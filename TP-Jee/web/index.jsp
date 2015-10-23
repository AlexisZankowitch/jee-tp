<%-- 
    Document   : index
    Created on : 21 oct. 2015, 13:25:44
    Author     : azank
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
    body {
        background-color: linen;
    }

    h1 {
        color: maroon;
        margin-left: 40px;
    } 
    .left{
        float: left;
    }
    .right{
        float: right;
    }
    </style>
    <body>
        <div class="left">
            <form action="http://localhost:8080/TP1-Jee/Servlet">
                <h1>Bonus Calculation</h1>
                <div>
                    <label for="socialnumber">
                        Security social number :
                        <input type="text" name="socialnumber" id="socialnumber"/>
                    </label>
                    <label for="multiplier">
                        Enter multiplier :
                        <input type="text" name="multiplier" id ="multiplier"/>
                    </label>
                </div>
                <input type="submit" id="submit_form" />
            </form>
        </div>
        <div class="right">
            <form action="http://localhost:8080/TP1-Jee/ServletTable">
                <h1>Bonus Calculation for a table</h1>
                <c:forEach var="i" begin="1" end="3">
                <div>
                    <label for="socialnumber">
                        Security social number :
                        <input type="text" name="socialnumber" value='${i}'/>
                    </label>
                    <label for="multiplier">
                        Enter multiplier :
                        <input type="text" name="multiplier" value='${i+2}'/>
                    </label>
                </div>
                </c:forEach>
            <input type="submit" id="submit_form" />
            </form>
        </div>
        <div class="left">
            <form action="http://localhost:8080/TP1-Jee/ServletDAO">
                <h1>Bonus Calculation DAO</h1>
                <c:forEach var="i" begin="1" end="3">
                <div>
                    <label for="socialnumber">
                        Security social number :
                        <input type="text" name="socialnumber" value='${i}'/>
                    </label>
                    <label for="multiplier">
                        Enter multiplier :
                        <input type="text" name="multiplier" value='${i+2}'/>
                    </label>
                </div>
                </c:forEach>
            <input type="submit" id="submit_form" />
            </form>
        </div>
        <div class="right">
            <form action="http://localhost:8080/TP1-Jee/ServletEJB">
                <h1>Bonus Calculation for EJB</h1>
                <c:forEach var="i" begin="1" end="3">
                <div>
                    <label for="socialnumber">
                        Security social number :
                        <input type="text" name="socialnumber" value='${i+7}'/>
                    </label>
                    <label for="multiplier">
                        Enter multiplier :
                        <input type="text" name="multiplier" value='${i+5}'/>
                    </label>
                </div>
                </c:forEach>
            <input type="submit" id="submit_form" />
            </form>
        </div>
        <div class="left">
            <form action="http://localhost:8080/TP1-Jee/ServletBonusRemote">
                <h1>Bonus Calculation for EJB Remote</h1>
                <c:forEach var="i" begin="1" end="3">
                <div>
                    <label for="socialnumber">
                        Security social number :
                        <input type="text" name="socialnumber" value='${i+9}'/>
                    </label>
                    <label for="multiplier">
                        Enter multiplier :
                        <input type="text" name="multiplier" value='${i+40}'/>
                    </label>
                </div>
                </c:forEach>
            <input type="submit" id="submit_form" />
            </form>
        </div>
    </body>
</html>
