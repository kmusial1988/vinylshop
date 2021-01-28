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
        this.vinyl.add(new Vinyl("Sounds Like Teen Spirit","Nirvana ", 10, "366-874-42" ,29.99));
        this.vinyl.add(new Vinyl("Bon Jovi","Bon Jovi ", 15, "203-573-20" ,49.99));
        this.vinyl.add(new Vinyl("Mother's Milk ","Red Hot Chili Peppers  ", 20, "654-367-95" ,39.99));
        this.vinyl.add(new Vinyl("Americana","The Offspring  ", 17, "207-007-23" ,35.99));

    }

    @Override
    public List<Vinyl> getAllVinyl() {
        return this.vinyl;
    }
}
