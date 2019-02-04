package controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.PersistenceDAO;
import entities.User;

@SessionAttributes({ "user", "workout", "userWorkoutExercises", "workoutExercise" })
@Controller
public class HTMLController {

	@Autowired
	private PersistenceDAO dao;

	@PersistenceContext
	EntityManager em;



	@ModelAttribute("user")
	public User newUser() {
		return new User();
	}


	// Forwards user to sign up page
	@RequestMapping(path = "createUser.do", method = RequestMethod.GET)
	public ModelAndView signupForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup.jsp");
		return mv;
	}

	// User created and persisted to database
	@RequestMapping(path = "createUser.do", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user") User user) {
		dao.createNewUser(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("profile.jsp");
		return mv;
	}

	// User forwarded to login page
	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public ModelAndView loginForm(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}

	// User forwarded to login page
	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView loginFormPost(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		System.out.println(dao.getAllUsers());
		mv.setViewName("hello.html");
		return mv;
	}
}
