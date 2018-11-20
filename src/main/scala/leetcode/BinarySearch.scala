package leetcode

/**
  * Binary Search
  *
  * https://leetcode.com/problems/binary-search
  */
object BinarySearch {

  def search(nums: Array[Int], target: Int): Int = {
    binarySearch(nums, target, 0, nums.size - 1)
  }

  @scala.annotation.tailrec
  def binarySearch(nums: Array[Int], target: Int, start: Int, end: Int): Int = {
    if (start > end) return -1

    val mid = (start + end) / 2
    val value = nums(mid)

    if (value == target) mid
    else if (value > target) binarySearch(nums, target, start, mid - 1)
    else binarySearch(nums, target, mid + 1, end)
  }

}
