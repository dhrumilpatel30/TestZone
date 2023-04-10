package com.proj.java.onlineexaminationsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        if (!session.isNew() && session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals("teacher")) {
                return "redirect:/teacher";
            }
            return "redirect:/student";
        }
        session.invalidate();
        return "redirect:/student/login";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

}
