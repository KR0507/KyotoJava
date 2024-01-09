package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.AttendanceManage.form.LoginForm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "attendancelist")
@Controller
public class LoginController {
	
	@Id
	@Autowired
	private AttendanceListRepository attendanceListRepository;
	
	
	@GetMapping("/Login")
	public String view(Model model,LoginForm form) {
		
		return "Login";
    }
	
	@PostMapping("/Login")
    public String login(Model model, LoginForm form) {
        // データベースからユーザー情報を取得
        AttendanceList user = attendanceListRepository.findByIdAndPassword(form.getLoginId(), form.getPassword());

        if (user != null) {
            // ユーザーが存在すればMenu.htmlにリダイレクト
            return "redirect:/Menu";
        } else {
            model.addAttribute("errorMsg", "IDもしくはパスワードが間違いです。");
            return "Login";
		}
	}
	
}
