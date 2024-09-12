package com.algoriant.order.controller;

import com.algoriant.order.model.Invoice;
import com.algoriant.order.model.InvoiceRequest;
import com.algoriant.order.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @PutMapping("/modifyInvoice/{id}")
    public ResponseEntity<Invoice> modifyInvoice(@PathVariable("id") int id, @RequestBody InvoiceRequest invoiceRequest) {
        return new ResponseEntity<>(invoiceService.modifyInvoice(id, invoiceRequest), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @DeleteMapping("/removeInvoice/{id}")
    public ResponseEntity<String> removeInvoice(@PathVariable("id") int id) {
        invoiceService.removeInvoice(id);
        return new ResponseEntity<>("Invoice removed successfully", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @GetMapping("/getInvoice/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable("id") int id) {
        return new ResponseEntity<>(invoiceService.getInvoice(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
    @GetMapping("/getAllInvoice")
    public ResponseEntity<List<Invoice>> getAllInvoice() {
        return new ResponseEntity<>(invoiceService.getAllInvoice(), HttpStatus.OK);
    }
}
