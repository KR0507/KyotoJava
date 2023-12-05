package com.example.AttendanceManage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

        @Autowired
        private JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        String sql = "SELECT * FROM USERS WHERE username = ? AND password = ?";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql, username, password);

        if (users.isEmpty()) {
            // ログイン失敗時の処理
            model.addAttribute("error", "Invalid username or password");
            return "login";
        } else {
            // ログイン成功時の処理
            return "redirect:/attendanceList";
        }
    }

    @GetMapping("/attendanceList")
    public String attendanceList(Model model) {
        String sql = "SELECT * FROM ATTENDANCES";
        List<Map<String, Object>> attendances = jdbcTemplate.queryForList(sql);
        model.addAttribute("attendances", attendances);
        return "attendancelist";
    }
}
