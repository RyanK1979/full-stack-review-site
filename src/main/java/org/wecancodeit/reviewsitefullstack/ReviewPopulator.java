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
		Tag action = new Tag("Action");
		tagRepo.save(action);
		Tag adventure = new Tag("Adventure");
		tagRepo.save(adventure);
		Tag comedy = new Tag("Comedy");
		tagRepo.save(comedy);
		Tag suspense = new Tag("Suspense");
		tagRepo.save(suspense);
		Tag romance = new Tag("Romance");
		tagRepo.save(romance);
		Tag horror = new Tag("Horror");
		tagRepo.save(horror);
		Tag sports = new Tag("Sports");
		tagRepo.save(sports);
		Tag scifi = new Tag("Sci-fi");
		tagRepo.save(scifi);
		Category movies = new Category("Movies");
		categoryRepo.save(movies);
		Category series = new Category("Series");
		categoryRepo.save(series);
		Review review1 = new Review(
				"One of the first movies I remember going to see.  Amazing adventure, really holds up even if the special effects do not.  I still watch it every time"
						+ "it is on",
				"Goonies", "./images/goonies.jpg", movies, action, adventure, comedy);
		reviewRepo.save(review1);
		Review review2 = new Review(
				"Awesome series, I binged watched both seasons.  The kids have great chemistry together, and yet it still remains funny through out, I highly recommend "
						+ "for the handful of people who have yet to watch.",
				"Stranger Things", "./images/strangerthings.jpg", series, adventure, action, scifi);
		reviewRepo.save(review2);
		Review review3 = new Review(
				"This series started out so strong. I really lose intrest heavily in the last few years, to the point I didn't even make it through the entirety of the"
						+ "last season.  I still highly recommend the first few seasons though",
				"Orange is the new Black", "./orangeblack.jpg", series, comedy, suspense, romance);
		reviewRepo.save(review3);
		Review review4 = new Review(
				"Highly enjoyable show.  I laugh at things I should never laugh at on here, and watching Frank scheme so he never has to work is so funny.  It will make you "
						+ "question yourself afterwards for finding it so hilarious.  One of my favorite shows on TV",
				"Shameless", "./images/shameless.jpg", series, comedy, suspense, romance);
		reviewRepo.save(review4);
		Review review5 = new Review(
				"One of the most visually stunning movies ever.  This is the movie that made me buy a 3D tv for my house.  I still show people this movie when they ask"
						+ "why I wasted my money on the technology!  Just a really great movie, and I highly recommend it.",
				"Avatar", "./images/avatar.jpg", movies, action, adventure, romance);
		reviewRepo.save(review5);
		Review review6 = new Review(
				"One of the cheesiest, yet hilarious, and entertaining movies ever.  The special effects look so bad by today's standards.  Kurt Russell though is amazing"
						+ "in this role as Jack Burton.  I still watch this bluray from time to time when I need to laugh.",
				"Big Trouble in Little China", "./images/bigtrouble.jpg", movies, action, adventure, romance);
		reviewRepo.save(review6);
		Review review7 = new Review(
				"One of the greatest sports movies in history.  I may be biased by my love of baseball.  It always reminds me of dad, and the connection we always shared"
						+ "in going to games, and watching, and of course seeing the movie.  I have this in my personal top 10 of movies that I love",
				"Field of Dreams", "./images/dreams.jpg", movies, sports, adventure, romance);
		reviewRepo.save(review7);

	}
}
