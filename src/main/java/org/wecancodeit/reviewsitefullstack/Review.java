package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	public Review(String name, Category category) {
		this.name = name;
		this.category = category;
	}

	public Review(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@SuppressWarnings("unused")
	private Review() {
	}

	public Review(String name, Tag... tags) {
		this.name = name;
		this.tags = new HashSet<>(asList(tags));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Review) obj).id;
	}

}
