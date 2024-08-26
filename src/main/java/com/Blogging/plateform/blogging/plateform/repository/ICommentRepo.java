package com.Blogging.plateform.blogging.plateform.repository;

import com.Blogging.plateform.blogging.plateform.model.Comment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {
//    List<Comment> getCommentsByPostId(Integer postId);
}
