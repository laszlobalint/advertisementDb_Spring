package advertisement.config.implementation;

import advertisement.config.service.ForRentService;
import advertisement.config.search.SearchDTO;
import advertisement.dao.ForRentRepository;
import advertisement.model.ForRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static advertisement.config.implementation.UserDetailsServiceImpl.activeUserId;

@Component
public class ForRentServiceImpl implements ForRentService {

    @Autowired
    private ForRentRepository forRentRepository;

    public void createForRent(ForRent forRent) {
        ForRent newForRent = new ForRent();
        newForRent.setUserId(activeUserId);
        newForRent.setText(forRent.getText());
        newForRent.setCounty(forRent.getCounty());
        newForRent.setMonthlyRent(forRent.getMonthlyRent());
        newForRent.setCurrentExpenses(forRent.getCurrentExpenses());
        newForRent.setCautionMonths(forRent.getCautionMonths());
        newForRent.setIsSmoking(forRent.getIsSmoking());
        newForRent.setIsForStudents(forRent.getIsForStudents());
        newForRent.setCanBeMoved(forRent.getCanBeMoved());
        forRentRepository.save(newForRent);
    }

    @Override
    public List<ForRent> search(SearchDTO searchCriteria) {
        return null;
    }
}
