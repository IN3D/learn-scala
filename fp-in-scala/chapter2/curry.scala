def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
  (x: A) => (y: B) => f(x, y)
}

// Test
val res = curry[Int, Int, Int]((x, y) => x + y)
val res2 = res(2)
(res2(2) == 4)

val thing = curry[Int, Int, Int]((x, y) => x + y)(2)
val resOfThing = thing(4)
(resOfThing == 6)
