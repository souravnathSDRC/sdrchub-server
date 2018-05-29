package com.sdrc.sdrchub.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SopController {
	
	@RequestMapping("/test")
	public String exceptionHandlerTest() {
		return "sdrc-hub";
	}
}
