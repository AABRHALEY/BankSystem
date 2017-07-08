package com.cs545.zara.controller;




import java.io.File;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cs545.zara.domain.Authority;
import com.cs545.zara.domain.PrimaryAccount;
import com.cs545.zara.domain.SavingAccount;
import com.cs545.zara.domain.User;
import com.cs545.zara.service.AccountService;
import com.cs545.zara.service.AuthorityService;
import com.cs545.zara.service.SecurityService;
import com.cs545.zara.service.UserService;
import com.cs545.zara.serviceImpl.AccountServiceImpl;

@Controller
public class UserController {
	@Autowired
	private AccountService accountService; 
	
    @Autowired
    private UserService userService;

  @Autowired
  private AuthorityService authorityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(@ModelAttribute("userForm")  User userForm) {

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult,HttpServletRequest request, Model model) {


        if (bindingResult.hasErrors()) {
        
            return "registration";
        }
        MultipartFile userImage =
                userForm.getUserImage();
              String rootDirectory =
                request.getSession().getServletContext().getRealPath("/");
              if (userImage!=null && !userImage.isEmpty()) {
                try {
                	System.out.println("success");
                	userImage.transferTo(new
                    File(rootDirectory+"resources/images/"+
                    		userForm.getUsername() + ".png"));
              
                } catch (Exception e) {
                  throw new RuntimeException("User Image Failed",
                  e);
       } }
        
        Authority autority=new Authority(userForm.getUsername(),"ROLE_USER");
        
        userForm.setAuthority(authorityService.createAuth(userForm.getUsername())); 
       
        userForm.setPrimaryAccount(accountService.createPrimaryAccount());
        userForm.setSavingAccount(accountService.createSavingAccount());
        userService.save(userForm);

        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Principal principal,Model model) {

     return "login";
    
    }
    @RequestMapping(value = { "/welcomePage"}, method = RequestMethod.GET)
    public String welcome1(Principal principal,Model model) {
    	User user=userService.findByUsername(principal.getName());
    	PrimaryAccount primaryAccount=user.getPrimaryAccount();
    	SavingAccount savingAccount=user.getSavingAccount();
    	
    	model.addAttribute("primaryAccount",primaryAccount);
    	model.addAttribute("savingAccount",savingAccount);
    	model.addAttribute("username",user.getUsername());
    	model.addAttribute("user",user);
    
       return "welcome";
    }
}
