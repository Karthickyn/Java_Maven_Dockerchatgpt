<%@ page language="java" %>
<html>
<head>
    <title>Java Counter App</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 50px; }
        button { padding: 10px 20px; margin: 5px; }
    </style>
</head>
<body>

<h1>Java Counter App</h1>

<%
    Integer count = (Integer) session.getAttribute("count");
    if (count == null) count = 0;
%>

<h2><%= count %></h2>

<form method="post" action="counter">
    <button name="action" value="inc">+</button>
    <button name="action" value="dec">-</button>
    <button name="action" value="reset">Reset</button>
</form>

</body>
</html>
