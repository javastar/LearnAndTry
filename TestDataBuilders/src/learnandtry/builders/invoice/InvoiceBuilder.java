package learnandtry.builders.invoice;

import java.util.ArrayList;
import java.util.List;


public class InvoiceBuilder {

    private Address address;
    private List<InvoiceLine> invoiceLines = new ArrayList <InvoiceLine>();


    public static InvoiceBuilder anInvoice() {
        return new InvoiceBuilder();
    }

    public Invoice build() {
        Invoice invoice = new Invoice();
        invoice.setAddress(address);
        invoice.setInvoiceLines(invoiceLines);
        return invoice;
    }

    public InvoiceBuilder with(AddressBuilder addressBuilder) {
        address = addressBuilder.build();
        return this;
    }

    public InvoiceBuilder with(InvoiceLineBuilder invoiceLineBuilder ) {
        invoiceLines.add(invoiceLineBuilder.build());
        return this;
    }

}
