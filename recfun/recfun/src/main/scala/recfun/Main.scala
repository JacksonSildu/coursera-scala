package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {

    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("Count Change")
    println(countChange(4, List(1, 2)))

    println("Balance")
    println(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    if (c < 0 || c > r) {
      0
    } else if (c == 0 && r == 0) {
      1
    } else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

    //   (defn bc [rr cc]
    //		(loop [r rr c cc acc 1]
    //			(if (or (= c 0) (= r 0) (= r c))
    //			acc
    //			(recur (dec r) (dec c) (/ (* acc r) c)))
    //		)
    //	)	
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    @tailrec def balancing(numbersOpen: Int, chars: List[Char]): Boolean = {
      val head = chars.head

      val newNumbersOpens = if (head == '(') {
        numbersOpen + 1
      } else if (head == ')') {
        numbersOpen - 1
      } else {
        numbersOpen
      }

      if (newNumbersOpens < 0 || (chars.tail.isEmpty && newNumbersOpens > 0)) {
        false
      } else if (chars.tail.isEmpty && newNumbersOpens == 0) {
        true
      } else {
        balancing(newNumbersOpens, chars.tail)
      }
    }

    val balance = if (Option(chars) == None || chars.isEmpty) {
      true
    } else {
      balancing(0, chars)
    }

    balance

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(money: Int, coins: List[Int], accumulator: Int): Int = {
      if (money == 0) {
        accumulator + 1
      } else if (money < 0 || coins.isEmpty) {
        accumulator
      } else {
        change(money - coins.head, coins, accumulator) + change(money, coins.tail, accumulator)
      }
    }

    change(money, coins, 0)
  }
}
