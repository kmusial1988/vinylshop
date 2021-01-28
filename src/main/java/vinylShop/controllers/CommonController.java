package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vinylShop.dataBase.IVinylRepository;
import vinylShop.model.Vinyl;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IVinylRepository vinylRepository;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {


        model.addAttribute("vinyls", this.vinylRepository.getAllVinyl());


        return "main";
    }
}
