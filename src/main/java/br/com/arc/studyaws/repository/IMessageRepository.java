package br.com.arc.studyaws.repository;

import br.com.arc.studyaws.repository.entity.Message;

import java.util.Optional;

public interface IMessageRepository {
    Message save(Message message);
    Optional<Message> findByDate(Message message);
}
