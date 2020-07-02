package com.mtb.ex.repository;

import com.mtb.ex.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author MithileshB
 * @created 02/07/2020 - 3:39 PM
 * @project spring-boot-mybatis
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
