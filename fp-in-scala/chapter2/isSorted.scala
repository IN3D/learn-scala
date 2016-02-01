def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
  @annotation.tailrec
  def go(curr: Int, next: Int, len: Int): Boolean = {
    if(!gt(as(curr), as(next))) false
    else if(next == len) true
    else go(next, next + 1, len)
  }
  go(0, 1, as.length - 1)
}

isSorted[Int](Array(1,2,3), (x,y) => x < y)
