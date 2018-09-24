package application;
import java.awt.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.*;
//
public class AdditionController {

	@FXML
	private TextField input1;
	
	@FXML
	private TextField input2;
	
	
	@FXML
	private Label input;
	private long number1 = 0;
	private long number2 = 0;
	private boolean start = true;
	private ModelView model = new ModelView();
//	
	public void processNumbers(ActionEvent event) {
		if (start){
			input1.setText("");
			input2.setText("");
			start = false;
		}
		String value = ((TextField)event.getSource()).getText();
		input1.setText(input.getText() + value);
		input2.setText(input.getText() + value);
	}
//	
	public void processOperator(ActionEvent event) {
	    //String value = ((Button)event.getSource()).getText();

		number1 = Long.parseLong(input1.getText());
		number2 = Long.parseLong(input2.getText());
		
		//call an event handler on the fxid
		//setOnAction(new EventHandler<ActionEvent>)
		//@Override
		//public void handle(ActionEvent event) {
		    float output = model.calculate(number1, number2);
		    System.out.println(output);
		//}
		//result.setText(String.valueOf(output));
		
	}
	}