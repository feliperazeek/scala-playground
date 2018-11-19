package interviewcamp.week1

object DutchNationalFlag {

  def sortColors(nums: Array[Int]): Array[Int] = {
    var low = 0
    var mid = 0
    var high = nums.length - 1

    def swap(i1: Int, i2: Int) = {
      val value1 = nums(i1)
      val value2 = nums(i2)

      nums(i1) = value2
      nums(i2) = value1
    }

    while (mid <= high) {
      val value = nums(mid)

      value match {
        case 0 =>
          swap(low, mid)
          low = low + 1
          mid = mid + 1

        case 1 =>
          mid = mid + 1

        case 2 =>
          swap(mid, high)
          high = high - 1
      }
    }

    nums
  }
}