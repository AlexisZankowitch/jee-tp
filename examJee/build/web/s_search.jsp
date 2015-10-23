<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>${name}</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <h1>${name}</h1>
        <table border="1">
            <tr>
                <td>firstname</td>
                <td>birthname</td>
                <td>login</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>
                        <c:out value="${user.firstname}" />
                    </td>
                    <td>
                        <c:out value="${user.birthname}"/>
                    </td>
                    <td>
                        <c:out value="${user.login}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="creation.jsp">retour</a>
    </body>
</html>