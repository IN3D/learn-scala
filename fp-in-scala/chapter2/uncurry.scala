def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
  (x: A, y: B) => f(x)(y)
}

// Test
val res = uncurry[Int, Int, Int]((x) => (y) => x + y)
(res(2, 2) == 4)
