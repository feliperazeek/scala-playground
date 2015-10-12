package algo

import scala.math
import Ordering.Implicits._
import Numeric.Implicits._

object CountInversions {

  private[this] def inversions[T : Numeric](arr: Array[T])(implicit c: scala.reflect.ClassTag[T]): (Int, Array[T]) = {
    arr.size match {
      case x if x <= 1 =>
        (0, arr)

      case 2 =>
        if (arr.head > arr.last) (1, Array(arr.min, arr.max))
        else (0, Array(arr.min, arr.max))

      case _ =>
        val med = arr.size / 2
        val (leftCount, leftArray) = inversions(arr.slice(0, med))
        val (rightCount, rightArray) = inversions(arr.slice(med, arr.size))
        val (mergedCount, mergedArray) = merge(leftArray, rightArray)

        (leftCount + rightCount + mergedCount, mergedArray)
    }
  }

  private[this] def merge[T : Numeric](l: Array[T], r: Array[T], count: Int = 0)(implicit c: scala.reflect.ClassTag[T]): (Int, Array[T]) = {
    (l, r) match {
      case (Array(), _) => (count, r)
      case (_, Array()) => (count, l)
      case _ =>
        val l1 = l.head
        val r1 = r.head
        val ls = l slice (1, l.size)
        val rs = r slice (1, r.size)

        (l1 <= r1) match {
          case true =>
            val (leftCount, mergedArray) = merge(ls, r, count)
            (leftCount + count, Array[T](l1) ++ mergedArray)

          case false =>
            val (rightCount, mergedArray) = merge(l, rs, count)
            (l.size + rightCount + count, Array[T](r1) ++ mergedArray)
        }
    }
  }

  def apply[T : Numeric](arr: Array[T])(implicit c: scala.reflect.ClassTag[T]): Int = {
    inversions[T](arr)._1
  }

  def test[T : Numeric](arr: Array[T], expected: Int)(implicit c: scala.reflect.ClassTag[T]): Unit = {
    val output = apply(arr)
    (output == expected) match {
      case true => println(s"OK: ${arr.toList}, Output: $output, Expected: $expected")
      case false => println(s"FAILED - Input: ${arr.toList}, Output: $output, Expected: $expected")
    }
  }

  def main(args: Array[String]): Unit = {
    List(
      (Array(1, 4, 3, 1, 2), 5)
    ) foreach { case (list, expected) =>
      test[Int](list, expected)
    }
  }

}