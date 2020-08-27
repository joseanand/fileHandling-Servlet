package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int BUFFER_SIZE = 1024 * 100;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		File file = new File (getServletContext().getRealPath(FileUploadServlet.relativePath), request.getParameter("fileName"));
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		response.setContentType("application/octet-stream");
		response.setHeader("content-disposition", "attachment; fileName="+request.getParameter("fileName"));
		byte[] buffer = new byte[1024];
		int length;
		while((length = fis.read(buffer))>0) {
		    os.write(buffer, 0, length);
		}
		os.close();
		fis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
