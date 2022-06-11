package checkout

trait Checkout {
  /* checkout takes a map of a desired product and the quantity as an Int */
  def checkout(xs:Map[String, Int], all_products:Map[String, Double]): (Map[String, Double], Double)
}
