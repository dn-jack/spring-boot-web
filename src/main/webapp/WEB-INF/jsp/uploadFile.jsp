<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/uploadFile" method="POST" enctype="multipart/form-data">
    <p>单文件上传：</><br/>
    <input type="file" name="file1"/>
    <input type="submit" value = "上传"/>
</form>
<form method="POST" enctype="multipart/form-data" 
    action="${pageContext.request.contextPath }/uploadFiles">
    <p>多文件上传：</>
    <p>文件1：<input type="file" name="file" /></p>
    <p>文件2：<input type="file" name="file" /></p>
    <p><input type="submit" value="上传" /></p>
</form>
<a href="${pageContext.request.contextPath }/download">下载</a>
</body>
</html>