package ch.makery.address
import ch.makery.address.view.HowToPlayController
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{FXMLLoader, FXMLView, NoDependencyResolver}
import javafx.{scene => jfxs}
import scalafx.scene.image.Image
import scalafx.stage.{Modality, Stage}

object MainApp extends JFXApp {
  //source: addressapp - Dr Chin Teck Min practicals
  // transforming the path of RootLayout.fxml to URI for resource location
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  // initializing the loader object
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  // Loading root layout from fxml file.
  loader.load();
  // retrieving the root component BorderPane from the FXML
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  var currentPlayer: Int = 0
  var difficultyMode: Int = 1
  // initializing stage
  stage = new PrimaryStage {
    title = "BoardGame"

    scene = new Scene {
      root = roots
    }
  }
  // method for displaying welcome window
  def showWelcome() = {
    val resource = getClass.getResource("view/WelcomePage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]()
    this.roots.setCenter(roots)
  }
  // method for displaying character window
  def showCharacter() = {
    val resource = getClass.getResource("view/Character.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]()
    this.roots.setCenter(roots)
  }
  // method for displaying difficulty window
  def showDifficulty(player: Int) = {
    currentPlayer = player
    val resource = getClass.getResource("view/Difficulty.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]()
    this.roots.setCenter(roots)
  }
  // method for displaying main game board window
  def showBoard(mode: Int): Unit = {

    difficultyMode = mode

    val resource = getClass.getResource("view/Board.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)

  }
  // method for displaying  how to play dialog
  def showTutorial()= {
    val resource = getClass.getResourceAsStream("view/HowToPlay.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[HowToPlayController#Controller]

    val dialog = new Stage() {
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {

        root = roots2
      }
    }
    control.dialogStage = dialog
    dialog.showAndWait()

  }

  // call to display Welcome page when app start
showWelcome()
}
