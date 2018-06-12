package leetcode

class RemoveDuplicateSortedArrayInPlace26 {

  def removeDuplicates(nums: Array[Int]): Int = {
    val default: Option[Int] = None

    nums.foldLeft((default, 0)) { case ((maybeLast, total), item) =>
      val newIndex = total

      val newTotal = maybeLast match {
        case Some(last) =>
          if (last == item) total
          else total + 1
        case _ =>
          total + 1
      }

      val newLast = Some(item)

      if (newLast != maybeLast) nums(newIndex) = item

      (newLast, newTotal)

    }._2
  }

}
