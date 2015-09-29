package ua.vakulenko.notification.domain;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;


public class AbstractDocument {

    @Id private Long documentId;

    public void setId(Long id) {
        this.documentId = id;
    }

    public Long getId() {
        return documentId;
    }
}
