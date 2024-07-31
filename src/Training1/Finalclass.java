package Training1;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Finalclass {

    @Test
    
    
    public void testAPI() {
        AccountList accounts = new AccountList();
        List<Account> accountList = accounts.getAccounts();

        Account account1 = new Account();
        account1.setAccountNumber(111);
        account1.setBalance(20.34);
        account1.setFirstName("Anup");
        account1.setLast_Name("Kumar");
        account1.setEmail("anup@gmail.com");
        account1.setGender("Male");

        Account account2 = new Account();
        account2.setAccountNumber(123);
        account2.setBalance(20.31);
        account2.setFirstName("Deepak");
        account2.setLast_Name("Kumar");
        account2.setEmail("anup12@gmail.com");
        account2.setGender("Male");

        accountList.add(account1);
        accountList.add(account2);

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(accounts)
                .post("https://your-api-url.com");

        response.prettyPrint();
    }
}
