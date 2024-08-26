package com.Blogging.plateform.blogging.plateform.repository;

import com.Blogging.plateform.blogging.plateform.model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAdminRepo extends JpaRepository<UserAdmin,Integer> {
}
