package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;


@Controller
public class AttendanceListController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/attendanceList")

    public String index(Model model) {
        return "attendancelist";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, username, password);

        if (result.isEmpty()) {
            // ログイン失敗時の処理
            model.addAttribute("error", "Invalid username or password");
            return "login";
        } else {
            // ログイン成功時の処理
            return "redirect:/attendanceList";
        }
    }
}