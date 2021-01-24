package com.codecool.jpaweekendintro.controller;

import com.codecool.jpaweekendintro.entity.Meeting;
import com.codecool.jpaweekendintro.entity.Participant;
import com.codecool.jpaweekendintro.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping("/meetings/all")
    public Pair<List<Meeting>, List<Participant>> showMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/meetings/titles")
    public List<String> showMeetingTitles() {
        return meetingService.getTitles();
    }

    @GetMapping("/meetings/before/{date}")
    public List<Meeting> showMeetingsBefore(@PathVariable String date) {
        LocalDate localDate= LocalDate.parse(date);
        return meetingService.getMeetingBeforeDate(localDate);
    }
}
