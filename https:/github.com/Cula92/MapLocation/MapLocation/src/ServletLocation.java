

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLocation
 */
@WebServlet("/ServletLocation")
public class ServletLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String longitudine;
		
		String latitudine;
		
		latitudine = request.getParameter("latitude");
		
		longitudine = request.getParameter("longitude");
		
		out.println("Latitudine: " + latitudine);
		
		out.println("Longitudine: " + longitudine);
		
		String sql = "select * from citta where latitudine = " + latitudine + "and longitudine = " + longitudine;
		
		MyConnection Connessione = new MyConnection();
		
		ResultSet rs = Connessione.getResult(sql);
		
		try 
		{
			while(rs.next())
			{
				String s = rs.getString("nome");
				String s1 = rs.getString("stato");
			}
		} 
		catch (SQLException e) 
		{				
			System.out.println ("Error: resultset error!");
			e.printStackTrace();
		}
		
		Connessione.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
