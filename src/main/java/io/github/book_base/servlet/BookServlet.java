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

@WebServlet(name= "Book", urlPatterns = {"/api/books/*"})
public class BookServlet {
}
