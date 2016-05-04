<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <link rel="stylesheet" href="css/foundation.css" />
    <script src="js/vendor/modernizr.js"></script>
   
    
    <script language="javascript" type="text/javascript">
    
function select_value(obj){
	//alert(obj.value);
	if(obj.value == "1"){
		
		document.getElementById('query1').innerHTML = "One way to implement deep copy is to add copy constructors to each associated class. A copy constructor takes an instance of 'this' as its single argument and copies all the values from it. Quite some work, but pretty straightforward and safe. EDIT: note that you don't need to use accessor methods to read fields. You can access all fields directly because the source instance is always of the same type as the instance with the copy constructor. Obvious but might be overlooked. Example: Edit: Note that when using copy constructors you need to know the runtime type of the object you are copying. With the above approach you cannot easily copy a mixed list (you might be able to do it with some reflection code).";
	}else if(obj.value == "2"){
		
		document.getElementById('query1').innerHTML = "I was presented with this question in an end of module open book exam today and found myself lost. i was reading Head first Javaand both definitions seemed to be exactly the same. i was just wondering what the MAIN difference was for my own piece of mind. i know there are a number of similar questions to this but, none i have seen which provide a definitive answer.Thanks, Darren";	
	}else if(obj.value == "3"){
		
		document.getElementById('query1').innerHTML = "Inheritance is when a 'class' derives from an existing 'class'.So if you have a Person class, then you have a Student class that extends Person, Student inherits all the things that Person has.There are some details around the access modifiers you put on the fields/methods in Person, but that's the basic idea.For example, if you have a private field on Person, Student won't see it because its private, and private fields are not visible to subclasses.Polymorphism deals with how the program decides which methods it should use, depending on what type of thing it has.If you have a Person, which has a read method, and you have a Student which extends Person, which has its own implementation of read, which method gets called is determined for you by the runtime, depending if you have a Person or a Student.It gets a bit tricky, but if you do something likePerson p = new Student();p.read();the read method on Student gets called.Thats the polymorphism in action.You can do that assignment because a Student is a Person, but the runtime is smart enough to know that the actual type of p is Student.Note that details differ among languages.You can do inheritance in javascript for example, but its completely different than the way it works in Java.";
	}else if(obj.value == "4"){
		document.getElementById('query1').innerHTML = "Polymorphism: The ability to treat objects of different types in a similar manner.Example: Giraffe and Crocodile are both Animals, and animals can Move.If you have an instance of an Animal then you can call Move without knowing or caring what type of animal it is.Inheritance: This is one way of achieving both Polymorphism and code reuse at the same time.Other forms of polymorphism:There are other way of achieving polymorphism, such as interfaces, which provide only polymorphism but no code reuse (sometimes the code is quite different, such as Move for a Snake would be quite different from Move for a Dog, in which case an Interface would be the better polymorphic choice in this case.In other dynamic languages polymorphism can be achieved with Duck Typing, which is the classes don't even need to share the same base class or interface, they just need a method with the same name.Or even more dynamic like Javascript, you don't even need classes at all, just an object with the same method name can be used polymorphically.";
	}else if(obj.value == "5"){
		document.getElementById('query1').innerHTML = "I found out that the above piece of code is perfectly legal in Java. I have the following questions. ThanksAdded one more question regarding Abstract method classes.";
	}else if(obj.value == "6"){
		document.getElementById('query1').innerHTML = "In java it's a bit difficult to implement a deep object copy function. What steps you take to ensure the original object and the cloned one share no reference? ";
	}else if(obj.value == "7"){
		document.getElementById('query1').innerHTML = "You can make a deep copy serialization without creating some files. Copy: Restore:";
	}else if(obj.value == "8"){
		document.getElementById('query1').innerHTML = "Java has the ability to create classes at runtime. These classes are known as Synthetic Classes or Dynamic Proxies. See for more information. Other open-source libraries, such as and also allow you to generate synthetic classes, and are more powerful than the libraries provided with the JRE. Synthetic classes are used by AOP (Aspect Oriented Programming) libraries such as Spring AOP and AspectJ, as well as ORM libraries such as Hibernate. ";
	}else if(obj.value == "9"){
		document.getElementById('query1').innerHTML = "In short: the web server issues a unique identifier to on his visit. The visitor must bring back that ID for him to be recognised next time around. This identifier also allows the server to properly segregate objects owned by one session against that of another. If is: If is: Once he's on the service mode and on the groove, the servlet will work on the requests from all other clients.Why isn't it a good idea to have one instance per client? Think about this: Will you hire one pizza guy for every order that came? Do that and you'd be out of business in no time. It comes with a small risk though. Remember: this single guy holds all the order information in his pocket: so if you're not cautious about, he may end up giving the wrong order to a certain client.";
	}else if(obj.value == "10"){
		document.getElementById('query1').innerHTML = "A safe way is to serialize the object, then deserialize.This ensures everything is a brand new reference.about how to do this efficiently. Caveats: It's possible for classes to override serialization such that new instances are created, e.g. for singletons.Also this of course doesn't work if your classes aren't Serializable.";
	}else{}
	
	
}
</script>
</head>
<body>
<div style="height:250px">
<div style="align:center;text-align:center;background-color:yellow">
<form action="ServletPath" >
<input type="radio" name="text_display" value="1" onClick="select_value(this)" checked> Instance 1  <a href="http://localhost:8080/servelet1/serveletExample2?id=0">click here</a>
<input type="radio" name="text_display" value="2" onClick="select_value(this)"> Instance 2 <a href="http://localhost:8080/servelet1/serveletExample2?id=1">click here</a>
<input type="radio" name="text_display" value="3" onClick="select_value(this)"> Instance 3 <a href="http://localhost:8080/servelet1/serveletExample2?id=2">click here</a>
<input type="radio" name="text_display" value="4" onClick="select_value(this)"> Instance 4 <a href="http://localhost:8080/servelet1/serveletExample2?id=3">click here</a>
<input type="radio" name="text_display" value="5" onClick="select_value(this)"> Instance 5 <a href="http://localhost:8080/servelet1/serveletExample2?id=4">click here</a><br/>
<input type="radio" name="text_display" value="6" onClick="select_value(this)"> Instance 6 <a href="http://localhost:8080/servelet1/serveletExample2?id=5">click here</a>
<input type="radio" name="text_display" value="7" onClick="select_value(this)"> Instance 7 <a href="http://localhost:8080/servelet1/serveletExample2?id=6">click here</a>
<input type="radio" name="text_display" value="8" onClick="select_value(this)"> Instance 8 <a href="http://localhost:8080/servelet1/serveletExample2?id=7">click here</a>
<input type="radio" name="text_display" value="9" onClick="select_value(this)"> Instance 9 <a href="http://localhost:8080/servelet1/serveletExample2?id=8">click here</a>
<input type="radio" name="text_display" value="10" onClick="select_value(this)" > Instance 10 <a href="http://localhost:8080/servelet1/serveletExample2?id=9">click here</a><br>

