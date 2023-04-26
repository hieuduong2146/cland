<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
						<div class="content_title"><h2>Bài viết mới</h2></div>
							<c:choose>
								<c:when test="${not empty lands}">
									<c:forEach items="${lands}" var="land">
										<div class="clearfix single_content">										
											<div class="clearfix post_date floatleft">
												<div class="date">
													<h3>
														<fmt:formatDate value="${land.date_create}" pattern="dd"/>													
													</h3>
													<p> Tháng<fmt:formatDate value="${land.date_create}" pattern="M"/></p>
												</div>
											</div>
											<div class="clearfix post_detail">
												<h2><a href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(land.lname)}-${land.lid}.html">${land.lname}</a></h2>
												<div class="clearfix post-meta">
													<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${land.area}</span></p>
												</div>
												<div class="clearfix post_excerpt">
													<img src="${pageContext.request.contextPath}/files/${land.picture}" alt=""/>
													<p>${land.description} </p>
												</div>
												<a href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(land.lname)}-${land.lid}.html">Đọc thêm</a>
											</div>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div>
										Không có tin tức nào
									</div>
								</c:otherwise>
							</c:choose>
							<div class="pagination">
						<nav>
							<ul>
								<c:choose>
									<c:when test="${page == 1}">
										<li><a href="#"> << </a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/index/?page=${page-1}"> << </a></li>	
									</c:otherwise>
								</c:choose>
								
								
								<c:forEach  begin="1" end="${numberOfpage}" step="1" varStatus="loop">
									<c:choose>
										<c:when test="${loop.count == page } ">
										
											<li><a class ="active" href="<li><a href="${pageContext.request.contextPath}/index/?page=${loop.count}"> << </a></li>">${loop.count}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href=" ${pageContext.request.contextPath}/index/?page=${loop.count}">${loop.count}</a></li>
										</c:otherwise>
									</c:choose>
									
								</c:forEach>
								
								<c:choose>
									<c:when test="${page == numberOfpage }">
										<li><a href="#"> >> </a></li>										
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath}/index/?page=${page + 1}"> >> </a></li>	
									</c:otherwise>
								</c:choose>
								
								
							</ul>
						</nav>
					</div>
						
						
									
				
					
					