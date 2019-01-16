package java2.homework2.MyExceptions;

public class MyArraySizeException extends Exception {

    private String error;

    public MyArraySizeException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
