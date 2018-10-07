package advertisement.config.service;

import advertisement.config.search.SearchDTO;
import advertisement.model.ForSearch;

import java.util.List;

public interface ForSearchService {

    List<ForSearch> search(SearchDTO searchCriteria);
}
