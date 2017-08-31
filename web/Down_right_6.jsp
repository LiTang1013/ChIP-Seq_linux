<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2017/4/26
  Time: 21:19
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
</head>
<body>
<div id="attention" class="blackdown_tips_1">
  The input of Demo workflow has been filled on this page. Please click the "Execute" to run the demo.
  <br>
</div>
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
        <input type="text" name="input_peakfile"  class="input_text" value="H3K4me3.bed" id="input_peakfile"/>
        <input type='button' class='btn' value='Choose File' />
        <input type="file"  name="ipage_file" class="fileField"  onchange="document.getElementById('input_peakfile').value=this.value" />
      </div>

      <div class="file-box" style="display:none">
        <input type="text" name="input_exp"  class="input_text" id="input_exp"/>
        <input type='button' class='btn' value='Choose File' />
        <input type="file"  name="ipage_file" class="fileField"  onchange="document.getElementById('input_exp').value=this.value" />
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

</body>
</html>
