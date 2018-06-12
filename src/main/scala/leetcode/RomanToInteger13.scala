package leetcode

class RomanToInteger13 {

  val values = Map(
    'I' -> 1,
    'V' -> 5,
    'X' -> 10,
    'L' -> 50,
    'C' -> 100,
    'D' -> 500,
    'M' -> 1000
  )

  val behindOptions = Map(
    'I' -> Seq('V', 'X'),
    'X' -> Seq('L', 'C'),
    'C' -> Seq('D', 'M')
  )

  def romanToInt(s: String): Int = {
    val list = s.toUpperCase.toCharArray
    list.toList.zipWithIndex.foldLeft(0) { case (current, i) =>
      val (roman, index) = i

      val romanValue = values
        .get(roman)
        .getOrElse(sys.error(s"No idea what this char is: $roman"))

      val value = if (index < s.length - 1) {
        val nextChar = list(index + 1)
        val possibles = behindOptions.get(roman).getOrElse(Nil)
        val isValid = possibles.contains(nextChar)
        if (isValid) romanValue * -1
        else romanValue

      } else romanValue

      value + current
    }
  }
}
