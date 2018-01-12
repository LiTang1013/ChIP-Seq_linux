<%@ page import="java.net.URLDecoder" %>
<<<<<<< HEAD
<%@ page import="ChIP_Seq.TokenProcessor" %>
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/13 0013
  Time: 下午 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <METE NAME="renderer" CONTENT="webkit|ie-comp|ie-stand"/>
  <META HTTP-EQUIV="pragma" CONTENT="no-cache"/>
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"/>
  <META HTTP-EQUIV="expires" CONTENT="0"/>
  <title></title>
  <link rel="stylesheet" href="./css/banner.css">
  <link rel="stylesheet" href="./layer/skin/layer.css">
  <link rel="stylesheet" href="./layer/skin/layer.ext.css">
  <link rel="stylesheet" href="./css/banner.css">
  <script src="./jquery-1.11.1/jquery.js"></script>
  <script src="./layer/layer.js"></script>
  <script src="./js/banner.js"></script>
  <script language="JavaScript">
    window.onload=function(){
      var obj=document.getElementById('choose_home');
      obj.onclick=function(){
        window.location.href="home.jsp";
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
      document.getElementById("login_user_pass").value="Please input your password";
      document.getElementById("login_user_pass").type="text";
      document.getElementById("register_pass").value="Please input your password";
      document.getElementById("register_pass").type="text";
      document.getElementById("register_pass_re").value="Please repeat your password";
      document.getElementById("register_pass_re").type="text";


      if('${Session}'=='Y')
      {
        document.getElementById("login_spanUpdate").style.display="block";
      }
      else{
        document.getElementById("login_spanUpdate").style.display="none";
      }
    }

    function clickPrompt(){
        layer.prompt(function(val, index){
        layer.close(index);
      });
    }
    var country_arr = new Array("Afghanistan", "Albania", "Algeria", "American Samoa", "Angola", "Anguilla", "Antartica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Ashmore and Cartier Island", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Clipperton Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czeck Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Europa Island", "Falkland Islands (Islas Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "French Southern and Antarctic Lands", "Gabon", "Gambia, The", "Gaza Strip", "Georgia", "Germany", "Ghana", "Gibraltar", "Glorioso Islands", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard Island and McDonald Islands", "Holy See (Vatican City)", "Honduras", "Hong Kong", "Howland Island", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Ireland, Northern", "Israel", "Italy", "Jamaica", "Jan Mayen", "Japan", "Jarvis Island", "Jersey", "Johnston Atoll", "Jordan", "Juan de Nova Island", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Man, Isle of", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Midway Islands", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcaim Islands", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romainia", "Russia", "Rwanda", "Saint Helena", "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Scotland", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and South Sandwich Islands", "Spain", "Spratly Islands", "Sri Lanka", "Sudan", "Suriname", "Svalbard", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Tobago", "Toga", "Tokelau", "Tonga", "Trinidad", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "Uruguay", "USA", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands", "Wales", "Wallis and Futuna", "West Bank", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe");
    function populateCountries(countryElementId) {
      // given the id of the <select> tag as function argument, it inserts <option> tags
      var countryElement = document.getElementById(countryElementId);
      countryElement.length = 0;
      countryElement.options[0] = new Option('Select Country', '-1');
      countryElement.selectedIndex = 0;
      for (var i = 0; i < country_arr.length; i++) {
        countryElement.options[countryElement.length] = new Option(country_arr[i], country_arr[i]);
      }

      // Assigned all countries. Now assign event listener for the states.

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
    #choose_home{
      color:#fa7923;
      border-radius: 5px;
      background-color:rgba(255,255,255,0.9);
      text-shadow:1px 2px 3px #bdbcbb;
      width:65px;
      padding-left:12px;
      height:35px;
      float:right;
      font-weight: 300;
    }
    #choose_help{
      color:#ffffff;
      background:none;
      padding-left:10px;
      width:90px;
      height:35px;
      float:right;
      font-weight: 200;
    }
    #choose_help:hover{
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
      height:73%;
      margin:0 auto;
      margin-top:-20px;
      box-shadow:5px 5px 20px #999999;
      -moz-box-shadow:5px 5px 20px #999999;
      -webkit-box-shadow:5px 5px 20px #999999;
      background-size: 100%;
      z-index:990;
      background-image: url("./img/login_back.png");
    }
    #box_top{
        padding-top:20px;
        width:24%;
        height:50px;
        float:right;
        margin-right:3%;
      }
    #box_top_1{
      width:100%;
      height:50px;
      text-align: center;
      line-height:50px;
      font-weight:500;
      font-size:20px;
      color:#666666;
      background-color: rgba(255,255,255,0.8);
    }
    #box_down_1{
      width:24%;
      height:250px;
      float:right;
      margin-top:70px;
      margin-right: -24%;
      background-color:rgba(255,255,255,0.8);
    }
    #attention{
      padding-top:10px;
      color:#555555;
      font-size: 14px;
      width:24%;
      height:60px;
      float:right;
      margin-top:330px;
      margin-right: -24%;
      background-color:rgba(255,255,255,0.8);
    }
    ul{
      padding-right:10px;
    }
    #box_back{
      width:100%;
      height:100%;
      top:0px;
      left:0px;
      position:fixed;
      background-color:rgba(0,0,0,0.5);
    }
    #box_down_2_wrapper{
      width:420px;
      height:360px;
      position:absolute;
      top:50%;
      left:50%;
      margin:-180px 0 0 -200px;
      background-color:rgba(255,255,255,0.8);
    }
    #box_down_2{
      width:400px;
      height:340px;
      position:absolute;
      top:50%;
      left:50%;
      margin:-170px 0 0 -200px;
      background-color:#ffffff;
    }
    .btn_submit,.btn_cancel{
      line-height: 20px;
      border-radius: 5px;border: 1px solid #F9A32D;
      color:#ffffff;
      background-color:#F9A32D;
      height:25px; width:60px;
      margin-left:80px;
      margin-top:15px;
      margin-bottom:10px;
    }

    #introduction{
      position:absolute;
      margin-top:20px;
      margin-left:2%;
      float:left;
      width:76%;
      height:67%;
      background-color: rgba(255,255,255,0.85);
    }
    #abstract{
      padding-top: 30px;
      padding-left: 30px;
      padding-right:30px;
      color:#555555;
      font-size:18px;
      text-align:justify;
    }
    #reference{
      padding-top: 10px;
      padding-left: 30px;
      padding-right:30px;
      color:#555555;
      font-size:14px;
      text-align:justify;
    }

  </style>
