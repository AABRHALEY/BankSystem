package com.cs545.zara.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs545.zara.Exeption.BalanceIsInsufficientException;
import com.cs545.zara.HelpClasses.Help;
import com.cs545.zara.domain.PrimaryAccount;
import com.cs545.zara.domain.PrimaryTransaction;
import com.cs545.zara.domain.SavingAccount;
import com.cs545.zara.domain.SavingTransaction;
import com.cs545.zara.domain.User;
import com.cs545.zara.service.AccountService;
import com.cs545.zara.service.TransactionService;
import com.cs545.zara.service.UserService;



@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	UserService userService;

	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;
	
	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model,Principal principal){
	
		List<PrimaryTransaction> primaryTransactionList=transactionService.findPrimaryTransactionList(principal.getName());
		
		
		User user=userService.findByUsername(principal.getName());
    	PrimaryAccount primaryAccount=user.getPrimaryAccount();
    	model.addAttribute("primaryAccount",primaryAccount);
    	model.addAttribute("primaryTransactionList",primaryTransactionList);
		
    	return "primaryAccount";
	}
	
	@RequestMapping("/savingAccount")
	public String savingAccount(Principal principal,Model model){
		List<SavingTransaction> savingTransactionList=transactionService.findSavingTransactionList(principal.getName());
		model.addAttribute("savingTransactionList",savingTransactionList);
		
		User user=userService.findByUsername(principal.getName());
		SavingAccount savingAccount=user.getSavingAccount();
		model.addAttribute("savingAccount",savingAccount);
		
		return "savingAccount";
	}
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(@ModelAttribute("help") Help help) {

        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPOST(@ModelAttribute("help") Help help,Principal principal) {
    	

        String accountType=help.getAccountType();
        String amount=help.getAmount();
    	accountService.deposit(accountType, Double.parseDouble(amount), principal);

        return "redirect:/welcomePage";
    }
    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(@ModelAttribute("help") Help help) {
   
           return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("help") Help help,Principal principal) {
    	String accountType=help.getAccountType();
        String amount=help.getAmount();
        accountService.withdraw(accountType, Double.parseDouble(amount), principal);
      

        return "redirect:/welcomePage";
    }
	
    @ExceptionHandler(BalanceIsInsufficientException.class)
    public ModelAndView handleError(HttpServletRequest req, BalanceIsInsufficientException exception) {
    ModelAndView mav = new ModelAndView(); mav.addObject("Notransaction", exception.username()); mav.addObject("exception", exception);
             mav.addObject("url",
               req.getRequestURL()+"?"+req.getQueryString());
    mav.setViewName("TransactionNotFound");
     return mav; }
    
  

}
