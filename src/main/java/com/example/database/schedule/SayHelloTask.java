package com.example.database.schedule;

import com.example.database.repo.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SayHelloTask {

    private static final Logger LOG = LoggerFactory.getLogger(SayHelloTask.class);

    @Autowired
    ProfileRepository profileRepository;

    //@Scheduled(fixedRate = 1000)
    public void schedulerToRunEverySec() {
        long l = new Random().nextLong();
        //profileRepository.save(new Profile(l, "Narendra", "Kadiri", "nkadiri" + l + "", "Password" + l));
        LOG.info("Hello from our simple scheduled method");
    }
}