package ua.vakulenko.notification.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vakulenko.notification.domain.Friend;
import ua.vakulenko.notification.repository.SequenceRepository;
import ua.vakulenko.notification.repository.FriendRepository;

@Service
public class FriendService {

	@Autowired
	private SequenceRepository sequenceRepository;
	@Autowired
	private FriendRepository contactRepository;

	public void add(Friend contact) {
		contact.setId(sequenceRepository
				.getNextSequenceId(Friend.COLLECTION_NAME));
		contactRepository.save(contact);
	}

	public void update(Friend contact) {
		contactRepository.save(contact);
	}

	public void remove(Long id) {
		contactRepository.delete(id);
	}

	public List<Friend> findAll() {
		return contactRepository.findAll();
	}

}
