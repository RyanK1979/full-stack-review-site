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

	@Id
	@GeneratedValue
	private long id;
	private String showName;
	private String imageUrl;
	private String showReview;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	public Collection<Tag> getTags() {
		return tags;
	}

	public String getName() {
		return showName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getShowReview() {
		return showReview;
	}

	public Category getCategory() {
		return category;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@SuppressWarnings("unused")
	Review(String name, Tag sports) {
	}

	public Review(String showReview, String showName, String imageUrl, Category category, Tag... tags) {
		this.showName = showName;
		this.showReview = showReview;
		this.imageUrl = imageUrl;
		this.category = category;
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
