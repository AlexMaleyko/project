<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 28.03.2017
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/stylesheets/contactForm.css" >
    <script src="resources/js/contactForm.js"></script>
</head>
<body>
<section id="container">

    <section id="contact">
        <img src="pictures/default.jpg"/>
        <form>
            <label for="fname">Имя*</label><br>
            <input type="text" id="fname" name="fname" value="Имя"><br>
            <label for="lname">Фамилия*</label><br>
            <input type="text" id="lname" name="lname" value="Фамилия"><br>
            <label for="patronymic">Отчество</label><br>
            <input type="text" id="patronymic" name="patronymic" value="Отчество"><br>
            <label for="birth">Дата рождения</label><br>
            <input type="text" id="birth" name="birth" value="Дата Рождения"><br>
            <label for="gender">Пол</label>
            <select id="gender" name="gender">
                <option>М</option>
                <option>Ж</option>
            </select><br>
            <label for="citizenship">Гражданство</label><br>
            <input type="text" id="citizenship" name="citizenship" value="Гражданство"><br>
            <label for="status">Семейное положение</label><br>
            <input type="text" id="status" name="status" value="Семейное положение"><br>
            <label for="email">Email</label><br>
            <input type="text" id="email" name="email" value="example@mailbox.com"><br>
            <label for="web">Web-сайт</label><br>
            <input type="text" id="web" name="web" value="www.site.com"><br>
            <label for="job">Место работы</label><br>
            <input type="text" id="job" name="job" value="Работа"><br>
            Адрес<br>
            <label for="country">Страна: </label><input type="text" class="address" id="country" value="Страна">
            <label for="city">Город: </label><input type="text" class="address" id="city" value="Город"><br>
            <label for="street">Улица: </label><input type="text" class="address" id="street" value="Улица">
            <label for="index">Индекс: </label><input type="text" class="address" id="index" value="220123">
        </form>
    </section>



    <section id="associatedData">

        <section id="phones">
            <div>Контактные телефоны</div>
            <input type="submit" value="Добавить" class="phoneBtn"/>
            <input type="submit" value="Изменить" class="phoneBtn" id="updatePhoneBtn"/>
            <input type="submit" value="Удалить" class="phoneBtn"/>
            <table>
                <thead>
                <tr>
                    <th><input type="checkbox" id="mainCheckBox" onclick="checkAllPhones(this);manageUpdateButton(this)"/></th>
                    <th>Номер</th>
                    <th>Тип</th>
                    <th>Комментарий</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="checkbox" name="checkBoxGroup" onchange="manageUpdateButton(this)"/></td>
                    <td>+375(29)775-75-42</td>
                    <td>мобильный</td>
                    <td>Бесплатные вебинары по java</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="checkBoxGroup" onchange="manageUpdateButton(this)"/></td>
                    <td>+375(29)775-75-42</td>
                    <td>мобильный</td>
                    <td>Бесплатные вебинары по java</td>
                </tr>
                </tbody>
            </table>
        </section>

        <section id="attachments">
            <div>Прикрепленые файлы</div>
            <input type="submit" value="Добавить" class="attachmentBtn"/>
            <input type="submit" value="Изменить" class="attachmentBtn" id="updateAttachBtn"/>
            <input type="submit" value="Удалить" class="attachmentBtn"/>
            <table>
                <thead>
                <tr>
                    <th><input type="checkbox" id="mCheckBox" onclick="checkAllAttachs(this);manageUpdateButton1(this)"/></th>
                    <th>Имя файла</th>
                    <th>Дата загрузки</th>
                    <th>Комментарий</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="checkbox" name="checkBoxGroup1" onchange="manageUpdateButton1(this)"/></td>
                    <td>Имя файла</td>
                    <td>Дата загрузки</td>
                    <td>Комментарий</td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="checkBoxGroup1" onchange="manageUpdateButton1(this)"/></td>
                    <td>Имя файла</td>
                    <td>Дата загрузки</td>
                    <td>Комментарий</td>
                </tr>
                </tbody>
            </table>
        </section>
    </section>

</section>
</body>
</html>
