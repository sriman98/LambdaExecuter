import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.util.ByteString
import com.typesafe.config.Config
import org.slf4j.Logger
import HelperUtils.CreateLogger
import HelperUtils.ObtainConfigReference
import scala.concurrent.Future
import scala.util.{Failure, Success}



object AkkaClient{

  val logger: Logger = CreateLogger(classOf[AkkaClient.type])
  val config: Config = ObtainConfigReference("GET") match {
    case Some(value) => value
    case None => throw new RuntimeException("Failed to retrieve reference to the config data.")
  }

  // get URL and parameters from config file
  val URL: String = config.getString("GET.URL")
  val T: String = config.getString("GET.T")
  val DT: String = config.getString("GET.DT")

  implicit val system: ActorSystem = ActorSystem()
  import system.dispatcher


  def get(): Unit = {
    //GET request to the Lambda URL with parameters
    val request = HttpRequest(
      method = HttpMethods.GET,
      uri = s"$URL?T=$T&dT=$DT"
    )

    //Get the response and process the response accordingly
    val responseFuture: Future[HttpResponse] = Http().singleRequest(request)
    responseFuture
      .onComplete {
        case Success(res) =>
          logger.info("Akka Client: Connected to AWS end point to process the Lambda")
          val HttpResponse(statusCodes, headers, entity, _) = res
          logger.info("Status Code: "+statusCodes.toString())
          entity.dataBytes.runFold(ByteString(""))(_ ++ _).foreach (body => logger.info(body.utf8String))
          system.terminate()
        case Failure(_) => sys.error("Error in execution of CLient")
      }
  }

  //Main function to run
  def main(args: Array[String]): Unit = get()
}
