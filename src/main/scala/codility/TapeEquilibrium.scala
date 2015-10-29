package codility

import scala.math.{min, abs}

object TapeEquilibrium {

  def solution(A: Array[Int]): Int = {
    if (A.size < 2 || A.size > 100000) sys.error(s"Invalid input - array size: ${A.size}")

    val total = A.map(_.toLong).sum

    (A.foldLeft[(Int, Long, Long)](-1, -1, 0l) { (t, i) =>
      if (i < -1000 || i > 1000) sys.error(s"Invalid array element: $i")

      val (x, currentMin, lastLeftSum) = t
      val index = x + 1

      (index + 1 == A.size) match {
        case true =>
          // Do nothing on the last element
          t

        case false =>
          val leftSum = lastLeftSum.toLong + A(index).toLong
          val rightSum = total - leftSum

          val thisMin = abs(leftSum- rightSum)
          val results = if (currentMin == -1) thisMin
          else min(currentMin, thisMin)

          (index, results, leftSum)
      }

    })._2.toInt
  }

}