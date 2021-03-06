package advertisement.config.search;

import advertisement.config.implementation.UserDetailsServiceImpl;
import advertisement.config.service.ForSearchService;
import advertisement.dao.ForSearchRepository;
import advertisement.model.ForSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForSearchServiceImpl implements ForSearchService {

    @Autowired
    private ForSearchRepository forSearchRepository;

    public void createForSeach(ForSearch forSearch) {
        ForSearch newForSearch = new ForSearch();
        newForSearch.setUserId(UserDetailsServiceImpl.activeUserId);
        newForSearch.setText(forSearch.getText());
        newForSearch.setCounty(forSearch.getCounty());
        newForSearch.setCautionMonths(forSearch.getCautionMonths());
        newForSearch.setMonthlyRent(forSearch.getMonthlyRent());
        newForSearch.setIsSmoking(forSearch.getIsSmoking());
        newForSearch.setIsForStudents(forSearch.getIsForStudents());
        newForSearch.setCurrentInmate(forSearch.getCurrentInmate());
        newForSearch.setIsMan(forSearch.getIsMan());
        newForSearch.setCanBeMoved(forSearch.getCanBeMoved());
        forSearchRepository.save(newForSearch);
    }

    @Override
    public List<ForSearch> search(SearchDTO searchCriteria) {
        return null;
    }
}
