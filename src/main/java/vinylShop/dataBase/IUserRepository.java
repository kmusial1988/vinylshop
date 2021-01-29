package vinylShop.dataBase;

import vinylShop.model.User;

public interface IUserRepository {
    User authentication(User user);
}
