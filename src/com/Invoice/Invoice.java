package com.Invoice;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Invoice {
    private Customer customer;
    private ArrayList<InvoiceItem> invoiceItems;
    private double taxPercent;
    private double totalSumWithoutTax;
    private double taxSum;
    private double totalSum;
    private String status;

    public Invoice(Customer customer, double taxPercent, String status) {
        this.customer = customer;
        this.taxPercent = taxPercent;
        this.status = status;

        invoiceItems = new ArrayList<>();
    }

    public void addInvoiceItem(String product, double unitPrice, int qty) {

        if (unitPrice >= 0 && qty >= 0) {
            invoiceItems.add(new InvoiceItem(product, unitPrice, qty, taxPercent));
        }
    }

    public void countTotal() {
        totalSumWithoutTax = 0;
        taxSum = 0;

        for (InvoiceItem in : invoiceItems) {
            totalSumWithoutTax += in.getLineSumWithoutTax();
            taxSum += in.getLineTaxSum();
        }

        totalSum = totalSumWithoutTax + taxSum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public double getTaxSum() {
        return taxSum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public double getTotalSumWithoutTax() {
        return totalSumWithoutTax;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }
}
