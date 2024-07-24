package BMTT.DEMO.service;

import BMTT.DEMO.model.User;
import BMTT.DEMO.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(@NotNull User user) {
        userRepository.save(user);
    }
}*/
/*

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user, String keyString) {
        // Encrypt the password
        String encryptedPassword = PasswordEncryptor.encryptPassword(user.getPassword(), keyString);
        user.setUsername(user.getUsername());
        user.setPassword(encryptedPassword);

        // Save the user to the database
        userRepository.save(user);
    }
}
*/

/*

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user, String keyString) {
        // Encrypt the password with the dynamic key length
        String encryptedPassword = PasswordEncryptor.encryptPassword(user.getPassword(), keyString);
        user.setPassword(encryptedPassword);

        // Save the user to the database
        userRepository.save(user);
    }
}
*/


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        // Save the user to the database
        userRepository.save(user);
    }
}
