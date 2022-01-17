package bf.isge.Bank.controller;

import bf.isge.Bank.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@AllArgsConstructor
public class HomeController {

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)

    public String home(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

    return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)

    public String login(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

        return "login";
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)

    public String register(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

        return "register";
    }

}
