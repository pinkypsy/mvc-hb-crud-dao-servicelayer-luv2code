<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" type="text/css"
<%--the proper app name in curly braces--%>
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>
        List Customers
    </title>
</head>

<body>

<div id = "wrapper">
    <div id = "header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id = "container">
    <div id = "content">
        <input type="button" value="Add Customer"
        onclick="window.location.href = 'showFormForAdd'; return false"
        class="add-button">
    </div>
</div>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>

    <c:forEach var="customer" items="${customers}">
        <tr>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.email}</td>
        </tr>
    </c:forEach>
</table>


</body>

</html>