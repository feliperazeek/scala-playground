package codility

object StrSymmetryPoint {

  def solution(S: String): Int = {
    val max = S.length / 2

    @scala.annotation.tailrec
    def symmetryPoint(i: Int): Int = {
      val left = S(i)
      val right = S(S.length - 1 - i)

      if (left == right && i == max) i
      else if (left == right && i < max) symmetryPoint(i + 1)
      else i - 1
    }

    if (S.length < 1 || S.length > 2000000 || S.length % 2 != 1) -1
    else symmetryPoint(i = 0)
  }

  def main(args: Array[String]) = {
    println("X: " + solution("racecar"))
    println("X: " + solution("aaaaaaa"))
    println("X: " + solution("0"))
    println("X: " + solution(""))
  }

}