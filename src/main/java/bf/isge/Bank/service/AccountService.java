package bf.isge.Bank.service;


import bf.isge.Bank.dto.AccountDto;
import bf.isge.Bank.model.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findById(int id);
    Account addAccount(Account account);
    Account updateAccount(Account account);
    Account findByCountNum(int countNum);

}
