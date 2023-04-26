package vn.edu.vinaenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.Contact;
import vn.edu.vinaenter.model.Land;
import vn.edu.vinaenter.model.dao.CategoryDao;
import vn.edu.vinaenter.model.dao.ContactDao;
import vn.edu.vinaenter.model.dao.LandDAO;

@Controller

public class PublicController {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private LandDAO landDAO;
	@Autowired
	private ContactDao contactDao;
	@ModelAttribute
	void commonObject(ModelMap modelMap) {
		modelMap.addAttribute("LandDAO", landDAO);
		modelMap.addAttribute("categories",categoryDao.getItems());
	}
	@GetMapping("index")
	public String cland(@RequestParam(required = false,name = "page") Integer page  ,ModelMap modelMap ) {
		//sotin
		int numberOfitems = landDAO.countItems();
		//sotrang
		int numberOfpage = (int)Math.ceil(numberOfitems *1.0 / Defines.ROW_COUNT);
		if(page == null) {
			page = 1 ;
		}else if (page < 1 ){
			return "redirect:/?page=1";
		}else if(page > numberOfpage) {
			return "redirect:/?page=" + numberOfpage;
		}
		//trang hien tai
		int ofset = (page - 1) * Defines.ROW_COUNT;
		 List<Land> lands = landDAO.getItemsPagination(ofset);
		 modelMap.addAttribute("lands",lands);
		 modelMap.addAttribute("page",page);
		 modelMap.addAttribute("numberOfpage",numberOfpage);
		return"cland.public.index";
	}
	
	@GetMapping("lien-he")
	public String contact() {		
		return"cland.public.contact";
	}
	@PostMapping("lien-he")
	public String contact(@Valid @ModelAttribute("contact") Contact contact,RedirectAttributes ra) {	
		if(contactDao.add(contact) > 0) {
			ra.addFlashAttribute("msg","Thêm Liên hệ thành công");
			return "redirect:/lien-he";
		}else {
			ra.addFlashAttribute("msg","Thêm Liên hệ Thất Bại");
			return "redirect:/lien-he";
		}
		
	}



	
	@GetMapping("{landname}-{id}.html")
	public String single(@PathVariable int id,ModelMap modelMap) {	
		Land land = landDAO.getItem(id);
		List<Land> lands = landDAO.getRelatedTiem(land ,3);
		modelMap.addAttribute("land",land);
		modelMap.addAttribute("lands",lands);
		return"cland.public.single";
	}
	
	@GetMapping("danh-muc/{canme}-{cid}")
	public String cat(@PathVariable int cid,ModelMap modelMap) {
		
		List<Land>lands = landDAO.getItemsByCategoryId(cid);
		modelMap.addAttribute("lands",lands);
		Category category = categoryDao.getItems(cid);
		modelMap.addAttribute("category",category);
		return"cland.public.cat";
	}

	
}
