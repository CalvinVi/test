package htw_berlin.webtech;

import htw.berlin.webtech.WebtechApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = WebtechApplication.class)
@AutoConfigureMockMvc
public class TodoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTodos() throws Exception {
        mockMvc.perform(get("/todos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].title", is("Task 1")))
            .andExpect(jsonPath("$[1].title", is("Task 2")));
    }
}