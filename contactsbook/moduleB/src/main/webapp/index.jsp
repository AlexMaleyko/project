<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="resources/stylesheets/indexStylesheet.css" >
    <script src="resources/js/index.js"></script>
    <style>
        input[type='submit']:disabled{
            cursor: not-allowed;
        }
    </style>
</head>
<body>
<section>
    <div>
        <input type="submit" name="createContact" value="Создать">
        <input type="submit" id="updateContact" value="Изменить">
        <input type="submit" name="deleteContact" value="Удалить">
        Показывать
        <select>
            <option value="10">10</option>
            <option value="20">20</option>
        </select>
        записей на странице
        <input type="text" name="search" placeholder="Search.." id="searchInput" onkeydown="search()"/>
    </div>

    <table id="contactTable">
        <thead>
        <tr>
            <th><input type="checkbox" onchange="checkAll(this);manageUpdateButton(this)" id="mainCheckBox"/></th>
            <th>Полное имя</th>
            <th>Дата рождения</th>
            <th>Адрес</th>
            <th>Место работы</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td><input type="checkbox" name="checkBoxGroup" value="${contact.contactId}" onchange="manageUpdateButton(this)"/></td>
                <td><a href="#">${contact.name} ${contact.surname} ${contact.patronymic}</a></td>
                <td>${contact.birth}</td>
                <td>${contact.country} ${contact.city} ${contact.street} ${contact.postalCode}</td>
                <td>${contact.job}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button>Отправить email</button>
    <button>Форма поиска</button>

</section>
</body>
</html>
