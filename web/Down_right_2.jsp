<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2017/4/26
  Time: 21:12
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
<div class="link" onclick="JavaScript:nece_opt_show_HOMER_ne();"style="cursor:hand;">
  <div class="arrow-down" id="arrow-down1" style="display:block"></div>
  <div class="arrow-right" id="arrow-right1" style="display:none"></div>
  Necessary parameter</div>
  <div class="necessary_center" id="necessary_center_HOMER"style="display:block">
    <div class="blacktop_1">
      Input HOMER peak file/BED file
      <s:fielderror fieldName="input_HOMER_peak" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
    </div>
    <div class="blackdown_1">
      <div class="file-box" >
        <input type="text" name="input_HOMER_peak"  class="input_text" value="H3K4me3.bed" id="input_HOMER_peak"/>
        <input type='button' class='btn' value='Choose File' />
        <input type="file" name="fileField_HOMER" class="fileField" id="fileField_HOMER_peak" onchange="document.getElementById('input_HOMER_peak').value=this.value;fileChange(this,'input_HOMER_peak');" />
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
          <input type="text" name="input_HOMER_fasta"  class="input_text" id="input_HOMER_fasta"/>
          <input type='button' class='btn' value='Choose File' />
          <input type="file" name="fileField_HOMER" class="fileField" id="fileField_HOMER_fasta" onchange="document.getElementById('input_HOMER_fasta').value=this.value;fileChange(this,'input_HOMER_fasta');" />
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
        <input type="text" name="input_HOMER_size"  value="400" class="input_text" id="input_HOMER_size"/>
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
        <input type="text" name="HOMER_bg" class="input_setting_text" value="automatic"/><br>
        motif length <br>
        <h6>-len;default=8,10,12</h6>
        <input type="text" name="HOMER_len" class="input_setting_text" value="8,10,12"/><br>
        Number of motifs to optimize <br>
        <h6>-S;default: 25</h6>
        <input type="text" name="HOMER_S" class="input_setting_text" value="25"/><br>
        global optimization: searches for strings with # mismatches<br>
        <h6> -mis;default: 2</h6>
        <input type="text" name="HOMER_mis" class="input_setting_text" value="2"/><br>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('HOMER_option_input_setting').style.display='none';JavaScript:GLAM2_radio(GLAM2_r.value,GLAM2_n.value,GLAM2_z.value,GLAM2_w.value,GLAM2_a.value,GLAM2_b.value,GLAM2_D.value,GLAM2_E.value,GLAM2_I.value,GLAM2_J.value,GLAM2_q.value,GLAM2_t.value,GLAM2_c.value,GLAM2_u.value,GLAM2_m.value,GLAM2_x.value,GLAM2_s.value)"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('HOMER_option_input_setting').style.display='none';"/>
      </div>
    </div>
  </div>
</body>
</html>
