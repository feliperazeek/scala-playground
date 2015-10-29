package codility

object TreeHeight {

  case class Tree(value: Int, l: Tree, r: Tree)

  def solution(T: Tree): Int = {
    def height(t: Tree, i: Int): Int = {
      val left = (Option(t.l).map(height(_, i + 1)) getOrElse i)
      val right = (Option(t.r).map(height(_, i + 1)) getOrElse i)

      scala.math.max(i, scala.math.max(left, right))
    }

    height(T, 0)
  }

}