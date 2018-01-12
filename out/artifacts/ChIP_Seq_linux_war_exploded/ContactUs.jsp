<%@ page import="java.net.URLEncoder" %>
<%@ page import="ChIP_Seq.TokenProcessor" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/14 0014
  Time: 下午 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <METE NAME="renderer" CONTENT="webkit|ie-comp|ie-stand"/>
  <META HTTP-EQUIV="pragma" CONTENT="no-cache"/>
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"/>
  <META HTTP-EQUIV="expires" CONTENT="0"/>
  <title></title>
  <link rel="stylesheet" href="./css/banner.css">
  <script src="./js/banner.js"></script>
  <script language="JavaScript">
    window.onload=function(){
      var obj=document.getElementById('choose_home');
      var login=<%=session.getAttribute("login")%>;
      if(login=='2'){
        obj.onclick = function () {
          window.location.href = "home.jsp";
        }
      }
      else{
        obj.onclick = function () {
          window.location.href = "home_initial.jsp";
        }
      }
      var obj=document.getElementById('choose_tool');
      obj.onclick=function(){
        window.location.href="Tools_initial.jsp";
      }
      var obj=document.getElementById('choose_meme');
      obj.onclick=function(){
        window.location.href="MEME.jsp";
      }
      var obj=document.getElementById('choose_work');
      obj.onclick=function(){
        window.location.href="WorkFlow.jsp";
      }
      var obj=document.getElementById('choose_help');
      obj.onclick=function(){
        window.location.href="ContactUs.jsp";
      }
      //1 是未登录
      if(login=='2'){
        document.getElementById("login_span").style.display="block";
      }
      else{
        document.getElementById("login_span").style.display="none";
      }

      if('${Session}'=='Y')
      {
        document.getElementById("login_spanUpdate").style.display="block";
      }
      else{
        document.getElementById("login_spanUpdate").style.display="none";
      }
    }
    function mousemove(div) {
      for (var i = 1; i <= 2; i++) {
        document.getElementById('box_top_'+i).style.backgroundColor='rgba(255,255,255,0)';
        document.getElementById('box_top_'+i).style.color='#666666';
        document.getElementById('box_down_'+i).style.display='none';
      }
      document.getElementById('box_top_'+div).style.backgroundColor='rgba(255,255,255,0.8)';
      document.getElementById('box_top_'+div).style.color='#666666';
      document.getElementById('box_down_'+div).style.display='block';
    }
    function mouseOver(){
      document.getElementById("login_menu").style.display="block";
    }
    function mouseOut(){
      document.getElementById("login_menu").style.display="none";
    }
    function recentShow(){
      window.location.href = "RecentJob.jsp";
    }
  </script>
  <style type="text/css">
    body{
      font-family: Arial;
    }
    #back{
      width:100%;
      height:100%;
      background-color:#ebeaea;
    }
    #banner{
      height:190px;
      background: url("./img/back3.png") no-repeat;
      background-size:cover;
      background-position:center;
      z-index:800;
    }
    #logo_span{
      width:236px;
      height:125px;
      float:left;
      margin-left:8%;
      margin-top:10px;
      background-image: url("./img/logo.png");
    }
    #list_choose{
      height:35px;
      margin-right:10%;
      padding-top: 55px;
      line-height: 35px;
      font-size:20px;
    }
    #choose_help{
      color:#fa7923;
      border-radius: 5px;
      background-color:rgba(255,255,255,0.9);
      text-shadow:1px 2px 3px #bdbcbb;
      width:95px;
      padding-left:12px;
      height:35px;
      float:right;
      font-weight: 300;
    }
    #choose_home{
      color:#ffffff;
      background:none;
      padding-left:10px;
      width:90px;
      height:35px;
      float:right;
      font-weight: 200;
    }
    #choose_home:hover{
      color:#fa7923;
      border-left:none;
      border-right:none;
      border-top:none;
      font-weight: 300;
    }
    #choose_work{
      color:#ffffff;
      background:none;
      padding-left:10px;
      width:120px;
      height:35px;
      float:right;
      font-weight: 200;
    }
    #choose_work:hover{
      color:#fa7923;
      border-left:none;
      border-right:none;
      border-top:none;
      font-weight: 300;
    }
    #choose_meme{
      color:#ffffff;
      background:none;
      padding-left:10px;
      width:200px;
      height:35px;
      float:right;
      font-weight: 200;
    }
    #choose_meme:hover{
      color:#fa7923;
      border-left:none;
      border-right:none;
      border-top:none;
      font-weight: 300;
    }
    #choose_tool{
      color:#ffffff;
      background:none;
      width:60px;
      padding-left:12px;
      height:35px;
      float:right;
      font-weight: 300;
    }
    #choose_tool:hover{
      color:#fa7923;
      border-left:none;
      border-right:none;
      border-top:none;
      border-radius: 5px;
      font-weight: 500;
    }
    #side_center{
      width:80%;
      height:70%;
      margin:0 auto;
      margin-top:-20px;
      box-shadow:5px 5px 20px #999999;
      -moz-box-shadow:5px 5px 20px #999999;
      -webkit-box-shadow:5px 5px 20px #999999;
      background-size: 100%;
      z-index:990;
      background-color: #ffffff;
    }
    #center_1,#center_3{
      font-size:25px;
      color:#fa7923;
      padding-top:25px;
      margin-left:40px;
      margin-bottom: 10px;
    }
    #center_2,#center_4{
      padding-top:10px;
      padding-left:10px;
      margin-left:40px;
      width:90%;
      border:1px dashed #cccccc;
      color:#666666;
    }
    #login_spanUpdate{
      width:110px;
      height:30px;
      text-align: center;
      line-height: 30px;
      top:20px;
      right:30px;
      color:#ffffff;
      position:absolute;
    }
    #login_spanUpdate:hover{
      width:110px;
      height:30px;
      top:20px;
      right:30px;
      text-align: center;
      line-height: 30px;
      border-radius: 5px;
      background-color:rgba(255,255,255,0.9);
      text-shadow:1px 2px 3px #bdbcbb;
      color:#fa7923;
      position:absolute;
      font-weight: 200;
    }
  </style>
