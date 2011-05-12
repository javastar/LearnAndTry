package learnandtry.builders.account;


public class AccountBuilder {

    private String name = "DEFAULT_NAME";
    private String id = "DEFAULT_ID";
    private AccountStatus status = AccountStatus.ACTIVE;
    private Company company;

    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }
    private AccountBuilder() {}


    public Account build() {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setStatus(status);
        account.setCompany(company);
        return account;
    }

    public AccountBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AccountBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public AccountBuilder with(AccountStatus status) {
        this.status = status;
        return this;
    }

    public AccountBuilder with(CompanyBuilder companyBuilder) {
        this.company = companyBuilder.build();
        return this;
    }

}
