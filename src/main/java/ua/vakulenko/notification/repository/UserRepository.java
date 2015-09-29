package ua.vakulenko.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ua.vakulenko.notification.domain.User;

public interface UserRepository extends MongoRepository<User,Long>{

}
