package com.sujit.restjpaweb.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sujit.restjpaweb.post.Post;
import com.sujit.restjpaweb.post.PostRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	
	
	@GetMapping("/users/{id}") 
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id); 
	  
		if(user.isEmpty()) { 
			throw new UserNotFoundException("id-"+id); 
		} 
		
		// "all-users", SERVER_PATH + "/users"
		// retrieveAllUsers
		EntityModel<User> resource = EntityModel.of(user.get());//new EntityModel<User>(user.get());

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		resource.add(linkTo.withRel("all-users"));

		// HATEOAS

		return resource;
	}
	  

	
    @PostMapping("/users") 
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) { 
    	User savedUser = userRepository.save(user); 
    	URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest() .path("/{id}") 
    			.buildAndExpand(savedUser.getId())
    			.toUri(); 
    	return ResponseEntity.created(location).build(); 
    }
	 
  
	@DeleteMapping("/users/{id}") 
    public void deleteUser(@PathVariable int id) {
	    userRepository.deleteById(id); 
    }
	 
	@GetMapping("/users/{id}/posts")
	public List<Post> retrieveAllUserPosts(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id-"+id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts") 
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) { 
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isEmpty()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		
    	URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest() .path("/{id}") 
    			.buildAndExpand(post.getId())
    			.toUri(); 
    	return ResponseEntity.created(location).build(); 
    }
	
}
