package ch.makery.address.view

import scalafx.event.ActionEvent
import scalafx.stage.Stage
import scalafxml.core.macros.sfxml
@sfxml
class HowToPlayController {
  var dialogStage: Stage = null
//method dealing with button press to close tutorial dialog
  def handleClose(action: ActionEvent) {
    dialogStage.close();

  }
}
