<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa tin tức </div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/land/edit/${land.lid}" method="post" enctype="multipart/form-data">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="lname">Tên tin tức </label>
											<input value = "${land.lname}" name="lname" type="text" class="form-control" placeholder="Nhập tên tin">
											<form:errors path="land.lname"></form:errors>
										</div>
										
										<div class="form-group">
											<label>Danh mục </label>
											<select name = "cid" class="form-control">
												<c:choose>
													<c:when test="${not empty categories }">
														<c:forEach items="${categories}" var="cat" >
														<c:choose>
															<c:when test="${cat.cid == land.category.cid}">
																<option selected="selected" value="${cat.cid }">${cat.cname }</option>
															</c:when>
															<c:otherwise>
																<option  value="${cat.cid }">${cat.cname }</option>
															</c:otherwise>
														</c:choose>
															
														</c:forEach>
													</c:when> 
													<c:otherwise>
														<option> Không có danh mục nào</option>
													</c:otherwise>
												</c:choose>
											   
											  
											</select>
										</div>

										<div class="form-group">
											<label>Thêm hình ảnh</label>
											<input name = "image" type="file" class="btn btn-default" id="exampleInputFile1">
											<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
											<img style="width:100px" alt="" src="${pageContext.request.contextPath}/files/${land.picture}"/>
										</div>
										<div class="form-group">
											<label for="name">Diện tích </label>
											<input value = "${land.area}" name="area" type="text" class="form-control" placeholder="Nhập diện tích">
											
										</div>
										<div class="form-group">
											<label for="address">Địa chỉ </label>
											<input  value = "${land.address}" name="address" type="text" class="form-control" placeholder="Nhập địa chỉ">
											<form:errors path="land.address"></form:errors>
											
										</div>
										<div class="form-group">
										   <label for ="description">Mô tả</label>
										   <textarea  id ="description" name = "description" class="form-control" rows="3">${land.description}</textarea>
										<form:errors path="land.description"></form:errors>
										</div>										
									</div>
									<div class="col-sm-6"></div>

									<div class="col-sm-12">
										<div class="form-group">
										   <label for="detail">Chi tiết</label>
										   <textarea name ="detail" class="form-control" rows="7">${land.detail}</textarea>
										   <form:errors path="land.detail"></form:errors>
										</div>
									</div>
								</div>

								<hr>

								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Sửa" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>
							</div>
							</form>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		 