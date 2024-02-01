import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Downloader1")
public class Downloader_HTML extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int day=Integer.parseInt(request.getParameter("day"));
		
		
		String url = "http://localhost:8080/WebPortal/Route1?numday="+day;
        try {
            // Create a URL object
            URL webpageUrl = new URL(url);
            
            // Open a connection to the URL
            Scanner scanner = new Scanner(webpageUrl.openStream());
            
            // Create a PrintWriter to write the HTML content to a file
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("webpage_content.txt")));
            
            // Write each line of the HTML content to the file
            while (scanner.hasNext()) {
                writer.println(scanner.nextLine());
            }
            
            // Close the writer and scanner
            writer.close();
            scanner.close();
            
            System.out.println("Webpage content has been saved to 'webpage_content1.txt'");
        } catch (IOException e) {
            System.out.println("Failed to download webpage content: " + e.getMessage());
        }
        finally{
        	request.getRequestDispatcher("home.jsp").forward(request, response);
        }
	}


}
