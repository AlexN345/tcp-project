package com.example.myapp.controller;

import com.example.myapp.dto.auth.*;
import com.example.myapp.dto.response.EntranceSDTO;
import com.example.myapp.exception.UserAlreadyExistsException;
import com.example.myapp.model.Client;
import com.example.myapp.security.JwtProperties;
import com.example.myapp.service.Auth_serv;
import com.example.myapp.service.Client_serv;
import com.example.myapp.mapper.AuthMapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Objects;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final Client_serv clientService;
    private final AuthMapper authMapper;
    private final Auth_serv authService;
    private final JwtProperties props;


    public AuthController(Client_serv clientService, AuthMapper authMapper, Auth_serv authService, JwtProperties props) {
        System.out.println("AuthController!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        this.clientService = clientService;
        this.authMapper = authMapper;
        this.authService = authService;
        this.props = props;
        //this.groupService = groupService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        System.out.println("AuthController  showRegistrationForm!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        model.addAttribute("registrationDto", new RegistrationQDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registrationDto") RegistrationQDTO registrationDto, BindingResult bindingResult, Model model) {
        System.out.println("AuthController registerUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (!registrationDto.isPasswordMatch()) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "register";
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            Client client = authMapper.toClient(registrationDto);
            client.setPassword(registrationDto.password());
            clientService.registerClient(client);
            model.addAttribute("registrationSuccess", true);
            return "register";
        } catch (UserAlreadyExistsException e) {
            bindingResult.rejectValue("phone", "error.phone", e.getMessage());
            return "register";
        }

    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        System.out.println("AuthController  showLoginForm!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        model.addAttribute("entranceDto", new JwtRequest());
        return "login";
    }

    @PostMapping("/login")
    public String getAuthClient(@Valid @ModelAttribute("entranceDto") JwtRequest req, BindingResult bindingResult,HttpServletResponse response, Model model) {
        System.out.println("AuthController  getAuthClient!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            JwtResponse jwt = authService.login(req); //проверяет учётные данные и выдаёт токены
            System.out.println("Auth_serv end!!!!!!!!!!!!!!!");

            ResponseCookie cookie = ResponseCookie.from("accessToken", jwt.getAccessToken())
                    //кладём accessToken в HTTPonly cookie accessToken(браузер автоматическиотсылал,JavaScriptкнемунеимелдоступа
                    .httpOnly(true)
                    .secure(true)
                    .sameSite("Lax")
                    .path("/") // cookie действует на всё приложение
                    .maxAge(props.getAccess() * 3600) // время жизни в секундах
                    .build();
            //response.addHeader("Authorization", "Bearer " + jwt.getAccessToken());
            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            /*request.getRequestDispatcher("/groups").forward(request, response);
            return null;*/
            System.out.println("Auth_contr end!!!!!!!!!!!!!!!");
            return "redirect:/groups";
        } catch (BadCredentialsException e) {
            bindingResult.rejectValue("username", "error.username", "Неверный телефон или пароль");
            return "login";
        }
    }


}