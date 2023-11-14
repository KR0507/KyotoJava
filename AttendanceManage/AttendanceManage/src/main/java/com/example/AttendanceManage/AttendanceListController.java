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

        //List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM ATTENDANCES");
        //list.forEach(System.out::println);
        public String index(Model model){
                String sql = "SELECT * FROM ATTENDANCES";

            System.out.println(jdbcTemplate.queryForList(sql));
            return "attendancelist";
        }

}