</head>
<body>
<%
  //获取令牌类实例
  TokenProcessor processor = TokenProcessor.getInstance();
  //获取令牌值
  String token = processor.getToken(request);
%>
<input type="hidden" name="org.sunxin.token" value="<%=token%>"/>
<div id="back">
  <div id="banner">
    <div id="logo_span"></div>
    <input type="text" name="Session" style="display:none" value="<%=session.getAttribute("Session")%>">
    <div id="list_choose">
      <div  id="choose_help">About Us</div>
      <div  id="choose_meme">Downstream Analysis</div>
      <div  id="choose_tool">Tools</div>
      <div  id="choose_work">Work Flow</div>
      <div  id="choose_home">Home</div>
    </div>
    <div id="login_spanUpdate" style="display:none" onclick="recentShow();">Recent Jobs</div>
  </div>
  <div id="side_center">
    <div id="center_1">
      Contact Us
    </div>
    <div id="center_2">
      <span style="color:#fa7923">Address:</span>School of Information Science and Engineering，Central South University，Changsha,Hunan,China<br><br>
      <span style="color:#fa7923">Post:</span>410083<br><br>
      <span style="color:#fa7923">Phone:</span>+86-73188830212<br><br>
      <span style="color:#fa7923">Fax:</span>+86-73188830212<br><br>
      <span style="color:#fa7923">Contact:</span><br><br>
      <span style="color:#fa7923">Min Li:</span>limin@mail.csu.edu.cn<br><br>
      <span style="color:#fa7923">Li Tang: </span>tangli_csu@csu.edu.cn<br><br>
      <span style="color:#fa7923">Jianxin Wang: </span>jxwang@mail.csu.edu.cn<br><br>
    </div>
    <div id="center_3">
      Collaboration
    </div>
    <div id="center_4">
      After the analysis process, you can download the result files on the "Recent Jobs" page. For your uploaded data, we will keep it in the server for three days and it will be deleted after the limit time.<br><br>
    </div>
  </div>
</div>
</body>
</html>