package com.example.exception;


@SuppressWarnings("serial")
public class CustomException extends RuntimeException{

	public CustomException(String message) {
		super(message);
	}
}
