package com.codingdojo.ninjaGold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
		public String index(HttpSession session) {
			if(session.getAttribute("gold")==null) {
				session.setAttribute("gold", 0);
				session.setAttribute("activities", new ArrayList<String>());
			}
			return "index.jsp";
		}
	@RequestMapping(path="", method=RequestMethod.POST)
	public String addGold(HttpSession session, @RequestParam(value="location") String location) {
		String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		if(location.equals("farm")) {
			Random num = new Random();
			Integer amount = num.nextInt(11) + 10;
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+amount);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You earned "+amount+" gold coins. ("+time+")");
		}
		else if(location.equals("cave")) {
			Random num = new Random();
			Integer amount = num.nextInt(6) + 5;
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+amount);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You earned "+amount+" gold coins. ("+time+")");
		}
		else if(location.equals("house")) {
			Random num = new Random();
			Integer amount = num.nextInt(4) +2;
			Integer gold = (Integer) session.getAttribute("gold");
			session.setAttribute("gold", gold+amount);
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add("You earned "+amount+" gold coins. ("+time+")");
		}
		else if(location.equals("casino")) {
			Random num = new Random();
			Integer amount = num.nextInt(51);
			Integer result = num.nextInt(2) +1;
			Integer gold = (Integer) session.getAttribute("gold");
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			if(result == 1) {
				session.setAttribute("gold", gold+amount);
				activities.add("You earned "+amount+" gold coins ("+time+")");
			} else {
				session.setAttribute("gold", gold-amount);
				activities.add("You lost "+amount+" gold coins ("+time+")");
			}
		}
		return "redirect:/";
	}
}
