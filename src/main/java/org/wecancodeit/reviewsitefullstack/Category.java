package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;
	private String category;

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	public Collection<Review> getReviews() {
		return reviews;
	}

	@SuppressWarnings("unused")
	private Category() {
	}

	public Category(String category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

}
