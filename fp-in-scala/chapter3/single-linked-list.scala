package fpinscala.datastructures

sealed trait List[+A]

case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => List()
    case Cons(x, xs) => xs
  }

  // this is what allows List to be used like: List(1,2,3,4) or List("hi", "bye")
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}


val x = List(1,2,3,4,5) match {
  case Cons(x, Cons(2, Cons(4, _))) => x // This will not match, because this pattern expects a 4 after 2
  case Nil => 42 // This will not match, the provided list isn't nil
  case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // this is the match, see below
  case Cons(h, t) => h + List.sum(t) // this will not match becase a match was already found
  case _ => 101 // this will not match because a match was already found
}

/*
 * x matches where it does, because the first two values are variables, they could be anything, and are
 * effectively wildcards to the match. then 3 and 4 are expected to follow, followed by '_' so that anything
 * could come after. 5 happens to, though it is effectively ignored
 */
(x == 3) // true

val thing = List.product(List(1.0, 2.0, 3.0))


val subList = List.tail[Int](List(1,2,3))
(subList == List(2,3))
