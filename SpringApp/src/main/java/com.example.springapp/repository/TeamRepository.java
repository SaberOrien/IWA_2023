package com.example.springapp.repository;

import com.example.springapp.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findById(long id);
    Team findByTeamName(String teamName);
}
