import checkout.Checkout_Products

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("example test that succeeds") {
    val obtained = Checkout_Products.checkout(Map(("book1", 2), ("book3", 3), ("book4", 1)), Map(("book1", 10), ("book3", 14)))._2
    val expected = 62.0
    assertEquals(obtained, expected)
  }
}
