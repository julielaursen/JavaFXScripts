package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController2 {
	
	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();
	private BigDecimal tipPercentage = new BigDecimal(0.15);
	
    @FXML
    private Label amountLabel;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField perPersonTextField;

    @FXML
    private TextField numPeopleTextField;

    BigDecimal amount;
	BigDecimal numPeople;
	BigDecimal total;
	BigDecimal tip;
	BigDecimal splitTip;
 
	@FXML 
	private void calculate() {
		try {
			amount = new BigDecimal(amountTextField.getText());		
			numPeople = new BigDecimal(numPeopleTextField.getText());
			tip = amount.multiply(tipPercentage);
			total = amount.add(tip);
			splitTip = tip.divide(numPeople);
			BigDecimal tipPercentage = BigDecimal.valueOf(tipPercentageSlider.getValue());
			tipTextField.setText(currency.format(tip));
			totalTextField.setText(currency.format(tip));
			perPersonTextField.setText(currency.format(splitTip));
			}
		catch (NumberFormatException ex) {
			return;
			}
	}
	
	 @FXML
	 private void amountTextField(ActionEvent event) {
	        amountTextField.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent k) {
					calculate();
				}
	    });
	 }
	        
	 @FXML
	    private void numPeopleTextField(ActionEvent event) {
	        numPeopleTextField.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override 
	        	public void handle(ActionEvent k ) {
	        		calculate();
	        	}
	        });
	    }
	
	 @FXML
     public void initialize() {
		//tipTextField.textProperty().bind(tipPercentageSlider.valueProperty().asString("%.0f"));
    	currency.setRoundingMode(RoundingMode.HALF_UP);
    	numPeopleTextField.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			calculate();
    		}
    	});
    	
    	amountTextField.textProperty().addListener(new ChangeListener<String>(){ 		
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				calculate();
 			}
    	});
    	
    	tipTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				calculate();
 			}
    	});
    	
    	totalTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				calculate();

 			}
    	});
    	
    	tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
				tipPercentageLabel.setText(percent.format(tipPercentage));
 				totalTextField.setText(currency.format(total));
				perPersonTextField.setText(currency.format(splitTip));
				calculate();
			}
       });	
	 }
}



		
	
	
