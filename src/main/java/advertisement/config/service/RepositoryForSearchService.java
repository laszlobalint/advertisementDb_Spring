package advertisement.config.service;

import advertisement.config.search.SearchDTO;
import advertisement.config.search.SearchType;
import advertisement.dao.ForSearchRepository;
import advertisement.model.ForSearch;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

public class RepositoryForSearchService implements ForSearchService{

    @Resource
    private ForSearchRepository forSearchRepository;

    @Transactional
    @Override
    public List<ForSearch> search(SearchDTO searchCriteria) {
        Long searchTerm = searchCriteria.getSearchTerm();
        SearchType searchType = searchCriteria.getSearchType();

        if (searchType == null) {
            throw new IllegalArgumentException();
        }
        return findForSearchBySearchType(searchTerm, searchType);
    }

    private List<ForSearch> findForSearchBySearchType(Long searchTerm, SearchType searchType) {
        List<ForSearch> forSearches = null;
        if (searchType == SearchType.QUERY_ANNOTATION) {
            forSearches = forSearchRepository.find(searchTerm);
        } else {
            System.out.println("No search result.");
        }
        return forSearches;
    }
}