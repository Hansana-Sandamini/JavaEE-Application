package lk.ijse.aad;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/mime")
//@MultipartConfig
public class Main extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String body = new BufferedReader(new InputStreamReader(req.getInputStream())).lines()
//                .collect(Collectors.joining("\n"));
//        resp.setContentType("text/plain");
//        resp.getWriter().write(body);
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String address = req.getParameter("address");
//        resp.setContentType("text/plain");
//        resp.getWriter().write("Name: " + name + "\nAddress: " + address + "\n");
//    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        Part part = req.getPart("file");
//        String  fileName = part.getSubmittedFileName();
//
//        resp.setContentType("text/plain");
//        resp.setHeader("Multipart Form Data" + name , "attachment; filename=\"" + fileName + "\"");
//    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.readTree(req.getReader());
//        JsonNode jsonNode = mapper.readTree(req.getReader());
//
//        String name = jsonNode.get("name").asText();
//        String address = jsonNode.get("address").asText();
//
//        resp.setContentType("text/plain");
//        resp.getWriter().println(name + " " + address);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> users = mapper.readValue(req.getReader(), new TypeReference<List<JsonNode>>() {});
        for (JsonNode user : users) {
            String name = user.get("name").asText();
            String address = user.get("address").asText();
            System.out.println(name + " " + address);
        }
        resp.getWriter().write("OK");
    }

}