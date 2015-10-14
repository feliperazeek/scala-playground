package algo

import org.scalatest._

class CountInversionsSpec extends FlatSpec with Matchers {
  "Count Inversions" should "return zero if the array is already sorted" in {
    val a1 = Array(1, 2, 4, 5, 6, 7, 8)
    CountInversions(a1) should be ((0, a1.sorted.toList))
  }

  "Count Inversions" should "return more than zero if not sorted" in {
    val a1 = Array(1, 4, 3, 1, 2)
    CountInversions(a1) should be ((5, a1.sorted.toList))
  }

  "Count Inversions" should "work on a bigger dataset" in {
    val arr = scala.io.Source.fromURL(getClass.getResource("/integers.txt")).getLines.toList.map(_.toInt).toArray
    CountInversions(arr) should be ((2407905288l, arr.sorted.toList))
  }
}