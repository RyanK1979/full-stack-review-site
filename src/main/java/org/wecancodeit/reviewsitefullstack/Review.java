package org.wecancodeit.reviewsitefullstack;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String image;
	@Lob
	private String content;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	public Review(String content, String name, String image, Category category, Tag... tags) {
		this.name = name;
		this.content = content;
		this.image = image;
		this.category = category;
		this.tags = new HashSet<>(asList(tags));
	}

	public Review(long id, Category category) {
		this.id = id;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public String getContent() {
		return content;
	}

	public Collection<Tag> getTags() {
		return tags;
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
	private Review() {
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
