package cms.bpm.flowable.exceptions;

/**
 * @author qiushi
 * @date 2022/10/31
 */
public class ProcessIllegalAccessException extends ProcessException{
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
