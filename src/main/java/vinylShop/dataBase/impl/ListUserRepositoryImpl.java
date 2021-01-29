package vinylShop.dataBase.impl;

import org.springframework.stereotype.Component;
import vinylShop.dataBase.IUserRepository;
import vinylShop.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListUserRepositoryImpl implements IUserRepository {

    private final List<User> userList = new ArrayList<>();

    public ListUserRepositoryImpl() {
        this.userList.add(new User("kamil","kamil","admin", "admin"));
    }

    @Override
    public User authentication(User user) {
        for (User userFromDataBase : this.userList) {
            if (userFromDataBase.getLogin().equals(user.getLogin())) {
                if (userFromDataBase.getPass().equals(user.getPass())) {
                    return userFromDataBase;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
