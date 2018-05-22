package advertisement.config.service;

import advertisement.dao.UserInfoDAO;
import advertisement.dao.UserRepository;
import advertisement.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    public static Long activeUserId;

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Autowired
    private UserRepository userRepository;

    // LOAD ACTIVE USER
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDAO.getActiveUser(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),Arrays.asList(authority));
        activeUserId = userInfo.getId();
        UserDetails userDetails = (UserDetails)user;
        return userDetails;
    }

    // CREATE NEW USER
    public void createUser(UserInfo user) {
        BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
        UserInfo newUser = new UserInfo();
        newUser.setName(user.getName());
        newUser.setUsername(user.getName());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setDateOfBirth(user.getDateOfBirth());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        newUser.setRole("USER");
        userRepository.save(newUser);
    }
}
