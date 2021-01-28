package vinylShop.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import vinylShop.model.Vinyl;

import java.util.List;
@Component
@SessionScope
public class SessionObject {
    private boolean isLogged = false;

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
