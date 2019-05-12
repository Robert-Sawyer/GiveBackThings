<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 11.05.19
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Panel administratora</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="../../../media/css/style.css"/>" >
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/about" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br />
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>

            <ul class="slogan--buttons">
                <li><a href="/giveBackThings" class="btn btn--large">Oddaj rzeczy</a></li>
                <li><a href="/organizeCollection" class="btn btn--large">Zorganizuj zbiórkę</a></li>
            </ul>
        </div>
    </div>
</header>

<div class="sidenav">
    <a href='<c:url value="/adminDashboard" />'>Kokpit</a>
    <a href='<c:url value="/adminsList" />'>Administratorzy</a>
    <a href='<c:url value="/usersList" />'>Użytkownicy</a>
    <a href='<c:url value="/trustedInstitutions" />'>Zaufane instytucje</a>
    <a href='<c:url value="/listOfMyGifts" />'>Moje dary</a>
    <a href='<c:url value="/listOfMyCollections" />'>Moje zbiórki</a>
    <a href="#">Edytuj dane</a>
    <a href='<c:url value="/logout"/>'>Wyloguj</a>
</div>
<div class="dashboardPageContainer">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="/places/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">ODDAJ RZECZY</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/travel-plan/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">ZORGANIZUJ ZBIÓRKĘ</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/places/listAllPlaces">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">MOŻE COŚ JESZCZE</span>
                </a>
            </div>
        </div>

        <%--        <div class="dashboard-alerts">--%>
        <%--            <div class="alert-item alert-light">--%>
        <%--                <i class="far icon-calendar fa-calendar-alt"></i>--%>
        <%--                <span class="font-weight-bold">Liczba planów: </span>--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </div>
</div>


<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię" /></div>
            <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko" /></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="images/icon-facebook.svg"/></a> <a href="#" class="btn btn--small"><img src="images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>

</body>
</html>
