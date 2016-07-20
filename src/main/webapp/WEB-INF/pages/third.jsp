<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>

<style type="text/css">
    input.button7 {
        font-weight: 700;
        color: white;
        text-decoration: none;
        border-radius: 3px;
        background: rgb(64, 199, 129);
        box-shadow: 0 -3px rgb(53, 167, 110) inset;
        transition: 0.2s;
        width: 280px;
        text-align: center;
        display: inline-block;
        padding: .8em 0 calc(.8em + 3px);

    }

    input.button7:hover {
        background: rgb(53, 167, 110);
    }

    input.button7:active {
        background: rgb(33, 147, 90);
        box-shadow: 0 3px rgb(33, 147, 90) inset;
    }
</style>

<head>

    <meta charset="utf-8">
    <style>
        #centerLayer {
            width: 450px;
            height: 250px;
            position: fixed;
            margin: auto;
            left: 0;
            top: 0;
            right: 0;
            bottom: 0;
            padding: 5px;
            border: 1px solid black;
            background: #ebebeb;
        }
    </style>

    <title>
        <c:if test="${empty record.id}"> Добавление </c:if>
        <c:if test="${not empty record.id}"> Редактирование </c:if>
    </title>
</head>
<body>
<div id="centerLayer">
    <div align="center">
        <H2>Заполнение формы</H2>
        <form:form commandName="record" method="post" action="/add">
            <form:hidden path="id"/>
            <table>
                <tr>
                    <td>Событие</td>
                    <td><form:input path="event" size="30"/></td>
                </tr>
                <tr>
                    <td>Время</td>
                    <td><form:input path="time" size="30"/></td>
                </tr>
                <tr>
                    <td>Приоритет</td>
                    <td><form:input path="priority" size="30"/></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Сохранить" class="button7"/>
        </form:form>
    </div>
</div>
</body>
</html>