package swingy.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.repos.UserRepo;
import swingy.services.serviceRepo.UserService;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

}