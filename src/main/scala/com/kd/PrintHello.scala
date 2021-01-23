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

  /**
   * 占位符的测试函数
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  def f(a: Int, b: Int, c: Int): Int = a + b + c

  /**
   * 数组生成函数
   *
   * @param a
   * @return
   */
  def arrayGenerate(a: Int): Array[Int] = {
    var arr: Array[Int] = new Array[Int](a)

    if (a < 1) return arr

    for (i <- 0 to a - 1) arr(i) = i

    arr
  }







  def main(args: Array[String]): Unit = {
    say()
    val test: HelloTest = new HelloTest(1)
    test.say()

    val a = forfunc()
    println(a)

    dparam()

    val fo = f _ //占位符，代表f的所有参数
    println(fo(1, 2, 3))

    println("-----print array-------占位符替代-------begin-----------")
    val arr = arrayGenerate(10)
    arr.foreach(println _)
    val list = List(arr).forall(x => x.length > 0)
    println(list);
    println("-----print array-------占位符替代------- end -----------")

  }
}