</head>
<body>
<<<<<<< HEAD
<%
  //获取令牌类实例
  TokenProcessor processor = TokenProcessor.getInstance();
  //获取令牌值
  String token = processor.getToken(request);
%>
<input type="hidden" name="org.sunxin.token" value="<%=token%>"/>
=======

>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
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
  </div>
  <div id="side_center">
    <div id="introduction" >
      <div id="abstract">
        <span style="color:#fa7923;font-size:28px">CSA</span> is developed for the whole process of ChIP-Seq analysis, which covers mapping (BWA[1], Bowtie, Bowtie2[2], SOAP[3], BLAST, Subread[4], NGM[5]), quality control (multiBamSummary[6]), peak calling (MACS[7], MACS2, PeakSeq[8], PeakRanger[9], SICER[10], FindPeaks[11], Fseq[12], AREM, BroadPeak, BCP, PePr[13], diffReps[14], SISSRs[15]), and downstream analysis (findMotifs, annotatePeaks, iPAGE[16]). In addition, CSA provides a customization function for users to define their own workflow. Moreover, the visualization of mapping, peak calling, motif finding, and pathway analysis results is also supplied in CSA.
        </div>
      <br>
      <br>
      <div id="reference">
        <span style="color:#666666;font-size:20px">Reference</span><br>
        [1]Li, H., & Durbin, R. (2010). Bioinformatics, 25(5), 1754-1760.<br>
        [2]Langmead, B., & Salzberg, S. L. (2012). Nature Methods, 9(4), 357.<br>
        [3]Li, R., Yu, C., et al. (2009). Bioinformatics, 25(15), 1966-1967.<br>
        [4]Liao, Y., Smyth, G. K., & Shi, W. (2013). Nucleic Acids Research, 41(10), 89-94.<br/>
        [5]Sedlazeck, F. J. (2013). Bioinformatics, 29(21), 2790-1.<br>
        [6]Ramírez, F., Dündar, F., Diehl, S., et al. (2014). Nucleic Acids Research, 42(W1), 187-91.<br>
        [7]Zhang, Y., Liu, T., et al. (2008). Genome Biology, 9(9), : R137.<br>
        [8]Rozowsky, J., Euskirchen, G., et al. (2009). Nature Biotechnology, 27(1), 66-75.<br>
        [9]Feng, X., Grossman, R., & Stein, L. (2011). BMC Bioinformatics, 12(1), 139.<br>
        [10]Xu, S., Grullon, S., Ge, K., & Peng, W. (2014). 1150, 97-111.<br>
        [11]Fejes, A. P., Robertson, G., Bilenky, M., et al (2008). Bioinformatics, 24(15), 1729.<br>
        [12]Boyle, A. P., Guinney, J., Crawford, G. E., & Furey, T. S. (2008). Bioinformatics, 24(21), 2537-2538.<br>
        [13]Zhang, Y., Lin, Y. H., Johnson, T. D., et al (2014). Bioinformatics, 30(18), 2568-2575.<br>
        [14]Shen, L., Shao, N. Y., Liu, X., Maze, I., Feng, J., & Nestler, E. J. (2012). Plos One, 8(6), e65598.<br>
        [15]Jothi, R., Cuddapah, S., Barski, A., Cui, K., & Zhao, K. (2008). Nucleic Acids Research, 36(16), 5221.<br>
        [16]Goodarzi, H., Elemento, O., & Tavazoie, S. (2009).  Molecular Cell, 36(5), 900-911.<br>
        <li style="color:#fa7923;margin-top:10px;" >Firefox and Chrome are recommended to get better interface display.</li>
      </div>
    </div>
    <%--<div id="box_top" >
      <div id="box_top_1">Login </div>
    </div>
    <div id="box_down_1" >
      <s:form action="login_user">
        <input type="text" name="login_user_name" id="login_user_name" value="Please input your account" style ="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:20px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please input your account'){value=''};" onblur="if(value==''){value='Please input your account';};">
        <input type="password" name="login_user_pass" id="login_user_pass" value="Please input your password" style="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:20px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please input your password'){value=''};document.getElementById('login_user_pass').type='password'" onblur="if(value==''){value='Please input your password';document.getElementById('login_user_pass').type='text'};">
        <s:fielderror fieldName="login_user_name" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;margin-bottom: -10px;font-size:16px;"  />
        <s:fielderror fieldName="login_user_pass" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;margin-bottom: -10px;font-size:16px;"  />
        <s:fielderror fieldName="login_user" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;margin-bottom: -10px;font-size:14px;"  />
        <s:submit value="Login" cssStyle= "margin-top:20px;width:80%; height:28px; border: 0px ; margin-left:30px;background:#F9A32D;color: #ffffff; border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;border-top-left-radius: 10px;border-top-right-radius: 10px;" >
        </s:submit>
      </s:form>
      <div id="register_tag">
        <input type="button" value="Register" id="register_button" onclick="document.getElementById('box_back').style.display='block';populateCountries('country2');"/>
      </div>
    </div>

    <div id="attention">
      <ul>
        <li style="color:#fa7923">Firefox and Chrome are recommended to get better interface display.</li>
      </ul>
    </div>--%>

    </div>
