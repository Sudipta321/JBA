package org.java.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.java.spring.entity.Blog;
import org.java.spring.entity.Item;
import org.java.spring.entity.Role;
import org.java.spring.entity.User;
import org.java.spring.repository.BlogRepository;
import org.java.spring.repository.ItemRepository;
import org.java.spring.repository.RoleRepository;
import org.java.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
	public List<User> findAll() {
		return userRepository.findAll();
	}


	public User findOne(int id) {
		return userRepository.findOne(id);
	}

    @Transactional
	public User findOneWithBlogs(int id) {
        User user =findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog,new PageRequest(0,10,Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
        return user;
	}


	public void save(User user) {
        
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);

	}


	public User findOneWithBlogs(String name) {

		User user =userRepository.findByName(name);
		return findOneWithBlogs(user.getId());
	}
	
	
}
