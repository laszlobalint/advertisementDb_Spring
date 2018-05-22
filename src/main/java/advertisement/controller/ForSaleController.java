package advertisement.controller;

import advertisement.config.service.ForSaleServiceImpl;
import advertisement.dao.ForSaleRepository;
import advertisement.model.ForSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

import static advertisement.config.service.UserDetailsServiceImpl.activeUserId;


import static advertisement.config.service.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping("/users/ads/forsale")

public class ForSaleController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }
    @Autowired
    ForSaleRepository forSaleRepository;
    @Autowired
    ForSaleServiceImpl forSaleService;

    @GetMapping(path = "/")
    public ModelAndView getAllForSaleUserAds() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("allforsale");
        modelAndView.addObject("forsale", forSaleRepository.findAll());
        return modelAndView;
    }

    @GetMapping(path = "/{id}/")
    public ModelAndView getForSaleAds(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("userforsale");
        modelAndView.addObject("forsale", forSaleRepository.find(id));
        return modelAndView;
    }

    @GetMapping("new")
    public ModelAndView forSaleForm(ModelAndView model) {
        model.setViewName("addforsale");
        model.addObject("activeUser", activeUserId);
        model.addObject("forSale", new ForSale());
        return model;
    }

    @PostMapping("new")
    public ModelAndView forSaleAdd(@Valid ForSale forSale, BindingResult bindingResult, ModelAndView model) {
        if(bindingResult.hasErrors()) {
            return model;
        }
        forSaleService.createForSale(forSale);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforsale");
        model.addObject("forsale", forSaleRepository.findAll());
        return model;
    }

    @GetMapping(path = "/edit/{adsId}")
    public ModelAndView editForSale(@PathVariable Long adsId) {
        ModelAndView modelAndView = new ModelAndView();
        ForSale forSale = forSaleRepository.findById(adsId).get();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("editforsale");
        modelAndView.addObject("editforsale", forSale);
        return modelAndView;
    }

    @PostMapping(path = "/edit/{adsId}")
    public ModelAndView updateUser(@ModelAttribute ForSale editforsale, ModelAndView model, @PathVariable Long adsId) {
        ForSale editFs = forSaleRepository.findById(adsId).get();
        editFs.setUserId(activeUserId);
        editFs.setText(editforsale.getText());
        editFs.setCounty(editforsale.getCounty());
        editFs.setWasBuilt(editforsale.getWasBuilt());
        editFs.setPrice(editforsale.getPrice());
        editFs.setIsMortgaged(editforsale.getIsMortgaged());
        editFs.setCanBeMoved(editforsale.getCanBeMoved());
        forSaleRepository.save(editFs);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforsale");
        model.addObject("forsale", forSaleRepository.findAll());
        return model;
    }

    @GetMapping("/delete/{adsId}")
    public ModelAndView deleteForSale(@PathVariable Long adsId, ModelAndView model) {
        forSaleRepository.deleteById(adsId);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforsale");
        model.addObject("forsale", forSaleRepository.findAll());
        return model;
    }
}