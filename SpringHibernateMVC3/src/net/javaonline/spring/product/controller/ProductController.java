package net.javaonline.spring.product.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.javaonline.spring.product.dao.ItemMasterDAO;
import net.javaonline.spring.product.model.Advertise;
import net.javaonline.spring.product.model.ContactDescription;
import net.javaonline.spring.product.model.EducationalHistory;
import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.ItemMaster;
import net.javaonline.spring.product.model.Resume;
import net.javaonline.spring.product.model.Skill;
import net.javaonline.spring.product.model.SkillAdvertise;
import net.javaonline.spring.product.model.User;
import net.javaonline.spring.product.model.WorkHistory;
import net.javaonline.spring.product.service.AdvertiseService;
import net.javaonline.spring.product.service.ContactDescriptionService;
import net.javaonline.spring.product.service.EducationalHistoryService;
import net.javaonline.spring.product.service.IndividualDescriptionService;
import net.javaonline.spring.product.service.ResumeService;
import net.javaonline.spring.product.service.SkillAdvertiseService;
import net.javaonline.spring.product.service.SkillService;
import net.javaonline.spring.product.service.UserService;
import net.javaonline.spring.product.service.WorkHistoryService;

@Controller
public class ProductController {
	
	@Autowired
	private ItemMasterDAO itemMasterDao;
	
private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	
private IndividualDescriptionService individualDescriptionService;
	
	@Autowired(required=true)
	@Qualifier(value="individualDescriptionService")
	public void setIndividualDescriptionService(IndividualDescriptionService is){
		this.individualDescriptionService = is;
	}
	
private ContactDescriptionService contactDescriptionService;
	
	@Autowired(required=true)
	@Qualifier(value="contactDescriptionService")
	public void setContactDescriptionService(ContactDescriptionService cs){
		this.contactDescriptionService = cs;
	}

private ResumeService resumeService;
	
	@Autowired(required=true)
	@Qualifier(value="resumeService")
	public void setResumeService(ResumeService rs){
		this.resumeService = rs;
	}
	
private WorkHistoryService workHistoryService;
	
	@Autowired(required=true)
	@Qualifier(value="workHistoryService")
	public void setWorkHistoryService(WorkHistoryService ws){
		this.workHistoryService = ws;
	}
	
private EducationalHistoryService educationalHistoryService;
	
	@Autowired(required=true)
	@Qualifier(value="educationalHistoryService")
	public void setEducationalHistoryService(EducationalHistoryService es){
		this.educationalHistoryService = es;
	}
	
private SkillService skillService;
	
	@Autowired(required=true)
	@Qualifier(value="skillService")
	public void setSkillService(SkillService ss){
		this.skillService = ss;
	}
	
private SkillAdvertiseService skillAdvertiseService;
	
	@Autowired(required=true)
	@Qualifier(value="skillAdvertiseService")
	public void setSkillAdvertiseService(SkillAdvertiseService sas){
		this.skillAdvertiseService = sas;
	}
	
private AdvertiseService advertiseService;
	
	@Autowired(required=true)
	@Qualifier(value="advertiseService")
	public void setAdvertiseService(AdvertiseService as){
		this.advertiseService = as;
	}
	
	
	  @RequestMapping(value="/list")
	    public ModelAndView list() {
	        List<ItemMaster> itemList = itemMasterDao.list();
	        ModelAndView model = new ModelAndView("ItemMasterList");
	        model.addObject("itemList", itemList);
	        return model;
	    }

	  @RequestMapping(value="/loadAddForm")
	    public ModelAndView add() {
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
		   ItemMaster item=new ItemMaster();
           model.addObject("item", item);
	        List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }
	  
	  @RequestMapping(value="/edit")
	    public ModelAndView edit(@RequestParam(value="id", required=true) Long id) {
		  System.out.println("Id= " + id);
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
		   ItemMaster item=  itemMasterDao.getItem(id);
           model.addObject("item", item);
	       List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }
	
	
	  @RequestMapping(value="/delete")
	    public ModelAndView delete(@RequestParam(value="id", required=true) Long id) {
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
	        itemMasterDao.delete(id);
	       List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }
	
	  

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelAndView save(@ModelAttribute("item") ItemMaster item) {
	        System.out.println(item.getItem_name());
	        if(null != item ) 
	        	itemMasterDao.add(item);
	         
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
			item=new ItemMaster();
	        model.addObject("item", item);
	        List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	  }
	  
