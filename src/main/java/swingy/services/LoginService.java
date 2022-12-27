package swingy.services;

import swingy.forms.LoginForm;
import swingy.models.User;

public interface LoginService {

    boolean loginUser(LoginForm form);
}
