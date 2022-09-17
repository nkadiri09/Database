package com.example.database.schedule;

import com.example.database.entity.UserEntity;
import com.example.database.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SayHelloTask {

    private static final Logger LOG = LoggerFactory.getLogger(SayHelloTask.class);

    @Autowired
    UserRepository userRepository;

    //@Scheduled(fixedRate = 10000)
    public void sayHello() {
        long l = new Random().nextLong();
        userRepository.save(new UserEntity(l, "Narendra", "Kadiri", "nkadiri" + l + "", "Password" + l));
        LOG.info("Hello from our simple scheduled method");
    }
}