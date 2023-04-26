<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
						
						<div class="contact_us">
						
							<h1>Liên hệ với chúng tôi</h1>
							
							<p>
							TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br />
							Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br />
							Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
							</p>
							<c:if test="${not empty msg }">
								<p>${msg}</p>
							</c:if>
							<p>
								
							</p>
							<form action = "${pageContext.request.contextPath }/lien-he" method="post" >
								<p><input name= "fullname" type="text" class="wpcf7-text" placeholder="Họ tên *"/></p>
								<form:errors path="contact.fullname"/>
								<p><input  name= "email" type="text" class="wpcf7-email" placeholder="Email *"/></p>
								<form:errors path="contact.email"/>
								<p><input  name= "subject" type="text" class="wpcf7-text" placeholder="Chủ đề *"/></p>
								<form:errors path="contact.subject"/>
								<p><textarea name = "content" class="wpcf7-textarea" placeholder="Nội dung *"></textarea></p>
								<form:errors path="contact.content"/>
								<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ"/></p>
							</form>
							
						</div>
						
					