<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2017/4/26
  Time: 21:18
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
<div class="link" onclick="JavaScript:nece_opt_show_GOMo_ne();"style="cursor:hand;">
  <div class="arrow-down" id="arrow-down3" style="display:block"></div>
  <div class="arrow-right" id="arrow-right3" style="display:none"></div>
  Necessary parameter</div>
  <div class="necessary_center" id="necessary_center_GOMo" style="display:block">
    <div class="blacktop_1">
      Input the peak/BED file
      <s:fielderror fieldName="input_anno_peak" cssStyle="color:red;float:right;margin-top:0px;"  />
    </div>
    <div class="blackdown_1">
      <div class="file-box">
        <input type="text" name="input_anno_peak" value="H3K4me3.bed" class="input_text" id="input_anno_peak"/>
        <input type='button' class='btn' value='Choose File' />
        <input type="file"  name="Gomo_peak" class="fileField"  onchange="document.getElementById('input_anno_peak').value=this.value;fileChange(this,'input_anno_peak');" />
      </div>
    </div>
    <div class="blacktop_1">Select the appropriate genome</div>
    <div class="blackdown_1">
      <select name="anno_genome" id="anno_genome" class="GOMo_select" style="display:block">
        <option value="1" selected="selected">Human(hg19)</option>
        <option value="2">Mouse</option>
        <option value="3">Rat</option>
        <option value="4">Frog</option>
        <option value="5">Zebrafish</option>
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
        <input type="text" name="anno_gsize" class="input_setting_text" value="2e9"/><br>
        Fragment length, default=auto, might want to set to 1 for 5'RNA<br>
        <h6>-len / -fragLength</h6>
        <input type="text" name="anno_len" class="input_setting_text" value="auto"/><br>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('GOMo_option_input_setting').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('GOMo_option_input_setting').style.display='none';"/>
      </div>
    </div>
  </div>

</body>
</html>
