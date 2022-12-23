package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import swingy.domain.User;
import swingy.forms.RegistrationForm;
import swingy.repos.UserRepo;

@RequiredArgsConstructor
@Component
public class RegistrationServiceImpl implements RegistrationService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;


    @Override
    public void registrationUser(RegistrationForm form) {
        User user = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();

        userRepo.save(user);
    }
}
