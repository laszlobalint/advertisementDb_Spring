package advertisement.config.service;

import advertisement.config.search.SearchDTO;
import advertisement.config.search.SearchType;
import advertisement.dao.ForSaleRepository;
import advertisement.model.ForSale;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

public class RepositoryForSaleService implements ForSaleService {

    @Resource
    private ForSaleRepository forSaleRepository;

    @Transactional
    @Override
    public List<ForSale> search(SearchDTO searchCriteria) {
        Long searchTerm = searchCriteria.getSearchTerm();
        SearchType searchType = searchCriteria.getSearchType();

        if (searchType == null) {
            throw new IllegalArgumentException();
        }
        return findForSaleBySearchType(searchTerm, searchType);
    }

    private List<ForSale> findForSaleBySearchType(Long searchTerm, SearchType searchType) {
        List<ForSale> forSales = null;
        if (searchType == SearchType.QUERY_ANNOTATION) {
            forSales = forSaleRepository.find(searchTerm);
        }
        else {
            System.out.println("No search result.");
        }
        return forSales;
    }
}
