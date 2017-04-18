package com.nosophobic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebServlet
 */
@WebServlet(description = "Nosophobic", urlPatterns = { "/nosphobicServlet" })
public class NosophobicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NosophobicServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state = request.getParameter("state");
		String disease = request.getParameter("disease");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head");
		out.println("<title>Form Example</title>");
		out.println("<body>");
		out.println("STATE: " + state + "DISEASE: " + disease);
		out.println("<body>");
		out.println("</html>");
		
	}

}