</form>
</div>


<div style="align:center;text-align:center;background-color:cyan">
<p id="query1"></p>
<input type="submit" value="Get recommendations">
</div>
</div>
 <form action="ServletPath">
	<a href="http://localhost:8080/servelet1/serveletExample2?id=2">click here</a>
</form>
  <div class="row">
      <div class="large-12 columns">
        	<ul class="accordion" data-accordion>
  <li class="accordion-navigation">
    <a href="#panel1a">Accordion 1</a>
    <div id="panel1a" class="content active">
      <iframe src="${message1}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel2a">Accordion 2</a>
    <div id="panel2a" class="content">
     <iframe src="${message2}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel3a">Accordion 3</a>
    <div id="panel3a" class="content">
      <iframe src="${message3}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
    <li class="accordion-navigation">
    <a href="#panel4a">Accordion 4</a>
    <div id="panel4a" class="content active">
      <iframe src="${message4}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel5a">Accordion 5</a>
    <div id="panel5a" class="content">
     <iframe src="${message5}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel6a">Accordion 6</a>
    <div id="panel6a" class="content">
      <iframe src="${message6}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
    <li class="accordion-navigation">
    <a href="#panel7a">Accordion 7</a>
    <div id="panel7a" class="content active">
      <iframe src="${message7}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel8a">Accordion 8</a>
    <div id="panel8a" class="content">
      <iframe src="${message8}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel9a">Accordion 9</a>
    <div id="panel9a" class="content">
      <iframe src="${message9}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
  <li class="accordion-navigation">
    <a href="#panel10a">Accordion 10</a>
    <div id="panel10a" class="content">
      <iframe src="${message10}" style="height:200px;width:100%"></iframe>
    </div>
  </li>
</ul>
      </div>
    </div>
    <script src="js/vendor/jquery.js"></script>
    <script src="js/foundation.min.js"></script>
    <script>
      $(document).foundation();
    </script>
</body>
</html>