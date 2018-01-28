package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import org.scalatest.Matchers._
import utils.Utils._

class GetEdgeLengthTest extends FlatSpecLike{

  val dataSize = 3
  val edgeLength = 5

  s"edge length for node at height 1, data-size $dataSize, edge-length $edgeLength" should s"be 5" in {
    val el = getEdgeLength(1)(dataSize, edgeLength)
    el should be(5)
  }

  s"edge length for node at height 2, data-size $dataSize, edge-length $edgeLength" should s"be 8" in {
    val el = getEdgeLength(2)(dataSize, edgeLength)
    el should be(8)
  }

  s"edge length for node at height 3, data-size $dataSize, edge-length $edgeLength" should s"be 19" in {
    val el = getEdgeLength(3)(dataSize, edgeLength)
    el should be(19)
  }

  s"edge length for node at height 4, data-size $dataSize, edge-length $edgeLength" should s"be 41" in {
    val el = getEdgeLength(4)(dataSize, edgeLength)
    el should be(41)
  }

  s"edge length for node at height 5, data-size $dataSize, edge-length $edgeLength" should s"be 85" in {
    val el = getEdgeLength(5)(dataSize, edgeLength)
    el should be(85)
  }
}