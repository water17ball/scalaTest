package com.kd

/**
 * 打印九九乘法表
 * 目的：
 * 1）练习case class
 * 2）熟悉函数式风格的编码
 * 3) yield的结果是Vector
 */
case class MultiTable(n: Int) {
  var num: Int = n

  //以序列形式返回一行乘法表
  def makeRowSeq(row: Int) =
    for (col <- 1 to row) yield {
      val prod = (col * row).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  //以字符串形式
  def makeRow(row: Int) = makeRowSeq(row).mkString

  //以字符串形式返回乘法表，每行记录一行字符串
  def printMultiTable() = {
    val tableSeq =
      for (row <- 1 to 9) yield {
        makeRow(row)
      }
    tableSeq.mkString("\n")
  }


}
