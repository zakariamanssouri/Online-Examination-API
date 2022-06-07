package ma.enset.api.repositories;

import ma.enset.api.entities.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}