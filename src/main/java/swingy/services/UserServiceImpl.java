package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.repos.UserRepo;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

}