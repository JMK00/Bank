package bf.isge.Bank.repository;

import bf.isge.Bank.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AccountsRepo extends JpaRepository<Account, Integer> {
   // Account findById();
    //Account findAllAccount();
   @Transactional
   public Account findByCountNum(int countNum);
}
