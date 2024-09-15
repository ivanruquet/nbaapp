package com.ruquet.nbaapp.Repository;
import com.ruquet.nbaapp.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {
}
