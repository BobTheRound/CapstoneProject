package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static Main instance;

    private String activePlayerTitle = "ADPP Player 1"; // Initially, Player 1 is active
    private Player[] players = new Player[2];

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Step 1: Create stages for both players
        Stage[] playerStages = new Stage[2];
        
        // Step 2: Create instances of the Player class for both players
        for (int i = 0; i < 2; i++) {
            players[i] = new Player("ADPP Player " + (i + 1));
            playerStages[i] = new Stage();
            players[i].start(playerStages[i]); // Start the player
        }

        // Step 3: Show all player stages
        for (Stage stage : playerStages) {
        	stage.setHeight(550);
        	stage.setWidth(550);
            stage.show();
        }

        // Step 4: Start the game loop for player one
        players[0].toggleActivePlayer(true); // Start with player one active
    }

    public void toggleActivePlayer() {
        // Toggle active player
        activePlayerTitle = (activePlayerTitle.equals("ADPP Player 1")) ? "ADPP Player 2" : "ADPP Player 1";

        // Deactivate the inactive player and activate the active player
        for (Player player : players) {
            player.toggleActivePlayer(player.getTitle().equals(activePlayerTitle));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}