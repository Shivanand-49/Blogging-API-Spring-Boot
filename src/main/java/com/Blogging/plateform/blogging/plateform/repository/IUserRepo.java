package com.Blogging.plateform.blogging.plateform.repository;

import com.Blogging.plateform.blogging.plateform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);
}
