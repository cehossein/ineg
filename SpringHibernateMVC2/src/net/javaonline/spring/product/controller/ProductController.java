package net.javaonline.spring.product.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.javaonline.spring.product.model.ContactDescription;
import net.javaonline.spring.product.model.IndividualDescription;
import net.javaonline.spring.product.model.Resume;
import net.javaonline.spring.product.model.User;
import net.javaonline.spring.product.service.ContactDescriptionService;
import net.javaonline.spring.product.service.IndividualDescriptionService;
import net.javaonline.spring.product.service.ResumeService;
import net.javaonline.spring.product.service.UserService;

@Controller
public class ProductController {
	
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
	/*
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
	  
*/	  
	
/*	**************************************************************** 
 *  **************************************************************** */
	
	
		@RequestMapping(value="/index")
	    public ModelAndView index() {
	        ModelAndView model = new ModelAndView("index");
	        return model;
	    }
	 
		
		@RequestMapping(value="/updateIndividualDescription",method = RequestMethod.POST)
		public ModelAndView updateIndividualDescription(@ModelAttribute("user") User user) {
		    ModelAndView model = new ModelAndView("updateIndividualDescription");
		    model.addObject("username", user.getUsername());
		    /*This is OK*/
			return model;
		}
		

		  @RequestMapping(value = "/executeUpdateIndividualDescription" , method = RequestMethod.POST)
		    public ModelAndView executeUpdateIndividualDescription(@ModelAttribute("individualDescription") IndividualDescription individualDescription , HttpSession httpSession) {
		        ModelAndView model = null ;
		        String username = (String) httpSession.getAttribute("username");
		        if(null != individualDescription ){
		        	System.out.println(username);
		        	System.out.println(individualDescription.getEmail());
		        	System.out.println(individualDescription.getLastname());
		        	System.out.println(individualDescription.getMarriagestatus());
		        	individualDescriptionService.updateByNameAndObject(username, individualDescription);
		            model = new ModelAndView("HomePage");
		            model.addObject("type", "Employee");
	        		model.addObject("username", username);
	        		/*OK*/
		        }
		        return model;
		  }

		@RequestMapping(value="/updateContactDescription",method = RequestMethod.POST)
		public ModelAndView updateContactDescription(@ModelAttribute("user") User user) {
		    ModelAndView model = new ModelAndView("updateContactDescription");
		    model.addObject("username", user.getUsername());
		    /*This is OK*/
			return model;
		}
		

  @RequestMapping(value = "/executeUpdateContactDescription" , method = RequestMethod.POST)
    public ModelAndView executeUpdateContactDescription(@ModelAttribute("contactDescription") ContactDescription contactDescription , HttpSession httpSession) {
        ModelAndView model = null ;
        String username = (String) httpSession.getAttribute("username");
        if(null != contactDescription ){        	
        	/*OK*/
        	contactDescriptionService.updateByNameAndObject(username, contactDescription);
            model = new ModelAndView("HomePage");
            model.addObject("type", "Employee");
    		model.addObject("username", username);
        }
        return model;
  }
		  
		@RequestMapping(value="/updateOther",method = RequestMethod.POST)
		public ModelAndView updateOther(@ModelAttribute("user") User user) {
		    ModelAndView model = new ModelAndView("updateOther");
		    model.addObject("username", user.getUsername());
		    /*This is OK*/
			return model;
		}
		
		  @RequestMapping(value = "/executeUpdateOther" , method = RequestMethod.POST)
		    public ModelAndView executeUpdateOther(@ModelAttribute("resume") Resume resume , HttpSession httpSession) {
		        ModelAndView model = null ;
		        String username = (String) httpSession.getAttribute("username");
		        if(null != resume ){        	
		        	/*OK*/
		        	resumeService.updateByNameAndObject(username, resume);
		            model = new ModelAndView("HomePage");
		            model.addObject("type", "Employee");
		    		model.addObject("username", username);
		        }
		        return model;
		  }
	  
	  @RequestMapping(value = "/signUp", method = RequestMethod.POST)
	    public ModelAndView signUp(@ModelAttribute("user") User user) {
		  String invalidInitialParameter = "Invalid Content";
		  IndividualDescription individualDescription = new IndividualDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
		  ContactDescription contactDescription = new ContactDescription(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
		  Resume resume = new Resume(invalidInitialParameter, invalidInitialParameter, invalidInitialParameter);
		  resume.setIndividualDescription(individualDescription);
		  resume.setContactDescription(contactDescription);
		  user.setResume(resume);
		  individualDescriptionService.add(individualDescription);
		  contactDescriptionService.add(contactDescription);
		  resumeService.add(resume);
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
		        		}
	        	}
	        	else{
		        	model = new ModelAndView("error");
	        	}
	        }
	        return model;
	  }

}


