package de.viadee.api.roundtrip.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private String id;
	private String name;

	public User(String name) {
		this.name = name;
	}
}
