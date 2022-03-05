package br.com.arc.studyaws.exception;

public class DynamoException extends RuntimeException{
    public DynamoException(String message){
         super(message);
    }
}
