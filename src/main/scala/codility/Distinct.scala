package codility

object Distinct {

  def solution(A: Array[Int]): Int = {
      val positive = new java.util.BitSet()
      val negative = new java.util.BitSet()

      A.foldLeft(0) { (current, i) =>
          val duplicate = if (i < 0) (negative get i * -1)
          else (positive get i)

          duplicate match {
              case true =>
                  current

              case false =>
                  if (i >= 0) positive set i
                  else negative set i * -1

                  current + 1
          }
      }
  }

}