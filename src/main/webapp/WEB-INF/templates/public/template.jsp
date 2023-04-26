<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/templates/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title>CLand | VinaEnter Edu</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--Oswald Font -->
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/publicUrl/css/tooltipster.css" />`
		<!-- home slider-->
		<link href="${pageContext.request.contextPath}/publicUrl/css/pgwslider.css" rel="stylesheet">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/publicUrl/css/font-awesome.min.css">
		<link href="${pageContext.request.contextPath}/publicUrl/style.css" rel="stylesheet" media="screen">	
		<link href="${pageContext.request.contextPath}/publicUrl/responsive.css" rel="stylesheet" media="screen">		
	</head>

	<body>
	
		<tiles:insertAttribute name="header"/>
		
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<div class="clearfix main_content floatleft">
				
					<div class="clearfix slider">
						<ul class="pgwSlider">
							<li><img src="${pageContext.request.contextPath}/publicUrl/images/thumbs/megamind_07.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars" data-large-src="${pageContext.request.contextPath}/publicUrl/images/slides/megamind_07.jpg"/></li>
							<li><img src="${pageContext.request.contextPath}/publicUrl/images/thumbs/wall-e.jpg" alt="Montréal, QC, Canada" data-large-src="${pageContext.request.contextPath}/publicUrl/images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars"/></li>
							<li>
								<img src="${pageContext.request.contextPath}/publicUrl/images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="${pageContext.request.contextPath}/publicUrl/images/slides/up-official-trailer-fake.jpg" data-description="Shanghai ,chaina">
							</li>


						</ul>
					</div>
					
					<div class="clearfix content">
						<tiles:insertAttribute name ="body"/>
					</div>
					
					
				</div>
					<tiles:insertAttribute name ="rightbar"/>
				</div>
			</div>
		</section>
		<tiles:insertAttribute name = "footer"/>
		
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.0.min.js"></script>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/publicUrl/js/jquery.tooltipster.min.js"></script>		
		<script type="text/javascript">
			$(document).ready(function() {
				$('.tooltip').tooltipster();
			});
		</script>
		 <script type="text/javascript" src="${pageContext.request.contextPath}/publicUrl/js/selectnav.min.js"></script>
		<script type="text/javascript">
			selectnav('nav', {
			  label: '-Navigation-',
			  nested: true,
			  indent: '-'
			});
		</script>		
		<script src="${pageContext.request.contextPath}/publicUrl/js/pgwslider.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.pgwSlider').pgwSlider({
					
					intervalDuration: 5000
				
				});
			});
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/publicUrl/js/placeholder_support_IE.js"></script>
	</body>
</html>

		
