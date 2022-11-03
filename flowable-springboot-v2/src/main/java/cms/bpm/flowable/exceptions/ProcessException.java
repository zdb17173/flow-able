package cms.bpm.flowable.exceptions;

/**
 * @author qiushi
 * @date 2022/10/31
 */
public class ProcessException extends RuntimeException{
    public ProcessException(String message){
        super(message);
    }

    public ProcessException(String message, Throwable e){
        super(message, e);
    }

    public ProcessException(Throwable cause) {
        super(cause);
    }
}
