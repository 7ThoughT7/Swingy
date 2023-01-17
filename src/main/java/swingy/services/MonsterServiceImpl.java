package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.repos.MonsterRepo;

@RequiredArgsConstructor
@Component
public class MonsterServiceImpl implements MonsterService{

    private final MonsterRepo monsterRepo;


}
