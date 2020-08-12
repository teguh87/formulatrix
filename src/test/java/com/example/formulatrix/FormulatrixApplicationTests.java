package com.example.formulatrix;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.formulatrix.controllers.*;
import com.example.formulatrix.models.*;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class FormulatrixApplicationTests {

	MockMvc mockMvc;

	private List<Content> contents;

	@Autowired
	RegisterController registerController;

	@Test
	void contextLoads() {
	}

	@Before
    public void setup() throws Exception {
		this.mockMvc = standaloneSetup(this.registerController).build();// Standalone context
		contents = new ArrayList();
		// contents.add(new Content("annon1", "<Register><firstname>Nemo</firstname><lastname>NoBody</lastname><email>nemo@example.com</email><password>123456</password><phoneNumber>+628177728172</phoneNumber><address>Anywhere</address></Register>", 2));
		// contents.add(new Content("annon2", "<Register><firstname>Setyo</firstname><lastname>Nugroho</lastname><email>setyo@example.com</email><password>123456</password><phoneNumber>+62883881777</phoneNumber><address>Anywhere</address></Register>", 2));
		// contents.add(new Content("annon3", "{\"Register\":{\"firstname\":\"Aprilia\",\"lastname\":\"Sadewa\",\"email\":\"aprillia@example.com\",\"password\":\"123456\",\"phoneNumber\":\"+6281772663773\",\"address\":\"Anywhere\"}}", 1));
	}
}
