package vinylShop.dataBase;

import vinylShop.model.User;


public interface IUserRepository {
    User authentication(User user);
    User updateUserData (User user);
    User updateUserPass (User user);
}
