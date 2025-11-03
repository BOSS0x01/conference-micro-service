package boss.team.keynoteservice.repositories;

import boss.team.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeynoteRepository extends JpaRepository<Keynote,Long> {
}
