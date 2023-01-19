package swingy.services.serviceRepo;

import swingy.forms.LoginForm;
import swingy.models.User;

public interface LoginService {

    boolean loginUser(LoginForm form);
}
