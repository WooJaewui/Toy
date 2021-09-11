package test;

import java.awt.Image;
import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.Field;

@WebServlet("/image")
public class image extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String[] dog = request.getParameterValues("dog");
		
		
		
		PrintWriter out = response.getWriter();
		
		if(dog == null){
			out.println("좋아하는 강아지가 없습니다.");
		} else{
			for(int i=0; i<dog.length; i++){
				switch(dog[i]){
				case "푸들" :
					out.write("<html><body><img src='/Image_test/source/pu.jpg'></body></html>");
					break;
				case "진돗개" :
					out.write("<html><body><img src='/Image_test/source/jin.jpg'></body></html>");
					break;
				case "풍산개" :
					out.write("<html><body><img src='/Image_test/source/pung.jpg'></body></html>");
					break;
				case "삽살개" :
					out.write("<html><body><img src='/Image_test/source/sap.jpg'></body></html>");
					break;
				}
			}
		} 
		out.close();
	}
}
