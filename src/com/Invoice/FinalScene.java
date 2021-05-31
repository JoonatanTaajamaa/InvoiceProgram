package com.Invoice;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class FinalScene {

    private Customer customer;
    private Invoice invoice;

    private Text qtyTitle;
    private Text productNameTitle;
    private Text unitPriceTitle;
    private Text sumWithoutTaxTitle;
    private Text taxSumTitle;
    private Text totalSumTitle;
    private Text taxPercentTitle;

    public FinalScene(Customer customer, Invoice invoice) {
        this.customer = customer;
        this.invoice = invoice;

        init();
    }

    private void init() {
        qtyTitle = new Text("Qty");
        productNameTitle = new Text("Name");
        unitPriceTitle = new Text("Unit Price");
        sumWithoutTaxTitle = new Text("Sum Without tax");
        taxSumTitle = new Text("Tax sum");
        totalSumTitle = new Text("Total sum");
        taxPercentTitle = new Text("Tax percent");
    }

    public GridPane createScene() {
        GridPane pane = new GridPane();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setMinSize(200, 400);
        pane.setMaxSize(2200, 2200);
        pane.setHgap(22);
        pane.setVgap(12);

        Text sceneTitle = new Text("Invoice");
        sceneTitle.setFont(new Font(20));

        pane.add(sceneTitle, 9, 0);

        pane.add(new Text("Invoice to"), 0, 1);
        pane.add(new Text("Name: " + invoice.getCustomer().getName()), 0, 2);
        pane.add(new Text("Social security number: " +  invoice.getCustomer().getSocialSecurityNumber()),
                0, 3);

        pane.add(qtyTitle, 0, 5);
        pane.add(productNameTitle, 3, 5);
        pane.add(unitPriceTitle, 6, 5);
        pane.add(sumWithoutTaxTitle, 9, 5);
        pane.add(taxSumTitle, 12, 5);
        pane.add(totalSumTitle, 15, 5);
        pane.add(taxPercentTitle, 18, 5);

        int countRows = 6;
        for(InvoiceItem in : invoice.getInvoiceItems()) {

            pane.add(new Label(in.getQty() +""), 0, countRows);
            pane.add(new Label(in.getProduct() +""), 3, countRows);
            pane.add(new Label(decimalFormat.format(in.getUnitPrice()) +" €"), 6, countRows);
            pane.add(new Label(decimalFormat.format(in.getLineSumWithoutTax()) +" €"), 9, countRows);
            pane.add(new Label(decimalFormat.format(in.getLineTaxSum()) +" €"), 12, countRows);
            pane.add(new Label(decimalFormat.format(in.getLineTotalSum()) +" €"), 15, countRows);
            pane.add(new Label(decimalFormat.format(in.getTaxPercent()) +" %"), 18, countRows);

            countRows++;
        }

        pane.add(new Text("Status: " + invoice.getStatus()), 0, countRows + 1);
        pane.add(new Text("Sum Without tax: " + decimalFormat.format(invoice.getTotalSumWithoutTax()) + " €"), 0, countRows + 2);
        pane.add(new Text("Tax percent: " + decimalFormat.format(invoice.getTaxPercent()) + " %"), 0, countRows + 3);
        pane.add(new Text("Tax sum: " + decimalFormat.format(invoice.getTaxSum()) + " €"), 0, countRows + 4);
        pane.add(new Text("Total sum: " + decimalFormat.format(invoice.getTotalSum()) + " €"), 0, countRows + 5);

        return pane;
    }
}
