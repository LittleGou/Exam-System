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
		<p id="buttons" style="margin-top:-20px;">
			<a class= 'btn btn-primary btn-md' id='previous' href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&paper=${sessionScope.question.paper}&number=${sessionScope.question.number-1}' role='button' style='margin-right:150px'>Previous</a> &nbsp;
			<a class='btn btn-success btn-md' id='submit' href='#' role='button' style='margin-left:200px; padding:6px 22px;'>Submit</a> &nbsp;
			<a class= 'btn btn-primary btn-md' id='next' href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&paper=${sessionScope.question.paper}&number=${sessionScope.question.number+1}' role='button' style='margin-left:30px; padding:6px 25px;'>Next</a> &nbsp;
		</p>
		<span id="isCorrect"></span><br>
		<pre id="answers" style="display:none;">Answer:&nbsp;${sessionScope.question.answers}</pre>
		<pre id="comments" style="display:none;">Comment:<br>${sessionScope.question.comments}</pre>		
	</div>
</div>

<script type="text/javascript">
	/*Disable 'Previous' and 'Next' when Question Number is 1 or 60;*/
	$(function(){
		var num = ${sessionScope.question.number};
		if(num == 1){
			$("#previous").attr('class', 'btn btn-primary btn-md disabled');
			//$("#previous").css('display', 'none');
		}else if (num == 60){
			$("#next").attr('class', 'btn btn-primary btn-md disabled'); 
		}else{
			$("#previous").attr('class', 'btn btn-primary btn-md');
			$("#next").attr('class', 'btn btn-primary btn-md');
			//$("#previous").css('display', 'visible');
		}
	});
//------------------------------------------------------------------------------------------------------------------------------------	
	$("#submit").click(function(){
		if(quantity != numberChoice){
			alert("Make sure you choose " + quantity + " answer/s before submit");
		}else{
			if(confirm("Do you want to submit?")){
				var temp = "";
				$("input[name='selectBox']").each(function(k,v){
					if($(this).prop("checked")){
						temp += $(this).val();
					}
				});
				if(answers == temp){
					$("#isCorrect").html("Correct!").css("color", "green").css("font-weight", "bold").css("font-size", "medium");
				}else{
					$("#isCorrect").html("Wrong!").css("color", "red").css("font-weight", "bold").css("font-size", "medium");
				}
				$("#answers").css('display', 'block');
				$("#comments").css('display', 'block');
			}else{
				return false;
			}
		}
	});
//------------------------------------------------------------------------------------------------------------------------------------		

</script>