package ch.makery.address.model

import scala.util.Random
//easy mode
class SnakesAndLaddersGameModel {


  private var playerPosition = 1

  protected var ladderPositions = Map[Int, Int]()
  protected var snakePositions = Map[Int, Int]()

  def initialize(): Unit = {
    //setting snakes and ladders positions

    ladderPositions = Map(2 -> 9, 11 -> 22)
    snakePositions = Map(19 -> 14, 12 -> 3)
    playerPosition = 1
  }

  def rollDice(): Int = {
    Random.nextInt(6) + 1
  }
//citation for some ideas of model class: https://github.com/Tressos-Aristomenis/Snakes-And-Ladders-JavaFX-from-scratch/blob/master/src/GameBoard/GameBoard.java
  def movePlayer(rollResult: Int): Int = {
    val newPosition = playerPosition + rollResult
    // checking if the new position is a snake or ladder or none
    val ladderPosition = ladderPositions.getOrElse(newPosition, newPosition)
    val snakePosition = snakePositions.getOrElse(ladderPosition, ladderPosition)
    playerPosition = snakePosition
    playerPosition
  }

}
