package com.vk.jenkinp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class JenkincicdApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test

	public void testGreetingsEndpoint()throws Exception{
		String name ="jothi vk";

		mockMvc.perform(MockMvcRequestBuilders.get("/greetings/{name}",name))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello " + name.split(" ")[0]+ " Greetings from Jenkins CI-CD Flow...."));
	}

}
