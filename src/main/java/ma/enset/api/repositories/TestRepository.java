package ma.enset.api.repositories;

import ma.enset.api.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,Long>{
    Test findByCode(String string);
    Test findById(long id);

    @Query(value = "select t from Test t where t.name like %:keyword%")
    List<Test> findByNameContaining(String keyword);
}
