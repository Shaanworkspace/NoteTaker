package com.servlets;



import com.entities.note;
import com.helper.SessionManager;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.util.Date;

public class saver extends HttpServlet {
    public saver() {
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
            out.println("<h1>Hi saved note <a href='showNotes.jsp'>Click to view</a></h1>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
