<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 03.02.2019
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


        <div class="modal-form" id="user-form">
            <div class="modal-header">
                <h3 class="modal-title">Добавить пользователя</h3>
            </div>
            <div class="modal-body">
                <form id="personForm">
                    <input type="hidden" id="PersonId" name="id">
                    <table class="auxiliaryTables">
                        <tr>
                            <td>
                                <label for="person_name" class="col-form-label">Имя пользователя</label>
                            </td>
                            <td>
                                <input type="text" class="field" id="person_name" name="person_name" placeholder="Имя пользователя">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="email" class="col-form-label">E-mail</label>                            </td>
                            <td>
                                <input type="text" class="field" id="email" name="email" placeholder="E-mail">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label>Статус</label>
                            <td>
                            <select name="status" class="selector">
                                <option value="ROLE_ADMIN">Администратор</option>
                                <option value="ROLE_USER" selected>Пользователь</option>
                            </select>                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="password" class="col-form-label">Введите пароль</label>

                            </td>
                            <td>
                                <input type="password" class="field" id="password" name="password" placeholder="Введите пароль">
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label for="repassword" class="col-form-label">Повторите пароль</label>
                            </td>
                            <td>
                                <input type="password" class="field" id="repassword" name="repassword" placeholder="Повторите пароль">
                            </td>
                        </tr>

                    </table>
                        <div id="execute">
                            <button type="button" class="button" onclick="validPerson()">Сохранить</button>
                        </div>
                </form>
            </div>
        </div>

