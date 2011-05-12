package learnandtry.builders.account;

import org.junit.Test;

import static learnandtry.builders.account.AccountBuilder.anAccount;
import static learnandtry.builders.account.CompanyBuilder.aCompany;


public class AccountTest  {

    @Test
    public void accountTest_withCreateMethod() {
        Account account = createAccount("NAME", "ID", AccountStatus.ACTIVE);
    }

    @Test
    public void accountTest_withTestDataBuilder() {
        Account account = anAccount()
                .withId("ID")
                .withName("NAME")
                .with(AccountStatus.ACTIVE).build();
    }

    @Test
    public void accountTest_withTestDataBuilder_CompanyBuilder() {
        Account account = anAccount().with(aCompany()).build();
    }


    @Test
    public void accountTest_withTestDataBuilder_DEFAULT_VALUES() {
        Account account = anAccount().build();
    }


    private Account createAccount(String name, String id, AccountStatus status) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setStatus(status);
        return account;
    }

}
