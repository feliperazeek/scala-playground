package leetcode

import org.scalatest.{FlatSpec, Matchers}

class BinarySearchSpec extends FlatSpec with Matchers {

  "Binary Search" should "return -1 when there's no match or return index when there's match" in {
    BinarySearch.search(Array(1, 2, 3, 4, 5), target = 8) shouldEqual -1
    BinarySearch.search(Array(-1,0,3,5,9,12), target = 9) shouldEqual 4
    BinarySearch.search(Array(-1,0,3,5,9,12), target = 9) shouldEqual 4
  }

}
