package ua.vakulenko.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vakulenko.notification.domain.Notification;
import ua.vakulenko.notification.repository.NotificationRepository;
import ua.vakulenko.notification.repository.SequenceRepository;

@Service
public class NotificationService {
	@Autowired
	private SequenceRepository sequenceRepository;
	@Autowired
	private NotificationRepository contactRepository;

	public void add(Notification contact) {
		contact.setId(sequenceRepository
				.getNextSequenceId(Notification.COLLECTION_NAME));
		contactRepository.save(contact);

	}

	public Notification find(Long id) {
		return contactRepository.findOne(id);
	}

	public void update(Notification contact) {
		contactRepository.save(contact);
	}

	public void remove(Long id) {
		contactRepository.delete(id);
	}

	public List<Notification> findAll() {
		return contactRepository.findAll();
	}
}
