package BMTT.DEMO.controller;

import BMTT.DEMO.model.User;
import BMTT.DEMO.security.TranspositionCipher;
import BMTT.DEMO.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/*

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private UserRepository usersRepository; // Assume you have a repository for Users

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Add any necessary model attributes
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@RequestParam("username") String username,
                                      @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        usersRepository.save(user); // Save the user
        return "redirect:/home"; // Redirect to success page or another URL
    }
}
*/
/*

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        String keyString = "1,2,3,4,5,6"; // Example key string
        userService.registerUser(user, keyString);
        return "redirect:/login";
    }
}*/
/*

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        String keyString = generateKeyString(user.getPassword().length());
        userService.registerUser(user, keyString);
        return "redirect:/login";
    }

    private String generateKeyString(int length) {
        return IntStream.rangeClosed(1, length)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}*/

/*
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private final  HttpPostRequestService httpPostRequestService;

    @Autowired
    public RegisterController(HttpPostRequestService httpPostRequestService) {
        this.httpPostRequestService = httpPostRequestService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    *//*@PostMapping("/register")
    public String registerUser(User user, Model model) {
        int key = 7; // Example key length
        String encryptedPassword = PasswordEncryptor.encryptPassword(user.getPassword(), key);
        user.setPassword(encryptedPassword);
        userService.registerUser(user);
        return "redirect:/login";
    }*//*

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("user") User user) {
        try {
            int key = 7;  // Key cho thuật toán transposition cipher
            String encryptedPassword = PasswordEncryptor.encryptPassword(user.getPassword(), key);
            user.setPassword(Arrays.toString(encryptedPassword.getBytes()));
            userService.registerUser(user);
            System.out.println("Encrypted password: " + encryptedPassword);  // Để kiểm tra mã hóa
            // Gửi encryptedPassword đi qua HTTP POST request
            httpPostRequestService.sendPostRequest();
            return "redirect:/login"; // Điều hướng đến trang đăng nhập thành công
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Xử lý ngoại lệ nếu cần thiết và trả về trang lỗi
        }
    }*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String submitRegistrationForm(@ModelAttribute("user") User user, Model model) {
        userService.registerUser(user);
        return "redirect:/login";
    }
}


