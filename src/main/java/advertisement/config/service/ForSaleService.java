package advertisement.config.service;

import advertisement.model.ForSale;

import java.util.List;

public interface ForSaleService {

    List<ForSale> search(SearchDTO searchCriteria);
}
