package learnandtry.builders.invoice;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class InvoiceWithSetMethodsTest {

    @Test
    public void testWithSetMethods() {
        Invoice invoice2 = new Invoice();
        invoice2.setAddress(createAddress());
        ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
        invoiceLines.add(createInvoiceLine(10.0, "PC"));
        invoiceLines.add(createInvoiceLine(1000.0, "Macbook"));
        invoice2.setInvoiceLines(invoiceLines);

        assertInvoiceIsCorrect(invoice2);
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("Riga");
        address.setPostCode("1057");
        address.setStreet("Rigas");
        return address;
    }

    private InvoiceLine createInvoiceLine(double price, String product) {
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setPrice(price);
        invoiceLine.setProduct(product);
        return invoiceLine;
    }

    private void assertInvoiceIsCorrect(Invoice invoice) {
        assertEquals("Riga", invoice.getAddress().getCity());
        assertEquals("1057", invoice.getAddress().getPostCode());
        assertEquals("Rigas", invoice.getAddress().getStreet());
        assertEquals(2, invoice.getInvoiceLines().size());
        assertEquals((Double) 10.0, invoice.getInvoiceLines().get(0).getPrice());
        assertEquals((Double) 1000.0, invoice.getInvoiceLines().get(1).getPrice());
        assertEquals("PC", invoice.getInvoiceLines().get(0).getProduct());
        assertEquals("Macbook", invoice.getInvoiceLines().get(1).getProduct());
    }

}
