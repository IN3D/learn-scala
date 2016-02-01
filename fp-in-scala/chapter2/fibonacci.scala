def fibonacci(n: Int): Int = {
  @annotation.tailrec
  def go(i: Int, curr: Int, prev: Int): Int = {
    if(n == 0 || n == 1) n
    else if(i == n) curr
    else go((i + 1), (curr + prev), curr)
  }
  go(1, 1, 0)
}

// Test
(fibonacci(0) == 0)
(fibonacci(1) == 1)
(fibonacci(2) == 1)
(fibonacci(3) == 2)
(fibonacci(4) == 3)
(fibonacci(5) == 5)
(fibonacci(6) == 8)
(fibonacci(7) == 13)
