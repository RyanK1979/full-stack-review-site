package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TagRepository tagRepo;

	@Resource
	CategoryRepository categoryRepo;

	@RequestMapping("/review")
	public String getAReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("tag", tagRepo.findOne(id));
		return "review";
	}

	@RequestMapping("/reviews")
	public String showAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	// @RequestMapping("/tag")
	// public String getATag(@RequestParam(value = "id", required = true) long
	// tagId, Model model) {
	// Tag tag = tagRepo.findOne(tagId);
	// model.addAttribute("tag", tag);
	// return "tag";
	// }
	//
	// @RequestMapping("/tags")
	// public String showAllTags(Model model) {
	// model.addAttribute("tags", tagRepo.findAll());
	// return "tags";
	// }

	@RequestMapping("/categories")
	public String getCategories(Model model) {
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "categories";
	}

	@RequestMapping("/category")
	public String getCategory(@RequestParam long id, Model model) {
		Category category = categoryRepo.findOne(id);
		model.addAttribute("category", category);
		model.addAttribute("review", reviewRepo.findOne(id));
		model.addAttribute("reviews", reviewRepo.findByCategory(category));
		return "category";
	}

	@RequestMapping(value = "/index")
	public String getAllTables(Model model) {
		Collection<Review> reviews = (Collection<Review>) reviewRepo.findAll();
		model.addAttribute("reviews", reviews);
		Collection<Category> categories = (Collection<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		return "index";

	}

}
