package com.kodak.selenium.ui;

import org.openqa.selenium.WebElement;

public class Exceptions {

	public Exceptions() {
		// TODO Auto-generated constructor stub
	}

	public static class ObjectNotDefinedException extends KodakException {

		private static final long serialVersionUID = 837970244862715270L;

		public ObjectNotDefinedException(String id) {
			super("The object id is not defined in Repository file:" + id);
			// TODO Auto-generated constructor stub
		}

	}

	public static class TypeIncorrectException extends KodakException {

		private static final long serialVersionUID = -3262962246049163246L;

		public TypeIncorrectException(String expectedType, WebElement unexpected) {
			super(String.format("Expected type is:%s, but given %s", expectedType, unexpected));
		}

	}

	public static class ObjectDefinitionError extends KodakException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ObjectDefinitionError(String id, String type, String value) {

			super("Definition for [%s] error:%s=%s", id, type, value);

		}
	}
}
