package br.com.arc.studyaws.repository.impl;

import br.com.arc.studyaws.exception.DynamoException;
import br.com.arc.studyaws.repository.IMessageRepository;
import br.com.arc.studyaws.repository.entity.Message;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class MessageRepository implements IMessageRepository {

    @Autowired
    private DynamoDBMapper mapper;

    @Override
    public Message save(Message message) {
        try {
            mapper.save(message);
            log.info("Inserido dados com sucesso no dynamo.");
            return message;
        }catch (Exception e){
            throw new DynamoException("Erro ao gravar dados no banco. " + e.getMessage());
        }

    }

    @Override
    public Optional<Message> findByDate(Message message) {
        return Optional.empty();
    }
}
