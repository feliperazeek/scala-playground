package algo

import org.scalatest._

class SortSpec extends FlatSpec with Matchers {
  "QuickSort" should "return sorted array" in {
    val list = List(
      Array(8, 7, 1, 5, 3, 2, 4, 6),
      Array(8, 4, 5, 7, 6, 9, 2, 1, 3),
      Array(4, 7, 8, 3, 1, 2, 5, 6, 9),
      Array(1, 2, 3, 4, 5, 6, 7, 8),
      Array(4, 4, 4, 4, 4),
      Array[Int](),
      Array(1)
    )

    list.foreach { arr =>
      println("---------------------------------")
      QuickSort(arr).toList should be (arr.sorted.toList)
      println("---------------------------------")
    }
  }
}