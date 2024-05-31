package domain.Exception;

public class ErrorCheck extends Exception{
    public ErrorCheck(){
        super();
    }
    public ErrorCheck(String message){
        super(message);
    }
    public ErrorCheck(Throwable cause){
        super(cause);
    }
    public ErrorCheck(String message, Throwable cause){
        super(message,cause);
    }
}
