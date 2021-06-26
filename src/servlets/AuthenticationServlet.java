package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.DAOFactory;
import dao.UtilisateurDAO;


public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurDAO newUser;

	public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        newUser= DAOFactory.getInstance().createUtilisateurDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/Authentification.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if (request.getQueryString().equals("register")) {
			 
			 System.out.println(newUser.getConnection());
			 // remplir usr avec donnees
			 Utilisateur usr=new Utilisateur();
			 usr.setNOM(request.getParameter("nom"));
			 usr.setPRENOM(request.getParameter("prenom"));
			 usr.setDATE_NAIS(java.sql.Date.valueOf(request.getParameter("dn")));
			 usr.setLOGIN(request.getParameter("email"));
			 usr.setPWD(request.getParameter("pwd"));
			 newUser.add(usr);
			 request.setAttribute("user", usr);
			 HttpSession session = request.getSession();
			 session.setAttribute("session-user", usr);
			 request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
		 } 
		 if (request.getQueryString().equals("login")) {
			 String login= request.getParameter("emaillogin");
			 String pwd= request.getParameter("pwdlogin");
			 Utilisateur usr = newUser.findUser(login,pwd);
			 if(usr!=null) {
				 request.setAttribute("user", usr);
				 HttpSession session = request.getSession();
				 session.setAttribute("session-user", usr);
				 request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
			 }
		 }
	}

}
