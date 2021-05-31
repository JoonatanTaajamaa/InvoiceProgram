package com.Invoice;

public class InvoiceItem {
    private String product;
    private double unitPrice;
    private int qty;
    private double taxPercent;
    private double lineSumWithoutTax;
    private double lineTaxSum;
    private double lineTotalSum;

    public InvoiceItem(String product, double unitPrice, int qty, double taxPercent) {

        this.product = product;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.taxPercent = taxPercent;

        sumLine();
    }

    private void sumLine() {
        lineSumWithoutTax = unitPrice * qty;
        lineTaxSum = (unitPrice * (taxPercent / 100)) * qty;
        lineTotalSum = lineSumWithoutTax + lineTaxSum;
    }

    public String getProduct() {
        return product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public double getLineSumWithoutTax() {
        return lineSumWithoutTax;
    }

    public double getLineTaxSum() {
        return lineTaxSum;
    }

    public double getLineTotalSum() {
        return lineTotalSum;
    }
}
