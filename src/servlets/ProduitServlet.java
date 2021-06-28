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
import dao.DAOFactory;
import dao.ProduitDAO;
import dao.UtilisateurDAO;


@WebServlet("/ProduiutServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDAO prod;
	Produit p;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory daoFactory = DAOFactory.getInstance();
        prod = DAOFactory.getInstance().createProduitDAO();
        if(request.getQueryString()!=null && request.getQueryString()!="") {
        	System.out.println(request.getQueryString());
        	p = prod.findProduct(Integer.parseInt(request.getQueryString()));
            request.setAttribute("prodone", p);
            request.getRequestDispatcher("WEB-INF/produit.jsp").forward(request, response);
        }
        else {
        	request.getRequestDispatcher("WEB-INF/404.jsp").forward(request, response);
        }
		//request.getRequestDispatcher("WEB-INF/produit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("session-panier")==null) {
			ArrayList<Produit> panierlist=new ArrayList<Produit>();
			panierlist.add(p);
			
			session.setAttribute("session-panier", panierlist);
		}
		else {
			ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
			panierlist.add(p);
			session.setAttribute("session-panier", panierlist);
		}
		
		request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
	}

}
