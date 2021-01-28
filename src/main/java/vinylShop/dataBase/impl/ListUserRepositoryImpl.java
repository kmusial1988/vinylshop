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
        this.userList.add(new User("admin", "admin"));
    }

    @Override
    public boolean authentication(User user) {
        for (User userFromDataBase : this.userList) {
            if (userFromDataBase.getLogin().equals(user.getLogin())) {
                if (userFromDataBase.getPass().equals(user.getPass())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
