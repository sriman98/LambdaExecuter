package HelperUtils

import com.typesafe.config.{Config, ConfigFactory}
import java.util.logging.Logger
import scala.util.{Failure, Success, Try}

// Config reference object to retrieve user inputs from the application.conf file
class ObtainConfigReference
object ObtainConfigReference {
  private val config = ConfigFactory.load()

  private val logger = Logger.getLogger(classOf[ObtainConfigReference.type ].getName)
  private def ValidateConfig(confEntry: String):Boolean = Try(config.getConfig(confEntry)) match {
    case Failure(exception) => logger.info(s"Failed to retrieve config entry $confEntry for reason $exception"); false
    case Success(_) => true
  }

  def apply(confEntry:String): Option[Config] = if (ValidateConfig(confEntry)){Some(config)}
  else {None}
}