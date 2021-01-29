package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vinylShop.dataBase.IUserRepository;
import vinylShop.model.User;
import vinylShop.model.view.ChangePassData;
import vinylShop.session.SessionObject;

import javax.annotation.Resource;


@Controller
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginFrom(Model model) {
        model.addAttribute("userModel", new User());
        String info = this.sessionObject.getInfo();
        if(info != null){
            model.addAttribute("info", info);
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authentication(@ModelAttribute User user) {

        userRepository.authentication(user);

        this.sessionObject.setUser(this.userRepository.authentication(user));

        if (this.sessionObject.getUser() != null) {
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Nieprawidłowe Dane !!!");
            return "redirect:/login";
        }


    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setUser(null);
        return "redirect:/login";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        if (this.sessionObject.isLogged()) {
            model.addAttribute("user", this.sessionObject.getUser());
            model.addAttribute("passModel", new ChangePassData());
            String info = this.sessionObject.getInfo();
            if(info != null) {
                model.addAttribute("info", info);
                this.sessionObject.setInfo(null);
            }
            return "edit";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/changeData", method = RequestMethod.POST)
    public String changeData(@ModelAttribute User user) {
        user.setLogin(this.sessionObject.getUser().getLogin());
        User updateUser = this.userRepository.updateUserData(user);
        this.sessionObject.setUser(updateUser);

        return "redirect:/edit";
    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    public String changePass (@ModelAttribute ChangePassData changePassData, Model model) {

        if(!changePassData.getNewPass().equals(changePassData.getRepeatedNewPass())){
           this.sessionObject.setInfo("nieprawidłowo powtórzone hasło !!!");
            return "redirect:/edit";

        }
        User user = new User();
        user.setPass(changePassData.getPass());
        user.setLogin(this.sessionObject.getUser().getLogin());

        User authenticatedUser = this.userRepository.authentication(user);

        if(authenticatedUser == null){

            this.sessionObject.setInfo("nieprawidłowe hasło !!!");
            return "redirect:/edit";
        }

        user.setPass(changePassData.getNewPass());
        User updateUser = this.userRepository.updateUserPass(user);
        this.sessionObject.setUser(updateUser);


        return "redirect:/edit";
    }

}
