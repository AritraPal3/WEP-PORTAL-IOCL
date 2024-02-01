package backend;

import java.io.IOException;
import Filepath.filepath;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excel_filter.AppTest;
import link.AppLink;

@WebServlet("/Details")
public class Details extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    List<AppTest> temp = AppLink.readXLSXFile(filepath.fileSource());
	    PrintWriter out = response.getWriter();
	    out.println("<a href='/WebPortal/'>Back</a>");
	    out.println("<style>" +
                "table {" +
                "    border-collapse: collapse;" +
                "    width: 100%;" +
                "    border: 1px solid black;" +
                "}" +
                "th, td {" +
                "    border: 1px solid black;" +
                "    padding: 8px;" +
                "    text-align: center;" +
                "}" +
                "</style>");
	    
	    out.println("<table>");
	    out.println("<tr>" +
	                "<th>S_no</th>" +
	                "<th>ReferenceNo</th>" +
	                "<th>Initiator Name</th>" +
	                "<th>Initiator Department</th>" +
	                "<th>Initiator Location</th>" +
	                "<th>Pending Department</th>" +
	                "<th>Pending User</th>" +
	                "<th>Pending Location</th>" +
	                "<th>Subject</th>"+
	                "<th>No of Days</th>" +
	                "</tr>");
	    
	    for (AppTest i : temp) { if( i!=null && i.getPendingLocation().equals("Eastern Region Office")){
	        out.println("<tr>" +
	                    "<td>" + i.getS_no() + "</td>" +
	                    "<td>" + i.getRefernce() + "</td>" +
	                    "<td>" + i.getInitiatorName() + "</td>" +
	                    "<td>" + i.getInitiatorDepartment() + "</td>" +
	                    "<td>" + i.getInitiatorLocation() + "</td>" +
	                    "<td>" + i.getPendingDepartment() + "</td>" +
	                    "<td>" + i.getPendingUser() + "</td>" +
	                    "<td>" + i.getPendingLocation() + "</td>" +
	                    "<td>" + i.getSubject() + "</td>" +
	                    "<td>" + i.getPendingDays() + "</td>" +
	                    "</tr>");
	    }
	    }
	    out.println("</table>");
	}

}

