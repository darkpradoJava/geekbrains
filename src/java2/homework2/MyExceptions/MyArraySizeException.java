package java2.homework2.MyExceptions;

/**
 * @author Stanislav Melekhin
 * Created on 16/01/2019
 */

public class MyArraySizeException extends Exception {

    private String error;

    public MyArraySizeException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
