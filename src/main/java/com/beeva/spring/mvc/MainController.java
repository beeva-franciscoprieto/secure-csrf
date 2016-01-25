/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beeva.spring.mvc;


import com.beeva.mongodb.form.AccountForm;
import com.beeva.mongodb.form.TransferForm;
import com.beeva.mongodb.model.Account;
import com.beeva.mongodb.service.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 * @author secure development group
 */
@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);

    private Service service;

	@Autowired
	public MainController(Service service) {
		this.service = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(value = "/accessdenied")
	public String denied(ModelMap model) {
		return "denied";
	}

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String message(ModelMap map) {

        return "account";
    }
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public String messages(ModelMap map) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); //get logged in username

        List<Account> accounts = service.getAllAccounts(userId);
		map.addAttribute("accounts", accounts);
		return "accounts";
	}


    @RequestMapping(value = "/transfer", method = RequestMethod.POST, consumes = { MediaType
            .APPLICATION_FORM_URLENCODED_VALUE})
    public String transfer(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                          @ModelAttribute("transferForm") TransferForm inputData)
            throws MethodArgumentNotValidException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); //get logged in username

        Account defaultAccount = service.getDefaultAccount(userId);
        inputData.setOriginAccount(defaultAccount.getAccountNumber());

        logger.info("Transferencia realizada: " + inputData);

        return "redirect:/accounts";
    }


    @RequestMapping(value = "/newAccount", method = RequestMethod.POST, consumes = { MediaType
            .APPLICATION_FORM_URLENCODED_VALUE})
    public String newAccount(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                               @ModelAttribute("accountForm") AccountForm inputData)
            throws MethodArgumentNotValidException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName(); //get logged in username

        service.saveAccount(userId, inputData);
        return "redirect:/accounts";
    }
}

