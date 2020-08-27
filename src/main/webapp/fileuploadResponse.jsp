<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body bgcolor="#FCF7DA" align="center">
	<h1>File Upload Response</h1>
	<div>
		File <% out.print(request.getAttribute("fileName")); %> uploaded successfully.
	</div>
	Click <a href="uploadedFilesServlet">here</a> to get list of files uploaded.
	</body>
</html>	