package com.dxctraining.inventorymgt_mvc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt_mvc.sprint6_supplier.entiites.Supplier;
import com.dxctraining.inventorymgt_mvc.sprint6_supplier.service.ISupplierService;

@Controller
public class SupplierController {

	@Autowired
	private ISupplierService supplierService;
	
	@PostConstruct
	public void init() {
		
		Supplier supplier1=new Supplier("John");
		int id1=supplier1.getId();
		supplier1=supplierService.save(supplier1);
		
		Supplier supplier2=new Supplier("Sam");
		int id2=supplier1.getId();
		supplier2=supplierService.save(supplier2);
	}
	
	@GetMapping("/supplier")
	public ModelAndView employeeDetails(@RequestParam("id") int id) {
		Supplier supplier = supplierService.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("supplierDetails", "supplier", supplier);
		return modelAndView;
	}

}
