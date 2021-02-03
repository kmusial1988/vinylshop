package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vinylShop.dataBase.IVinylRepository;

import vinylShop.session.SessionObject;
import vinylShop.utils.filterUtils;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;
    @Autowired
    IVinylRepository vinylRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String commonRedirect() {
        return "redirect:/main";

    }


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model, @RequestParam(defaultValue = "none") String category) {
        if (sessionObject.isLogged()) {


            switch (category) {
                case "lata90":
                    model.addAttribute("vinyls", filterUtils.filterVinyls(this.vinylRepository.getAllVinyl90(), this.sessionObject.getFilter()));
                 break;

                case "lata00":

                    model.addAttribute("vinyls", filterUtils.filterVinyls(this.vinylRepository.getAllVinyl00(), this.sessionObject.getFilter()));
                   break;


                default:
                        model.addAttribute("vinyls", filterUtils.filterVinyls(this.vinylRepository.getAllVinyl(), this.sessionObject.getFilter()));
                    break;
            }
            model.addAttribute("user", this.sessionObject.getUser());
            model.addAttribute("filter", this.sessionObject.getFilter());

            return "main";
        } else {
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String filter) {
        if (sessionObject.isLogged()) {

            this.sessionObject.setFilter(filter);
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        if (sessionObject.isLogged()) {

            model.addAttribute("user", this.sessionObject.getUser());
            return "contact";
        } else {
            return "redirect:/login";
        }
    }

}
