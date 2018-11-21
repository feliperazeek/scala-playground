package leetcode

object ProductOfArrayExceptSelf {

  // TODO improve brute force by calculating everything in the left and than the right
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    if (nums.isEmpty) Array.empty
    else {
      nums.zipWithIndex.map { i =>
        val index = i._2

        nums.zipWithIndex.foldLeft(1) { case (current, (num2, index2)) =>
          val product2 = if (index2 == index) 1 else num2

          current * product2
        }
      }
    }
  }

}
