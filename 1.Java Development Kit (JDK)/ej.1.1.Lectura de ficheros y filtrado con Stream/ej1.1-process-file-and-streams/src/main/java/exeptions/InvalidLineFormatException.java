package exeptions;

public class InvalidLineFormatException extends Exception{
    public InvalidLineFormatException(){}

    public InvalidLineFormatException(String message){
        super(message);
    }
}