	  @RequestMapping(value = "/update", method = RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute("item") ItemMaster item) {
	        System.out.println(item.getItem_name());
	        if(null != item ) 
	        	itemMasterDao.update(item);
	         
	        ModelAndView model = new ModelAndView("ItemMasterAdd");
			item=new ItemMaster();
	        model.addObject("item", item);
	        List<ItemMaster> itemList = itemMasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	  }
	  
	  
	
/*	**************************************************************** 
 *  **************************************************************** */
	
	
		@RequestMapping(value="/index")
	    public ModelAndView index() {
	        ModelAndView model = new ModelAndView("index");
	        return model;
	    }
	 
		
		//Skill Advertise
		
		@RequestMapping(value="/deleteSkillsAdvertise")
	    public ModelAndView deleteSkillsAdvertise(@RequestParam(value="id", required=true) int id
	    		, HttpSession httpSession) {
	        ModelAndView model = new ModelAndView("updateSkillsAdvertise");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    int advertiseId = (int) httpSession.getAttribute("advertiseId");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    model.addObject("advertiseId",advertiseId);
		    
	        skillAdvertiseService.remove(id,advertiseId);
	        List<SkillAdvertise> skills = skillAdvertiseService.list(advertiseId);
	        model.addObject("item", new SkillAdvertise());
		    model.addObject("itemList", skills);
		    
	        return model;
	    }
	
	
	@RequestMapping(value="/executeUpdateSkillsAdvertiseAdd",method = RequestMethod.POST)
	public ModelAndView executeUpdateSkillsAdvertiseAdd(@ModelAttribute("additem") SkillAdvertise additem, HttpSession httpSession) {
		ModelAndView model = new ModelAndView("updateSkillsAdvertise");

	    String username = (String) httpSession.getAttribute("username");
	    int resume_id = (int) httpSession.getAttribute("resume_id");
	    int advertiseId = (int) httpSession.getAttribute("advertiseId");
	    String type = (String) httpSession.getAttribute("type");
	    model.addObject("username", username);
	    model.addObject("resume_id", resume_id);
	    model.addObject("type", type);
	    model.addObject("advertiseId",advertiseId);
	    
		skillAdvertiseService.add(additem,advertiseId);
		List<SkillAdvertise> skills = skillAdvertiseService.list(advertiseId);
	    model.addObject("item", new SkillAdvertise());
	    model.addObject("itemList", skills);
	    
	    return model;
	}
	
	
	@RequestMapping(value="/executeUpdateSkillsAdvertiseUpdate",method = RequestMethod.POST)
	public ModelAndView executeUpdateSkillsAdvertiseUpdate(@ModelAttribute("item") SkillAdvertise item, HttpSession httpSession) {
		SkillAdvertise skillAdvertise = (SkillAdvertise) httpSession.getAttribute("exist_item");
		ModelAndView model = new ModelAndView("updateSkillsAdvertise");

	    String username = (String) httpSession.getAttribute("username");
	    int resume_id = (int) httpSession.getAttribute("resume_id");
	    int advertiseId = (int) httpSession.getAttribute("advertiseId");
	    String type = (String) httpSession.getAttribute("type");
	    model.addObject("username", username);
	    model.addObject("resume_id", resume_id);
	    model.addObject("type", type);
	    model.addObject("advertiseId",advertiseId);
	    
		skillAdvertiseService.remove(skillAdvertise.getId(),advertiseId);
		skillAdvertiseService.add(item,advertiseId);
		List<SkillAdvertise> skillsAdvertise = skillAdvertiseService.list(advertiseId);
	    model.addObject("item", new SkillAdvertise());
	    model.addObject("itemList", skillsAdvertise);
	    return model;
	}
	
	
	
			@RequestMapping(value="/updateSkillsAdvertise",method = RequestMethod.POST)
	public ModelAndView updateSkillsAdvertise(@ModelAttribute("user") User user, HttpSession httpSession) {
	    ModelAndView model = new ModelAndView("updateSkillsAdvertise");
	   
	    String username = (String) httpSession.getAttribute("username");
	    int resume_id = (int) httpSession.getAttribute("resume_id");
	    String type = (String) httpSession.getAttribute("type");
	    model.addObject("username", username);
	    model.addObject("resume_id", resume_id);
	    model.addObject("type", type);
	    
	    SkillAdvertise skillAdvertise = new SkillAdvertise();
	    List<SkillAdvertise> skillsAdvertise = skillAdvertiseService.list(resume_id);
	    model.addObject("item", skillAdvertise);
	    model.addObject("itemList", skillsAdvertise);
	    
        return model;
	}
	

