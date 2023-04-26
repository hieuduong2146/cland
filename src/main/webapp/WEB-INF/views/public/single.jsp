<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
						
						<h1>${land.lname } </h1>
						<div class="clearfix post-meta">
							<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address} </span> <span><i class="fa fa-folder"></i> Diện tích: ${land.area }</span></p>
						</div>
						
						<div class="vnecontent">
							<p>${land.detail}</p>
						</div>
						<div class="more_themes">
							<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
							<div class="more_themes_container">
								<c:choose>
									<c:when test="${not empty lands }">
										<c:forEach items="${lands}" var= "lands">
											<div class="single_more_themes floatleft">
												<img src="${pageContext.request.contextPath}/files/${lands.picture}" alt=""/>
												<a href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(lands.lname)}-${lands.lid}.html"><h2>${lands.lname}</h2></a>
											</div>
										</c:forEach>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
								

							</div>
						</div>
						
					
				