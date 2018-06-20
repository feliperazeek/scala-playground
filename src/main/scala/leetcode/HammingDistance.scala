package leetcode

/**
  * LeetCode Hamming Distance
  *
  * https://leetcode.com/problems/hamming-distance
  */
class HammingDistance {

  def hammingDistance(x: Int, y: Int): Int = {
    val goal = math.max(4, math.max(x.toBinaryString.size, y.toBinaryString.size))

    implicit class Filler(x: String) {
      def fillIfNeeded: String = {
        val missing = goal - x.size
        if (x.size < goal) ("0" * missing) + x
        else x
      }
    }

    val i1 = x.toBinaryString.fillIfNeeded
    val i2 = y.toBinaryString.fillIfNeeded

    i1.zip(i2)
      .filter { case (e1, e2) =>
        e1 != e2
      }
      .size
  }

}