	  @RequestMapping(value="/editSkillsAdvertise")
	    public ModelAndView editSkillsAdvertise(@RequestParam(value="id", required=true) int id
	    		, HttpSession httpSession) {
	        ModelAndView model = new ModelAndView("updateSkillsAdvertise");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    int advertiseId = (int) httpSession.getAttribute("advertiseId");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    model.addObject("advertiseId",advertiseId);
		    
			  List<SkillAdvertise> skillsAdvertise = skillAdvertiseService.list(advertiseId);
		        SkillAdvertise skillAdvertise = skillAdvertiseService.getById(id, advertiseId);
		        model.addObject("item", skillAdvertise);
			    model.addObject("itemList", skillsAdvertise);
		    
	        return model;
	    }
//End Skill Advertise
		
		
		
		
		
		
		
		
		@RequestMapping(value="/contactDescription")
		public ModelAndView contactDescription(HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("contactDescription");
		   
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
	        return model;
		}
		
		
		@RequestMapping(value="/createContactDescription",method = RequestMethod.POST)
		public ModelAndView createContactDescription(@ModelAttribute("contactDescription") ContactDescription contactDescription, HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("otherPropertiesInAdv");
		   
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    int contactDescrptionId;
		    contactDescriptionService.add(contactDescription);
		    contactDescrptionId = contactDescriptionService.search(contactDescription);
		    
		    model.addObject("contactDescrptionId" , contactDescrptionId);
	        return model;
		}
		
		
		
		@RequestMapping(value="/executeCreateOtherProperties",method = RequestMethod.POST)
		public ModelAndView executeCreateOtherProperties(@ModelAttribute("advertise") Advertise advertise, HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("updateSkillsAdvertise");//
		   
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    int contactDescrptionId = (int) httpSession.getAttribute("contactDescrptionId");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    advertiseService.add(advertise, resume_id , contactDescrptionId);
		    int advertiseId = advertiseService.search(advertise);
		    model.addObject("advertiseId" , advertiseId);
	        return model;
		}
		
/*		
		@RequestMapping(value="/otherPropertiesInAdv",method = RequestMethod.POST)
		public ModelAndView otherPropertiesInAdv(HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("otherPropertiesInAdv");
		   
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
	        return model;
		}
		
		@RequestMapping(value="/executeCreateOtherProperties",method = RequestMethod.POST)
		public ModelAndView executeCreateOtherProperties(@ModelAttribute("advertise") Advertise advertise, HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("createAdv");
		   
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    advertiseService.add(advertise, resume_id);
		    
		    
		    
	        return model;
		}*/
		
		
		
		
		@RequestMapping(value="/searchResumesBySkill")
	    public ModelAndView searchResumesBySkill(HttpSession httpSession ,HttpServletRequest httpServletRequest) {
	        ModelAndView model = new ModelAndView("SearchResumeResult");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    
		   String search_word = httpServletRequest.getParameter("search_word");
	       List<Resume> resumes  = skillService.list(search_word);
	       model.addObject("item", new Resume());
		   model.addObject("itemList",resumes);
		    
	        return model;
	    }
		
		//Skill
		
