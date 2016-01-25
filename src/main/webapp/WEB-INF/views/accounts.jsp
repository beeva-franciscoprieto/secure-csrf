<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
	<meta charset="UTF-8" />
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
	<title>Accounts</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Secure development" />
	<meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
	<meta name="author" content="Codrops" />

	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/font-awesome.min.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/animate.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/structure.css'/>"/>

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>

    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Varela">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="overflow: visible;background-color: rgba(208, 223, 226, 0.4)">

<nav>
    <div class="container">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div id="bs-example-navbar-collapse-10" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden active">
                    <a href="#page-top"></a>
                </li>
                <li class="page-scroll">
                    <a href="/secure-csrf/logout" aria-label="Left Align"><span aria-hidden="true" class="glyphicon glyphicon-log-out"></span></a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!-- Preloader -->
<div id="preloader" style="display: none;">
    <div id="status" style="display: none;">&nbsp;</div>
</div>

<div>
    <section>
        <div>
            <div id="wrapper" class="col-sm-offset-3 col-sm-6 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
                <div id="register" class="animate form">

                    <div class="col-sm-2 col-sm-offset-10 col-md-offset-10 col-md-2 col-lg-offset-10 col-lg-2" style="visibility: visible; animation-name: fadeInDown;">
                        <input type="button" value="+" class="message_button" onclick="location='<c:url
                                value='/account' />'">
                    </div>
                    <form id="transferForm"  method="POST" action="<c:url
                    value='/transfer?${_csrf.parameterName}=${_csrf.token}'/>" autocomplete="on">

                        <h1> Accounts </h1>
                        <div style="width:500px">

                            <label>Origin Account</label></br>
                            <c:forEach var="account"  items="${accounts}"  varStatus="status">
                                <c:choose>
                                    <c:when test="${account.favorite == 'true'}">
                                        <input type="radio" name="originAccount" value="default"
                                               style="width:40px" checked>${account.accountNumber}
                                        </br>

                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="originAccount" value="${account.accountNumber}"
                                               style="width:40px">${account.accountNumber}
                                        </br>

                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <p>
                                <label>Amount</label>
                                <input type="text" id="amount" name="amount" required="required" placeholder="100&#128;">
                            </p>
                            <p>
                                <label>Target Account</label>
                                <input id="targetAccount" type="text" placeholder="ES7620770024003102575333"
                                       required="required" name="targetAccount">
                            </p>
                        </div>
                        <p class="signin button"><input type="submit" value="Tranfer"/></p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</footer>
<!-- ==================End content body section=============== -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<!-- For content animatin  -->
<script src="<c:url value='/resources/js/wow.min.js'/>"></script>

<script src="<c:url value='/resources/js/custom.js'/>"></script>
</body>
</html>