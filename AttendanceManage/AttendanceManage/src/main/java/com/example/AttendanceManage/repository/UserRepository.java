package com.example.AttendanceManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AttendanceManage.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}