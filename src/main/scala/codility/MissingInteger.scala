package codility

object MissingInteger {

  def solution(A: Array[Int]): Int = {
    val bitz = new java.util.BitSet(A.size)

    val n = A.foldLeft(0) { (total, i) =>
      if (i > 0 && i <= A.size && !bitz.get(i)) {
        bitz.set(i)
        total + 1
      } else total
    }

    val possibilities = if (n < 1) 1
    else n

    (1 to possibilities).foldLeft(possibilities + 1) { (current, i) =>
      bitz.get(i) match {
        case true =>
          current
        case false =>
          return i
      }
    }
  }

}