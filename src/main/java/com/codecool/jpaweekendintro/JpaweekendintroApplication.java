package com.codecool.jpaweekendintro;

import com.codecool.jpaweekendintro.entity.Meeting;
import com.codecool.jpaweekendintro.entity.Participant;
import com.codecool.jpaweekendintro.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaweekendintroApplication {


    @Autowired
    MeetingRepository meetingRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaweekendintroApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Meeting meeting1 = Meeting.builder()
                    .title("Standup")
                    .description("Standup of the daaaay")
                    .date(LocalDate.now())
                    .build();

            Meeting meeting2 = Meeting.builder()
                    .title("Retro")
                    .description("Retro")
                    .date(LocalDate.parse("2021-01-11"))
                    .build();

            Participant susan = Participant.builder()
                    .name("Susan")
                    .build();

            Participant peter = Participant.builder()
                    .name("Peter")
                    .build();

            Participant mary = Participant.builder()
                    .name("Mary")
                    .build();

            Set<Participant> participantSet = new HashSet();
            participantSet.add(susan);
            meeting1.setParticipantCollection(participantSet);

            Set<Participant> participantSetRetro = new HashSet();
            participantSetRetro.add(mary);
            participantSetRetro.add(peter);
            meeting2.setParticipantCollection(participantSetRetro);

            meetingRepository.save(meeting1);
            meetingRepository.save(meeting2);
        };
    }
}
