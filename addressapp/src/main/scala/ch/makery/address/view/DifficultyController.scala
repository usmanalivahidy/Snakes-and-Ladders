package ch.makery.address.view
import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml

@sfxml
class DifficultyController {
  //method to show game board with easy difficulty
  def startGame3(action: ActionEvent): Unit = {
    MainApp.showBoard(1)

  }

  //method to show game board with hard difficulty
  def startGame4(action: ActionEvent): Unit = {
    MainApp.showBoard(2)

  }

}
