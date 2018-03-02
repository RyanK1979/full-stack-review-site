package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private TagRepository tagRepo;

	@Resource
	private CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {
		Tag sports = new Tag("Sports");
		sports = tagRepo.save(sports);
		Tag design = new Tag("design");
		design = tagRepo.save(design);
		// we save on the *one* side of the relationship first
		Category category = categoryRepo.save(new Category("Java One", sports, design));
		// then the things on the *many* side.
		reviewRepo.save(new Review("Head First Java", category));
		reviewRepo.save(new Review("Head First Design Patterns", category));
	}
}
