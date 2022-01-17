package bf.isge.Bank.repository;


import bf.isge.Bank.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository <User, Integer> {

    User findByEmail(String email);
    User findByEmailAndPassword(String email,String password);

    //Users findByName(String firstname, String lastname);

   // @Query("SELECT coalesce(max(e.id), 0) FROM Users e")
    //Long getMaxId();
}
