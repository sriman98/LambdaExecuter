//The GRPC execution is built on the following open source implementation https://github.com/xuwei-k/grpc-scala-sample
package Grpc

import HelperUtils.{CreateLogger, ObtainConfigReference}
import com.typesafe.config.Config
import org.slf4j.Logger
import java.util.concurrent.TimeUnit
import com.protobuff.proto.protoconfig.{GrpcServiceGrpc, logRequest}
import com.protobuff.proto.protoconfig.GrpcServiceGrpc.GrpcServiceBlockingStub
import io.grpc.{ManagedChannel, ManagedChannelBuilder, StatusRuntimeException}

object GrpcClient {
  val logger: Logger = CreateLogger(classOf[GrpcClient.type])
  val config: Config = ObtainConfigReference("GET") match {
    case Some(value) => value
    case None => throw new RuntimeException("Failed to retrieve reference to the config data.")
  }
  val port: Integer = Integer.valueOf(config.getString("GET.Port"))

  //Configuration required to build the GRPC client
  def apply(host: String, port: Int): GrpcClient = {
    val channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build
    val blockingStub = GrpcServiceGrpc.blockingStub(channel)
    new GrpcClient(channel, blockingStub)
  }

  //Main method to get the parameters from Config and execute the Client program
  def main(args: Array[String]): Unit = {
    val client = GrpcClient("localhost", port)
    try {
      val t: String= config.getString("GET.T")
      val dT: String= config.getString("GET.DT")
      client.response(t,dT)
    } finally {
      client.shutdown()
    }
  }
}

class GrpcClient private( private val channel: ManagedChannel, private val blockingStub:GrpcServiceBlockingStub) {

  def shutdown(): Unit = {
    channel.shutdown.awaitTermination(5, TimeUnit.SECONDS)
  }

  //Response method to send the request and process the response received
  def response(t: String,dT: String): Unit = {
    val request = logRequest(t,dT)
    try {
      val response = blockingStub.grpcServer(request)
      GrpcClient.logger.info(response.message)
    }
    catch {
      case e: StatusRuntimeException =>
        GrpcClient.logger.info("RPC failed: {0}"+ e.getStatus)
    }
  }
}
