package com.example.kodillahibernate.invoice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @BeforeEach
    public void before() {
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        Item item1 = new Item(product1, new BigDecimal("100"), 2, new BigDecimal("200"));
        Item item2 = new Item(product2, new BigDecimal("200"), 3, new BigDecimal("600"));
        Item item3 = new Item(product3, new BigDecimal("50"), 5, new BigDecimal("250"));

        Invoice invoice = new Invoice("INV001");
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item3);

        invoiceDao.save(invoice);
    }

    @AfterEach
    public void after() {
        invoiceDao.deleteAll();
        productDao.deleteAll();
    }

    @Test
    public void testInvoiceDaoSave() {
        // given
        int expectedInvoiceCount = 1;
        int expectedItemCount = 3;

        // when
        Iterable<Invoice> invoices = invoiceDao.findAll();
        int actualInvoiceCount = 0;
        int actualItemCount = 0;
        for (Invoice invoice : invoices) {
            actualInvoiceCount++;
            actualItemCount += invoice.getItems().size();
        }

        // then
        assertEquals(expectedInvoiceCount, actualInvoiceCount);
        assertEquals(expectedItemCount, actualItemCount);
    }
}