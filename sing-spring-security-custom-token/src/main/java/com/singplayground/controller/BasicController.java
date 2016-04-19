package com.singplayground.controller;

import javax.annotation.Resource;

import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.singplayground.security.CustomUser;

@Controller
@RequestMapping(value = "/basic")
public class BasicController {

	@Resource(name = "sessionRegistry")
	private SessionRegistryImpl sessionRegistry;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView test1Controller() throws Exception {
		System.out.println("this is test !!!!");

		//ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		// ActiveSessions as = new ActiveSessions(appContext);
		System.out.println("the size of the principle : " + sessionRegistry.getAllPrincipals().size());
		CustomUser customUser = new CustomUser();
		customUser.setUsername("username111");
		CustomUser customUser2 = new CustomUser();
		customUser2.setUsername("username2222");
		System.out.println("****************** ");
		sessionRegistry.registerNewSession("123", customUser);
		sessionRegistry.registerNewSession("xxxx", customUser2);

		System.out.println("****************** 2");

		CustomUser getUser = (CustomUser) sessionRegistry.getSessionInformation("123").getPrincipal();
		System.out.println("****************** 3");
		System.out.println("username : " + getUser.getUsername());

		CustomUser getUser2 = (CustomUser) sessionRegistry.getSessionInformation("xxxx").getPrincipal();
		System.out.println("****************** 3");
		System.out.println("username : " + getUser2.getUsername());

		//CustomUser customUser1 =  (CustomerUser)sessionRegistry.getSessionInformation("123");
		//sessionRegistry.get
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in username
		//System.out.println("------- name -- " + name);
		//CustomUser customUser = (CustomUser) SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().getPrincipal();
		//SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().geta
		//System.out.println("get the customer user : " + customUser.getUsername());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("basic/index");
		return mav;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView createSessionController() throws Exception {
		System.out.println("this create !!!!");

		//ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		// ActiveSessions as = new ActiveSessions(appContext);
		System.out.println("the size of the principle : " + sessionRegistry.getAllPrincipals().size());
		CustomUser customUser = new CustomUser();
		customUser.setUsername("eyJpc3MiOiJzY290Y2");
		CustomUser customUser2 = new CustomUser();
		customUser2.setUsername("username2222");
		System.out.println("****************** ");
		sessionRegistry.registerNewSession("eyJpc3MiOiJzY290Y2guaW8iLCJleHAiOjEzMDA4MTkzODAsIm5hbWUiOiJDaHJpcyBTZXZpbGxlamEiLCJhZG1pbiI6dHJ1ZX0", customUser);

		CustomUser getUser = (CustomUser) sessionRegistry.getSessionInformation(
				"eyJpc3MiOiJzY290Y2guaW8iLCJleHAiOjEzMDA4MTkzODAsIm5hbWUiOiJDaHJpcyBTZXZpbGxlamEiLCJhZG1pbiI6dHJ1ZX0").getPrincipal();
		System.out.println("****************** 3");
		System.out.println("username : " + getUser.getUsername());

		//CustomUser customUser1 =  (CustomerUser)sessionRegistry.getSessionInformation("123");
		//sessionRegistry.get
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String name = auth.getName(); //get logged in username
		//System.out.println("------- name -- " + name);
		//CustomUser customUser = (CustomUser) SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().getPrincipal();
		//SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().geta
		//System.out.println("get the customer user : " + customUser.getUsername());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("basic/index");
		return mav;
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	public ModelAndView getSessionController() throws Exception {

		System.out
				.println(sessionRegistry.getSessionInformation("eyJpc3MiOiJzY290Y2guaW8iLCJleHAiOjEzMDA4MTkzODAsIm5hbWUiOiJDaHJpcyBTZXZpbGxlamEiLCJhZG1pbiI6dHJ1ZX0").isExpired());
		System.out.println("the size of the principle : " + sessionRegistry.getAllPrincipals().size());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("basic/index");
		return mav;
	}

}
