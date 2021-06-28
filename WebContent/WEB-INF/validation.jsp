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
  <link rel="stylesheet" href="css/nice-select.css">
  <link rel="stylesheet" href="css/slick.css">
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
							aria-label="Toggle navigation">
							<span class="menu_icon"><i class="fas fa-bars"></i></span>
						</button>

						<div class="collapse navbar-collapse main-menu-item"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link" href="/index">Home</a>
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
			                    String ship=(String)session.getAttribute("shipping");
			                    float total =0;
						        if(user==null)  {
						    %>            
						        <ul class="navbar-nav">
							        <li class="nav-item dropdown">
							        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							          <span>Authentifier<i class="fas fa-user"></i></span>
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
							          <a class="dropdown-item" href="#">home</a>
							          <a class="dropdown-item" href="#">mon profile</a>
							          <a class="dropdown-item" href="#">deconnecter</a>
							        </div>
							      </li>   
							    </ul>
						    <%
						        }
						    %>
							    <ul class="navbar-nav">
							    <div class="dropdown cart">
	                                <a class="dropdown-toggle" href="#" id="navbarDropdown3" role="button"
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
	              <p>Home <span>-</span> Confirmation Commande</p>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </section>
	  
	   <section class="checkout_area padding_top">
    <div class="container">
      <div class="billing_details">
        <div class="row">
          <div class="col-lg-8">
            <h3>Details Paiement</h3>
            <form class="row contact_form" action="/validation" method="post" novalidate="novalidate">
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" placeholder="prenom" id="first" name="first" />
              </div>
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" placeholder="nom" id="last" name="last" />
              </div>
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" placeholder="telephone" id="number" name="number" />
              </div>
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" placeholder="Email" id="email" name="email" />
              </div>
              <div class="col-md-12 form-group p_star">
                <select class="country_select" id="pays" name="pays">
                  <option value="1">Pays</option>
                  <option value="2">Maroc</option>

                </select>
              </div>
              <div class="col-md-12 form-group p_star">
                <input type="text" class="form-control" placeholder="Adresse" id="add1" name="add1" />
              </div>
              <div class="col-md-12 form-group p_star">
                <input type="text" class="form-control" placeholder="ville" id="city" name="city" />
              </div>
              <div class="col-md-12 form-group">
                <input type="text" class="form-control" id="zip" name="zip" placeholder="code postal" />
              </div>
              <% if(ship=="Livraison Express: 80 DH") {%>
                    <input type="text" hidden value="1" id="typeliv" name="typeliv"  />
                    <% } %>
                    <% if(ship=="Livraison Standard: 40 DH") {%>
                    <input type="text" value="2" hidden id="typeliv" name="typeliv" />
                    <% } %>
            </form>
          </div>
          <div class="col-lg-4">
            <div class="order_box">
              <h2>Votre Commande</h2>
              <ul class="list">
                <li>
                  <a >Produit
                    <span>Total</span>
                  </a>
                </li>
                <% if(panierlist!=null && panierlist.size()>0 )  {
        			total = (float) session.getAttribute("session-panier_total"); 
        			for(int i=0;i<panierlist.size();i++){
        			%>
                <li>
                  <a ><%= panierlist.get(i).getLIBELLE() %>
                    <span class="middle">x <%= panierqte.get(i) %></span>
                    <span class="last"><%= panierlist.get(i).getPRIX_UNIT() %></span>
                  </a>
                </li>
               <% } }%>
              </ul>
              <ul class="list list_2">
                <li>
                  <a >Sous Total
                    <span><%= total %></span>
                  </a>
                </li>
                <li>
                  <a >Livraison
                    <span><%= ship+" DH" %>></span>
                  </a>
                </li>
                <li>
                  <a >Total
                  <% if(ship=="Livraison Express: 80 DH") {%>
                    <span><%= (total+80)+ " DH" %></span>
                    <% } %>
                    <% if(ship=="Livraison Standard: 40 DH") {%>
                    <span><%= (total+40)+ " DH" %></span>
                    <% } %>
                  </a>
                </li>
              </ul>
              <div class="payment_item">
                <div class="radion_btn">
                  <input type="radio" id="f-option5" name="selector" />
                  <label for="f-option5">Cash On Delivery</label>
                  <div class="check"></div>
                </div>
                <p>
					on vous offre la possibilite de payer votre commande lorsque vous le recever,
					Vous serrez etre contactes avec notre agent de livraison. 
                </p>
              </div>
              <div class="payment_item active">
                <div class="radion_btn">
                  <input type="radio" id="f-option6" name="selector" />
                  <label for="f-option6">Carte Guichet </label>
                  <img src="img/product/single-product/card.jpg" alt="" />
                  <div class="check"></div>
                </div>
                <p>
                  on vous offre un paiement facile avec votre carte guichet.
                </p>
              </div>
              <a class="btn_3" onclick="validateform()" href="#">Payer votre Commande</a>
            </div>
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
							<p>Ecom &copy;2021 | Tous droits réservés</p>
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


	<script>
		function validateform(){
			var x=document.getElementsByClassName("payment_item");
			if(x[0].classList.contains("active")){
				document.getElementById("contact_form").action="/validation?cod";
			}
			else{
				document.getElementById("contact_form").action="/validation?stripe";
			}
		}
	</script>

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
  <script src="js/stellar.js"></script>
  <script src="js/price_rangs.js"></script>
	<script src="js/App.js"></script>

</body>
</html>