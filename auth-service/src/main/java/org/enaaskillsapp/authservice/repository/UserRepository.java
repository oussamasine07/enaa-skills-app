package org.enaaskillsapp.authservice.repository;

import org.enaaskillsapp.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail( String email );

}
