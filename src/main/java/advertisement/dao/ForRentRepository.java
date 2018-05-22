package advertisement.dao;

import advertisement.model.ForRent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ForRentRepository extends CrudRepository<ForRent, Long> {

    @Query("SELECT f FROM ForRent f WHERE f.userId = :userId")
    List<ForRent> find(@Param("userId") Long userId);
}
