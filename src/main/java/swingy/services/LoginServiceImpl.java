package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.forms.LoginForm;
import swingy.models.User;
import swingy.repos.UserRepo;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class LoginServiceImpl implements LoginService{

    private final UserRepo userRepo;


    @Override
    public boolean loginUser(LoginForm form) {
        User user = userRepo.findByEmail(form.getEmail());
        return user != null && Objects.equals(user.getPassword(), form.getPassword());
    }
}
