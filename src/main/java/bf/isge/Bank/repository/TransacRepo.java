package bf.isge.Bank.repository;

import bf.isge.Bank.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransacRepo extends CrudRepository<Transaction,Integer> {
}
