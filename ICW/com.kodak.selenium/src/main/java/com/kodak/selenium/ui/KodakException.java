package com.kodak.selenium.ui;

public class KodakException extends Exception {

	private static final long serialVersionUID = -2246839662214048197L;

	public KodakException() {
		// TODO Auto-generated constructor stub
	}

	public KodakException(String format, Object... args) {

		super(String.format("[Kodak selenium]:" + format, args));
		// TODO Auto-generated constructor stub
	}

	public KodakException(String message) {
		super("[Kodak selenium]:" + message);
		// TODO Auto-generated constructor stub
	}

	public KodakException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public KodakException(String message, Throwable cause) {
		super("[Kodak selenium]:" + message, cause);
		// TODO Auto-generated constructor stub
	}

	public KodakException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super("[Kodak selenium]:" + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
