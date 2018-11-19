package interviewcamp.week1

import org.scalatest._


class DutchNationalFlagSpec extends FlatSpec with Matchers {
  "DutchNationalFlag" should "sort array 0s first, than 1s than 2s" in {
    DutchNationalFlag.sortColors(Array(0, 1, 2, 0, 1, 2)) should be (Array(0, 0, 1, 1, 2, 2))
    DutchNationalFlag.sortColors(Array(0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1)) should be (Array(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2))
  }
}
