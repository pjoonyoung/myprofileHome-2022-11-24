<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Joonyoung Profile **</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/content.css">
</head>
<body>
<%@ include file="include/header.jsp" %>
	<center>
	<table width="75%" border="0" cellspacing="0" cellpadding="20">
		<tr>
			<td class="titlebox">
				<span class="title01">DEVELOPER JOONYOUNG PROFILE</span>
			</td>
		</tr>
		<tr>
			<td class="titlebox">
				<span class="title02">I'm joonyoung park, a developer who wants a development job. Please call me back</span>
			</td>
		</tr>
		<tr>
			<td>
				<center>
				<table width="80%" border="0" cellspacing="0" cellpadding="10">
					<tr class="contentbox">
						<td class="content">
							<br><br>
							<center>
							<table width="80%" border="1" cellspacing="0" cellpadding="10">
								<tr>
									<th calss="board_title01">NO</th>
									<th calss="board_title01">ID</th>
									<th calss="board_title01" width="50%">QUESTION</th>
									<th calss="board_title01">NAME</th>
									<th calss="board_title01">DATE</th>
								</tr>
								<tr>
									<td class="board_content">10</td>
									<td class="board_content">tiger</td>
									<td class="board_content">안녕하세요</td>
									<td class="board_content">홍길동</td>
									<td class="board_content">2022-11-25 02:34</td>
								</tr>
								<tr>
									<td class="board_content">20</td>
									<td class="board_content">tiger2</td>
									<td class="board_content">안녕하세요.안녕하세요.안녕하세요.</td>
									<td class="board_content">홍길동</td>
									<td class="board_content">2022-11-25 02:34</td>
								</tr>
								<tr>
									<td class="board_content">30</td>
									<td class="board_content">tiger3</td>
									<td class="board_content">안녕하세요.안녕하세요.</td>
									<td class="board_content">홍길동</td>
									<td class="board_content">2022-11-25 02:34</td>
								</tr>
								<tr>
									<td colspan="5" align="right">
										<input type="button" value="질문하기" class="button_type01" onclick="script:wondow.location='question'">
										
									</td>
								</tr>
							</table>
							</center>
							<br>
						</td>
					</tr>
					
				</table>
				</center>
			</td>
		</tr>
	</table>
	</center>
<%@ include file="include/footer.jsp" %>
</body>
</html>