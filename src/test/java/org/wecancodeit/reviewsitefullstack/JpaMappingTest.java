package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class JpaMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	RagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadReview() {
		Review review = reviewRepo.save(new Review("its name"));
		review = reviewRepo.save(review);
		// more concise to do:
		// Course course = courseRepo.save(new Course("its name", "its description"));
		long reviewId = review.getId();

		entityManager.flush(); // forces pending stuff to happen
		entityManager.clear(); // detaches all entities, forces jpa to hit the db when we try to find an entity

		review = reviewRepo.findOne(reviewId);

		assertThat(review.getName(), is("its name"));
	}

	@Test
	public void shouldSaveReviewToCategoryRelationship() {

		Category category = new Category("its name");
		// first we save the thing that does NOT own the relationship (so that we have
		// an id to be used as a foreign key)
		categoryRepo.save(category);
		long categoryId = category.getId();

		Review first = new Review("foo", category);
		reviewRepo.save(first);

		Review second = new Review("bar", category);
		reviewRepo.save(second);

		entityManager.flush(); // forces pending stuff to happen
		entityManager.clear(); // forces jpa to hit the db when we try to find it

		category = categoryRepo.findOne(categoryId);
		assertThat(category.getReviews(), containsInAnyOrder(first, second));
	}

	@Test
	public void shouldSaveAndLoadRag() {
		Tag tag = tagRepo.save(new Tag("its name"));
		long tagId = tag.getId();

		entityManager.flush(); // forces jpa to hit the db when we try to find it
		entityManager.clear();

		tag = tagRepo.findOne(tagId);
		assertThat(tag.getName(), is("its name"));
	}

}
