package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Categorie;
import beans.Produit;
import dao.CategorieDAO;
import dao.DAOFactory;
import dao.ProduitDAO;
import dao.UtilisateurDAO;


@WebServlet("/ProduiutServlet")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDAO prod;
	Produit p;
	CategorieDAO catdao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory daoFactory = DAOFactory.getInstance();
        prod = DAOFactory.getInstance().createProduitDAO();
        catdao = DAOFactory.getInstance().createCategorieDAO();
        Categorie cat= catdao.findCat(p.getID_CAT());
        if(request.getQueryString()!=null && request.getQueryString()!="") {
        	System.out.println(request.getQueryString());
        	p = prod.findProduct(Integer.parseInt(request.getQueryString()));
            request.setAttribute("prodone", p);
            request.setAttribute("catone", cat);
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
			ArrayList<Integer> panierqte=new ArrayList<Integer>();
			panierlist.add(p);
			panierqte.add(Integer.parseInt(request.getParameter("product_qte")));
			session.setAttribute("session-panier", panierlist);
			session.setAttribute("session-panier_qte", panierqte);
			float total=p.getPRIX_UNIT()*Integer.parseInt(request.getParameter("product_qte"));
			session.setAttribute("session-panier_total", total);
		}
		else {
			ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
			ArrayList<Integer> panierqte=(ArrayList<Integer>) session.getAttribute("session-panier_qte");
			panierlist.add(p);
			panierqte.add(Integer.parseInt(request.getParameter("product_qte")));
			session.setAttribute("session-panier", panierlist);
			session.setAttribute("session-panier_qte", panierqte);
			float total=0;
			for(int i=0;i<panierlist.size();i++) {
				total =total +(panierlist.get(i).getPRIX_UNIT()*panierqte.get(i));
			}
			session.setAttribute("session-panier_total", total);
		}
		
		request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
	}

}
