package vinylShop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vinylShop.dataBase.IVinylRepository;
import vinylShop.model.Vinyl;
import vinylShop.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class BasketController {

    @Autowired
    IVinylRepository vinylRepository;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/addToBasket/{isbn}", method = RequestMethod.GET)
    public String addVinylToBasket(@PathVariable String isbn){

        //TODO odejmowanie ilości, nie może dodać jak jest 0
        for(Vinyl vinyl : this.sessionObject.getBasket()) {
            if(vinyl.getIsbn().equals(isbn)){
                vinyl.setPieces(vinyl.getPieces()+1);
                return "redirect:/main";
            }
        }

        Vinyl vinyl = (Vinyl) this.vinylRepository.getVinylByISBN(isbn).clone();
        vinyl.setPieces(1);
        sessionObject.getBasket().add(vinyl);


        return "redirect:/main";
    }
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(Model model){
        model.addAttribute("vinyls",this.sessionObject.getBasket());
        model.addAttribute("user", this.sessionObject.getUser());
        double bill = 0;
        for(Vinyl vinyl : this.sessionObject.getBasket()){
            bill = bill + vinyl.getPrice() * vinyl.getPieces();
        }
        model.addAttribute("bill", bill);
        return "basket";
    }

}
