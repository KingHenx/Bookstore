
package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/category")
	public String category(Model model) {
		
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "categorylist";
	}
	
	@RequestMapping(value = "/addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:category";
	}
	
	@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
		categoryRepository.deleteById(categoryId);
		return "redirect:../category";
	}
	
}


