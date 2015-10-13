package algo

import org.scalatest._

class CountInversionsSpec extends FlatSpec with Matchers {
  "Count Inversions" should "return zero if the array is already sorted" in {
    CountInversions(Array(1, 2, 4, 5, 6, 7, 8)) should be (0)
  }

  "Count Inversions" should "foo" in {
    val arr = scala.io.Source.fromURL(getClass.getResource("/integers.txt")).getLines.toList.map(_.toInt).toArray
    CountInversions(arr) should be (0)
  }
}