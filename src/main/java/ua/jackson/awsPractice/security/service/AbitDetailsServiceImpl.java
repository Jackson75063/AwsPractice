package ua.jackson.awsPractice.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.repository.AbitRepos;

@Service
public class AbitDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AbitRepos userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Abiturient abiturient = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

        System.out.println( "user details repo  " +abiturient);

        return AbitDetailsImpl.build(abiturient);
    }

}
