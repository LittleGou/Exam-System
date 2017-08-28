<%@ page pageEncoding="UTF-8"%>
<!-- ---------------------------------------------------------------------------- -->
   	<nav class="navbar navbar-default">
  	<div class="box">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">OCJP</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/">Oracle Java Certificate<span class="sr-only">(current)</span></a></li>
        <li><a href="#">Random Test</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Exam Paper <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/exam.jsp">Exam A</a></li>
            <li><a href="#">Exam B</a></li>
            <li><a href="#">Exam C</a></li>
            <li><a href="#">Exam D</a></li>
            <li><a href="#">Exam E</a></li>
            
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Find An Exam">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Tim Gou's Play Ground &nbsp; (Login)</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Setting <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">##</a></li>
            <li><a href="#">##</a></li>
            <li><a href="#">##</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">##</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
    </div> <!-- .box -->
 
	</nav>	
