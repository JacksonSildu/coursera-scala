package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)

  val r = union(s1,s2)
  val s = union(r, s3)
  println (contains(s, 1))
  println (contains(s, 2))
  println (contains(s, 3))
}
