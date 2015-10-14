package algo

import scala.math
import Ordering.Implicits._
import Numeric.Implicits._

object CountInversions {

  private[this] def inversions[T : Numeric](arr: Array[T], low: Int, high: Int, count: Long, sorted: Array[T])(implicit c: scala.reflect.ClassTag[T]): (Long, Array[T]) = {
    val diff = (high - low) + 1
    val med = (high + low) / 2
    diff match {
      case x if x <= 1 =>
        (0, Array[T](arr(low)))

      case 2 =>
        val i1 = arr(low)
        val i2 = arr(high)
        if (i1 > i2) (1, Array(i2, i1))
        else (0, Array(i1, i2))

      case _ =>
        val (leftCount, leftArray) = inversions(arr, low, med, count, sorted)
        val (rightCount, rightArray) = inversions(arr, med + 1, high, count, sorted)

        merge(leftArray, rightArray, leftCount + rightCount, sorted)
    }
  }

  @scala.annotation.tailrec
  private[this] def merge[T : Numeric](l: Array[T], r: Array[T], count: Long, sorted: Array[T])(implicit c: scala.reflect.ClassTag[T]): (Long, Array[T]) = {
    (l, r) match {
      case (Array(), _) =>
        (count, sorted ++ r)

      case (_, Array()) =>
        (count, sorted ++ l)

      case _ =>
        val l1 = l.head
        val r1 = r.head
        val ls = l slice (1, l.size)
        val rs = r slice (1, r.size)

        (l1 <= r1) match {
          case true =>
            merge(ls, r, count, sorted ++ Array[T](l1))

          case false =>
            merge(l, rs, l.size + count, sorted ++ Array[T](r1))
        }
    }
  }

  def apply[T : Numeric](arr: Array[T])(implicit c: scala.reflect.ClassTag[T]): (Long, List[T]) = {
    val (count, items) = inversions[T](arr, 0, arr.length - 1, 0l, Array[T]())
    (count, items.toList)
  }

}