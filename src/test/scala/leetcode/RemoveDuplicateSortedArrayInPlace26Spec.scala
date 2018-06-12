package leetcode

import org.scalatest.{FlatSpec, Matchers}

class RemoveDuplicateSortedArrayInPlace26Spec extends FlatSpec with Matchers {

  "RemoveDuplicateSortedArrayInPlace" should "return unique count" in {
    val obj = new RemoveDuplicateSortedArrayInPlace26

    test(Array(0,0,1,1,1,2,2,3,3,4))
    test(Array(1,1,2))
  }

  def test(arr: Array[Int]): Unit = {
    val obj = new RemoveDuplicateSortedArrayInPlace26
    val size = arr.distinct.size
    val expected = arr.clone().distinct.toArray
    obj.removeDuplicates(arr) should be (size)
    arr.slice(0, expected.size) should be (expected)
  }

}
