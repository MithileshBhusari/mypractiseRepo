package com.mtb.ex.repository;

import com.mtb.ex.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MithileshB
 * @created 02/07/2020 - 3:39 PM
 * @project spring-boot-mybatis
 */
@Repository
public interface PostRepository extends  JpaRepository<Post,Long> {

}
