package advertisement.config.service;

import advertisement.config.search.SearchDTO;
import advertisement.model.ForRent;

import java.util.List;

public interface ForRentService {

    List<ForRent> search(SearchDTO searchCriteria);
}
