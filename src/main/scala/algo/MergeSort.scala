package algo

import scala.math
import Ordering.Implicits._
import Numeric.Implicits._

object MergeSort {

  private[this] def mergeSort[T : Numeric](arr: Array[T])(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    arr.size match {
      case x if x <= 1 =>
        arr

      case 2 =>
        Array[T](arr.min, arr.max)

      case _ =>
        val med = arr.size / 2
        val l = mergeSort(arr.slice(0, med))
        val r = mergeSort(arr.slice(med, arr.size))

        merge(l, r)
    }
  }

  private[this] def merge[T : Numeric](l: Array[T], r: Array[T])(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    (l, r) match {
      case (Array(), _) => r
      case (_, Array()) => l
      case _ =>
        val l1 = l.head
        val r1 = r.head
        val ls = l slice (1, l.size)
        val rs = r slice (1, r.size)

        if (l1 < r1)  Array[T](l1) ++ merge(ls, r)
        else Array[T](r1) ++ merge(l, rs)
    }
  }

  def apply[T : Numeric](arr: Array[T])(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    mergeSort[T](arr)
  }

  def test[T : Numeric](arr: Array[T])(implicit c: scala.reflect.ClassTag[T]): Unit = {
    val expected = arr.sorted.toList
    val output = apply(arr).toList
    (output == expected) match {
      case true => println(s"OK: ${arr.toList}")
      case false => println(s"FAILED - Input: ${arr.toList}, Output: $output, Expected: $expected")
    }
  }

  def main(args: Array[String]): Unit = {
    List(
      Array(1, 4, 50, 20, 10)
    ) foreach test[Int]
  }

}