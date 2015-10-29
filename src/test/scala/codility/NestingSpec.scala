package codility

import org.scalatest._

class NestingSpec extends FlatSpec with Matchers {
  "Nesting" should "return 1 if string is properly nested and return 0 if it's not properly nested" in {
    Nesting.solution("(()(())())") should be (1)
    Nesting.solution("())") should be (0)
  }
}