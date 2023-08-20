<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.digit.javaTraining.bean.Plans,com.digit.hibernateServlet.Model.HibernateManager,com.digit.javaTraining.bean.PurchaseHistory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<link rel="stylesheet" type="text/css" href="sty.css">
</head>
<body>
	<div class="container">
		<h1>Book Purchase History</h1>
		<%
		
		ArrayList<PurchaseHistory> allPurchasesHistory = HibernateManager.getAllPurchasesHistory();
		%>
		<table>
			<tr>
				<th>Purchase ID</th>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Cost</th>
				<th>UserID</th>
				<th>Invoice</th>
				
				
			</tr>

			<%
			for (PurchaseHistory curSub : allPurchasesHistory) {
			%>
			<tr>
				<td><%=curSub.getPid()%></td>
				<td><%=curSub.getBook_id()%></td>
				<td><%=curSub.getBname()%></td>
				<td><%=curSub.getAmount()%></td>
				<td><%=curSub.getUser_id()%></td>
				<td><%=curSub.getInvoice()%></td>
			</tr>
			<%
			}
			%>
		</table>


		<br> <a href="adminHome.html">Go To Home</a>
	</div>
</body>
</html>