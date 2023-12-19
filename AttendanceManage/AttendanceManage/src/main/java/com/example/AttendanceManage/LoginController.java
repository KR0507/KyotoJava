package com.example.AttendanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AttendanceManage.form.LoginForm;

@Controller
@RequestMapping("/Login")
public class LoginController {
	
	@GetMapping
	public String view(Model model,LoginForm form) {
		
		
		return "Login";
	
    }
	
	@PostMapping
	public void login(LoginForm form) {
		System.out.println(form.toString());
	}
	
}
