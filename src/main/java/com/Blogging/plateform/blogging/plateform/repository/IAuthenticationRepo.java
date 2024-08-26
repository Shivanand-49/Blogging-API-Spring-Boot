package com.Blogging.plateform.blogging.plateform.repository;

import com.Blogging.plateform.blogging.plateform.model.AuthenticationToken;
import com.Blogging.plateform.blogging.plateform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
