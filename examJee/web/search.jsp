<%-- 
    Document   : search
    Created on : 23 oct. 2015, 14:29:55
    Author     : azank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>exam Jee</title>
    </head>
    <body>
        <h1>Search</h1>
        <div>
            <form action="http://localhost:8080/examJee/ServletUserSearch">
                <label for="search">
                    Enter login :
                    <input type="text"/>
                </label>
                <input type="submit" value="Search"/>
            </form>
        </div>
        <footer>
            <a href="index.jsp">Home</a>
        </footer>
    </body>
</html>
