

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.lucene.queryparser.classic.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class serveletExample2
 */
@WebServlet("/serveletExample2")
public class serveletExample2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveletExample2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String initial = config.getInitParameter("initial");
        try {
        	crawlingJsoup.crawl("",getServletContext().getRealPath("/"));
        }
        catch (Exception e) {
        }
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		if(id==null)
			id="0";
		try {
		
			String output[]=SimpleLuceneIndexing.mainCall(Integer.parseInt(id),getServletContext().getRealPath("/"));
		
			BufferedReader br = null;
			String path=null;
			if(System.getProperty("os.name").toLowerCase().startsWith("windows"))
			{
				path=getServletContext().getRealPath("/")+"linkfiles\\";
			}
			else
			{
				path=getServletContext().getRealPath("/")+"linkfiles/";
			}
			
			for(int i=0;i<output.length;i++)
			{
				String temppath=null;
				temppath=path+output[i];
				br = new BufferedReader(new FileReader(temppath));
				String sCurrentLine="",finalOutput="";
				    sCurrentLine = br.readLine(); 
					finalOutput += sCurrentLine;
					br.close();
				String messageString="message"+i;
				
				request.setAttribute(messageString, "https://en.wikibooks.org"+finalOutput);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		int i=0;
	
	}

}
