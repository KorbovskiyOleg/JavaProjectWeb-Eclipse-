package com.olegkorbovskij.cardatabase;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {
	
	 @Autowired
	 private MockMvc mockMvc;
	 
	 @Test
	 @DisplayName("Four example test case")
		void testAuthentication() throws Exception {
			// Testing authentication with correct credentials
			this.mockMvc
					.perform(post("/login").content("{\"username\":\"admin\",\"password\":\"admin\"}")
							.header(HttpHeaders.CONTENT_TYPE, "application/json"))
					.andDo(print()).andExpect(status().isOk());
		}
	 

}
