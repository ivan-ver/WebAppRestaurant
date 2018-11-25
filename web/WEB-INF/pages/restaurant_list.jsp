<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="windows-1251">
    <title>Рестораны</title>
</head>
<body>
    <h1>Рестораны</h1>
    <%--<a href="/restaurant/showAddRestaurantPage"><p><botton>добавить ресторан</botton></a>--%>

    <table border="1">
                <tr>
                    <th>Ресторан</th>
                    <th>Меню</th>
                    <th>Оценка посетителей</th>
                    <th></th>
                </tr>
                <tr>
                    <th><a href="/restaurant/showAddRestaurantPage"><p><button>Добавить ресторан</button></a></th>
                </tr>
            <c:forEach items="${restaurants}" var="restaurant">
                <tr>
                    <td>
                        <b>${restaurant.restaurant_name}</b>
                    </td>
                    <td>
                        <c:if test="${restaurant.dishes.size() > 0}">
                        <table>
                            <c:forEach items="${restaurant.dishes}" var="dish">
                            <tr>
                                <td>${dish.dish_name}</td>
                                <td align="right">${dish.dish_price} руб.</td>
                                <td align="right"><a href="/restaurant/showUpdateDish/${dish.id}"><p><button>Изменить</button></a></td>
                                <td align="right"><a href="/restaurant/deleteDish/${dish.id}"><p><button>Удалить</button></a></td>
                            </tr>
                            </c:forEach>
                        </table>
                        </c:if>
                        <a href="/restaurant/showAddDishPage/${restaurant.id}"><p><button>Добавить блюдо</button></a>
                    </td>
                    <td align="center">
                        <b>${restaurant.mean_assessment}</b>
                    </td>
                    <td align="center">
                        <a href="/restaurant/showUpdateRestaurant/${restaurant.id}"><p><button>Изменить</button></a>
                        <a href="/restaurant/deleteRestaurant/${restaurant.id}"><p><button>Удалить</button></a>
                    </td>
                </tr>
            </c:forEach>
    </table>




</body>
</html>
