<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 03.02.2019
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="modal-form" id="restaurant-form">
    <div class="modal-header">
        <h3 class="modal-title">Добавить ресторан</h3>
    </div>
    <div class="modal-body">
        <form id="restaurantForm">
            <input type="hidden" id="RestaurantId" name="id">
            <table class="auxiliaryTables">
                <tr>
                    <td>
                        <label for="restaurant_name" >Название ресторана</label>
                    </td>
                    <td>
                        <input class="field" type="text" id="restaurant_name" name="restaurant_name">
                    </td>
                </tr>

            </table>
            <div id="execute">
                <button type="button" class="button" onclick="save('restaurant',adminRestaurantURL)">Сохранить</button>
            </div>
        </form>
    </div>
</div>
