package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private String category;

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	@ManyToMany
	private Collection<Tag> tags;

	public Collection<Review> getReviews() {
		return reviews;
	}

	@SuppressWarnings("unused")
	private Category() {
	}

	public Category(String category, Tag... tags) {
		this.category = category;
		this.tags = new HashSet<>(asList(tags));

	}

	public Category(String category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

}
