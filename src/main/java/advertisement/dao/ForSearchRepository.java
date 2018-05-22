package advertisement.dao;

import advertisement.model.ForSearch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ForSearchRepository extends CrudRepository<ForSearch, Long> {

    @Query("SELECT f FROM ForSearch f WHERE f.userId = :userId")
    List<ForSearch> find(@Param("userId") Long userId);
}
