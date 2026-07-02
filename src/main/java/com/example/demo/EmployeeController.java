package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	//============================ Home=====================
	@GetMapping("/")
	public String Home()
	{
		return "Home";
	}
	//========================Insert=====================
	@GetMapping("/insert")
	public String insertPage()
	{
		return "index";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam int id,@RequestParam String name,@RequestParam double sal)
	{
		Employee emp=new Employee(id,name,sal);
		dao.StoreData(emp);
		return "redirect:/read";
	}
	//===============================Read==========================
	@GetMapping("/read")
	public String read(Model model)
	{
		List<Employee>emp=dao.getData();
		model.addAttribute("emp",emp);
		return "read";
	}
	//================================Update===============================
	@GetMapping("/update")
	public String updatepage()
	{
		return "update";
	}
	@PostMapping("/update")
	public String update(@RequestParam int id,@RequestParam String name,@RequestParam double sal)
	{
		Employee emp=new Employee(id,name,sal);
		 dao.Update(emp);
		 return "redirect:/read";
	}
	@GetMapping("/delete")
	public String deletepage()
	{
		return "delete";
	}
	@PostMapping("/delete")
	public String delete(@RequestParam int id)
	{
		Employee emp=new Employee();
		dao.Delete(id);
		return "redirect:/read";
	}
	
	
	
}
