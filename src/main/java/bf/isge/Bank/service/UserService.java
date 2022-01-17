package bf.isge.Bank.service;

import bf.isge.Bank.model.User;
import bf.isge.Bank.dto.UserDto;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    User addUser(UserDto userDto);
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    User findByEmail(String email);
}
