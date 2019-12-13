package pers.ZJ.StepWebDriver.exception;

public class WebDriverException extends RuntimeException{

    private String message;

    public WebDriverException(String message){
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