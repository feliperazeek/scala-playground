package leetcode

import org.scalatest.{FlatSpec, Matchers}

class SearchInsertPositionSpec extends FlatSpec with Matchers {

  "Search Insert Position" should "do the right thing" in {
    val obj = SearchInsertPosition

    obj.searchInsert(Array(1,3,5,6), 5) should be (2)
    obj.searchInsert(Array(1,3,5,6), 2) should be (1)
    obj.searchInsert(Array(1,3,5,6), 7) should be (4)
    obj.searchInsert(Array(1,3,5,6), 0) should be (0)
    obj.searchInsert(Array(), 0) should be (-1)
  }

}
