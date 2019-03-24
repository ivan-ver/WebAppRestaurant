<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 03.02.2019
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal-form" id="dish-form">
    <div class="modal-header">
        <h3 class="modal-title">Добавить блюдо</h3>
    </div>
    <div class="modal-body">
        <form id="dishForm">
            <input type="hidden" id="DishId" name="id">
            <table class="auxiliaryTables">
                <tr>
                    <td>
                        <label for="dish_name" class="col-form-label">Название блюда</label>
                    </td>
                    <td>
                        <input type="text" class="field" id="dish_name" name="dish_name">
                    </td>
                </tr>

                <tr>
                    <td>
                        <label for="dish_price" class="col-form-label">Цена</label>
                    </td>
                    <td>
                        <input type="number" class="field" id="dish_price" name="dish_price">
                    </td>
                </tr>

            </table>
            <div id="execute">
                <button type="button" class="button" onclick="save('dish',adminDishURL)">Сохранить</button>
            </div>
        </form>
    </div>
</div>
