import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureWithError {

  def main(args: Array[String]): Unit = {
    println(Await.result(foo, 1 second))
  }

  def foo: Future[String] = for {
    x <- bar("1")
    y <- bar("a")
  } yield (x + y).toString

  def bar(s: String): Future[Int] = {
    Future(s.toInt)
  }
}
