package ua.vakulenko.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ua.vakulenko.notification.domain.Notification;

public interface NotificationRepository extends MongoRepository<Notification,Long> {

}
