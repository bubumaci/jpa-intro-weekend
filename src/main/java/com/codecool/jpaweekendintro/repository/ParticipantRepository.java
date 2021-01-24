package com.codecool.jpaweekendintro.repository;

import com.codecool.jpaweekendintro.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
