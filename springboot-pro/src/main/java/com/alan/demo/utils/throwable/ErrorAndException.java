package com.alan.demo.utils.throwable;

import java.io.FileNotFoundException;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/26
 */

public class ErrorAndException {

    private void throwError() {
        throw new StackOverflowError();
    }

    private void throwRuntimeException() {

    }

    private void throwCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main(String[] args) {
        ErrorAndException eae = new ErrorAndException();

    }
}
