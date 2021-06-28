package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Produit;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
		ArrayList<Integer> panierqte=(ArrayList<Integer>) session.getAttribute("session-panier_qte");
		if(panierlist.size()!=0 && panierlist!=null && panierqte.size()!=0 && panierqte!=null ) {
			request.getRequestDispatcher("WEB-INF/validation.jsp").forward(request, response);
		}else {
	        	request.getRequestDispatcher("WEB-INF/404.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
