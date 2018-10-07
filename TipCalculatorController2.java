package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
 
	@FXML 
	private void calculate() {
		
		try {
			amount = new BigDecimal(amountTextField.getText());		
			numPeople = new BigDecimal(numPeopleTextField.getText());
			}
		catch (NumberFormatException ex) {
			return;
			}
		BigDecimal tip = amount.multiply(tipPercentage);
		total = amount.add(tip);
		System.out.println("Total is " + total);
		BigDecimal tipPercentage = BigDecimal.valueOf(tipPercentageSlider.getValue());
		BigDecimal splitTip = tip.divide(numPeople);
		perPersonTextField.setText(currency.format(splitTip));
		tipTextField.setText(currency.format(tip));

	}
		
	
     public void initialize() {
    	currency.setRoundingMode(RoundingMode.HALF_UP);
    	tipTextField.textProperty().bind(tipPercentageSlider.valueProperty().asString("%.0f"));
     	amountTextField.textProperty().addListener(e -> calculate());
    	tipTextField.textProperty().addListener(e -> calculate());
    	totalTextField.textProperty().addListener(e -> calculate());
     	
    	tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
				tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
				tipPercentageLabel.setText(percent.format(tipPercentage));
				totalTextField.setText(currency.format(total));
			}
    });
    	
 
}
}


		
	
	
