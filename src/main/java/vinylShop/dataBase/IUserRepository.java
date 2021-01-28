package vinylShop.dataBase;

import vinylShop.model.User;

public interface IUserRepository {
    boolean authentication(User user);
}
