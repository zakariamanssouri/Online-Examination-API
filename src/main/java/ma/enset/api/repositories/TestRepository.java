package ma.enset.api.repositories;

import ma.enset.api.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Long>{

}