		@RequestMapping(value="/deleteSkills")
	    public ModelAndView deleteSkills(@RequestParam(value="id", required=true) int id
	    		, HttpSession httpSession) {
	        ModelAndView model = new ModelAndView("updateSkills");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
	        skillService.remove(id,resume_id);
	        List<Skill> skills = skillService.list(resume_id);
	        model.addObject("item", new Skill());
		    model.addObject("itemList", skills);
		    
	        return model;
	    }
	
	
	@RequestMapping(value="/executeUpdateSkillsAdd",method = RequestMethod.POST)
	public ModelAndView executeUpdateSkillsAdd(@ModelAttribute("additem") Skill additem, HttpSession httpSession) {
		ModelAndView model = new ModelAndView("updateSkills");

	    String username = (String) httpSession.getAttribute("username");
	    int resume_id = (int) httpSession.getAttribute("resume_id");
	    String type = (String) httpSession.getAttribute("type");
	    model.addObject("username", username);
	    model.addObject("resume_id", resume_id);
	    model.addObject("type", type);
	    
		skillService.add(additem,resume_id);
		List<Skill> skills = skillService.list(resume_id);
	    model.addObject("item", new Skill());
	    model.addObject("itemList", skills);
	    
	    return model;
	}
	
	
	@RequestMapping(value="/executeUpdateSkillsUpdate",method = RequestMethod.POST)
	public ModelAndView executeUpdateSkillsUpdate(@ModelAttribute("item") Skill item, HttpSession httpSession) {
		Skill skill = (Skill) httpSession.getAttribute("exist_item");
		ModelAndView model = new ModelAndView("updateSkills");

	    String username = (String) httpSession.getAttribute("username");
	    int resume_id = (int) httpSession.getAttribute("resume_id");
	    String type = (String) httpSession.getAttribute("type");
	    model.addObject("username", username);
	    model.addObject("resume_id", resume_id);
	    model.addObject("type", type);
	    
		skillService.remove(skill.getId(),resume_id);
		skillService.add(item,resume_id);
		List<Skill> skills = skillService.list(resume_id);
	    model.addObject("item", new Skill());
	    model.addObject("itemList", skills);
	    return model;
	}
	
	
	
			@RequestMapping(value="/updateSkills",method = RequestMethod.POST)
	public ModelAndView updateSkills(@ModelAttribute("user") User user, HttpSession httpSession) {
	    ModelAndView model = new ModelAndView("updateSkills");
	   
	    String username = (String) httpSession.getAttribute("username");
	    int resume_id = (int) httpSession.getAttribute("resume_id");
	    String type = (String) httpSession.getAttribute("type");
	    model.addObject("username", username);
	    model.addObject("resume_id", resume_id);
	    model.addObject("type", type);
	    
	    Skill skill = new Skill();
	    List<Skill> skills = skillService.list(resume_id);
	    model.addObject("item", skill);
	    model.addObject("itemList", skills);
	    
        return model;
	}
	

	  @RequestMapping(value="/editSkills")
	    public ModelAndView editSkills(@RequestParam(value="id", required=true) int id
	    		, HttpSession httpSession) {
	        ModelAndView model = new ModelAndView("updateSkills");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
			  List<Skill> skills = skillService.list(resume_id);
		        Skill skill = skillService.getById(id, resume_id);
		        model.addObject("item", skill);
			    model.addObject("itemList", skills);
		    
	        return model;
	    }


	  //End Skill
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		///Educational History
		
		  @RequestMapping(value="/deleteEducationalHistory")
		    public ModelAndView deleteEducationalHistory(@RequestParam(value="studyfield", required=true) String studyfield 
		    		,@RequestParam(value="grade", required=true) String grade 
		    		,@RequestParam(value="academicorientation", required=true) String academicorientation
		    		, HttpSession httpSession) {
		        ModelAndView model = new ModelAndView("updateEducationalHistory");

			    String username = (String) httpSession.getAttribute("username");
			    int resume_id = (int) httpSession.getAttribute("resume_id");
			    String type = (String) httpSession.getAttribute("type");
			    model.addObject("username", username);
			    model.addObject("resume_id", resume_id);
			    model.addObject("type", type);
			    
		        educationalHistoryService.remove(studyfield, grade, academicorientation, resume_id);
		        List<EducationalHistory> educationalHistories = educationalHistoryService.list(resume_id);
		        model.addObject("item", new EducationalHistory());
			    model.addObject("itemList", educationalHistories);
			    
		        return model;
		    }
		
		
		@RequestMapping(value="/executeUpdateEducationalHistoryAdd",method = RequestMethod.POST)
		public ModelAndView executeUpdateEducationalHistoryAdd(@ModelAttribute("additem") EducationalHistory additem, HttpSession httpSession) {
			ModelAndView model = new ModelAndView("updateEducationalHistory");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
			educationalHistoryService.add(additem,resume_id);
			List<EducationalHistory> educationalHistories = educationalHistoryService.list(resume_id);
		    model.addObject("item", new EducationalHistory());
		    model.addObject("itemList", educationalHistories);
		    
		    return model;
		}
		
		
		@RequestMapping(value="/executeUpdateEducationalHistoryUpdate",method = RequestMethod.POST)
		public ModelAndView executeUpdateEducationalHistoryUpdate(@ModelAttribute("item") EducationalHistory item, HttpSession httpSession) {
			ModelAndView model = new ModelAndView("updateEducationalHistory");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    EducationalHistory educationalHistory = (EducationalHistory) httpSession.getAttribute("exist_item");
			educationalHistoryService.remove(educationalHistory.getStudyfield(),educationalHistory.getGrade(),educationalHistory.getAcademicorientation(),resume_id);
			educationalHistoryService.add(item,resume_id);
			List<EducationalHistory> educationalHistories = educationalHistoryService.list(resume_id);
		    model.addObject("item", new EducationalHistory());
		    model.addObject("itemList", educationalHistories);
		    
		    
		    return model;
		}
		
		
		
