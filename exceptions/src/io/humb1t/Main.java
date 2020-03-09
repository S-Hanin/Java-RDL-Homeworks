package io.humb1t;

import person.hanin.CloseableResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        try {
            new LifeCycleAction().execute();
        } catch (LifeCycleActionExecutionException | AccessDeniedException | MyShinyMetalException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exceptionVsResult() {
        final String result1 = (String) this.returnResult().value;
        final String result2 = returnOptional().orElse("");
        String result3 = "";
        try {
            result3 = returnValueOrThrowException();
        } catch (AccessDeniedException e) {
        }
    }

    private Result returnResult() {
        return Result.OK.setValue("OK");
    }

    private Optional<String> returnOptional() {
        return Optional.of("OK");
    }

    private String returnValueOrThrowException() throws AccessDeniedException {
        return "OK";
    }

    public static class LifeCycleAction {
        //TODO task1: add exception to `execute` method signature
        public void execute() throws LifeCycleActionExecutionException,
                AccessDeniedException, MyShinyMetalException {
            throw new LifeCycleActionExecutionException();
        }
    }

    public static class LifeCycleActionExecutionException extends Exception {
    }

    //TODO task1: create your own exception class
    public static class MyShinyMetalException extends Exception {
    }
}
