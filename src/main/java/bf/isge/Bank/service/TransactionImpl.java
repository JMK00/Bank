package bf.isge.Bank.service;

import bf.isge.Bank.model.Transaction;

import bf.isge.Bank.repository.TransacRepo;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import java.util.Optional;


public class TransactionImpl implements TransacService  {
    @Autowired
    TransacRepo transacRepo;




    public Transaction addTransaction(Transaction transaction) {

        return transacRepo.save(transaction);
    }
}