<<<<<<< HEAD
=======
  <div id="box_back" style="display:none">
    <div id="box_down_2_wrapper">
    <div id="box_down_2">
      <form action="register"  method="post">
        <input type="text" name="register_account" id="register_account" value="Please input your account" style ="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:20px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please input your account'){value=''}" onblur="if(value==''){value='Please input your account'};">
        <input type="password" id="register_pass" name="register_pass" value="Please input your password" style="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:10px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please input your password'){value=''};document.getElementById('register_pass').type='password'" onblur="if(value==''){value='Please input your password';document.getElementById('register_pass').type='text'};">
        <input type="password" id="register_pass_re" name="register_pass_re" value="Please repeat your password" style="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:10px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please repeat your password'){value=''};document.getElementById('register_pass_re').type='password'" onblur="if(value==''){value='Please repeat your password';document.getElementById('register_pass_re').type='text'};">
        <input type="text" id="register_email" name="register_email" value="Please input your email address" style="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:10px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please input your email address'){value=''};" onblur="if(value==''){value='Please input your email address'}"><br>
        <select id="country2" name="country2" style="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:10px;border-radius: 10px;border:1px solid #999999;color:#999999;" ></select><br/>
        <input type="text" id="register_comp" name="register_comp"  value="Please input your organization" style="width:80%;height:28px;padding-left:10px;margin-left:30px;margin-top:10px;border-radius: 10px;border:1px solid #999999;color:#999999;" onclick="if(value=='Please input your organization'){value=''};" onblur="if(value==''){value='Please input your organization'}">
        <s:fielderror fieldName="register_user" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;margin-bottom: -15px;font-size:14px;"  />
        <s:fielderror fieldName="register_pass_re" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;margin-bottom: -15px;font-size:14px;"  />
        <s:fielderror fieldName="register_email" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;margin-bottom: -15px;font-size: 14px;"  />
        <input type="submit" value="Register" class="btn_submit" onclick="document.getElementById('box_back').style.display='none';"/>
        <input type="button" value="Cancel"  class="btn_cancel" onclick="document.getElementById('box_back').style.display='none';" />
      </form>
    </div>
      </div>
  </div>
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c

</div>
</body>
</html>