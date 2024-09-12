package com.algoriant.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @Column(name = "invoice_id")
    private int invoiceId;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "issued_at")
    private Timestamp issuedAt;

    public Invoice() {
    }

    public Invoice(int invoiceId, int orderId, BigDecimal totalAmount, Timestamp issuedAt) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.issuedAt = issuedAt;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Timestamp issuedAt) {
        this.issuedAt = issuedAt;
    }

    public static Invoice toEntity(InvoiceRequest invoiceRequest) {
        Invoice invoice = new Invoice();
        invoice.setOrderId(invoiceRequest.getOrderId());
        invoice.setTotalAmount(invoiceRequest.getTotalAmount());
        return invoice;
    }
}
