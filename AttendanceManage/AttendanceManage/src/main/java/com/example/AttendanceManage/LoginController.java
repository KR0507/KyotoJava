package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.AttendanceManage.entity.User;
import com.example.AttendanceManage.form.LoginForm;
import com.example.AttendanceManage.repository.UserRepository;

@Controller
public class LoginController {
	
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
    	model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginForm loginForm, Model model) {
    	User user = userRepository.findById(loginForm.getId()).orElse(null);

        if (user != null && user.getPassword().equals(loginForm.getPassword())) {
            if (user.getAdmin() != null && user.getAdmin() == 1) {
                return "redirect:/admenu";
            } else {
                return "redirect:/menu";
            }
        } else {
            model.addAttribute("error", "IDまたはパスワードが正しくありません");
            return "login";
        }
    }


}