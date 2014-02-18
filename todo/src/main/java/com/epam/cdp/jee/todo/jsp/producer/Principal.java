package com.epam.cdp.jee.todo.jsp.producer;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Named;

@SessionScoped
@Named
public class Principal implements Serializable {

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public void onLogIn(@Observes(notifyObserver = Reception.ALWAYS) final Principal principal) {
        this.login = principal.getLogin();
    }
}
