package vinylShop.model;

import javax.management.relation.Role;

public class User {

    private String name;
    private String surname;
    private String login;
    private String pass;
    private Role role;

    public User() {
    }

    public User(String name, String surname, String login, String pass, Role role) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {

        USER,
        ADMIN
    }
}
