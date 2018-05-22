package advertisement.config.service;

import advertisement.dao.ForRentRepository;
import advertisement.model.ForRent;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

public class RepositoryForRentService implements ForRentService {

    @Resource
    private ForRentRepository forRentRepository;

    @Transactional
    @Override
    public List<ForRent> search(SearchDTO searchCriteria) {
        Long searchTerm = searchCriteria.getSearchTerm();
        SearchType searchType = searchCriteria.getSearchType();

        if (searchType == null) {
            throw new IllegalArgumentException();
        }
        return findForRentBySearchType(searchTerm, searchType);
    }

    private List<ForRent> findForRentBySearchType(Long searchTerm, SearchType searchType) {
        List<ForRent> forRents = null;
        if (searchType == SearchType.QUERY_ANNOTATION) {
            forRents = forRentRepository.find(searchTerm);
        }
        else {
            System.out.println("No search result.");
        }
        return forRents;
    }
}
