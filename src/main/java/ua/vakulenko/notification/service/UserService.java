package ua.vakulenko.notification.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vakulenko.notification.domain.User;
import ua.vakulenko.notification.repository.SequenceRepository;
import ua.vakulenko.notification.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private SequenceRepository sequenceRepository;
	@Autowired
	private UserRepository contactRepository;

	public void add(User contact) {
		contact.setId(sequenceRepository
				.getNextSequenceId(User.COLLECTION_NAME));
		contactRepository.save(contact);

	}

	public void update(User contact) {
		contactRepository.save(contact);
	}

	public User find(Long id) {
		return  contactRepository.findOne(id);
	}
	public void remove(Long id) {
		contactRepository.delete(id);
	}

	public List<User> findAll() {
		return contactRepository.findAll();
	}

}
