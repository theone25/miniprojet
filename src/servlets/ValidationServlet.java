package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.google.gson.Gson;
*/
import beans.Commande;
import beans.CommandeClient;
import beans.Livraison;
import beans.Produit;
import beans.Utilisateur;
import dao.CommandeClientDAO;
import dao.CommandeDAO;
import dao.DAOFactory;
import dao.LivraisonDAO;


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
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    java.util.Date date = new java.util.Date();  
		    System.out.println(formatter.format(date));
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
			
			ArrayList<String> adr=new ArrayList<String>();
			adr.add(request.getParameter("add1"));
			adr.add(request.getParameter("city"));
			adr.add(request.getParameter("pays"));
			adr.add(request.getParameter("zip"));
			request.setAttribute("adr", cmddao);
			
			cmddao.add(cmd);
			
			CommandeClientDAO cmdclidao=daoFactory.getInstance().createCommandeClientDAO();
			for(int i=0;i<panierlist.size();i++) {
				CommandeClient cmdcli=new CommandeClient();
				cmdcli.setID_PR(panierlist.get(i).getID_PR());
				cmdcli.setNUM_COM(cmd.getNUM_COM());
				cmdcli.setQTE(panierqte.get(i));
				
				cmdclidao.add(cmdcli);
			}
			
			request.setAttribute("cmd", cmd);
			request.setAttribute("liv", liv);
			request.getRequestDispatcher("WEB-INF/confirmation.jsp").forward(request, response);
				
			}
			else {
				/*
				ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
				ArrayList<Integer> panierqte=(ArrayList<Integer>) session.getAttribute("session-panier_qte");
				Livraison liv=new Livraison();
				liv.setID_TYPE(Integer.valueOf(request.getParameter("typeliv")));
				liv.setADRESSE_LIV(request.getParameter("add1")+" "+request.getParameter("city")+" "+request.getParameter("pays"));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    java.util.Date date = new java.util.Date();  
			    System.out.println(formatter.format(date));
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
				
				ArrayList<String> adr=new ArrayList<String>();
				adr.add(request.getParameter("add1"));
				adr.add(request.getParameter("city"));
				adr.add(request.getParameter("pays"));
				adr.add(request.getParameter("zip"));
				request.setAttribute("adr", cmddao);
				
				cmddao.add(cmd);
				
				CommandeClientDAO cmdclidao=daoFactory.getInstance().createCommandeClientDAO();
				for(int i=0;i<panierlist.size();i++) {
					CommandeClient cmdcli=new CommandeClient();
					cmdcli.setID_PR(panierlist.get(i).getID_PR());
					cmdcli.setNUM_COM(cmd.getNUM_COM());
					cmdcli.setQTE(panierqte.get(i));
					
					cmdclidao.add(cmdcli);
				}
				
				request.setAttribute("cmd", cmd);
				request.setAttribute("liv", liv);
				
				String YOUR_DOMAIN = "http://localhost:8080";
				Stripe.apiKey="pk_test_51J7PbhHxb8dJTnx5zATvIXsp6LtD0gcvt8zxuC6EhXqd2TJkZ0KkIlPK8MXbK6pUk9hClHsQBpzeydDNrUIqlCer00ATRpobA1";
				SessionCreateParams params =
				          SessionCreateParams.builder()
				            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				            .setMode(SessionCreateParams.Mode.PAYMENT)
				            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
				            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
				            .addLineItem(
				              SessionCreateParams.LineItem.builder()
				                .setQuantity(1L)
				                .setPriceData(
				                  SessionCreateParams.LineItem.PriceData.builder()
				                    .setCurrency("usd")
				                    .setUnitAmount(2000L)
				                    .setProductData(
				                      SessionCreateParams.LineItem.PriceData.ProductData.builder()
				                        .setName("Stubborn Attachments")
				                        .build())
				                    .build())
				                .build())
				            .build();
				
				Session sessionstr;
				try {
					sessionstr = Session.create(params);
					HashMap<String, String> responseData = new HashMap<String, String>();
				      responseData.put("id", session.getId());
				      PrintWriter out = response.getWriter();
				      response.setContentType("application/json");
				      response.setCharacterEncoding("UTF-8");
				      String data = gson.toJson(responseData);
				      out.print(data);
				      out.flush();
				} catch (StripeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
			}
		} else {
			request.getRequestDispatcher("WEB-INF/Authentification.jsp").forward(request, response);
		}
	}

}
