package codility

object MinAvgTwoSlice {

  def solution(A: Array[Int]): Int = {
      (A.foldLeft[(Int, Option[Double], Int)]((0, None, -1)) { (t, item) =>
        val (index, min, results) = t

        val checkPair = index <= A.size - 2
        val checkTrio = index <= A.size - 3

        val pairMin = checkSlice(min, checkPair) { () => (A(index) + A(index + 1)) / 2.0 }
        val trioMin = checkSlice(min, checkTrio) { () => (A(index) + A(index + 1) + A(index + 2)) / 3.0 }

        if (pairMin.isDefined || trioMin.isDefined) (index + 1, Some(Math.min(pairMin.getOrElse(Double.MaxValue), trioMin.getOrElse(Double.MaxValue))), index)
        else (index + 1, min, results)
      })._3
  }

  def checkSlice(min: Option[Double], check: Boolean)(f: () => Double) = {
    check match {
      case true =>
        val value = f()
        min map { minValue =>
          if (value < minValue) Some(value)
          else None
        } getOrElse Some(value)

      case false =>
        None
    }
  }

}