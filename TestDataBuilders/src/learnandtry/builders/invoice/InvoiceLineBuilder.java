package learnandtry.builders.invoice;


public class InvoiceLineBuilder {

    private String product = "Moloko";
    private Double price = 50.0;


    public InvoiceLineBuilder withProduct(String product) {
        this.product = product;
        return this;
    }

    public InvoiceLineBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }

    public InvoiceLine build() {
        InvoiceLine invoice = new InvoiceLine();
        invoice.setPrice(price);
        invoice.setProduct(product);
        return invoice;
    }

    public static InvoiceLineBuilder anInvoiceLine() {
        return new InvoiceLineBuilder();
    }
}
