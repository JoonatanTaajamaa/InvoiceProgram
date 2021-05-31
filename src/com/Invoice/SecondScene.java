package com.Invoice;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SecondScene {
    private Text productNameTitle;
    private TextField productNameInput;
    private Text productQtyTitle;
    private TextField productQtyInput;
    private Text productUnitPriceTitle;
    private TextField productUnitPriceInput;
    private Button submitInvoiceItemButton;
    private Button makeInvoiceButton;

    public SecondScene() {
        init();
    }

    private void init() {
        productNameTitle = new Text("Name");
        productNameInput = new TextField();

        productQtyTitle = new Text("Qty");
        productQtyInput = new TextField();

        productUnitPriceTitle = new Text("Unit price");
        productUnitPriceInput = new TextField();

        submitInvoiceItemButton = new Button("submit");

        makeInvoiceButton = new Button("Make invoice");
    }

    public GridPane createScene() {
        GridPane pane = new GridPane();

        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setMinSize(400, 400);
        pane.setHgap(6);
        pane.setVgap(6);

        Text sceneTitle = new Text("Add Items");
        sceneTitle.setFont(new Font(20));

        pane.add(sceneTitle, 1, 0);

        pane.add(productNameTitle, 0, 1);
        pane.add(productNameInput, 1, 1);

        pane.add(productQtyTitle, 0, 2);
        pane.add(productQtyInput, 1, 2);

        pane.add(productUnitPriceTitle, 0, 3);
        pane.add(productUnitPriceInput, 1, 3);

        pane.add(submitInvoiceItemButton, 2, 4);
        pane.add(makeInvoiceButton, 2,5);

        return pane;
    }

    public TextField getProductNameInput() {
        return productNameInput;
    }

    public TextField getProductQtyInput() {
        return productQtyInput;
    }

    public TextField getProductUnitPriceInput() {
        return productUnitPriceInput;
    }

    public Button getMakeInvoiceButton() {
        return makeInvoiceButton;
    }

    public Button getSubmitInvoiceItemButton() {
        return submitInvoiceItemButton;
    }
}
