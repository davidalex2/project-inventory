package com.algoriant.order.service;

import com.algoriant.order.model.Invoice;
import com.algoriant.order.model.InvoiceRequest;
import com.algoriant.order.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice modifyInvoice(int invoiceId, InvoiceRequest invoiceRequest) {
        Invoice invoice = Invoice.toEntity(invoiceRequest);
        invoiceRepository.updateInvoice(invoiceId, invoice.getOrderId(), invoice.getTotalAmount());
        return invoice;
    }

    public void removeInvoice(int invoiceId) {
        invoiceRepository.deleteInvoiceById(invoiceId);
    }

    public Invoice getInvoice(int invoiceId) {
        return invoiceRepository.getInvoiceById(invoiceId);
    }

    public List<Invoice> getAllInvoice() {
        return invoiceRepository.getAllInvoice();
    }
}
