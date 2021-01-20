package ru.aamsystems.juniortest.controllertests;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.aamsystems.juniortest.controller.ProductController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void test(){
        Assert.assertNotNull(productController);
        Assert.assertNotNull(mockMvc);
    }


    @Test
    public void productsPage() throws Exception {
        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("products"))
                .andExpect(content().string(StringContains.containsString("Products page")));
    }

    @Test
    public void addProduct() throws Exception {
        mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("addForm"))
                .andExpect(content().string(StringContains.containsString("Add product!")));
    }
    @Test
    public void editProduct() throws Exception {
        mockMvc.perform(get("/edit?id=20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("editForm"))
                .andExpect(content().string(StringContains.containsString("Edit Product!")))
                .andExpect(content().string(StringContains.containsString("AMD ryzen 5")));

    }
}
