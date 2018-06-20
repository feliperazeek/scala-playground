package leetcode

import org.scalatest.{FlatSpec, Matchers}

/**
  * LeetCode Hamming Distance
  *
  * https://leetcode.com/problems/hamming-distance
  */
class HammingDistanceSpec extends FlatSpec with Matchers {

  "Hamming Distance" should "return the number of bits that differ between two integers" in {
    test(x = 4, y = 2)(expected = 2)
    test(x = 1, y = 4)(expected = 2)
    test(x = 4, y = 5)(expected = 1)
    test(x = 0, y = 0)(expected = 0)
    test(x = 1, y = 1)(expected = 0)
    test(x = 680142203, y = 1111953568)(expected = 19)
  }

  def test(x: Int, y: Int)(expected: Int): Unit = {
    val obj = new HammingDistance
    val diff = obj.hammingDistance(x, y)
    diff should be (expected)
  }

}
