package hh.swd20.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		
		return "index";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../index";
	}
	
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


