package ru.itis.inform.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;

import java.util.ArrayList;
import java.util.List;

import static ru.itis.inform.security.user.Roles.*;

/**
 * 30.10.2016.
 *
 * @author Maxim Romanov
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CustomerDao customerDao;

    /** Fill our user model with real data from db
    * @param token - user token*/
    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        Customer customer = customerDao.getCustomerByToken(token);
        List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(USER.toString()));
        return new UserDetailsImpl(customer.getPhone(), customer.getHashPassword(), authorities);
    }
}
