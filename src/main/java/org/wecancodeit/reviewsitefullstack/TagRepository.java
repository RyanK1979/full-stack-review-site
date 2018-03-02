package org.wecancodeit.reviewsitefullstack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TagRepository {

	@Id
	@GeneratedValue
	private long id;
	private String name;

}
