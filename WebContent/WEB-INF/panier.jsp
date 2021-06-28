<%@page import="beans.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>panier</title>
<!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- animate CSS -->
  <link rel="stylesheet" href="css/animate.css">
  <!-- owl carousel CSS -->
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="css/all.css">
  <!-- flaticon CSS -->
  <link rel="stylesheet" href="css/flaticon.css">
  <link rel="stylesheet" href="css/themify-icons.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="css/magnific-popup.css">
  <!-- swiper CSS -->
  <link rel="stylesheet" href="css/slick.css">
  <!-- style CSS -->
  <link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,300,400i,400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css?family=Roboto:400,500i,700" rel="stylesheet"> 


<style>
  
  
  .panier-card {
    margin-bottom: 30px;
    border: 0;
    -webkit-transition: all .3s ease;
    transition: all .3s ease;
    letter-spacing: .5px;
    border-radius: 8px;
    -webkit-box-shadow: 1px 5px 24px 0 rgba(68, 102, 242, .05);
    box-shadow: 1px 5px 24px 0 rgba(68, 102, 242, .05)
}

.panier-card .panier-card-body {
    padding: 30px;
    background-color: transparent
}

.panier-button-empty,
.panier-button-empty.disabled,
.panier-button-empty:disabled {
    background-color: #4466f2 !important;
    border-color: #4466f2 !important
}

</style>
</head>
<body>
	<!--::header part start::-->
    <header class="main_menu home_menu">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-12">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="navbar-brand" href="index.html"> <img src="img/logo.png" alt="logo"> </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="menu_icon"><i class="fas fa-bars"></i></span>
                        </button>

                        <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="/index">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/produits">Tous les Produits</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/contact">Contact</a>
                                </li>
                            </ul>
                        </div>
                        <div class="hearer_icon d-flex">
	                       <div class="collapse navbar-collapse" id="navbar-list-4">
	                       <%
						        Utilisateur user = (Utilisateur)request.getAttribute("user");
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
    
    <!-- banner part start-->
    <section class="breadcrumb breadcrumb_bg">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8">
          <div class="breadcrumb_iner">
            <div class="breadcrumb_iner_item">
              <h2>Panier</h2>
              <p>Home <span>-</span>Panier</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  
    <!-- feature_part start-->
   <section class="cart_area padding_top">
    <div class="container">
      <div class="cart_inner">
      <%
		ArrayList<Produit> panierlist=(ArrayList<Produit>) session.getAttribute("session-panier");
      ArrayList<Integer> panierqte=(ArrayList<Integer>) session.getAttribute("session-panier_qte");
		if(panierlist!=null && panierlist.size()>0 )  {
			float total = (float) session.getAttribute("session-panier_total");
	  %>  
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Produit</th>
                <th scope="col">Prix</th>
                <th scope="col">Quantite</th>
                <th scope="col">Total</th>
              </tr>
            </thead>
            <tbody>
				<% for(int i=0;i<panierlist.size();i++) { %>
              <tr>
                <td>
                  <div class="media">
                    <div class="d-flex">
                      <img src="img/product/<%= panierlist.get(i).getIMG() %>" alt="" />
                    </div>
                    <div class="media-body">
                      <p><%= panierlist.get(i).getLIBELLE() %></p>
                    </div>
                  </div>
                </td>
                <td>
                  <h5><%= panierlist.get(i).getPRIX_UNIT() + " DH" %></h5>
                </td>
                <td>
                  <h5><%= String.valueOf(panierqte.get(i)) %></h5>
                  <!-- <div class="product_count"> 
                    <span class="input-number-decrement"> <i class="ti-angle-down"></i></span>
                    <input class="input-number" type="text" value="<%= String.valueOf(panierqte.get(i)) %>" min="0" max="100">
                    <span class="input-number-increment"> <i class="ti-angle-up"></i></span>
                  </div>-->
                </td>
                <td>
                  <h5><%= panierqte.get(i)*panierlist.get(i).getPRIX_UNIT() +" DH"%></h5>
                </td>
              </tr>
              <% } %>
              <tr>
                <td></td>
                <td></td>
                <td>
                  <h5>Total du Panier</h5>
                </td>
                <td>
                  <h5><%= total %></h5>
                </td>
              </tr>
              <tr class="shipping_area">
                <td></td>
                <td></td>
                <td>
                  <h5>Livraison</h5>
                </td>
                <td>
                  <div class="shipping_box">
                    <ul class="list">
                      <li id="liv2" onclick="liv(2)" class="active">
                        <a >Livraison Standard: 40 DH</a>
                      </li>
                      <li id="liv1" onclick="liv(1)">
                        <a >Livraison Express: 80 DH</a>
                      </li>
                      
                    </ul>
                    
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
          <div class="checkout_btn_inner float-right">
            <a class="btn_1 checkout_btn_1" onclick="formSubmitpanier()" href="#">Payer votre commande</a>
          </div>
        </div>
      <%
		} else {
	  %>
      
      <div class="container-fluid mt-100">
		    <div class="row">
		        <div class="col-md-12">
		            <div class="card panier-card">
		                <div class="card-body panier-card-body cart">
		                    <div class="col-sm-12 empty-cart-cls text-center"> <img src="https://i.imgur.com/dCdflKN.png" width="130" height="130" class="img-fluid mb-4 mr-3">
		                        <h3><strong>Votre panier est Vide</strong></h3>
		                        <h4>Pour continuer vos achats cliquer sur le bouton au dessus :)</h4> <a class="btn_3" href="/produits">continue votre Shopping</a>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
      
      <% } %>
      
      
      </div>
  </section>
  <form hidden id="formPanier" method="POST" action="">
    <input hidden id="shipping" name="shipping" type="text" value="2">

  </form>

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


    <script>
      function liv(x){
        if(x==1){
          var liv1=document.getElementById("liv1");
          var liv2=document.getElementById("liv2");
          liv1.classList.add("active");
          liv2.classList.remove("active");
          var shipping=document.getElementById("shipping");
          shipping.value="1";
        }
        else{
          var liv1=document.getElementById("liv1");
          var liv2=document.getElementById("liv2");
          liv1.classList.remove("active");
          liv2.classList.add("active");
          var shipping=document.getElementById("shipping");
          shipping.value="2";
        }
      }

      function formSubmitpanier(){
        document.getElementById("formPanier").submit(); 
      }
    </script>
    
    <!-- jquery -->
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
  <!-- custom js -->
  <script src="js/App.js"></script>
</body>
</html>