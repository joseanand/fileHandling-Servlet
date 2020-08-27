package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final String relativePath = "/WEB-INF/uploads";


	/***** This Method Is Called By The Servlet Container To Process A 'POST' Request *****/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Part filePart = request.getPart("file");
    String fileName = getSubmittedFileName(filePart);
    File fileDir = new File(getServletContext().getRealPath(relativePath));
    if (!fileDir.exists()){
      fileDir.mkdir();
    }
    File file = new File (getServletContext().getRealPath(relativePath), fileName);
    InputStream is = filePart.getInputStream();
    FileOutputStream fos = new FileOutputStream(file);
    byte[] buffer = new byte[1024];
    int length;
    while ((length = is.read(buffer))>0) {
        fos.write(buffer, 0, length);
    }
    fos.close();
    is.close();
    request.setAttribute("fileName", fileName);
    request.getRequestDispatcher("fileuploadResponse.jsp").forward(request, response);
  }

  protected String getSubmittedFileName(Part part){
    for (String cd : part.getHeader("content-disposition").split(";")){
      if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
			}
    }
    return null;
  }


}