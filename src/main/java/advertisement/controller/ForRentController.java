package advertisement.controller;

import advertisement.config.service.ForRentServiceImpl;
import advertisement.dao.ForRentRepository;
import advertisement.model.ForRent;
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
@RequestMapping("/users/ads/forrent")

public class ForRentController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }
    @Autowired ForRentRepository forRentRepository;
    @Autowired ForRentServiceImpl forRentService;

    // SHOW ALL RENT ADS
    @GetMapping(path = "/")
    public ModelAndView getAllForRentUserAds() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("allforrent");
        modelAndView.addObject("forrent", forRentRepository.findAll());
        return modelAndView;
    }

    // SHOW ALL USERS RENT ADS
    @GetMapping(path = "/{id}/")
    public ModelAndView getForRentAds(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("userforrent");
        modelAndView.addObject("forrent", forRentRepository.find(id));
        return modelAndView;
    }

    // GET NEW FOR RENT FORM
    @GetMapping("new")
    public ModelAndView forRentForm(ModelAndView model) {
        model.setViewName("addforrent");
        model.addObject("activeUser", activeUserId);
        model.addObject("forRent", new ForRent());
        return model;
    }

    // ADD NEW FOR RENT
    @PostMapping("new")
    public ModelAndView forRentAdd(@Valid ForRent forRent, BindingResult bindingResult, ModelAndView model) {
        if(bindingResult.hasErrors()) {
            return model;
        }
        forRentService.createForRent(forRent);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforrent");
        model.addObject("forrent", forRentRepository.findAll());
        return model;
    }

    // GET EDIT FOR RENT FORM
    @GetMapping(path = "/edit/{adsId}")
    public ModelAndView editForRent(@PathVariable Long adsId) {
        ModelAndView modelAndView = new ModelAndView();
        ForRent forRent = forRentRepository.findById(adsId).get();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("editforrent");
        modelAndView.addObject("editforrent", forRent);
        return modelAndView;
    }

    // EDIT FOR RENT AD
    @PostMapping(path = "/edit/{adsId}")
    public ModelAndView updateUser(@ModelAttribute ForRent editforrent, ModelAndView model, @PathVariable Long adsId) {
        ForRent editFr = forRentRepository.findById(adsId).get();
        editFr.setUserId(activeUserId);
        editFr.setText(editforrent.getText());
        editFr.setCounty(editforrent.getCounty());
        editFr.setMonthlyRent(editforrent.getMonthlyRent());
        editFr.setCurrentExpenses(editforrent.getCurrentExpenses());
        editFr.setCautionMonths(editforrent.getCautionMonths());
        editFr.setIsSmoking(editforrent.getIsSmoking());
        editFr.setIsForStudents(editforrent.getIsForStudents());
        editFr.setCanBeMoved(editforrent.getCanBeMoved());
        forRentRepository.save(editFr);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforrent");
        model.addObject("forrent", forRentRepository.findAll());
        return model;
    }

    // DELETE FOR RENT AD
    @GetMapping("/delete/{adsId}")
    public ModelAndView deleteForRent(@PathVariable Long adsId, ModelAndView model) {
        forRentRepository.deleteById(adsId);
        model.addObject("activeUser", activeUserId);
        model.setViewName("allforrent");
        model.addObject("forrent", forRentRepository.findAll());
        return model;
    }
}