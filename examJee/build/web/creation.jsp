<%-- 
    Document   : index
    Created on : 23 oct. 2015, 13:45:20
    Author     : azank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exam Jee</title>
    </head>
    <body>
        <header>
           <h1>Users creation</h1> 
        </header>
        <div>
            <form action="http://localhost:8080/examJee/ServletUserCreation">
                <c:forEach var="i" begin="1" end="4">
                <div>
                    <label for="Firstname">
                        Firstname :
                        <input type="text" name="Firstname"/>
                    </label>
                    <label for="Birthname">
                        Birthname :
                        <input type="text" name="Birthname"/>
                    </label>
                    <label for="Login">
                        Login :
                        <input type="text" name="Login"/>
                    </label>
                </div>
                </c:forEach>
            <input type="submit" id="submit_form" value="Create"/>
            </form>
        </div>
        <footer>
            <a href="index.jsp">Home</a>
        </footer>
    </body>
</html>
