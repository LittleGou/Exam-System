<%@ page pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<p id="buttons" style="margin-top:-20px;">
			<a class='btn btn-primary btn-md' id='previous' href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&paper=${sessionScope.question.paper}&number=${sessionScope.question.number-1}' role='button' style='margin-right:150px'>Previous</a> &nbsp;
			<a class='btn btn-success btn-md' id='submit' href='' role='button' style='margin-left:200px; padding:6px 22px;'>Submit</a> &nbsp;
			<a class='btn btn-primary btn-md' id='next' href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&paper=${sessionScope.question.paper}&number=${sessionScope.question.number+1}' role='button' style='margin-left:30px; padding:6px 25px;'>Next</a> &nbsp;
			<a class='btn btn-danger btn-md' id='restart' href='${pageContext.request.contextPath}/servlet/TestServlet?action=restart' role='button' style='margin-left:100px; padding:6px 25px;'>Restart</a>
		</p> 
		<span id="isCorrect"></span><br>
		<pre id="answers_comments" style="display:none;"><br><br><span style="font-weight:bold;">Comment:</span><br>${sessionScope.question.comments}</pre>
	</div>
</div>

<script type="text/javascript">
	/*Disable 'Previous' and 'Next' when Question Number is 1 or 60;*/
	$(function(){
		var num = ${sessionScope.question.number};
		if(num == 1){
			$("#previous").attr('class', 'btn btn-primary btn-md disabled');
		}else if (num == 60){
			$("#next").attr('class', 'btn btn-primary btn-md disabled'); 
		}else{
			$("#previous").attr('class', 'btn btn-primary btn-md');
			$("#next").attr('class', 'btn btn-primary btn-md');
		}
	});
//------------------------------------------------------------------------------------------------------------------------------------	
	$("#submit").click(function(){
		if(quantity != numberChoice){
			if(alert("Make sure you choose " + quantity + " answer/s before submit")){}else{return false};
			//$("#submit").attr('href','');
		}else{
			var temp = "";
			$("input[name='selectBox']").each(function(k,v){
				if($(this).prop("checked")){
					temp += $(this).val();
				}
			});
			$("#submit").attr('href', '${pageContext.request.contextPath}/servlet/TestServlet?action=submit&paper=${sessionScope.question.paper}&number=${sessionScope.question.number}&choices='+temp);

			if(confirm("Do you want to submit?")){}else{return false;}
		}
	});
	
	
//------------------------------------------------------------------------------------------------------------------------------------
	$("#restart").click(function(){
		if(confirm("Caution! Continue will restart the exam!")){}else{return false;}
	});
//------------------------------------------------------------------------------------------------------------------------------------	
	
	/* 
	Retrieve Information without Using AJAX/JSON
	*/
	//haha
	window.onload = function(){
		var mark = [];
		var correct = [];
		var color = [];
		<c:forEach var = 'mark' items='${sessionScope.markMap}'>
			var value = ${mark.value};	
			mark.push(value);
		</c:forEach>
		<c:forEach var = 'correct' items='${sessionScope.correctMap}'>
			var value = ${correct.value};
			correct.push(value);
		</c:forEach>
		<c:forEach var = 'color' items='${sessionScope.colorMap}'>
			var value = ${color.value};
			color.push(value);
		</c:forEach>
		
		var number = '${sessionScope.question.number}';
		//----------------------------------------------------------------
		if(color != null && color.length > 0){
			for (var i = 0; i < color.length; i++){
				var name = "#button"+(i+1);
				if(color[i] == 1){
					$(name).attr("class", "btn btn-success btn-sm");
				}else if (color[i] == 2){
					$(name).attr("class", "btn btn-danger btn-sm");
				}
			}
		}
		//----------------------------------------------------------------
		if(mark != null && mark.length > 0){
			//alert(name);
			if(mark[number-1] == 1){
				$("#submit").attr('class', 'btn btn-success btn-md disabled'); 
				$("#answers_comments").css('display', 'block');
				$("#answers_comments").prepend("<span style='font-weight:bold;'>Answers:&nbsp;</span>${sessionScope.question.answers}");
				if(correct[number-1] == 1){
					$("#isCorrect").html("Correct!").css("color", "green").css("font-weight", "bold").css("font-size", "medium");
				}else{
					$("#isCorrect").html("Wrong!").css("color", "red").css("font-weight", "bold").css("font-size", "medium");
				}
			}
		}
	};
</script>