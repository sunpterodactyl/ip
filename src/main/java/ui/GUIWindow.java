package ui;

import command.ByeCommand;
import command.Command;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import storage.Storage;
import sunpter.Sunpter;

import static ui.DialogBox.getSunpterDialog;
import parser.Parser;

/**
 * Controller for the main GUI.
 */
public class GUIWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;
    private Sunpter sunpter;
    private final Parser parser = new Parser();

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/prison_mike.jpg"));
    private final Image sunpterImage = new Image(this.getClass().getResourceAsStream("/images/sunpter.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                getSunpterDialog(Ui.showWelcome(), sunpterImage)
        );
    }

    /** Injects the sunpter.Sunpter instance */
    public void setSunpter(Sunpter s) {
        sunpter = s;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing sunpter.Sunpter's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    //Completable Future
    /*
    CompletableFuture.supplyAsync(() -> sunpter.getResponse(input))
            .thenAccept(response -> Platform.runLater(() ->
    addToDialog(DialogBox.getSunpterDialog(response, dukeImage))));
    */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        //Command response = parser.parseCommand(input);
        String displayResponse = sunpter.getResponse(input);
        if(input.startsWith("bye")) {
            System.exit(0);
        }
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                getSunpterDialog(displayResponse, sunpterImage)
        );
        userInput.clear();
    }
}

