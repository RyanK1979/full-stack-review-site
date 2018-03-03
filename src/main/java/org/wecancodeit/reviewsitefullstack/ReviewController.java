package org.wecancodeit.reviewsitefullstack;

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

	@RequestMapping(value = "/reviews")
	public String getAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String getAReview(@RequestParam Long id, Model model) {
		model.addAttribute("reviews", reviewRepo.findOne(id));
		return "review";
	}

	@RequestMapping("/tags")
	public String showTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/tag")
	public String getATag(@RequestParam Long id, Model model) {
		model.addAttribute("tags", tagRepo.findOne(id));
		return "tag";
	}

	@RequestMapping(value = "/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("/category")
	public String getACategory(@RequestParam Long id, Model model) {
		model.addAttribute("categories", categoryRepo.findOne(id));
		return "category";
	}

}
