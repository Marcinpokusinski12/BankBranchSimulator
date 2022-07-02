import account.AccountManager
import bankbranch.Bank
import spock.lang.Specification

class AccountManagerTest extends Specification{

    def "Add Account to existing Bank"() {
        given:
        def bank = Bank.createNewBank("Bank", "glowny", "email")
        def account = new AccountManager()

        when:
        account.createUserAccount("Test", 2.0 ,"123123123",  bank)

        then:
        bank.getUserAccounts().forEach(x -> x.accountOwner == "Test")
    }

    def "Deposit money to account"() {
        given:
        def account = new AccountManager().createUserAccount("Test", 100.0, "123123123", Bank.createNewBank("Bank", "glowny","email"))
        def accountManager = new AccountManager()

        when:
        accountManager.depositMoneyToAccount(account, 100);

        then:
        account.getBalance() == 200;
    }


}
