package com.cs545.zara.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs545.zara.HelpClasses.Helper;
import com.cs545.zara.domain.PrimaryAccount;
import com.cs545.zara.domain.Recipient;
import com.cs545.zara.domain.SavingAccount;
import com.cs545.zara.domain.User;
import com.cs545.zara.service.AccountService;
import com.cs545.zara.service.TransactionService;
import com.cs545.zara.service.UserService;


@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @Autowired
	AccountService accountService;
    
    @RequestMapping(value = "/betweenAccounts", method = RequestMethod.GET)
    public String betweenAccounts(@ModelAttribute("help") Helper help) {

        return "betweenAccounts";
    }

    @RequestMapping(value = "/betweenAccounts", method = RequestMethod.POST)
    public String betweenAccountsPOST(@ModelAttribute("help") Helper help1,Principal principal) {

     	String accountType=help1.getAccountType();
    	String accountType1=help1.getAccountType1();
    	 String amount=help1.getAmount();
        accountService.withdraw(accountType, Double.parseDouble(amount), principal);
       
    	accountService.deposit(accountType1, Double.parseDouble(amount), principal);


        return "redirect:/welcomePage";
    }
    
    
//    @RequestMapping(value = {"/recipient","/toSomeoneElse"}, method = RequestMethod.GET)
//    public String ongoing(){
//    	
//    	return "Ongoing";
//    }
//    
    
//    @RequestMapping(value = "/recipient", method = RequestMethod.GET)
//    public String recipient(Model model, Principal principal) {
//        List<Recipient> recipientList = transactionService.findRecipientList(principal);
//
//        Recipient recipient = new Recipient();
//
//        model.addAttribute("recipientList", recipientList);
//        model.addAttribute("recipient", recipient);
//
//        return "recipient";
//    }

//    @RequestMapping(value = "/recipient/save", method = RequestMethod.POST)
//    public String recipientPost(@ModelAttribute("recipient") Recipient recipient, Principal principal) {
    
    
    
//
//        User user = userService.findByUsername(principal.getName());
//        recipient.setUser(user);
//        transactionService.saveRecipient(recipient);
//
//        return "redirect:/transfer/recipient";
//    }

//    @RequestMapping(value = "/recipient/edit", method = RequestMethod.GET)
//    public String recipientEdit(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){
//
//        Recipient recipient = transactionService.findRecipientByName(recipientName);
//        List<Recipient> recipientList = transactionService.findRecipientList(principal);
//
//        model.addAttribute("recipientList", recipientList);
//        model.addAttribute("recipient", recipient);
//
//        return "recipient";
//    }

//    @RequestMapping(value = "/recipient/delete", method = RequestMethod.GET)
//    @Transactional
//    public String recipientDelete(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){
//
//        transactionService.deleteRecipientByName(recipientName);
//
//        List<Recipient> recipientList = transactionService.findRecipientList(principal);
//
//        Recipient recipient = new Recipient();
//        model.addAttribute("recipient", recipient);
//        model.addAttribute("recipientList", recipientList);
//
//
//        return "recipient";
//    }

    @RequestMapping(value = "/toSomeoneElse",method = RequestMethod.GET)
    public String toSomeoneElse(@ModelAttribute("recipient") Recipient recipient) {
    	
        return "Ongoing";
    }

    @RequestMapping(value = "/toSomeoneElse",method = RequestMethod.POST)
    public String toSomeoneElsePost(@ModelAttribute("recipient") Recipient recipient, Principal principal) {
    
    String accountType=recipient.getAccountTypeFrom();
    String accountTypeFrom=recipient.getAccountTypeTo();
    String accountNumber=recipient.getAccountNumber();
    String amount=recipient.getAmount();
	
    accountService.depositToSomeOneElse(accountType, Double.parseDouble(amount), accountNumber);
//        User user = userService.findByUsername(principal.getName());
//        Recipient recipient = transactionService.findRecipientByName(recipientName);
//       accountService.depositToSomeOneElse(accountTypeTo, Double.parseDouble(amount), accountNumber);
accountService.withdraw(accountTypeFrom, Double.parseDouble(amount), principal);
        return "redirect:/welcomePage";
   }
}
