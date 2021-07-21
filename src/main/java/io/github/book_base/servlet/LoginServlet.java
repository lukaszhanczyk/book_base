package io.github.book_base.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.book_base.model.User;
import io.github.book_base.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name= "Login", urlPatterns = {"/api/login/*"})
public class LoginServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(CategoryServlet.class);

    private final UserRepository repository;
    private final ObjectMapper mapper;

    @SuppressWarnings("unused")
    public LoginServlet(){
        this(new UserRepository(),new ObjectMapper());
    }
    LoginServlet(UserRepository repository,ObjectMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        var user = session.getAttribute("loggedUser");
        resp.setContentType("aplication/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(),user);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var reqUser = mapper.readValue(req.getInputStream(), User.class);
        try {
            var user = repository.findByNameAndPassword(reqUser.getName(), reqUser.getPassword());
            if(user.isPresent()){
                HttpSession session = req.getSession();
                session.setAttribute("loggedUser", user.get());
                resp.setContentType("aplication/json;charset=UTF-8");
                mapper.writeValue(resp.getOutputStream(),user.get());
            }else{
                resp.setContentType("aplication/json;charset=UTF-8");
            }
        }catch (Exception e){
            logger.warn("Wrong user info");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("loggedUser");
    }
}
