package advertisement.config.service;

import advertisement.model.ForRent;

import java.util.List;

public interface ForRentService {

    List<ForRent> search(SearchDTO searchCriteria);
}
