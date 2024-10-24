package ch.makery.address.view

import ch.makery.address.MainApp
import ch.makery.address.model.SnakesAndLaddersGameModel
import ch.makery.address.model.SnakesAndLaddersGameModelHard
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.{Alert, Button, TextField}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.text.Text
import scalafxml.core.macros.sfxml


@sfxml
class BoardController(

                       private val diceImageView: ImageView,
                       private val positionText: Text,
                       private val index_1: ImageView,
                       private val index_2: ImageView,
                       private val index_3: ImageView,
                       private val index_4: ImageView,
                       private val index_5: ImageView,
                       private val index_6: ImageView,
                       private val index_7: ImageView,
                       private val index_8: ImageView,
                       private val index_9: ImageView,
                       private val index_10: ImageView,
                       private val index_11: ImageView,
                       private val index_12: ImageView,
                       private val index_13: ImageView,
                       private val index_14: ImageView,
                       private val index_15: ImageView,
                       private val index_16: ImageView,
                       private val index_17: ImageView,
                       private val index_18: ImageView,
                       private val index_19: ImageView,
                       private val index_20: ImageView,
                       private val index_21: ImageView,
                       private val index_22: ImageView,
                       private val index_23: ImageView,
                       private val index_24: ImageView,
                       private val index_25: ImageView,
                       private val nameField : TextField


                     ) {
  private val difficulty = MainApp.difficultyMode
  private val gameModel: SnakesAndLaddersGameModel =
    if (difficulty == 1) new SnakesAndLaddersGameModel()
    else new SnakesAndLaddersGameModelHard()
//initializing the boards snakes and ladders
  gameModel.initialize()
//initializing player position at start of game
  private var currentPlayerPosition: Int = 1
nameField.text = ""

  def rollDiceAndMovePlayer(action: ActionEvent): Unit = {
    //checking if player hasnt won game or left name field empty
    if (currentPlayerPosition < 25 && (nameField.text.value != null && nameField.text.value.length != 0)) {
      val rollResult = gameModel.rollDice()
      val diceImage = new Image(s"ch/makery/address/images/dice_$rollResult.png")
      diceImageView.image = diceImage
      val newPosition = gameModel.movePlayer(rollResult)
      //updating user position text
      positionText.text = s"Position: $newPosition"
      removePlayerImage(currentPlayerPosition)
      movePlayerImage(newPosition)
      currentPlayerPosition = newPosition
      if (newPosition >= 25) {
        positionText.text = "YOU WON!"
      }


      def removePlayerImage(position: Int): Unit = {
        val imageViewToRemove = position match {
          case 1 => index_1
          case 2 => index_2
          case 3 => index_3
          case 4 => index_4
          case 5 => index_5
          case 6 => index_6
          case 7 => index_7
          case 8 => index_8
          case 9 => index_9
          case 10 => index_10
          case 11 => index_11
          case 12 => index_12
          case 13 => index_13
          case 14 => index_14
          case 15 => index_15
          case 16 => index_16
          case 17 => index_17
          case 18 => index_18
          case 19 => index_19
          case 20 => index_20
          case 21 => index_21
          case 22 => index_22
          case 23 => index_23
          case 24 => index_24
          case 25 => index_25
          case _ => throw new IllegalArgumentException(s"Invalid position: $position")
        }

        // Clearing the image of the previous position
        imageViewToRemove.image = null
      }

      def movePlayerImage(newPosition: Int): Unit = {
        val imageViewToUpdate = newPosition match {
          case 1 => index_1
          case 2 => index_2
          case 3 => index_3
          case 4 => index_4
          case 5 => index_5
          case 6 => index_6
          case 7 => index_7
          case 8 => index_8
          case 9 => index_9
          case 10 => index_10
          case 11 => index_11
          case 12 => index_12
          case 13 => index_13
          case 14 => index_14
          case 15 => index_15
          case 16 => index_16
          case 17 => index_17
          case 18 => index_18
          case 19 => index_19
          case 20 => index_20
          case 21 => index_21
          case 22 => index_22
          case 23 => index_23
          case 24 => index_24
          case 25 => index_25
          case 26 => index_25
          case 27 => index_25
          case 28 => index_25
          case 29 => index_25
          case 30 => index_25
          case 31 => index_25
          case _ => throw new IllegalArgumentException(s"Invalid final position: $newPosition")
        }
        //deriving color chosen by player
        val playerColor = MainApp.currentPlayer
        val playerImage = new Image(s"ch/makery/address/images/player_$playerColor.png")
        imageViewToUpdate.image = playerImage
      }


    }
      //alerting user namefield cannot be empty
    else if (nameField.text.value == null || nameField.text.value.length == 0) {
      val alert = new Alert(AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "INVALID INPUT"
        headerText = "You can not leave the name field empty"
        contentText = "Please enter your name in the name field to start playing"
      }.showAndWait()

    }
      //alerting user theyve already won
    else {

      val alert = new Alert(AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "GAME OVER"
        headerText = "CONGRATULATIONS, you have already won the game!!!"
        contentText = "If you would like to restart the game, please do so using the menu bar. " +
          "Or else you can close the game using the menu bar"
      }.showAndWait()
    }


  }





}
