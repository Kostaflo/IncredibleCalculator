package io.github.Kostaflo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

  @FXML private TextField display;

  @FXML
  private void handleDigit(ActionEvent event) {
    // Παίρνουμε το κείμενο του κουμπιού που πατήθηκε
    String digit = ((Button) event.getSource()).getText();
    System.out.println("DEBUG: Πατήθηκε το νούμερο " + digit);

    // Απλά το κολλάμε στο τέλος του κειμένου της οθόνης
    display.setText(display.getText() + digit);
  }

  @FXML
  private void handleOperator(ActionEvent event) {
    String symbol = ((Button) event.getSource()).getText();
    System.out.println("DEBUG: Πατήθηκε η πράξη " + symbol);
  }

  @FXML
  private void handleEquals(ActionEvent event) {
    System.out.println("DEBUG: Πατήθηκε το ίσον");
  }

  @FXML
  private void handleClear(ActionEvent event) {
    System.out.println("DEBUG: Καθαρισμός");
    display.setText("");
  }
}
