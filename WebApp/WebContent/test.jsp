<%@ page pageEncoding="UTF-8"%>

<div class="jumbotron-style">
	<div class="jumbotron" id="jumbo-test">
		<h3 class="jumbotron-title" style="margin-top:-20px;">Exam A</h3><br>
		
		<div class="row">
			<!-- Question -->
			<%@ include file="box_question.jsp" %>
			<!-- Button Box -->
			<%@ include file="box_button.jsp" %>
		</div>
		<br>
		<p id="buttons" style="margin-top:-20px;"></p>
				
	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#buttons").append("<a class = 'btn btn-primary btn-md' id='previous' href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&code=${sessionScope.question.code}&number=${sessionScope.question.number-1}' role='button' style='margin-right:150px'>Previous</a> &nbsp;");
		$("#buttons").append("<a class = 'btn btn-success btn-md' id='submit' href='#' role='button' style='margin-left:120px; padding:6px 22px;'>Submit</a> &nbsp;");
		$("#buttons").append("<a class = 'btn btn-primary btn-md' id='next' href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&code=${sessionScope.question.code}&number=${sessionScope.question.number+1}' role='button' style=' padding:6px 25px;'>Next</a> &nbsp;");
	});
	
	$(function(){
		var number = ${sessionScope.question.number};
		if(number == 1){
			$("#previous").attr('class', 'btn btn-primary btn-md disabled');
			//$("#previous").css('display', 'none');
		}else if (number == 60){
			$("#next").attr('class', 'btn btn-primary btn-md disabled'); 
		}else{
			$("#previous").attr('class', 'btn btn-primary btn-md');
			$("#next").attr('class', 'btn btn-primary btn-md');
			//$("#previous").css('display', 'visible');
		}
	});
</script>