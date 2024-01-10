package com.example.AttendanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@GetMapping("/Menu")
	public String view() {
		
		return "Menu";
	}

}
