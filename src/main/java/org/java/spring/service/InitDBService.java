package org.java.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class InitDBService {
	

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	
	@PostConstruct
	
	public void init(){
	Role roleUser = new Role();
	roleUser.setName("ROLE_USER");
	roleRepository.save(roleUser);

	Role roleAdmin = new Role();
	roleAdmin.setName("ROLE_ADMIN");
	roleRepository.save(roleAdmin);

	User userAdmin = new User();
	userAdmin.setEnabled(true);
	userAdmin.setName("admin");
	//userAdmin.setPassword("admin");
	BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	userAdmin.setPassword(encoder.encode("admin"));
	List<Role> roles = new ArrayList<Role>();
	roles.add(roleAdmin);
	roles.add(roleUser);
	userAdmin.setRoles(roles);
	userRepository.save(userAdmin);

	Blog blogJavavids = new Blog();
	blogJavavids.setName("JavaVids");
	blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
	blogJavavids.setUser(userAdmin);
	blogRepository.save(blogJavavids);

	 Item item1 = new Item();
	 item1.setBlog(blogJavavids);
	 item1.setTitle("first");
	 item1.setLink("http://www.javavids.com");
	 item1.setPublishedDate(new Date());
	 itemRepository.save(item1);
	
	 Item item2 = new Item();
	 item2.setBlog(blogJavavids);
	 item2.setTitle("second");
	 item2.setLink("http://www.javavids.com");
	 item2.setPublishedDate(new Date());
	 itemRepository.save(item2);
	 
	}
}
