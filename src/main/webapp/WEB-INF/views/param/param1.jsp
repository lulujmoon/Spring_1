<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Param Test</h1>

	<form action="./param1" method="post">
		<p>
			p1<input type="text" name="p1">
		</p>

		<p>
			p2<input type="date" name="p2">
		</p>
		
		<p>
			p3<input type="color" name="p3">
		</p>
		<p>
			p4 <select name="p4">
					<option >KT</option>
					<option >SKT</option>
					<option >LG</option>
			
			</select>
			
		<p>
			kt <input type="radio" name="p5" value="kt">
			skt <input type="radio" name="p5" value="skt">
			lg <input type="radio" name="p5" "value="lg">
		</p>
		<p>
			kt <input type="checkbox" name="p6" value="kt">
			skt <input type="checkbox" name="p6" value="skt">
			lg <input type="checkbox" name="p6" value="lg">
		</p>
		<button>Submit</button>
	</form>

</body>
</html>