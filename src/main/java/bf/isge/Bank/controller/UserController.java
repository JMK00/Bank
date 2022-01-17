package bf.isge.Bank.controller;


import bf.isge.Bank.model.Account;
import bf.isge.Bank.model.Transaction;
import bf.isge.Bank.service.AccountImpl;
import bf.isge.Bank.service.UsersImpl;
import bf.isge.Bank.model.User;
import bf.isge.Bank.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@AllArgsConstructor
public class UserController {
    @Autowired
    AccountImpl accountImpl;
    @Autowired
    UsersImpl usersImpl;


    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public User add(@RequestBody UserDto userdto){
        User user = new User();
        usersImpl.addUser(userdto);
        return null;
    }

    @RequestMapping(value = "/users/getClient", method = RequestMethod.GET)
    public User getterByMail(@RequestParam("email") String email){

        return usersImpl.findByEmail(email);
    }

    @RequestMapping(value = {"/enregistrement"}, method = RequestMethod.POST)
    public String adduser (Model model, @ModelAttribute("userDto") UserDto userDto, HttpSession httpSession){
       // User user=usersImpl.adUser(userDto,model);
        //userDto.setPassword(user.getPassword());
        model.addAttribute("userDto",userDto);
        httpSession.setAttribute("userDto", userDto);

        return addrecup(model);
    }

    @RequestMapping(value = {"/recup"}, method = RequestMethod.GET)
    public String addrecup (Model model){
        return "recup";
    }

    @RequestMapping(value = {"/authentification"}, method = RequestMethod.POST)
    public String compare (Model model, @ModelAttribute("userDto") UserDto userDto, HttpSession httpSession){
        if(usersImpl.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword())!=null)
        {
            model.addAttribute("account", (Account) httpSession.getAttribute("account") );

            User user=usersImpl.findByEmailAndPassword(userDto.getEmail(),userDto.getPassword());
            Transaction transaction=new Transaction();
            model.addAttribute("user",user);
            model.addAttribute("transaction",transaction);
            httpSession.setAttribute("account",accountImpl.findAccount(user.getId()));
            return "accueil";////page acceuil pour user a creer
        }

        else {return "index";}
    }


}
