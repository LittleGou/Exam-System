<%@ page pageEncoding="UTF-8"%>

<div class="col-lg-4" >
	<div class="thumbnail" style="background-color:rgb(238,238,238); border-style:none;">
		<h5 style="font-weight:bold;">Select A Question Below:</h5>
		<div id="buttonBox"></div>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		var numberButton = "";
		var temp = "";
		for(var i = 1; i <= 60; i++){
			if(i < 10){
				numberButton = "0" + i;
			}else{
				numberButton = i;
			}
			//temp += "<button type='button' href='#' class='btn btn-default btn-sm' style='margin-right:5px; margin-top:5px;'>" + number + "</button>";
			temp += "<a href='${pageContext.request.contextPath}/servlet/TestServlet?action=test&paper=A&number="+i+"' class='btn btn-default btn-sm' role='button' aria-pressed autocomplete='off' style='margin-right:5px; margin-top:5px;'>" + numberButton + "</a>";
			if(i % 10 == 0){
				temp += "<br>";
			}
		}
		$('#buttonBox').html(temp);
	});
</script>