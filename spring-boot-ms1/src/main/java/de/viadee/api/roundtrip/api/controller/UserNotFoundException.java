package de.viadee.api.roundtrip.api.controller;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String id) {
		super("Could not find user " + id);
	}
}
