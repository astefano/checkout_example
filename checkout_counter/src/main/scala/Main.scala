@main def hello: Unit = 
  println(basic_checkout(Set("book1")))
  println(checkout0(Map(("book1", 2))))

def products = Map(("book1", 10.0), ("book2",Double.NaN))

/* the simplest checkout: the products are simply given as a map, product & price */
def basic_checkout(xs:Set[String]): Tuple2[Map[String, Double],Double] =
  val products_for_xs = products.filter((k,v)=>xs(k)).filter((k,v)=> ! v.isNaN)
  val total_cost = products_for_xs.values.sum
  Tuple2(products_for_xs, total_cost)

/* checkout0 takes a map of a desired product and the quantity as an Int */
def checkout0(xs:Map[String, Int]): Tuple2[Map[String, Double],Double] =
  val products_in_xs : List[String] = xs.keys.toList
  val products_for_xs = products.filter( (k,v) => products_in_xs.contains(k) ).filter((k,v)=> ! v.isNaN)
  val total_cost = products_for_xs.foldLeft(0.0)((a, t) => a + xs(t._1) * t._2)
  Tuple2(products_for_xs, total_cost)
