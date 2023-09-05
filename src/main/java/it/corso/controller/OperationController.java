package it.corso.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Operation;
import it.corso.service.OperationService;

@Controller
@RequestMapping("/operation")
public class OperationController
{
	@Autowired
	private OperationService operationService;
	
	@GetMapping
	public String getPage(Model model)
	{
		model.addAttribute("operation", new Operation());
		return "operation";
	}
	
	@PostMapping
	public String registerOperation(
			@Valid @ModelAttribute("operation") Operation operation, 
			BindingResult result)
	{
		if(result.hasErrors())
			return "operation";
		operationService.createOperation(operation);
		return "redirect:/";
	}
}