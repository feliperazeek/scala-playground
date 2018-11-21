package leetcode

import org.scalatest.{FlatSpec, Matchers}

class ProductOfArrayExceptSelfSpec extends FlatSpec with Matchers {

  "ProductOfArrayExceptSelf" should "do the right thing" in {
    ProductOfArrayExceptSelf.productExceptSelf(Array(1,2,3,4)) shouldEqual Array(24,12,8,6)
  }

}

