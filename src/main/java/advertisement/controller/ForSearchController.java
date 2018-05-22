package advertisement.controller;

import advertisement.config.service.ForSearchServiceImpl;
import advertisement.dao.ForSearchRepository;
import advertisement.model.ForSearch;
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

@Controller
@RequestMapping("/users/ads/forsearch")

public class ForSearchController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }
    @Autowired
    ForSearchRepository forSearchRepository;
    @Autowired
    ForSearchServiceImpl forSearchService;

    @GetMapping(path = "/")
    public ModelAndView getAllForSearchUserAds() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("allforsearch");
        modelAndView.addObject("forsearch", forSearchRepository.findAll());
        return modelAndView;
    }

    @GetMapping(path = "/{id}/")
    public ModelAndView getForSearchAds(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("userforsearch");
        modelAndView.addObject("forsearch", forSearchRepository.find(id));
        return modelAndView;
    }

    @GetMapping("new")
    public ModelAndView forSearchForm(ModelAndView model) {
        model.setViewName("addforsearch");
        model.addObject("activeUser", activeUserId);
        model.addObject("forSearch", new ForSearch());
        return model;
    }

    @PostMapping("new")
    public ModelAndView forSearchAdd(@Valid ForSearch forSearch, BindingResult bindingResult, ModelAndView model) {
        if(bindingResult.hasErrors()) {
            return model;
        }
        forSearchService.createForSeach(forSearch);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforsearch");
        model.addObject("forsearch", forSearchRepository.findAll());
        return model;
    }

    @GetMapping(path = "/edit/{adsId}")
    public ModelAndView editForSearch(@PathVariable Long adsId) {
        ModelAndView modelAndView = new ModelAndView();
        ForSearch forSearch = forSearchRepository.findById(adsId).get();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("editforsearch");
        modelAndView.addObject("editforsearch", forSearch);
        return modelAndView;
    }

    @PostMapping(path = "/edit/{adsId}")
    public ModelAndView updateUser(@ModelAttribute ForSearch editforsearch, ModelAndView model, @PathVariable Long adsId) {
        ForSearch editFm = forSearchRepository.findById(adsId).get();
        editFm.setUserId(activeUserId);
        editFm.setText(editforsearch.getText());
        editFm.setCounty(editforsearch.getCounty());
        editFm.setCautionMonths(editforsearch.getCautionMonths());
        editFm.setMonthlyRent(editforsearch.getMonthlyRent());
        editFm.setIsSmoking(editforsearch.getIsSmoking());
        editFm.setIsForStudents(editforsearch.getIsForStudents());
        editFm.setCurrentInmate(editforsearch.getCurrentInmate());
        editFm.setIsMan(editforsearch.getIsMan());
        editFm.setCanBeMoved(editforsearch.getCanBeMoved());
        forSearchRepository.save(editFm);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforsearch");
        model.addObject("forsearch", forSearchRepository.findAll());
        return model;
    }

    @GetMapping("/delete/{adsId}")
    public ModelAndView deleteForSeach(@PathVariable Long adsId, ModelAndView model) {
        forSearchRepository.deleteById(adsId);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforsearch");
        model.addObject("forsearch", forSearchRepository.findAll());
        return model;
    }
}
