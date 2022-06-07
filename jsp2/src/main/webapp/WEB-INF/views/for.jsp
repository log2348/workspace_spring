<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h1>For Example</h1>
	</header>
	<main>
		<b>1에서 10까지 합은 ?</b>
		<!-- JSP 태그 활용해서 1 + 2 + 3 + 4 + ... + 10 = 55-->
		<p>
			<%
			int sum = 0;

			for (int i = 1; i < 11; i++) {
				if (i < 10) {
			%>
				<%=(i + " + ")%> <!-- 화면에 출력되는 부분 -->
			<%
				} else {
					out.println(i + " = "); /* 화면에 출력되는 부분 */
				}
				sum += i;
			}
			%>
			<b><%=sum%></b> <!-- 화면에 출력되는 부분 -->
		</p>
	</main>

</body>
</html>