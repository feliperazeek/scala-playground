package codility

object OddOccurrencesInArray {

  def solution(A: Array[Int]): Int = {
    val N = A.size

    if (N < 1 || N > 1000000) sys.error(s"Invalid array size: $N")

    A.foldLeft(0) { (current, i) =>
      i ^ current
    }
  }
}