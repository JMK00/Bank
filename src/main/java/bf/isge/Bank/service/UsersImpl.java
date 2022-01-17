package bf.isge.Bank.service;


import bf.isge.Bank.repository.UsersRepo;
import bf.isge.Bank.model.User;
import bf.isge.Bank.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class UsersImpl implements UserService{
    @Autowired
    UsersRepo usersRepo;

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public User addUser(UserDto userDto) {
        return null;
    }


    public User adUser(UserDto userDto, Model model) {
        User users= new User();
        model.addAttribute("userDto");
        users.setFirstName(userDto.getFirstName());
        users.setLastName(userDto.getLastName());
        users.setPassword(userDto.getPassword());
        users.setEmail(userDto.getEmail());
        users.setDateNaissance(userDto.getDateNaissance());
        users.setTel(userDto.getTel());
        //users.setBirthday(userdto.getBirthday());
        users.setNationalite(userDto.getNationalite());
        usersRepo.save(users);
        return users;
    }

   @Override
    public User findByFirstName(String firstName){
        return null;
    }

    @Override
    public User findByLastName(String lastName) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return usersRepo.findByEmail(email);
    }

    public User findByEmailAndPassword(String email,String password) {
        return usersRepo.findByEmailAndPassword(email, password);
    }
}
