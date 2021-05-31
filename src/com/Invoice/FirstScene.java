package com.Invoice;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FirstScene {

    private Text customerNameTitle;
    private TextField customerNameInput;
    private Text customerSocialSecurityNumberTitle;
    private TextField customerSocialSecurityNumberInput;
    private Text taxPercentTitle;
    private TextField taxPercentInput;
    private Text statusTitle;
    private TextField statusInput;
    private Button submitCustomerButton;


    public FirstScene() {
        init();
    }

    private void init() {

        customerNameTitle = new Text("Name");
        customerNameInput = new TextField();

        customerSocialSecurityNumberTitle = new Text("Social security number");
        customerSocialSecurityNumberInput = new TextField();

        taxPercentTitle = new Text("TaxPercent");
        taxPercentInput = new TextField();

        statusTitle = new Text("Status");
        statusInput = new TextField();

        submitCustomerButton = new Button("submit");
    }

    public GridPane createScene() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setMinSize(400, 400);
        pane.setHgap(6);
        pane.setVgap(6);

        Text sceneTitle = new Text("Customer's information");
        sceneTitle.setFont(new Font(22));

        pane.add(sceneTitle, 1, 0);

        pane.add(customerNameTitle, 0, 1);
        pane.add(customerNameInput, 1, 1);

        pane.add(customerSocialSecurityNumberTitle, 0, 2);
        pane.add(customerSocialSecurityNumberInput, 1, 2);

        pane.add(taxPercentTitle, 0, 3);
        pane.add(taxPercentInput, 1, 3);

        pane.add(statusTitle, 0, 4);
        pane.add(statusInput, 1, 4);

        pane.add(submitCustomerButton, 2, 5);

        return pane;
    }


    public TextField getCustomerNameInput() {
        return customerNameInput;
    }

    public TextField getCustomerSocialSecurityNumberInput() {
        return customerSocialSecurityNumberInput;
    }

    public TextField getTaxPercentInput() {
        return taxPercentInput;
    }

    public TextField getStatusInput() {
        return statusInput;
    }

    public Button getSubmitCustomerButton() {
        return submitCustomerButton;
    }
}
