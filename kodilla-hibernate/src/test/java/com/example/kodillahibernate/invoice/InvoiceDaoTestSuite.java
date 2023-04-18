package com.example.kodillahibernate.invoice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @AfterEach
    public void after() {
        invoiceDao.deleteAll();
    }

    @Test
    public void testInvoiceDaoSave() {
        // given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        Item item1 = new Item(product1, new BigDecimal("100"), 2, new BigDecimal("200"));
        Item item2 = new Item(product2, new BigDecimal("200"), 3, new BigDecimal("600"));
        Item item3 = new Item(product3, new BigDecimal("50"), 5, new BigDecimal("250"));

        Invoice newInvoice = new Invoice("INV001");
        newInvoice.addItem(item1);
        newInvoice.addItem(item2);
        newInvoice.addItem(item3);


        int expectedInvoiceCount = 1;
        int expectedItemCount = 3;

        // when
        invoiceDao.save(newInvoice);

        Optional<Invoice> optionalInvoice = invoiceDao.findById(newInvoice.getId());
        assertTrue(optionalInvoice.isPresent());
        Invoice invoice = optionalInvoice.get();

        int actualInvoiceCount = 1;
        int actualItemCount = invoice.getItems().size();
        // then
        assertEquals(expectedInvoiceCount, actualInvoiceCount);
        assertEquals(expectedItemCount, actualItemCount);
    }
}