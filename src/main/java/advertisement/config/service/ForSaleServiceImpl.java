package advertisement.config.service;


import advertisement.dao.ForSaleRepository;
import advertisement.model.ForSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static advertisement.config.service.UserDetailsServiceImpl.activeUserId;

@Component
public class ForSaleServiceImpl implements ForSaleService {

    @Autowired
    private ForSaleRepository forSaleRepository;

    public void createForSale(ForSale forSale) {
        ForSale newForSale = new ForSale();
        newForSale.setUserId(activeUserId);
        newForSale.setText(forSale.getText());
        newForSale.setCounty(forSale.getCounty());
        newForSale.setWasBuilt(forSale.getWasBuilt());
        newForSale.setPrice(forSale.getPrice());
        newForSale.setIsMortgaged(forSale.getIsMortgaged());
        newForSale.setCanBeMoved(forSale.getCanBeMoved());
        forSaleRepository.save(newForSale);
    }

    @Override
    public List<ForSale> search(SearchDTO searchCriteria) {
        return null;
    }
}