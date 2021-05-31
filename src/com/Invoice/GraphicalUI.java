package com.Invoice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class GraphicalUI extends Application {
    private Scene mainScene;
    private Scene invoiceItemScene;
    private Scene invoiceShowScene;

    private FirstScene firstScene;
    private SecondScene secondScene;
    private FinalScene finalScene;

    private Customer customer;
    private Invoice invoice;

    @Override
    public void start(Stage primaryStage) throws Exception {
        firstScene = new FirstScene();
        secondScene = new SecondScene();

        mainScene = new Scene(firstScene.createScene());
        invoiceItemScene = new Scene(secondScene.createScene());


        firstScene.getSubmitCustomerButton().setOnAction(event -> {
            try {
                customer = new Customer(firstScene.getCustomerNameInput().getText(), firstScene.getCustomerSocialSecurityNumberInput().getText());
                invoice = new Invoice( customer, Double.valueOf(firstScene.getTaxPercentInput().getText()), firstScene.getStatusInput().getText());
                primaryStage.setScene(invoiceItemScene);
            }catch (Exception e) {
                System.err.println("Try again.");
            }

        });

        secondScene.getSubmitInvoiceItemButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    invoice.addInvoiceItem(secondScene.getProductNameInput().getText(),
                            Double.valueOf(secondScene.getProductUnitPriceInput().getText()),
                            Integer.valueOf(secondScene.getProductQtyInput().getText()));

                    secondScene.getProductNameInput().clear();
                    secondScene.getProductUnitPriceInput().clear();
                    secondScene.getProductQtyInput().clear();
                    invoice.countTotal();
                }catch (Exception e) {
                    System.err.println("Try again.");
                }
            }
        });

        secondScene.getMakeInvoiceButton().setOnAction(event -> {
            try {
                finalScene = new FinalScene(customer, invoice);
                invoiceShowScene = new Scene(finalScene.createScene());
                primaryStage.setScene(invoiceShowScene);
            }catch (Exception e) {
                System.err.println("Try again.");
            }
        });

        primaryStage.setTitle("Invoice");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void run() {
        launch(GraphicalUI.class);
    }
}
