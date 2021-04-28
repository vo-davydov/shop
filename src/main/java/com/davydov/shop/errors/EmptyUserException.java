package com.davydov.shop.errors;

public class EmptyUserException extends RuntimeException{
  public EmptyUserException() {
    super();
  }

  public EmptyUserException(String message, Throwable cause) {
    super(message, cause);
  }

  public EmptyUserException(String message) {
    super(message);
  }

  public EmptyUserException(Throwable cause) {
    super(cause);
  }
}
