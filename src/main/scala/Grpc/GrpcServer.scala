//The GRPC execution is built on the following open source implementation https://github.com/xuwei-k/grpc-scala-sample
package Grpc

import HelperUtils.{CreateLogger, ObtainConfigReference}
import org.slf4j.Logger
import io.grpc.{Server, ServerBuilder}
import com.protobuff.proto.protoconfig.{GrpcServiceGrpc, logReply, logRequest}
import com.typesafe.config.Config
import scala.concurrent.{ExecutionContext, Future}

object GrpcServer {

  private val logger: Logger = CreateLogger(classOf[GrpcServer.type])
  val config: Config = ObtainConfigReference("GET") match {
    case Some(value) => value
    case None => throw new RuntimeException("Failed to retrieve reference to the config data.")
  }
  val port: Integer = Integer.valueOf(config.getString("GET.Port"))

  def main(args: Array[String]): Unit = {
    val server = new GrpcServer(ExecutionContext.global)
    server.start()
    server.blockUntilShutdown()
  }
}

class GrpcServer(executionContext: ExecutionContext) {
  self =>

  //Configuration code required to build GRPC server
  private[this] var server: Server = null
  private def start(): Unit = {
    server = ServerBuilder.forPort(GrpcServer.port).addService(GrpcServiceGrpc.bindService(new GrpcServiceImpl, executionContext)).build.start
    GrpcServer.logger.info("Server started on " + GrpcServer.port)
    sys.addShutdownHook {
      GrpcServer.logger.info("Shutting down gRPC server since JVM is shutting down")
      self.stop()
    }
  }

  private def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }

  private def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }

  private class GrpcServiceImpl extends GrpcServiceGrpc.GrpcService {

    val config: Config = ObtainConfigReference("GET") match {
      case Some(value) => value
      case None => throw new RuntimeException("Failed to retrieve reference to the config data.")
    }

    //Server to process the Request from client and send the reply
    // This server in turn sends request to AWS lambda and translates the response to the GRPC client
    override def grpcServer(req: logRequest) = {
      val t=req.t
      val dT=req.dT
      val URL: String = config.getString("GET.URL")
      try {
        val responseAWS = scala.io.Source.fromURL(URL + "?T=" + t + "&dT=" + dT)
        val result = responseAWS.mkString
        responseAWS.close()
        Future.successful(logReply(message = "Status 200:"+result))
      }
      catch {
        case e:Exception => Future.successful(logReply(message = "Status 404: No Messages Found"))
      }
    }
  }
}