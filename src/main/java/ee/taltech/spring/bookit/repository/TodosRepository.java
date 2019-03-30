package ee.taltech.spring.bookit.repository;

import ee.taltech.spring.bookit.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TodosRepository extends JpaRepository<Todo, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
    value = "UPDATE todos set done = true WHERE id=?")
    void setTodoDone(Long id);
}
