package org.baron.framework.core.exception;

/**
 * Created by User on 2017/5/15.
 */
public class AjaxJsonException extends RuntimeException{

    public AjaxJsonException(String message){
        super(message);
    }

    public AjaxJsonException(Throwable cause)
    {
        super(cause);
    }

    public AjaxJsonException(String message,Throwable cause)
    {
        super(message,cause);
    }


}
