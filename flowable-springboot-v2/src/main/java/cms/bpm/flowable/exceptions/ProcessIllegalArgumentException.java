package cms.bpm.flowable.exceptions;

/**
 * @author qiushi
 * @date 2022/10/31
 */
public class ProcessIllegalArgumentException extends ProcessException{
    public ProcessIllegalArgumentException(String message) {
        super(message);
    }

    public ProcessIllegalArgumentException(String message, Throwable e) {
        super(message, e);
    }

    public ProcessIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
