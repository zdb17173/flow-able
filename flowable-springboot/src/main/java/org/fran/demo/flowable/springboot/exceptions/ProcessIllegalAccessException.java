package org.fran.demo.flowable.springboot.exceptions;

public class ProcessIllegalAccessException extends RuntimeException{
    public ProcessIllegalAccessException(String message){
        super(message);
    }

    public ProcessIllegalAccessException(String message, Throwable e){
        super(message, e);
    }

    public ProcessIllegalAccessException(Throwable cause) {
        super(cause);
    }
}
