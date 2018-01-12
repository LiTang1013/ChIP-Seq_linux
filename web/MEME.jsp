<%@ page import="java.net.URLEncoder" %>
<%@ page import="ChIP_Seq.TokenProcessor" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/9 0009
  Time: 上午 8:56
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
    <link rel="stylesheet" href="./layer/skin/layer.css">
    <link rel="stylesheet" href="./layer/skin/layer.ext.css">
    <link rel="stylesheet" href="./css/MEME.css">
    <script src="./js/banner.js"></script>
    <script src="./jquery-1.11.1/jquery.js"></script>
    <script src="./layer/layer.js"></script>
    <script src="./js/MEME.js"></script>
  <script language="javascript">
      function fileChange(target,box){
          var filename;
          filename=target.files[0].name;
          var fileSize;
          var filemaxsize = 2048*1024;//1G
          fileSize = target.files[0].size;
          var size = fileSize / 1024;
          if(size>filemaxsize){
              alert("Upload files can not be larger than 2G!");
              document.getElementById(box).value="";
              target.value ="";
              return false;
          }
          if(size<=0){
              alert("Upload files can not be empty!");
              target.value ="";
              return false;
          }
          else{
              document.getElementById(box).value=filename;
              return true;
          }
      }
      function ValidateChar(s) {
          var valid=false;
          var pattern = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&", "{", "}", "[", "]", "(", ")",";","\"", "'", "|", "\\", "<", ">", "?", "/", "<<", ">>","+");
          for (var i = 0; i < pattern.length; i++){
              if (s.indexOf(pattern[i]) >= 0){
                  valid=true;
                  break;
              }
              else{
                  valid=false;
              }
          }
          if(valid){
              return true;
          }
          else{
              return false;
          }
      }

      function searchData(id,btnbox,waitbox) {
          var flag = "valid";
      //    var pattern = new RegExp("[<>\"`~!@#$^&*()=|{}';'\\[\\]<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]") ;
          var frm = document.getElementById(id).getElementsByTagName("input");
          for (var i = 0; i < frm.length; i++) {
              if (frm[i].type == "text") {
                  if(frm[i].value=="" || frm[i].value==null){
                      flag="empty";
                      break;
                  }
                  else{
                      if (ValidateChar(frm[i].value)) {
                          flag = "invalid";
                          break;
                      }
                      else{
                          flag="valid";
                      }
                  }
              }
          }
              if (flag=="invalid") {
                  alert("The input contains invalid character,please input again!");
                  return false;
              }
              else if(flag=="empty"){
                  alert("The input cannot be empty!");
                  return false;
              }
              else {
                  document.getElementById(btnbox).style.backgroundColor = '#666666';
                  document.getElementById(waitbox).style.display = 'block';
                  return true;
              }
          }

      function checkFileExt(filename,box) {
          var flag=null; //状态
          var arr = ["bed","BED"];
          //取出上传文件的扩展名
          var index = filename.lastIndexOf(".");
          var ext = filename.substr(index+1);
          //循环比较
          if(document.getElementById(box).value=="" || document.getElementById(box).value==null){
              flag="empty";
          }
          else{
              for(var i=0;i<arr.length;i++) {
                  if(ext == arr[i])
                  {
                      flag = "valid"; //一旦找到合适的，立即退出循环
                      break;
                  }
                  else{
                      flag="invalid";
                  }
              }
          }

          //条件判断
          if(flag=="valid")
          {
              return true;
          }
          else if(flag=="empty"){
              alert("The input cannot be empty!");
              document.getElementById(box).value="";
              return false;
          }
          else{
              alert("The file uploaded should be in .bed");
              document.getElementById(box).value="";
              return false;
          }
      }

  window.onload=function(){
      var obj1 = document.getElementById('choose_home');
      var obj2 = document.getElementById('choose_tool');
      var obj3 = document.getElementById('choose_meme');
      var obj4 = document.getElementById('choose_work');
      var obj5 = document.getElementById('choose_help');
      var msg = "If you leave this page, the operation will be stopped!";
      var x = document.getElementsByClassName("Upload_wait_div");
      var signal="true";
      obj1.onclick = function (){
          for (var i = 0; i < x.length; i++){
              if (x[i].style.display == 'block'){
                  if (confirm(msg)) {
                      signal="true";
                  }
                  else {
                      signal="false";
                      break;
                  }
              }
          }
          if(signal=="true"){
              window.location.href = "home_initial.jsp";
          }
          else{
          }
      }

      obj2.onclick = function () {
          for (var i = 0; i < x.length; i++){
              if (x[i].style.display == 'block'){
                  if (confirm(msg)) {
                      signal="true";
                  }
                  else {
                      signal="false";
                      break;
                  }
              }
          }
          if(signal=="true"){
              window.location.href = "Tools_initial.jsp";
          }
          else{
          }
      }

      obj3.onclick = function () {
          for (var i = 0; i < x.length; i++){
              if (x[i].style.display == 'block'){
                  if (confirm(msg)) {
                      signal="true";
                  }
                  else {
                      signal="false";
                      break;
                  }
              }
          }
          if(signal=="true"){
              window.location.href = "MEME.jsp";
          }
          else{
          }
      }

      obj4.onclick = function () {
          for (var i = 0; i < x.length; i++){
              if (x[i].style.display == 'block'){
                  if (confirm(msg)) {
                      signal="true";
                  }
                  else {
                      signal="false";
                      break;
                  }
              }
          }
          if(signal=="true"){
              window.location.href = "WorkFlow.jsp";
          }
          else{
          }
      }

      obj5.onclick=function() {
          for (var i = 0; i < x.length; i++){
              if (x[i].style.display == 'block'){
                  if (confirm(msg)) {
                      signal="true";
                  }
                  else {
                      signal="false";
                      break;
                  }
              }
          }
          if(signal=="true"){
              window.location.href = "ContactUs.jsp";
          }
          else{
          }
      }

      if("${flag}"=="1"||"${flag}"=="2"||"${flag}"=="3"){
          for(var i=1;i<=3;i++){
          document.getElementById("side_right_"+i).style.display="none";

      }
          for(var g=1;g<=6;g++){
              document.getElementById("detail_text_"+i).style.display="none";
          }
      for(var j=1;j<=3;j++){
          document.getElementById("side_son_"+j).style.backgroundColor="#dadada";
          document.getElementById("side_son_"+j).style.color="#555555";
      }
          document.getElementById("side_son_"+"${flag}").style.backgroundColor="#fa7923";
          document.getElementById("side_son_"+"${flag}").style.color="#ffffff";
          document.getElementById("side_right_"+"${flag}").style.display="block";
          var h=${flag}+3;
          document.getElementById("detail_text_"+h).style.display="block";
      }


      var id_validate=parseInt('${flag_validate}');
      if(id_validate==2){
          for(var i=1;i<=6;i++){
              document.getElementById("detail_text_"+i).style.display="none";
          }
      }

      if('${Session}'=='Y')
      {
          document.getElementById("login_spanUpdate").style.display="block";
      }
      else{
          document.getElementById("login_spanUpdate").style.display="none";
      }
  }

  function side_right_show(divId){
      for(var i=1;i<=3;i++){
          document.getElementById("side_right_"+i).style.display="none";
          document.getElementById("side_son_"+i).style.backgroundColor="#dadada";
          document.getElementById("side_son_"+i).style.color="#555555";
          document.getElementById("Demo_btn"+i).style.display="none";
      }
      document.getElementById("side_son_"+divId).style.backgroundColor="#fa7923";
      document.getElementById("side_son_"+divId).style.color="#ffffff";
      document.getElementById("side_right_"+divId).style.display="block";
      document.getElementById("Demo_btn"+divId).style.display="block";
  }
      function recentShow(){
          window.location.href = "RecentJob.jsp";
      }
  var count=1;
  function Tip_click(TipId) {
      var id = "#tip" + TipId;
      if (TipId == 1) {
          if(count==1){
              layer.tips('If you are not sure what the size is,you can input the default size:200', id, {
                  tips: [1, '#fa7923'],time:10000
              });
              count++;
          }
        else{
              layer.close(layer.index);
              count--;
          }
      }
      else {
          if(count==1){
              layer.tips('The output file will be sent to this e-mail address.', id, {
                  tips: [1, '#fa7923'],time:10000
              });
              count++;
          }
         else{
              layer.close(layer.index);
              count--;
          }
      }
  }
    </script>
    <style type="text/css">
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
  <div id="left_side">
    <div class="side_radio"></div>
    <div class="side_top"><h2>Downstream analysis</h2></div>
    <div class="side_parent">
        <div class="arrow1" id="arrow1" style="display: block"></div>
        <div class="arrow2" id="arrow2" style="display:none"></div>
        Motif Discovery</div>
    <div class="side_son" id="side_son_1" style="background-color: #fa7923;color:#ffffff" onclick="JavaScript:side_right_show(1)">findMotifs</div>
    <div class="side_parent">
        <div class="arrow1" id="arrow3" style="display: block"></div>
        <div class="arrow2" id="arrow4" style="display:none"></div>
        Gene ontology analysis</div>
    <div class="side_son" id="side_son_2" onclick="JavaScript:side_right_show(2)">annotatePeaks</div>
    <div class="side_parent">
        <div class="arrow1" id="arrow5" style="display: block"></div>
        <div class="arrow2" id="arrow6" style="display:none"></div>
        Pathway analysis</div>
      <div class="side_son" id="side_son_3" onclick="JavaScript:side_right_show(3)">iPAGE</div>
      <div id="demo_describe">
          <span style="font-size: 18px ;color:#ffffff">Demo dataset:</span>  <br>
          <input type="button" id="Demo_btn1" class="Demo_btn" value="Use demo dataset" style="display:block;"onclick="window.location.reload();"/>
          <input type="button" id="Demo_btn2" class="Demo_btn" value="Use demo dataset" style="display:none;"onclick="window.location.reload();"/>
          <input type="button" id="Demo_btn3" class="Demo_btn" value="Use demo dataset" style="display:none;"onclick="window.location.reload();"/>(Click here to fill the input.)<br>
          <span style="font-size:16px;color:#ffffff">ChIP-Seq peak file:</span>H3K4me3.bed<br>
          <span style="font-size:16px;color:#ffffff">The above demo dataset is from:</span><br>Rhie S K, Hazelett D J, Coetzee S G, et al. Nucleosome positioning and histone modifications define relationships between regulatory elements and nearby gene expression in breast epithelial cells[J]. BMC Genomics, 2014, 15(1):45-58.<br>
      </div>
  </div>
    <div id="side_right">
        <!--------------------------------HOMER-------------------------------------------------------->
      <div class="side_right" id="side_right_1" style="display:block;">
          <div id="attention1" class="blackdown_tips_1">
          The input of Demo workflow has been filled on this page. Please click the "Execute" to run the demo.
          <br>
      </div>
        <div class="link" onclick="JavaScript:nece_opt_show_HOMER_ne();"style="cursor:hand;">
          <div class="arrow-down" id="arrow-down1" style="display:block"></div>
          <div class="arrow-right" id="arrow-right1" style="display:none"></div>
          Necessary parameter</div>
        <form action="HOMER_exe" id="HOMER_exe" enctype="multipart/form-data" method="post" onsubmit="return searchData('HOMER_exe','btn_HOMER','wait_HOMER');">
        <div class="necessary_center" id="necessary_center_HOMER" style="display:block">
            <div class="blacktop_1">
                Input HOMER peak file/BED file
                <s:fielderror fieldName="input_HOMER_peak" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
            </div>
            <div class="blackdown_1">
                <div class="file-box" >
                    <input type="text" name="input_HOMER_peak"  class="input_text"  value="H3K4me3.bed" id="input_HOMER_peak" />
                    <input type='button' class='btn' value='Choose File' />
                    <input type="file" name="fileField_HOMER" class="fileField" id="fileField_HOMER_peak" onchange="return (fileChange(this,'input_HOMER_peak' )&& checkFileExt(this.value,'input_HOMER_peak'))" />
                </div>
            </div>
            <div class="blacktop_1">
                Select the appropriate genome or input FASTA file
                <s:fielderror fieldName="input_HOMER_fasta" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
            </div>
            <div class="blackdown_2">
                <input type="radio" name="HOMER_select" value="1" checked="true" onclick="document.getElementById('HOMER_genome').style.display='block';document.getElementById('HOMER_fasta').style.display='none';"/>Select the appropriate genome
                <input type="radio" name="HOMER_select" value="2" onclick="document.getElementById('HOMER_genome').style.display='none';document.getElementById('HOMER_fasta').style.display='block';"/>Input FASTA file<br>
                <select name="HOMER_genome" id="HOMER_genome" class="GOMo_select" style="display:block">
                    <option value="1" selected="selected">Human(hg19)</option>
                    <option value="2">Mouse(mm8)</option>
                    <option value="3">Yeast(sacCer3)</option>
                </select>
                <div class="blackdown_1" id="HOMER_fasta" style="display:none">
                    <div class="file-box" >
                        <input type="text" name="input_HOMER_fasta"  class="input_text" value="Human" id="input_HOMER_fasta" />
                        <input type='button' class='btn' value='Choose File' />
                        <input type="file" name="fileField_HOMER" class="fileField" id="fileField_HOMER_fasta" onchange="return( fileChange(this,'input_HOMER_fasta') && checkFileExt(this.value,'input_HOMER_fasta'))" />
                    </div>
                </div>
    </div>
            <div class="blacktop_1">
                Input the size of the region for motif finding
                <div class="tip_out"><img class="tip" id="tip1" src="./img/tip.png" onclick="JavaScript:Tip_click(1)"></div>
                <s:fielderror fieldName="input_HOMER_size" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
            </div>
            <div class="blackdown_1">
                <div class="file-box" >
                    <input type="text" name="input_HOMER_size" value="400" class="input_text" id="input_HOMER_size"/>
                </div>
            </div>
          </div>
        <div class="link" onclick="JavaScript:nece_opt_show_HOMER_op();" style="cursor:hand;">
          <div class="arrow-down" id="arrow-down2" style="display:block"></div>
          <div class="arrow-right" id="arrow-right2" style="display:none"></div>
          Optional parameter</div>
        <div class="optional_center" id="optional_center_HOMER" style="display:block">
          <div class="blacktop_1">Optional parameter</div>
          <div class="blackdown_1">
            <input type="radio" name="HOMER_option"  id="HOMER_option_default" value="1" checked="true" onclick="document.getElementById('HOMER_option_input_setting').style.display='none';document.getElementById('HOMER_radio').style.visibility='hidden'";/>default
            <input type="radio" name="HOMER_option"  id="HOMER_option_setting" value="2"  onclick="document.getElementById('HOMER_option_input_setting').style.display='block'";/>set the parameters by yourself
            <div id="HOMER_radio" class="radio_text"></div>
            </div>
          <div class="inputOption_setting" id="HOMER_option_input_setting" style="display:none;">
            <div class="inputOption_setting_center"  style="overflow-y:scroll;">
                mask repeats/lower case sequence<br>
                <h6>-mask;defualt:off</h6>
                <input type="radio" name="HOMER_mask" value="1" checked="true"/>on
                <input type="radio" name="HOMER_mask" value="2"/>off<br>
                 genomic positions to be used as background,removes background positions overlapping with target positions
                <br>
                <h6>-bg;default=automatic</h6>
                <input type="text" id="HOMER_bg" name="HOMER_bg" class="input_setting_text" value="automatic" /><br>
                 motif length <br>
              <h6>-len;default=8,10,12</h6>
              <input type="text" id="HOMER_len" name="HOMER_len" class="input_setting_text" value="8,10,12" /><br>
                Number of motifs to optimize <br>
              <h6>-S;default: 25</h6>
              <input type="text" id="HOMER_S" name="HOMER_S" class="input_setting_text" value="25"/><br>
                global optimization: searches for strings with # mismatches<br>
              <h6> -mis;default: 2</h6>
              <input type="text" id="HOMER_mis" name="HOMER_mis" class="input_setting_text" value="2" /><br>
              <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('HOMER_option_input_setting').style.display='none';JavaScript:GLAM2_radio(GLAM2_r.value,GLAM2_n.value,GLAM2_z.value,GLAM2_w.value,GLAM2_a.value,GLAM2_b.value,GLAM2_D.value,GLAM2_E.value,GLAM2_I.value,GLAM2_J.value,GLAM2_q.value,GLAM2_t.value,GLAM2_c.value,GLAM2_u.value,GLAM2_m.value,GLAM2_x.value,GLAM2_s.value)"/>
              <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('HOMER_option_input_setting').style.display='none';"/>
            </div>
            </div>
        </div>
            <input type="submit" value="Execute" class="Execute_btn" id="btn_HOMER"/><s:fielderror fieldName="check1" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;"  />
            <div id="wait_HOMER" class="Upload_wait_div" style="display:none;">
                <img src="./img/wait.gif" class="Upload_wait" />
                Uploading and processing your file,please wait...
            </div>
        </form>
          <div id="detail_text_1" class="detail_tip" style="display:none" >
              If you have questions about the results or if you want to get detail information about the finished operation,please <a href="JavaScript:operation_detail(1);" style="text-decoration: none;color:#666666">click here</a>.
              You can view the HTML report <a href="./htmlReport/homer/homerResults.html" target="_blank" style="text-decoration: none;color:#666666">click here</a>.
          </div>
          <div id="detail_1" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                  <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_1').style.display='none'"/>
              </div>
          </div>
          <div id="detail_text_4" class="detail_tip_demo" style="display:none" >
              You can view the HTML report <a href="./htmlReport/homer_demo/homerResults.html" target="_blank" style="text-decoration: none;color:#666666">click here</a>
          </div>
          <div id="detail_4" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                  <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_1').style.display='none'"/>
              </div>
          </div>
      </div>
        <!------------------------annotation------------------------------------------------------------------>
      <div class="side_right" id="side_right_2" style="display:none;">
          <div id="attention2" class="blackdown_tips_1">
              The input of Demo workflow has been filled on this page. Please click the "Execute" to run the demo.
              <br>
          </div>
        <div class="link" onclick="JavaScript:nece_opt_show_GOMo_ne();"style="cursor:hand;">
          <div class="arrow-down" id="arrow-down3" style="display:block"></div>
          <div class="arrow-right" id="arrow-right3" style="display:none"></div>
          Necessary parameter</div>
        <form action="GOMo_exe" id="GOMo_exe" enctype="multipart/form-data" method="post" onsubmit="return searchData('GOMo_exe','btn_Gomo','wait_Gomo')">
        <div class="necessary_center" id="necessary_center_GOMo" style="display:block">
          <div class="blacktop_1">
              Input the peak/BED file
              <s:fielderror fieldName="input_anno_peak" cssStyle="color:red;float:right;margin-top:0px;"  />
          </div>
          <div class="blackdown_1">
            <div class="file-box">
              <input type="text" name="input_anno_peak"  class="input_text"  value="H3K4me3.bed" id="input_anno_peak"/>
              <input type='button' class='btn' value='Choose File' />
              <input type="file"  name="Gomo_peak" class="fileField"  onchange="return( fileChange(this,'input_anno_peak')&& checkFileExt(this.value,'input_anno_peak'))"/>
            </div>
            </div>
          <div class="blacktop_1">Select the appropriate genome</div>
            <div class="blackdown_1">
                <select name="anno_genome" id="anno_genome" class="GOMo_select" style="display:block">
                    <option value="1" selected="selected">Human(hg19)</option>
                    <option value="2">Mouse(mm8)</option>
                    <option value="3">Yeast(sacCer3)</option>
                </select>
            </div>
        </div>

        <div class="link" onclick="JavaScript:nece_opt_show_GOMo_op();"style="cursor:hand;">
          <div class="arrow-down" id="arrow-down4" style="display:block"></div>
          <div class="arrow-right" id="arrow-right4" style="display:none"></div>
          Optional parameter</div>
        <div class="optional_center" id="optional_center_GOMo"style="display:block">
          <div class="blacktop_1">Optional parameter</div>
          <div class="blackdown_1">
            <input type="radio" name="GOMo_option"  id="GOMo_option_default" value="1" checked="true" onclick="document.getElementById('GOMo_option_input_setting').style.display='none';document.getElementById('GOMo_radio').style.visibility='hidden'";/>default
            <input type="radio" name="GOMo_option"  id="GOMo_option_setting" value="2"  onclick="document.getElementById('GOMo_option_input_setting').style.display='block'";/>set the parameters by yourself
            <div id="GOMo_radio" class="radio_text"></div>
          </div>
          <div class="inputOption_setting" id="GOMo_option_input_setting" style="display:none;">
            <div class="inputOption_setting_center"  style="overflow-y:scroll;">
                Genome size for genomeOntology analysis<br>
              <h6> -gsize;default: 2e9</h6>
              <input type="text" id="anno_gsize" name="anno_gsize" class="input_setting_text" value="2e9" /><br>
                Fragment length, default=auto, might want to set to 1 for 5'RNA<br>
                <h6>-len / -fragLength</h6>
                <input type="text" id="anno_len" name="anno_len" class="input_setting_text" value="auto"/><br>
                <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('GOMo_option_input_setting').style.display='none';"/>
              <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('GOMo_option_input_setting').style.display='none';"/>
            </div>
          </div>
        </div>
            <input type="submit" value="Execute" class="Execute_btn" id="btn_Gomo"/><s:fielderror fieldName="check1" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;"  />
            <div id="wait_Gomo" class="Upload_wait_div" style="display:none;">
                <img src="./img/wait.gif" class="Upload_wait" />
                Uploading and processing your file,please wait...
            </div>
          </form>
          <div id="detail_text_2" class="detail_tip" style="display:none" >
              If you have questions about the results or if you want to get detail information about the finished operation,please <a href="JavaScript:operation_detail(3);" style="text-decoration: none;color:#666666">click here</a>.
              You can view the HTML report <a href="./htmlReport/go/GenomeOntology.html" target="_blank" style="text-decoration: none;color:#666666">click here</a>.
          </div>
          <div id="detail_2" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                  <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_2').style.display='none'"/>
              </div>
              <div id="detail_text_5" class="detail_tip_demo" style="display:none" >
                  You can view the HTML report <a href="./htmlReport/go_demo/GenomeOntology.html" target="_blank" style="text-decoration: none;color:#666666">click here</a>.
              </div>
              <div id="detail_5" class="inputOption_setting_de" style="display:none;">
                  <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                      ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_2').style.display='none'"/>
                  </div>
              </div>
          </div>
