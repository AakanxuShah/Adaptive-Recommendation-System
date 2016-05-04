import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
import org.apache.lucene.analysis.standard.ClassicFilter;
import org.apache.lucene.analysis.standard.ClassicTokenizer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.codecs.TermStats;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.IOUtils;
import org.apache.lucene.util.Version;
import org.apache.lucene.util.packed.PackedInts.Reader;
//import org.apache.lucene.misc.HighFreqTerms;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.*;


/**
 * Lucene Demo: basic similarity based content indexing 
 * @author Sharonpova
 * Current sample files fragments of wikibooks and stackoverflow. 
 */

public class SimpleLuceneIndexing {
	
//	private static final String  = null;

	private static void indexDirectory(IndexWriter writer, File dir) throws IOException {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				indexDirectory(writer, f); // recurse
			} else if (f.getName().endsWith(".txt")) {
				// call indexFile to add the title of the txt file to your index (you can also index html)
				indexFile(writer, f);
			}
		}
	}
	private static void indexFile(IndexWriter writer, File f) throws IOException {
		System.out.println("Indexing " + f.getName());
		Document doc = new Document();
		doc.add(new TextField("filename", f.getName(), TextField.Store.YES));
		
		
		//open each file to index the content
		try{
			
				FileInputStream is = new FileInputStream(f);
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		        StringBuffer stringBuffer = new StringBuffer();
		        String line = null;
		        while((line = reader.readLine())!=null){
		          stringBuffer.append(line).append("\n");
		        }
		        reader.close();
				doc.add(new TextField("contents", stringBuffer.toString(), TextField.Store.YES));
	

		}catch (Exception e) {
            
			System.out.println("something wrong with indexing content of the files");
        }    
		
          
        
		writer.addDocument(doc);
		
	}	
	
	 public static String[] mainCall(int index,String path) throws IOException, ParseException {
		 
		 String answerArray[]=new String[10];
		 String type[]={"answer","question","answer accepted-answer","answer","question","question","answer","answer","answer","answer accepted-answer"};
		 String text[]=new String[10];
		 text[0]="One way to implement deep copy is to add copy constructors to each associated class. A copy constructor takes an instance of 'this' as its single argument and copies all the values from it. Quite some work, but pretty straightforward and safe. EDIT: note that you don't need to use accessor methods to read fields. You can access all fields directly because the source instance is always of the same type as the instance with the copy constructor. Obvious but might be overlooked. Example: Edit: Note that when using copy constructors you need to know the runtime type of the object you are copying. With the above approach you cannot easily copy a mixed list (you might be able to do it with some reflection code). ";
		 text[1]="I was presented with this question in an end of module open book exam today and found myself lost. i was reading Head first Javaand both definitions seemed to be exactly the same. i was just wondering what the MAIN difference was for my own piece of mind. i know there are a number of similar questions to this but, none i have seen which provide a definitive answer.Thanks, Darren";
		 text[2]="Inheritance is when a 'class' derives from an existing 'class'.So if you have a Person class, then you have a Student class that extends Person, Student inherits all the things that Person has.There are some details around the access modifiers you put on the fields/methods in Person, but that's the basic idea.For example, if you have a private field on Person, Student won't see it because its private, and private fields are not visible to subclasses.Polymorphism deals with how the program decides which methods it should use, depending on what type of thing it has.If you have a Person, which has a read method, and you have a Student which extends Person, which has its own implementation of read, which method gets called is determined for you by the runtime, depending if you have a Person or a Student.It gets a bit tricky, but if you do something likePerson p = new Student();p.read();the read method on Student gets called.Thats the polymorphism in action.You can do that assignment because a Student is a Person, but the runtime is smart enough to know that the actual type of p is Student.Note that details differ among languages.You can do inheritance in javascript for example, but its completely different than the way it works in Java.";
		 text[3]="Polymorphism: The ability to treat objects of different types in a similar manner.Example: Giraffe and Crocodile are both Animals, and animals can Move.If you have an instance of an Animal then you can call Move without knowing or caring what type of animal it is.Inheritance: This is one way of achieving both Polymorphism and code reuse at the same time.Other forms of polymorphism:There are other way of achieving polymorphism, such as interfaces, which provide only polymorphism but no code reuse (sometimes the code is quite different, such as Move for a Snake would be quite different from Move for a Dog, in which case an Interface would be the better polymorphic choice in this case.In other dynamic languages polymorphism can be achieved with Duck Typing, which is the classes don't even need to share the same base class or interface, they just need a method with the same name.Or even more dynamic like Javascript, you don't even need classes at all, just an object with the same method name can be used polymorphically.";
		 text[4]="I found out that the above piece of code is perfectly legal in Java. I have the following questions. ThanksAdded one more question regarding Abstract method classes.";
		 text[5]="In java it's a bit difficult to implement a deep object copy function. What steps you take to ensure the original object and the cloned one share no reference? ";
		 text[6]="You can make a deep copy serialization without creating some files. Copy: Restore:";
		 text[7]="Java has the ability to create classes at runtime. These classes are known as Synthetic Classes or Dynamic Proxies. See for more information. Other open-source libraries, such as and also allow you to generate synthetic classes, and are more powerful than the libraries provided with the JRE. Synthetic classes are used by AOP (Aspect Oriented Programming) libraries such as Spring AOP and AspectJ, as well as ORM libraries such as Hibernate. ";
		 text[8]="In short: the web server issues a unique identifier to on his visit. The visitor must bring back that ID for him to be recognised next time around. This identifier also allows the server to properly segregate objects owned by one session against that of another. If is: If is: Once he's on the service mode and on the groove, the servlet will work on the requests from all other clients.Why isn't it a good idea to have one instance per client? Think about this: Will you hire one pizza guy for every order that came? Do that and you'd be out of business in no time. It comes with a small risk though. Remember: this single guy holds all the order information in his pocket: so if you're not cautious about, he may end up giving the wrong order to a certain client.";
		 text[9]="A safe way is to serialize the object, then deserialize.This ensures everything is a brand new reference.about how to do this efficiently. Caveats: It's possible for classes to override serialization such that new instances are created, e.g. for singletons.Also this of course doesn't work if your classes aren't Serializable.";
		 
		String readPath =path+"crawled_text_files";
	
		File dataDir = new File(readPath); //my sample file folder path
		// Check whether the directory to be indexed exists
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(
					dataDir + " does not exist or is not a directory");
		}
		Directory indexDir = new RAMDirectory();
		
		// Specify the analyzer for tokenizing text.
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_48);
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_48,analyzer);
		IndexWriter writer = new IndexWriter(indexDir, config);
		
		
		indexDirectory(writer, dataDir);
		writer.close();
		 
		//Query string!  
		List<Keyword> temp=tokenStream(text[index]);
		String inputTemp="";
		for(int i=0;i<10;i++)
		{
			Keyword ky=temp.get(i);
			Set<String> tempTerms = new HashSet<String>();
			tempTerms=ky.getTerms();
			for(String s: tempTerms)
			{
				inputTemp = inputTemp+s+" ";
				System.out.println(s);
			}
		}
		
		String querystr = "contents:"+inputTemp;
		
		/*//This is going to be your selected posts.
		Scanner console = new Scanner(System.in);
		String querystr = "contents:"+console.nextLine();
		System.out.println(querystr);
		*/
		
		Query q = new QueryParser(Version.LUCENE_48, "contents", analyzer).parse(querystr);
		int hitsPerPage = 10;
		IndexReader reader = null;
		 
		 
		 
		 TopScoreDocCollector collector = null;
		 IndexSearcher searcher = null;
		 reader = DirectoryReader.open(indexDir);
		 searcher = new IndexSearcher(reader);
		 collector = TopScoreDocCollector.create(hitsPerPage,true);
		 searcher.search(q, collector);
		 
		 
		 
		 ScoreDoc[] hits = collector.topDocs().scoreDocs;
		 System.out.println("Found " + hits.length + " hits.");
		 System.out.println();
		 
		 for (int i = 0; i < hits.length; ++i) {
			 int docId = hits[i].doc;
			 Document d;
			 d = searcher.doc(docId);
			 answerArray[i]=d.get("filename");
			 System.out.println((i + 1) + ". " + d.get("filename"));
		 }
		 
		 reader.close();
		 return answerArray;
	 }
	 
	// Code Courtesy : http://stackoverflow.com/questions/17447045/java-library-for-keywords-extraction-from-input-text
	 public static List<Keyword> tokenStream(String input) throws IOException {
		 TokenStream tok = null;
		
		 input = input.replaceAll("-+", "-0");
		   
		    input = input.replaceAll("[\\p{Punct}&&[^'-]]+", " ");
		   
		    input = input.replaceAll("(?:'(?:[tdsm]|[vr]e|ll))+\\b", "");
		 	  
		 	  tok = new ClassicTokenizer(Version.LUCENE_48, new StringReader(input));
		       tok = new LowerCaseFilter(Version.LUCENE_48, tok);   
		       tok = new ClassicFilter(tok);
		       tok = new ASCIIFoldingFilter(tok);
		       tok = new StopFilter(Version.LUCENE_48, tok, EnglishAnalyzer.getDefaultStopSet());
		      
		       List<Keyword> keywords = new LinkedList<Keyword>();
		       CharTermAttribute token = tok.getAttribute(CharTermAttribute.class);
		       tok.reset();
		       while (tok.incrementToken()) {
		         String term = token.toString();
		        
		         String stem = stem(term);
		         if (stem != null) {
		           // create the keyword or get the existing one if any
		           Keyword keyword = find(keywords, new Keyword(stem.replaceAll("-0", "-")));
		           // add its corresponding initial token
		           keyword.add(term.replaceAll("-0", "-"));
		 
		         }
		       }
		
		       Collections.sort(keywords);
		       tok.close();
		       return keywords;
		       
		       
		     }
	 	
	 
	// Code Courtesy : http://stackoverflow.com/questions/17447045/java-library-for-keywords-extraction-from-input-text
	 public static String stem(String term) throws IOException {

		  TokenStream tokenStream = null;
		  try {

		    // tokenize
		    tokenStream = new ClassicTokenizer(Version.LUCENE_48, new StringReader(term));
		    // stem
		    tokenStream = new PorterStemFilter(tokenStream);

		    // add each token in a set, so that duplicates are removed
		    Set<String> stems = new HashSet<String>();
		    CharTermAttribute token = tokenStream.getAttribute(CharTermAttribute.class);
		   tokenStream.reset();
		    while (tokenStream.incrementToken()) {
		      stems.add(token.toString());
		    }

		    // if no stem or 2+ stems have been found, return null
		    if (stems.size() != 1) {
		      return null;
		    }
		    String stem = stems.iterator().next();
		    // if the stem has non-alphanumerical chars, return null
		    if (!stem.matches("[a-zA-Z0-9-]+")) {
		      return null;
		    }

		    return stem;

		  } finally {
		    if (tokenStream != null) {
		      tokenStream.close();
		    }
		  }

		}
	 
	 
	// Code Courtesy : http://stackoverflow.com/questions/17447045/java-library-for-keywords-extraction-from-input-text
	 public static <T> T find(Collection<T> collection, T example) {
		  for (T element : collection) {
		    if (element.equals(example)) {
		      return element;
		    }
		  }
		  collection.add(example);
		  return example;
		}
	 
 /* This function was tried but wasn't giving proper output
	 
	 public double calculateSimilarity(String oneContent, String otherContet) {
		 
		         Set<String> keyWords1 = keywordGenerator.generateKeyWords(oneContent);
		 
		         Set<String> keyWords2 = keywordGenerator.generateKeyWords(otherContet);
		 
		         Set<String> denominator = Sets.union(keyWords1,keyWords2);
		
		         Set<String> numerator = Sets.intersection(keyWords1,keyWords2);
		 
		  
		 
		         return denominator.size()>0? (double)numerator.size()/(double)denominator.size() : 0;
		 
		     }


	 
	 public void calculateSim(){
		 
		         SimilarityCalculator calculator = new JaccardIndexBasedSimilarity();
		 
		         Assert.assertEquals(calculator.calculateSimilarity("They Licked the platter clean","Jack Sprat could eat no fat"),0.0);
		 
		         //1(lamb) out of 6(littl,lamb,mari,had,go,sure) words are same
		 
		         Assert.assertEquals(calculator.calculateSimilarity("Mary had a little lamb", "The lamb was sure to go."), 0.16, 0.02);
		 
		         Assert.assertEquals(calculator.calculateSimilarity("Mary had a little lamb","Mary had a little lamb"),1.0);
		 
		     }
*/

}