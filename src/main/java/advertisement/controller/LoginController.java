package advertisement.controller;

import advertisement.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import static advertisement.config.service.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = {"", "main"})
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("main");
        return modelAndView;
    }
    @GetMapping("login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("login")
    public ModelAndView afterLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userRepository.findAll());
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("allprofile");
        return modelAndView;
    }
    @GetMapping("about")
    public ModelAndView aboutPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("about");
        return modelAndView;
    }
    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        modelAndView.addObject("errorMsg", errorMessage);
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("error");
        return modelAndView;
    }
    @GetMapping("logout")
    public ModelAndView logoutPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("activeUser", activeUserId);
        modelAndView.setViewName("logout");
        return modelAndView;
    }
    @PostMapping("logout")
    public ModelAndView afterLogout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        activeUserId = null;
        return modelAndView;
    }
}