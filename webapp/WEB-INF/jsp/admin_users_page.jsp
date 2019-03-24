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
        ${name}
    </div>
</header>

<aside>
    <div class="login_form" hidden="hidden">

            <table class="auxiliaryTables">
                <tr>
                    <td>
                        <button id="updateButton" onclick="updateRow(adminPersonURL+${id},'person')">Редактировать свой профиль</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button id="deleteButton">Удалить свой профиль</button>
                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--<button class="addButton" id="regNewPerson" onclick="add($userModalContent)">Добавить нового пользователя</button>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <tr>
                    <td>
                        <form action="/logout">
                            <button id="logoutButton" type="submit">ВЫХОД</button>
                        </form>
                    </td>
                </tr>
            </table>

    </div>

    <table>
        <tr>
            <td>
                <button id="addPerson" class="addButton" onclick="add($userModalContent)">
                    Добавить пользователя
                </button>
            </td>
            <td>
                <form action="/rest/admin/restaurant_list/${id}">
                    <button id="toUserPage" type="submit">Список ресторанов</button>
                </form>
            </td>
        </tr>
    </table>

    <div class="RestTable">
        <table id="usersTable" class="shownTables">
            <thead>
            <tr>
                <%--<th class="details-control"></th>--%>
                <th>Имя</th>
                <th>E-mail</th>
                <th>Статус</th>
            </tr>
            </thead>
        </table>
    </div>
    <br/>

</aside>

<footer>
    Приложение "Рестораны" <br/>
    &copy; Иван Верещагин <br/>
    ivan_ver89@mail.ru
</footer>


<jsp:include page="/WEB-INF/jsp/forms/form-user.jsp"/>

<script type="text/javascript" src="/resources/js/JSresources/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/JSresources/datatables.js"></script>

<script type="text/javascript" src="/resources/js/common_functions.js"></script>
<script type="text/javascript" src="/resources/js/CONSTANTS.js"></script>
<script type="text/javascript" src="/resources/js/modal_window.js"></script>

<%--<jsp:include page="/WEB-INF/jsp/fragments/ref_JS.jsp"/>--%>
<script type="text/javascript" src="/resources/js/admin_users_page.js"></script>








</body>
</html>
