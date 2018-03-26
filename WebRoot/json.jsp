<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">

	// 发送json格式数据
	function requestJson(){
		$.ajax({
			type:'post',
			contentType:'application/json',
			url:'${pageContext.request.contextPath }/requestJson.action',
			data:'{"name":"苹果手机","price":"999"}',
			success:function(data){
				alert(data.name+"---"+data.price);
			}
		});
	}
	
	// 发送json格式数据
	function requestKV(){
		$.ajax({
			type:'post',
			// contentType:'application/json',
			url:'${pageContext.request.contextPath }/requestKV.action',
			data:'name=华为手机&price=888',
			success:function(data){
				alert(data.name+"---"+data.price);
			}
		});
	}

</script>
<title>json</title>
</head>
<body>
	<input type="button" value="发送json格式数据" onclick="requestJson();">
	<input type="button" value="发送KV格式数据" onclick="requestKV();">
</body>
</html>