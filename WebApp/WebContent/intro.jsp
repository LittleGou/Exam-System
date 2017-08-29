<%@ page pageEncoding="UTF-8"%>

<div class="jumbotron-style">
	<div class="jumbotron" id="jumbo-intro">
		<h2 class="jumbotron-title">Oracle Certified Java Programmer: 1Z0-851</h2><br>
		<p>Java SE 6 Programmer Certified Professional (1Z0-851):
		is for programmers experienced using the Java programming language. 
		Achieving this certification provides clear evidence that a programmer understands the basic syntax and structure of the Java programming language 
		and can create Java technology applications that run on server and desktop systems using J2SE 5.0.
		<br><br>To achieve this certification, candidates must successfully complete one exam. It is not necessary to be a Certified Java Associate prior to taking this exam.
		<br><br>Formerly Sun Certified Java Programmer (SCJP)
		<br><br><span>To better prepare your OCJP exam, try out one of the trial exams below now !</span>
		</p><br>
		
		<a class = "btn btn-primary btn-lg" href="${pageContext.request.contextPath}/servlet/TestServlet?action=test&paper=A&number=1" role="button">Exam A</a> &nbsp;
		<a class = "btn btn-success btn-lg" href="${pageContext.request.contextPath}/" role="button">Exam B</a> &nbsp;	
		<a class = "btn btn-info btn-lg" href="${pageContext.request.contextPath}/" role="button">Exam C</a> &nbsp;		
		<a class = "btn btn-warning btn-lg" href="${pageContext.request.contextPath}/" role="button">Exam D</a> &nbsp;		
		<a class = "btn btn-danger btn-lg" href="${pageContext.request.contextPath}/" role="button">Exam E</a> &nbsp;			
	</div>
</div>