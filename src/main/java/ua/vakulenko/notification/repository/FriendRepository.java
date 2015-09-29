package ua.vakulenko.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ua.vakulenko.notification.domain.Friend;

public interface FriendRepository extends MongoRepository<Friend, Long> {

}
