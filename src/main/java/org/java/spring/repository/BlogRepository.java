package org.java.spring.repository;

import java.util.List;

import org.java.spring.entity.Blog;
import org.java.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	

	List<Blog> findByUser(User user);
}
