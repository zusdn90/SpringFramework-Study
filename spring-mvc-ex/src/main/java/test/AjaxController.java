package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax/test")
public class AjaxController {
	
	@RequestMapping("/hello")
	public String sayHello(){
		return "Hello World";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO sendVO(){
		SampleVO sample = new SampleVO();
		sample.setSampleNo(1);
		sample.setFirstName("더블");
		sample.setLastName("에스");
		
		return sample;
	}
	
}
