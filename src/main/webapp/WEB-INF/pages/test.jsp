<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctxstatic}/bootstrap3/css/bootstrap.css">
<script type="text/javascript" src="${ctxstatic}/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${ctxstatic}/bootstrap3/js/bootstrap.js"></script>
<style type="text/css">
	.commonborder{
		border:1px solid blue;
	}
	 .center-vertical{
        position: relative;
        top: 50%;
        transform: translateY(-50%);
    }
    .vcenter {
	    display: inline-block;
	    vertical-align: middle;
	    float: none;
	}
	.vtop{
		display:inline-block;
		vertical-align:top;
		float:none;
	}
</style>
</head>
<body>
	<h1 class="text-primary text-center">Boostrap组件测试</h1>
	<!-- 基本容器测试 -->
	<section class="container">
		<section class="row commonborder">
			<article class="col-lg-4 commonborder col-lg-offset-12">
				<header class="text-center"><b>今日头条</b></header>
				到底什么是今日的头条
				<footer>20180626</footer>
				<aside></aside>
			</article>
			<article class="col-lg-4 col-lg-offset-4 commonborder">
				<header class="text-center"><b>军事信息</b></header>
				<ul class="list list-unstyled">
					<li>美军驻军伊拉克</li>
					<li>中国驻美国大使馆抗议军事行动</li>
				</ul>
				<footer>20180627</footer>
			</article>
		</section>
	</section>
	<br/>
	<br/>
	<!-- 高级容器测试 -->
	<section class="container">
		<section class="row">
			<section class="col-lg-6 col-lg-offset-3 commonborder" >
				<div class="row" >
					<div class="col-lg-0 vcenter" style="height:15em"></div>
					<div class="col-lg-3 vcenter">
						<div style="height:4em" >
							<button class="btn btn-primary">前一页</button>
						</div>
					</div>
					<div class="col-lg-5 vtop">
						<ul class="list-unstyled">
							<li>美军驻军伊拉克</li>
							<li>中国驻美国大使馆抗议军事行动</li>
						</ul>
					</div>
					<div class="col-lg-3 vcenter">
						<!-- <div style="border:1px solid #F00">Small</div> -->
						<div style="height:4em" >
							<button class="btn btn-primary">后一页</button>
						</div>
					</div>
				</div>
			</section>
		</section>
	</section>
</body>
</html>