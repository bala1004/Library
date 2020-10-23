package com.library.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Genre {
	@Column(name = "genre_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
