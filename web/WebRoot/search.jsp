<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>servlet+ajax搜索框</title>
    <style type="text/css">
    	.mydiv{
    		position:absolute;
    		left:50%;
    		top:50%;
    		margin-left:-200px;
    		margin-top:-50px;
    		
    	}
    	.mouserOver{
    		background:#708090;
    		color:#FFFAFA;
    	}
    	.mouseOut{
    		background:#FFFAFA;
    		color:#000000;
    	}
    </style>
	<script type="text/javascript">
		/** 键盘按下键盘所触发的事件 获取关联信息 */
		function getMoreContents(){
			var xmlHttp;
			var content = document.getElementById("keyword");
			if(content.value == ""){
				/** 清空关联信息 */
				clearContent();
				return;
			}
			/** 发送ajax请求(原生js发送ajax需要XMLHttpRequest对象) */
			xmlHttp = createXmlHttp();
			
			var url= "servlet/SearchServlet?keyword="+content.value;
			/**  采用异步模式  */
			xmlHttp.open("GET", url,true);
			/** 绑定回调函数 处理响应结果  */
			/**
				0: 请求未初始化
				1: 服务器连接已建立
				2: 请求已接收
				3: 请求处理中
				4: 请求已完成，且响应已就绪
			*/
			xmlHttp.onreadystatechange=callback;
			/** 封装发送数据，针对是post请求的 */
			xmlHttp.send(null);
			
			/** 回调函数  */
			function callback(){
				/** 请求已完成 */
				if(xmlHttp.readyState == 4){
					/** 服务器响应成功 */
					if(xmlHttp.status == 200){
						/** 获取数据 */
						var result =  xmlHttp.responseText;
						/** 将Java json转换成js 的json */
						var json = eval("("+result+")");
						/** 把数据设置指定元素里 */
						setContent(json);
					}
				}
			}
		}
		
		/** 创建原生js XMLHttpRequest 对象 */
		function createXmlHttp(){
			var xmlHttp;
			/** 通用浏览器支持该对象 */
			if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest();
			}
			/** IE浏览器 */
			if(window.ActiveXObject){
				/** IE低版本创建XMLHTTP   */
				xmlHttp= new XMLHttpRequest("Mircosoft.XMLHTTP");
				/**  不支持这种类型就用下面这种类型处理  */
				if(!xmlHttp){
					/** IE高版本创建XMLHTTP   */
					xmlHttp = new XMLHttpRequest("Msxml2.XMLHTTP");
				}
			}
			return xmlHttp;
		}
		
		
		/** 设置展示数据 */
		function setContent(contents){
			/**清空关联数据  */
			clearContent();
			/** 展示关联信息显示的位置 */
			setLocation();
			
			var size = contents.length;
			for(var i=0;i<size;i++){
				/** 文本节点内容 */
				var contentNode = contents[i];
				/** 元素节点 */
				var tr = document.createElement("tr");
				var td = document.createElement("td");
				/** td样式 */
				td.setAttribute("border", "0");
				td.setAttribute("color","#FFFAFA");
				/** td追加事件 */
				td.onmouseover=function(){
					this.className="mouseOver";
				};
				td.onmouseout=function(){
					this.className="mouseOut";
				};
				td.onmousedown=function(){
					document.getElementById("keyword").value = this.innerHTML;
				};
				
				/** 文本节点 */
				var text = document.createTextNode(contentNode);
				td.appendChild(text);
				tr.appendChild(td);
				/** 将节点追加到要显示的元素标签中  */
				document.getElementById("content_table_body").appendChild(tr);
			}
		}
		
		/**清空关联信息 */
		function clearContent(){
			var contentTableBody = document.getElementById("content_table_body");
			var size = contentTableBody.childNodes.length;
			/** 从最后一个元素移除 */
			for(var i=size-1;i>=0;i--){
				contentTableBody.removeChild(contentTableBody.childNodes[i]);
			}
			/** 关联信息div没有数据会显示一个边框 */
			document.getElementById("popDiv").style.border = "none";
		}
		
		/** 关联信息显示位置 */
		function setLocation(){
			/** 获取搜索框的高度和宽度 */
			var content = document.getElementById("keyword");
			var width = content.offsetWidth;
			var left = content["offsetLeft"];
			var top = content["offsetTop"] + content.offsetHeight;
			var popDiv = document.getElementById("popDiv");
			popDiv.style.border = "black 1px soild";
			popDiv.style.left = left + "px";
			popDiv.style.top = top + "px";
			popDiv.style.width = width + "px";
			/** 表格与div同宽  */
			document.getElementById("content_table").style.width = width + "px";
		}
		
		/** 鼠标失去焦点清空关联数据 */
		function keywordBlur(){
			clearContent();
		}
	</script>
  </head>
  
  <body>
  	<div class="mydiv">
    	<input type="text" size="50" name="keyword" id="keyword" onkeyup="getMoreContents();"
    	 onblur="keywordBlur();" onfocus="getMoreContents();"/>
    	<input type="button" value="百度一下" width="50px;"/>
    	<div id="popDiv">
    		<table id="content_table" bgcolor="#FFFAFA;" border="0"
    			cellspacing="0" cellpadding="0">
    			<tbody id="content_table_body">
    				<!-- 需要展示内容 -->
    				<!-- 
    				<tr><td>111111</td></tr>
    				<tr><td>111111</td></tr>
    				-->
    			</tbody>
    		
    		</table>
    	</div>
  	</div>
  </body>
</html>
