package algo

import scala.math
import Ordering.Implicits._
import Numeric.Implicits._

object QuickSort {

  private[this] val LogEnabled = false

  // TODO obviously that log() function is not the best way to do logging
  // and those arr.toList are a performance killer but they are make my life easier for right now

  private[this] def sort[T : Numeric](arr: Array[T], low: Int, high: Int)(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    (high <= low) match {
      case true =>
        arr

      case false =>
        if (LogEnabled) log(s"**** Sort - Array: ${arr.toList}, From ${arr(low)} to ${arr(high)} ****")

        // Partition the array
        val j = partition(arr, low, high, low)
        if (LogEnabled) log(s"** Partition Result: $j - Array: ${arr.toList} **")
        if (LogEnabled) log("")

        // Sort Partitions
        sort(arr, low, j - 1)
        sort(arr, j + 1, high)
    }
  }

  @scala.annotation.tailrec
  private[this] def partition[T : Numeric](arr: Array[T], i: Int, j: Int, p: Int)(implicit c: scala.reflect.ClassTag[T]): Int = {
    val pivot = arr(p)

    if (LogEnabled) log(s"-- Partition - Array: ${arr.toList}, From ${arr(i)} to ${arr(j)}, Pivot: $pivot --")

    @scala.annotation.tailrec
    def left(x: Int): Option[Int] = {
      if (x >= j) {
        // Didn't find anything bigger than the pivot to be sent to the right side
        if (LogEnabled) log("Left - found nothing!")
        None

      } else if (arr(x) >= pivot) {
        // Found an element bigger than the pivot
        if (LogEnabled) log(s"Left - ${arr(x)} is bigger or equal than pivot $pivot")
        Some(x)

      } else {
        // This is already smaller than the pivot so keep looking
        left(x + 1)
      }
    }

    @scala.annotation.tailrec
    def right(x: Int): Option[Int] = {
      if (x <= i) {
        // Didn't find anything smaller than the pivot to be sent to the left side
        if (LogEnabled) log("Right - found nothing!")
        None

      } else if (arr(x) <= pivot) {
        // Found an element that's smaller than the pivot
        if (LogEnabled) log(s"Right - ${arr(x)} is smaller or equal than pivot $pivot")
        Some(x)

      } else {
        // This is already bigger than the pivot so keep looking
        right(x - 1)
      }
    }

    (left(i + 1), right(j)) match {
      case (Some(ll), Some(rr)) =>
        if (ll < rr) exchange(arr, ll, rr)
        partition(arr, ll, rr, p)
      case (None, Some(rr)) =>
        exchange(arr, p, rr)
        rr
      case (Some(ll), None) =>
        exchange(arr, p, i)
        ll - 1

      case _ =>
        exchange(arr, p, i)
        i
    }
  }



  private[this] def exchange[T : Numeric](arr: Array[T], i: Int, j: Int)(implicit c: scala.reflect.ClassTag[T]): Unit = {
    val (left, right) = (arr(i), arr(j))
    arr(j) = left
    arr(i) = right
    if (LogEnabled) log(s"Exchange - $left for $right")
  }

  private[this] def log(msg: String): Unit = if (LogEnabled) println(msg)

  def apply[T : Numeric](arr: Array[T], randomize: Boolean = false)(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    arr.size match {
      case x if x <= 1 =>
        arr

      case _ =>
        val input = if (randomize) util.Random.shuffle(arr.toSeq).toArray
        else arr

        if (LogEnabled) log(s"Input: ${input.toList}")

        sort[T](input, 0, arr.size - 1)
    }
  }

}