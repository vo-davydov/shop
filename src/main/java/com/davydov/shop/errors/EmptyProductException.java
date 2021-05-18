package com.davydov.shop.errors;

public class EmptyProductException extends RuntimeException {
  public EmptyProductException() {
    super();
  }

  public EmptyProductException(String message, Throwable cause) {
    super(message, cause);
  }

  public EmptyProductException(String message) {
    super(message);
  }

  public EmptyProductException(Throwable cause) {
    super(cause);
  }
}
