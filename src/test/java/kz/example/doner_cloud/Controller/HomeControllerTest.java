package kz.example.doner_cloud.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class) //Тест для HomeController
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; //Внедряем MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) //Выполняем GET запрос
                .andExpect(status().isOk()) //Ожидается 200
                .andExpect(view().name("home")) //Ожидается имя представления home
                .andExpect(content().string(
                        containsString("Welcome to DonerCloud") //Ожидается наличиек строки "Welcome to DonerCloud"
                ));
    }
}
