package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import utils.DataPNode
import utils.Utils._

class ProcessNodesTest extends FlatSpecLike {

  "basic test" should "pass" in {
    val bnodes = List(DataPNode(5, 6, 0, true, false, true), DataPNode(23, 5, 0, true, false, false))
    enrichMissingNodes(3, 2, bnodes)
  }
}
