<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@page import="vn.edu.vinaenter.model.dao.LandDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
				<div class="clearfix sidebar_container floatright">
					<div class="clearfix sidebar">
						<div class="clearfix single_sidebar category_items">
							<h2>Danh mục bất động sản</h2>
							<ul>
								<c:choose>
									<c:when test="${not empty categories}">
									
										<c:forEach items="${categories}" var="cat">
											<li class=""><a href="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(cat.cname)}-${cat.cid}">${cat.cname}</a>(${LandDAO.countItemByCategoryID(cat.cid)})</li>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<li>Không có danh mục nào</li>
									</c:otherwise>
									
								</c:choose>
								
							</ul>
						</div>

						<div class="clearfix single_sidebar">
							<div class="popular_post">
								<div class="sidebar_title"><h2>Xem nhiều</h2></div>
								<ul>
									<li><a href="">Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. </a></li>
									<li><a href="">Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. </a></li>
									<li><a href="">Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. </a></li>
									<li><a href="">Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. </a></li>
									<li><a href="">Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. </a></li>
								</ul>
							</div>
							</div>
						
						<div class="clearfix single_sidebar">
							<h2>Danh mục hot</h2>
							<ul>
								<li><a href="">Category Name <span>(12)</span></a></li>
								<li><a href="">Category Name <span>(12)</span></a></li>
								<li><a href="">Category Name <span>(12)</span></a></li>
								<li><a href="">Category Name <span>(12)</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			