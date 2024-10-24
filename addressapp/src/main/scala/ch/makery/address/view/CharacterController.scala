package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
@sfxml
class CharacterController {
  //method to deal with button press choosing green character
  def startGame2(action: ActionEvent): Unit = {
    MainApp.showDifficulty(2)

  }
  //method to deal with button press choosing blue character
  def startGame1(action: ActionEvent): Unit = {
    MainApp.showDifficulty(1)

  }

}
