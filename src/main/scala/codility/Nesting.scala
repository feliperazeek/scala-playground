package codility

object Nesting {

  def solution(S: String): Int = {
    val results = S.foldLeft(0) { (total, chr) =>
      if (total < 0) total
      else {
        chr match {
          case '(' => total + 1
          case ')' => total - 1
          case _ => total
        }
      }
    }

    if (results == 0) 1
    else 0
  }

}