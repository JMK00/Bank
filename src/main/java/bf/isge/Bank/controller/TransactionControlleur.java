package bf.isge.Bank.controller;

import bf.isge.Bank.model.Account;
import bf.isge.Bank.model.Transaction;
import bf.isge.Bank.service.AccountImpl;
import bf.isge.Bank.service.AccountService;
import bf.isge.Bank.service.TransacService;
import bf.isge.Bank.service.TransactionImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller


public class TransactionControlleur {

    AccountService countservice = new AccountImpl();

    TransacService transacService = new TransactionImpl();

    @RequestMapping(value = "/virement", method = RequestMethod.POST)
    public String virement (Model model, Transaction transaction,@RequestParam("destNum") int destNum, HttpSession httpSession){
            Account account = countservice.findByCountNum(destNum);
        if(account.equals(null)){
            throw new RuntimeException("not found");
        }else
        {
            Account count1 =(Account) httpSession.getAttribute("account");
            Account count2 = account;
            count1.setBalance(count1.getBalance()-transaction.getMontantTran());
            count2.setBalance(count2.getBalance()+transaction.getMontantTran());
            transaction.setDate(LocalDateTime.now());
            countservice.updateAccount(count1);
            countservice.updateAccount(count2);

            transacService.addTransaction(transaction);
            model.addAttribute("transaction", transaction);
        }
        return "accueil";///acceuil

    }


}
