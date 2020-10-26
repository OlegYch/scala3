import scala.quoted._
object Macro {
  def impl[A : Type](using qctx: QuoteContext): Unit = {
    import qctx.reflect._
    val tpe = TypeRepr.of[A].seal.asInstanceOf[Type[_ <: AnyRef]]
    '{ (a: ${tpe}) => ???} // error
  }
}
