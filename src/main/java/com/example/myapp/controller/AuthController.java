package com.example.myapp.controller;

import com.example.myapp.config.JwtTokenRepository;
import com.example.myapp.dto.request.EntranceQDTO;
//import com.example.myapp.dto.request.GroupRequest;
import com.example.myapp.dto.request.RegistrationQDTO;
import com.example.myapp.dto.response.EntranceSDTO;
import com.example.myapp.exception.UserAlreadyExistsException;
import com.example.myapp.model.Client;
import com.example.myapp.model.Groupp;
import com.example.myapp.service.Client_serv;
import com.example.myapp.mapper.AuthMapper;
import com.example.myapp.service.Groupp_serv;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    //private final Groupp_serv groupService;

    public AuthController(Client_serv clientService, AuthMapper authMapper) {
        System.out.println("AuthController!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        this.clientService = clientService;
        this.authMapper = authMapper;
        //this.groupService = groupService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        System.out.println("AuthController  showRegistrationForm!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        model.addAttribute("registrationDto", new RegistrationQDTO());
        return "register";
    }

    /*@PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("registrationDto") RegistrationQDTO registrationDto,
            BindingResult result,
            Model model
    ) { System.out.println("AuthController  registerUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (result.hasErrors()) {
            return "register";
        }

        if (!registrationDto.isPasswordMatch()) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "register";
        }

        try {
            Client client = authMapper.toClient(registrationDto);
            client.setPassword(registrationDto.password());
            clientService.registerClient(client);
            return "redirect:/login?success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }*/

    /*@PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationQDTO registrationDto) {
        System.out.println("AuthController registerUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (!registrationDto.isPasswordMatch()) {
            return ResponseEntity.badRequest().body("Пароли не совпадают");
        }

        try {
            Client client = authMapper.toClient(registrationDto);
            client.setPassword(registrationDto.password());
            clientService.registerClient(client);
            return ResponseEntity.ok("Регистрация успешна");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка сервера");
        }
    }*/

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        System.out.println("AuthController  showLoginForm!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        model.addAttribute("entranceDto", new EntranceQDTO());
        return "login";
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAuthClient() {
        System.out.println("AuthController  getAuthClient!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth == null || !auth.isAuthenticated()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            // Получаем телефон из аутентификации
            String phoneNumber = auth.getName(); // Простой способ получить username

            // Ищем клиента в БД
            Client client = clientService.getClientByPhoneNumberWithGroups(phoneNumber);

            if (client == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            return ResponseEntity.ok(client);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Client getAuthClient() {
        System.out.println("1 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        System.out.println("2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Object principal = auth.getPrincipal();
        System.out.println("Principal class: " + principal.getClass()); // Добавим логирование

        // Изменяем только эту строку:
        String phoneNumber = (principal instanceof UserDetails)
                ? ((UserDetails) principal).getUsername()
                : null;

        System.out.println("Phone from principal: " + phoneNumber);
        System.out.println("4 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return this.clientService.getClientByPhoneNumberWithGroups(phoneNumber);
    }*/

    /*@PostMapping("/login")
    public String loginUser(
            @Valid @ModelAttribute("entranceDto") EntranceQDTO entranceDto,
            BindingResult result,
            Model model,
            HttpServletResponse response) {

        if (result.hasErrors()) {
            return "login";
        }

        try {
            Client client = clientService.getClientByPhoneNumber(entranceDto.phone());
            if (!client.checkPassword(entranceDto.password())) {
                model.addAttribute("error", "Неверный пароль");
                return "login";
            }

            UserDetails userDetails = clientService.loadUserByUsername(client.getPhoneNumber());
            String token = jwtUtil.generateToken(userDetails);

            Cookie cookie = new Cookie("AUTH-TOKEN", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);

            return "redirect:/home";

        } catch (Exception e) {
            model.addAttribute("error", "Пользователь не найден");
            return "login";
        }
    }*/

   /* @PostMapping("/groupp")
    public ResponseEntity<?> getGroupClients(
            @RequestBody GroupRequest request,
            @RequestHeader("Authorization") String authHeader
    ) {
        try {
            // Проверка JWT (автоматически через SecurityConfig)
            String jwt = authHeader.substring(7); // Удаляем "Bearer "

            // Получаем клиента и его группы
            Client client = clientService.getClientByIdWithGroups(request.getClientId());
            Groupp group = groupService.getGroupWithClients(request.getGroupId());

            // Проверяем, состоит ли клиент в этой группе
            boolean isMember = client.getClientGroups().stream()
                    .anyMatch(g -> g.getGroupId().equals(request.getGroupId()));

            if (!isMember) {
                return ResponseEntity.status(403).body("Доступ запрещён");
            }

            return ResponseEntity.ok(group.getClients());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка: " + e.getMessage());
        }
    }*/
}