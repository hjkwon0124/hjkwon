package step5

/**
 * Created by hjkwon on 15. 5. 22.
 */
sealed trait Stream[+A]
{
  def headOption[A] = this match
  {
    case Empty => None
    case Cons(h,t) => Some(h())
  }
}
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]


object Stream {
  def cons[A](hd: => A, tl: => Stream[A]):Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons( () => head, () => tail )
  }

  def empty[A]:Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty else cons(as.head,apply(as.tail: _*))



}