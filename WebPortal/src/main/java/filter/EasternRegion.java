package filter;

import java.io.IOException;
import Filepath.filepath;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excel_filter.AppTest;
import link.AppLink;

/**
 * Servlet implementation class EasternRegion
 */
@WebServlet("/Filter")
public class EasternRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//int sno = Integer.parseInt(request.getParameter("sno"));
//		String refno = request.getParameter("refno");
//		String initname = request.getParameter("initname");
//		String initdep = request.getParameter("initdep");
//		String initloc = request.getParameter("initloc");
//		String pendep = request.getParameter("pendep");
//		String penduser = request.getParameter("penduser");
//		String sub = request.getParameter("sub");
		int day = Integer.parseInt(request.getParameter("numday"));
//---------------------------------------------------------------------------------
		List<AppTest> temp = AppLink.readXLSXFile(filepath.fileSource());
		HashMap<String, Integer> initDep = new HashMap<>();
		HashMap<String, Integer> pendDep = new HashMap<>();

		for (AppTest cust : temp) {
			String temp1 = cust.getInitiatorDepartment();
			String temp2 = cust.getPendingDepartment();
			String pendloc = cust.getPendingLocation();
			if (pendloc!=null && cust.getPendingDays() >= day && pendloc.equals("Eastern Region Office")) {

				if (initDep.containsKey(temp1) == false) {
					initDep.put(temp1, 1);
				} else {
					int x = initDep.get(temp1);
					initDep.put(temp1, x + 1);
				}
				if (pendDep.containsKey(temp2) == false) {
					pendDep.put(temp2, 1);
				} else {
					int x = pendDep.get(temp2);
					pendDep.put(temp2, x + 1);
				}
			}
		}
		//----------------------------------------------------------------------
		HashMap<HashMap<String,Integer>,String>depc=new HashMap<>();
		HashMap<String,Integer> emp =new HashMap<>();
		HashMap<String,String> empdep=new HashMap<>();
		for(AppTest i:temp)
		{
			String name=i.getPendingUser();
			String pendloc = i.getPendingLocation();
			String dep = i.getPendingDepartment();
			if (i.getPendingDays() >= day && pendloc.equals("Eastern Region Office")) {
				if(emp.containsKey(name)==false)
					emp.put(name, 1);
				else
				{
					int x=emp.get(name);
					emp.put(name, x+1);
				}
				if(empdep.containsKey(name)==false)
					empdep.put(name, dep);
			}
		}
		int gd=0;
		for(String num:emp.keySet())
		{
			gd+=emp.get(num);
		}
		
		//--------------------------------------------------------
		for (AppTest i : temp) {
		    String pendloc = i.getPendingLocation();
		    
		    if (i.getPendingDays() >= day && pendloc.equals("Eastern Region Office")) {
		        String name = i.getPendingDepartment();
		        HashMap<String, Integer> innerMap = new HashMap<>();
		        
		        for (String empName : emp.keySet()) {
		        	if(i.getPendingUser().equals(empName) && name.equals(empdep.get(empName)))
		        		innerMap.put(empName, emp.get(empName));
		        }
		        depc.put(innerMap, name);
		    }
		}
		
		HashMap<String,List<String>> dep=new HashMap<>();
		for(String dp:pendDep.keySet())
		{
			List<String> pdnames = new ArrayList<>();
			for(String i:empdep.keySet())
			{
				if(empdep.get(i).equals(dp))
				{
					pdnames.add(i);
				}
			}
			dep.put(dp, pdnames);
		}
		//-----------------------------------------------------------------------------------
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Filtered Data</title></head><body>");
		out.println("<div style='background-color:orange;'><h1 style='text-align: center;'>Number of Files pending with Unayan for >= " +day+" days"+"</h1></div>");
		out.println("<h2 style='text-align: center;'>List of Pending with Departments</h2>");
		out.println("<table border='1' style='margin: auto; border-collapse: collapse;'>"); 
		out.println("<tr>");
		for (String department : pendDep.keySet()) {
		    out.println("<th style='text-align: center;background-color:orange; width: 100px; height: 40px;'>" + department + "</th>");
		}
		out.println("<th style='text-align: center;background-color:orange; width: 100px; height: 40px;'>" + "ERO" + "</th>");
		out.println("</tr>");
		out.println("<tr>");
		int sum1 = 0;
		for (String department : pendDep.keySet()) {
		    sum1 += pendDep.get(department);
		    out.println("<td style='text-align: center; width: 100px; height: 40px;'>" + pendDep.get(department) + "</td>");
		}
		out.println("<td style='text-align: center; width: 100px; height: 40px;'>" + sum1 + "</td>");
		out.println("</tr>");
		out.println("</table>");

		out.println("<h2 style='text-align: center;'>List of Initiator Departments</h2>");
		out.println("<table border='1' style='margin: auto; border-collapse: collapse;'>"); 
		out.println("<tr>");
		int sum2 = 0;
		for (String department : initDep.keySet()) {
		    out.println("<th style='text-align: center; background-color:orange; width: 100px; height: 40px;'>" + department + "</th>");
		}
		out.println("<th style='text-align: center; background-color:orange; width: 100px; height: 40px;'>" + "ERO" + "</th>");
		out.println("</tr>");
		out.println("<tr>");
		for (String department : initDep.keySet()) {
		    sum2 += initDep.get(department);
		    out.println("<td style='text-align: center; width: 100px; height: 40px;'>" + initDep.get(department) + "</td>");
		}
		out.println("<td style='text-align: center; width: 100px; height: 40px;'>" + sum2 + "</td>");
		out.println("</tr>");
		out.println("</table>");
		
		
		out.println("<br><br><table style='margin: auto; text-align: center; border-collapse: collapse; border: 1px solid black;'>");
		out.println("<tr style='background-color:lightgrey''><th style='border: 1px solid black;width:320px'>PENDING WITH DEPARTMENT</th><th style='border: 1px solid black; width:300px'>PENDING WITH NAME</th><th style='border: 1px solid black; width:100px'>REFERENCE COUNT</th></tr>");
		for (String dp : dep.keySet()) {
		    List<String> employees = dep.get(dp);
		    out.println("<tr>");
		    out.println("<td style='border: 1px solid black;' rowspan='" + employees.size() + "'>" + dp + "</td>");
		    for (int i = 0; i < employees.size(); i++) {
		        if (i > 0) {
		            out.println("<tr>");
		        }
		        out.println("<td style='border: 1px solid black;'>" + employees.get(i) + "</td>");
		        out.println("<td style='border: 1px solid black;'>" + emp.get(employees.get(i)) + "</td></tr>");
		    }
		    out.println("</tr>");
		}
		out.println("<tr style='background-color:lightgrey;'><td colspan='2'>"+"GRAND TOTAL"+"</td><td>"+gd+"</td></tr>");
		out.println("</table>");
		out.println("<form action='Downloader' method='get'>"+ "<button type='submit' name='day' value="+day+ ">DOWNLOAD</button></form>");
		out.println("</body></html>");

	}
}
