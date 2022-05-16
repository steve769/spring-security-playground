package info.stephenderrick.basicauth.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static info.stephenderrick.basicauth.config.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicatiopnUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicatiopnUsers (){

        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                    STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "annasmith",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "linda",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMINTRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "tom",
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
