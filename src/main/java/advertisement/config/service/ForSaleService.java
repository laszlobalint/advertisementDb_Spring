package advertisement.config.service;

import advertisement.config.search.SearchDTO;
import advertisement.model.ForSale;

import java.util.List;

public interface ForSaleService {

    List<ForSale> search(SearchDTO searchCriteria);
}