</div>
<!-------------------------------------iPAGE----------------------------------->
<div class="side_right" id="side_right_3" style="display:none">
    <div id="attention3" class="blackdown_tips_1">
        The input of Demo workflow has been filled on this page. Please click the "Execute" to run the demo.
        <br>
    </div>
    <form action="iPAGE_NEW" id="iPAGE_NEW" enctype="multipart/form-data" method="post" onsubmit="return searchData('iPAGE_NEW','btn_ipage','wait_ipage')">
    <div class="necessary_center" id="necessary_center_iPAGE"style="display:block">
    <div class="blacktop_1">
        Input expression profile or peak file
        <s:fielderror fieldName="input_peakfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
        <s:fielderror fieldName="input_exp" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
    </div>
        <div class="blackdown_2">
                <input type="radio" name="exp_peak" value="1" checked="true" onclick="document.getElementById('peakfile').style.display='block';document.getElementById('expfile').style.display='none'"/>peak file
                <input type="radio" name="exp_peak" value="2" onclick="document.getElementById('peakfile').style.display='none';document.getElementById('expfile').style.display='block'"/>expression profile<br>
            <div class="file-box" style="display:block">
                <input type="text" name="input_peakfile"  class="input_text"  value="H3K4me3.bed" id="input_peakfile" />
                <input type='button' class='btn' value='Choose File' />
                <input type="file"  name="ipage_file" class="fileField"  onchange="return (fileChange(this,'input_peakfile') && checkFileExt(this.value,'input_peakfile'))" />
            </div>

            <div class="file-box" style="display:none">
                <input type="text" name="input_exp"  class="input_text" value="H3K4me3.bed" id="input_exp" />
                <input type='button' class='btn' value='Choose File' />
                <input type="file"  name="ipage_file" class="fileField"  onchange="return (fileChange(this,'input_exp')&& checkFileExt(this.value,'input_exp'))" />
            </div>

        </div>
        <div class="blacktop_1">Select the species</div>
            <div class="blackdown_1">
                <div id="species_select" style="display:block;">
                    <select name="species_select" class="GOMo_select"/>
                    <option value="1" selected="selected">human</option>
                    <option value="2">yeast </option>
                    <option value="3">worm </option>
                    <option value="4">rat </option>
                    <option value="5">pombe </option>
                    <option value="6">mouse </option>
                    <option value="7">malaria </option>
                    <option value="8">drosophila </option>
                    <option value="9">ciona </option>
                    <option value="10">chicken </option>
                    <option value="11">calbicans </option>
                    <option value="12">arabidopsis </option>
                    </select><br>
                </div>
            </div>
        <div class="blacktop_1">Whether the expression profile is discrete or continuous.</div>
        <div class="blackdown_1">
            <input type="radio" name="profile_type" value="1" checked="true"/>continuous
            <input type="radio" name="profile_type" value="2" />discrete
        </div>
            </div>
            <input type="submit" value="Execute" class="Execute_btn" id="btn_ipage"/><s:fielderror fieldName="check1" cssStyle="color:red;float:left;margin-top:0px;margin-right:10px;"  />
            <div id="wait_ipage" class="Upload_wait_div" style="display:none;">
                <img src="./img/wait.gif" class="Upload_wait" />
                Uploading and processing your file,please wait...
            </div>
        </form>
    <div id="detail_text_3" class="detail_tip" style="display:none" >
        If you have questions about the results or if you want to get detail information about the finished operation,please <a href="JavaScript:operation_detail(5);" style="text-decoration: none;color:#666666">click here</a>.
        You can view the HTML report <a href="./htmlReport/iPAGE/Result.exp.summary.html" target="_blank" style="text-decoration: none;color:#666666">click here</a>.
    </div>
    <div id="detail_3" class="inputOption_setting_de" style="display:none;">
        <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
            ${stdoutlist}<br>
            <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_5').style.display='none'"/>
        </div>
    </div>
    <div id="detail_text_6" class="detail_tip_demo" style="display:none" >
        You can view the HTML report <a href="./htmlReport/iPAGE_demo/Result.exp.summary.html" target="_blank" style="text-decoration: none;color:#666666">click here</a>.
    </div>
    <div id="detail_6" class="inputOption_setting_de" style="display:none;">
        <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
            ${stdoutlist}<br>
            <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_3').style.display='none'"/>
        </div>
    </div>
    <span style="color:#666666;font-size:20px;">Citation:</span> <br>
    <div  class="citation">
        Goodarzi, H., Elemento, O., & Tavazoie, S. (2009). Revealing global regulatory perturbations across human cancers. Molecular Cell, 36(5), 900-911.
    </div>
            </div>
</div>
    </div>
    <div id="foot">
        Copyright © 2016 - CSU-Bioinformatics Group | All Rights Reserved
    </div>
  </div>
  </div>
</body>
</html>
