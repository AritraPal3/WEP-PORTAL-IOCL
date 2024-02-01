package route2;

import java.io.IOException;
import Filepath.filepath;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excel_filter.AppTest;
import link.AppLink;

@WebServlet("/Route1")
public class SecondFilter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read data from the Excel file
        List<AppTest> data = AppLink.readXLSXFile(filepath.fileSource());
        PrintWriter out = response.getWriter();
        int day = Integer.parseInt(request.getParameter("numday"));
        out.println("<!DOCTYPE html>");
        out.println("<html style='margin: auto;'>");
        out.println("<head><title>Filtered Data 2</title></head>");
        out.println("<body>");
        out.println("<div style='background-color:orange;'><h1 style='text-align: center;'>Number of Files pending with Unayan for >= " + day + " days" + "</h1></div>");

        out.println("<form action='Downloader1' method='get'>"+ "<button type='submit' name='day' value="+day+ ">DOWNLOAD</button></form>");
        out.println("<div style='display: flex; justify-content: center;s'>");

        // Table 1: Pending with Location, Department, Users
        out.println("<div>");
        // table function1
        pendingTable(day,data,out);
        out.println("</div>");
        ///-------------------------------------------------------------
        // Table 2: Initiator Location, Initiator Department, Initiator Name
        out.println("<div style='margin-left: 20px;'>");
        //table function 2
        initiatorTable(day,data,out);
        out.println("</div>");
        out.println("</div>");
    
        

        out.println("</body></html>");

    }
    public void pendingTable(int num,List<AppTest> data, PrintWriter out)
    {
        HashMap<String,Integer> dep=new HashMap<>();
        HashMap<String,String> user_dep=new HashMap<>();
        HashMap<String,Integer> user_ct=new HashMap<>();
        int count=0;
        for(AppTest i:data)
        {
        	String loc=i.getPendingLocation();
        	//--------------------
//        	if(loc!=null && loc.equals("West Bengal State Office"))
//    			System.out.println(i.getPendingUser());
        	//----------------------
        	if(loc!=null && !loc.equals("Eastern Region Office") && i.getPendingDays()>=num)
        	{
        		//DEbug
//        		if(loc.equals("West Bengal State Office")&&count==0)
//        			System.out.println(i.getPendingUser()+"------"+i.getPendingDepartment()+"---"+i.getPendingLocation());
        		count++;
        		if(true) {
        		String emp_name=i.getPendingUser();
        		String pend_dep=i.getPendingDepartment();
//        		System.out.println(pend_dep);
        		user_dep.put(emp_name, pend_dep);
        		
//        		if(i.getPendingDepartment().equals("Aviation"))
//        			System.out.println(i.getPendingUser());
        		String name=pend_dep;
        		if(dep.containsKey(name)==false)
					dep.put(name, 1);
				else
				{
					int x=dep.get(name);
					dep.put(name, x+1);
				}
        		
        		if(user_ct.containsKey(emp_name)==false)
					user_ct.put(emp_name, 1);
				else
				{
					int x=user_ct.get(emp_name);
					user_ct.put(emp_name, x+1);
				}
        		}
        	}    	
        }
//        count--;
        
        //--Debug Code

        

        out.println("<table style='margin: auto; text-align: center; border-collapse: collapse; background-color: lightorange; border: 1px solid black;'>");
        out.println("<tr style='background-color:#efc984;'><td style='height:52px; font-size:20px' colspan='2'>"+"Pending with Location, Department, Users"+"</td></tr>");
        out.println("<tr style='background-color:#bebeff;'><td style='border: 1px solid black; '><b><u>Departments</u></b></td><td style='border: 1px solid black;'><b><u>Count_reference</u></b></td></tr>");
//        out.println("<tr><th style='border: 1px solid black;'>Departments</th><th style='border: 1px solid black;'>Count_reference</th></tr>");
        for (String department : dep.keySet()) {
            out.println("<tr><td style='border: 1px solid black;'><b>" + department + "</b></td><td style='border: 1px solid black;'><b>" + dep.get(department) + "</b></td></tr>");
            for (String emp : user_dep.keySet()) {
                if (user_dep.get(emp).equals(department))
                    out.println("<tr><td style='border: 1px solid black;'>" + emp + "</td><td style='border: 1px solid black;'>" + user_ct.get(emp) + "</td></tr>");
            }
        }
        out.println("<tr style='background-color:lightgrey;'><td>"+"GRAND TOTAL"+"</td><td>"+count+"</td></tr>");
        out.println("</table>");
    }

    public void initiatorTable(int num,List<AppTest> data, PrintWriter out)
    {
    	HashMap<String,Integer> dep=new HashMap<>();
        HashMap<String,String> user_dep=new HashMap<>();
        HashMap<String,Integer> user_ct=new HashMap<>();
        int count=0;
        for(AppTest i:data)
        {
        	String loc=i.getInitiatorLocation();
        	if(loc!=null && !loc.equals("Eastern Region Office") && i.getPendingDays()>=num)
        	{
        		count++;
        		if(true) {
        		String emp_name=i.getInitiatorName();
        		String init_dep=i.getInitiatorDepartment();
//        		System.out.println(init_dep);
//        		if(i.getInitiatorDepartment().equals("Aviation"))
//        			System.out.println(i.getInitiatorName());
        		user_dep.put(emp_name, init_dep);
        		String name=init_dep;
        		if(dep.containsKey(name)==false)
					dep.put(name, 1);
				else
				{
					int x=dep.get(name);
					dep.put(name, x+1);
				}
        		
        		if(user_ct.containsKey(emp_name)==false)
					user_ct.put(emp_name, 1);
				else
				{
					int x=user_ct.get(emp_name);
					user_ct.put(emp_name, x+1);
				}
        		}
        	}
        }
        //count--;
        
        //Debug Code
        
        
//        s
        

        out.println("<table style='margin: auto; text-align: center; border-collapse: collapse; background-color: lightorange; border: 1px solid black;'>");
        out.println("<tr style='background-color:#efc984;'><td style='height:52px; font-size:20px' colspan='2'>"+"Initiator Location, Department, Users"+"</td></tr>");
        out.println("<tr style='background-color:#bebeff;'><td style='border: 1px solid black;'><b><u>Departments</u></b></td><td style='border: 1px solid black;'><b><u>Count_reference</u></b></td></tr>");
        for (String department : dep.keySet()) {
            out.println("<tr style='background-color=grey;'><td style='border: 1px solid black;'><b>" + department + "</b></td><td style='border: 1px solid black;'><b>" + dep.get(department) + "</b></td></tr>");
            for (String emp : user_dep.keySet()) {
                if (user_dep.get(emp).equals(department))
                    out.println("<tr><td style='border: 1px solid black;'>" + emp + "</td><td style='border: 1px solid black;'>" + user_ct.get(emp) + "</td></tr>");
            }
        }
        out.println("<tr style='background-color:lightgrey;'><td>"+"GRAND TOTAL"+"</td><td>"+count+"</td></tr>");
        out.println("</table>");
    }
}
