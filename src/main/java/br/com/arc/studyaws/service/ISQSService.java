package br.com.arc.studyaws.service;

public interface ISQSService {
    void send(final String queue,final String message);
}
