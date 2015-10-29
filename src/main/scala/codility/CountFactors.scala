package codility

object CountFactors {
    def solution(N: Int): Int = {
      if (N < 1) sys.error(s"Invalid input: $N")

      @scala.annotation.tailrec
      def foo(i: Int, total: Int): (Int, Int) = {
        if ((i * i) >= N) (total, i)
        else if (N % i == 0) foo(i + 1, total + 2)
        else foo(i + 1, total)
      }

      val (results, x) = foo( 1, total = 0)

      if (x * x == N) results + 1
      else results
    }
}