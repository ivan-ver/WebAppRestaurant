<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Рестораны</title>
    <meta charset="windows-1251">
    <jsp:include page="/WEB-INF/jsp/fragments/ref_CSS.jsp"/>

</head>
<body>
<header>
    <div id="title">
        Рестораны
    </div>
    <div id="inlet_button">
        Вход
    </div>
</header>

<aside>
    <div class="login_form" hidden="hidden">
        <form name='form_login' action="/login" method='POST' >
            <table class="auxiliaryTables">
                <tr>
                    <td class="login_field" colspan="2">
                        <input type='text' name='username' value='' placeholder="E-mail" class="field">
                    </td>
                </tr>
                <tr>
                    <td class="login_field" colspan="2">
                        <input type='password' name='password' placeholder="Пароль" class="field"/>
                    </td>
                </tr>
                <tr>
                    <td >
                        <button name="submit" type="submit" value="submit" id="login_b">Войти</button>
                    </td>
                </tr>
            </table>
        </form>

    </div>


    <div class="RestTable">
        <div>
            <table id="WelcomeRestaurantTable" class="shownTables">
                <thead>
                <tr>
                    <th class="details-control"></th>
                    <th class="restaurantName">Ресторан</th>
                    <th class="restaurantAssessment">Средняя оценка посетителей</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</aside>

<footer>
    Приложение "Рестораны" <br/>
    &copy; Иван Верещагин <br/>
    ivan_ver89@mail.ru
</footer>




<script type="text/javascript" src="resources/js/JSresources/jquery-3.3.1.js"></script>
<script type="text/javascript" src="resources/js/JSresources/datatables.js"></script>

<script type="text/javascript" src="resources/js/common_functions.js"></script>
<script type="text/javascript" src="resources/js/CONSTANTS.js"></script>
<script type="text/javascript" src="resources/js/modal_window.js"></script>
<script type="text/javascript" src="/resources/js/welcome_page_fuctions.js"></script>



</body>
</html>
