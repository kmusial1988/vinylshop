package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vinylShop.dataBase.IUserRepository;
import vinylShop.model.User;

@Controller
public class UserController {

    @Autowired
    IUserRepository userRepository;
    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginFrom(Model model){
        model.addAttribute("userModel", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authentication(@ModelAttribute User user){

        userRepository.authentication(user);

        boolean autResult = userRepository.authentication(user);

        if(autResult){
            return "redirect:/main";
        }else{
            return "redirect:/login";
        }


    }

}
