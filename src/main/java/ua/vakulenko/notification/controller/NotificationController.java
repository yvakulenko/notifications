package ua.vakulenko.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.vakulenko.notification.domain.Notification;
import ua.vakulenko.notification.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	NotificationService notificationDao;

	@RequestMapping(value = "/notification", method = RequestMethod.POST)
	public void createNotification(@RequestBody Notification notification) {
		notificationDao.add(notification);
	}

	@RequestMapping(value = "/notification/{id}", method = RequestMethod.PUT)
	public void updateNotification(@PathVariable("id") Long id) {
		Notification notification = notificationDao.find(id);
		notificationDao.update(notification);
	}

	@RequestMapping(value = "/notification/{id}", method = RequestMethod.GET)
	public Notification getNotification(@PathVariable("id") Long id) {
		return notificationDao.find(id);
	}

	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public List getAllNotifications() {
		return notificationDao.findAll();
	}

	@RequestMapping(value = "/notification/remove/{id}", method = RequestMethod.DELETE)
	public void deleteNotification(@PathVariable("id") Long id) {
		notificationDao.remove(id);
	}

}
