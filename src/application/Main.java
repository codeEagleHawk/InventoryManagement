package application;

import java.io.IOException;

import application.database.DatabaseController;
import application.model.Context;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application 
{
	private Stage primaryStage;
    private AnchorPane rootLayout;
    private static DatabaseController databaseController;
    
    @FXML
    private Button myButton;
    
    @Override
    public void start(Stage primaryStage) 
    {
    	initializeApplication();
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Inventory Management");
        
        Context.getInstance().getStageManager().addStage(this.primaryStage);

        initRootLayout();
    }
    
    public void initializeApplication()
    {
    	databaseController = new DatabaseController();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() 
    {
        try 
        {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/RootLayout.fxml"));
            this.rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout, 1000, 700);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
            
            Context.getInstance().getStageManager().addStage(this.primaryStage);
        } 
        catch (IOException e) 
        {
        	e.printStackTrace();
	    }
    }

    /**
	 * Returns the main stage.
	 * @return
	 */
    public Stage getPrimaryStage() 
    {
    	return primaryStage;
	}
    
    public static DatabaseController getDatabase()
    {
    	return Main.databaseController;
    }
    
    public void getProperties()
    {

    }

	public static void main(String[] args) 
	{
		launch(args);
	}
}
