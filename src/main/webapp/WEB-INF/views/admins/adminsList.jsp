<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 09.05.19
  Time: 12:15
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
    <title>Lista adminów</title>
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
    <a href="#">Edytuj dane</a>
    <a href='<c:url value="/logout"/>'>Wyloguj</a>
</div>


<div class="dashboardPageContainer" style="background-size: 100%; background-image: url(/media/images/P9046627)">
    <div class="pageTitle">
        <h2 style="color: white;">LISTA ADMINISTRATORÓW</h2>
    </div>

    <div class="addAdminForm">
        <form method="get" action="/admins/add">
            <p>Dodaj nowego administratora: <input type="submit" value="Dodaj"></p>
        </form>
    </div>
    <div class="makeNewAdmin">
        <form method="get" action="/usersList">
            <p>Mianuj nowego admina<input type="submit" value="Wybierz"></p>
        </form>
    </div>
    <div class="adminsList">
        <ul>
            <c:forEach items="${admins}" var="admin">
                <li>
                    <table style="color: black;">
                        <tr>
                            <td>${admin.firstName}</td>
                            <td>${admin.lastName}</td>
                            <td>${admin.login}</td>
                            <td>${admin.email}</td>
                            <td>
                                <form method="get" action="/usersList">
                                    <input type="submit" value="Edytuj dane admina">
                                </form>
                            </td>
                            <td>
                                <form:form modelAttribute="deleteAdmin" method="post">
                                    <input type="hidden" value="${admin
                                    .id}" name="userId">
                                    <input type="submit" value="Usuń admina" name="delete">
                                </form:form>
                            </td>
<%--                            <td>--%>
<%--                                <form:form modelAttribute="addPlaceToPlan" method="post">--%>
<%--                                    <select name="planId">--%>
<%--                                        <c:forEach items="${plans}" var="plan">--%>
<%--                                            <c:if test="${!plan.places.contains(place)}">--%>
<%--                                                <option value="${plan.id}">${plan.name}</option>--%>
<%--                                            </c:if>--%>
<%--                                        </c:forEach>--%>
<%--                                        <input type="hidden" value="${place.id}" name="placeId"/>--%>
<%--                                        <input type="submit" value="Usuń admina" name="addToPlan"/>--%>
<%--                                    </select>--%>
<%--                                </form:form>--%>
<%--                            </td>--%>
                        </tr>
                    </table>
                </li>
            </c:forEach>
        </ul>
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
