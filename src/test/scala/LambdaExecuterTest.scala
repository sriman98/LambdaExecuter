import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import Grpc.GrpcServer.config

class LambdaExecuterTest extends AnyFlatSpec with Matchers{
  behavior of "Lambda Executer"

  it should "Check port" in {
    config.getInt("GET.port") should be (50051)
  }
  it should "Check URL" in {
    config.getString("GET.URL") should startWith("https://")
  }
  it should "check T" in {
    config.getString("GET.T").split(':')  should have length 3
  }
  it should "check DT" in {
    config.getString("GET.DT").split(':')  should have length 3
  }

  it should "check Lambda API" in {
    val T = config.getString("GET.T")
    val dT = config.getString("GET.DT")
    val responseAWS = scala.io.Source.fromURL(config.getString("GET.URL")+"?T="+T+"&dT="+dT)
    val response = responseAWS.mkString
    assert(!response.isEmpty)
  }

}