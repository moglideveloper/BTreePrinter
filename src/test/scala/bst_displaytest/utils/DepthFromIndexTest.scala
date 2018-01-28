package bst_displaytest.utils

import org.scalatest.FlatSpecLike
import org.scalatest.Matchers._
import utils.Utils._

class DepthFromIndexTest extends FlatSpecLike{

  "depth for index 1" should "be 0" in {
    val depth = depthFromIndex(1)
    depth should be(0)
  }

  "depth for index 2, 3" should "be 1" in {

    val indexes = List(2, 3)

    indexes foreach{ index =>
      val depth = depthFromIndex(index)
      depth should be(1)
    }
  }

  "depth for index 4, 5, 6, 7" should "be 2" in {

    val indexes = List(4, 5, 6, 7)

    indexes foreach{ index =>
      val depth = depthFromIndex(index)
      depth should be(2)
    }
  }

  "depth for index 8, 9, 10, 11, 12, 13, 14, 15" should "be 3" in {

    val indexes = List(8, 9, 10, 11, 12, 13, 14, 15)

    indexes foreach{ index =>
      val depth = depthFromIndex(index)
      depth should be(3)
    }
  }
}
