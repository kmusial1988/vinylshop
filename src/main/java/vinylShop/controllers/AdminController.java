package vinylShop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vinylShop.dataBase.IVinylRepository;
import vinylShop.model.Vinyl;
import vinylShop.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Autowired
    IVinylRepository vinylRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {

        if(!this.sessionObject.isLogged()){
            return "redirect:/login";
        }

        model.addAttribute("info", this.sessionObject.getInfo());
        model.addAttribute("user", this.sessionObject.getUser());
        model.addAttribute("vinyl", new Vinyl());
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Vinyl vinyl) {

        if(!this.sessionObject.isLogged()){
            return "redirect:/login";
        }

        Vinyl vinylsFromDB = this.vinylRepository.getVinylByISBN(vinyl.getIsbn());

        if (vinylsFromDB != null) {
            vinylsFromDB.setPieces(vinylsFromDB.getPieces() + vinyl.getPieces());
            this.sessionObject.setInfo("Zwiększono ilość sztuk !!!");
        } else {
            if (vinyl.getTitle().equals("") || vinyl.getAuthor().equals("") || vinyl.getIsbn().equals("") || vinyl.getPrice() == 0.0) {
                this.sessionObject.setInfo("Uzupełnij formularz!!!");
            } else {
                this.vinylRepository.addnyl(vinyl);
                this.sessionObject.setInfo("Dodano nową płyte !!!");
            }
        }
        return "redirect:/addProduct";


    }

    @RequestMapping(value = "/editVinyl/{isbn}", method = RequestMethod.GET)
    public  String editVinylPage(@PathVariable String isbn, Model model) {

        Vinyl vinyl = this.vinylRepository.getVinylByISBN(isbn);
        model.addAttribute("vinyl", vinyl);
        model.addAttribute(this.sessionObject.getUser());

        return "editVinyl";
    }
    @RequestMapping(value = "/editVinyl/{isbn}", method = RequestMethod.POST)
    public  String editVinyl(@ModelAttribute Vinyl vinyl, @PathVariable String isbn) {

        Vinyl vinylFromDB = this.vinylRepository.getVinylByISBN(isbn);
        vinylFromDB.setPieces(vinyl.getPieces());
        vinylFromDB.setPrice(vinyl.getPrice());

        return "redirect:/main";

    }
}


