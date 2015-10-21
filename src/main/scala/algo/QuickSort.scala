package algo

import scala.math
import Ordering.Implicits._
import Numeric.Implicits._

object QuickSort {

  // FIXME Those arr.toList are a performance killer but they make my life easier right now
  private[this] val logger = org.log4s.getLogger

  private[this] def sort[T : Numeric](arr: Array[T], low: Int, high: Int)(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    (high <= low) match {
      case true =>
        arr

      case false =>
        logger.debug(s"**** Sort - Array: ${arr.toList}, From ${arr(low)} to ${arr(high)} ****")

        // Partition the array
        val j = partition(arr, low, high, low)
        logger.debug(s"** Partition Result: $j - Array: ${arr.toList} **")
        logger.debug("")

        // Sort Partitions
        sort(arr, low, j - 1)
        sort(arr, j + 1, high)
    }
  }

  @scala.annotation.tailrec
  private[this] def partition[T : Numeric](arr: Array[T], i: Int, j: Int, p: Int)(implicit c: scala.reflect.ClassTag[T]): Int = {
    val pivot = arr(p)

    logger.debug(s"-- Partition - Array: ${arr.toList}, From ${arr(i)} to ${arr(j)}, Pivot: $pivot --")

    @scala.annotation.tailrec
    def left(x: Int): Option[Int] = {
      if (x >= j) {
        // Didn't find anything bigger than the pivot to be sent to the right side
        logger.debug("Left - found nothing!")
        None

      } else if (arr(x) >= pivot) {
        // Found an element bigger than the pivot
        logger.debug(s"Left - ${arr(x)} is bigger or equal than pivot $pivot")
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
        logger.debug("Right - found nothing!")
        None

      } else if (arr(x) <= pivot) {
        // Found an element that's smaller than the pivot
        logger.debug(s"Right - ${arr(x)} is smaller or equal than pivot $pivot")
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
    logger.debug(s"Exchange - $left for $right")
  }

  def apply[T : Numeric](arr: Array[T], randomize: Boolean = false)(implicit c: scala.reflect.ClassTag[T]): Array[T] = {
    arr.size match {
      case x if x <= 1 =>
        arr

      case _ =>
        val input = if (randomize) util.Random.shuffle(arr.toSeq).toArray
        else arr

        logger.debug(s"Input: ${input.toList}")

        sort[T](input, 0, arr.size - 1)
    }
  }

}