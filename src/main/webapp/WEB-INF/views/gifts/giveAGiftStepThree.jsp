<%--
  Created by IntelliJ IDEA.
  User: robert
  Date: 09.05.19
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Przekaż dar. Krok 3</title>
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj Agata
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Ustawienia</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="#">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li>
                <a href="#" class="btn btn--without-border"
                >Fundacje i organizacje</a
                >
            </li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
                wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
                bądź celu ich pomocy.
            </p>
            <p data-step="4">
                Na podstawie Twoich kryteriów oraz rzeczy, które masz do oddania
                wybraliśmy organizacje, którym możesz pomóc. Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="5">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>3</span>/5</div>

        <form:form modelAttribute="stepThree" method="post">
            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Lokalizacja:</h3>

                <div class="form-group form-group--dropdown">
                    <form:select path="localization">
                        <option value="0">- wybierz -</option>
                        <option value="warsaw">Warszawa</option>
                        <option value="wroclaw">Wrocław</option>
                        <option value="poznan">Poznań</option>
                        <option value="gdansk">Gdańsk</option>
                    </form:select>
                </div>

                <div class="form-section">
                    <h4>Komu chcesz pomóc?</h4>
                    <div class="form-section--checkboxes">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="help[]" value="children" />
                                <span class="checkbox">dzieciom</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="help[]" value="mothers" />
                                <span class="checkbox">samotnym matkom</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <input type="checkbox" name="help[]" value="homeless" />
                                <span class="checkbox">bezdomnym</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="help[]" value="disabled" />
                                <span class="checkbox">niepełnosprawnym</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="help[]" value="old" />
                                <span class="checkbox">osobom starszym</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="help[]" value="unemployed" />
                                <span class="checkbox">bezrobotnym</span>
                            </label>
                        </div>

                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="help[]" value="animals" />
                                <span class="checkbox">zwierzętom</span>
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-section">
                    <h4>Wpisz nazwę konkretnej organizacji (opcjonalnie)</h4>
                    <div class="form-group">
                        <textarea rows="4" name="organization_search"></textarea>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Szukaj</button>
                </div>
            </div>

        </form:form>
    </div>
</section>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50">
                <input type="text" name="name" placeholder="Imię" />
            </div>
            <div class="form-group form-group--50">
                <input type="text" name="surname" placeholder="Nazwisko" />
            </div>

            <div class="form-group">
            <textarea
                    name="message"
                    placeholder="Wiadomość"
                    rows="1"
            ></textarea>
            </div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"
            ><img src="images/icon-facebook.svg"
            /></a>
            <a href="#" class="btn btn--small"
            ><img src="images/icon-instagram.svg"
            /></a>
        </div>
    </div>
</footer>
</body>
</html>
