package leetcode

import org.scalatest.{FlatSpec, Matchers}

class RomanToInteger13Spec extends FlatSpec with Matchers {

  "Roman to Integer" should "do the right thing" in {
    val obj = new RomanToInteger13

    obj.romanToInt("III") should be (3)
    obj.romanToInt("IV") should be (4)
    obj.romanToInt("IX") should be (9)
    obj.romanToInt("LVIII") should be (58)
    obj.romanToInt("MCMXCIV") should be (1994)
  }

}
