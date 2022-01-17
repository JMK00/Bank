package bf.isge.Bank.service;


import bf.isge.Bank.model.Account;
import bf.isge.Bank.dto.AccountDto;
import bf.isge.Bank.repository.AccountsRepo;
import bf.isge.Bank.repository.RepositoryAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountImpl implements AccountService{
    @Autowired
    public AccountsRepo accountRepository;
    @Autowired
    public RepositoryAccount repositoryaccount;

    @Override
    public Optional<Account> findById(int accountId) {
        return Optional.empty();
    }


    public int generateAccount(){
        int number = 100000;
        Random rnd = new Random();
        boolean isAllowed = true;
        Iterable<Account> accounts = this.findAllAccount();

        while (isAllowed){
            isAllowed=false;
            number = rnd.nextInt(899999) + 100000;
            for(Account compte:accounts){
                if(compte.getCountNum()==number) isAllowed=true;
            }

        }
        return number;
    }

    @Override
    public Account addAccount(Account account) {
       // Account accounts=new Account();
       // accountDto.setBalance(100000);


        return repositoryaccount.save(account);

    }


   // public Iterable<Account> findAllAccount() {
     //   return repositoryaccount.findAll();    }

    @Override
    public Account updateAccount(Account account) {
        return repositoryaccount.save(account);
    }

    @Override
    public Account findByCountNum(int countNum) {

        return accountRepository.findByCountNum(countNum);
    }


    public Iterable<Account> findAllAccount() {
        return repositoryaccount.findAll();    }

    public Account findAccount(int id)
    {
        Iterable<Account> accounts=findAllAccount();
        Account cmpt=new Account();
        for(Account account: accounts) {
            if (account.getUsers().getId()==id)
            {
                cmpt=account;
            }

        }
        return cmpt;
    }


}
