package vn.edu.vinaenter.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.Land;
import vn.edu.vinaenter.model.dao.CategoryDao;
import vn.edu.vinaenter.model.dao.LandDAO;
import vn.edu.vinaenter.util.FileNameUtil;

@Controller
@RequestMapping("admin/land")
public class AdminLandController {
	
	@Autowired
	private LandDAO landDAO;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private  ServletContext servletContext;
	
	@GetMapping("index")
	public String index(@RequestParam(required = false,name = "page") Integer page,ModelMap modelMap) {
		
		int numberOffitems = landDAO.countItems();
		int numberOffpages =(int) Math.ceil(numberOffitems * 1.0 / Defines.ROW_COUNT);
		if(page == null) {
			page = 1;
		}else if(page < 0) {
			return "redirect:/admin/land/index";
		}else if(page > numberOffpages ){
			return "redirect:/admin/land/index?page=2";
		}
		
		System.out.println(page);
		
		int offset = (page - 1) * Defines.ROW_COUNT ;
		List<Land> lands = landDAO.getItemsPagination(offset);
		modelMap.addAttribute("lands",lands);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("numberOffpages",numberOffpages);
		return "cland.admin.land.index";
	}
	
	@GetMapping("add")
	public String add(ModelMap modelMap) {
		
		modelMap.addAttribute("categories",categoryDao.getItems());
		return "cland.admin.land.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("land") Land land ,BindingResult rs,ModelMap modelMap,@RequestParam("cid") int cid,
			@RequestParam("image") CommonsMultipartFile cmf ,RedirectAttributes ra) {			
		land.setCategory(new Category(cid,null));		
	
		if(rs.hasErrors()) {
			modelMap.addAttribute("categories",categoryDao.getItems());
			return "cland.admin.land.add";
		}
		String fileName = FileNameUtil.rename(cmf.getOriginalFilename());
		land.setPicture(fileName);
		
		if(landDAO.add(land) > 0) {
			String dirPath = servletContext.getRealPath("")+ "WEB-INF" + java.io.File.separator + Defines.DIR_UPLOAD;
			System.out.println(dirPath);
			java.io.File dir = new java.io.File(dirPath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			String filePath = dirPath + java.io.File.separator + fileName ; 
			try {
				cmf.transferTo(new java.io.File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/land/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/land/index";
		}						
	}
	@GetMapping("del/{id}")	
	public String del(@PathVariable int id,RedirectAttributes ra) {
		Land land = landDAO.getItem(id);
		if(landDAO.del(id) > 0 ) {
			
			java.io.File  file = new java.io.File(servletContext.getRealPath("")+ "WEB-INF" + 
			java.io.File.separator + Defines.DIR_UPLOAD + java.io.File.separator + land.getPicture());
			file.delete();
			ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);			
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);			
		}
		return "redirect:/admin/land/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id,ModelMap modelMap) {
		Land land = landDAO.getItem(id);
		modelMap.addAttribute("land", land);
		modelMap.addAttribute("categories", categoryDao.getItems());
		return "cland.admin.land.edit";
	}
	
	@PostMapping("edit/{lid}")
	public String edit(@Valid @ModelAttribute("land") Land land ,BindingResult rs,ModelMap modelMap,@RequestParam("cid") int cid,
			@RequestParam("image") CommonsMultipartFile cmf ,RedirectAttributes ra) {	
		land.setCategory(new Category(cid,null));	
		Land oldLand = landDAO.getItem(land.getLid());
		String filename= "";
		if("".equals(cmf.getOriginalFilename())) {
			land.setPicture(oldLand.getPicture());
		}else {
			filename = FileNameUtil.rename(cmf.getOriginalFilename());
			land.setPicture(filename);
		}
		if(rs.hasErrors()) {			
			land.setPicture(oldLand.getPicture());
			modelMap.addAttribute("categories",categoryDao.getItems());
			return "cland.admin.land.edit";
		}
		if(landDAO.edit(land) > 0) {
			if(!"".equals(filename)) {
				String dirPath = servletContext.getRealPath("")+ "WEB-INF" + java.io.File.separator + Defines.DIR_UPLOAD;
				System.out.println(dirPath);
				java.io.File dir = new java.io.File(dirPath);
				if(!dir.exists()) {
					dir.mkdir();
				}
				//xoa anh cu
				File oldFile = new File(dirPath + File.separator + oldLand.getPicture()); 
				oldFile.delete();
				//upload anh moi
				try {
					cmf.transferTo(new File(dirPath + File.separator+filename));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ra.addFlashAttribute("msg",Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/land/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/land/index";
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
