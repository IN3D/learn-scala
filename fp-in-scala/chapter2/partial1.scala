def partial1[A,B,C](a: A, f: (A, B) => C): B => C = (x: B) => f(a, x)

// Test
val ret = partial1[Int, Int, Double](1, (x, y) => x.toDouble + y.toDouble)
(ret(2) == 3.0)

/**
 * Use Case:
 * To do part of your computation up front, and pass the function on somewhere
 * else to be resolved at a later time. This could be useful if you will recieve
 * your values to be computed at two different times.
 */
