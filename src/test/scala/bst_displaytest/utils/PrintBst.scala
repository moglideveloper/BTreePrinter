package bst_displaytest.utils

import bst_display.btprinter.BinaryTreePrinter
import org.scalatest.FlatSpecLike

class PrintBst extends FlatSpecLike with TestData {

  "group by level" should "group treedata" in {
    val treeData = getIntList(15)
    val printer = BinaryTreePrinter(8, 7, " ")
    printer.printTree(treeData)

  }
}
