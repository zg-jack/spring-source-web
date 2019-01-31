<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>user list</title>
</head>
<body>
<table align='center' border='1'>
    <caption>user list</caption>
    <tbody>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>age</th>
    </tr>
                <#list users as user>
                    <tr>
                        <td>${user.uid}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                    </tr>
                </#list>
    <tbody>
</table>
</body>
</html>