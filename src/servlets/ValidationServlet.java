package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Commande;
import beans.CommandeClient;
import beans.Livraison;
import beans.Produit;
import beans.Utilisateur;
import dao.CommandeClientDAO;
import dao.CommandeDAO;
import dao.DAOFactory;
import dao.LivraisonDAO;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user=(Utilisateur)session.getAttribute("session-user");
		if(user!=null) {
			if (request.getQueryString().equals("cod")) {
			ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
			ArrayList<Integer> panierqte=(ArrayList<Integer>) session.getAttribute("session-panier_qte");
			Livraison liv=new Livraison();
			liv.setID_TYPE(Integer.valueOf(request.getParameter("typeliv")));
			liv.setADRESSE_LIV(request.getParameter("add1")+" "+request.getParameter("city")+" "+request.getParameter("pays"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    java.util.Date date = new java.util.Date();  
			liv.setDATE_LIV(java.sql.Date.valueOf(formatter.format(date)));
			liv.setTEL_LIV(request.getParameter("number"));
			liv.setNUM_LIV(0);
			
			DAOFactory daoFactory = DAOFactory.getInstance();
			LivraisonDAO livdao=DAOFactory.getInstance().createLivraisonDAO();
			livdao.add(liv);
			
			CommandeDAO cmddao=daoFactory.getInstance().createCommandeDAO();
			 
			Commande cmd=new Commande();
			cmd.setNUM_COM(0);
			cmd.setNUM_LIV(liv.getNUM_LIV());
			cmd.setID(user.getID());
			cmd.setDATE_COM(liv.getDATE_LIV());
			cmd.setETAT_COM("paye");
			cmd.setPAIEMENT("COD");
			
			
			cmddao.add(cmd);
			
			CommandeClientDAO cmdclidao=daoFactory.getInstance().createCommandeClientDAO();
			for(int i=0;i<panierlist.size();i++) {
				CommandeClient cmdcli=new CommandeClient();
				cmdcli.setID_PR(panierlist.get(i).getID_PR());
				cmdcli.setNUM_COM(cmd.getNUM_COM());
				cmdcli.setQTE(panierqte.get(i));
				
				cmdclidao.add(cmdcli);
			}
			}
			else {
				
			}
		}
		else {
			request.getRequestDispatcher("WEB-INF/Authentification.jsp").forward(request, response);
		}
	}

}
