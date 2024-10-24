package ch.makery.address.model
import scala.util.Random
//hardmode subclass of normal game
class SnakesAndLaddersGameModelHard extends SnakesAndLaddersGameModel {
  override def initialize(): Unit = {
    //inheriting superclass methods and vairables
    super.initialize()
    //overriding the snakePositions
    snakePositions = Map(19 -> 14, 12 -> 3, 17 -> 13, 24 -> 18)
  }
}

