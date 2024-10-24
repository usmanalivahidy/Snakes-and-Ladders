package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
@sfxml
class WelcomePageController {
  //method dealing with button to show character window
  def startGame(action: ActionEvent): Unit = {
    MainApp.showCharacter()
  }
  //method dealing with button to show tutorial dialog
  def showHowToPlay(action: ActionEvent): Unit = {
    MainApp.showTutorial()
  }
}
