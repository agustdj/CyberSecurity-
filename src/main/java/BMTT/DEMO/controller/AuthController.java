package BMTT.DEMO.controller;


import BMTT.DEMO.model.User;
import BMTT.DEMO.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    // Display login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Returns the name of the login view (login.html)
    }

    // Process login form
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            boolean isAuthenticated = authenticationService.login(username, password);
            if (isAuthenticated) {
                return "redirect:/home"; // Redirect to the user's dashboard or a successful login page
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login"; // Return to the login page with an error message
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "error"; // Xử lý ngoại lệ nếu cần thiết và trả về trang lỗi
        }
    }
}
