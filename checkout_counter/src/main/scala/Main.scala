package checkout

import scala.io.Source

def load_products() : Map[String, Double] = {
  var products = collection.mutable.Map[String, Double]()
  /* adapted from https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch12s06.html */
  val bufferedSource = Source.fromFile("products.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)
    val price = try { cols{1}.toDouble } catch { case _ => Double.NaN }
    products += (cols{0} -> price)
  }
  bufferedSource.close
  return products.toMap
}

@main def hello: Unit =
  println(load_products())
  println(Checkout_Products.checkout(Map(("book1", 2), ("book3", 3), ("book4", 1)), load_products()))

