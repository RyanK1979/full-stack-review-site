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
	private String categoryName;

	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	@SuppressWarnings("unused")
	private Category() {
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Category) obj).id;
	}

}
