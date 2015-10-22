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
        <div>
            <h1>Affichage tp1</h1>
            <table border="1">
            <tr>
                <td>SNN</td>
                <td>Multiplier</td>
                <td>Bonus</td>
            </tr>
                <tr>
                    <td>
                        ${ssn}
                    </td>
                    <td>
                        ${multiplier}
                    </td>
                    <td>
                        ${bonus}
                    </td>
                </tr>
        </table>
        </div>
        <div>
            <h1>Affichage tp2</h1>
            <table border="1">
            <tr>
                <td>SNN</td>
                <td>Multiplier</td>
                <td>Bonus</td>
            <a href="../../../../Dropbox/ENSSAT/code/jee/web/tp5/affichage.jsp"></a>
            </tr>
                <tr>
                    <td>
                        ${beanBonus['ssn']==-1?"Mauvais ssn":beanBonus['ssn']}
                    </td>
                    <td>
                        ${beanBonus['multiplier']==-1?"Mauvais multiplier":beanBonus['multiplier']}
                    </td>
                    <td>
                        ${beanBonus['bonus']}
                    </td>
                </tr>
        </table>
        </div>
        <a href="/TP1-Jee">retour</a>
    </body>
</html>