<%@page import="java.util.List"%>
<%@page import="com.FileDetails"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body bgcolor="#FCF7DA" align="center">
    <h1>Uploaded Files</h1>
    <table align="center">
    	<thead>
    	<tr>
    	<th>File Name</th>
    	<th>File Size</th>
    	</tr>
    	</thead>
    	<tbody>
        <%
            List<FileDetails> fileList = (List) request.getAttribute("fileDetails");
            for (FileDetails fileDetails : fileList){
                %><tr>
                <td><a href="downloadServlet?fileName=<% out.println(fileDetails.getName());%>"><% out.println(fileDetails.getName());%></a> </td>
                <td><% out.println(fileDetails.getSize());%> kb </td>
                </tr><%
            }
        %>
        </tbody>
        </table>
    </body>
</html>