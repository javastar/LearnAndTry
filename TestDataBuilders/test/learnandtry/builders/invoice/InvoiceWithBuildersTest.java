package learnandtry.builders.invoice;

import org.junit.Test;

import static learnandtry.builders.invoice.AddressBuilder.anAddress;
import static learnandtry.builders.invoice.InvoiceBuilder.anInvoice;
import static learnandtry.builders.invoice.InvoiceLineBuilder.anInvoiceLine;
import static org.junit.Assert.assertEquals;


public class InvoiceWithBuildersTest {

    @Test
    public void testWithBuilders() {
        Invoice invoice =
                anInvoice()
                        .with(anAddress()
                                .withCity("Riga")
                                .withPostcode("1057")
                        )
                        .with(anInvoiceLine()
                                .withPrice(10.0)
                                .withProduct("PC")
                        )
                        .with(anInvoiceLine()
                                .withPrice(1000.0)
                                .withProduct("Macbook")

                        )
                .build();

        assertInvoiceIsCorrect(invoice);
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
