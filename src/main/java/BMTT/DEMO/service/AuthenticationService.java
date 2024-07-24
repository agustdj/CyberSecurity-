package BMTT.DEMO.service;


import BMTT.DEMO.model.User;
import BMTT.DEMO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}