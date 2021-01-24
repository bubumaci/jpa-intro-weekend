package com.codecool.jpaweekendintro.repository;

import com.codecool.jpaweekendintro.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface MeetingRepository extends JpaRepository<Meeting,Long> {

    List<Meeting> findMeetingByDateBefore(LocalDate before);

    @Query("SELECT distinct m.title from Meeting m WHERE m.title LIKE :search")
    List<String> findTitles(String search);


}
