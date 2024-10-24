package ch.makery.address.view

import ch.makery.address.MainApp
import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
@sfxml
class RootLayoutController() {
  //method to close System program
  def handleClose(action: ActionEvent): Unit = {
    System.exit(0)
  }
  //method to restart game
  def handleRestart(action: ActionEvent): Unit = {
  MainApp.showCharacter()
   }
  //method to display tutorial dialog
  def handleHelp(action: ActionEvent): Unit = {
    MainApp.showTutorial()
  }

}
