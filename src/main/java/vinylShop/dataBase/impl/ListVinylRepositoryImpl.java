package vinylShop.dataBase.impl;

import org.springframework.stereotype.Component;
import vinylShop.dataBase.IVinylRepository;
import vinylShop.model.Vinyl;

import java.util.ArrayList;
import java.util.List;


@Component
public class ListVinylRepositoryImpl implements IVinylRepository {


    private final List<Vinyl> vinyls = new ArrayList<>();

    public ListVinylRepositoryImpl() {
        this.vinyls.add(new Vinyl("Sounds Like Teen Spirit","Nirvana ", 10, "36687442" ,29.99));
        this.vinyls.add(new Vinyl("Bon Jovi","Bon Jovi ", 15, "20357320" ,49.99));
        this.vinyls.add(new Vinyl("Mother's Milk ","Red Hot Chili Peppers  ", 20, "65453629" ,39.99));
        this.vinyls.add(new Vinyl("Americana","The Offspring  ", 17, "20770020" ,35.99));

    }

    @Override
    public List<Vinyl> getAllBooks() {
        return this.vinyls;
    }
}
