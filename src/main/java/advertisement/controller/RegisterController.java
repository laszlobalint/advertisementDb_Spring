package advertisement.controller;

import advertisement.config.implementation.UserDetailsServiceImpl;
import advertisement.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.UUID;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

import static advertisement.config.implementation.UserDetailsServiceImpl.activeUserId;

@Controller
@RequestMapping("/")
public class RegisterController {

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(       Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	@Autowired
	private UserDetailsServiceImpl userService;

	@GetMapping("adduser")
	public ModelAndView registerForm(ModelAndView model) {
		model.setViewName("adduser");
		model.addObject("activeUser", activeUserId);
		model.addObject("userInfo", new UserInfo());

		return model;
	}

	@PostMapping("adduser")
    public ModelAndView registerUser(@Valid UserInfo userInfo, BindingResult bindingResult, ModelAndView model) {
		if(bindingResult.hasErrors()) {
			return model;
		}
		userService.createUser(userInfo);
		model.setViewName("allprofile");
		return model;
	}
}