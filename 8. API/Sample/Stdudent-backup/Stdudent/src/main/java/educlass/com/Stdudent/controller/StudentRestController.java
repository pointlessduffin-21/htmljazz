package educlass.com.Stdudent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	@GetMapping("/testrest")
	public String testmethod()
	{
		return "hello";
	}

}
