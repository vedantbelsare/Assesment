package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class DemoController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String welcome()

	{
		return "index";
	}
	
	@RequestMapping("/login")
	public ModelAndView requestLogin(@RequestParam String user, @RequestParam String password)
	{
		ModelAndView modelAndView;
		if ((user.equals("user")) && (password.equals("password"))) {
			modelAndView = new ModelAndView("home");
		} else {
			modelAndView = new ModelAndView("index");
		}
		return modelAndView;
	}
	
	@GetMapping("/home")
	public String homePage()
	{
		return "home";
	}

	
	//add employees
	@GetMapping("/addEmp")
	public ModelAndView addEmpGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("addEmp");
		Employee e=new Employee();
		mv.addObject("emp", e);
		return mv;
	}

	@PostMapping("/addEmp")
	public ModelAndView addEmpPost(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		mv.addObject("emp",employeeService.addNewEmployee(e));
		return mv;
	}
	
	
	/// print all employees
	
	
	@GetMapping("/allEmp")
	public ModelAndView allEmp()throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.listEmployees();
		mv.addObject("emps",emps);
		return mv;
	}
	
	
	
	// print employee
	
	
	@GetMapping("/printEmployee")
	public ModelAndView print(@RequestParam("id")Long id)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		Employee e=new Employee();
		
		return mv;
	}
	
	
	
	//update employee
	
	
	@GetMapping("/updateEmp")
	public ModelAndView updateEmp() throws Exception{
		ModelAndView mv=new ModelAndView("updateEmp");
		Employee e=new Employee();
		mv.addObject("emp",e);
		return mv;
	}
	
	@PostMapping("/updateEmp")
	public ModelAndView updateEmpPost(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		mv.addObject("emp",employeeService.updateEmployee(e));
		return mv;
	}
	
	
	//delete employee
	
	
	@GetMapping("/deleteEmp")
	public ModelAndView deleteEmp() throws Exception{
		ModelAndView mv=new ModelAndView("deleteEmp");
		Employee e=new Employee();
		mv.addObject("emp",e);
		return mv;
	}
	
	@PostMapping("/deleteEmployee")
	public ModelAndView deleteEmp(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("deletedEmployee");
		try{
			employeeService.findById(e);
			mv.addObject("emp",employeeService.deleteEmployee(e));
			}
			catch(NoSuchElementException e1)
			{
				System.out.println(e1);
				mv=new ModelAndView("error");
			}
		
		return mv;
	}
	
	//find by id
	
	@GetMapping("/findEmpId")
	public ModelAndView findById() throws Exception{
		ModelAndView mv=new ModelAndView("findEmpId");
		Employee e=new Employee();
		mv.addObject("emp",e);
		return mv;
	}
	
	@PostMapping("/findEmpById")
	public ModelAndView findById(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		try{
		employeeService.findById(e);
		mv.addObject("emp",employeeService.findById(e));
		}
		catch(NoSuchElementException e1)
		{
			System.out.println(e1);
			mv=new ModelAndView("error");
		}
		return mv;
	}
	
	
	//find by designation
	
		@GetMapping("/findEmpByDesig")
		public ModelAndView findByDesignation() throws Exception{
			ModelAndView mv=new ModelAndView("findEmpByDesig");
			Employee e=new Employee();
			mv.addObject("emp",e);
			return mv;
		}
		
		@PostMapping("/findEmpByDesignation")
		public ModelAndView findByDesignation(@RequestParam("designation") String designation)throws Exception
		{
			ModelAndView mv;
			
			if(employeeService.findByDesignation(designation).isEmpty())
			{
				mv=new ModelAndView("error");
			}
			else{
				mv=new ModelAndView("allEmp");
			mv.addObject("emps",employeeService.findByDesignation(designation));
			}
			return mv;
		}
		
		
		
		// find by dept no
		
		
			@GetMapping("/findEmpByDeptNo")
			public ModelAndView findByDeptNo() throws Exception{
				ModelAndView mv=new ModelAndView("findEmpByDeptNo");
				return mv;
			}
			
			@PostMapping("/findEmpBydeptNo")
			public ModelAndView findByDeptNo(@RequestParam("deptNo") int deptNo)throws Exception
			{
				ModelAndView mv;
				
				if(employeeService.findByDeptNo(deptNo).isEmpty())
				{
					mv=new ModelAndView("error");
				}
				else{
					mv=new ModelAndView("allEmp");
				mv.addObject("emps",employeeService.findByDeptNo(deptNo));
				}
				return mv;
			}
			
			
			
			// find by name
			
			
			
			@GetMapping("/findEmpByName")
			public ModelAndView findByName() throws Exception{
				ModelAndView mv=new ModelAndView("findEmpByName");
				return mv;
			}
			
			@PostMapping("/findByName")
			public ModelAndView findByName(@RequestParam("name") String name)throws Exception
			{

				ModelAndView mv;
				
				if(employeeService.findByName(name).isEmpty())
				{
					mv=new ModelAndView("error");
				}
				else{
					mv=new ModelAndView("allEmp");
				mv.addObject("emps",employeeService.findByName(name));
				}
				return mv;
			}
}
