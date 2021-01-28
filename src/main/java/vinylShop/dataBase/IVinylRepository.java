package vinylShop.dataBase;

import vinylShop.model.Vinyl;

import java.util.List;

public interface IVinylRepository {
    List<Vinyl> getAllVinyl();
    List<Vinyl> getAllVinyl90();
    List<Vinyl> getAllVinyl00();
    List<Vinyl> getVinylByFilter(String filter);

}
