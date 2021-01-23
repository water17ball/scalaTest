package com.kd


class HelloTest(x: Int, y: String) {
  var value = x
  var name = y
  println(s"-----[HelloTest Construction]----HelloTest created!") //包含在构造函数中
  println(s"-----[HelloTest Construction]----value=${value}") //包含在构造函数中
  println(s"-----[HelloTest Construction]----name=${name}") //包含在构造函数中
  def this(x: Int) = this(x, "default")

  def say(): Unit ={
    println("hello")
  }

  def main(args: Array[String]): Unit = {
    say()
  }
}
