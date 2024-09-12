package com.algoriant.order.repository;

import com.algoriant.order.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Modifying
    @Query(value = "UPDATE invoice SET order_id = :orderId, total_amount = :totalAmount WHERE invoice_id = :invoiceId", nativeQuery = true)
    void updateInvoice(@Param("invoiceId") int invoiceId, @Param("orderId") int orderId, @Param("totalAmount") BigDecimal totalAmount);
    @Modifying
    @Query(value = "DELETE FROM invoice WHERE invoice_id = :invoiceId", nativeQuery = true)
    void deleteInvoiceById(int invoiceId);

    @Query(value = "SELECT * FROM invoice WHERE invoice_id = :invoiceId", nativeQuery = true)
    Invoice getInvoiceById(int invoiceId);

    @Query(value = "SELECT * FROM invoice", nativeQuery = true)
    List<Invoice> getAllInvoice();
}
