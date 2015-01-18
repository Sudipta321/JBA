package org.java.spring.repository;

import java.util.List;

import org.java.spring.entity.Blog;
import org.java.spring.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	List<Item> findByBlog(Blog blog,Pageable pageable);
	

}
