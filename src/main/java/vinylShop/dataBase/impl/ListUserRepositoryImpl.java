package vinylShop.dataBase.impl;

import org.springframework.stereotype.Component;
import vinylShop.dataBase.IUserRepository;
import vinylShop.model.User;

import java.util.ArrayList;
import java.util.List;


public class ListUserRepositoryImpl implements IUserRepository {

    private final List<User> userList = new ArrayList<>();

    public ListUserRepositoryImpl() {
        this.userList.add(new User("kamil","kamil","admin", "admin",User.Role.ADMIN));
        this.userList.add(new User("Jan","Kowalski","jan", "jan",User.Role.USER));
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

    @Override
    public User updateUserData(User user) {
        for(User userFromDB : this.userList) {
            if(userFromDB.getLogin().equals(user.getLogin())) {
                userFromDB.setName(user.getName());
                userFromDB.setSurname(user.getSurname());
                return userFromDB;
            }
        }
        return null;
    }

    @Override
    public User updateUserPass(User user) {

        for(User userFromDB : this.userList){

            if(userFromDB.getLogin().equals(user.getLogin())){
                userFromDB.setPass(user.getPass());
                return userFromDB;
            }
        }

        return null;
    }

    @Override
    public boolean checkIfLoginExist(String login) {
        for(User userFromDB : this.userList ) {
            if (userFromDB.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(User user) {

        this.userList.add(user);
    }
}
