package application;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Random;

public class Player {
    private String title;
    private Stage primaryStage;
    private VBox methodButtonsPane;
    private GridPane playerGrid;
    private int guesses = 1;
    private Random rand = new Random();
    private Button hint = new Button("Hint!");
    private boolean isActive = false;
    private static String stroke = "Block";
    
    
    public Player(String title) {
        this.title = title;
    }

    public Player() {
    }
    
    public void reset() {
        // Clear the game grid
        playerGrid.getChildren().clear();
        
        // Reset guesses
        guesses = 1;
        
        // Reset UI state
        methodButtonsPane.setVisible(true);
        playerGrid.setVisible(false);
    }

    public String setStroke(String stroke) {
    	return this.stroke = stroke;
    }
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // Store the primaryStage
        primaryStage.setTitle(title);

        // Create method buttons pane
        methodButtonsPane = createMethodButtons();
        playerGrid = createGameGrid(); // Initialize playerGrid here
        playerGrid.setVisible(false); // Hide the grid initially

        // Set up the root pane
        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(playerGrid, methodButtonsPane);
        primaryStage.setScene(new Scene(rootPane, 400, 400));
        primaryStage.show();
    }

    private VBox createMethodButtons() {
        VBox methodButtons = new VBox(10); // Add spacing between buttons

        // Create buttons for methods
        String[] methods = {"Slice", "Chop", "SideLoop", "Smash", "Block"};
        for (String method : methods) {
            Button methodButton = new Button(method);
            methodButton.setOnAction(e -> {
            	if (method.equals("Block")) {
            		setGuesses(2);
            	}
            handleMethodButtonClick(method);
            });
       
            methodButton.setMinSize(80, 40); // Larger buttons
            methodButtons.getChildren().add(methodButton);
        }

        return methodButtons;
    }
    
    private int setGuesses(int guesses) {
		this.guesses = guesses;
		return this.guesses;
		
	}

	public String getTitle() {
        return title;
    }
    
	public void toggleActivePlayer(boolean isActive) {
	    this.isActive = isActive;
	    if (isActive) {
	        resetUI(); // Reset the UI when the player becomes active
	    }
	    // Enable or disable method buttons based on isActive flag
	    for (Node node : methodButtonsPane.getChildren()) {
	        if (node instanceof Button) {
	            Button button = (Button) node;
	            button.setDisable(!isActive); // Disable buttons if isActive is false
	        }
	    }
	}
    
    private void handleMethodButtonClick(String method) {
    	
        // Serve the ball and get its position
        Pair<Integer, Integer> ballPosition = serveBall(playerGrid);
        System.out.println(ballPosition.getKey() + " " + ballPosition.getValue());
        int ballCol = ballPosition.getKey();
        int ballRow = ballPosition.getValue();
        System.out.println(ballCol + " " + ballRow);
        // Call the appropriate method in StrokeType based on the method label
        switch (stroke) {
            case "Slice":
                new StrokeType().sliceMethod(playerGrid, ballCol, ballRow, hint);
                setStroke(method);
                break;
            case "Chop":
                new StrokeType().chopMethod(playerGrid, ballCol, ballRow, hint);
                setStroke(method);
                break;
            case "SideLoop":
                new StrokeType().sideLoopMethod(playerGrid, ballCol, ballRow, hint);
                setStroke(method);
                break;
            case "Smash":
                new StrokeType().smashMethod(playerGrid, ballCol, ballRow, hint);
                setStroke(method);
                break;
            case "Block":
                new StrokeType().blockMethod(playerGrid, ballCol, ballRow, hint);
                setStroke(method);
                break;
            default:
                // Handle invalid method name
                System.out.println("Invalid method name");
                break;
        }
        // Disable buttons on the gridPane
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                ((Button) playerGrid.getChildren().get(row * 10 + col)).setDisable(false);
            }
        }

        // Remove method buttons pane
        ((StackPane) methodButtonsPane.getParent()).getChildren().remove(methodButtonsPane);

        playerGrid.setVisible(true); // Show the grid
        primaryStage.show();

        // Generate a random ball button
        serveBall(playerGrid);
        
    }

    private void resetUI() {
        // Reset the player's grid
        playerGrid.getChildren().clear();
        playerGrid = createGameGrid();
        playerGrid.setVisible(false);

//        // Remove method buttons pane
//        ((StackPane) methodButtonsPane.getParent()).getChildren().remove(methodButtonsPane);

        // Show the reset grid
        StackPane rootPane = new StackPane();
        rootPane.getChildren().addAll(playerGrid, methodButtonsPane);
        primaryStage.setScene(new Scene(rootPane, 400, 400));
        primaryStage.show();
    }
    
    private void handleEndTurn() {
    	resetUI();
        Main.getInstance().toggleActivePlayer();
        
    }
    
    private GridPane createGameGrid() {
        GridPane pane = new GridPane();

        // Loop through rows
        for (int row = 0; row < 10; row++) {
            // Loop through columns
            for (int col = 0; col < 10; col++) {
                // Create a button
                Button button = new Button(row + "" + col); // Label button with row and column numbers
                button.setMinSize(50, 50); // Set button size
                button.setDisable(true); // Disable buttons initially
                button.setOnAction(e ->{
                	guesses --;
                	System.out.println("Gridpane Click! " + guesses);
                	if (guesses <= 0) {
                		handleEndTurn();
                	}
                });
                // Add button to the grid at the specified row and column
                pane.add(button, col, row);
            }
        }

        return pane;
    }
    
    public void getHint(GridPane pane, int col, int row) {
    	hint = new Button("Hint!");
    	hint.setMaxSize(50, 50);
    	hint.setOnAction(e -> {
    		guesses --;
    		System.out.println("Hint click " + guesses);
    		if (guesses <= 0) {
        		handleEndTurn();
        	}
    	});
    	pane.add(hint, col, row);
    }
    
    
    public Pair<Integer, Integer> serveBall(GridPane pane) {
        // Check if a ball button already exists on the grid
        if (pane.getChildren().stream().anyMatch(node -> GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null && node instanceof Button && ((Button) node).getText().equals("Ball!"))) {
            // Ball button already exists, return null to indicate that no new ball button was added
            return null;
        }

        int row = rand.nextInt(8) + 1; // Random row (1 to 8)
        int col = rand.nextInt(8) + 1; // Random column (1 to 8)
        Button ballButton = new Button("Ball!");
        ballButton.setMinSize(50, 50);
        ballButton.setOpacity(50);
        ballButton.setOnAction(e -> {
            guesses--;
            System.out.println("Ball click " + guesses);
            if (guesses <= 0) {
        		handleEndTurn();
        	}
        });
        pane.add(ballButton, col, row);

        // Return the row and column indices as a Pair
        return new Pair<>(col, row);
    }
 
    
}