				@RequestMapping(value="/updateEducationalHistory",method = RequestMethod.POST)
		public ModelAndView updateEducationalHistory(@ModelAttribute("user") User user, HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("updateEducationalHistory");
		    
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    EducationalHistory educationalHistory = new EducationalHistory();
		    List<EducationalHistory> educationalHistories = educationalHistoryService.list(resume_id);
		    model.addObject("item", educationalHistory);
		    model.addObject("itemList", educationalHistories);
		    
	        return model;
		}
		

		  @RequestMapping(value="/editEducationalHistory")
		    public ModelAndView editEducationalHistory(@RequestParam(value="studyfield", required=true) String studyfield 
		    		,@RequestParam(value="grade", required=true) String grade 
		    		,@RequestParam(value="academicorientation", required=true) String academicorientation
		    		, HttpSession httpSession) {
		        ModelAndView model = new ModelAndView("updateEducationalHistory");


			    String username = (String) httpSession.getAttribute("username");
			    int resume_id = (int) httpSession.getAttribute("resume_id");
			    String type = (String) httpSession.getAttribute("type");
			    model.addObject("username", username);
			    model.addObject("resume_id", resume_id);
			    model.addObject("type", type);
			    
				  List<EducationalHistory> educationalHistories = educationalHistoryService.list(resume_id);
				  EducationalHistory educationalHistory = educationalHistoryService.getById(studyfield, grade, academicorientation, resume_id);
			        model.addObject("item", educationalHistory);
				    model.addObject("itemList",educationalHistories);
				    
		        return model;
		    }
		
		
		
		///Educational History
		
		
		
		///Work History
		
	
		  @RequestMapping(value="/deleteWorkHistory")
		    public ModelAndView deleteWorkHistory(@RequestParam(value="startdate", required=true) String startdate 
		    		,@RequestParam(value="finishdate", required=true) String finishdate 
		    		,@RequestParam(value="departmentname", required=true) String departmentname
		    		, HttpSession httpSession) {
		        ModelAndView model = new ModelAndView("updateWorkHistory");

			    String username = (String) httpSession.getAttribute("username");
			    int resume_id = (int) httpSession.getAttribute("resume_id");
			    String type = (String) httpSession.getAttribute("type");
			    model.addObject("username", username);
			    model.addObject("resume_id", resume_id);
			    model.addObject("type", type);
			    
		        workHistoryService.remove(startdate, finishdate, departmentname, resume_id);
		        List<WorkHistory> workHistories = workHistoryService.list(resume_id);
		        model.addObject("item", new WorkHistory());
			    model.addObject("itemList", workHistories);
			    
		        return model;
		    }
		
		
		@RequestMapping(value="/executeUpdateWorkHistoryAdd",method = RequestMethod.POST)
		public ModelAndView executeUpdateWorkHistoryAdd(@ModelAttribute("additem") WorkHistory additem, HttpSession httpSession) {
			ModelAndView model = new ModelAndView("updateWorkHistory");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
			workHistoryService.add(additem,resume_id);
			List<WorkHistory> workHistories = workHistoryService.list(resume_id);
		    model.addObject("item", new WorkHistory());
		    model.addObject("itemList", workHistories);
		    
		    return model;
		}
		
		
		@RequestMapping(value="/executeUpdateWorkHistoryUpdate",method = RequestMethod.POST)
		public ModelAndView executeUpdateWorkHistoryUpdate(@ModelAttribute("item") WorkHistory item, HttpSession httpSession) {
			WorkHistory workHistory = (WorkHistory) httpSession.getAttribute("exist_item");
			ModelAndView model = new ModelAndView("updateWorkHistory");

		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
			workHistoryService.remove(workHistory.getStartdate(),workHistory.getFinishdate(),workHistory.getDepartmentname(),resume_id);
			workHistoryService.add(item,resume_id);
			List<WorkHistory> workHistories = workHistoryService.list(resume_id);
		    model.addObject("item", new WorkHistory());
		    model.addObject("itemList", workHistories);
		    return model;
		}
		
		
		
