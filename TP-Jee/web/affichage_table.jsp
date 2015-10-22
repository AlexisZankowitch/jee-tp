<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <table border="1">
            <tr>
                <td>SNN</td>
                <td>multiplicator</td>
                <td>Bonus calc</td>
            </tr>
            <c:forEach items="${bonus_list.list}" var="bonus">
                <tr>
                    <td>
                        <c:out value="${bonus['ssn']}" />
                    </td>
                    <td>
                        <c:out value="${bonus['multiplicator']}"/>
                    </td>
                    <td>
                        <c:out value="${bonus['amount']}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/TP1-Jee">retour</a>
    </body>
</html>