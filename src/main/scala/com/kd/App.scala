package com.kd

/**
 * Hello world!
 *
 */
object App {
  def main(args: Array[String]): Unit = {
  println( "Hello World!" )


    val it = Iterator("Baidu", "Google", "Runoob", "Taobao")

    while (it.hasNext) {
      println(it.next())
    }


    var arr = for (i <- 1 to 10) yield {
      i
    }
    println(arr)
    //    val v:Vector =

  }
}
