package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	Collection<Review> findByCategoryId(long categoryId);

	Collection<Review> findByCategory(Category category);

	Collection<Review> findByTagsContains(Tag tag);

	Collection<Review> findByTagsId(long id);

}
