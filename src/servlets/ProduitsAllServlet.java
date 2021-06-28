package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categorie;
import beans.Produit;
import dao.CategorieDAO;
import dao.DAOFactory;
import dao.ProduitDAO;


@WebServlet("/ProduitsAllServlet")
public class ProduitsAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDAO prod;
	CategorieDAO catdao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory daoFactory = DAOFactory.getInstance();
        prod = DAOFactory.getInstance().createProduitDAO();
        catdao = DAOFactory.getInstance().createCategorieDAO();
        ArrayList<Produit> p =new ArrayList<Produit>();
        ArrayList<Categorie> cat= new ArrayList<Categorie>();
        p=prod.findall();
        ArrayList<ArrayList<Produit>> listPage=new ArrayList<ArrayList<Produit>>();
        int numbP=(int)Math.ceil(p.size()/9);
        for(int i=0;i<numbP;i++) {
        	if(i==numbP-1) {
        		ArrayList<Produit> pp=new ArrayList<Produit>();
        		pp.addAll(p.subList(i*9, p.size()));
        		listPage.add(pp);
        	}
        	else {
        		ArrayList<Produit> pp=new ArrayList<Produit>();
        		pp.addAll(p.subList(i*9, (i+1)*9));
        		listPage.add(pp);
        	}
        }
        cat=catdao.findall();
        for(int i=0;i<listPage.size();i++) {
        	request.setAttribute("allprod"+i, listPage.get(i));
        }
        request.setAttribute("allcat", cat);
        request.setAttribute("nump", numbP);
        request.getRequestDispatcher("WEB-INF/allproduits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
