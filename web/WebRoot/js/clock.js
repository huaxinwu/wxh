/** 绘制图像的对象div */
var canvas = document.getElementById("clock");
/** 获取创建绘制图像全局对象,目前只支持2d (canvas这个对象不是上面那个，是浏览器自带的) */
var clock= canvas.getContext("2d");
/** 绘制时钟函数 */
function drawClock(){
	/** 清除画图 在给定的矩形内清除指定的像素 */
	clock.clearRect(0,0,800,800);
	/** 获取本地当前时间 */
	var now = new Date();
	/** 秒 */
	var secd = now.getSeconds();
	/** 分 */
	var minu = now.getMinutes();
	/** 时 */
	var hour = now.getHours();
	/**
	 * 小时必须获取浮点类型(小时+分数转化的小时)
	 * 时间格式19:23:30
	 * 将24小时进制装换为12小时进制
	 */
	hour = hour + (minu / 60);
	hour = hour > 12 ? hour - 12 : hour;
	/** 起始一条路径，或重置当前路径 */
	clock.beginPath();
	/** 设置或返回当前的线条宽度  */
	clock.lineWidth = 10;
	/** 设置或返回用于笔触的颜色、渐变或模式 */
	clock.strokeStyle = "blue";
	/** 创建弧/曲线（用于创建圆形或部分圆）顺时针 */
	clock.arc(250, 250, 200, 0, 360,false);
	/** 绘制已定义的路径   */
	clock.stroke();
	/** 创建从当前点回到起始点的路径 */
	clock.closePath();
	/** 绘制时钟刻度 --时针刻度 */
	for(var i = 0;i < 12;i++){
		/** 保存当前环境的状态 */
		clock.save();
		/** 设置时针的粗细 */
		clock.lineWidth = 7;
		/** 时针的颜色 */
		clock.strokeStyle = "#000";
		/**  重新映射画布上的 (0,0) 位置到指定位置 */
		clock.translate(250, 250);
		/** 旋转当前绘图 (角度*Math.PI/180=弧度) */
		clock.rotate((i*30)*Math.PI / 180);
		/** 起始一条路径，或重置当前路径 */
		clock.beginPath();
		/** 把路径移动到画布中的指定点，不创建线条 */
		clock.moveTo(0, -170);
		/** 添加一个新点，然后在画布中创建从该点到最后指定点的线条 */
		clock.lineTo(0, -190);
		/** 创建从当前点回到起始点的路径 */
		clock.closePath();
		/** 绘制已定义的路径   */
		clock.stroke();
		/**  返回之前保存过的路径状态和属性 */
		clock.restore();
	}
	/** 绘制时钟刻度 --分针刻度 */
	for(var i = 0;i < 60;i++){
		clock.save();
		clock.lineWidth = 3;
		clock.strokeStyle = "#000";
		clock.translate(250, 250);
		/** 角度转为弧度 360/60=6 */
		clock.rotate((i*6)*Math.PI / 180);
		clock.beginPath();
		clock.moveTo(0, -180);
		clock.lineTo(0, -190);
		clock.closePath();
		clock.stroke();
		clock.restore();
	}
	
	
	/** 绘制时间(3,6,9,12)*/ 
	clock.font = " bold 30px impack" 
    clock.fillText("3", 110, 10); 
    clock.fillText("6", -7, 120); 
    clock.fillText("9", -120, 10); 
    clock.fillText("12", -16, -100); 
    clock.stroke(); 
    clock.restore(); 
	
	/** 绘制时针 */
	clock.save();
	clock.lineWidth = 7;
	clock.strokeStyle = "black";
	clock.translate(250, 250);
	clock.rotate(hour * 30 * Math.PI / 180);
	clock.beginPath();
	clock.moveTo(0, -140);
	clock.lineTo(0, 10);
	clock.stroke();
	clock.closePath();
	clock.restore();
	
	/** 绘制分针 */
	clock.save();
	clock.lineWidth = 5;
	clock.strokeStyle = "green";
	clock.translate(250, 250);
	clock.rotate(minu * 6 * Math.PI / 180);
	clock.beginPath();
	clock.moveTo(0, -160);
	clock.lineTo(0, 10);
	clock.stroke();
	clock.closePath();
	clock.restore();
	
	/**  绘制秒针 */
	clock.save();
	clock.lineWidth = 3;
	clock.strokeStyle = "red";
	clock.translate(250, 250);
	clock.rotate(secd * 6 * Math.PI / 180);
	clock.beginPath();
	clock.moveTo(0, -170);
	clock.lineTo(0, 10);
	clock.closePath();
	clock.stroke();
	
	/** 指针 分针 秒针 交叉点绘制 */
	clock.beginPath();
	clock.arc(0, 0, 5, 0, 360,false);
	clock.closePath();
	/** 设置或返回用于填充绘画的颜色、渐变或模式  */
	clock.fillStyle = "gray";
	/** 填充当前绘图（路径）  */
	clock.fill();
	clock.stroke();
	clock.beginPath();
	clock.arc(0, -150, 5, 0, 360, false);
	clock.closePath();
	clock.fillStyle = "gray";
	clock.fill();
	clock.stroke();
	clock.restore();
}

/** js轮询函数让时钟动起来 每一秒就执行*/
drawClock();
setInterval(drawClock, 1000);