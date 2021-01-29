package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vinylShop.dataBase.IVinylRepository;

import vinylShop.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;
    @Autowired
    IVinylRepository vinylRepository;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        if (sessionObject.isLogged()) {
            model.addAttribute("vinyls", this.vinylRepository.getAllVinyl());
            model.addAttribute("user", this.sessionObject.getUser());

            return "main";
        } else {
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/lata90", method = RequestMethod.GET)
    public String lata90(Model model) {
        if (sessionObject.isLogged()) {
            model.addAttribute("vinyls", this.vinylRepository.getAllVinyl90());
            model.addAttribute("user", this.sessionObject.getUser());
            return "main";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/lata00", method = RequestMethod.GET)
    public String lata00(Model model) {
        if (sessionObject.isLogged()) {

            model.addAttribute("vinyls", this.vinylRepository.getAllVinyl00());
            model.addAttribute("user", this.sessionObject.getUser());
            return "main";
        } else {
            return "redirect:/login";
        }
    }


    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String filter, Model model) {
        if (sessionObject.isLogged()) {

            model.addAttribute("vinyls", this.vinylRepository.getVinylByFilter(filter));
            model.addAttribute("user", this.sessionObject.getUser());
            return "main";
        } else {
            return "redirect:/login";
        }
    }

        @RequestMapping(value = "/contact", method = RequestMethod.GET)
        public String contact (Model model){
            if (sessionObject.isLogged()) {

                model.addAttribute("user", this.sessionObject.getUser());
                return "contact";
            } else {
                return "redirect:/login";
            }
        }

    }
