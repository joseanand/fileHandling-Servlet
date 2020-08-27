<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body bgcolor="#FCF7DA" align="center">
	<h1>File Upload</h1>
    <form action="/fileUploadServlet" method="POST" enctype="multipart/form-data">
    <div>
      <label>Upload File:</label>
      <input type="file" name="file" id="fileAttachment">Please upload a file!
    </div>
    <div>
      <input type="submit" id="uploadBtn">
    </div>
    </form>
  </body>
</html>