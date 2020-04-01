package ps.web.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ps.config.PokerConfig;
import ps.web.mvc.SpringMvcConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * тест функциональности {@link HomeController}
 */
@ExtendWith(SpringExtension.class) // расширение
@ContextConfiguration(classes = {PokerConfig.class, SpringMvcConfig.class})
@WebAppConfiguration
public class HomeControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc; // через что будем делать запросы



    @BeforeEach // инициализация перед каждым тестом
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void testHome() throws Exception {

        mockMvc.perform(get("/"))
                .andDo(print())    // выведем детали на экран
                .andExpect(status().is2xxSuccessful());  // статус запроса
    }



}