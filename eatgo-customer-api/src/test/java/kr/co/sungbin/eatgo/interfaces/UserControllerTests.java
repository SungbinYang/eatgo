package kr.co.sungbin.eatgo.interfaces;

import kr.co.sungbin.eatgo.application.UserService;
import kr.co.sungbin.eatgo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTests {

    @Autowired
    MockMvc mvc;
    
    @MockBean
    private UserService userService;

    @Test
    void create() throws Exception {

        User mockUser = User.builder().id(1004L).email("tester@example.com").name("Tester").password("test").build();

        given(userService.registerUser("tester@example.com", "Tester", "test"))
                .willReturn(mockUser);

        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"tester@example.com\", \"name\":\"Tester\", \"password\":\"test\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/users/1004"));

        verify(userService).registerUser(eq("tester@example.com"), eq("Tester"), eq("test"));
    }
}