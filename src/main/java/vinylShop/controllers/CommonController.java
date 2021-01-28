package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vinylShop.dataBase.IVinylRepository;
import vinylShop.model.Vinyl;
import vinylShop.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;
    @Autowired
    IVinylRepository vinylRepository;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("vinyls", this.vinylRepository.getAllVinyl());

        if (sessionObject.isLogged()) {
            return "main";
        }else {
            return "redirect:/login";
        }

    }
    @RequestMapping(value = "/lata90",method = RequestMethod.GET)
    public String lata90(Model model){
        model.addAttribute("vinyls", this.vinylRepository.getAllVinyl90());

        return "main";

    }

    @RequestMapping(value = "/lata00", method = RequestMethod.GET)
    public String lata00(Model model){
        model.addAttribute("vinyls", this.vinylRepository.getAllVinyl00());

        return "main";

    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam String filter, Model model){

        List<Vinyl> filterVinyl = this.vinylRepository.getVinylByFilter(filter);
        model.addAttribute("vinyls", filterVinyl);

        return "main";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(){


        return "contact";

    }

}