				@RequestMapping(value="/updateWorkHistory",method = RequestMethod.POST)
		public ModelAndView updateWorkHistory(@ModelAttribute("user") User user, HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("updateWorkHistory");
		   
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    WorkHistory workHistory = new WorkHistory();
		    List<WorkHistory> workHistories = workHistoryService.list(resume_id);
		    model.addObject("item", workHistory);
		    model.addObject("itemList", workHistories);
		    
	        return model;
		}
		

		  @RequestMapping(value="/editWorkHistory")
		    public ModelAndView editWorkHistory(@RequestParam(value="startdate", required=true) String startdate 
		    		,@RequestParam(value="finishdate", required=true) String finishdate 
		    		,@RequestParam(value="departmentname", required=true) String departmentname
		    		, HttpSession httpSession) {
		        ModelAndView model = new ModelAndView("updateWorkHistory");

			    String username = (String) httpSession.getAttribute("username");
			    int resume_id = (int) httpSession.getAttribute("resume_id");
			    String type = (String) httpSession.getAttribute("type");
			    model.addObject("username", username);
			    model.addObject("resume_id", resume_id);
			    model.addObject("type", type);
			    
				  List<WorkHistory> workHistories = workHistoryService.list(resume_id);
			        WorkHistory workHistory = workHistoryService.getById(startdate, finishdate, departmentname, resume_id);
			        model.addObject("item", workHistory);
				    model.addObject("itemList", workHistories);
			    
		        return model;
		    }

		  
		///Work History
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		@RequestMapping(value="/updateIndividualDescription",method = RequestMethod.POST)
		public ModelAndView updateIndividualDescription(@ModelAttribute("user") User user , HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("updateIndividualDescription");
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
			return model;
		}
		

		  @RequestMapping(value = "/executeUpdateIndividualDescription" , method = RequestMethod.POST)
		    public ModelAndView executeUpdateIndividualDescription(@ModelAttribute("individualDescription") IndividualDescription individualDescription , HttpSession httpSession) {
		        ModelAndView model = new ModelAndView("updateIndividualDescription");
		        if(null != individualDescription ){
		        	
		            model = new ModelAndView("HomePage");
				    String username = (String) httpSession.getAttribute("username");
				    int resume_id = (int) httpSession.getAttribute("resume_id");
				    String type = (String) httpSession.getAttribute("type");
				    model.addObject("username", username);
				    model.addObject("resume_id", resume_id);
				    model.addObject("type", type);
				    
				    individualDescriptionService.updateByIdAndObject(resume_id, individualDescription);
	        		/*OK*/
		        }
		        return model;
		  }

		@RequestMapping(value="/updateContactDescription",method = RequestMethod.POST)
		public ModelAndView updateContactDescription(@ModelAttribute("user") User user , HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("updateContactDescription");
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    /*This is OK*/
			return model;
		}
		

  @RequestMapping(value = "/executeUpdateContactDescription" , method = RequestMethod.POST)
    public ModelAndView executeUpdateContactDescription(@ModelAttribute("contactDescription") ContactDescription contactDescription , HttpSession httpSession) {
        ModelAndView model = null ;
        if(null != contactDescription ){        	
            model = new ModelAndView("HomePage");
            
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    contactDescriptionService.updateByIdAndObject(resume_id, contactDescription);
        }
        return model;
  }
  

		  
		@RequestMapping(value="/updateOther",method = RequestMethod.POST)
		public ModelAndView updateOther(@ModelAttribute("user") User user , HttpSession httpSession) {
		    ModelAndView model = new ModelAndView("updateOther");
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    /*This is OK*/
			return model;
		}
		
		  @RequestMapping(value = "/executeUpdateOther" , method = RequestMethod.POST)
		    public ModelAndView executeUpdateOther(@ModelAttribute("resume") Resume resume , HttpSession httpSession) {
		        ModelAndView model = null ;
		        if(null != resume ){        	
		        	/*OK*/

		            model = new ModelAndView("HomePage");
				    String username = (String) httpSession.getAttribute("username");
				    int resume_id = (int) httpSession.getAttribute("resume_id");
				    String type = (String) httpSession.getAttribute("type");
				    model.addObject("username", username);
				    model.addObject("resume_id", resume_id);
				    model.addObject("type", type);
				    
		        	resumeService.updateByNameAndObject(username, resume);
		        }
		        return model;
		  }
	  
