package com.EM.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.EM.System.Repo.HrRepo;
import com.EM.System.model.HrLogin;

@Controller
public class HomeController {
	@Autowired
	HrRepo HR;
     @RequestMapping("/index")
	public String index() {
		return"home.jsp";
	}
     @RequestMapping("/home")
     public String mainHome() {
    	 return "mainHome.jsp";

     }
     @RequestMapping("/savedata")
     public String saveHr(HrLogin hrlogin) {
    	 HR.save(hrlogin);
    	 return"mainHome.jsp";
     }
     @RequestMapping("/getdata")
     public ModelAndView getdata(@RequestParam int id) {
      
    	 ModelAndView mv=new ModelAndView("show.jsp");
    	 HrLogin hrlogin=HR.findById(id).get();
    	 mv.addObject(hrlogin);
    	 
    	 return mv;
     }
}

