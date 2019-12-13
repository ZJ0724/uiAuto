package pers.ZJ.StepWebDriver.exception;

public class BugException extends RuntimeException{

    private String message;

    public BugException(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}