	  @RequestMapping(value = "/signUp", method = RequestMethod.POST)
	    public ModelAndView signUp(@ModelAttribute("user") User user) {
		  String invalidInitialParameter = "Invalid Content";
		  String type = user.getType();
		  
		  if(type.equals("Employee")){
			  
			  IndividualDescription individualDescription = new IndividualDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  ContactDescription contactDescription = new ContactDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  WorkHistory workHistory = new WorkHistory(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  EducationalHistory educationalHistory = new EducationalHistory(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  Skill skill = new Skill(invalidInitialParameter);
			  Resume resume = new Resume(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			 
			  resume.setIndividualDescription(individualDescription);
			  resume.setContactDescription(contactDescription);
			  workHistory.setResume(resume);
			  skill.setResume(resume);
			  educationalHistory.setResume(resume);
			  user.setResume(resume);
			  
			  individualDescriptionService.add(individualDescription);
			  contactDescriptionService.add(contactDescription);
			  resumeService.add(resume);
			  workHistoryService.add(workHistory);
			  skillService.add(skill);
			  educationalHistoryService.add(educationalHistory);
		        
		  }
		  else{
			  IndividualDescription individualDescription = new IndividualDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  ContactDescription contactDescription = new ContactDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  ContactDescription contactDescriptionForResume = new ContactDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  Resume resume = new Resume(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
			  Advertise advertise = new Advertise(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);

			  resume.setIndividualDescription(individualDescription);
			  resume.setContactDescription(contactDescriptionForResume);
			  advertise.setContactDescription(contactDescription);
			  advertise.setResume(resume);
			  user.setResume(resume);
			  
			  individualDescriptionService.add(individualDescription);
			  contactDescriptionService.add(contactDescription);
			  contactDescriptionService.add(contactDescriptionForResume);
			  resumeService.add(resume);
			  advertiseService.add(advertise);
		  }
		  
		  

          if(null != user ) 
	        	userService.add(user);
	        ModelAndView model = new ModelAndView("Registration");
	        model.addObject("name", user.getUsername());
	        return model;
	  }


	  @RequestMapping(value="/sign")
	    public ModelAndView sign() {
	        ModelAndView model = new ModelAndView("signUp");
	        return model;
	    }
	  
	  
	  
	  
	  @RequestMapping(value="/HomePage")
	    public ModelAndView displayHomePage(HttpSession httpSession) {
	        ModelAndView model = new ModelAndView("HomePage");
            model = new ModelAndView("HomePage");
		    String username = (String) httpSession.getAttribute("username");
		    int resume_id = (int) httpSession.getAttribute("resume_id");
		    String type = (String) httpSession.getAttribute("type");
		    model.addObject("username", username);
		    model.addObject("resume_id", resume_id);
		    model.addObject("type", type);
		    
		    
	        return model;
	    }
	  
	  @RequestMapping(value="/login")
	    public ModelAndView displayLogin() {
	        ModelAndView model = new ModelAndView("login");
	        return model;
	    }
	  
	  @RequestMapping(value = "/executeLogin", method = RequestMethod.POST)
	    public ModelAndView executeLogin(@ModelAttribute("user") User user) {
	        ModelAndView model = null ;
	        /*This is ok with h.getAttribute("username") that h is HttpSession*/
	        if(null != user ){
	        	String pass = user.getPassword().toString();
	        	User user_in_db = new User();
	        	user_in_db = userService.getUserByUserName(user.getUsername());//dorost shavad.
	        	if(null !=user_in_db){
	        		String user_in_db_pass = user_in_db.getPassword();
		        	if(pass.equals(user_in_db_pass)){
		        		model = new ModelAndView("HomePage");
		        		model.addObject("type", user_in_db.getType());
		        		model.addObject("username", user.getUsername());
		        		model.addObject("resume_id",user_in_db.getResume().getId());
		        	/*ok*/	
		        	}
	        	}
	        	else{
		        	model = new ModelAndView("error");
	        	}
	        }
	        return model;
	  }

}


