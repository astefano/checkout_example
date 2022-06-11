package checkout

def products = Map(("book1", 10.0), ("book2",Double.NaN), ("book3", 15.0), ("book4", 16.0))

@main def hello: Unit =
  println(Checkout_Products.checkout(Map(("book1", 2), ("book4", 3)), products))

