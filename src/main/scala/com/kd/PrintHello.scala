package com.kd

object PrintHello {
  def say(): Unit ={
    println("ni hao!")
    val greetings : Array[String] = new Array[String](3);
    greetings(0) = "Hello"
    greetings(1) = ","
    greetings(2) = "World!\n"
    for (elem <- greetings) {println(elem)}
  }

  /**
   * for循环中的 yield 会把当前的元素记下来，保存在集合中，
   * 循环结束后将返回该集合。
   * Scala中for循环是有返回值的。
   * 如果被循环的是Map，返回的就是Map，
   * 被循环的是List，返回的就是List，以此类推。
   * @return
   */
  def forfunc(): List[Int] ={
     var intList = List(1,2,3,4)
    intList = intList ::: List(5,6,7)
    var int2 = for (
      i <- intList
      if (i % 2)==0
      )yield i

    int2

  }

  /**
   * 变量作用域
   * 在不同的作用域，可以定义完全相同名字的变量
   */
    def dparam(): Int ={
      val a = 1;
      {
        val a = 2
        println(a)
      }
      println(a)
      a

    }

  def main(args: Array[String]): Unit = {
    say()
    val test:HelloTest = new HelloTest()
    test.say()

    val a = forfunc()
    println(a)

    dparam()

  }
}
