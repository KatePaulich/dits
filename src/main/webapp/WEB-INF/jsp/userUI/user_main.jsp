<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>User main page</title>
    <link rel="stylesheet" href="<c:url value="/css/common_style.css"/>" type="text/css"/>
</head>
<body>
<h4 align="center">User UI main page</h4>
<table align="center" border="0" cellspacing="2">
    <tbody>
    <tr >
        <td rowspan="2">
            <img width="50%" height="50%" src="<c:url value="/resources/images/human1.png"/>">
        </td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td>
                        <a href="<c:url value="/user/select_topic_and_test"/>">Выбор темы и теста </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="<c:url value="/user/personal_statistic"/>">Личная статистика</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
