package com.codecool.jpaweekendintro.service;

import com.codecool.jpaweekendintro.entity.Meeting;
import com.codecool.jpaweekendintro.entity.Participant;
import com.codecool.jpaweekendintro.repository.MeetingRepository;
import com.codecool.jpaweekendintro.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MeetingService {


    @Autowired
    MeetingRepository meetingRepository;


    @Autowired
    ParticipantRepository participantRepository;

    public Pair<List<Meeting>, List<Participant>> getAllMeetings() {

        return Pair.of(meetingRepository.findAll(Sort.by("date")), participantRepository.findAll());
    }

    public List<Meeting> getMeetingBeforeDate(LocalDate date) {
        return meetingRepository.findMeetingByDateBefore(date);
    }

    public List<String> getTitles() {
        return meetingRepository.findTitles("s");
    }
}
