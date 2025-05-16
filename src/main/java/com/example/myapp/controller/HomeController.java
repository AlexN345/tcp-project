/*package com.example.myapp.controller;

import com.example.myapp.dto.response.EntranceSDTO;
import com.example.myapp.model.Client;
import com.example.myapp.service.Client_serv;
import com.example.myapp.mapper.AuthMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    private final Client_serv clientService;
    private final AuthMapper authMapper;
    private final JwtUtil jwtUtil;

    public HomeController(Client_serv clientService, AuthMapper authMapper, JwtUtil jwtUtil) {
        this.clientService = clientService;
        this.authMapper = authMapper;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/home")
    public String homePage(Model model, HttpServletRequest request) {
        String token = extractToken(request);
        if (token == null || !jwtUtil.validateToken(token)) {
            return "redirect:/login";
        }

        String phoneNumber = jwtUtil.extractUsername(token);
        Client client = clientService.getClientByPhoneNumberWithGroups(phoneNumber);
        EntranceSDTO entranceSDTO = authMapper.toEntranceSDTOWithGroups(client);
        model.addAttribute("userData", entranceSDTO);

        return "home";
    }

    private String extractToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("AUTH-TOKEN".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}*/