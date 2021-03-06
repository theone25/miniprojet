<%@page import="beans.Livraison"%>
<%@page import="beans.Commande"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Categorie"%>
<%@page import="beans.Utilisateur"%>
<%@page import="beans.Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Ecom </title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/lightslider.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<!--::header part start::-->
	<header class="main_menu home_menu">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-12">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="index.html"> <img
							src="img/logo.png" alt="logo">
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Bascule de navigation">
							<span class="menu_icon"><i class="fas fa-bars"></i></span>
						</button>

						<div class="collapse navbar-collapse main-menu-item"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link" href="/index">Acceuil</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="/produits">Tous
										les Produits</a></li>
								<li class="nav-item"><a class="nav-link" href="/contact">Contact</a>
								</li>
							</ul>
						</div>
						<div class="hearer_icon d-flex">
							<div class="hearer_icon d-flex">
	                       <div class="collapse navbar-collapse" id="navbar-list-4">
	                       <%
						        Utilisateur user = (Utilisateur)session.getAttribute("session-user");
	                       		ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
	           					ArrayList<Integer> panierqte=(ArrayList<Integer>) session.getAttribute("session-panier_qte");
	                       		Commande cmd=(Commande)request.getAttribute("cmd");
	                       		Livraison liv=(Livraison)request.getAttribute("liv");
	                       		ArrayList<String> adr=(ArrayList<String>)request.getAttribute("adr"); 
	                       		float total =0;
	                       		total = (float) session.getAttribute("session-panier_total"); 
						        if(user==null)  {
						    %>            
						        <ul class="navbar-nav">
							        <li class="nav-item dropdown">
							        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							          <span>Authentification<i class="fas fa-user"></i></span>
							        </a>
							        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							          <a class="dropdown-item" href="/authentication">Se connecter</a>
							          <a class="dropdown-item" href="/authentication">Creer un compte</a>
							        </div>
							      </li>   
							    </ul>
						    <%
						        } else {
						    %>
						        <ul class="navbar-nav">
							        <li class="nav-item dropdown">
							        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							          <span><%= user.getNOM()+" "+user.getPRENOM() %><i class="fas fa-user"></i></span>
							        </a>
							        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							          <a class="dropdown-item" href="#">Acceuil</a>
							          <a class="dropdown-item" href="#">mon profile</a>
							          <a class="dropdown-item" href="#">deconnection</a>
							        </div>
							      </li>   
							    </ul>
						    <%
						        }
						    %>
							    <ul class="navbar-nav">
							    <div class="dropdown cart">
	                                <a class="dropdown-toggle" href="/panier" id="navbarDropdown3" role="button"
	                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                    <i class="fas fa-cart-plus"></i>
	                                </a>
	                            </div>
							    </ul>
							  </div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>
	 <section class="breadcrumb breadcrumb_bg">
	    <div class="container">
	      <div class="row justify-content-center">
	        <div class="col-lg-8">
	          <div class="breadcrumb_iner">
	            <div class="breadcrumb_iner_item">
	              <h2>Confirmation Commande</h2>
	              <p>Acceuil <span>-</span> Confirmation de Commande</p>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </section>
	  
	  <section class="confirmation_part padding_top">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="confirmation_tittle">
            <span>Merci, votre commande a ??t?? bien re??ue.</span>
          </div>
        </div>
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>informations de la commande</h4>
            <ul>
              <li>
                <p>Num??ro de la commande</p><span>: <%= cmd.getNUM_COM() %></span>
              </li>
              <li>
                <p>Date</p><span>: <%= cmd.getDATE_COM() %></span>
              </li>
              <li>
              <% if( liv.getID_TYPE()==1) { %>
                <p>Total</p><span>: <%= total+80 %> DH</span>
                <% } else { %>
                <p>Total</p><span>: <%= total+40 %> DH</span>
                <% } %>
              </li>
              <li>
                <p>M??thode de paiement</p><span>: V??rifier les paiements</span>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>Adresse de facturation</h4>
            <ul>
              <li>
                <p>Rue</p><span>: <%= adr.get(0)  %></span>
              </li>
              <li>
                <p>Ville</p><span>: <%= adr.get(1)  %></span>
              </li>
              <li>
                <p>Pays</p><span>: <%= adr.get(2)  %></span>
              </li>
              <li>
                <p>Code postal</p><span>: <%= adr.get(3)  %></span>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-6 col-lx-4">
          <div class="single_confirmation_details">
            <h4>Adresse de livraison</h4>
            <ul>
              <li>
                <p>Rue</p><span>: <%= adr.get(0)  %></span>
              </li>
              <li>
                <p>Ville</p><span>: <%= adr.get(1)  %></span>
              </li>
              <li>
                <p>Pays</p><span>: <%= adr.get(2)  %></span>
              </li>
              <li>
                <p>Code postal</p><span>: <%= adr.get(3)  %></span>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="order_details_iner">
            <h3>D??tails de la commande</h3>
            <table class="table table-borderless">
              <thead>
                <tr>
                  <th scope="col" colspan="2">Produit</th>
                  <th scope="col">Quantit??</th>
                  <th scope="col">Total</th>
                </tr>
              </thead>
              <tbody>
               <% if(panierlist!=null && panierlist.size()>0 )  {
        			for(int i=0;i<panierlist.size();i++){
        			%>
                <tr>
                  <th colspan="2"><span><%= panierlist.get(i).getLIBELLE() %></span></th>
                  <th>x<%=panierqte.get(i) %></th>
                  <th> <span><%= panierqte.get(i)*panierlist.get(i).getPRIX_UNIT()  %> DH</span></th>
                </tr>
                <%} } %>
                <tr>
                  <th colspan="3">Sous total</th>
                  <th> <span><%= total %> DH</span></th>
                </tr>
                <tr>
                  <th colspan="3">Livraison</th>
                  <% if( liv.getID_TYPE()==1) { %>
                <th><span>Livraison Express: 80.00 DH</span></th>
                <% } else { %>
                <th><span>Livraison Standard: 40.00 DH</span></th>
                <% } %>
                </tr>
              </tbody>
              <tfoot>
                <tr>
                  <th scope="col" colspan="3"></th>
                  <% if( liv.getID_TYPE()==1) { %>
                <th scope="col"><%= total+80 %></th>
                <% } else { %>
                <th scope="col"><%= total+40 %></th>
                <% } %>
                  
                </tr>
              </tfoot>
            </table>
          </div>
        </div>
      </div>
    </div>
  </section>
  
  
	<!--::footer_part start::-->
	<footer class="footer_part">

		<div class="copyright_part">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="copyright_text">
							<p>Ecom &copy;2021 | Tous droits r??serv??s</p>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="footer_icon social_icon">
							<ul class="list-unstyled">
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-facebook-f"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-twitter"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fas fa-globe"></i></a></li>
								<li><a href="#" class="single_social_icon"><i
										class="fab fa-behance"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!--::footer_part end::-->

	<!-- jquery plugins here-->

	<script src="js/jquery-1.12.1.min.js"></script>
	<!-- popper js -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- easing js -->
	<script src="js/jquery.magnific-popup.js"></script>
	<!-- swiper js -->
	<script src="js/swiper.min.js"></script>
	<!-- swiper js -->
	<script src="js/masonry.pkgd.js"></script>
	<!-- particles js -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<!-- slick js -->
	<script src="js/slick.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>
	<script src="js/App.js"></script>

</body>
</html>