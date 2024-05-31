package domain.Exception;

public class ErrorUncheck extends RuntimeException{
    public ErrorUncheck(){
        super();
    }
    public ErrorUncheck(String message){
        super(message);
    }
    public ErrorUncheck(Throwable cause){
        super(cause);
    }
    public ErrorUncheck(String message, Throwable cause){
        super(message,cause);
    }
}
