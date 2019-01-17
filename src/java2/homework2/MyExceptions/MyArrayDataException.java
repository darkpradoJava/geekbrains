package java2.homework2.MyExceptions;

/**
 * @author Stanislav Melekhin
 * Created on 16/01/2019
 */

public class MyArrayDataException extends Exception {

    private String strError;

    public MyArrayDataException(int i, int j) {
        strError = "Array element on [" + i + "][" + j + "] is not parseInt!";
    }

    public String getStrError() {
        return strError;
    }

}
