package com.Blogging.plateform.blogging.plateform.repository;

import com.Blogging.plateform.blogging.plateform.model.Comment;
import com.Blogging.plateform.blogging.plateform.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Integer> {

}
