package bankbranch;

import java.util.ArrayList;
import java.util.List;

public class BanksManager {
    public static List<BankBranchMain> AVAILABLE_BANK_BRANCH_MAINS = new ArrayList<>();


    public boolean addBranch(BankBranchMain bankBranchMain) {
        return checkIfBranchExists(bankBranchMain);
    }

    private boolean checkIfBranchExists(BankBranchMain bankBranchMain) {
        if (AVAILABLE_BANK_BRANCH_MAINS.stream().noneMatch(branch -> branch.getBranchName().equals(bankBranchMain.getBranchName()))) {
            addBranchBecauseNotExists(bankBranchMain);
            return true;
        }
        return false;
    }
    private void addBranchBecauseNotExists(BankBranchMain bankBranchMain) {
        AVAILABLE_BANK_BRANCH_MAINS.add(bankBranchMain);
    }


}
