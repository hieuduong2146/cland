<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
		<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="index.html"><h1><span>C</span>Land</h1></a>
					</div>
					<div class="clearfix search floatright">
						<form>
							<input type="text" placeholder="Search"/>
							<input type="submit" />
						</form>
					</div>
				</div>
				<div class="header_bottom">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath}/index">Trang chủ</a></li>
							<li id="dropdown"><a href="cat.html">Bất động sản</a>
									<ul>
								<c:choose>
									<c:when test="${not empty categories}">
									
										<c:forEach items="${categories}" var="cat">
											<li ><a href ="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(cat.cname)}-${cat.cid}">${cat.cname}</a></li>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<li> <a href = "#">Không có danh mục nào</a></li>
									</c:otherwise>
									
								</c:choose>
								
							</ul>
							</li>
							<li><a href="single.html">Giới thiệu</a></li>
							<li><a href="${pageContext.request.contextPath}/lien-he">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>
		
		