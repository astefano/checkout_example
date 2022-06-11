package checkout

object Checkout_Products extends Checkout {
  
  def checkout(xs:Map[String, Int], all_products:Map[String, Double]): (Map[String, Double], Double) = {
    val products_in_xs: List[String] = xs.keys.toList
    val products_for_xs = all_products.filter ((k, v) => products_in_xs.contains (k) ).filter ((k, v) => ! v.isNaN)
    val total_cost = products_for_xs.foldLeft (0.0) ((a, t) => a + xs (t._1) * t._2)
    Tuple2 (products_for_xs, total_cost)
  }
}


