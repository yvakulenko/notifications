package ua.vakulenko.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.vakulenko.notification.domain.User;
import ua.vakulenko.notification.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userDao;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody  User user) {
         userDao.add(user);
    }
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id")  Long id) {
		User user = userDao.find(id);
         userDao.update(user);
    }
	
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id")  Long id) {
         return userDao.find(id);
         
    }
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public List getAllUsers() {
        return userDao.findAll();
    }
	
	@RequestMapping(value = "/user/remove/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id")  Long id) {
         userDao.remove(id);
    }
	
}
