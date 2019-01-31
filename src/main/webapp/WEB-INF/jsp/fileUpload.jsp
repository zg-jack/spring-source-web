<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload</title>
</head>
<body>

<form action="/file/fileUpload" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file">
    <input type="submit" value="提交">
</form>

</body>
</html>
