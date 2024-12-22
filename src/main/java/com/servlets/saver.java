package com.servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entities.note;
import com.helper.SessionManager;
import jakarta.servlet.annotation.WebServlet;
import org.hibernate.Session;

import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.util.Date;
@WebServlet("/saver")
public class SaveNoteServlet extends HttpServlet {
    public SaveNoteServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try{
            String title = req.getParameter("title");
            String context = req.getParameter("context");
            
            //Now we need to call the constructor of note class to give them the data they need
            note Note = new note(title,context,new Date());

            //now we want to save the data using hibernate:save()
           Session s = SessionManager.getFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.save(Note);
            tx.commit();
            s.close();

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h1>Hi saved note</h1>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
