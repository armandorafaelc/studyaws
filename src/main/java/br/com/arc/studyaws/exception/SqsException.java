package br.com.arc.studyaws.exception;

public class SqsException extends Exception{
    public SqsException(String message){
        super(message);
    }
}
