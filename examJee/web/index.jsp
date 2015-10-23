<%-- 
    Document   : index
    Created on : 23 oct. 2015, 14:28:08
    Author     : azank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>exam Jee</title>
        <style>
            body {
                background-color: linen;
            }

            h1 {
                color: maroon;
                margin-left: 40px;
            } 
            ul li {
                padding: 10px 15px;
            }
        </style>
    </head>
    <body>
        <h1>Navigation</h1>
        <ul>
            <li>
                <a href="creation.jsp">User creation</a>
            </li>
            <li>
                <a href="search.jsp">Search</a>
            </li>
            <li>
                <a href="/examJee/ServletShowAll">All users</a>
            </li>
            <li>
                <a href="/examJee/ServletPurge">Purge bdd</a>
            </li>
        </ul>
    </body>
</html>
