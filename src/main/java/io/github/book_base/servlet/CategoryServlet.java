package io.github.book_base.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.book_base.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "Category", urlPatterns = {"/api/categories/*"})
public class CategoryServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(CategoryServlet.class);

    private final CategoryService service;
    private final ObjectMapper mapper;

    @SuppressWarnings("unused")
    public CategoryServlet(){
        this(new CategoryService(),new ObjectMapper());
    }
    CategoryServlet(CategoryService service,ObjectMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request got width parameters "+ req.getParameterMap());
        resp.setContentType("aplication/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(),service.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
