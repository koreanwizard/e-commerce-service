package com.madebywizard.ecommerce.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User
                .withUsername("admin")
                .authorities("BASIC", "SPECIAL")
                .password(encoder.encode("1"))
                .build();

        UserDetails user = User
                .withUsername("user")
                .authorities("BASIC")
                .password(encoder.encode("2"))
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*
    This only works on GET requests so if the service also wants to work on POST / PUT /DELETE
    requests, it should disable the CSRF (Cross Site Request Forgery).
    Since GET requests only reads the data and doesn't modify. However, other requests
    are able to mutate the data, disabling the CSRF is needed.

    CSRF:
    The attacker can modify user's information such as email address, password, or intentionally make a funds transfer.
    If the victim user has a privileged role (such as an admin), the attacker can take full control of the
    whole application's data and functionality.

    말 그대로 '사이트 간 요청 위조': 공격자는 사용자의 지정해 놓은 정보를 수정하고 사용자의 의지와 무관한 행위를 웹사이트에
    요청하게 한다.
    */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable) // allows for mutating mappings with authentication
                .authorizeHttpRequests(authorize -> {
                        authorize.requestMatchers("/open").permitAll(); // give permission to every user
                        authorize.requestMatchers("/closed").authenticated(); // only authenticated user can access
                        authorize.requestMatchers(HttpMethod.POST, "/closed").authenticated();

                        authorize.requestMatchers(HttpMethod.GET, "/special").hasAuthority("SPECIAL"); // this GET request only has authority of "SPECIAL"
                        authorize.requestMatchers(HttpMethod.GET, "/basic").hasAnyAuthority("SPECIAL", "BASIC"); // this has both "SPECIAL" AND "BASIC"
                })
                .httpBasic(Customizer.withDefaults())
                .build(); // for basic authentication
    }
}












