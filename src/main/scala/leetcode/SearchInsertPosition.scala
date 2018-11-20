package leetcode

object SearchInsertPosition {

  def searchInsert(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) return -1

    (0 to nums.size - 1).foreach { i =>
      val num = nums(i)
      if (num >= target) return i
    }

    return nums.size
  }
}
