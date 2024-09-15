package com.ruquet.nbaapp.Repository;
import com.ruquet.nbaapp.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
