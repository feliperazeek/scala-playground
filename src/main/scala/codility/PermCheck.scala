package codility

import java.util.BitSet

object PermCheck {

  def solution(A: Array[Int]): Int = {
      val bitz = new BitSet(A.size + 1)

      val good = A.foldLeft(true)((current, i) =>
          if (current) {
              (i, bitz.get(i)) match {
                  case (x, _) if x > A.size =>
                      false

                  case (x, _) if x < 1 || x > 1000000000 =>
                      false

                  case (0, _) =>
                      false

                  case (_, true) =>
                      false

                  case _ =>
                      bitz.set(i)
                      true
              }

          } else false
      )

      if (good && A.size > 0 && A.size <= 100000) 1
      else 0
  }

}