package biz.hahamo.dev.katas.rockpaperscissors;

import biz.hahamo.dev.katas.rockpaperscissors.GameLogic.Hand;
import java.util.Random;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Main class with main method for the Game.
 *
 * I skip Iteration 2 because this could be done with a GUI -- Iteration 4 in my
 * example.
 *
 * @author GHajba
 */
public class RockPaperScissorsGame extends Application {

    private GameLogic gameLogic = new GameLogic();
    private Random random = new Random();

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        final TextArea messageArea = new TextArea("Choose a game mode than your hand.");
        messageArea.setEditable(false);
        
        final ToggleGroup gameModes = new ToggleGroup();
        
        final RadioButton simpleGame = new RadioButton("Rock-Paper-Scissors");
        simpleGame.setToggleGroup(gameModes);
        simpleGame.setSelected(true);
        final RadioButton extendedGame = new RadioButton("RPSLS");
        extendedGame.setToggleGroup(gameModes);
        extendedGame.setSelected(false);
        
        final EventHandler<ActionEvent> gameButtonEventHandler;
        gameButtonEventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() instanceof Button) {
                    Button source = (Button) event.getSource();
                    messageArea.clear();
                    Hand playerHand = Hand.fromName(source.getText());
                    messageArea.appendText("Your choice: " + playerHand.name);
                    Hand computerHand;
                    do {
                        computerHand = gameLogic.getRandomHand();
                    } while (computerHand.ordinal() % 2 != 0 && !extendedGame.isSelected());

                    messageArea.appendText("\nComputer's choice: " + computerHand.name);
                    String winnerText = "";
                    switch(gameLogic.determineWinner(playerHand, computerHand)) {
                        case 1:
                            winnerText = "You win.";
                            break;
                        case 2:
                            winnerText = "Computer wins.";
                            break;
                        default:
                            winnerText = "It is a draw.";
                            break;
                    }
                    messageArea.appendText("\n" + winnerText);
                }
            }
        };

        final Button rock = new Button("Rock");
        final Button paper = new Button("Paper");
        final Button scissors = new Button("Scissors");
        final Button lizard = new Button("Lizard");
        final Button spock = new Button("Spock");
        lizard.setDisable(true);
        spock.setDisable(true);
        rock.setOnAction(gameButtonEventHandler);
        paper.setOnAction(gameButtonEventHandler);
        scissors.setOnAction(gameButtonEventHandler);
        lizard.setOnAction(gameButtonEventHandler);
        spock.setOnAction(gameButtonEventHandler);
        
        primaryStage.setTitle("Hello World!");

        gameModes.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                if (gameModes.getSelectedToggle() != null) {
                    boolean simpleMode = new_toggle.equals(simpleGame);
                    lizard.setDisable(simpleMode);
                    spock.setDisable(simpleMode);
                }
            }
        });

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10.0);
        root.setVgap(10.0);
        root.setPadding(new Insets(25, 25, 25, 25));

        root.add(simpleGame, 0, 0, 3, 1);
        root.add(extendedGame, 3, 0, 3, 1);

        root.add(rock, 0, 1);
        root.add(paper, 1, 1);
        root.add(scissors, 2, 1);
        root.add(lizard, 3, 1);
        root.add(spock, 4, 1);

        root.add(messageArea, 0, 2, 5, 1);

        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
    }

}
