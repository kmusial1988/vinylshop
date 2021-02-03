package vinylShop.dataBase.impl;

import org.springframework.stereotype.Component;
import vinylShop.dataBase.IVinylRepository;
import vinylShop.model.Vinyl;

import java.util.ArrayList;
import java.util.List;


@Component
public class ListVinylRepositoryImpl implements IVinylRepository {


    private final List<Vinyl> vinyl = new ArrayList<>();

    public ListVinylRepositoryImpl() {
        this.vinyl.add(new Vinyl("Sounds Like Teen Spirit","Nirvana ", 10, "366-874-42" ,29.99, Vinyl.Category.lata90));
        this.vinyl.add(new Vinyl("Bon Jovi","Bon Jovi ", 15, "203-573-20" ,49.99, Vinyl.Category.lata90));
        this.vinyl.add(new Vinyl("Mother's Milk ","Red Hot Chili Peppers  ", 20, "654-367-95" ,39.99, Vinyl.Category.lata00));
        this.vinyl.add(new Vinyl("Americana","The Offspring  ", 17, "207-007-23" ,35.99, Vinyl.Category.lata90));

    }

    @Override
    public List<Vinyl> getAllVinyl() {
        return this.vinyl;
    }

    @Override
    public List<Vinyl> getAllVinyl90() {
        List<Vinyl> vinyl90 = new ArrayList<>();

        for(Vinyl vinyl : this.vinyl){
            if(vinyl.getCategory() == Vinyl.Category.lata90) {
                vinyl90.add(vinyl);
            }
        }

        return vinyl90;
    }

    @Override
    public List<Vinyl> getAllVinyl00() {
        List<Vinyl> vinyl00 = new ArrayList<>();

        for(Vinyl vinyl : this.vinyl){
            if(vinyl.getCategory() == Vinyl.Category.lata00) {
                vinyl00.add(vinyl);
            }
        }

        return vinyl00;
    }

    @Override
    public Vinyl getVinylByISBN(String isbn) {

        for(Vinyl vinyl : this.vinyl) {
            if (vinyl.getIsbn().equals(isbn)) {
                return vinyl;
            }
        }
        return null;
    }

    @Override
    public void addnyl(Vinyl vinyl) {
        this.vinyl.add(vinyl);
    }


}
