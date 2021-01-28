package com.kd

import java.util.concurrent.ConcurrentSkipListMap

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

  /**
   * ConcurrentSkipListMap试用
   *
   * @param position
   * @return
   */
  def getFloorItem(position: Int): Int = {
    val segments = new ConcurrentSkipListMap[Int, Int]();
    segments.put(0, 100);
    segments.put(100, 100);
    segments.put(200, 200);
    segments.put(400, 100);
    segments.floorKey(position)

  }


  /**
   * 显示函数的各种lambda表达形式
   */
  def funLambda(): Unit = {
    def foo(s: String) = {
      println(s)
    }

    foo("你好!")

    def hf(f: String => Unit) = f("higher")

    hf(foo)

    val f: String => Unit = foo
    f("zaijian")

    val f2: Function1[String, Unit] = foo
    f2("f2 zaijian")

    hf(f)

    //开始lambda形式
    println("----------lambda-------------------")
    //第1个版本省略了s的类型，这是因为在定义hf时已经声明了参数类型为String=>Unit，编译器会把lambda表达式中的入参和出参按声明的类型来对待。
    hf(s => println(s))
    //第2个版本则是采用了占位符的方式。它的形式为，对于所有的 x=>g(x) 都可以用占位符的形式写为：g(_)，相当于省去了lambda表达式的入参和箭头部分，然后用占位符表示入参。
    hf(println(_))
    //第3个版本和第2个版本都是部分应用函数(partial applied function)的写法，当只有一个参数时，这两个写法是等价的。
    hf(println _)
    //第4个版本的背后其实是编译器支持lambda的“eta转换”
    //简单的说就是对于lambda表达式中只有一个参数，并且箭头右边的逻辑是对入参执行一个函数：即 x => f(x)
    //则可以简写为f
    hf(println)
  }

  //match匹配
  def matchFun(a: Int): Unit = {
    println("----into matchFun----------")
    var matchVar = a match {
      case 1 => 101
      case 2 => 102
      case 3 => 103
      case _ => 100
    }
    println(matchVar)
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


    val positon = 125
    println("floor[" + positon + "] = " + getFloorItem(positon))

    //lambda
    println("--------run funLambda-------------")
    funLambda()


    //match
    matchFun(2)

  }


}
