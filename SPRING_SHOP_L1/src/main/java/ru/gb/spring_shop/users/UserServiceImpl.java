package ru.gb.spring_shop.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.spring_shop.repository.RoleRepository;
import ru.gb.spring_shop.repository.UserRepository;
import ru.gb.spring_shop.roles.Role;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

//    @Autowired
//    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
    }

//    public User findByUserName(String userName) {
//        Optional<User> maybeUser = userRepository.findByUserName(userName);
//        if (maybeUser.isEmpty()) {
//            throw new UsernameNotFoundException("No such user!");
//        }
//        User user = maybeUser.get();
////        return userRepository.findOneByUserName(userName);
//        return new org.springframework.security.core.userdetails.User(
//                user.getUserName(),
//                user.getPassword(),
//                user.getRoles()
//                        .stream()
//                        .map(role -> new SimpleGrantedAuthority(role.getName()))
//                        .to
//        );
//    }

//    public boolean save (SystemUser systemUser) {
//        User user = new User();
//        if (findByUserName(systemUser.getUserName()) != null) {
//            return false;
//        }
//        user.setUserName(systemUser.getUserName());
//        user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
//        user.setFirstName(systemUser.getFirstName());
//        user.setLastName(systemUser.getLastName());
//        user.setEmail(systemUser.getEmail());
//        user.setRoles(Arrays.asList(roleRepository.findOneByName("ROLE_CLIENT")));
//        userRepository.save(user);
//        return true;
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> maybeUser = userRepository.findByUserName(userName);
        if (maybeUser.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username/password!");
        }
        User user = maybeUser.get();
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority>
    mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
