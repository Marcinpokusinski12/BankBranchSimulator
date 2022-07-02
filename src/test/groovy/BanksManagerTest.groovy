import bankbranch.BankBranchMain
import bankbranch.BanksManager
import spock.lang.Specification

class BanksManagerTest extends Specification{

    def "Add Branch to collection"() {
        given:
        def bankBranch = BankBranchMain.createBankBranch("Second test branch")
        def manager = new BanksManager();

        when:
        boolean value = manager.addBranch(bankBranch);

        then:
        value
    }

    def "is Branch duplicated"() {
        given:
        def bankBranch = BankBranchMain.createBankBranch("Second test branch")
        def bankBranchSecond = BankBranchMain.createBankBranch("Second test branch")
        def manager = new BanksManager()
        manager.addBranch(bankBranch);
        var flag = manager.addBranch(bankBranchSecond);


        expect:
        !flag
    }

}
