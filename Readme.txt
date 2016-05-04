README

Name : Vaibhav Patel
ASU ID :1208649516
Phone : 480-646-2791

Main File to run : serveletExample2.java

Code Run Instructions : run serveletExample2.java using tomcat server(version used is 7). 

Main JSP File which is called automatically from servelet is index.jsp

External Jar Libraries used are : 
1) jsop-1.8.3.jar
2) lucene-analyzers-common-4.8.0.jar
3) lucene-core-4.8.0.jar
4) lucene-demo-4.8.0.jar
5) lucene-queryparser-4.8.0.jar

Java files and their functions
1) crawlingSoup.java - Used to crawl data from website given and 3 types of folders are created. Jsoup is used to crwal the data.
  - textfiles : which will store text files for every indexed page
  - linknames : which stores links to file names
  - htmlfiles : stores html code for files

2) Keyword.java - This is file containing third party code which is used in indexing files

3) SampleLuceneIndexing.java - This file contain indexing code which is combination of code provided by professor, third party code and self written code.

4) ServeletExample2.java - This file contains servelet code which acts as binding place to call all other java files and dynamically calling index.jsp page

5) index.jsp - This file uses foundation responsive framework to render collapsible panel functionality.


Error Handling
1) As crwaling is done on init() function of srvelet, if sometimes directory is not found than please restrat the server and run again.
 