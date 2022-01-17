package bf.isge.Bank.service;

import bf.isge.Bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public interface TransacService {

    Transaction addTransaction(Transaction transaction);

}
