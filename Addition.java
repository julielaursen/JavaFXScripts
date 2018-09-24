package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Addition extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
      // Button btn = new Button("Calculate");
       //btn.setOnAction(new EventHandler<ActionEvent>(){
    	//   
    	  // @Override
    	   //public void handle(ActionEvent event) {
    		 //  System.out.println("Hello world");
    	   ///}
       //});
	   try {
		   Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		   Scene scene = new Scene(root, 500, 300);
		   primaryStage.setTitle("Addition");
		   primaryStage.setScene(scene);
		   primaryStage.show();
	  }
	   catch(Exception e) {
		  e.printStackTrace(); 
	   }
	}
       public static void main(String[] args) {
   		launch(args);
   	}
}
