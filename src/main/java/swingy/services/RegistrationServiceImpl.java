package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.models.User;
import swingy.forms.RegistrationForm;
import swingy.repos.UserRepo;

@RequiredArgsConstructor
@Component
public class RegistrationServiceImpl implements RegistrationService{

    private final UserRepo userRepo;


    @Override
    public void registrationUser(RegistrationForm form) {
        User user = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .role(User.Role.USER)
                .password(form.getPassword())
                .build();

        userRepo.save(user);
    }
}
