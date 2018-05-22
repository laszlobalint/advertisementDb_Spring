package advertisement.dao;

import advertisement.model.ForSale;
import advertisement.model.ForSearch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ForSaleRepository extends CrudRepository<ForSale, Long> {

    @Query("SELECT f FROM ForSale f WHERE f.userId = :userId")
    List<ForSale> find(@Param("userId") Long userId);

    @Query("SELECT f FROM ForSale f WHERE f.id = :id")
    List<ForSale> findAd(@Param("id") Long id);
}
