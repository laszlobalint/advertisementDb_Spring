package advertisement.config.service;

import advertisement.model.ForSearch;

import java.util.List;

public interface ForSearchService {

    List<ForSearch> search(SearchDTO searchCriteria);
}
