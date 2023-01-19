package swingy.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.repos.MonsterRepo;
import swingy.services.serviceRepo.MonsterService;

@RequiredArgsConstructor
@Component
public class MonsterServiceImpl implements MonsterService {

    private final MonsterRepo monsterRepo;


}
