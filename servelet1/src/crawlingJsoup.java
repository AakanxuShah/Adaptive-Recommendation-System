import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.lucene.queryparser.classic.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawlingJsoup {
	
	public static void crawl(String url, String path) throws IOException
	{
		Document doc = Jsoup.connect("https://en.wikibooks.org/wiki/Java_Programming").get();
		String title = doc.title();

		String html=doc.html();
		Document doc1 = Jsoup.parseBodyFragment(html);
		Elements ele=doc1.select("div#mw-content-text");
		Elements resultLinks = ele.select("li");
		Elements resulta = resultLinks.select("a");
		
		File file1 = new File(path+"htmlfiles");
		file1.mkdir();
		//getServletContext().getRealPath("/")
		File file2 = new File(path+"crawled_text_files");
		file2.mkdir();
		
		File file3 = new File(path+"linkfiles");
		file3.mkdir();
		
		int i=0;
		for(Element ulink : resulta)
		{
			i++;
			if(ulink.hasText() )
			{
				System.out.println(ulink);
				System.out.println(ulink.attr("href"));
				
				if(i>6)
				{	
				crawlText(ulink.attr("href"),ulink.text(),ele.html(),path);
				}
			}
		}
		}
		
		public static void crawlText(String url,String title,String html,String path) throws IOException
		{
			if(title.matches("Basic I/O"))
					title="Basic IO";
			Document doc2 = Jsoup.connect("https://en.wikibooks.org"+url).get();
			String html2=doc2.html();
			Document doc3 = Jsoup.parseBodyFragment(html2);
			Elements ele=doc2.select("div#mw-content-text");
			PrintWriter writer;
			PrintWriter writer1;
			PrintWriter writer2;
			
			if(System.getProperty("os.name").toLowerCase().startsWith("windows"))
			{
				writer = new PrintWriter(path+"crawled_text_files\\"+title+".txt", "UTF-8");
				writer1 = new PrintWriter(path+"htmlfiles\\"+title+".txt", "UTF-8");
				writer2 = new PrintWriter(path+"linkfiles\\"+title+".txt", "UTF-8");
			}
			
			else
			{
				writer = new PrintWriter(path+"crawled_text_files/"+title+".txt", "UTF-8");
				writer1 = new PrintWriter(path+"htmlfiles/"+title+".html", "UTF-8");
				writer2 = new PrintWriter(path+"linkfiles/"+title+".txt", "UTF-8");
			}
			
			writer.println(ele.text());
			writer1.println(html);
			writer2.println(url);
			writer.close();
			writer1.close();
			writer2.close();
		}	

}
