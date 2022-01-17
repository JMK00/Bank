package bf.isge.Bank.controller;


import bf.isge.Bank.dto.AccountDto;
import bf.isge.Bank.controller.HomeController;
import bf.isge.Bank.dto.UserDto;
import bf.isge.Bank.model.Account;
import bf.isge.Bank.model.User;
import bf.isge.Bank.service.AccountImpl;
import bf.isge.Bank.service.UsersImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@AllArgsConstructor
public class AccountController {
    @Autowired
    AccountImpl accountImpl;
    @Autowired
    UsersImpl usersImpl;

    @RequestMapping(value = "/accounts/save", method = RequestMethod.POST)
    public Account add(@RequestBody Account account){
        this.accountImpl.addAccount(account);
        return null;
    }

    @RequestMapping(value = {"/countNum"}, method = RequestMethod.POST)
    public String countNum(Model model, @ModelAttribute("userDto") UserDto userDto, HttpSession httpSession){
        String a=userDto.getPassword();
        userDto=(UserDto) httpSession.getAttribute("userDto");
        userDto.setPassword(a);
        User user=usersImpl.adUser(userDto,model);
        Account account = new Account();
        account.setCountNum(accountImpl.generateAccount());
        account.setBalance(100000);
        account.setUsers(user);
        accountImpl.addAccount(account);


        httpSession.setAttribute("account",account);
        model.addAttribute("userDto", userDto);

        model.addAttribute("account",account);
        return afficher(model);

    }

    @RequestMapping(value = {"/A"}, method = RequestMethod.GET)
    public String afficher(Model model){
        return "index";
    }


}
