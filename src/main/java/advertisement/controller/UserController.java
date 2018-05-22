package advertisement.controller;

import advertisement.config.service.UserDetailsServiceImpl;
import advertisement.dao.ForRentRepository;
import advertisement.dao.ForSaleRepository;
import advertisement.dao.ForSearchRepository;
import advertisement.dao.UserRepository;
import advertisement.model.SearchById;
import advertisement.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

import static advertisement.config.service.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping(path="/users")

public class UserController {
    private static Long searchAdsId;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private ForRentRepository forRentRepository;
    @Autowired
    private ForSaleRepository forSaleRepository;
    @Autowired
    private ForSearchRepository forSearchRepository;

    // SHOW ALL USERS
    @GetMapping(path = "/")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allprofile");
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.addObject("user", userRepository.findAll());
        return modelAndView;
    }

    // FIND SINGLE USER
    @GetMapping(path = "/{id}")
    public ModelAndView getUser(@PathVariable Long id) {
        id = activeUserId;
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userRepository.findById(id).get();
        modelAndView.setViewName("userprofile");
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    // GET NEW USER FORM
    @GetMapping(path = "/edit/{id}")
    public ModelAndView editUserForm(@PathVariable Long id) {
        id = activeUserId;
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userRepository.findById(id).get();
        modelAndView.setViewName("edituser");
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.addObject("edituser", user);
        return modelAndView;
    }

    // EDIT FOR USER
    @PostMapping(path = "/edit/{id}")
    public String updateUser(@ModelAttribute UserInfo user, Model model, @PathVariable Long id) {
        id = activeUserId;
        UserInfo editU = userRepository.findById(id).get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        editU.setName(user.getName());
        editU.setUsername(user.getUsername());
        editU.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        editU.setDateOfBirth(user.getDateOfBirth());
        editU.setPhone(user.getPhone());
        editU.setEmail(user.getEmail());
        userRepository.save(editU);
        model.addAttribute("activeUser", activeUserId);
        model.addAttribute("user", userRepository.findAll());
        return "allprofile";
    }

    // DELETE USER
    @PostMapping(path = "/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        id = activeUserId;
        userRepository.deleteById(id);
        model.addAttribute("activeUser", activeUserId);
        model.addAttribute("user", userRepository.findAll());
        return "allprofile";
    }

    @GetMapping(path = "/search")
    public ModelAndView getSearchForm(ModelAndView modelAndView) {
        modelAndView.setViewName("search");
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.addObject("searchById", new SearchById());
        return modelAndView;
    }

    @PostMapping(path = "/search")
    public ModelAndView searchAds(@ModelAttribute SearchById searchById) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(searchById.getId());
        modelAndView.setViewName("searchresult");
        modelAndView.addObject("forrent", forRentRepository.findById(searchById.getId()));
        modelAndView.addObject("forsale", forSaleRepository.findById(searchById.getId()));
        modelAndView.addObject("forsearch", forSearchRepository.findById(searchById.getId()));
        return modelAndView;
    }
}