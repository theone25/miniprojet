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
<title>Ecom | <% 
  Produit p=(Produit) request.getAttribute("p"); %></title>
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
 <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/price_rangs.css">
    <link rel="stylesheet" href="css/nice-select.css">
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
							          <a class="dropdown-item" href="#">Mon profile</a>
							          <a class="dropdown-item" href="#">Déconnection</a>
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
	<!-- Header part end-->
	<section class="breadcrumb breadcrumb_bg">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="breadcrumb_iner">
                        <div class="breadcrumb_iner_item">
                            <h2>Catégories du magasin</h2>
                            <p>Acceuil <span>-</span> Catégories du magasin</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <section class="cat_product_area section_padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="left_sidebar_area">
                        <aside class="left_widgets p_filter_widgets">
                            <div class="l_w_title">
                                <h3>Categories</h3>
                            </div>
                            <div class="widgets_inner">
                                <ul class="list">
                                <% ArrayList<Categorie> cat = (ArrayList<Categorie>)request.getAttribute("allcat"); %>
                                <% for(int i=0; i<cat.size();i++) { %>
                                    <li>
                                        <a href="#"><%= cat.get(i).getLIB_CAT() %></a>
                                    </li>
                                 <% } %>
                                </ul>
                            </div>
                        </aside>

                        <aside class="left_widgets p_filter_widgets price_rangs_aside">
                            <div class="l_w_title">
                                <h3>Filtre par Prix:</h3>
                            </div>
                            <div class="widgets_inner">
                                <div class="range_item">
                                    <!-- <div id="slider-range"></div> -->
                                    <input type="text" class="js-range-slider" value="" />
                                    <div class="d-flex">
                                        <div class="price_text">
                                            <p>Prix :</p>
                                        </div>
                                        <div class="price_value d-flex justify-content-center">
                                            <input type="text" class="js-input-from" id="amount" readonly />
                                            <span>jusqu'à</span>
                                            <input type="text" class="js-input-to" id="amount" readonly />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </aside>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product_top_bar d-flex justify-content-between align-items-center">
                                <div class="single_product_menu">
                                    <p>Produits</p>
                                </div>
                                <div class="single_product_menu d-flex">
                                    <h5>trier par: </h5>
                                    <select id="categorie-select" name="categorie-select">
                                    	<option value="0" data-display="Trier" selected disabled hidden>trier</option>
                                        <option value="1">Nom</option>
                                        <option value="2">Prix</option>
                                    </select>
                                </div>
                               
                                <div class="single_product_menu d-flex">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="rechercher"
                                            aria-describedby="inputGroupPrepend">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="inputGroupPrepend"><i
                                                    class="ti-search"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row align-items-center latest_product_inner">
                    	<% 
                    	int nump=(int)request.getAttribute("nump");
                    	for(int j=0;j<nump;j++){ %>
                    		
                    	<% ArrayList<Produit> prd = (ArrayList<Produit>)request.getAttribute("allprod"+j); 
                    	if(j==0){ %>
                    		<% for(int i=0; i<prd.size();i++) { %>
                        <div class="pagination-list" class="col-lg-4 col-sm-6">
                            <div class="single_product_item">
                                <img src="img/product/<%= prd.get(i).getIMG()  %>" alt="">
                                <div class="single_product_text">
                                    <h4><%= prd.get(i).getLIBELLE()  %></h4>
                                    <h3><%= prd.get(i).getPRIX_UNIT()+" DH"  %></h3>
                                    <a href="/produit?<%= prd.get(i).getID_PR() %>" class="add_cart">+ Ajouter Au Panier<i class="ti-heart"></i></a>
                                </div>
                            </div>
                        </div>
                        <% } %>
                    	<%} else { %>
                        <% for(int i=0; i<prd.size();i++) { %>
                        <div hidden class="pagination-list" class="col-lg-4 col-sm-6">
                            <div class="single_product_item">
                                <img src="img/product/<%= prd.get(i).getIMG()  %>" alt="">
                                <div class="single_product_text">
                                    <h4><%= prd.get(i).getLIBELLE()  %></h4>
                                    <h3><%= prd.get(i).getPRIX_UNIT()+" DH"  %></h3>
                                    <a href="/produit?<%= prd.get(i).getID_PR() %>" class="add_cart">+ Ajouter Au Panier<i class="ti-heart"></i></a>
                                </div>
                            </div>
                        </div>
                        <% } %>
                        <% } %>
                        <% } %>
                        <div class="col-lg-12">
                            <div class="pageination">
                                <nav aria-label="Exemple de page de navigation">
                                    <ul class="pagination justify-content-center">
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Précedent">
                                                <i class="ti-angle-double-left"></i>
                                            </a>
                                        </li>
                                        <% for(int j=0;j<nump;j++){ %>
                                        <li class="page-item"><a onclick="pagination(<%= j %>)" class="page-link" href="#"><%= j+1 %></a></li>
                                        <% } %>
                                        <li class="page-item">
                                            <a class="page-link" href="#" aria-label="Suivant">
                                                <i class="ti-angle-double-right"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Category Product Area =================-->

   
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
	function pagination(p1) {
	  var list=document.getElementsByClassName("pagination-list");
	  for(let i = 0; i < list.length; i++){
		  if(p1==i){
			  list[i].style.visibility === "visible"
		  }
		  else{
			  list[i].style.visibility === "hidden"
		  }
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