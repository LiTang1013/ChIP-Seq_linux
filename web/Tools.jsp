<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/9 0009
  Time: 下午 10:41
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
    <script src="./js/banner.js"></script>
    <script src="./jquery-1.11.1/jquery.js"></script>
    <script src="./layer/layer.js"></script>
  <script language="javascript">

      window.onload=function() {
          var obj1 = document.getElementById('choose_home');
          var obj2 = document.getElementById('choose_tool');
          var obj3 = document.getElementById('choose_meme');
          var obj4 = document.getElementById('choose_work');
          var obj5 = document.getElementById('choose_help');
          var msg = "If you leave this page, the operation will be stopped!";
          var x = document.getElementsByClassName("Upload_wait_div");
          var signal = "true";
          obj1.onclick = function () {
              for (var i = 0; i < x.length; i++) {
                  if (x[i].style.display == 'block') {
                      if (confirm(msg)) {
                          signal = "true";
                      }
                      else {
                          signal = "false";
                          break;
                      }
                  }
              }
              if (signal == "true") {
                  window.location.href = "home_initial.jsp";
              }
              else {
              }
          }

          obj2.onclick = function () {
              for (var i = 0; i < x.length; i++) {
                  if (x[i].style.display == 'block') {
                      if (confirm(msg)) {
                          signal = "true";
                      }
                      else {
                          signal = "false";
                          break;
                      }
                  }
              }
              if (signal == "true") {
                  window.location.href = "Tools_initial.jsp";
              }
              else {
              }
          }

          obj3.onclick = function () {
              for (var i = 0; i < x.length; i++) {
                  if (x[i].style.display == 'block') {
                      if (confirm(msg)) {
                          signal = "true";
                      }
                      else {
                          signal = "false";
                          break;
                      }
                  }
              }
              if (signal == "true") {
                  window.location.href = "MEME.jsp";
              }
              else {
              }
          }

          obj4.onclick = function () {
              for (var i = 0; i < x.length; i++) {
                  if (x[i].style.display == 'block') {
                      if (confirm(msg)) {
                          signal = "true";
                      }
                      else {
                          signal = "false";
                          break;
                      }
                  }
              }
              if (signal == "true") {
                  window.location.href = "WorkFlow.jsp";
              }
              else {
              }
          }

          obj5.onclick = function () {
              for (var i = 0; i < x.length; i++) {
                  if (x[i].style.display == 'block') {
                      if (confirm(msg)) {
                          signal = "true";
                      }
                      else {
                          signal = "false";
                          break;
                      }
                  }
              }
              if (signal == "true") {
                  window.location.href = "ContactUs.jsp";
              }
              else {
              }
          }
      }
      window.onload=function() {
          var id=parseInt('${flag}');
          var id_validate=parseInt('${flag_validate}');
          for(var i=1;i<=23;i++){
              document.getElementById("side_right_"+i).style.display="none";
              document.getElementById("side_son_"+i).style.backgroundColor="#dadada";
              document.getElementById("side_son_"+i).style.color="#555555";
              document.getElementById("detail_text_"+i).style.display="none";
          }
          document.getElementById("side_son_"+id).style.backgroundColor="#fa7923";
          document.getElementById("side_son_"+id).style.color="#ffffff";
          document.getElementById("side_right_"+id).style.display="block";
          document.getElementById("detail_text_"+id).style.display="block";

          if(id_validate==2){
              for(var i=1;i<=23;i++){
                  document.getElementById("detail_text_"+i).style.display="none";
              }
          }

          if(id==8){
              for(var i=1;i<=4;i++){
                  var j=2*i-1;
                  var jj=j+1;
                  document.getElementById("side_"+i).style.display='none';
                  document.getElementById("arrow"+j).style.display='none';
                  document.getElementById("arrow"+jj).style.display='block';
              }
              document.getElementById("side_2").style.display='block';
              document.getElementById("arrow3").style.display='block';
              document.getElementById("arrow4").style.display='none';
          }
          if(id>8&&id<22){
              for(var i=1;i<=4;i++){
                  var j=2*i-1;
                  var jj=j+1;
                  document.getElementById("side_"+i).style.display='none';
                  document.getElementById("arrow"+j).style.display='none';
                  document.getElementById("arrow"+jj).style.display='block';
              }
              document.getElementById("side_3").style.display='block';
              document.getElementById("arrow5").style.display='block';
              document.getElementById("arrow6").style.display='none';
          }
          if(id==22||id==23){
              for(var i=1;i<=4;i++){
                  var j=2*i-1;
                  var jj=j+1;
                  document.getElementById("side_"+i).style.display='none';
                  document.getElementById("arrow"+j).style.display='none';
                  document.getElementById("arrow"+jj).style.display='block';
              }
              document.getElementById("side_4").style.display='block';
              document.getElementById("arrow7").style.display='block';
              document.getElementById("arrow8").style.display='none';
          }

          if('${Session}'=='Y')
          {
              document.getElementById("login_spanUpdate").style.display="block";
          }
          else{
              document.getElementById("login_spanUpdate").style.display="none";
          }
      }
      var count=1;
      function Tip_click(TipId) {
          var id = "#tip" + TipId;
          if (TipId == 1||TipId ==3||TipId ==5||TipId ==7||TipId ==9||TipId ==11||TipId ==13) {
              if(count==1){
                  layer.tips('Please input .fasta format file.', id, {
                      tips: [1, '#fa7923'],time:10000
                  }); count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==2||TipId ==4||TipId ==6||TipId ==8||TipId ==10||TipId ==12||TipId ==14){
              if(count==1) {
                  layer.tips('Please input .fastq format file.', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==16||TipId==18||TipId==20||TipId==22||TipId==24||TipId==26||TipId==28||TipId==30||TipId==32||TipId==34||TipId==36||TipId==56){
              if(count==1) {
                  layer.tips('Control file should has the same format as chIP file.', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==15){
              if(count==1) {
                  layer.tips('Please input .bed format file.', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }

          }
          else if(TipId==17){
              if(count==1) {
                  layer.tips('Please input .bedGraph format file.', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==19){
              if(count==1) {
                  layer.tips('Please input the file after being sorted.', id, {
                      tips: [1, '#fa7923'],time:10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==21||TipId==23||TipId==25||TipId==27||TipId==29||TipId==31||TipId==35||TipId==37||TipId==38||TipId==39||TipId==40||TipId==41||TipId==42||TipId==43||TipId==44||TipId==45||TipId==46||TipId==47||TipId==48||TipId==49||TipId==50||TipId==51||TipId==52||TipId==55){
              if(count==1) {
                  layer.tips('The output file will be sent to this e-mail address.', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==53){
              if(count==1) {
                  layer.tips('Please input indexed bam files separated by spaces', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
          else if(TipId==54){
              if(count==1) {
                  layer.tips('Limits the coverage analysis to the regions specified in these files.', id, {
                      tips: [1, '#fa7923'], time: 10000
                  });
                  count++;
              }
              else{
                  layer.close(layer.index);
                  count--;
              }
          }
      }


      function side_right_show(divId,count){
     for(var i=1;i<=count;i++){
        document.getElementById("side_right_"+i).style.display="none";
        document.getElementById("side_son_"+i).style.backgroundColor="#dadada";
        document.getElementById("side_son_"+i).style.color="#555555";
  }
        document.getElementById("side_son_"+divId).style.backgroundColor="#fa7923";
        document.getElementById("side_son_"+divId).style.color="#ffffff";
        document.getElementById("side_right_"+divId).style.display="block";
  }
  function side_mapping(divId,arrowId){
      var r=arrowId+1;
      for(var i=1;i<=4;i++){
          var j=2*i-1;
          var jj=j+1;
          document.getElementById("side_"+i).style.display='none';
          document.getElementById("arrow"+j).style.display='none';
          document.getElementById("arrow"+jj).style.display='block';
      }
      document.getElementById(divId).style.display='block';
      document.getElementById("arrow"+arrowId).style.display='block';
      document.getElementById("arrow"+r).style.display='none';
  }
  function nece_opt_show_BWA_ne(){
    if(document.getElementById("necessary_center_BWA").style.display=='block'){
      document.getElementById("necessary_center_BWA").style.display="none";
      document.getElementById("arrow-down3").style.display="none";
      document.getElementById("arrow-right3").style.display="block";
    }
    else{
      document.getElementById("necessary_center_BWA").style.display="block";
      document.getElementById("arrow-down3").style.display="block";
      document.getElementById("arrow-right3").style.display="none";
    }
  }
      function nece_opt_show_BWA_op(){
          if(document.getElementById("optional_center_BWA").style.display=='block'){
              document.getElementById("optional_center_BWA").style.display="none";
              document.getElementById("arrow-down4").style.display="none";
              document.getElementById("arrow-right4").style.display="block";
          }
          else{
              document.getElementById("optional_center_BWA").style.display="block";
              document.getElementById("arrow-down4").style.display="block";
              document.getElementById("arrow-right4").style.display="none";
          }
      }
      function nece_opt_show_SOAP_op(){
        if(document.getElementById("optional_center_SOAP").style.display=='block'){
          document.getElementById("optional_center_SOAP").style.display="none";
          document.getElementById("arrow-down31").style.display="none";
          document.getElementById("arrow-right31").style.display="block";
        }
        else{
          document.getElementById("optional_center_SOAP").style.display="block";
          document.getElementById("arrow-down31").style.display="block";
          document.getElementById("arrow-right31").style.display="none";
        }
      }
      function nece_opt_show_SOAP_ne(){
          if(document.getElementById("necessary_center_SOAP").style.display=='block'){
              document.getElementById("necessary_center_SOAP").style.display="none";
              document.getElementById("arrow-down30").style.display="none";
              document.getElementById("arrow-right30").style.display="block";
          }
          else{
              document.getElementById("necessary_center_SOAP").style.display="block";
              document.getElementById("arrow-down30").style.display="block";
              document.getElementById("arrow-right30").style.display="none";
          }
      }

  function nece_opt_show_Bowtie_ne(){
    if(document.getElementById("necessary_center_bowtie").style.display=='block'){
      document.getElementById("necessary_center_bowtie").style.display="none";
      document.getElementById("arrow-down14").style.display="none";
      document.getElementById("arrow-right14").style.display="block";
    }
    else{
      document.getElementById("necessary_center_bowtie").style.display="block";
      document.getElementById("arrow-down14").style.display="block";
      document.getElementById("arrow-right14").style.display="none";
    }
  }
      function nece_opt_show_Bowtie_op(){
        if(document.getElementById("optional_center_bowtie").style.display=='block'){
          document.getElementById("optional_center_bowtie").style.display="none";
          document.getElementById("arrow-down15").style.display="none";
          document.getElementById("arrow-right15").style.display="block";
        }
        else{
          document.getElementById("optional_center_bowtie").style.display="block";
          document.getElementById("arrow-down15").style.display="block";
          document.getElementById("arrow-right15").style.display="none";
        }
      }
      function nece_opt_show_blast_ne(){
          if(document.getElementById("necessary_center_blast").style.display=='block'){
              document.getElementById("necessary_center_blast").style.display="none";
              document.getElementById("arrow-down32").style.display="none";
              document.getElementById("arrow-right32").style.display="block";
          }
          else{
              document.getElementById("necessary_center_blast").style.display="block";
              document.getElementById("arrow-down32").style.display="block";
              document.getElementById("arrow-right32").style.display="none";
          }
      }
      function nece_opt_show_blast_op(){
          if(document.getElementById("optional_center_blast").style.display=='block'){
              document.getElementById("optional_center_blast").style.display="none";
              document.getElementById("arrow-down33").style.display="none";
              document.getElementById("arrow-right33").style.display="block";
          }
          else{
              document.getElementById("optional_center_blast").style.display="block";
              document.getElementById("arrow-down33").style.display="block";
              document.getElementById("arrow-right33").style.display="none";
          }
      }
      function nece_opt_show_Subread_ne(){
          if(document.getElementById("necessary_center_Subread").style.display=='block'){
              document.getElementById("necessary_center_Subread").style.display="none";
              document.getElementById("arrow-down34").style.display="none";
              document.getElementById("arrow-right34").style.display="block";
          }
          else{
              document.getElementById("necessary_center_Subread").style.display="block";
              document.getElementById("arrow-down34").style.display="block";
              document.getElementById("arrow-right34").style.display="none";
          }
      }
      function nece_opt_show_Subread_op(){
          if(document.getElementById("optional_center_Subread").style.display=='block'){
              document.getElementById("optional_center_Subread").style.display="none";
              document.getElementById("arrow-down35").style.display="none";
              document.getElementById("arrow-right35").style.display="block";
          }
          else{
              document.getElementById("optional_center_Subread").style.display="block";
              document.getElementById("arrow-down35").style.display="block";
              document.getElementById("arrow-right35").style.display="none";
          }
      }
      function nece_opt_show_NGM_ne(){
          if(document.getElementById("necessary_center_NGM").style.display=='block'){
              document.getElementById("necessary_center_NGM").style.display="none";
              document.getElementById("arrow-down36").style.display="none";
              document.getElementById("arrow-right36").style.display="block";
          }
          else{
              document.getElementById("necessary_center_NGM").style.display="block";
              document.getElementById("arrow-down36").style.display="block";
              document.getElementById("arrow-right36").style.display="none";
          }
      }
      function nece_opt_show_NGM_op(){
          if(document.getElementById("optional_center_NGM").style.display=='block'){
              document.getElementById("optional_center_NGM").style.display="none";
              document.getElementById("arrow-down37").style.display="none";
              document.getElementById("arrow-right37").style.display="block";
          }
          else{
              document.getElementById("optional_center_NGM").style.display="block";
              document.getElementById("arrow-down37").style.display="block";
              document.getElementById("arrow-right37").style.display="none";
          }
      }
  function macs_option_ne(){
    if(document.getElementById("necessary_center_macs").style.display=='block'){
      document.getElementById("necessary_center_macs").style.display="none";
      document.getElementById("arrow-down8").style.display="none";
      document.getElementById("arrow-right8").style.display="block";
    }
    else{
      document.getElementById("necessary_center_macs").style.display="block";
      document.getElementById("arrow-down8").style.display="block";
      document.getElementById("arrow-right8").style.display="none";
    }
  }
      function macs2_option_ne(){
          if(document.getElementById("necessary_center_macs2").style.display=='block'){
              document.getElementById("necessary_center_macs2").style.display="none";
              document.getElementById("arrow-down12").style.display="none";
              document.getElementById("arrow-right12").style.display="block";
          }
          else{
              document.getElementById("necessary_center_macs2").style.display="block";
              document.getElementById("arrow-down12").style.display="block";
              document.getElementById("arrow-right12").style.display="none";
          }
      }
      function macs_option_op(){
        if(document.getElementById("optional_center_macs").style.display=='block'){
          document.getElementById("optional_center_macs").style.display="none";
          document.getElementById("arrow-down9").style.display="none";
          document.getElementById("arrow-right9").style.display="block";
        }
        else{
          document.getElementById("optional_center_macs").style.display="block";
          document.getElementById("arrow-down9").style.display="block";
          document.getElementById("arrow-right9").style.display="none";
        }
      }
      function multi_option_ne(){
          if(document.getElementById("necessary_center_multi").style.display=='block'){
              document.getElementById("necessary_center_multi").style.display="none";
              document.getElementById("arrow-down44").style.display="none";
              document.getElementById("arrow-right44").style.display="block";
          }
          else{
              document.getElementById("necessary_center_multi").style.display="block";
              document.getElementById("arrow-down44").style.display="block";
              document.getElementById("arrow-right44").style.display="none";
          }
      }
      function multi_option_op(){
          if(document.getElementById("optional_center_multi").style.display=='block'){
              document.getElementById("optional_center_multi").style.display="none";
              document.getElementById("arrow-down45").style.display="none";
              document.getElementById("arrow-right45").style.display="block";
          }
          else{
              document.getElementById("optional_center_multi").style.display="block";
              document.getElementById("arrow-down45").style.display="block";
              document.getElementById("arrow-right45").style.display="none";
          }
      }
      function macs2_option_op(){
          if(document.getElementById("optional_center_macs2").style.display=='block'){
              document.getElementById("optional_center_macs2").style.display="none";
              document.getElementById("arrow-down13").style.display="none";
              document.getElementById("arrow-right13").style.display="block";
          }
          else{
              document.getElementById("optional_center_macs2").style.display="block";
              document.getElementById("arrow-down13").style.display="block";
              document.getElementById("arrow-right13").style.display="none";
          }
      }
  function nece_opt_show_ne(){
    if(document.getElementById("necessary_center_bowtie2").style.display=='block'){
      document.getElementById("necessary_center_bowtie2").style.display="none";
      document.getElementById("arrow-down1").style.display="none";
      document.getElementById("arrow-right1").style.display="block";
    }
    else{
      document.getElementById("necessary_center_bowtie2").style.display="block";
      document.getElementById("arrow-down1").style.display="block";
      document.getElementById("arrow-right1").style.display="none";
    }
  }
      function nece_opt_show_op(){
        if(document.getElementById("optioanl_center_bowtie2").style.display=='block'){
          document.getElementById("optioanl_center_bowtie2").style.display="none";
          document.getElementById("arrow-down2").style.display="none";
          document.getElementById("arrow-right2").style.display="block";
        }
        else{
          document.getElementById("optioanl_center_bowtie2").style.display="block";
          document.getElementById("arrow-down2").style.display="block";
          document.getElementById("arrow-right2").style.display="none";
        }
      }
  function peakseq_option_ne(){
    if(document.getElementById("necessary_center_peakseq").style.display=='block'){
      document.getElementById("necessary_center_peakseq").style.display="none";
      document.getElementById("arrow-down16").style.display="none";
      document.getElementById("arrow-right16").style.display="block";
    }
    else{
      document.getElementById("necessary_center_peakseq").style.display="block";
      document.getElementById("arrow-down16").style.display="block";
      document.getElementById("arrow-right16").style.display="none";
    }
  }
      function peakseq_option_op(){
          if(document.getElementById("optional_center_peakseq").style.display=='block'){
              document.getElementById("optional_center_peakseq").style.display="none";
              document.getElementById("arrow-down17").style.display="none";
              document.getElementById("arrow-right17").style.display="block";
          }
          else{
              document.getElementById("optional_center_peakseq").style.display="block";
              document.getElementById("arrow-down17").style.display="block";
              document.getElementById("arrow-right17").style.display="none";
          }
      }
  function peakranger_option_ne(){
    if(document.getElementById("necessary_center_peakranger").style.display=='block'){
      document.getElementById("necessary_center_peakranger").style.display="none";
      document.getElementById("arrow-down18").style.display="none";
      document.getElementById("arrow-right18").style.display="block";
    }
    else{
      document.getElementById("necessary_center_peakranger").style.display="block";
      document.getElementById("arrow-down18").style.display="block";
      document.getElementById("arrow-right18").style.display="none";
    }
  }
      function peakranger_option_op(){
          if(document.getElementById("optional_center_peakranger").style.display=='block'){
              document.getElementById("optional_center_peakranger").style.display="none";
              document.getElementById("arrow-down19").style.display="block";
              document.getElementById("arrow-right19").style.display="none";
          }
          else{
              document.getElementById("optional_center_peakranger").style.display="block";
              document.getElementById("arrow-down19").style.display="none";
              document.getElementById("arrow-right19").style.display="block";
          }
      }
  function sicer_option_ne(){
    if(document.getElementById("necessary_center_sicer").style.display=='block'){
      document.getElementById("necessary_center_sicer").style.display="none";
      document.getElementById("arrow-down10").style.display="none";
      document.getElementById("arrow-right10").style.display="block";
    }
    else{
      document.getElementById("necessary_center_sicer").style.display="block";
      document.getElementById("arrow-down10").style.display="block";
      document.getElementById("arrow-right10").style.display="none";
    }
  }
      function sicer_option_op(){
          if(document.getElementById("optional_center_sicer").style.display=='block'){
              document.getElementById("optional_center_sicer").style.display="none";
              document.getElementById("arrow-down11").style.display="block";
              document.getElementById("arrow-right11").style.display="none";
          }
          else{
              document.getElementById("optional_center_sicer").style.display="block";
              document.getElementById("arrow-down11").style.display="none";
              document.getElementById("arrow-right11").style.display="block";
          }
      }
  function samtools_option(divId){
      if(document.getElementById("samtools_center_"+divId).style.display=="none"){
          document.getElementById("samtools_center_"+divId).style.display="block";
          document.getElementById("arrow-down"+(divId+4)).style.display="block";
          document.getElementById("arrow-right"+(divId+4)).style.display="none";
          document.getElementById("samtools_Btn_"+divId).style.display="block";
      }
      else{
          document.getElementById("samtools_center_"+divId).style.display="none";
          document.getElementById("arrow-down"+(divId+4)).style.display="none";
          document.getElementById("arrow-right"+(divId+4)).style.display="block";
          document.getElementById("samtools_Btn_"+divId).style.display="none";
      }
  }
      function pepr_option_ne(){
          if(document.getElementById("necessary_center_pepr").style.display=='block'){
              document.getElementById("necessary_center_pepr").style.display="none";
              document.getElementById("arrow-down20").style.display="none";
              document.getElementById("arrow-right20").style.display="block";
          }
          else{
              document.getElementById("necessary_center_pepr").style.display="block";
              document.getElementById("arrow-down20").style.display="block";
              document.getElementById("arrow-right20").style.display="none";
          }
      }
      function pepr_option_op(){
          if(document.getElementById("optional_center_pepr").style.display=='block'){
              document.getElementById("optional_center_pepr").style.display="none";
              document.getElementById("arrow-down21").style.display="block";
              document.getElementById("arrow-right21").style.display="none";
          }
          else{
              document.getElementById("optional_center_pepr").style.display="block";
              document.getElementById("arrow-down21").style.display="none";
              document.getElementById("arrow-right21").style.display="block";
          }
      }
      function BCP_option_ne(){
          if(document.getElementById("necessary_center_BCP").style.display=='block'){
              document.getElementById("necessary_center_BCP").style.display="none";
              document.getElementById("arrow-down22").style.display="none";
              document.getElementById("arrow-right22").style.display="block";
          }
          else{
              document.getElementById("necessary_center_BCP").style.display="block";
              document.getElementById("arrow-down22").style.display="block";
              document.getElementById("arrow-right22").style.display="none";
          }
      }
      function BCP_option_op(){
          if(document.getElementById("optional_center_BCP").style.display=='block'){
              document.getElementById("optional_center_BCP").style.display="none";
              document.getElementById("arrow-down23").style.display="block";
              document.getElementById("arrow-right23").style.display="none";
          }
          else{
              document.getElementById("optional_center_BCP").style.display="block";
              document.getElementById("arrow-down23").style.display="none";
              document.getElementById("arrow-right23").style.display="block";
          }
      }
      function diff_option_ne(){
          if(document.getElementById("necessary_center_diff").style.display=='block'){
              document.getElementById("necessary_center_diff").style.display="none";
              document.getElementById("arrow-down24").style.display="none";
              document.getElementById("arrow-right24").style.display="block";
          }
          else{
              document.getElementById("necessary_center_diff").style.display="block";
              document.getElementById("arrow-down24").style.display="block";
              document.getElementById("arrow-right24").style.display="none";
          }
      }
      function diff_option_op(){
          if(document.getElementById("optional_center_diff").style.display=='block'){
              document.getElementById("optional_center_diff").style.display="none";
              document.getElementById("arrow-down25").style.display="block";
              document.getElementById("arrow-right25").style.display="none";
          }
          else{
              document.getElementById("optional_center_diff").style.display="block";
              document.getElementById("arrow-down25").style.display="none";
              document.getElementById("arrow-right25").style.display="block";
          }
      }
      function SISSR_option_ne(){
          if(document.getElementById("necessary_center_SISSR").style.display=='block'){
              document.getElementById("necessary_center_SISSR").style.display="none";
              document.getElementById("arrow-down26").style.display="none";
              document.getElementById("arrow-right26").style.display="block";
          }
          else{
              document.getElementById("necessary_center_SISSR").style.display="block";
              document.getElementById("arrow-down26").style.display="block";
              document.getElementById("arrow-right26").style.display="none";
          }
      }
      function SISSR_option_op(){
          if(document.getElementById("optional_center_SISSR").style.display=='block'){
              document.getElementById("optional_center_SISSR").style.display="none";
              document.getElementById("arrow-down27").style.display="block";
              document.getElementById("arrow-right27").style.display="none";
          }
          else{
              document.getElementById("optional_center_SISSR").style.display="block";
              document.getElementById("arrow-down27").style.display="none";
              document.getElementById("arrow-right27").style.display="block";
          }
      }
      function findpeak_option_ne(){
          if(document.getElementById("necessary_center_findpeaks").style.display=='block'){
              document.getElementById("necessary_center_findpeaks").style.display="none";
              document.getElementById("arrow-down28").style.display="none";
              document.getElementById("arrow-right28").style.display="block";
          }
          else{
              document.getElementById("necessary_center_findpeaks").style.display="block";
              document.getElementById("arrow-down28").style.display="block";
              document.getElementById("arrow-right28").style.display="none";
          }
      }
      function findpeak_option_op(){
          if(document.getElementById("optional_center_findpeaks").style.display=='block'){
              document.getElementById("optional_center_findpeaks").style.display="none";
              document.getElementById("arrow-down29").style.display="block";
              document.getElementById("arrow-right29").style.display="none";
          }
          else{
              document.getElementById("optional_center_findpeaks").style.display="block";
              document.getElementById("arrow-down29").style.display="none";
              document.getElementById("arrow-right29").style.display="block";
          }
      }
      function AREM_option_ne(){
          if(document.getElementById("necessary_center_AREM").style.display=='block'){
              document.getElementById("necessary_center_AREM").style.display="none";
              document.getElementById("arrow-down38").style.display="none";
              document.getElementById("arrow-right38").style.display="block";
          }
          else{
              document.getElementById("necessary_center_AREM").style.display="block";
              document.getElementById("arrow-down38").style.display="block";
              document.getElementById("arrow-right38").style.display="none";
          }
      }
      function AREM_option_op(){
          if(document.getElementById("optional_center_AREM").style.display=='block'){
              document.getElementById("optional_center_AREM").style.display="none";
              document.getElementById("arrow-down39").style.display="block";
              document.getElementById("arrow-right39").style.display="none";
          }
          else{
              document.getElementById("optional_center_AREM").style.display="block";
              document.getElementById("arrow-down39").style.display="none";
              document.getElementById("arrow-right39").style.display="block";
          }
      }
      function Fseq_option_ne(){
          if(document.getElementById("necessary_center_Fseq").style.display=='block'){
              document.getElementById("necessary_center_Fseq").style.display="none";
              document.getElementById("arrow-down40").style.display="none";
              document.getElementById("arrow-right40").style.display="block";
          }
          else{
              document.getElementById("necessary_center_Fseq").style.display="block";
              document.getElementById("arrow-down40").style.display="block";
              document.getElementById("arrow-right40").style.display="none";
          }
      }
      function Fseq_option_op(){
          if(document.getElementById("optional_center_Fseq").style.display=='block'){
              document.getElementById("optional_center_Fseq").style.display="none";
              document.getElementById("arrow-down41").style.display="block";
              document.getElementById("arrow-right41").style.display="none";
          }
          else{
              document.getElementById("optional_center_Fseq").style.display="block";
              document.getElementById("arrow-down41").style.display="none";
              document.getElementById("arrow-right41").style.display="block";
          }
      }
      function BroadPeak_option_ne(){
          if(document.getElementById("necessary_center_BroadPeak").style.display=='block'){
              document.getElementById("necessary_center_BroadPeak").style.display="none";
              document.getElementById("arrow-down42").style.display="none";
              document.getElementById("arrow-right42").style.display="block";
          }
          else{
              document.getElementById("necessary_center_BroadPeak").style.display="block";
              document.getElementById("arrow-down42").style.display="block";
              document.getElementById("arrow-right42").style.display="none";
          }
      }
      function BroadPeak_option_op(){
          if(document.getElementById("optional_center_BroadPeak").style.display=='block'){
              document.getElementById("optional_center_BroadPeak").style.display="none";
              document.getElementById("arrow-down43").style.display="block";
              document.getElementById("arrow-right43").style.display="none";
          }
          else{
              document.getElementById("optional_center_BroadPeak").style.display="block";
              document.getElementById("arrow-down43").style.display="none";
              document.getElementById("arrow-right43").style.display="block";
          }
      }

      function IGV_mapping(){
          if(document.getElementById("IGV_center_1").style.display=='block'){
              document.getElementById("IGV_center_1").style.display="none";
              document.getElementById("arrow-down44").style.display="none";
              document.getElementById("arrow-right44").style.display="block";
          }
          else{
              if(document.getElementById("IGV_center_2").style.display=='block'){
                  document.getElementById("IGV_center_2").style.display="none";
                  document.getElementById("arrow-down45").style.display="none";
                  document.getElementById("arrow-right45").style.display="block";
                  document.getElementById("IGV_center_1").style.display="block";
                  document.getElementById("arrow-down44").style.display="block";
                  document.getElementById("arrow-right44").style.display="none";
              }
              else{
                  document.getElementById("IGV_center_1").style.display="block";
                  document.getElementById("arrow-down44").style.display="block";
                  document.getElementById("arrow-right44").style.display="none";
              }
          }
      }
      function IGV_peakcalling(){
          if(document.getElementById("IGV_center_2").style.display=='block'){
              document.getElementById("IGV_center_2").style.display="none";
              document.getElementById("arrow-down45").style.display="none";
              document.getElementById("arrow-right45").style.display="block";
          }
          else{
              if(document.getElementById("IGV_center_1").style.display=='block'){
                  document.getElementById("IGV_center_1").style.display="none";
                  document.getElementById("arrow-down44").style.display="none";
                  document.getElementById("arrow-right44").style.display="block";
                  document.getElementById("IGV_center_2").style.display="block";
                  document.getElementById("arrow-down45").style.display="block";
                  document.getElementById("arrow-right45").style.display="none";
              }
              else{
                  document.getElementById("IGV_center_2").style.display="block";
                  document.getElementById("arrow-down45").style.display="block";
                  document.getElementById("arrow-right45").style.display="none";
              }
          }
      }
  function optional_radio_input(s,u,trim5,trim3){
    var div = document.getElementById("optional_radio_input");
    div.innerHTML="(-s "+s+" -u "+u+" -5 "+trim5+" -3 "+trim3+")";
    div.style.visibility="visible";
  }
      function SOAP_radio(SOAP_M,SOAP_l,SOAP_n,SOAP_r,SOAP_m,SOAP_x,SOAP_v,SOAP_s,SOAP_g,SOAP_e,SOAP_p){
          var div = document.getElementById("SOAP_radio");
          div.innerHTML="(-M "+SOAP_M+" -l "+SOAP_l+" -n "+SOAP_n+" -r "+SOAP_r+" -m "+SOAP_m+" -x "+SOAP_x+" -v "+SOAP_v+" -s "+SOAP_s+" -g "+SOAP_g+" -e "+SOAP_e+" -p "+SOAP_p+")";
          div.style.visibility="visible";
      }
      function Subread_index_radio(Subread_B,Subread_f,Subread_F,Subread_M){
          var div = document.getElementById("Subread_index_radio");
          div.innerHTML="(-B "+Subread_B+" -f "+Subread_f+" -F "+Subread_F+" -M "+Subread_M+")";
          div.style.visibility="visible";
      }
      function Subread_align_radio(Subread_B2,Subread_d,Subread_D,Subread_I,Subread_m,Subread_M,Subread_n,Subread_p,Subread_P,Subread_S,Subread_T,Subread_trim5,Subread_trim3){
          var div = document.getElementById("Subread_align_radio");
          div.innerHTML="(-B "+Subread_B2+" -d "+Subread_d+" -D "+Subread_D+" -I "+Subread_I+" -m "+Subread_m+" -M "+Subread_M+" -n "+Subread_n+" -p "+Subread_p+" -P "+Subread_P+" -S "+Subread_S+" -T "+Subread_T+" --trim5 "+Subread_trim5+" --trim3 "+Subread_trim3+")";
          div.style.visibility="visible";
      }
  function alignment_radio(alignment_N,alignment_L,alignment_i,alignment_n,alignment_dpad,alignment_gbar){
    var div = document.getElementById("alignment_radio");
    div.innerHTML="(-N "+alignment_N+" -L "+alignment_L+" -i "+alignment_i+" ---n-ceil "+alignment_n+" --dpad "+alignment_dpad+" --gbar "+alignment_gbar+")";
    div.style.visibility="visible";
  }
  function score_radio(score_ma,score_mp,score_np,score_rdg5,score_rdg3,score_rfg5,score_rfg3){
    var div = document.getElementById("score_radio");
    div.innerHTML="(--ma "+score_ma+" --mp "+score_mp+" --np "+score_np+" --rdg "+score_rdg5+" "+score_rdg3+" "+" --rfg "+score_rfg5+" "+score_rfg3+")";
    div.style.visibility="visible";
  }
  function ak_radio(ak_k){
    var div = document.getElementById("ak_radio");
    div.innerHTML="(-k "+ak_k+")";
    div.style.visibility="visible";
  }
  function analysisMode_radio(analysisMode_n,analysisMode_o,analysisMode_e,analysisMode_i,analysisMode_d,analysisMode_l,analysisMode_k,analysisMode_m,analysisMode_M,analysisMode_O,analysisMode_E,analysisMode_R,analysisMode_q,analysisMode_B,analysisMode_L)
  {
    var div = document.getElementById("analysisMode_radio");
    div.innerHTML="(-n "+analysisMode_n+" -o "+analysisMode_o+" -e "+analysisMode_e+" -i "+analysisMode_i+" -d "+analysisMode_d+" -l "+analysisMode_l+" -k "+analysisMode_k+" -m "+analysisMode_m+" -M "+analysisMode_M+" -O "+analysisMode_O+" -E "+analysisMode_E+" -R "+analysisMode_R+" -q "+analysisMode_q+" -B "+analysisMode_B+" -L "+analysisMode_L+")";
    div.style.visibility="visible";
  }
  function advancedPair_radio(advancedPair_a,advancedPair_o,advancedPair_n,advancedPair_N,advancedPair_c){
    var div = document.getElementById("advancedPair_radio");
    div.innerHTML="(-a "+advancedPair_a+" -o "+advancedPair_o+" -n "+advancedPair_n+" -N "+advancedPair_N+" -c "+advancedPair_c+")";
    div.style.visibility="visible";
  }
  function macs_radio(macs_g,macs_s,macs_bw,macs_p){
    var div = document.getElementById("macs_radio");
    div.innerHTML="(-g "+macs_g+" -s "+macs_s+" -bw "+macs_bw+" -p "+macs_p+")";
    div.style.visibility="visible";
  }
      function macs2_radio(macs2_g,macs2_s,macs2_bw,macs2_q,macs2_m){
          var div = document.getElementById("macs2_radio");
          div.innerHTML="(-g "+macs2_g+" -s "+macs2_s+" -bw "+macs2_bw+" -q "+macs2_q+" -m "+macs2_m+")";
          div.style.visibility="visible";
      }
  function sicer_radio(sicer_sp,sicer_RT,sicer_ws,sicer_fs,sicer_egf,sicer_gs,sicer_fdr){
    var div = document.getElementById("sicer_radio");
    div.innerHTML="("+sicer_sp+" "+sicer_RT+" "+sicer_ws+" "+sicer_fs+" "+sicer_egf+" "+sicer_gs+" "+sicer_fdr+")";
    div.style.visibility="visible";
  }
      function pepr_radio(pepr_peaktype,pepr_p,pepr_keep,pepr_num){
          var div = document.getElementById("pepr_radio");
          div.innerHTML="(--peaktype "+pepr_peaktype+" --threshold "+pepr_p+" --keep-max-dup "+pepr_keep+" --num-processors "+pepr_num+")";
          div.style.visibility="visible";
      }
      function BCP_radio_HM(BCP_f,BCP_W,BCP_p){
          var div = document.getElementById("BCP_radio");
          div.innerHTML="(-f "+BCP_f+" -w "+BCP_W+" -p "+BCP_p+")";
          div.style.visibility="visible";
      }
      function BCP_radio_TF(BCP_e,BCP_p2){
          var div = document.getElementById("BCP_radio");
          div.innerHTML="(-e "+BCP_e+" -p "+BCP_p2+")";
          div.style.visibility="visible";
      }
      function diff_radio(diff_mode,diff_w,diff_step,diff_gap,diff_nsd,diff_alpha,diff_bkg){
          var div = document.getElementById("diff_radio");
          div.innerHTML="(--mode "+diff_mode+" --window "+diff_w+" --step "+diff_step+" --gap "+diff_gap+" --nsd "+diff_nsd+" --alpha "+diff_alpha+" --bkg "+diff_bkg+")";
          div.style.visibility="visible";
      }
      function SISSR_radio(SISSR_D,SISSR_e,SISSR_p,SISSR_m,SISSR_w,SISSR_E,SISSR_L){
          var div = document.getElementById("SISSR_radio");
          div.innerHTML="(-D "+SISSR_D+" -e "+SISSR_e+" -p "+SISSR_p+" -m "+SISSR_m+" -w "+SISSR_w+" -E "+SISSR_E+" -L "+SISSR_L+")";
          div.style.visibility="visible";
      }
      function BroadPeak_radio(BroadPeak_b,BroadPeak_g){
          var div = document.getElementById("BroadPeak_radio");
          div.innerHTML="(-b "+BroadPeak_b+" -g "+BroadPeak_g+")";
          div.style.visibility="visible";
      }
      function Fseq_radio(Fseq_l,Fseq_s,Fseq_t,Fseq_v){
          var div = document.getElementById("Fseq_radio");
          var v;
          if(Fseq_v==1){
              v=" -v ";
          }
          else{
              v="";
          }
          div.innerHTML="(-l "+Fseq_l+" -s "+Fseq_s+" -t "+Fseq_t+v+")";
          div.style.visibility="visible";
      }
      function findpeak_radio(findpeak_dir,findpeak_type,findpeak_filter,findpeak_hs){
          var div = document.getElementById("findpeak_radio");
          var dir,filter;
          if(findpeak_dir==1){
              dir="-directional";
          }
          else{
              dir="";
          }
          if(findpeak_filter==1){
              filter="-filter";
          }
          else{
              filter="";
          }
          div.innerHTML="("+dir+" -dist_type "+findpeak_type+filter+" -hist_size "+findpeak_hs+")";
          div.style.visibility="visible";
      }
      function bowtie_index_radio(bowtie_nodc,bowtie_justref,bowtie_offrate,bowtie_t,bowtie_ns){
    var div = document.getElementById("bowtie_index_radio");
    var nodc,justref,ntoa;
    if(bowtie_nodc==1){
      nodc="";
    }
    else{
      nodc="--nodc"
    }
    if(bowtie_justref==1){
      justref="";
    }
    else{
      justref="--justref";
    }
    if(bowtie_ns==1){
      ntoa="";
    }
    else{
      ntoa="--ntoa";
    }
    div.innerHTML="("+nodc+" "+justref+" "+ntoa+" --offrate "+bowtie_offrate+" -t "+bowtie_t+")";
    div.style.visibility="visible";
  }
  function bowtie_mode_n_radio(bowtie_mode_n,bowtie_mode_l,bowtie_mode_e,bowtie_mode_max){
    var div = document.getElementById("bowtie_mode_n_radio");
    div.innerHTML="(-n "+bowtie_mode_n+" -l "+bowtie_mode_l+" -e "+bowtie_mode_e+" --maxbts "+bowtie_mode_max+")";
    div.style.visibility="visible";
  }
  function bowtie_mode_v_radio(bowtie_mode_v){
    var div = document.getElementById("bowtie_mode_v_radio");
    div.innerHTML="(-v "+bowtie_mode_v+")";
    div.style.visibility="visible";
  }
  function bowtie_input_radio(bowtie_s,bowtie_u,bowtie_5,bowtie_3){
    var div = document.getElementById("bowtie_input_radio");
    div.innerHTML="(-s "+bowtie_s+" -u "+bowtie_u+" -5 "+bowtie_5+" -3 "+bowtie_3+")";
    div.style.visibility="visible";
  }
  function bowtie_alignment_radio(bowtie_nomaqround,bowtie_I,bowtie_X){
    var div = document.getElementById("bowtie_alignment_radio");
    var noma;
    if(bowtie_nomaqround==1){
      noma="";
    }
    else{
      noma="--nomaqround";
    }

    div.innerHTML="(--nomaqround "+bowtie_nomaqround+" -I "+bowtie_I+" -X "+bowtie_X+")";
    div.style.visibility="visible";
  }
  function bowtie_report_radio(bowtie_k,bowtie_a){
    var div = document.getElementById("bowtie_report_radio");
    var a;
    if(bowtie_a==1){
      a="";
    }
    else{
      a="-a";
    }
    div.innerHTML="(-k "+bowtie_k+" "+a+")";
    div.style.visibility="visible";
  }
  function peakseq_radio(peakseq_length,peakseq_fdr,peakseq_N,peakseq_Min,peakseq_mode,peakseq_qvalue){
    var div = document.getElementById("peakseq_radio");
    var mode;
    if(peakseq_mode==1){
      mode="Poisson";
    }
    else{
      mode="Simulated";
    }
    div.innerHTML="(length "+peakseq_length+" FDR "+peakseq_fdr+" N_Simulations "+peakseq_N+" distance "+peakseq_Min+" mode "+mode+" Qvalue "+peakseq_qvalue+")";
    div.style.visibility="visible";
  }
      function expandPhoto(){
          var overlay=document.createElement("div");
          overlay.setAttribute("id","overlay");
          overlay.setAttribute("class","overlay");
          document.body.appendChild(overlay);

          var img=document.createElement("img");
          img.setAttribute("class","overlayimg");
          img.src="http://192.168.1.113:9080/ChIP-Seq_linux_war/img/mapping_visual.png";
          document.getElementById("overlay").appendChild(img);

          img.onclick=restore;
      }
      function expandPhoto1(){
          var overlay=document.createElement("div");
          overlay.setAttribute("id","overlay");
          overlay.setAttribute("class","overlay");
          document.body.appendChild(overlay);

          var img=document.createElement("img");
          img.setAttribute("class","overlayimg");
          img.src="http://192.168.1.113:9080/ChIP-Seq_linux_war/img/peakcalling_visual.png";
          document.getElementById("overlay").appendChild(img);
          img.onclick=restore;
      }
      function restore(){
          document.body.removeChild(document.getElementById("overlay"));
          document.body.removeChild(document.getElementById("img"));
      }

      function operation_detail(id){
          document.getElementById("detail_"+id).style.display="block";
      }
      function mouseOver(){
          document.getElementById("login_menu").style.display="block";
      }
      function mouseOut(){
          document.getElementById("login_menu").style.display="none";
      }
      function fileChange(target,box) {
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
      height:1000px;
      background-color:#ebeaea;
    }
    #banner{
        height:190px;
        background: url("./img/back3.png") no-repeat;
        background-size:cover;
        background-position:center;
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
          color:#ffffff;
          background:none;
          width:70px;
          padding-left:12px;
          height:35px;
          float:right;
          font-weight: 300;
      }
      #choose_home:hover{
          color:#fa7923;
          border-left:none;
          border-right:none;
          border-top:none;
          border-radius: 5px;
          font-weight: 500;
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
      #choose_tool{
          color:#fa7923;
          border-radius: 5px;
          background-color:rgba(255,255,255,0.9);
          text-shadow:1px 2px 3px #bdbcbb;
          padding-left:10px;
          width:60px;
          height:35px;
          float:right;
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
    #side_center{
      width:95%;
      margin:0 auto;
    }
    #left_side{
      width:25%;
      height:80%;
      float:left;
    }
    .side_radio{
      margin-top:63px;
      margin-left:10%;
      float:left;
      border-radius:50%;
      width:14px;
      height:14px;
      background-color: #fa7923;
      border:3px solid #fbb24f;
    }
    .side_top{
      margin-top:50px;
      margin-left:10%;
      height:40px;
      line-height: 52px;
      padding-left:50px
      color:#000000;
      font-weight: 300;
      border-top:none;
      border-left:none;
      border-right:none;
      border-bottom:2px solid #fa7923;
    }
    .arrow1{
      float:left;
      margin-left: 15%;
      margin-top:10px;
      width:18px;
      height:18px;
      background-image: url("./img/arrow-down.png");
    }
    .arrow2{
      float:left;
      margin-left: 15%;
      margin-top:10px;
      width:18px;
      height:18px;
      background-image: url("./img/arrow-right.png");
    }
    .side_parent{
      margin-left:8px;
      height:40px;
      line-height: 40px;
      color: #fa7923;
    }
    .side_son{
      margin-left:18%;
      padding-left:10px;
      height:40px;
      line-height: 40px;
      color: #555555;
      background-color:#e1dfdf;
    }
    .side_son:hover{
      margin-left:20%;
      height:40px;
      line-height: 40px;
      color: #555555;
      background-color: #bfbfbf;
      border-top:none;
      border-bottom: none;
      border-right:none;
      border-left:2px solid #fa7923;
    }
    #side_right{
      margin-top:-20px;
      margin-left:25%;
      width:70%;
      height:800px;
      overflow-y:scroll;
      position:relative;
      background-color: #ffffff;
      z-index: 900;
      box-shadow:10px 5px 20px #999999;
      -moz-box-shadow:10px 5px 20px #999999;
      -webkit-box-shadow:10px 5px 20px #999999;
    }
    .arrow-down {
      width:0;
      height:0;
      float:left;
      border-left:6px solid transparent;
      border-right:6px solid transparent;
      border-top:6px solid #666666;
      margin-top:5px;
      margin-right:2px;
    }
    .arrow-right {
      width:0;
      height:0;
      float:left;
      border-top:6px solid transparent;
      border-bottom: 6px solid transparent;
      border-left: 6px solid #666666;
      margin-top:3px;
      margin-right:2px;
    }
    .link{
      width:100%;
      margin-left:-10px;
      font-size:17px;
      font-weight: bold;
      color:#666666;
      margin-bottom:10px;
      margin-top:10px;
    }
    .side_right{
      width:90%;
      height:auto;
      padding-top: 20px;
      padding-left: 40px;
      color: #ffffff;
    }
    .necessary_center,.optional_center{
      width:100%;
      height:auto;
      border:1px solid #666666;
    }
    #optional_center_bowtie{
        width:100%;
        height:150px;
        border:1px solid #666666;
    }
    .blacktop_1,#blacktop_20{
      width:95%;
      height:25px;
      line-height:25px;
      background-color: #999999;
      padding-left: 8px;
      color: #ffffff;
      margin:0 auto;
      margin-top: 10px;
    }
    .blackdown_1{
      width:95%;
      height:40px;
      line-height: 40px;
      background-color: #dadada;
      padding-left: 8px;
      padding-top: 8px;
      color: #333333;
      margin:0 auto;
    }
    #blackdown_20{
      width:95%;
      height:35px;
      line-height: 35px;
      background-color: #dadada;
      padding-left: 8px;
      color: #333333;
      margin:0 auto;
    }
    #blackdown_2_bowtie{
      width:95%;
      height:95px;
      background-color: #dadada;
      padding-left: 8px;
      padding-top: 8px;
      color: #333333;
      margin:0 auto;
    }
    .blackdown_2_bowtie2{
      width:95%;
      height:60px;
      background-color: #dadada;
      padding-left: 8px;
      padding-top: 8px;
      color: #333333;
      margin:0 auto;
    }
    .blackdown_2_bwa{
        width:95%;
        height:120px;
        background-color: #dadada;
        padding-left: 8px;
        padding-top: 8px;
        color: #333333;
        margin:0 auto;
    }
    .radio_text{
      font-size:12px;
      color:#ffffff;
      display:inline;
    }
    .inputOption_setting{
      width:480px;
      height:330px;
      position:fixed;
      top:40%;
      left:40%;
      background-color:rgba(177,201,233,0.5);
      padding-left:5px;
      padding-top:8px;
    }
    .inputOption_setting_center{
      width:96%;
      height:97%;
      overflow-y:scroll;
      padding-left:15px;
      padding-top:5px;
      background-color: #b1c9e9;
      font-size:14px;
      font-weight: 500;
      color:#464646;
    }
    .inputOption_setting_de{
        width:600px;
        height:300px;
        position:fixed;
        top:30%;
        left:30%;
        background-color:rgba(177,201,233,0.5);
        padding-left:8px;
        padding-top:8px;
        padding-bottom:8px;
    }
    .inputOption_setting_center_de{
        width:96%;
        height:97%;
        overflow-y:scroll;
        padding-left:15px;
        padding-top:5px;
        background-color: #b1c9e9;
        font-size:14px;
        font-weight: 500;
        color:#464646;
    }
    .btn_submit,.btn_cancel{
      line-height: 20px;
      border-radius: 5px;border: 1px solid #F9A32D;
      color:#ffffff;
      background-color:#F9A32D;
      height:25px; width:60px;
      margin-left:100px;
      margin-top:15px;
      margin-bottom:10px;
    }
    h1{
      font-size: 14px;
      color:#999999;
      margin-top:-30px;
      margin-left:350px;
    }
      h2{
          font-size:25px;
          font-weight: 400;
          margin-left:25px;
      }
    .GOMo_select{
      width:96%;
      margin:0 auto;
      height:23px;
      line-height: 23px;
      border-radius: 5px;
      border:1px solid #999999;
      margin-bottom:5px;
    }
    h6{
      font-size:12px;
      font-weight: 200;
      color:#666666;
      margin-top:5px;
      margin-bottom:5px;
    }
    h7{
      font-size:12px;
      font-weight: 200;
      color:#CCCCCC;
      padding-left:10px;
    }
    h8{
      font-size:12px;
      font-weight: 200;
      color:#999999;
      padding-left:10px;
    }
    .input_setting_text{
      width:96%;
      margin:0 auto;
      height:23px;
      line-height: 23px;
      border-radius: 5px;
      border:1px solid #999999;
      margin-bottom:5px;
      padding-left:5px;
    }
    img{
        padding:5px;
        width:600px;
        height:auto;
    }
    .outer{
        width:600px;
        height:100px;
        margin-left:10px;
    }
    .overlay{
        background-color:rgba(0,0,0,0.7);
        top:0;
        left:0;
        width:100%;
        height:100%;
        position:fixed;
        z-index:910;
    }
    .overlayimg{
        z-index:911;
        margin:0 auto;
        width:auto;
        position:fixed;
    }
    #foot{
        width:100%;
        height:80px;
        background-color:#666666;
        margin-top:-30px;
        color:#ffffff;
        padding-left:100px;
        padding-top:80px;
        z-index:6;
    }
    .tip{
        width:15px;
        height:15px;
    }
    .tip_out{
        float:right;
        margin-left:5px;
    }
    .detail_tip{
        width:100%;
        height:40px;
        font-size:15px;
        background-color: #F9A32D;
        color:#ffffff;
        padding-left: 10px;
        padding-top:10px;
        margin:0 auto;
        margin-bottom:10px;
        border-radius: 5px;
    }
      .Upload_wait{
          width:30px;
          height:30px;
          margin-top:10px;
      }
      .Execute_btn{
          margin-bottom:10px;
          margin-top:10px;
          width:80px;
          height:30px;
          border: 0px ;
          background:#F9A32D;
          color: #ffffff;
          border-bottom-left-radius: 5px;
          border-bottom-right-radius: 5px;
          border-top-left-radius: 5px;
          border-top-right-radius: 5px;
          font-size: 15px;
      }
      .Execute_btn_samtools{
          margin-bottom:10px;
          margin-top:10px;
          margin-left:20px;
          width:80px;
          height:30px;
          border: 01px ;
          background:#F9A32D;
          color: #ffffff;
          border-bottom-left-radius: 5px;
          border-bottom-right-radius: 5px;
          border-top-left-radius: 5px;
          border-top-right-radius: 5px;
          font-size: 15px;
      }
      .Upload_wait_div{
          font-size: 15px;
          color:#666666;
          margin-top:-60px;
          margin-left:100px;
      }
      .citation{
          padding-top:10px;
          padding-left:10px;
          padding-bottom:10px;
          color:#666666;
          border:1px dashed #cccccc;
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
    .file-box{ position:relative;width:100%;}
    .btn{background-color:#F9A32D;height:28px; width:15%;color: #ffffff; border-radius: 10px;border: 1px solid #F9A32D;}
    .fileField{position:absolute; top:0; right:1px; height:28px; filter:alpha(opacity:0);opacity: 0;width:18%; }
    .input_text{ border:1px solid #999999;  width:80%;  height:28px;  color: #999999;  border-top-left-radius: 10px;  border-top-right-radius: 10px;  border-bottom-left-radius: 10px;  border-bottom-right-radius: 10px;  padding-left: 10px;}
    .input_text_pair{border:1px solid #999999; width:30%;  height:23px;  color: #999999;  border-top-left-radius: 10px;  border-top-right-radius: 10px;  border-bottom-left-radius: 10px;  border-bottom-right-radius: 10px;  padding-left: 8px;}
    .fileField_pair1{position:absolute; top:0; right:50%; height:28px; filter:alpha(opacity:0);opacity: 0;width:18%;}
    .fileField_pair2{position:absolute; top:0; right:10px; height:28px; filter:alpha(opacity:0);opacity: 0;width:18%;}
  </style>
</head>
<body>

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
      <div id="login_spanUpdate" style="display:none" onclick="recentShow()">Recent Jobs</div>
  </div>
  <div id="side_center">
    <div id="left_side">
      <div class="side_radio"></div>
      <div class="side_top"><h2>Tools</h2></div>
      <div class="side_parent" onclick="JavaScript:side_mapping('side_1',1); " style="cursor:hand;">
        <div class="arrow1" id="arrow1" style="display: block"></div>
        <div class="arrow2" id="arrow2" style="display:none"></div>
        Mapping</div>
      <div id="side_1" style="display: block">
      <div class="side_son" id="side_son_1" style="background-color: #fa7923;color:#ffffff" onclick="JavaScript:side_right_show(1,23)"; style="cursor:hand;">BWA</div>
      <div class="side_son" id="side_son_2"  onclick="JavaScript:side_right_show(2,23)">Bowtie</div>
      <div class="side_son" id="side_son_3"  onclick="JavaScript:side_right_show(3,23)">Bowtie2</div>
      <div class="side_son" id="side_son_4"  onclick="JavaScript:side_right_show(4,23)">SOAP</div>
      <div class="side_son" id="side_son_5"  onclick="JavaScript:side_right_show(5,23)">BLAST</div>
      <div class="side_son" id="side_son_6"  onclick="JavaScript:side_right_show(6,23)">Subread</div>
      <div class="side_son" id="side_son_7"  onclick="JavaScript:side_right_show(7,23)">NGM</div>
     </div>
        <div class="side_parent" onclick="JavaScript:side_mapping('side_2',3);" style="cursor:hand;">
            <div class="arrow1" id="arrow3" style="display: none"></div>
            <div class="arrow2" id="arrow4" style="display:block"></div>
        Quality Control</div>
        <div id="side_2" style="display: none">
            <div class="side_son" id="side_son_8" onclick="JavaScript:side_right_show(8,23)">multiBamSummary</div>
            </div>
      <div class="side_parent" onclick="JavaScript:side_mapping('side_3',5);" style="cursor:hand;">
        <div class="arrow1" id="arrow5" style="display: none"></div>
        <div class="arrow2" id="arrow6" style="display:block"></div>
        Peak Calling</div>
      <div id="side_3" style="display: none">
      <div class="side_son" id="side_son_9" onclick="JavaScript:side_right_show(9,23)">MACS</div>
      <div class="side_son" id="side_son_10" onclick="JavaScript:side_right_show(10,23)">MACS2</div>
      <div class="side_son" id="side_son_11" onclick="JavaScript:side_right_show(11,23)">PeakSeq</div>
      <div class="side_son" id="side_son_12" onclick="JavaScript:side_right_show(12,23)">PeakRanger</div>
      <div class="side_son" id="side_son_13" onclick="JavaScript:side_right_show(13,23)">SICER</div>
      <div class="side_son" id="side_son_14" onclick="JavaScript:side_right_show(14,23)">PePr</div>
      <div class="side_son" id="side_son_15" onclick="JavaScript:side_right_show(15,23)">BCP</div>
      <div class="side_son" id="side_son_16" onclick="JavaScript:side_right_show(16,23)">diffReps</div>
      <div class="side_son" id="side_son_17" onclick="JavaScript:side_right_show(17,23)">SISSRs</div>
      <div class="side_son" id="side_son_18" onclick="JavaScript:side_right_show(18,23)">FindPeaks</div>
      <div class="side_son" id="side_son_19" onclick="JavaScript:side_right_show(19,23)">AREM</div>
      <div class="side_son" id="side_son_20" onclick="JavaScript:side_right_show(20,23)">Fseq</div>
      <div class="side_son" id="side_son_21" onclick="JavaScript:side_right_show(21,23)">BroadPeak</div>
        </div>
      <div class="side_parent" onclick="JavaScript:side_mapping('side_4',7);" style="cursor:hand;">
        <div class="arrow1" id="arrow7" style="display:none"></div>
        <div class="arrow2" id="arrow8" style="display:block"></div>
        Format Convert</div>
      <div id="side_4" style="display:none">
          <div class="side_son" id="side_son_22" onclick="JavaScript:side_right_show(22,23)">Samtools</div>
          <div class="side_son" id="side_son_23" onclick="JavaScript:side_right_show(23,23)">bamCoverage</div>
      </div>
        <%--<div class="side_parent" onclick="JavaScript:side_mapping('side_4',7); " style="cursor:hand;">
            <div class="arrow1" id="arrow7" style="display: none"></div>
            <div class="arrow2" id="arrow8" style="display:block"></div>
            Visualization</div>
        <div id="side_4" style="display:none">
            <div class="side_son" id="side_son_22" onclick="JavaScript:side_right_show(22,22)">IGV</div>
            </div>--%>
    </div>
    <div id="side_right">
      <!--------------------------------BWA-------------------------------------------------------------->
      <div id="side_right_1" class="side_right" style="display:block">
        <div class="link" onclick="JavaScript:nece_opt_show_BWA_ne();" style="cursor:hand;">
          <div class="arrow-down" id="arrow-down3" style="display:block"></div>
          <div class="arrow-right" id="arrow-right3" style="display:none"></div>
          Necessary parameter</div>
          <form action="BWA_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_BWA').style.backgroundColor='#666666';document.getElementById('wait_BWA').style.display='block';">
              <div id="necessary_center_BWA" class="necessary_center" style="display:block" style="overflow-y:scroll; ">
                  <div class="blacktop_1" id="BWA_test">Choose the library type</div>
                  <div class="blackdown_1">
                      <input id="BWA_single"  name="BWA_type" type="radio" value="1" checked="true" onclick="document.getElementById('file-box_BWA_single').style.display='block';document.getElementById('file-box_BWA_paired').style.display='none';document.getElementById('blacktop_20').style.display='none';document.getElementById('blackdown_20').style.display='none'"/>Single-end
                      <input id="BWA_pair" name="BWA_type" type="radio" value="2" onclick="document.getElementById('file-box_BWA_single').style.display='none';document.getElementById('file-box_BWA_paired').style.display='block';document.getElementById('blacktop_20').style.display='block';document.getElementById('blackdown_20').style.display='block'"; />Paired-end
                  </div>
                  <div class="blacktop_1">
                      Select reference to build index or use a built-in index
                      <div class="tip_out"><img class="tip" id="tip1" src="./img/tip.png" onclick="JavaScript:Tip_click(1)"></div>
                      <s:fielderror fieldName="input_BWA_reference" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_2_bwa">
                      <input type="radio" name="refer_index_BWA" id="BWA_refer_index_1" value="1" checked="true" onclick="document.getElementById('file-input_BWA_reference').style.display='block';document.getElementById('built_in_BWA').style.display='none';"/>Select reference to build index
                      <input type="radio" name="refer_index_BWA" id="BWA_refer_index_2" value="2" onclick="document.getElementById('file-input_BWA_reference').style.display='none';document.getElementById('built_in_BWA').style.display='block'"/>Use a built-in index
                      <div class="file-box" id="file-input_BWA_reference" style="display:block">
                          <input type="text" name="input_BWA_reference" id="input_BWA_reference" class="input_text" />
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bwa" class="fileField" id="fileField_bwa_re" onchange="document.getElementById('input_BWA_reference').value=this.value;fileChange(this,'input_BWA_reference');" />
                      </div>
                      <br>
                      <div class="built_in" id="built_in_BWA" style="display: none;">
                          <select name="built_in_BWA" class="gomo_select">
                              <option value="1" selected="selected">Human(b37) hg19</option>
                              <option value="2" disabled="true">Human(b37) hg38</option>
                          </select>
                      </div>
                     -Choose the type of the reference genome.<br>
                      <input type="radio" name="long_short" value="1"/>long genome
                      <input type="radio" name="long_short" value="2" checked="true"/>short genome
                  </div>
                  <div class="blacktop_1">
                      Select reads file
                      <div class="tip_out">
                          <img class="tip" id="tip2" src="./img/tip.png" onclick="JavaScript:Tip_click(2)">
                      </div>
                      <s:fielderror fieldName="input_BWA_reads_single" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                      <s:fielderror fieldName="input_BWA_reads_pair1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box" id="file-box_BWA_single" style="display:block;">
                          <input type="text" name="input_BWA_reads_single" class="input_text" id="input_BWA_reads_single"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bwa" class="fileField" id="fileField_bwa_file" onchange="document.getElementById('input_BWA_reads_single').value=this.value;fileChange(this,'input_BWA_reads_single');" />
                      </div>
                      <div class="file-box" id="file-box_BWA_paired" style="display:none;">
                          <input type="text" name="input_BWA_reads_pair1" class="input_text_pair" id="input_BWA_reads_pair1"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bwa" class="fileField_pair1" id="fileField_bwa_file1" onchange="document.getElementById('input_BWA_reads_pair1').value=this.value;fileChange(this,'input_BWA_reads_pair1');" />
                          <input type="text" name="input_BWA_reads_pair2" class="input_text_pair" id="input_BWA_reads_pair2"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bwa" class="fileField_pair2" id="fileField_bwa_file2" onchange="document.getElementById('input_BWA_reads_pair2').value=this.value;fileChange(this,'input_BWA_reads_pair2');" />
                      </div>
                  </div>

              </div>
              <div class="link" onclick="JavaScript:nece_opt_show_BWA_op();" style="cursor:hand;">
                  <div class="arrow-down" id="arrow-down4" style="display:block"></div>
                  <div class="arrow-right" id="arrow-right4" style="display:none"></div>
                  Optional parameter</div>
              <div id="optional_center_BWA" class="optional_center"style="display:block">
                  <div id="blacktop_20" style="display:none">Set advanced paired end options? <h7>Provides additional controls </h7> </div>
                  <div id="blackdown_20" style="display:none">
                      <input type="radio" name="advancedPair"  id="advancedPair_default" value="1" checked="true" onclick="document.getElementById('advancedPair_setting').style.display='none';document.getElementById('advancedPair_radio').style.visibility='hidden'";/>do not set
                      <input type="radio" name="advancedPair"  id="advancedPair_set" value="2"  onclick="document.getElementById('advancedPair_setting').style.display='block'";/>set the parameters
                      <div id="advancedPair_radio" class="radio_text"></div>
                  </div>
                  <div id="advancedPair_setting" class="inputOption_setting" style="display:none;">
                      <div id="advancedPair_setting_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                          Maximum insert size for a read pair to be considered being mapped properly.<br>
                          <h6>sampe -a; This option is only used when there are not enough good alignment to infer the distribution of insert sizes; default=500</h6>
                          <input type="text" name="advancedPair_a" class="input_setting_text" value="500"/>
                          Maximum occurrences of a read for pairing. A read with more occurrences will be treated as a single-end read.<br>
                          <h6>sampe -o; Reducing this parameter helps faster pairing; default=100000</h6>
                          <input type="text" name="advancedPair_o" class="input_setting_text" value="100000"/>
                          Maximum number of alignments to output in the XA tag for reads paired properly.<br>
                          <h6>sampe -n; If a read has more than this many hits, the XA tag will not be written; default=3</h6>
                          <input type="text" name="advancedPair_n" class="input_setting_text" value="3"/>
                          Maximum number of alignments to output in the XA tag for disconcordant read pairs (excluding singletons).<br>
                          <h6>sampe -N; If a read has more than this many hits, the XA tag will not be written; default=10</h6>
                          <input type="text" name="advancedPair_N" class="input_setting_text" value="10"/>
                          Prior of chimeric rate (lower bound)<br>
                          <h6>sampe -c</h6>
                          <input type="text" name="advancedPair_c" class="input_setting_text" value="5e-05"/>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('advancedPair_setting').style.display='none';JavaScript:advancedPair_radio(advancedPair_a.value,advancedPair_o.value,advancedPair_n.value,advancedPair_N.value,advancedPair_c.value)"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('advancedPair_setting').style.display='none'"/>
                      </div>
                  </div>

                  <div class="blacktop_1">Analysis mode</div>
                  <div class="blackdown_1">
                      <input type="radio" name="analysisMode" class="analysisMode_default" id="analysisMode_default" value="1" checked="true" onclick="document.getElementById('analysisMode_setting').style.display='none';document.getElementById('analysisMode_radio').style.visibility='hidden'";/>default
                      <input type="radio" name="analysisMode" class="analysisMode_set" id="analysisMode_set" value="2" onclick="document.getElementById('analysisMode_setting').style.display='block'";/>set parameters by yourself
                      <div id="analysisMode_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="analysisMode_setting" style="display:none;">
                      <div class="inputOption_setting_center" id="analysisMode_setting_center" style="overflow-y:scroll; ">
                          maximum edit distance if the value is integer, or the fraction of missing alignments given 2% uniform base error rate if float. In the latter case, the maximum edit distance is automatically chosen for different read lengths.<br>
                          <h6>aln -n; default=0.04</h6>
                          <input type="text" name="analysisMode_n" class="input_setting_text" value="0.04"/>
                          maximum number or gap openings<br>
                          <h6>aln -o; default=1</h6>
                          <input type="text" name="analysisMode_o" class="input_setting_text" value="1"/>
                          maximum number of gap extensions<br>
                          <h6>aln -e; -1 disables long gaps and invokes k-difference mode; default=-1</h6>
                          <input type="text" name="analysisMode_e" class="input_setting_text" value="-1"/>
                          do not put an indel within this many bp towards the ends<br>
                          <h6>aln -i; default=5</h6>
                          <input type="text" name="analysisMode_i" class="input_setting_text" value="5"/>
                          maximum occurrences for extending a long deletion<br>
                          <h6>aln -d; default=10</h6>
                          <input type="text" name="analysisMode_d" class="input_setting_text" value="10"/>
                          seed length<br>
                          <h6>aln -l; default=32</h6>
                          <input type="text" name="analysisMode_l" class="input_setting_text" value="32"/>
                          maximum differences in the seed<br>
                          <h6>aln -k; default=2</h6>
                          <input type="text" name="analysisMode_k" class="input_setting_text" value="2"/>
                          maximum entries in the queue<br>
                          <h6>aln -m; default=2000000</h6>
                          <input type="text" name="analysisMode_m" class="input_setting_text" value="2000000"/>
                          mismatch penalty<br>
                          <h6>aln -M; default=3</h6>
                          <input type="text" name="analysisMode_M" class="input_setting_text" value="3"/>
                          gap open penalty<br>
                          <h6>aln -O; default=11</h6>
                          <input type="text" name="analysisMode_O" class="input_setting_text" value="11"/>
                          gap extension penalty<br>
                          <h6>aln -E; default=4</h6>
                          <input type="text" name="analysisMode_E" class="input_setting_text" value="4"/>
                          stop searching when there are more than this value of equally best hits<br>
                          <h6>aln -R; default=30</h6>
                          <input type="text" name="analysisMode_R" class="input_setting_text" value="30"/>
                          quality threshold for read trimming down to 35bp<br>
                          <h6>aln -q; default=0</h6>
                          <input type="text" name="analysisMode_q" class="input_setting_text" value="0"/>
                          length of barcode<br>
                          <h6>aln -B; optional parameter</h6>
                          <input type="text" name="analysisMode_B" class="input_setting_text"/>
                          log-scaled gap penalty for long deletions<br>
                          <h6>aln -L; optional parameter</h6>
                          <input type="text" name="analysisMode_L" class="input_setting_text"/>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('analysisMode_setting').style.display='none';JavaScript:analysisMode_radio(analysisMode_n.value,analysisMode_o.value,analysisMode_e.value,analysisMode_i.value,analysisMode_d.value,analysisMode_l.value,analysisMode_k.value,analysisMode_m.value,analysisMode_M.value,analysisMode_O.value,analysisMode_E.value,analysisMode_R.value,analysisMode_q.value,analysisMode_B.value,analysisMode_L.value)"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('analysisMode_setting').style.display='none'"/>
                      </div>
                  </div>
              </div>
              <input type="submit" value="Execute" class="Execute_btn" id="btn_BWA"/>
              <div id="wait_BWA" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
        </form>
          <div id="detail_text_1" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(1);" style="text-decoration: none;color:#666666">click here</a>.
              And the result will be sent to you by email as soon as possible.
          </div>
          <div id="detail_1" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                   <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_1').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div id="citation_bwa" class="citation">
              Li, H., & Durbin, R. (2010). Fast and accurate long-read alignment with burrows–wheeler transform. Bioinformatics, 25(5), 1754-1760.
          </div>
    </div>
      <!------------------------Bowtie-------------------------------------------------------------->
      <div id="side_right_2" class="side_right" style="display:none">
<div class="link" onclick="JavaScript:nece_opt_show_Bowtie_ne();"style="cursor:hand;">
  <div class="arrow-down" id="arrow-down14" style="display:block"></div>
  <div class="arrow-right" id="arrow-right14" style="display:none"></div>
  Necessary parameter
</div>
          <form action="Bowtie_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_Bowtie').style.backgroundColor='#666666';document.getElementById('wait_Bowtie').style.display='block';">
              <div id="necessary_center_bowtie"  class="necessary_center" style="display:block">
                  <div class="blacktop_1">
                      Choose the library type
                  </div>
                  <div class="blackdown_1">
                      <input type="radio" name="type" class="Bowtie_single" id="Bowtie_single" value="1"checked="true" onclick="document.getElementById('file-box_bowtie_reads_single').style.display='block';document.getElementById('file-box_bowtie_reads_pair').style.display='none';document.getElementById('bowtie_best').style.display='block';document.getElementById('bowtie_best_down').style.display='block';" />Single-end
                      <input type="radio" name="type" class="Bowtie_pair" id="Bowtie_pair" value="2" onclick="document.getElementById('file-box_bowtie_reads_pair').style.display='block';document.getElementById('file-box_bowtie_reads_single').style.display='none';document.getElementById('bowtie_best').style.display='none';document.getElementById('bowtie_best_down').style.display='none';" />Paired-end
                  </div>
                  <div class="blacktop_1">
                      Select reference to build index or use a built-in index
                      <div class="tip_out"><img class="tip" id="tip3" src="./img/tip.png" onclick="JavaScript:Tip_click(3)"></div>
                      <s:fielderror fieldName="input_re_bowtie" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div id="blackdown_2_bowtie">
                      <input type="radio" name="refer_index_bowtie" id="Bowtie_refer_index_1" value="1" checked="true" onclick="document.getElementById('file-box_tools_refer').style.display='block';document.getElementById('built_in_bowtie').style.display='none';document.getElementById('bowtie_index_build').style.display='block';"/>Select reference to build index
                      <input type="radio" name="refer_index_bowtie" id="Bowtie_refer_index_2" value="2" onclick="document.getElementById('file-box_tools_refer').style.display='none';document.getElementById('built_in_bowtie').style.display='block';document.getElementById('bowtie_index_build').style.display='none';"/>Use a built-in index
                      <div class="file-box" id="file-box_tools_refer" style="display:block">
                          <input type='text' name='input_re_bowtie' id='input_re_bowtie' class='input_text' />
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie" class="fileField" id="fileField_bowtie_re" onchange="document.getElementById('input_re_bowtie').value=this.value;fileChange(this,'input_re_bowtie');" />
                      </div>
                      <div id="bowtie_index_build" style="display:block">
                          whether set bowtie-build options?<br>
                          <input type="radio" value="1" name="bowtie_option_radio" onclick="document.getElementById('bowtie_build_option').style.display='none';document.getElementById('bowtie_index_radio').style.visibility='hidden'"/>No
                          <input type="radio" value="2" name="bowtie_option_radio" onclick="document.getElementById('bowtie_build_option').style.display='block'"/>Yes
                          <div id="bowtie_index_radio" class="radio_text"></div>
                      </div>
                      <div id="bowtie_build_option" class="inputOption_setting" style="display:none;z-index:999">
                          <div class="inputOption_setting_center" style="overflow-y:scroll; ">
                              Disable the default behavior whereby bowtie-build automatically selects values for the --bmax, --dcv and --packed parameters according to available memory.<br>
                              <h6>default:off</h6>
                              <input type="radio" name="bowtie_noauto" value="1" checked="true" onclick="document.getElementById('build_option_on'.style.display='none')">Off
                              <input type="radio" name="bowtie_noauto" value="2" onclick="document.getElementById('build_option_on'.style.display='block')">On
                              <br>   Disable use of the difference-cover sample. Suffix sorting becomes quadratic-time in the worst case (where the worst case is an extremely repetitive reference).<br>
                              <h6>--nodc ;Default: off.</h6>
                              <input type="radio" name="bowtie_nodc" value="1" checked="true"/>Off
                              <input type="radio" name="bowtie_nodc" value="2" />On
                              <br> Build only the NAME.3.ebwt and NAME.4.ebwt portions of the index, which contain a bitpacked version of the reference sequences and are used for paired-end alignment.
                              <h6>--justref ;Default: off.</h6>
                              <input type="radio" value="1" name="bowtie_justref" checked="true">Off
                              <input type="radio" value="2" name="bowtie_justref">On
                              <br>To map alignments back to positions on the reference sequences, it's necessary to annotate ("mark") some or all of the Burrows-Wheeler rows with their corresponding location on the genome. -o/--offrate governs how many rows get marked: the indexer will mark every 2^ rows. Marking more rows makes reference-position lookups faster, but requires more memory to hold the annotations at runtime.<br>
                              <h6>-o/--offrate ;Default:5</h6>
                              <input type="text" name="bowtie_offrate" class="input_setting_text" value="5"/><br>
                              The ftab is the lookup table used to calculate an initial Burrows-Wheeler range with respect to the first characters of the query. A larger yields a larger lookup table but faster query times.<br>
                              <h6>-t/--ftabchars ; The default setting is 10 (ftab is 4MB).</h6>
                              <input type="text" name="bowtie_t" class="input_setting_text" value="10"/><br>
                              Convert Ns in the reference sequence to As before building the index.<br>
                              <h6>--ntoa By default, Ns are simply excluded from the index and bowtie will not report alignments that overlap them.</h6>
                              <input type="radio" value="1" name="bowtie_ns"  checked="true">Off
                              <input type="radio" value="2" name="bowtie_ns">On<br>
                              <input type="button" name="bowtie_index_submit" value="submit" class="btn_submit" onclick="document.getElementById('bowtie_build_option').style.display='none';JavaScript:bowtie_index_radio(bowtie_nodc.value,bowtie_justref.value,bowtie_offrate.value,bowtie_t.value,bowtie_ns.value);"/>
                              <input type="button" name="bowtie_index_submit" value="cancel" class="btn_cancel" onclick="document.getElementById('bowtie_build_option').style.display='none';"/>
                          </div>
                      </div>

                      <div class="built_in" id="built_in_bowtie" style="display: none;">
                          <select name="built_in_bowtie" class="gomo_select"/>
                          <option value="1" selected="selected">Human(b37) hg19</option>
                          <option value="2">Human(b37) hg38</option>
                          </select><br>
                      </div>
                  </div>

                  <div class="blacktop_1">
                      Select reads file
                      <div class="tip_out"><img class="tip" id="tip4" src="./img/tip.png" onclick="JavaScript:Tip_click(4)"></div>
                      <s:fielderror fieldName="input_reads_bowtie" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                      <s:fielderror fieldName="input_reads_pair1_bowtie" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box"  id="file-box_bowtie_reads_single" style="display:block;">
                          <input type="text" name="input_reads_bowtie"  class="input_text" id="input_reads_bowtie"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie" class="fileField" id="fileField_bowtie_read" onchange="document.getElementById('input_reads_bowtie').value=this.value;fileChange(this,'input_reads_bowtie');" />
                      </div>
                      <div class="file-box" id="file-box_bowtie_reads_pair" style="display:none;">
                          <input type="text" name="input_reads_pair1_bowtie"  class="input_text_pair" id="input_reads_pair1_bowtie"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie" class="fileField_pair1" onchange="document.getElementById('input_reads_pair1_bowtie').value=this.value;fileChange(this,'input_reads_pair1_bowtie');" />
                          <input type="text" name="input_reads_pair2_bowtie"  class="input_text_pair" id="input_reads_pair2_bowtie"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie" class="fileField" onchange="document.getElementById('input_reads_pair2_bowtie').value=this.value;fileChange(this,'input_reads_pair2_bowtie');" />
                      </div>
                  </div>
              </div>

              <div class="link" onclick="JavaScript:nece_opt_show_Bowtie_op();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right15" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down15" style="display:block"></div>
                  Optional parameter
              </div>
              <div id="optional_center_bowtie" class="optional_center" style="display:block;overflow-y:scroll">
                  <div class="blacktop_1">Input options</div>
                  <div class="blackdown_1">
                      <input type="radio" name="inputOption_bowtie_mode"  id="inputOption_bowtie_n" value="1"  onclick="document.getElementById('bowtie_v').style.display='none';document.getElementById('bowtie_n').style.display='block';document.getElementById('bowtie_mode_v_radio').style.visibility='none'"/>n mode
                      <div id="bowtie_mode_n_radio" class="radio_text"></div>
                      <input type="radio" name="inputOption_bowtie_mode"  id="inputOption_bowtie_v" value="2" onclick="document.getElementById('bowtie_v').style.display='block';document.getElementById('bowtie_n').style.display='none';document.getElementById('bowtie_mode_n_radio').style.visibility='none'"/>v mode
                      <div id="bowtie_mode_v_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="bowtie_n" style="display:none;">
                      <div class="inputOption_setting_center" id="bowtie_n_center" style="overflow-y:scroll; ">
                          Alignments may have no more than N mismatches (where N is a number 0-3, set with -n) <br>
                          <h6>-n; default=2.</h6>
                          <input type="text" name="bowtie_mode_n" class="input_setting_text" value="2"/><br>
                          L is a number 5 or greater, set with -l on the high-quality (left) end of the read. The first L bases are called the "seed".<br>
                          <h6>-l;more than 5.</h6>
                          <input type="text" name="bowtie_mode_l" class="input_setting_text" value="5"/><br>
                          The sum of the Phred quality values at all mismatched positions (not just in the seed) may not exceed E (set with -e).<br>
                          <h6>-e;the Phred quality defaults to 40</h6>
                          <input type="text" name="bowtie_mode_e" class="input_setting_text" value="40"/><br>
                          The maximum number of backtracks permitted when aligning a read in -n 2 or -n 3 mode<br>
                          <h6>--maxbts ;default: 125 without --best, 800 with --best</h6>
                          <input type="text" name="bowtie_maximun" class="input_setting_text" value="125"/><br>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('bowtie_n').style.display='none';JavaScript:bowtie_mode_n_radio(bowtie_mode_n.value,bowtie_mode_l.value,bowtie_mode_e.value,bowtie_maximun.value)"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('bowtie_n').style.display='none'"/>
                      </div>
                  </div>
                  <div class="inputOption_setting" id="bowtie_v" style="display:none">
                      <div class="inputOption_setting_center" id="bowtie_v_center" style="overflow-y:scroll;">
                          In -v mode, alignments may have no more than V mismatches, where V may be a number from 0 through 3 set using the -v option. Quality values are ignored.<br>
                          <h6>default:2</h6>
                          <input type="text" name="bowtie_mode_v" class="input_setting_text" value="2"/><br>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('bowtie_v').style.display='none';JavaScript:bowtie_mode_v_radio(bowtie_mode_v.value);"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('bowtie_v').style.display='none'"/>
                      </div>
                  </div>

                  <div class="blacktop_1" id="bowtie_best" checked="true" style="display:none">Whether set --best/--strata or not?</div>
                  <div class="blackdown_1" id="bowtie_best_down" style="display:none">
                      <input type="radio" name="bowtie_best" value="1"/>No
                      <input type="radio" name="bowtie_best" value="2"/>Yes
                  </div>

                  <div class="blacktop_1">Input Options</div>
                  <div class="blackdown_1">
                      <input type="radio" value="1" checked="true" name="bowtie_inputoption" onclick="document.getElementById('bowtie_inputoption').style.display='none';document.getElementById('bowtie_input_radio').style.visibility='hidden'" />default
                      <input type="radio" value="2" name="bowtie_inputoption" onclick="document.getElementById('bowtie_inputoption').style.display='block'"/>Setting by yourself
                      <div id="bowtie_input_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="bowtie_inputoption" style="display:none">
                      <div class="inputOption_setting_center" style="overflow-y:scroll;">
                          Skip (i.e. do not align) the first s reads or pairs in the input.
                          <h6>-s/--skip s ;default:0</h6>
                          <input type="text" name="bowtie_s" class="input_setting_text" value="0"/><br>
                          Only align the first u reads or read pairs from the input (after the -s/--skip reads or pairs have been skipped). <br>
                          <h6>-u/--qupto ;Default: no limit.</h6>
                          <input type="text" name="bowtie_u" class="input_setting_text" value="100000000"/><br>
                          Trim the bases from high-quality (left) end of each read before alignment <br>
                          <h6>-5/--trim5 ;default: 0</h6>
                          <input type="text" name="bowtie_5" class="input_setting_text" value="0"/><br>
                          Trim the bases from low-quality (right) end of each read before alignment <br>
                          <h6>-3/--trim3 ;default: 0</h6>
                          <input type="text" name="bowtie_3" class="input_setting_text" value="0"/><br>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('bowtie_inputoption').style.display='none';JavaScript:bowtie_input_radio(bowtie_s.value,bowtie_u.value,bowtie_5.value,bowtie_3.value);"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('bowtie_inputoption').style.display='none'"/>
                      </div>
                  </div>

                  <div class="blacktop_1">Alignment Options</div>
                  <div class="blackdown_1">
                      <input type="radio" value="1" checked="true" name="bowtie_alignment_radio" onclick="document.getElementById('bowtie_alignment').style.display='none';document.getElementById('bowtie_alignment_radio').style.visibility='hidden';"/>default
                      <input type="radio" value="2" name="bowtie_alignment_radio" onclick="document.getElementById('bowtie_alignment').style.display='block'"/>Setting by yourself
                      <div id="bowtie_alignment_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="bowtie_alignment" style="display:none">
                      <div class="inputOption_setting_center" style="overflow-y:scroll;">
                          Maq accepts quality values in the Phred quality scale, but internally rounds values to the nearest 10, with a maximum of 30.<br>
                          <h6>By default, bowtie also rounds --nomaqround. --nomaqround prevents this rounding in bowtie.</h6>
                          <input type="radio" value="1" name="bowtie_nomaqround" checked="true">Off
                          <input type="radio" value="2" name="bowtie_nomaqround">On
                          <br>The minimum insert size for valid paired-end alignments. E.g. if -I 60 is specified and a paired-end alignment consists of two 20-bp alignments in the appropriate orientation with a 20-bp gap between them, that alignment is considered valid (as long as -X is also satisfied). A 19-bp gap would not be valid in that case. If trimming options -3 or -5 are also used, the -I constraint is applied with respect to the untrimmed mates.<br>
                          <h6>-I/--minins ;Default: 0.</h6>
                          <input type="text" name="bowtie_I" class="input_setting_text" value="0"/><br>
                          The maximum insert size for valid paired-end alignments. E.g. if -X 100 is specified and a paired-end alignment consists of two 20-bp alignments in the proper orientation with a 60-bp gap between them, that alignment is considered valid (as long as -I is also satisfied). A 61-bp gap would not be valid in that case. If trimming options -3 or -5 are also used, the -X constraint is applied with respect to the untrimmed mates, not the trimmed mates.<br>
                          <h6>-X/--maxins ;Default: 250.</h6>
                          <input type="text" name="bowtie_X" class="input_setting_text" value="250"/><br>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('bowtie_alignment').style.display='none';JavaScript:bowtie_alignment_radio(bowtie_nomaqround.value,bowtie_I.value,bowtie_X.value);"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('bowtie_alignment').style.display='none';"/>
                      </div>
                  </div>

                  <div class="blacktop_1">Reporting Options</div>
                  <div class="blackdown_1">
                      <input type="radio" value="1" checked="true" onclick="document.getElementById('bowtie_report').style.display='none';document.getElementById('bowtie_report_radio').style.visibility='hidden';"/>default
                      <input type="radio" value="2" onclick="document.getElementById('bowtie_report').style.display='block'"/>Setting by yourself
                      <div id="bowtie_report_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="bowtie_report" style="display:none">
                      <div class="inputOption_setting_center" style="overflow-y:scroll;">
                          Report up to k valid alignments per read or pair <br>
                          <h6>-k ;default: 1 </h6>
                          <input type="text" name="bowtie_k" class="input_setting_text" value="1"/><br>
                          Report all valid alignments per read or pair <br>
                          <h6>-a/--all ;default: off.</h6>
                          <input type="radio" name="bowtie_a" value="1"/>Off
                          <input type="radio" name="bowtie_a" value="2"/>on<br>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('bowtie_report').style.display='none';JavaScript:bowtie_report_radio(bowtie_k.value,bowtie_a.value);"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('bowtie_report').style.display='none'"/>
                      </div>
                  </div>
              </div>

              <input type="submit" value="Execute" class="Execute_btn" id="btn_Bowtie"/>
              <div id="wait_Bowtie" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
        </form>
          <div id="detail_text_2" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(2);" style="text-decoration: none;color:#666666">click here</a>.
              And the result files will be sent to you by email as soon as possible.
          </div>
          <div id="detail_2" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_2').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div class="citation">
              Langmead, B. (2010). Aligning short sequencing reads with bowtie. , Chapter 11(Unit 11.17), Unit 11.7.
          </div>
      </div>
      <!------------------------Bowtie2-------------------------------------------------------------->
      <div id="side_right_3" class="side_right" style="display:none">
<div class="link" onclick="JavaScript:nece_opt_show_ne();"style="cursor:hand;">
  <div class="arrow-down" id="arrow-down1" style="display:block"></div>
  <div class="arrow-right" id="arrow-right1" style="display:none"></div>
  Necessary parameter</div>
          <form action="Bowtie2_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_Bowtie2').style.backgroundColor='#666666';document.getElementById('wait_Bowtie2').style.display='block';">
              <div id="necessary_center_bowtie2" class="necessary_center"style="display:block">
                  <div class="blacktop_1">
                      Choose the library type
                      <s:fielderror fieldName="type" cssStyle="color:red;float:right;margin-top:0px;"  />
                  </div>
                  <div class="blackdown_1">
                      <input type="radio" name="type" class="Bowtie2_single" id="Bowtie2_single" value="1" checked="true" onclick="document.getElementById('file-box_tools_reads_single').style.display='block';document.getElementById('file-box_tools_reads_pair').style.display='none'"; />Single-end
                      <input type="radio" name="type" class="Bowtie2_pair" id="Bowtie2_pair" value="2" onclick="document.getElementById('file-box_tools_reads_pair').style.display='block';document.getElementById('file-box_tools_reads_single').style.display='none'"; />Paired-end
                  </div>
                  <div class="blacktop_1">
                      Select reference to build index
                      <div class="tip_out"><img class="tip" id="tip5" src="./img/tip.png" onclick="JavaScript:Tip_click(5)"></div>
                      <s:fielderror fieldName="input_re" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_2_bowtie2">
                      <input type="radio" name="refer_index" id="Bowtie2_refer_index_1" value="1" checked="true" onclick="document.getElementById('bowtie2_select').style.display='none';document.getElementById('bowtie2_reference_box').style.display='block';"/>Select reference to build index
                      <input type="radio" name="refer_index" id="Bowtie2_refer_index_2" value="2" onclick="document.getElementById('bowtie2_select').style.display='block';document.getElementById('bowtie2_reference_box').style.display='none';" />Use a built-in index
                      <div class="file-box" id="bowtie2_reference_box">
                          <input type='text' name='input_re' id='input_re' class='input_text' />
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie2" class="fileField" id="fileField_bowtie2_re" onchange="document.getElementById('input_re').value=this.value;fileChange(this,'input_re');" />
                      </div>
                      <div class="bowtie2_select" id="bowtie2_select" style="display: none;">
                          <select name="bowtie2_select_index" class="gomo_select"/>
                          <option value="1" selected="selected">Human(b37) hg19</option>
                          <option value="2">Human(b37) hg38</option>
                          </select><br>
                      </div>
                  </div>
                  <div class="blacktop_1">
                      Select reads file
                      <div class="tip_out"><img class="tip" id="tip6" src="./img/tip.png" onclick="JavaScript:Tip_click(6)"></div>
                      <s:fielderror fieldName="input_reads" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                      <s:fielderror fieldName="input_reads_pair1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box"  id="file-box_tools_reads_single" style="display:block;">
                          <input type="text" name="input_reads"  class="input_text" id="input_reads"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie2" class="fileField" id="fileField_bowtie2_read" onchange="document.getElementById('input_reads').value=this.value;fileChange(this,'input_reads');" />
                      </div>
                      <div class="file-box" id="file-box_tools_reads_pair" style="display:none;">
                          <input type="text" name="input_reads_pair1"  class="input_text_pair" id="input_reads_pair1"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie2" class="fileField_pair1" id="fileField_bowtie2_pair1" onchange="document.getElementById('input_reads_pair1').value=this.value;fileChange(this,'input_reads_pair1');" />
                          <input type="text" name="input_reads_pair2"  class="input_text_pair" id="input_reads_pair2"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_bowtie2" class="fileField_pair2" id="fileField_bowtie2_pair2" onchange="document.getElementById('input_reads_pair2').value=this.value;fileChange(this,'input_reads_pair2');" />
                      </div>
                  </div>
              </div>
              <div class="link"onclick="JavaScript:nece_opt_show_op();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right2" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down2" style="display:block"></div>
                  Optional parameter</div>
              <div id="optioanl_center_bowtie2" class="optional_center" style="display:block">
                  <div class="blacktop_1">Input options</div>
                  <div class="blackdown_1">
                      <input type="radio" name="inputOption" class="inputOption_default" id="inputOption_default" value="1" checked="true" onclick="document.getElementById('inputOption_setting').style.display='none';document.getElementById('optional_radio_input').style.visibility='hidden'";/>default
                      <input type="radio" name="inputOption" class="inputOption_set" id="inputOption_set" value="2" onclick="document.getElementById('inputOption_setting').style.display='block';"/>set parameters by yourself
                      <div id="optional_radio_input" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="inputOption_setting" style="display:none;">
                      <div class="inputOption_setting_center"  style="overflow-y:scroll; ">
                          Skip the first that many reads or pairs in the input<br>
                          <h6>-s/--skip; default=0</h6>
                          <input type="text" name="setting_skip" class="input_setting_text" value="0"/><br>
                          Align the first that many reads or read pairs from the input then stop<br>
                          <h6>-u/--qupto; for default behavior (no limit) leave this value very large</h6>
                          <input type="text" name="setting_u" class="input_setting_text" value="100000000"/><br>
                          Trim that many bases from 5' (left) end of each read before alignment<br>
                          <h6>-5/--trim5; default=0</h6>
                          <input type="text" name="setting_trim5" class="input_setting_text" value="0"/><br>
                          Trim that many bases from 3' (right) end of each read before alignment<br>
                          <h6>-3/--trim3; default=0</h6>
                          <input type="text" name="setting_trim3" class="input_setting_text" value="0"/><br>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('inputOption_setting').style.display='none';JavaScript:optional_radio_input(setting_skip.value,setting_u.value,setting_trim5.value,setting_trim3.value);"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('inputOption_setting').style.display='none'"/>
                      </div>
                  </div>
                  <div class="blacktop_1">Alignment options</div>
                  <div class="blackdown_1">
                      <input type="radio" name="alignmentOption" class="alignmentOption_default" id="alignmentOption_default" value="1" checked="true" onclick="document.getElementById('alignmentOption_setting').style.display='none';document.getElementById('alignment_radio').style.visibility='hidden'";/>default
                      <input type="radio" name="alignmentOption" class="alignmentOption_set" id="alignmentOption_set" value="2" onclick="document.getElementById('alignmentOption_setting').style.display='block'";/>set parameters by yourself
                      <div id="alignment_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="alignmentOption_setting" style="display:none;">
                      <div class="inputOption_setting_center" id="alignmentOption_setting_center" style="overflow-y:scroll; ">
                          Set the number of mismatches to be allowed in a seed alignment during multiseed alignment<br>
                          <h6>-N; Can be set to 0 or 1. Setting this higher makes alignment slower (often much slower) but increases sensitivity; default=0</h6>
                          <select name="alignment_N" class="GOMo_select"/>
                          <option value="0" selected="selected">0</option>
                          <option value="1">1</option>
                          </select><br>
                          Sets the length of the seed substrings to align during multiseed alignment<br>
                          <h6>-L; Smaller values make alignment slower but more sensitive. Default=22</h6>
                          <input type="text" name="alignment_L" class="input_setting_text" value="22"/>
                          Set a function governing the interval between seed substrings to use during multiseed alignment.Also see description of this option below in the help section.<br>
                          <h6>-i;Default=`S,1,1.15`</h6>
                          <input type="text" name="alignment_i"class="input_setting_text" value="S,1,1.15"/>
                          Set a function governing the maximum number of ambiguous characters (usually `N`s and/or `.`s) allowed in a read as a function of read length.<br>
                          <h6>--n-ceil;Default=`L,0,0.15`</h6>
                          <input type="text" name="alignment_n"class="input_setting_text" value="L,0,0.15"/>
                          Pad dynamic programming problems by that many columns on either side to allow gaps.
                          <h6>--dpad; default=15</h6>
                          <input type="text" name="alignment_dpad"class="input_setting_text" value="15"/>
                          Disallow gaps within that many positions of the beginning or end of the read
                          <h6>--gbar; default=4</h6>
                          <input type="text" name="alignment_gbar"class="input_setting_text" value="4"/>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('alignmentOption_setting').style.display='none';JavaScript:alignment_radio(alignment_N.value,alignment_L.value,alignment_i.value,alignment_n.value,alignment_dpad.value,alignment_gbar.value)"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('alignmentOption_setting').style.display='none'"/>
                      </div>
                  </div>
                  <div class="blacktop_1">Scoring options</div>
                  <div class="blackdown_1">
                      <input type="radio" name="scoreOption" class="scoreOption_default" id="scoreOption_default" value="1" checked="true" onclick="document.getElementById('scoreOption_setting').style.display='none';document.getElementById('score_radio').style.visibility='hidden'";/>default
                      <input type="radio" name="scoreOption" class="scoreOption_set" id="scoreOption_set" value="2" onclick="document.getElementById('scoreOption_setting').style.display='block'";/>set parameters by yourself
                      <div id="score_radio" class="radio_text"></div>
                  </div>
                  <div class="inputOption_setting" id="scoreOption_setting" style="display:none;">
                      <div class="inputOption_setting_center" id="scoreOption_setting_center" style="overflow-y:scroll; ">
                          Set the match bonus<br>
                          <h6>--ma; Default=2</h6>
                          <input type="text" name="score_ma" class="input_setting_text" value="2"/>
                          Set the maximum (`MX`) and minimum (`MN`) mismatch penalties, both integers<br>
                          <h6>--mp;Default=6,2</h6>
                          <input type="text" name="score_mp" class="input_setting_text" value="6,2"/>
                          Sets penalty for positions where the read, reference, or both, contain an ambiguous character such as `N`<br>
                          <h6>--np; Default=1</h6>
                          <input type="text" name="score_np" class="input_setting_text" value="1"/>
                          Set the read gap opening penalty<br>
                          <h6>--rdg; this is the first component of --rdg flag - opening penalty; Default=5</h6>
                          <input type="text" name="score_rdg5" class="input_setting_text" value="5"/>
                          Set the read gap extension penalty<br>
                          <h6>--rdg; this is the second component of --rdg flag - extension penalty; Default=3</h6>
                          <input type="text" name="score_rdg3" class="input_setting_text" value="3"/>
                          Set the reference gap opening penalty<br>
                          <h6> --rfg; this is the first component of --rfg flag - opening penalty; Default=5</h6>
                          <input type="text" name="score_rfg5" class="input_setting_text" value="5"/>
                          Set the reference gap extension penalty<br>
                          <h6>--rfg; this is the second component of --rfg flag - extension penalty; Default=3</h6>
                          <input type="text" name="score_rfg3" class="input_setting_text" value="3"/>
                          <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('scoreOption_setting').style.display='none';JavaScript:score_radio(score_ma.value,score_mp.value,score_np.value,score_rdg5.value,score_rdg3.value,score_rfg5.value,score_rfg3.value)"/>
                          <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('scoreOption_setting').style.display='none'"/>
                      </div>
                  </div>
              </div>
              <input type="submit" value="Execute" class="Execute_btn" id="btn_Bowtie2"/>
              <div id="wait_Bowtie2" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
        </form>
          <div id="detail_text_3" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(3);" style="text-decoration: none;color:#666666">click here</a>.
              And the result files will be sent to you by email as soon as possible.
          </div>
          <div id="detail_3" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_3').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div class="citation">
              Langmead, B., & Salzberg, S. L. (2012). Fast gapped-read alignment with bowtie 2. Nature Methods, 9(4), 357.
          </div>
      </div>
        <!------------------------SOAP-------------------------------------------------------------->
        <div id="side_right_4" class="side_right" style="display:none">
            <div class="link" onclick="JavaScript:nece_opt_show_SOAP_ne();"style="cursor:hand;">
                <div class="arrow-down" id="arrow-down30" style="display:block"></div>
                <div class="arrow-right" id="arrow-right30" style="display:none"></div>
                Necessary parameter</div>
            <form action="SOAP_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_SOAP').style.backgroundColor='#666666';document.getElementById('wait_SOAP').style.display='block';">
                <div id="necessary_center_SOAP" class="necessary_center" style="display:block" style="overflow-y:scroll; ">
                    <div class="blacktop_1">Choose the library type</div>
                    <div class="blackdown_1">
                        <input id="SOAP_single"  name="SOAP_type" type="radio" value="1" checked="true" onclick="document.getElementById('file-box_SOAP_single').style.display='block';document.getElementById('file-box_SOAP_paired').style.display='none';"/>Single-end
                        <input id="SOAP_pair" name="SOAP_type" type="radio" value="2" onclick="document.getElementById('file-box_SOAP_single').style.display='none';document.getElementById('file-box_SOAP_paired').style.display='block';" />Paired-end
                    </div>
                    <div class="blacktop_1">
                        Select reference to build index or use a built-in index
                        <div class="tip_out"><img class="tip" id="tip7" src="./img/tip.png" onclick="JavaScript:Tip_click(7)"></div>
                        <s:fielderror fieldName="input_SOAP_reference" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_2_bowtie2">
                        <input type="radio" name="refer_index_SOAP"  value="1" checked="true" onclick="document.getElementById('file-box_SOAP_refer').style.display='block';document.getElementById('built_in_SOAP').style.display='none';"/>Select reference to build index
                        <input type="radio" name="refer_index_SOAP"  value="2" onclick="document.getElementById('file-box_SOAP_refer').style.display='none';document.getElementById('built_in_SOAP').style.display='block'"/>Use a built-in index
                        <div class="file-box" id="file-box_SOAP_refer" style="display:block">
                            <input type="text" name="input_SOAP_reference"  class="input_text" id="input_SOAP_reference"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_soap" class="fileField" id="fileField_soap_re" onchange="document.getElementById('input_SOAP_reference').value=this.value;fileChange(this,'input_SOAP_reference');" />
                        </div>
                        <div class="built_in" id="built_in_SOAP" style="display: none;">
                            <select name="built_in_SOAP" class="gomo_select"/>
                            <option value="1" selected="selected">Human(b37) hg19</option>
                            <option value="2">Human(b37) hg38</option>
                            </select><br>
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Select reads file
                        <div class="tip_out"><img class="tip" id="tip8" src="./img/tip.png" onclick="JavaScript:Tip_click(8)"></div>
                        <s:fielderror fieldName="input_SOAP_reads_single" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                        <s:fielderror fieldName="input_SOAP_reads_pair1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box" id="file-box_SOAP_single" style="display:block;">
                            <input type="text" name="input_SOAP_reads_single" class="input_text" id="input_SOAP_reads_single"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_soap" class="fileField" id="fileField_soap_read" onchange="document.getElementById('input_SOAP_reads_single').value=this.value;fileChange(this,'input_SOAP_reads_single');" />
                        </div>
                        <div class="file-box" id="file-box_SOAP_paired" style="display:none;">
                            <input type="text" name="input_SOAP_reads_pair1" class="input_text_pair" id="input_SOAP_reads_pair1"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_soap" class="fileField_pair1" id="fileField_soap_pair1" onchange="document.getElementById('input_SOAP_reads_pair1').value=this.value;fileChange(this,'input_SOAP_reads_pair1');" />
                            <input type="text" name="input_SOAP_reads_pair2" class="input_text_pair" id="input_SOAP_reads_pair2"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_soap" class="fileField_pair2" id="fileField_soap_pair2" onchange="document.getElementById('input_SOAP_reads_pair2').value=this.value;fileChange(this,'input_SOAP_reads_pair2');" />
                        </div>
                    </div>
                </div>
                <div class="link" onclick="JavaScript:nece_opt_show_SOAP_op();"style="cursor:hand;">
                    <div class="arrow-down" id="arrow-down31" style="display:block"></div>
                    <div class="arrow-right" id="arrow-right31" style="display:none"></div>
                    Optional parameter</div>
                <div id="optional_center_SOAP" class="optional_center"style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_SOAP" id="optionalParameters_default_SOAP" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('optional_center_setting_SOAP').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_SOAP" id="optionalParameters_set_SOAP" class="optionalParameters_set" value="2" onclick="document.getElementById('optional_center_setting_SOAP').style.display='block'"/>set the parameters by yourself
                        <div id="SOAP_radio" class="radio_text"></div>
                    </div>
                    <div id="optional_center_setting_SOAP" class="inputOption_setting" style="display:none;">
                        <div id="optional_center_setting_SOAP_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            -M <br>
                            <h6>match mode for each read or the seed part of read, which shouldn't contain more than 2 mismaches, [4]<br>
                                0: exact match only<br>
                                1: 1 mismatch match only<br>
                                2: 2 mismatch match only<br>
                                4: find the best hits<br>
                            </h6>
                            <input type="text" name="SOAP_M" class="input_setting_text" value="4"/><br>
                            -l
                            <h6>align the initial n bps as a seed [256] means whole length of read</h6>
                            <input type="text" name="SOAP_l" class="input_setting_text" value="256"/>
                            -n
                            <h6>filter low-quality reads containing >n Ns before alignment, [5]</h6>
                            <input type="text" name="SOAP_n" class="input_setting_text" value="5"/><br>
                            -r[0,1,2]
                            <h6>how to report repeat hits, 0=none; 1=random one; 2=all, [1]</h6>
                            <input type="text" name="SOAP_r" class="input_setting_text" value="1"/>
                            -m
                            <h6>minimal insert size allowed, [400]</h6>
                            <input type="text" name="SOAP_m" class="input_setting_text" value="400"/><br>
                            -x
                            <h6>maximal insert size allowed, [600]</h6>
                            <input type="text" name="SOAP_x" class="input_setting_text" value="600"/><br>
                            -v
                            <h6>maximum number of mismatches allowed on a read. [5] bp</h6>
                            <input type="text" name="SOAP_v" class="input_setting_text" value="5"/><br>
                            -s
                            <h6>minimal alignment length (for soft clip) [255] bp</h6>
                            <input type="text" name="SOAP_s" class="input_setting_text" value="255"/><br>
                            -g
                            <h6>one continuous gap size allowed on a read. [0] bp</h6>
                            <input type="text" name="SOAP_g" class="input_setting_text" value="0"/><br>
                            -e
                            <h6>will not allow gap exist inside n-bp edge of a read, default=5</h6>
                            <input type="text" name="SOAP_e" class="input_setting_text" value="5"/><br>
                            -p
                            <h6>number of processors to use, [1]</h6>
                            <input type="text" name="SOAP_p" class="input_setting_text" value="1"/>
                            <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('optional_center_setting_SOAP').style.display='none';JavaScript:SOAP_radio(SOAP_M.value,SOAP_l.value,SOAP_n.value,SOAP_r.value,SOAP_m.value,SOAP_x.value,SOAP_v.value,SOAP_s.value,SOAP_g.value,SOAP_e.value,SOAP_p.value)"/>
                            <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('optional_center_setting_SOAP').style.display='none'"/>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Execute" class="Execute_btn" id="btn_SOAP"/>
                <div id="wait_SOAP" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
                </form>
            <div id="detail_text_4" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(4);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_4" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_4').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Li, R., Yu, C., Li, Y., Lam, T. W., Yiu, S. M., & Kristiansen, K., et al. (2009). Soap2: an improved ultrafast tool for short read alignment.Bioinformatics, 25(15), 1966-1967.
            </div>
        </div>
        <!------------------------BLAST-------------------------------------------------------------->
        <div id="side_right_5" class="side_right" style="display:none">
            <div class="link" onclick="JavaScript:nece_opt_show_blast_ne();"style="cursor:hand;">
                <div class="arrow-down" id="arrow-down32" style="display:block"></div>
                <div class="arrow-right" id="arrow-right32" style="display:none"></div>
                Necessary parameter</div>
            <form action="blast_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_Blast').style.backgroundColor='#666666';document.getElementById('wait_Blast').style.display='block';">
                <div id="necessary_center_blast" class="necessary_center" style="display:block" style="overflow-y:scroll; ">
                    <div class="blacktop_1">
                        Select the type of sequence
                        <s:fielderror fieldName="blast_type" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="radio" name="blast_type" value="1" onclick="document.getElementById('optional_center_setting_blastn').style.display='block';document.getElementById('optional_center_setting_blastp').style.display='none';"/>nucleotide
                        <input type="radio" name="blast_type" value="2" onclick="document.getElementById('optional_center_setting_blastn').style.display='none';document.getElementById('optional_center_setting_blastp').style.display='block';"/>protein
                    </div>
                    <div class="blacktop_1">
                        Select reference to build index or use a built-in index
                        <div class="tip_out"><img class="tip" id="tip9" src="./img/tip.png" onclick="JavaScript:Tip_click(9)"></div>
                        <s:fielderror fieldName="input_blast_reference" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_2_bowtie2">
                        <input type="radio" name="refer_index_blast"  value="1" checked="true" onclick="document.getElementById('file-box_blast_refer').style.display='block';document.getElementById('built_in_blast').style.display='none';"/>Select reference to build index
                        <input type="radio" name="refer_index_blast"  value="2" onclick="document.getElementById('file-box_blast_refer').style.display='none';document.getElementById('built_in_blast').style.display='block'"/>Use a built-in index
                        <div class="file-box" id="file-box_blast_refer" style="display:block">
                            <input type="text" name="input_blast_reference"  class="input_text" id="input_blast_reference"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_blast" class="fileField" id="fileField_blast_re" onchange="document.getElementById('input_blast_reference').value=this.value;fileChange(this,'input_blast_reference');" />
                        </div>
                        <div class="built_in" id="built_in_blast" style="display: none;">
                            <select name="built_in_blast" class="gomo_select"/>
                            <option value="1" selected="selected">Human(b37) hg19</option>
                            <option value="2">Human(b37) hg38</option>
                            </select><br>
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Select reads file
                        <div class="tip_out"><img class="tip" id="tip10" src="./img/tip.png" onclick="JavaScript:Tip_click(10)"></div>
                        <s:fielderror fieldName="input_blast_reads" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box" id="file-box_blast" style="display:block;">
                            <input type="text" name="input_blast_reads" class="input_text" id="input_blast_reads"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_blast" class="fileField" id="fileField_blast_read" onchange="document.getElementById('input_blast_reads').value=this.value;fileChange(this,'input_blast_reads');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:nece_opt_show_blast_op();"style="cursor:hand;">
                    <div class="arrow-down" id="arrow-down33" style="display:block"></div>
                    <div class="arrow-right" id="arrow-right33" style="display:none"></div>
                    Optional parameter</div>
                <div id="optional_center_blast" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_blast" id="optionalParameters_default_blast" class="optionalParameters_default" value="1" onclick="document.getElementById('optional_center_setting_blast').style.display='none'" checked="true"/>default
                        <input type="radio" name="optionalParameters_blast" id="optionalParameters_set_blast" class="optionalParameters_set" value="2" onclick="document.getElementById('optional_center_setting_blast').style.display='block'"/>set the parameters by yourself
                    </div>
                    <div id="optional_center_setting_blast" class="inputOption_setting" style="display:none;">
                        <div id="optional_center_setting_blast_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            num_descriptions<br>
                            <h6>default:500;Show one-line descriptions for this number of database sequences.</h6>
                            <input type="text" name="blast_num_descriptions" class="input_setting_text" value="500"/>
                            num_alignments	<br>
                            <h6>default:250;Show alignments for this number of database sequences.</h6>
                            <input type="text" name="blast_num_align" class="input_setting_text" value="250"/>
                            max_target_seqs<br>
                            <h6>default:500	Number of aligned sequences to keep.
                                Use with report formats that do not have separate definition line and alignment sections such as tabular (all outfmt > 4). Not compatible with num_descriptions or num_alignments.</h6>
                            <input type="text" name="blast_max_target_seqs" class="input_setting_text" value="500"/>
                            <div id="optional_center_setting_blastn" style="display:block">
                                word_size<br>
                                <h6>default:11;Length of initial exact match.</h6>
                                <input type="text" name="blast_word_size" class="input_setting_text" value="11"/>
                                gapopen	<br>
                                <h6>default:5;Cost to open a gap. See appendix “BLASTN reward/penalty values”.</h6>
                                <input type="text" name="blast_gapopen" class="input_setting_text" value="5"/>
                                reward	<br>
                                <h6>default:2;Reward for a nucleotide match.</h6>
                                <input type="text" name="blast_reward" class="input_setting_text" value="2"/>
                                penalty	<br>
                                <h6>default:-3;Penalty for a nucleotide mismatch.</h6>
                                <input type="text" name="blast_penalty" class="input_setting_text" value="-3"/>
                                strand<br>
                                <h6>default:both;Query strand(s) to search against database/subject. Choice of both, minus, or plus.</h6>
                                <input type="text" name="blast_strand" class="input_setting_text" value="both"/>
                                dust<br>
                                <h6>default:20 64 1;Filter query sequence with dust.</h6>
                                <input type="text" name="blast_dust" class="input_setting_text" value="20 64 1"/>
                            </div>
                            <div id="optional_center_setting_blastp" style="display:block">
                                word_size	<br>
                                <h6>default:3;Word size of initial match. Valid word sizes are 2-7.</h6>
                                <input type="text" name="blast_word_sizep" class="input_setting_text" value="3"/>
                                gapextend	<br>
                                <h6>default:1;Cost to extend a gap.</h6>
                                <input type="text" name="blast_gapextend" class="input_setting_text" value="1"/>
                                threshold	<br>
                                <h6>default:11;Minimum score to add a word to the BLAST lookup table.</h6>
                                <input type="text" name="blast_threshold" class="input_setting_text" value="11"/>
                                comp_based_stats	<br>
                                <h6>default:2;Use composition-based statistics:<br>
                                    D or d: default (equivalent to 2)<br>
                                    0 or F or f: no composition-based statistics<br>
                                    1: Composition-based statistics as in NAR 29:2994-3005, 2001<br>
                                    2 or T or t : Composition-based score adjustment as in Bioinformatics<br>
                                    21:902-911, 2005, conditioned on sequence properties<br>
                                    3: Composition-based score adjustment as in Bioinformatics 21:902-911, 2005, unconditionally<br></h6>
                                <input type="text" name="blast_comp_based_stats" class="input_setting_text" value="2"/>
                                seg<br>
                                <h6>default:no;	Filter query sequence with SEG (Format: 'yes', 'window locut hicut', or 'no' to disable).</h6>
                                <input type="text" name="blast_seg" class="input_setting_text" value="no"/>
                                soft_masking	<br>
                                <h6>default:false;Apply filtering locations as soft masks (i.e., only for finding initial matches).</h6>
                                <input type="text" name="blast_soft_masking" class="input_setting_text" value="false"/>
                                window_size	<br>
                                <h6>default:40;Multiple hits window size, use 0 to specify 1-hit algorithm.</h6>
                                <input type="text" name="blast_window_size" class="input_setting_text" value="40"/>
                            </div>
                            <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('optional_center_setting_blast').style.display='none'"/>
                            <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('optional_center_setting_blast').style.display='none'"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_Blast"/>
                <div id="wait_Blast" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_5" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(5);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_5" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_5').style.display='none'"/>
                </div>
            </div>
        </div>
        <!------------------------Subread-------------------------------------------------------------->
        <div id="side_right_6" class="side_right" style="display:none">
            <div class="link" onclick="JavaScript:nece_opt_show_Subread_ne();"style="cursor:hand;">
                <div class="arrow-down" id="arrow-down34" style="display:block"></div>
                <div class="arrow-right" id="arrow-right34" style="display:none"></div>
                Necessary parameter</div>
            <form action="Subread_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_subread').style.backgroundColor='#666666';document.getElementById('wait_subread').style.display='block';">
                <div id="necessary_center_Subread" class="necessary_center" style="display:block" style="overflow-y:scroll; ">
                    <div class="blacktop_1">Choose the library type</div>
                    <div class="blackdown_1">
                        <input id="Subread_single"  name="Subread_type" type="radio" value="1" checked="true" onclick="document.getElementById('file-box_Subread_single').style.display='block';document.getElementById('file-box_Subread_paired').style.display='none';"/>Single-end
                        <input id="Subread_pair" name="Subread_type" type="radio" value="2" onclick="document.getElementById('file-box_Subread_single').style.display='none';document.getElementById('file-box_Subread_paired').style.display='block';" />Paired-end
                    </div>
                    <div class="blacktop_1">
                        Select reference to build index or use a built-in index
                        <div class="tip_out"><img class="tip" id="tip11" src="./img/tip.png" onclick="JavaScript:Tip_click(11)"></div>
                        <s:fielderror fieldName="input_subread_reference" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_2_bowtie2">
                        <input type="radio" name="refer_index_subread"  value="1" checked="true" onclick="document.getElementById('file-box_subread_refer').style.display='block';document.getElementById('built_in_subread').style.display='none';"/>Select reference to build index
                        <input type="radio" name="refer_index_subread"  value="2" onclick="document.getElementById('file-box_subread_refer').style.display='none';document.getElementById('built_in_subread').style.display='block'"/>Use a built-in index
                        <div class="file-box" id="file-box_subread_refer" style="display:block">
                            <input type="text" name="input_subread_reference"  class="input_text" id="input_subread_reference"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_subread" class="fileField" id="fileField_subread_re" onchange="document.getElementById('input_subread_reference').value=this.value;fileChange(this,'input_subread_reference');" />
                        </div>
                        <div class="built_in" id="built_in_subread" style="display: none;">
                            <select name="built_in_subread" class="gomo_select"/>
                            <option value="1" selected="selected">Human(b37) hg19</option>
                            <option value="2">Human(b37) hg38</option>
                            </select><br>
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Select reads file
                        <div class="tip_out"><img class="tip" id="tip12" src="./img/tip.png" onclick="JavaScript:Tip_click(12)"></div>
                        <s:fielderror fieldName="input_Subread_reads_single" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                        <s:fielderror fieldName="input_Subread_reads_pair1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box" id="file-box_Subread_single" style="display:block;">
                            <input type="text" name="input_Subread_reads_single" class="input_text" id="input_Subread_reads_single"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_subread" class="fileField" id="fileField_subread_read" onchange="document.getElementById('input_Subread_reads_single').value=this.value;fileChange(this,'input_Subread_reads_single');" />
                        </div>
                        <div class="file-box" id="file-box_Subread_paired" style="display:none;">
                            <input type="text" name="input_Subread_reads_pair1" class="input_text_pair" id="input_Subread_reads_pair1"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_subread" class="fileField_pair1" id="fileField_subread_pair1" onchange="document.getElementById('input_Subread_reads_pair1').value=this.value;fileChange(this,'input_Subread_reads_pair1');" />
                            <input type="text" name="input_Subread_reads_pair2" class="input_text_pair" id="input_Subread_reads_pair2"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_subread" class="fileField_pair2" id="fileField_subread_pair2" onchange="document.getElementById('input_Subread_reads_pair2').value=this.value;fileChange(this,'input_Subread_reads_pair2');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:nece_opt_show_Subread_op();"style="cursor:hand;">
                    <div class="arrow-down" id="arrow-down35" style="display:block"></div>
                    <div class="arrow-right" id="arrow-right35" style="display:none"></div>
                    Optional parameter</div>

                <div id="optional_center_Subread" class="optional_center" style="display:block">
                    <div class="blacktop_1">Index building optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_index_Subread"  class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('optional_center_setting_Subread').style.display='none'"/>default
                        <input type="radio" name="optionalParameters__index_Subread"  class="optionalParameters_set" value="2" onclick="document.getElementById('optional_center_setting_Subread').style.display='block'"/>set the parameters by yourself
                        <div id="Subread_index_radio" class="radio_text"></div>
                    </div>
                    <div id="optional_center_setting_Subread" class="inputOption_setting" style="display:none;">
                        <div id="optional_center_setting_Subread_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            -B( indexSplit=FALSE ) <br>
                            <h6>Create one block of index. The built index will not be split into mul-
                                tiple pieces.
                            </h6>
                            <input type="radio" name="Subread_B" value="1" checked="true">on
                            <input type="radio" name="Subread_B" value="2">off<br>
                            -f< int >( TH subread )<br>
                            <h6>Specify the threshold for removing uninformative subreads (highly
                                repetitive 16bp mers). Subreads will be excluded from the index if
                                they occur more than threshold number of times in the reference
                                genome. Default value is 100.</h6>
                            <input type="text" name="Subread_f" class="input_setting_text" value="100"/><br>
                            -F( gappedIndex=FALSE )<br>
                            <h6>Build a full index for the reference genome. 16bp mers (subreads)
                                will be extracted from every position of the reference genome.</h6>
                            <input type="radio" name="Subread_F" value="1" checked="true">on
                            <input type="radio" name="Subread_F" value="2">off<br>
                            -M < int >( memory )<br>
                            <h6>Specify the Size of requested memory(RAM) in megabytes, 8000MB
                                by default.</h6>
                            <input type="text" name="Subread_M" class="input_setting_text" value="8000"/><br>
                            <input type="button" value="submit" checked="true" class="btn_submit" onclick="document.getElementById('optional_center_setting_Subread').style.display='none';JavaScript:Subread_index_radio(Subread_B.value,Subread_f.value,Subread_F.value,Subread_M.value)"/>
                            <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('optional_center_setting_Subread').style.display='none'"/>
                        </div>
                    </div>

                    <div class="blacktop_1">Alignment optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_align_Subread"  class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('optional_center_setting_align_Subread').style.display='none'"/>default
                        <input type="radio" name="optionalParameters__align_Subread"  class="optionalParameters_set" value="2" onclick="document.getElementById('optional_center_setting_align_Subread').style.display='block'"/>set the parameters by yourself
                        <div id="Subread_align_radio" class="radio_text"></div>
                    </div>
                    <div id="optional_center_setting_align_Subread" class="inputOption_setting" style="display:none;">
                        <div id="optional_center_setting_align_Subread_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            -B < int >( nBestLocations )<br>
                            <h6>Specify the maximal number of equally-best mapping locations al-
                                lowed to be reported for each read. 1 by default.
                            </h6>
                            <input type="text" name="Subread_B2" class="input_setting_text" value="1"><br>
                            -d < int >( minFragLength )<br>
                            <h6>Specify the minimum fragment/template length, 50 by default.</h6>
                            <input type="text" name="Subread_d" class="input_setting_text" value="50"/><br>
                            -D < int >( maxFragLength )<br>
                            <h6>Specify the maximum fragment/template length, 600 by default.</h6>
                            <input type="text" name="Subread_D" class="input_setting_text" value="600"/><br>
                            -I < int >( indels )<br>
                            <h6>Specify the number of INDEL bases allowed in the mapping. 5 by
                                default. Indels of up to 200bp long can be detected.</h6>
                            <input type="text" name="Subread_I" class="input_setting_text" value="5"/><br>
                            -m < int >( TH1 )<br>
                            <h6>Specify the consensus threshold, which is the minimal number of
                                consensus subreads required for reporting a hit.3 by default.</h6>
                            <input type="text" name="Subread_m" class="input_setting_text" value="3"/><br>
                            -M < int >( maxMismatches )<br>
                            <h6>Specify the maximum number of mis-matched bases allowed in the
                                alignment. 3 by default. Mis-matches found in soft-clipped bases
                                are not counted.</h6>
                            <input type="text" name="Subread_M2" class="input_setting_text" value="3"/><br>
                            -n < int >( nsubreads )<br>
                            <h6>Specify the number of subreads extracted from each read, 10 by
                                default.</h6>
                            <input type="text" name="Subread_n" class="input_setting_text" value="10"/><br>
                            -p < int >( TH2 )<br>
                            <h6>Specify the minimum number of consensus subreads both reads
                                from the same pair must have.1 by default.</h6>
                            <input type="text" name="Subread_p" class="input_setting_text" value="1"/><br>
                            -P < 3 : 6 >( phredOffset )<br>
                            <h6>Specify the format of Phred scores used in the input data, ’3’ for
                                phred+33 and ’6’ for phred+64. ’3’ by default.</h6>
                            <input type="text" name="Subread_P" class="input_setting_text" value="3"/><br>
                            -S < f f : f r : rf >( PE orientation )<br>
                            <h6>Specify the orientation of the two reads from the same pair. It has
                                three possible values including ‘fr’, ‘ff’ and ‘’rf. Letter ‘f’ denotes
                                the forward strand and letter ‘r’ the reverse strand. ‘fr’ by default</h6>
                            <input type="text" name="Subread_S" class="input_setting_text" value="fr"/><br>
                            -T < int >( nthreads )<br>
                            <h6>Specify the number of threads/CPUs used for mapping. The value
                                should be between 1 and 32. 1 by default.</h6>
                            <input type="text" name="Subread_T" class="input_setting_text" value="1"/><br>
                            −−trim5 < int >( nTrim5 )<br>
                            <h6>Trim off < int > number of bases from 5’ end of each read. 0 by
                                default.</h6>
                            <input type="text" name="Subread_trim5" class="input_setting_text" value="0"/><br>
                            −−trim3 < int >( nTrim3 )<br>
                            <h6>Trim off < int > number of bases from 3’ end of each read. 0 by
                                default.</h6>
                            <input type="text" name="Subread_trim3" class="input_setting_text" value="0"/><br>
                            <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('optional_center_setting_align_Subread').style.display='none';JavaScript:Subread_align_radio(Subread_B2.value,Subread_d.value,Subread_D.value,Subread_I.value,Subread_m.value,Subread_M.value,Subread_n.value,Subread_p.value,Subread_P.value,Subread_S.value,Subread_T.value,Subread_trim5.value,Subread_trim3.value)"/>
                            <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('optional_center_setting_align_Subread').style.display='none'"/>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Execute" class="Execute_btn" id="btn_subread"/>
                <div id="wait_subread" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_6" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(6);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_6" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_6').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Liao, Y., Smyth, G. K., & Shi, W. (2013). The subread aligner: fast, accurate and scalable read mapping by seed-and-vote. Nucleic Acids Research, 41(10), 89-94.
            </div>
        </div>
        <!-----------------------NGM-------------------------------------------------------------->
        <div id="side_right_7" class="side_right" style="display:none">
            <div class="link" onclick="JavaScript:nece_opt_show_NGM_ne();"style="cursor:hand;">
                <div class="arrow-down" id="arrow-down36" style="display:block"></div>
                <div class="arrow-right" id="arrow-right36" style="display:none"></div>
                Necessary parameter</div>
            <form action="NGM_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_NGM').style.backgroundColor='#666666';document.getElementById('wait_NGM').style.display='block';">
                <div id="necessary_center_NGM" class="necessary_center" style="display:block" style="overflow-y:scroll; ">
                    <div class="blacktop_1">Select the type of sequence</div>
                    <div class="blackdown_1">
                        <input type="radio" name="NGM_type" value="1" checked="true" onclick="document.getElementById('file-box_NGM_single').style.display='block';document.getElementById('file-box_NGM_paired').style.display='none'"/>single-end
                        <input type="radio" name="NGM_type" value="2"   onclick="document.getElementById('file-box_NGM_single').style.display='none';document.getElementById('file-box_NGM_paired').style.display='block'"/>paired-end
                    </div>
                    <div class="blacktop_1">
                        Select reference to build index (NGM combines the step of indexing and aligning)
                        <div class="tip_out"><img class="tip" id="tip13" src="./img/tip.png" onclick="JavaScript:Tip_click(13)"></div>
                        <s:fielderror fieldName="input_NGM_reference" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_2_bowtie2">
                        <input type="radio" name="refer_index_NGM"  value="1" checked="true" onclick="document.getElementById('file-box_NGM_refer').style.display='block';document.getElementById('built_in_NGM').style.display='none';"/>Select reference to build index
                        <input type="radio" name="refer_index_NGM"  value="2" disabled="true" onclick="document.getElementById('file-box_NGM_refer').style.display='none';document.getElementById('built_in_NGM').style.display='block'"/>Use a built-in index
                        <div class="file-box" id="file-box_NGM_refer" style="display:block">
                            <input type="text" name="input_NGM_reference"  class="input_text" id="input_NGM_reference"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_ngm" class="fileField" id="fileField_ngm_re" onchange="document.getElementById('input_NGM_reference').value=this.value;fileChange(this,'input_NGM_reference');" />
                        </div>

                    </div>
                    <div class="blacktop_1">
                        Select reads file
                        <div class="tip_out"><img class="tip" id="tip14" src="./img/tip.png" onclick="JavaScript:Tip_click(14)"></div>
                        <s:fielderror fieldName="input_NGM_reads" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                        <s:fielderror fieldName="input_NGM_reads_pair1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box" id="file-box_NGM_single" style="display:block;">
                            <input type="text" name="input_NGM_reads" class="input_text" id="input_NGM_reads"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_ngm" class="fileField" id="fileField_ngm_read" onchange="document.getElementById('input_NGM_reads').value=this.value;fileChange(this,'input_NGM_reads');" />
                        </div>
                        <div class="file-box" id="file-box_NGM_paired" style="display:none;">
                            <input type="text" name="input_NGM_reads_pair1" class="input_text_pair" id="input_NGM_reads_pair1"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_ngm" class="fileField_pair1" id="fileField_ngm_pair1" onchange="document.getElementById('input_NGM_reads_pair1').value=this.value;fileChange(this,'input_NGM_reads_pair1');" />
                            <input type="text" name="input_NGM_reads_pair2" class="input_text_pair" id="input_NGM_reads_pair2"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_ngm" class="fileField_pair2" id="fileField_ngm_pair2" onchange="document.getElementById('input_NGM_reads_pair2').value=this.value;fileChange(this,'input_NGM_reads_pair2');" />
                        </div>
                    </div>
                </div>
                <div class="link" onclick="JavaScript:nece_opt_show_NGM_op();"style="cursor:hand;">
                    <div class="arrow-down" id="arrow-down37" style="display:block"></div>
                    <div class="arrow-right" id="arrow-right37" style="display:none"></div>
                    Optional parameter</div>
                <div id="optional_center_NGM" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_NGM"  class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('optional_center_setting_NGM').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_NGM" class="optionalParameters_set" value="2" onclick="document.getElementById('optional_center_setting_NGM').style.display='block'"/>set the parameters by yourself
                    </div>
                    <div id="optional_center_setting_NGM" class="inputOption_setting" style="display:none;">
                        <div id="optional_center_setting_NGM_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            --force-rlength-check <br>
                            <h6>Forces NextgenMap to run through all reads to
                                find the max. read length. (default: off)</h6>
                            <input type="radio" name="NGM_frc" value="1">on
                            <input type="radio" name="NGM_frc" value="2" checked="true">off<br>
                            -n/--topn <br>
                            <h6>Prints the n best alignments sorted by
                                alignment score (default: 1)</h6>
                            <input type="text" name="NGM_n" class="input_setting_text" value="1"/><br>
                            --keep-tags <br>
                            <h6>Copy BAM/SAM tags present in input file to
                                output file (default: off)</h6>
                            <input type="radio" name="NGM_kt" value="1">on
                            <input type="radio" name="NGM_kt" value="2" checked="true">off<br>
                            -t/--threads <br>
                            <h6>Number of candidate search threads</h6>
                            <input type="text" name="NGM_t" class="input_setting_text" value="1"/><br>
                            Scale estimated sensitivity:<br>
                            <h6>--very fast;Much faster, much less accurate<br>
                                --fast;Scale estimated sensitivity: Faster, less accurate<br>
                                --sensitive;Scale estimated sensitivity: More accurate, slower<br>
                                --very-sensitive;Scale estimated sensitivity: Much more accurate, much slower</h6>
                            <input type="radio" name="NGM_sen" value="1">very fast
                            <input type="radio" name="NGM_sen" value="2" checked="true">fast
                            <input type="radio" name="NGM_sen" value="3">sensitive
                            <input type="radio" name="NGM_sen" value="4">very-sensitive<br>
                            -i/--min-identity <0-1> <br>
                            <h6>All reads mapped with an identity lower than
                                this threshold will be reported as unmapped
                                (default: 0.65)</h6>
                            <input type="text" name="NGM_i" class="input_setting_text" value="0.65"/><br>
                            -R/--min-residues <br>
                            <h6>All reads mapped with lower than
                                * read length residues
                                will be reported as unmapped. (default: 0.5)</h6>
                            <input type="text" name="NGM_R" class="input_setting_text" value="0.5"/><br>
                            -Q/--min-mq <br>
                            <h6>All reads mapped with lower than n mapping quality will be reported as unmapped.
                                (default: 0)</h6>
                            <input type="text" name="NGM_Q" class="input_setting_text" value="0"/><br>
                            --bs-cutoff <br>
                            <h6>Max. number of Ts in a k-mer. All k-mers were
                                the number of Ts is higher than b are ignored (default: 8)</h6>
                            <input type="text" name="NGM_bc" class="input_setting_text" value="8"/><br>
                            -k/--kmer [10-14] <br>
                            <h6>Kmer length in bases. (default: 13)</h6>
                            <input type="text" name="NGM_k" class="input_setting_text" value="13"/><br>
                            --kmer-skip <br>
                            <h6>Number of k-mers to skip when building the
                                lookup table from the reference(default: 2)</h6>
                            <input type="text" name="NGM_ks" class="input_setting_text" value="2"/><br>
                            --kmer-min <br>
                            <h6>Minimal number of k-mer hits required to
                                consider a region a CMR. (default: 0)</h6>
                            <input type="text" name="NGM_km" class="input_setting_text" value="0"/><br>
                            -l/--local <br>
                            <h6>Perform local alignment. Ends might get clipped.
                                (default: on)</h6>
                            <input type="radio" value="1" name="NGM_l" checked="true">on
                            <input type="radio" value="2" name="NGM_l" >off<br>
                            -e/--end-to-end   <br>
                            <h6>Perform end-to-end alignment. No clipping.
                                (default: off)</h6>
                            <input type="radio" value="1" name="NGM_e" >on
                            <input type="radio" value="2" name="NGM_e" checked="true">off<br>
                            --affine     <br>
                            <h6>Use alignment algorithms that support affine gap
                                costs. This will give you better alignments for
                                longer indels but will also increase the runtime.
                                (default: off)</h6>
                            <input type="radio" value="1" name="NGM_a" >on
                            <input type="radio" value="2" name="NGM_a" checked="true">off<br>
                            --skip-mate-check     <br>
                            <h6>Don't check that both mates have the same name
                                (default: off)</h6>
                            <input type="radio" value="1" name="NGM_smc" >on
                            <input type="radio" value="2" name="NGM_smc" checked="true">off<br>
                            <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('optional_center_setting_NGM').style.display='none'"/>
                            <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('optional_center_setting_NGM').style.display='none'"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_NGM"/>
                <div id="wait_NGM" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_7" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(7);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_7" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_7').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Sedlazeck, F. J. (2013). Nextgenmap: fast and accurate read mapping in highly polymorphic genomes. Bioinformatics, 29(21), 2790-1.
            </div>
        </div>
        <!-------------------------------------------------multi-------------------------------------------------------------------------------------------->
        <div id="side_right_8" class="side_right" style="display:none">
            <form action="Tools_multiBamSummary" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_multi').style.backgroundColor='#666666';document.getElementById('wait_multi').style.display='block';">
                <div class="link" onclick="JavaScript:multi_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right44" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down44" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_multi" class="necessary_center" style="display:block">
                    <div class="blacktop_1">
                        Choose the mode to compute the read coverage
                    </div>
                    <div class="blackdown_1">
                        <input type="radio" name="multi_mode"  value="1" checked="true" onclick="document.getElementById('multi_bed').style.display='none'"/>bins
                        <input type="radio" name="multi_mode"  value="2" onclick="document.getElementById('multi_bed').style.display='block'"/>BED-file
                    </div>
                    <div class="blacktop_1">
                        Input SAM files
                        <div class="tip_out"><img class="tip" id="tip53" src="./img/tip.png" onclick="JavaScript:Tip_click(53)"></div>
                        <s:fielderror fieldName="multi_bins_bamfile1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="multi_bins_bamfile1" id="multi_bins_bamfile1" class="input_text_pair"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_multi" class="fileField_pair1" id="fileField_bins_multi_bam1" onchange="document.getElementById('multi_bins_bamfile1').value=this.value;fileChange(this,'multi_bins_bamfile1');" />
                            <input type="text" name="multi_bins_bamfile2" id="multi_bins_bamfile2" class="input_text_pair"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_multi" class="fileField_pair2" id="fileField_bins_multi_bam2" onchange="document.getElementById('multi_bins_bamfile2').value=this.value;fileChange(this,'multi_bins_bamfile2');" />
                        </div>
                    </div>
                    <div id="multi_bed" style="display:none">
                        <div class="blacktop_1">
                            Input BED file to limit the region
                            <div class="tip_out"><img class="tip" id="tip54" src="./img/tip.png" onclick="JavaScript:Tip_click(54)"></div>
                            <s:fielderror fieldName="multi_bed_text" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                        </div>
                        <div class="blackdown_1">
                            <div class="file-box">
                                <input type="text" name="multi_bed_text" id="multi_bed_text" class="input_text"/>
                                <input type='button' class='btn' value='Choose File' />
                                <input type="file" name="fileField_multi" class="fileField" id="fileField_multi_bed" onchange="document.getElementById('multi_bed_text').value=this.value;fileChange(this,'multi_bed_text');" />
                            </div>
                        </div>
                    </div>

                </div>
                <div class="link"onclick="JavaScript:multi_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right45" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down45" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_multi" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters" id="multi_optionalParameters_default" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('multi_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters" id=",ulti_optionalParameters_set" class="optionalParameters_set" value="2" onclick="document.getElementById('multi_optional_setting').style.display='block'"/>set the parameters by yourself
                    </div>
                    <div id="multi_optional_setting" class="inputOption_setting" style="display:none">
                        <div id="multi_optional_setting_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            --labels, -l<br>
                            <h6>User defined labels instead of default labels from file names. Multiple labels have to be separated by a space, e.g. –labels sample1 sample2 sample3</h6>
                            <input type="text" name="multi_l" class="input_setting_text"/><br>
                            --binSize, -bs<br>
                            <h6>Length in bases of the window used to sample the genome.</h6>
                            <input type="text" name="multi_bs"  class="input_setting_text"/><br>
                            --distanceBetweenBins, -n<br>
                            <h6>By default, multiBamSummary considers consecutive bins of the specified –binSize. However, to reduce the computation time, a larger distance between bins can by given. Larger distances result in fewer bins considered.</h6>
                            <input type="text" name="multi_n" class="input_setting_text"/><br>
                            --region, -r<br>
                            <h6>Region of the genome to limit the operation to - this is useful when testing parameters to reduce the computing time. The format is chr:start:end, for example –region chr10 or –region chr10:456700:891000.</h6>
                            <input type="text" name="multi_r" class="input_setting_text"/><br>
                            --blackListFileName, -bl<br>
                            <h6>A BED or GTF file containing regions that should be excluded from all analyses. Currently this works by rejecting genomic chunks that happen to overlap an entry. Consequently, for BAM files, if a read partially overlaps a blacklisted region or a fragment spans over it, then the read/fragment might still be considered. Please note that you should adjust the effective genome size, if relevant.</h6>
                            <input type="text" name="multi_bl" class="input_setting_text"/><br>
                            --numberOfProcessors, -p<br>
                            <h6>Number of processors to use. Type “max/2” to use half the maximum number of processors or “max” to use all available processors.</h6>
                            <input type="text" name="multi_p" class="input_setting_text"/><br>
                            --outRawCounts<br>
                            <h6>Save the counts per region to a tab-delimited file.</h6>
                            <input type="text" name="multi_out" class="input_setting_text"/><br>
                            --extendReads, -e<br>
                            <h6>This parameter allows the extension of reads to fragment size. If set, each read is extended, without exception.</h6>
                            <input type="text" name="multi_e" class="input_setting_text"/><br>
                           <br> --ignoreDuplicates<br>
                            <h6>If set, reads that have the same orientation and start position will be considered only once. If reads are paired, the mate’s position also has to coincide to ignore a read.</h6>
                            <input type="radio" name="multi_ignore" value="1"/>on
                            <input type="radio" name="multi_ignore" value="2" checked="true"/>off<br>
                            <br>--minMappingQuality<br>
                            <h6>If set, only reads that have a mapping quality score of at least this are considered.</h6>
                            <input type="radio" name="multi_minmapping" value="1"/>on
                            <input type="radio" name="multi_minmapping" value="2" checked="true"/>off<br>
                            <br>--centerReads<br>
                            <h6>By adding this option, reads are centered with respect to the fragment length. For paired-end data, the read is centered at the fragment length defined by the two ends of the fragment. For single-end data, the given fragment length is used. This option is useful to get a sharper signal around enriched regions.</h6>
                            <input type="radio" name="multi_center" value="1"/>on
                            <input type="radio" name="multi_center" value="2" checked="true"/>off<br>
                           <br> --samFlagInclude<br>
                            <h6>Include reads based on the SAM flag. For example, to get only reads that are the first mate, use a flag of 64. This is useful to count properly paired reads only once, as otherwise the second mate will be also considered for the coverage.</h6>
                            <input type="radio" name="multi_samFlagInclude" value="1"/>on
                            <input type="radio" name="multi_samFlagInclude" value="2" checked="true"/>off<br>
                            <br>--samFlagExclude<br>
                            <h6>Exclude reads based on the SAM flag. For example, to get only reads that map to the forward strand, use –samFlagExclude 16, where 16 is the SAM flag for reads that map to the reverse strand.</h6>
                            <input type="radio" name="multi_samFlagExclude" value="1"/>on
                            <input type="radio" name="multi_samFlagExclude" value="2" checked="true"/>off<br>
                            <br>--minFragmentLength<br>
                            <h6>The minimum fragment length needed for read/pair inclusion. Note that a value other than 0 will exclude all single-end reads. This option is primarily useful in ATACseq experiments, for filtering mono- or di-nucleosome fragments.</h6>
                            <input type="radio" name="multi_minFragmentLength" value="1"/>on
                            <input type="radio" name="multi_minFragmentLength" value="2" checked="true"/>off<br>
                           <br> --maxFragmentLength<br>
                            <h6>
                                The maximum fragment length needed for read/pair inclusion. A value of 0 disables filtering and is needed for including single-end and orphan reads.
                            </h6>
                            <input type="radio" name="multi_maxFragmentLength" value="1"/>on
                            <input type="radio" name="multi_maxFragmentLength" value="2" checked="true"/>off<br>
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('multi_optional_setting').style.display='none';"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('multi_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Execute" class="Execute_btn" id="btn_multi"/>
                <div id="wait_multi" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_8" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(8);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_8" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                    <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_8').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Ramírez, F., Dündar, F., Diehl, S., Grüning, B. A., & Manke, T. (2014). Deeptools: a flexible platform for exploring deep-sequencing data.Nucleic Acids Research, 42(W1), 187-91.
            </div>
        </div>
      <!------------------------MACS-------------------------------------------------------------->
      <div id="side_right_9" class="side_right" style="display:none">
          <form action="Tools_MACS_PeakCalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_MACS').style.backgroundColor='#666666';document.getElementById('wait_MACS').style.display='block';">
              <div class="link" onclick="JavaScript:macs_option_ne();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right8" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down8" style="display:block"></div>
                  Necessary parameters
              </div>
              <div id="necessary_center_macs" class="necessary_center" style="display:block">
                  <div class="blacktop_1">Choose the format of the input</div>
                  <div class="blackdown_1">
                      <input type="radio" name="macs_format"  value="1" checked="true"/>Sam
                      <input type="radio" name="macs_format"  value="2"/>Bam
                      <input type="radio" name="macs_format"  valie="3"/>Bed
                  </div>
                  <div class="blacktop_1">
                      ChIP-Seq Tag file
                      <s:fielderror fieldName="input_tagfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_tagfile" id="input_tagfile" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_macs" class="fileField" id="fileField_macs_tag" onchange="document.getElementById('input_tagfile').value=this.value;fileChange(this,'input_tagfile');" />
                      </div>
                  </div>
                  <div class="blacktop_1">
                      ChIP-Seq Control file
                      <div class="tip_out"><img class="tip" id="tip16" src="./img/tip.png" onclick="JavaScript:Tip_click(16)"></div>
                      <s:fielderror fieldName="input_controlfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_controlfile" id="input_controlfile" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_macs" class="fileField" id="fileField_macs_control" onchange="document.getElementById('input_controlfile').value=this.value;fileChange(this,'input_controlfile');" />
                      </div>
                  </div>

              </div>
              <div class="link"onclick="JavaScript:macs_option_op();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right9" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down9" style="display:block"></div>
                  Optional parameters
              </div>
              <div id="optional_center_macs" class="optional_center" style="display:block">
                  <div class="blacktop_1">optional parameters</div>
                  <div class="blackdown_1">
                      <input type="radio" name="optionalParameters" id="optionalParameters_default" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('macs_optional_setting').style.display='none'"/>default
                      <input type="radio" name="optionalParameters" id="optionalParameters_set" class="optionalParameters_set" value="2" onclick="document.getElementById('macs_optional_setting').style.display='block'"/>set the parameters by yourself
                      <div id="macs_radio" class="radio_text"></div>
                  </div>
                  <div id="macs_optional_setting" class="inputOption_setting" style="display:none">
                      <div id="macs_optional_setting_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                          Tag size<br>
                          <h6>This will overide the auto detected tag size.default:25</h6>
                          <input type="text" name="macs_s" value="25" class="input_setting_text"/>
                          Band width<br>
                          <h6>This value is only used while building the shifting model. DEFAULT: 300</h6>
                          <input type="text" name="macs_bw" value="300" class="input_setting_text"/>
                          Pvalue cutoff for peak detection<br>
                          <h6>Pvalue cutoff for peak detection. DEFAULT: 1e-5</h6>
                          <input type="text" name="macs_p" value="1e-5" class="input_setting_text"/>
                          Effective genome size:this is the size of the genome considered "usable" for peak calling.
                          <h6>default:2700000000.0</h6>
                          <input type="text" name="macs_gs" value="2700000000.0" class="input_setting_text"/><br>
                          <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('macs_optional_setting').style.display='none';JavaScript:macs_radio(macs_g.value,macs_s.value,macs_bw.value,macs_p.value);"/>
                          <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('macs_optional_setting').style.display='none';"/>
                      </div>
                  </div>
              </div>

              <input type="submit" value="Execute" class="Execute_btn" id="btn_MACS"/>
              <div id="wait_MACS" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
          </form>
          <div id="detail_text_9" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(9);" style="text-decoration: none;color:#666666">click here</a>.
              And the result files will be sent to you by email as soon as possible.
          </div>
          <div id="detail_9" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_9').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div class="citation">
              Zhang, Y., Liu, T., Meyer, C. A., Eeckhoute, J., Johnson, D. S., & Bernstein, B. E., et al. (2008). Model-based analysis of chip-seq (macs).Genome Biology, 9(9), : R137.
          </div>
      </div>
        <!------------------------MACS2-------------------------------------------------------------->
        <div id="side_right_10" class="side_right" style="display:none">
            <form action="PeakCalling_macs2" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_MACS2').style.backgroundColor='#666666';document.getElementById('wait_MACS2').style.display='block';">
                <div class="link" onclick="JavaScript:macs2_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right12" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down12" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_macs2" class="necessary_center" style="display:block">
                    <div class="blacktop_1">Choose the format of the input</div>
                    <div class="blackdown_2_bowtie2">
                        <input type="radio" name="macs2_format" value="1" checked="true">BAM
                        <input type="radio" name="macs2_format" value="2">SAM
                        <input type="radio" name="macs2_format" value="3">BED
                        <input type="radio" name="macs2_format" value="4">ELAND
                        <input type="radio" name="macs2_format" value="5">ELANDMULTI<br>
                        <input type="radio" name="macs2_format" value="6">ELANDEXPORT
                        <input type="radio" name="macs2_format" value="7">BOWTIE
                        <input type="radio" name="macs2_format" value="8">BAMPE
                        <input type="radio" name="macs2_format" value="9">BEDPE
                    </div>

                    <div class="blacktop_1">
                        ChIP-Seq Tag file
                        <s:fielderror fieldName="input_tagfile_macs2" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_tagfile_macs2" id="input_tagfile_macs2" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_macs2" class="fileField" id="fileField_macs2_tag" onchange="document.getElementById('input_tagfile_macs2').value=this.value;fileChange(this,'input_tagfile_macs2');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        ChIP-Seq Control file
                        <div class="tip_out"><img class="tip" id="tip18" src="./img/tip.png" onclick="JavaScript:Tip_click(18)"></div>
                        <s:fielderror fieldName="input_controlfile_macs2" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_controlfile_macs2" id="input_controlfile_macs2" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_macs2" class="fileField" id="fileField_macs2_control" onchange="document.getElementById('input_controlfile_macs2').value=this.value;fileChange(this,'input_controlfile_macs2');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:macs2_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right13" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down13" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_macs2" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_macs2" id="optionalParameters_default_macs2" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('macs2_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_macs2" id="optionalParameters_set_macs2" class="optionalParameters_set" value="2" onclick="document.getElementById('macs2_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="macs2_radio" class="radio_text"></div>
                    </div>
                    <div id="macs2_optional_setting" class="inputOption_setting" style="display:none">
                        <div id="macs2_optional_setting_center" class="inputOption_setting_center" style="overflow-y:scroll;">
                            Effective genome size<br>
                            <h6>default: hs</h6>
                            <input type="text" name="macs2_g" value="hs" class="input_setting_text"/>
                            Tag size<br>
                            <h6>This will overide the auto detected tag size.default:25</h6>
                            <input type="text" name="macs2_s" value="25" class="input_setting_text"/>
                            Band width<br>
                            <h6>This value is only used while building the shifting model. DEFAULT: 300</h6>
                            <input type="text" name="macs2_bw" value="300" class="input_setting_text"/>
                            The qvalue (minimum FDR) cutoff to call significant regions.<br>
                            <h6>Default is 0.01. For broad marks, you can try 0.05 as cutoff. Q-values are calculated from p-values using Benjamini-Hochberg procedure.</h6>
                            <input type="text" name="macs2_q" value="0.01" class="input_setting_text"/>
                            This parameter is used to select the regions within MFOLD range of high-confidence enrichment ratio against background to build model.<br>
                            <h6>-m/–mfold,default:5,50</h6>
                            <input type="text" name="macs2_m" value="5 50" class="input_setting_text"/>
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('macs2_optional_setting').style.display='none';JavaScript:macs2_radio(macs2_g.value,macs2_s.value,macs2_bw.value,macs2_q.value,macs2_m.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('macs2_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>


                <input type="submit" value="Execute" class="Execute_btn" id="btn_MACS2"/>
                <div id="wait_MACS2" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_10" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(10);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_10" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_10').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Zhang, Y., Liu, T., Meyer, C. A., Eeckhoute, J., Johnson, D. S., & Bernstein, B. E., et al. (2008). Model-based analysis of chip-seq (macs).Genome Biology, 9(9), : R137.
            </div>
        </div>
      <!------------------------PeakSeq-------------------------------------------------------------->
      <div id="side_right_11" class="side_right" style="display:none">
          <form action="peakseq_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_peakseq').style.backgroundColor='#666666';document.getElementById('wait_peakseq').style.display='block';">
              <div class="link"onclick="JavaScript:peakseq_option_ne();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right16" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down16" style="display:block"></div>
                  Necessary parameters
              </div>
              <div id="necessary_center_peakseq" class="necessary_center" style="display:block">
                  <div class="blacktop_1">Select file format </div>
                  <div class="blackdown_1">
                      <input type="radio" name="peakseq_format" id="peakseq_format_sam" checked="true" value="1"/>Sam
                      <input type="radio" name="peakseq_format" id="peakseq_format_ELAND" valie="2"/>ELAND
                  </div>
                  <div class="blacktop_1">
                      ChIP-Seq Tag file
                      <s:fielderror fieldName="input_tagfile_peakseq" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_tagfile_peakseq" id="input_tagfile_peakseq" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_peakseq" class="fileField" id="fileField_peakseq_tag" onchange="document.getElementById('input_tagfile_peakseq').value=this.value;fileChange(this,'input_tagfile_peakseq');" />
                      </div>
                  </div>
                  <div class="blacktop_1">
                      ChIP-Seq Control file
                      <div class="tip_out"><img class="tip" id="tip20" src="./img/tip.png" onclick="JavaScript:Tip_click(20)"></div>
                      <s:fielderror fieldName="input_controlfile_peakseq" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_controlfile_peakseq" id="input_controlfile_peakseq" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_peakseq" class="fileField" id="fileField_peakseq_control" onchange="document.getElementById('input_controlfile_peakseq').value=this.value;fileChange(this,'input_controlfile_peakseq');" />
                      </div>
                  </div>

              </div>

              <div class="link"onclick="JavaScript:peakseq_option_op();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right17" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down17" style="display:block"></div>
                  Optional parameters
              </div>
              <div id="optional_center_peakseq" class="optional_center" style="display:block">
                  <div class="blacktop_1">optional parameters</div>
                  <div class="blackdown_1">
                      <input type="radio" name="optionalParameters_peakseq" id="optionalParameters_default_peakseq" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('peakseq_optional_setting').style.display='none'"/>default
                      <input type="radio" name="optionalParameters_peakseq" id="optionalParameters_set_peakseq" class="optionalParameters_set" value="2" onclick="document.getElementById('peakseq_optional_setting').style.display='block'"/>set the parameters by yourself
                      <div id="peakseq_radio" class="radio_text"></div>
                  </div>
                  <div id="peakseq_optional_setting" class="inputOption_setting" style="display:none">
                      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
                          Enrichment fragment length For tag extension, this is the value of average fragment length.<br>
                          <h6>Enrichment_fragment_length ;default:200</h6>
                          <input type="text" name="peakseq_length" value="200" class="input_setting_text"/>
                          Target FDR in the simulations.<br>
                          <h6>target_FDR ;default:0.05</h6>
                          <input type="text" name="peakseq_fdr" value="0.05" class="input_setting_text"/>
                          Number of simulations performed while estimating the putative peaks.<br>
                          <h6>N_Simulations ;default:10</h6>
                          <input type="text" name="peakseq_N" value="10" class="input_setting_text"/>
                          Minimum distance between consecutive peaks<br>
                          <h6>Minimum_interpeak_distance ;default:200</h6>
                          <input type="text" name="peakseq_Min" value="200" class="input_setting_text"/>
                          Q-value threshold applied on the final set of peaks.<br>
                          <h6>max_Qvalue ;default:0.05</h6>
                          <input type="text" name="peakseq_qvalue" value="0.05" class="input_setting_text"/>
                          There are currently two models for simulating the background for threshold selection<br>
                          <input type="radio" name="peakseq_mode" value="1"/>Poisson
                          <input type="radio" name="peakseq_mode" value="2"/>Simulated<br>
                          <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakseq_optional_setting').style.display='none';JavaScript:peakseq_radio(peakseq_length.value,peakseq_fdr.value,peakseq_N.value,peakseq_Min.value,peakseq_mode.value,peakseq_qvalue.value);"/>
                          <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakseq_optional_setting').style.display='none';"/>
                      </div>
                  </div>
              </div>

              <input type="submit" value="Execute" class="Execute_btn" id="btn_peakseq"/>
              <div id="wait_peakseq" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
          </form>
          <div id="detail_text_11" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(11);" style="text-decoration: none;color:#666666">click here</a>.
              And the result files will be sent to you by email as soon as possible.
          </div>
          <div id="detail_11" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_11').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div class="citation">
              Rozowsky, J., Euskirchen, G., Auerbach, R. K., Zhang, Z. D., Gibson, T., & Bjornson, R., et al. (2009). Peakseq enables systematic scoring of chip-seq experiments relative to controls. Nature Biotechnology, 27(1), 66-75.
          </div>
      </div>
      <!------------------------PeakRanger-------------------------------------------------------------->
      <div id="side_right_12" class="side_right" style="display:none">
          <form action="peakranger_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_PeakRanger').style.backgroundColor='#666666';document.getElementById('wait_PeakRanger').style.display='block';">
              <div class="link"onclick="JavaScript:peakranger_option_ne();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right18" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down18" style="display:block"></div>
                  Necessary parameters
              </div>
              <div id="necessary_center_peakranger" class="necessary_center" style="display:block">
                  <div class="blacktop_1">Select file format </div>
                  <div class="blackdown_1">
                      <input type="radio" name="peakranger_format" id="peakranger_format_sam" value="1" checked="true"/>sam
                      <input type="radio" name="peakranger_format" id="peakranger_format_bam" value="2"/>bam
                      <input type="radio" name="peakranger_format" id="peakranger_format_bed" value="3"/>bed
                  </div>

                  <div class="blacktop_1">
                      ChIP-Seq Tag file
                      <s:fielderror fieldName="input_tagfile_peakranger" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_tagfile_peakranger" id="input_tagfile_peakranger" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_peakranger" class="fileField" id="fileField_peakranger_tag" onchange="document.getElementById('input_tagfile_peakranger').value=this.value;fileChange(this,'input_tagfile_peakranger');" />
                      </div>
                  </div>
                  <div class="blacktop_1">
                      ChIP-Seq Control file
                      <div class="tip_out"><img class="tip" id="tip22" src="./img/tip.png" onclick="JavaScript:Tip_click(22)"></div>
                      <s:fielderror fieldName="input_controlfile_peakranger" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_controlfile_peakranger" id="input_controlfile_peakranger" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_peakranger" class="fileField" id="fileField_peakranger_control" onchange="document.getElementById('input_controlfile_peakranger').value=this.value;fileChange(this,'input_controlfile_peakranger');" />
                      </div>
                  </div>

              </div>

              <div class="link" onclick="JavaScript:peakranger_option_op();" style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right19" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down19" style="display:block"></div>
                  Optional parameters
              </div>
              <div id="optional_center_peakranger" class="optional_center" style="display:block">
                  <div class="blacktop_1">Select the tool to call peaks</div>
                  <div class="blackdown_1">
                      <input type="radio" name="select_peakranger" id="optionalParameters_ranger"  value="1"  checked="true" onclick="document.getElementById('peakranger_ranger').style.display='block';document.getElementById('peakranger_ccat').style.display='none';document.getElementById('peakranger_bcp').style.display='none';"/>ranger
                      <input type="radio" name="select_peakranger" id="optionalParameters_ccat"  value="2" onclick="document.getElementById('peakranger_ranger').style.display='none';document.getElementById('peakranger_ccat').style.display='block';document.getElementById('peakranger_bcp').style.display='none';"/>ccat
                      <input type="radio" name="select_peakranger" id="optionalParameters_bcp"  value="3" onclick="document.getElementById('peakranger_ranger').style.display='none';document.getElementById('peakranger_ccat').style.display='none';document.getElementById('peakranger_bcp').style.display='block';"/>bcp
                  </div>
                  <div id="peakranger_ranger" class="inputOption_setting" style="display:none">
                      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
                          Whether generate html reports?<br>
                          <h6>`--report`</h6>
                          <input type="radio" name="peakranger_mode" value="1"/>Yes
                          <input type="radio" name="peakranger_mode" value="2"/>No<br>
                         <br> the length of the snapshort regions in the HTML report.<br>
                          <h6>`--plot_region`;It also controls the search span for nearby genes.</h6>
                          <input type="text" name="peakranger_length" value="" class="input_setting_text"/>
                          the gene annotation file<br>
                          <h6>`--gene_annot_file`</h6>
                          <input type="text" name="peakranger_annofile" value="" class="input_setting_text"/>
                          <br>p value cut off<br>
                          <h6>`-p,--pval` </h6>
                          <input type="text" name="peakranger_pvalue" value="" class="input_setting_text"/>
                          FDR cut off<br>
                          <h6>`-q,--FDR` </h6>
                          <input type="text" name="peakranger_fdr" value="" class="input_setting_text"/>
                          read extension length<br>
                          <h6>`-l,--ext_length` </h6>
                          <input type="text" name="peakranger_relength" value="" class="input_setting_text"/>
                          sensitivity of the summit detector<br>
                          <h6>`-r,--delta`</h6>
                          <input type="text" name="peakranger_delta" value="" class="input_setting_text"/>
                          smoothing bandwidth.<br>
                          <h6>`-b,--bandwidth` </h6>
                          <input type="text" name="peakranger_bandwidth" value="" class="input_setting_text"/>
                          pad read coverage to avoid false positive summits<br>
                          <h6>`--pad` </h6>
                          <input type="text" name="peakranger_pad" value="" class="input_setting_text"/>
                          number of threads.<br>
                          <h6>`-t`  ;default: 1</h6>
                          <input type="text" name="peakranger_t" value="" class="input_setting_text"/>
                          <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakranger_ranger').style.display='none';JavaScript:peakranger_radio(peakseq_length.value,peakseq_fdr.value,peakseq_N.value,peakseq_Min.value,peakseq_mode.value,peakseq_qvalue.value);"/>
                          <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakranger_ranger').style.display='none';"/>
                      </div>
                  </div>
                  <div id="peakranger_ccat" class="inputOption_setting" style="display:none">
                      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
                          Whether generate html reports?<br>
                          <h6>`--report`</h6>
                          <input type="radio" name="peakranger_mode1" value="1"/>Yes
                          <input type="radio" name="peakranger_mode1" value="2"/>No<br>
                          <br>the length of the snapshort regions in the HTML report.<br>
                          <h6>`--plot_region`;It also controls the search span for nearby genes.</h6>
                          <input type="text" name="peakranger_length1" value="" class="input_setting_text"/>
                          the gene annotation file<br>
                          <h6>`--gene_annot_file`</h6>
                          <input type="text" name="peakranger_annofile1" value="" class="input_setting_text"/>
                          FDR cut off<br>
                          <h6>`-q,--FDR`</h6>
                          <input type="text" name="peakranger_fdr1" value="" class="input_setting_text"/>
                          sliding window size<br>
                          <h6>`--win_size`</h6>
                          <input type="text" name="peakranger_winsize1" value="" class="input_setting_text"/>
                          window moving step<br>
                          <h6>`--win_step`</h6>
                          <input type="text" name="peakranger_winstep1" value="" class="input_setting_text"/>
                          minimum window reads count<br>
                          <h6>`--min_count`</h6>
                          <input type="text" name="peakranger_imcount1" value="" class="input_setting_text"/>
                          minimum window reads fold change<br>
                          <h6>`--min_score`</h6>
                          <input type="text" name="peakranger_minscore" value="" class="input_setting_text"/>
                          read extension length<br>
                          <h6>`-l,--ext_length` </h6>
                          <input type="text" name="peakranger_relength1" value="" class="input_setting_text"/>
                          p value cut off<br>
                          <h6>`-p,--pval` </h6>
                          <input type="text" name="peakranger_pvalue1" value="" class="input_setting_text"/>
                          <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakranger_ccat').style.display='none';JavaScript:peakranger_radio(peakseq_length.value,peakseq_fdr.value,peakseq_N.value,peakseq_Min.value,peakseq_mode.value,peakseq_qvalue.value);"/>
                          <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakranger_ccat').style.display='none';"/>
                      </div>
                  </div>
                  <div id="peakranger_bcp" class="inputOption_setting" style="display:none">
                      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
                          Whether generate html reports?<br>
                          <h6>`--report`</h6>
                          <input type="radio" name="peakranger_mode2" value="1"/>Yes
                          <input type="radio" name="peakranger_mode2" value="2"/>No<br>
                          <br>the length of the snapshort regions in the HTML report.<br>
                          <h6>`--plot_region`;It also controls the search span for nearby genes.</h6>
                          <input type="text" name="peakranger_length2" value="" class="input_setting_text"/>
                          the gene annotation file<br>
                          <h6>`--gene_annot_file`</h6>
                          <input type="text" name="peakranger_annofile2" value="" class="input_setting_text"/>
                          sliding window size<br>
                          <h6>`--win_size`</h6>
                          <input type="text" name="peakranger_winsize2" value="" class="input_setting_text"/>
                          read extension length<br>
                          <h6>`-l,--ext_length` </h6>
                          <input type="text" name="peakranger_relength2" value="" class="input_setting_text"/><br>
                          <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakranger_bcp').style.display='none';JavaScript:peakranger_radio(peakseq_length.value,peakseq_fdr.value,peakseq_N.value,peakseq_Min.value,peakseq_mode.value,peakseq_qvalue.value);"/>
                          <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakranger_bcp').style.display='none';"/>
                      </div>
                  </div>
              </div>
              <input type="submit" value="Execute" class="Execute_btn" id="btn_PeakRanger"/>
              <div id="wait_PeakRanger" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
          </form>
          <div id="detail_text_12" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(12);" style="text-decoration: none;color:#666666">click here</a>.
              And the result files will be sent to you by email as soon as possible.
          </div>
          <div id="detail_12" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_12').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div class="citation">
              Feng, X., Grossman, R., & Stein, L. (2011). Peakranger: a cloud-enabled peak caller for chip-seq data. BMC Bioinformatics, 12(1), 139.
          </div>
      </div>
      <!------------------------SICER-------------------------------------------------------------->
      <div id="side_right_13" class="side_right" style="display:none">
          <form action="SICER_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_SICER').style.backgroundColor='#666666';document.getElementById('wait_SICER').style.display='block';">
              <div class="link" onclick="JavaScript:sicer_option_ne();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right10" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down10" style="display:block"></div>
                  Necessary parameters
              </div>
              <div id="necessary_center_sicer" class="necessary_center" style="display:block">
                  <div class="blacktop_1">
                      ChIP-Seq Tag file
                      <s:fielderror fieldName="input_sicer_tagfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_sicer_tagfile" id="input_sicer_tagfile" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_sicer" class="fileField" id="fileField_sicer_tag" onchange="document.getElementById('input_sicer_tagfile').value=this.value;fileChange(this,'input_sicer_tagfile');" />
                      </div>
                  </div>
                  <div class="blacktop_1">
                      ChIP-Seq Control file
                      <div class="tip_out"><img class="tip" id="tip24" src="./img/tip.png" onclick="JavaScript:Tip_click(24)"></div>
                      <s:fielderror fieldName="input_sicer_controlfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                  </div>
                  <div class="blackdown_1">
                      <div class="file-box">
                          <input type="text" name="input_sicer_controlfile" id="input_sicer_controlfile" class="input_text"/>
                          <input type='button' class='btn' value='Choose File' />
                          <input type="file" name="fileField_sicer" class="fileField" id="fileField_sicer_control" onchange="document.getElementById('input_sicer_controlfile').value=this.value;fileChange(this,'input_sicer_controlfile');" />
                      </div>
                  </div>

              </div>

              <div class="link"onclick="JavaScript:sicer_option_op();"style="cursor:hand;">
                  <div class="arrow-right" id="arrow-right11" style="display:none"></div>
                  <div class="arrow-down"  id="arrow-down11" style="display:block"></div>
                  Optional parameters
              </div>
              <div id="optional_center_sicer" class="optional_center" style="display:block">
                  <div class="blacktop_1">optional parameters</div>
                  <div class="blackdown_1">
                      <input type="radio" name="optionalParameters_sicer" id="optionalParameters_default_sicer" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('sicer_optional_setting').style.display='none'"/>default
                      <input type="radio" name="optionalParameters_sicer" id="optionalParameters_set_sicer" class="optionalParameters_set" value="2" onclick="document.getElementById('sicer_optional_setting').style.display='block'"/>set the parameters by yourself
                      <div id="sicer_radio" class="radio_text"></div>
                  </div>
                  <div id="sicer_optional_setting" class="inputOption_setting" style="display:none">
                      <div class="inputOption_setting_center" style="overflow-y:scroll;">
                          Species: allowed species and genome versions are listed in GenomeData.py.<br> <h6>You
                          can add your own species and/or genome versions and relevant data there.</h6>
                          <input type="text" value="hg18" class="input_setting_text" name="sicer_sp">
                          Redundancy Threshold<br>
                          <h6>The number of copies of identical reads allowed in a library</h6>
                          <input type="text" value="1" class="input_setting_text" name="sicer_RT">
                          Window size<br>
                          <h6>Resolution of SICER algorithm. For histone modifications, one can use 200 bp.Default:200</h6>
                          <input type="text" value="200" class="input_setting_text" name="sicer_ws">
                          Fragment size<br>
                          <h6>for determination of the amount of shift from the beginning of a read to the center of the DNA fragment represented by the read. FRAGMENT_SIZE=150 means the shift is 75.</h6>
                          <input type="text" value="150" class="input_setting_text" name="sicer_fs">
                          Effective genome fraction<br>
                          <h6>Effective Genome as fraction of the genome size. It depends on read length.</h6>
                          <input type="text" value="0.74" class="input_setting_text" name="sicer_egf">
                          Gap size<br>
                          <h6>Needs to be multiples of window size. Namely if the window size is 200, the gap size should be 0, 200, 400, 600, ...</h6>
                          <input type="text" value="600" class="input_setting_text"name="sicer_gs">
                          Statistic threshold value<br>
                          <h6>FDR (with control) or E-value (without control)</h6>
                          <input type="text" value="0.01" class="input_setting_text" name="sicer_fdr">
                          <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('sicer_optional_setting').style.display='none';JavaScript:sicer_radio(sicer_sp.value,sicer_RT.value,sicer_ws.value,sicer_fs.value,sicer_egf.value,sicer_gs.value,sicer_fdr.value);"/>
                          <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('sicer_optional_setting').style.display='none';"/>
                      </div>
                  </div>
              </div>

              <input type="submit" value="Execute" class="Execute_btn" id="btn_SICER"/>
              <div id="wait_SICER" class="Upload_wait_div" style="display:none;">
                  <img src="./img/wait.gif" class="Upload_wait" />
                  Uploading and processing your file,please wait...
              </div>
          </form>
          <div id="detail_text_13" class="detail_tip" style="display:none" >
              If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(13);" style="text-decoration: none;color:#666666">click here</a>.
              And the result files will be sent to you by email as soon as possible.
          </div>
          <div id="detail_13" class="inputOption_setting_de" style="display:none;">
              <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                  ${stdoutlist}<br>
                      <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_13').style.display='none'"/>
              </div>
          </div>
          <span style="color:#666666;font-size:20px;">Ref:</span> <br>
          <div class="citation">
              Xu, S., Grullon, S., Ge, K., & Peng, W. (2014). Spatial clustering for identification of chip-enriched regions (sicer) to map regions of histone methylation patterns in embryonic stem cells.,1150, 97-111.
          </div>
      </div>
        <!------------------------PePr-------------------------------------------------------------->
        <div id="side_right_14" class="side_right" style="display:none">
            <form action="PePr_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_Pepr').style.backgroundColor='#666666';document.getElementById('wait_Pepr').style.display='block';">
                <div class="link" onclick="JavaScript:pepr_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right20" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down20" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_pepr" class="necessary_center" style="display:block">
                    <div class="blacktop_1">
                        Input biological replicate file1
                        <s:fielderror fieldName="input_pepr_tagfile1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_pepr_tagfile1" id="input_pepr_tagfile1" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_pepr" class="fileField" id="fileField_pepr_tag1" onchange="document.getElementById('input_pepr_tagfile1').value=this.value;fileChange(this,'input_pepr_tagfile1');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input biological replicate file2
                        <s:fielderror fieldName="input_pepr_tagfile2" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_pepr_tagfile2" id="input_pepr_tagfile2" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_pepr" class="fileField" id="fileField_pepr_tag2" onchange="document.getElementById('input_pepr_tagfile2').value=this.value;fileChange(this,'input_pepr_tagfile2');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input ChIP replicate file1
                        <s:fielderror fieldName="input_pepr_controlfile1" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_pepr_controlfile1" id="input_pepr_controlfile1" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_pepr" class="fileField" id="fileField_pepr_control1" onchange="document.getElementById('input_pepr_controlfile1').value=this.value;fileChange(this,'input_pepr_controlfile1');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input ChIP replicate file2
                        <s:fielderror fieldName="input_pepr_controlfile2" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_pepr_controlfile2" id="input_pepr_controlfile2" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_pepr" class="fileField" id="fileField_pepr_control2" onchange="document.getElementById('input_pepr_controlfile2').value=this.value;fileChange(this,'input_pepr_controlfile2');" />
                        </div>
                    </div>

                </div>

                <div class="link" onclick="JavaScript:pepr_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right21" style="display:block"></div>
                    <div class="arrow-down"  id="arrow-down21" style="display:none"></div>
                    Optional parameters
                </div>
                <div id="optional_center_pepr" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_pepr" id="optionalParameters_default_pepr" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('pepr_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_pepr" id="optionalParameters_set_pepr" class="optionalParameters_set" value="2" onclick="document.getElementById('pepr_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="pepr_radio" class="radio_text"></div>
                    </div>
                    <div id="pepr_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            --peaktype.sharp or broad. <br>
                            <h6>Default is broad.</h6>
                            <input type="text" value="broad" class="input_setting_text" name="pepr_peaktype"><br>
                            --threshold<br>
                            <h6>p-value cutoff. Default:1e-5.</h6>
                            <input type="text" value="1e-5" class="input_setting_text" name="pepr_p"><br>
                            --keep-max-dup<br>
                            <h6>maximum number of duplicated reads at each single position to keep. If not specified, will not remove any duplicate.</h6>
                            <input type="text" value="2" class="input_setting_text" name="pepr_keep"><br>
                            --num-processors<br>
                            <h6>Number of CPUs to run in parallel.</h6>
                            <input type="text" value="1" class="input_setting_text" name="pepr_num"><br>
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('pepr_optional_setting').style.display='none';JavaScript:pepr_radio(pepr_peaktype.value,pepr_p.value,pepr_keep.value,pepr_num.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('pepr_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_Pepr"/>
                <div id="wait_Pepr" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_14" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(14);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_14" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_14').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Zhang, Y., Lin, Y. H., Johnson, T. D., Rozek, L. S., & Sartor, M. A. (2014). Pepr: a peak-calling prioritization pipeline to identify consistent or differential peaks from replicated chip-seq data. Bioinformatics, 30(18), 2568-2575.
            </div>
        </div>
        <!------------------------BCP-------------------------------------------------------------->
        <div id="side_right_15" class="side_right" style="display:none">
            <form action="BCP_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_BCP').style.backgroundColor='#666666';document.getElementById('wait_BCP').style.display='block';">
                <div class="link" onclick="JavaScript:BCP_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right22" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down22" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_BCP" class="necessary_center" style="display:block">
                    <div class="blacktop_1">
                        Select the data type
                        <s:fielderror fieldName="BCP_type" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="radio" value="1" name="BCP_type" onclick="document.getElementById('BCP_HM').style.display='block';document.getElementById('BCP_TF').style.display='none';"/>Histone Modification case
                        <input type="radio" value="2" name="BCP_type" onclick="document.getElementById('BCP_TF').style.display='block';document.getElementById('BCP_HM').style.display='none';"/>Transcription Factor Bingding Sites
                    </div>
                    <div class="blacktop_1">
                        ChIP-Seq Tag file
                        <s:fielderror fieldName="input_BCP_tagfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_BCP_tagfile" id="input_BCP_tagfile" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_bcp" class="fileField" id="fileField_bcp_tag" onchange="document.getElementById('input_BCP_tagfile').value=this.value;fileChange(this,'input_BCP_tagfile');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        ChIP-Seq control file
                        <div class="tip_out"><img class="tip" id="tip26" src="./img/tip.png" onclick="JavaScript:Tip_click(26)"></div>
                        <s:fielderror fieldName="input_BCP_controlfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_BCP_controlfile" id="input_BCP_controlfile" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_bcp" class="fileField" id="fileField_bcp_control" onchange="document.getElementById('input_BCP_controlfile').value=this.value;fileChange(this,'input_BCP_controlfile');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:BCP_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right23" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down23" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_BCP" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_BCP" id="optionalParameters_default_BCP" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('BCP_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_BCP" id="optionalParameters_set_BCP" class="optionalParameters_set" value="2" onclick="document.getElementById('BCP_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="BCP_radio" class="radio_text"></div>
                    </div>
                    <div id="BCP_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" id="BCP_HM" style="overflow-y:scroll;">
                            fragment size<br>
                            <h6>-f;Here fragment size is decided by the ChIP experiment sonication size (default value is 200bp)</h6>
                            <input type="text" value="200" class="input_setting_text" name="BCP_f">
                            window size<br>
                            <h6>Window size is a resolution parameter that is decided by user.We recommend 200bp as the default value because it isapproximately the size of a single nucleosome. </h6>
                            <input type="text" value="200" class="input_setting_text" name="BCP_W">
                            <br> p-value<br>
                            <h6>P-values are used when calling signicant segments compared to control data (default is 1e-3). </h6>
                            <input type="text" value="1e-3" class="input_setting_text" name="BCP_p">
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('BCP_optional_setting').style.display='none';JavaScript:BCP_radio_HM(BCP_f.value,BCP_W.value,BCP_p.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('BCP_optional_setting').style.display='none';"/>
                        </div>

                        <div class="inputOption_setting_center" id="BCP_TF" style="overflow-y:scroll;display:none">
                            old enrichment<br>
                            <h6>-e;Fold enrichment is used when estimating shift size.The default value is 10 and we recommend users restrict within the range of 5
                            </h6>
                            <input type="text" value="10" class="input_setting_text" name="BCP_e">
                            <br>p-value<br>
                            <h6>p-value is also used to choose really significant peaks compared to the control data.The default p-value in the TFBS case is 1e-8. </h6>
                            <input type="text" value="1e-8" class="input_setting_text" name="BCP_p2">
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('BCP_optional_setting').style.display='none';JavaScript:BCP_radio_TF(BCP_e.value,BCP_p2.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('BCP_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_BCP"/>
                <div id="wait_BCP" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_15" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(15);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_15" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_15').style.display='none'"/>
                </div>
            </div>
        </div>
        <!------------------------diffReps-------------------------------------------------------------->
        <div id="side_right_16" class="side_right" style="display:none">
            <form action="diff_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_diff').style.backgroundColor='#666666';document.getElementById('wait_diff').style.display='block';">
                <div class="link" onclick="JavaScript:diff_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right24" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down24" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_diff" class="necessary_center" style="display:block">
                    <div class="blacktop_1">
                        ChIP-Seq Tag file
                        <s:fielderror fieldName="input_diff_tagfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_diff_tagfile" id="input_diff_tagfile" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_diff" class="fileField" id="fileField_diff_tag" onchange="document.getElementById('input_diff_tagfile').value=this.value;fileChange(this,'input_diff_tagfile');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        ChIP-Seq control file
                        <div class="tip_out"><img class="tip" id="tip28" src="./img/tip.png" onclick="JavaScript:Tip_click(28)"></div>
                        <s:fielderror fieldName="input_diff_controlfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_diff_controlfile" id="input_diff_controlfile" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_diff" class="fileField" id="fileField_diff_control" onchange="document.getElementById('input_diff_controlfile').value=this.value;fileChange(this,'input_diff_controlfile');" />
                        </div>
                    </div>
                    <div class="blacktop_1">Choose the currently built-in genomes</div>
                    <div class="blackdown_1">
                        <input type="radio" value="1" name="diff_gn" />mm9
                        <input type="radio" value="2" name="diff_gn" checked="true"/>hg19
                        <input type="radio" value="3" name="diff_gn"/>rn4
                    </div>
                </div>
                <div class="link" onclick="JavaScript:diff_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right25" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down25" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_diff" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_diff" id="optionalParameters_default_diff" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('diff_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_diff" id="optionalParameters_set_diff" class="optionalParameters_set" value="2" onclick="document.getElementById('diff_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="diff_radio" class="radio_text"></div>
                    </div>
                    <div id="diff_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            --mode<br>
                            <h6>Scanning mode: a selection implies a different window size.<br>
                                Set window and step size manually to override.<br>
                                (p)eak      (=1000)  Histone mark peak (Default).<br>
                                (n)ucleosome(=200)   Single nucleosome (+DNAlinker).<br>
                                (b)lock     (=10000) Large chromatin modification block.<br>
                            </h6>
                            <input type="radio" value="1" checked="true"  name="diff_mode">peak
                            <input type="radio" value="2" name="diff_mode">nucleosome
                            <input type="radio" value="3" name="diff_mode">block<br>
                            --window(1000)<br>
                            <h6>Window size (default=Histone mark peak size).</h6>
                            <input type="text" value="1000" class="input_setting_text" name="diff_w"><br>
                            --step(1/10 win) <br>
                            <h6>Window moving step size.</h6>
                            <input type="text" value="1" class="input_setting_text" name="diff_step"><br>
                            --gap(0)<br>
                            <h6>Gap allowed between two consecutive windows.</h6>
                            <input type="text" value="0" class="input_setting_text" name="diff_gap"><br>
                            --nsd(broad)<br>
                            <h6>Z-score cutoff for low read count. Choose from two default modes or set your own.<br>
                                (b)road     (=2)   Broad peak such as H3K36me3.<br>
                                (s)harp     (=20)  Sharp peak such as H3K4me3 or Transcription factors.</h6>
                            <input type="radio" value="1" name="diff_nsd" checked="true">broad
                            <input type="radio" value="2" name="diff_nsd">sharp<br>
                            --alpha(0.05)  <br>
                            <h6>Alpha for right-trimmed mean, must be in: [0, 0.5).</h6>
                            <input type="text" value="0.05" class="input_setting_text" name="diff_alpha"><br>
                            --bkg(0)<br>
                            <h6>Use fold enrichment vs. background as filter instead. Set a float number such as 2.0 here.</h6>
                            <input type="text" value="0" class="input_setting_text" name="diff_bkg">

                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('diff_optional_setting').style.display='none';JavaScript:diff_radio(diff_mode.value,diff_w.value,diff_step.value,diff_gap.value,diff_nsd.value,diff_alpha.value,diff_bkg.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('diff_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Execute" class="Execute_btn" id="btn_diff"/>
                <div id="wait_diff" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_16" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(16);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_16" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_16').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Shen, L., Shao, N. Y., Liu, X., Maze, I., Feng, J., & Nestler, E. J. (2012). Diffreps: detecting differential chromatin modification sites from chip-seq data with biological replicates. Plos One, 8(6), e65598.
            </div>
        </div>
        <!------------------------SISSRs-------------------------------------------------------------->
        <div id="side_right_17" class="side_right" style="display:none">
            <form action="SISSR_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_SISSR').style.backgroundColor='#666666';document.getElementById('wait_SISSR').style.display='block';">
                <div class="link" onclick="JavaScript:SISSR_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right26" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down26" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_SISSR" class="necessary_center" style="display:block">
                    <div class="blacktop_1">
                        ChIP-Seq Tag file
                        <div class="tip_out"><img class="tip" id="tip15" src="./img/tip.png" onclick="JavaScript:Tip_click(15)"></div>
                        <s:fielderror fieldName="input_SISSR_tagfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_SISSR_tagfile" id="input_SISSR_tagfile" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_sissr" class="fileField" id="fileField_sissr_tag" onchange="document.getElementById('input_SISSR_tagfile').value=this.value;fileChange(this,'input_SISSR_tagfile');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        ChIP-Seq control file
                        <div class="tip_out"><img class="tip" id="tip30" src="./img/tip.png" onclick="JavaScript:Tip_click(30)"></div>
                        <s:fielderror fieldName="input_SISSR_controlfile" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_SISSR_controlfile" id="input_SISSR_controlfile" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_sissr" class="fileField" id="fileField_sissr_control" onchange="document.getElementById('input_SISSR_controlfile').value=this.value;fileChange(this,'input_SISSR_controlfile');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Genome size (or length).
                        <s:fielderror fieldName="input_SISSR_size" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="text" name="input_SISSR_size" id="input_SISSR_size" class="input_text"/>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:SISSR_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right27" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down27" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_SISSR" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_SISSR" id="optionalParameters_default_SISSR" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('SISSR_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_SISSR" id="optionalParameters_set_SISSR" class="optionalParameters_set" value="2" onclick="document.getElementById('SISSR_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="SISSR_radio" class="radio_text"></div>
                    </div>
                    <div id="SISSR_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            False discovery rate if random background model based on Poisson probabilities need to be
                            used as control<br>
                            <h6>
                                i.e., no background data is available.Default: 0.001
                            </h6>
                            <input type="text" value="0.001" class="input_setting_text" name="SISSR_D"><br>
                            e-value threshold.<br>
                            <h6>It is the maximum number of “enriched regions” one can expect to see by
                                chance (Poisson probabilities), when analyzing a similar-sized dataset.Default: 10</h6>
                            <input type="text" value="10" class="input_setting_text" name="SISSR_e"><br>
                            p-value threshold.<br>
                            <h6>For a given F value (average DNA fragment length) and a candidate binding
                                site (represented as genomic coordinate t in Fig 1 of Jothi et al [1]), let u be the number of tags
                                mapped to the region [t - F, t] on the sense strand, and let v be the number of tags mapped to the
                                region [t, t + F] on the anti-sense strand.Default: 0.001</h6>
                            <input type="text" value="0.001" class="input_setting_text" name="SISSR_p"><br>
                            Fraction of genome (0.0 to 1.0) mappable by reads.<br>
                            <h6>Default: 0.8 for hg18, assuming ELAND was used for mapping. This could be different for
                                different organisms and other mapping algorithms.</h6>
                            <input type="text" value="0.8" class="input_setting_text" name="SISSR_m"><br>
                            Size of the overlapping/sliding scanning window (must be an even number >1), which is one of
                            the parameters that attempts to control for noise in the data<br>
                            <h6>The amount of background noise in the data is a important factor one needs to
                                consider before setting the size of the window.
                                Default: 20</h6>
                            <input type="text" value="20" class="input_setting_text" name="SISSR_w"><br>
                            Number of “directional” reads required within F base pairs on either side of the inferred
                            binding site.<br>
                            <h6>Default: 2 (assuming that the data file contains ~2 to ~5 million reads; the value may need to
                                be increased if the total number of reads is much larger).</h6>
                            <input type="text" value="2" class="input_setting_text" name="SISSR_E">
                            Upper-bound on the DNA fragment length. It is the approximate length/size of the longest
                            DNA fragment that was sequenced.<br>
                            <h6>Default: 500</h6>
                            <input type="text" value="500" class="input_setting_text" name="SISSR_L">
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('SISSR_optional_setting').style.display='none';JavaScript:SISSR_radio(SISSR_D.value,SISSR_e.value,SISSR_p.value,SISSR_m.value,SISSR_w.value,SISSR_E.value,SISSR_L.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('SISSR_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_SISSR"/>
                <div id="wait_SISSR" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_17" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(17);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_17" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_17').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Jothi, R., Cuddapah, S., Barski, A., Cui, K., & Zhao, K. (2008). Genome-wide identification of in vivo protein-dna binding sites from chip-seq data.Nucleic Acids Research, 36(16), 5221.
            </div>
        </div>
        <!------------------------findpeaks-------------------------------------------------------------->
        <div id="side_right_18" class="side_right" style="display:none">
            <form action="findpeaks_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_find').style.backgroundColor='#666666';document.getElementById('wait_find').style.display='block';">
                <div class="link" onclick="JavaScript:findpeak_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right28" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down28" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_findpeaks" class="necessary_center" style="display:block">
                    <div class="blacktop_1">Determines which aligner input to use</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="radio" name="findpeak_format" value="1" checked="true">ELAND
                            <input type="radio" name="findpeak_format" value="2" >BED
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input the ChIP-Seq file
                        <s:fielderror fieldName="input_findpeaks_file" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_findpeaks_file" id="input_findpeaks_file" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_find" class="fileField" id="fileField_find_tag" onchange="document.getElementById('input_findpeaks_file').value=this.value;fileChange(this,'input_findpeaks_file');" />
                        </div>
                    </div>

                    <div class="blacktop_1">
                        Input effective genome size
                        <s:fielderror fieldName="input_findpeaks_gs" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="text" name="input_findpeaks_gs" id="input_findpeaks_gs" class="input_text"/>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:findpeak_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right29" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down29" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_findpeaks" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_findpeaks" id="optionalParameters_default_findpeaks" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('findpeaks_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_findpeaks" id="optionalParameters_set_findpeaks" class="optionalParameters_set" value="2" onclick="document.getElementById('findpeaks_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="findpeak_radio" class="radio_text"></div>
                    </div>
                    <div id="findpeaks_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            -directional<br>
                            <h6>
                                Engages directional mode, which considers directional reads for identifying the location of the maximum
                                peak height. This may be useful for refining narrow peaks and filtering out noise.
                                If flag is omitted: directional mode is not engaged.
                            </h6>
                            <input type="radio" name="findpeak_dir" value="1"/>on
                            <input type="radio" name="findpeak_dir" value="2" checked="true"/>off<br>
                            <br>-dist_type <br>
                            <h6>0: fixed width model<br>
                                1: triangle distribution<br>
                                2: Adaptive (sampled) distribution<br>
                                3: Native mode<br>
                                default:1 200
                            </h6>
                            <input type="text" value="1 200" class="input_setting_text" name="findpeak_type"/>
                           <br> -filter<br>
                            <h6>Turns on duplicate filtering. Filtering is currently only performed to remove reads in the same direction
                                that share a start location.
                                If flag is omitted: duplicate filtering is off.
                            </h6>
                            <input type="radio" name="findpeak_filter" value="1"/>on
                            <input type="radio" name="findpeak_filter" value="2" checked="true"/>off
                            <br>-hist_size<br>
                            <h6>The number of cells in the output FDR histogram. The length of the histogram does not affect the running
                                of the FindPeaks application, but only the maximum height for which data is shown in the final summary.
                                Histogram always starts at one.
                                If flag is omitted: histogram size is set to 30.</h6>
                            <input type="text" value="30" class="input_setting_text" name="findpeak_hs"/>
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('findpeaks_optional_setting').style.display='none';JavaScript:findpeak_radio(findpeak_dir.value,findpeak_type.value,findpeak_filter.value,findpeak_hs.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('findpeaks_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_find"/>
                <div id="wait_find" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_18" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(18);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_18" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_18').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Fejes, A. P., Robertson, G., Bilenky, M., Varhol, R., Bainbridge, M., & Jones, S. J. M. (2008). Findpeaks 3.1: a tool for identifying areas of enrichment from massively parallel short-read sequencing technology.Bioinformatics, 24(15), 1729.
            </div>
        </div>
        <!------------------------AREM------------------------------------------------------------->
        <div id="side_right_19" class="side_right" style="display:none">
            <form action="AREM_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_AREM').style.backgroundColor='#666666';document.getElementById('wait_AREM').style.display='block';">
                <div class="link" onclick="JavaScript:AREM_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right38" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down38" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_AREM" class="necessary_center" style="display:block">

                    <div class="blacktop_1">
                        Input the ChIP-Seq file
                        <s:fielderror fieldName="input_AREM_file" cssStyle="color:red;float:right;margin-top:0px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_AREM_file" id="input_AREM_file" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_arem" class="fileField" id="fileField_arem_tag" onchange="document.getElementById('input_AREM_file').value=this.value;fileChange(this,'input_AREM_file');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input the control file
                        <div class="tip_out"><img class="tip" id="tip32" src="./img/tip.png" onclick="JavaScript:Tip_click(32)"></div>
                        <s:fielderror fieldName="input_AREM_control" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_AREM_control" id="input_AREM_control" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_arem" class="fileField" id="fileField_arem_control" onchange="document.getElementById('input_AREM_control').value=this.value;fileChange(this,'input_AREM_control');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:AREM_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right39" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down39" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_AREM" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_AREM" id="optionalParameters_default_AREM" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('AREM_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_AREM" id="optionalParameters_set_AREM" class="optionalParameters_set" value="2" onclick="document.getElementById('AREM_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="AREM_radio" class="radio_text"></div>
                    </div>
                    <div id="AREM_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            -g GSIZE, --gsize=GSIZE<br>
                            <h6>Effective genome size. It can be 1.0e+9 or 1000000000,
                                or shortcuts:'hs' for human (2.7e9), 'mm' for mouse
                                (1.87e9), 'ce' for C. elegans (9e7) and 'dm' for
                                fruitfly (1.2e8), Default:hs</h6>
                            <input type="text" value="hs" class="input_setting_text" name="AREM_g"><br>
                            -s TSIZE, --tsize=TSIZE<br>
                            <h6>Tag size. This will overide the auto detected tag
                                size. DEFAULT: 25</h6>
                            <input type="text" value="25" class="input_setting_text" name="AREM_s"><br>
                            --bw=BW       <br>
                            <h6>Band width. This value is only used while building the
                                shifting model. DEFAULT: 300</h6>
                            <input type="text" value="300" class="input_setting_text" name="AREM_bw"><br>
                            -p PVALUE, --pvalue=PVALUE<br>
                            <h6>Pvalue cutoff for peak detection. DEFAULT: 1e-5</h6>
                            <input type="text" value="1e-5" class="input_setting_text" name="AREM_p"><br>
                            -m MFOLD, --mfold=MFOLD<br>
                            <h6>Select the regions within MFOLD range of high-
                                confidence enrichment ratio against background to
                                build model. The regions must be lower than upper
                                limit, and higher than the lower limit. DEFAULT:10,30</h6>
                            <input type="text" value="10,30" class="input_setting_text" name="AREM_m"><br>
                            --slocal=SMALLLOCAL <br>
                            <h6>The small nearby region in basepairs to calculate
                                dynamic lambda. This is used to capture the bias near
                                the peak summit region. Invalid if there is no control
                                data. DEFAULT: 1000</h6>
                            <input type="text" value="1000" class="input_setting_text" name="AREM_slocal"><br>
                            --shiftsize=SHIFTSIZE<br>
                            <h6>The arbitrary shift size in bp. When nomodel is true,
                                MACS will use this value as 1/2 of fragment size.
                                DEFAULT: 100</h6>
                            <input type="text" value="100" class="input_setting_text" name="AREM_shift"><br>
                            --verbose=VERBOSE   <br>
                            <h6>Set verbose level. 0: only show critical message, 1:
                                show additional warning message, 2: show process
                                information, 3: show debug messages. DEFAULT:2</h6>
                            <input type="text" value="2" class="input_setting_text" name="AREM_verbose"><br>
                            --fe-min=FEMIN     <br>
                            <h6>For diagnostics, min fold enrichment to consider.
                                DEFAULT: 0</h6>
                            <input type="text" value="0" class="input_setting_text" name="AREM_femin"><br>
                            --EM-converge-diff=MIN_CHANGE<br>
                            <h6>The minimum entropy change between iterations before
                                halting E-M steps. DEFAULT : 1e-05</h6>
                            <input type="text" value="1e-05" class="input_setting_text" name="AREM_EM_cd"><br>
                            --EM-min-score=MIN_SCORE<br>
                            <h6>Minimum enrichment score. Windows below this threshold
                                will all look the same to the aligner. DEFAULT : 1.5</h6>
                            <input type="text" value="1.5" class="input_setting_text" name="AREM_EM_min"><br>
                            --prior-snp=PRIOR_PROB_SNP<br>
                            <h6>Prior probability that a SNP occurs at any base in the
                                genome. DEFAULT : 0.001</h6>
                            <input type="text" value="0.001" class="input_setting_text" name="AREM_ps">
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('AREM_optional_setting').style.display='none';JavaScript:AREM_radio(findpeak_dir.value,findpeak_type.value,findpeak_filter.value,findpeak_hs.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('AREM_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_AREM"/>
                <div id="wait_AREM" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_19" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(19);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_19" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_19').style.display='none'"/>
                </div>
            </div>
        </div>
        <!------------------------Fseq------------------------------------------------------------->
        <div id="side_right_20" class="side_right" style="display:none">
            <form action="Fseq_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_fseq').style.backgroundColor='#666666';document.getElementById('wait_fseq').style.display='block';">
                <div class="link" onclick="JavaScript:Fseq_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right40" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down40" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_Fseq" class="necessary_center" style="display:block">

                    <div class="blacktop_1">
                        Input the ChIP-Seq file
                        <s:fielderror fieldName="input_Fseq_file" cssStyle="color:red;float:right;margin-top:0px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_Fseq_file" id="input_Fseq_file" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_fseq" class="fileField" id="fileField_fseq_tag" onchange="document.getElementById('input_Fseq_file').value=this.value;fileChange(this,'input_Fseq_file');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input the control file
                        <div class="tip_out">
                            <img class="tip" id="tip34" src="./img/tip.png" onclick="JavaScript:Tip_click(34)">
                        </div>
                        <s:fielderror fieldName="input_Fseq_control" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_Fseq_control" id="input_Fseq_control" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_fseq" class="fileField" id="fileField_fseq_control" onchange="document.getElementById('input_Fseq_control').value=this.value;fileChange(this,'input_Fseq_control');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:Fseq_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right41" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down41" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_Fseq" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_Fseq" id="optionalParameters_default_Fseq" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('Fseq_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_Fseq" id="optionalParameters_set_Fseq" class="optionalParameters_set" value="2" onclick="document.getElementById('Fseq_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="Fseq_radio" class="radio_text"></div>
                    </div>
                    <div id="Fseq_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            -l <br>
                            <h6>feature length (default=600)</h6>
                            <input type="text" value="600" class="input_setting_text" name="Fseq_l"/><br>
                            -s <br>
                            <h6>wiggle track step (default=1)</h6>
                            <input type="text" value="1" class="input_setting_text" name="Fseq_s"/><br>
                            -t <br>
                            <h6>threshold (standard deviations) (default=4.0)</h6>
                            <input type="text" value="4.0" class="input_setting_text" name="Fseq_t"/><br>
                            -v   <br>
                            <h6>verbose output</h6>
                            <input type="radio" name="Fseq_v" value="1"/>on
                            <input type="radio" name="FSeq_v" value="2" checked="true"/>off<br>
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('Fseq_optional_setting').style.display='none';JavaScript:Fseq_radio(Fseq_l.value,Fseq_s.value,Fseq_t.value,Fseq_v.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('Fseq_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_fseq"/>
                <div id="wait_fseq" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_20" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(20);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_20" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_20').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Boyle, A. P., Guinney, J., Crawford, G. E., & Furey, T. S. (2008). F-seq: a feature density estimator for high-throughput sequence tags.Bioinformatics, 24(21), 2537-2538.
            </div>
        </div>
        <!------------------------BroadPeak------------------------------------------------------------->
        <div id="side_right_21" class="side_right" style="display:none">
            <form action="BroadPeak_peakcalling" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_broad').style.backgroundColor='#666666';document.getElementById('wait_broad').style.display='block';">
                <div class="link" onclick="JavaScript:BroadPeak_option_ne();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right42" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down42" style="display:block"></div>
                    Necessary parameters
                </div>
                <div id="necessary_center_BroadPeak" class="necessary_center" style="display:block">

                    <div class="blacktop_1">
                        Input the ChIP-Seq file
                        <div class="tip_out"><img class="tip" id="tip17" src="./img/tip.png" onclick="JavaScript:Tip_click(17)"></div>
                        <s:fielderror fieldName="input_BroadPeak_file" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_BroadPeak_file" id="input_BroadPeak_file" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_broad" class="fileField" id="fileField_broad_tag" onchange="document.getElementById('input_BroadPeak_file').value=this.value;fileChange(this,'input_BroadPeak_file');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Input the control file
                        <div class="tip_out"><img class="tip" id="tip36" src="./img/tip.png" onclick="JavaScript:Tip_click(36)"></div>
                        <s:fielderror fieldName="input_BroadPeak_control" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_BroadPeak_control" id="input_BroadPeak_control" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_broad" class="fileField" id="fileField_broad_control" onchange="document.getElementById('input_BroadPeak_control').value=this.value;fileChange(this,'input_BroadPeak_control');" />
                        </div>
                    </div>

                </div>
                <div class="link" onclick="JavaScript:BroadPeak_option_op();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right43" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down43" style="display:block"></div>
                    Optional parameters
                </div>
                <div id="optional_center_BroadPeak" class="optional_center" style="display:block">
                    <div class="blacktop_1">optional parameters</div>
                    <div class="blackdown_1">
                        <input type="radio" name="optionalParameters_BroadPeak" id="optionalParameters_default_BroadPeak" class="optionalParameters_default" value="1" checked="true" onclick="document.getElementById('BroadPeak_optional_setting').style.display='none'"/>default
                        <input type="radio" name="optionalParameters_BroadPeak" id="optionalParameters_set_BroadPeak" class="optionalParameters_set" value="2" onclick="document.getElementById('BroadPeak_optional_setting').style.display='block'"/>set the parameters by yourself
                        <div id="BroadPeak_radio" class="radio_text"></div>
                    </div>
                    <div id="BroadPeak_optional_setting" class="inputOption_setting" style="display:none">
                        <div class="inputOption_setting_center" style="overflow-y:scroll;">
                            -b: The size of bin<br>
                            <h6>default value 200 (bp). It should be consistent with the bedGraph format input file</h6>
                            <input type="text" value="200" class="input_setting_text" name="BroadPeak_b"/><br>
                            -g: The size of the genome under consideration<br>
                            <h6>default value 3107677273 (bp) for the human genome
                                (hg18).</h6>
                            <input type="text" value="3107677273" class="input_setting_text" name="BroadPeak_g"/>
                            <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('BroadPeak_optional_setting').style.display='none';JavaScript:BroadPeak_radio(BroadPeak_b.value,BroadPeak_g.value);"/>
                            <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('BroadPeak_optional_setting').style.display='none';"/>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_broad"/>
                <div id="wait_broad" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_21" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(21);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_21" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_21').style.display='none'"/>
                </div>
            </div>

        </div>
      <!------------------------Samtools-------------------------------------------------------------->
        <div id="side_right_22" class="side_right" style="display:none">
            <div class="link" style="cursor:hand;" onclick="JavaScript:samtools_option(1);">
                <div class="arrow-right" id="arrow-right5" style="display:none"></div>
                <div class="arrow-down"  id="arrow-down5" style="display:block"></div>
                Format convert<h8>(convert SAM to BAM/convert BAM to SAM)
            </h8>
            </div>
            <form action="SAM_TO_BAM" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_sam1').style.backgroundColor='#666666';document.getElementById('wait_sam1').style.display='block';">
            <div id="samtools_center_1" class="necessary_center" style="display:block">
                    <div class="blacktop_1">
                        Choose the convert type
                        <s:fielderror fieldName="samtools_convert_type" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="radio" name="samtools_convert_type" value="1" />SAM to BAM
                        <input type="radio" name="samtools_convert_type" value="2" />BAM to SAM
                    </div>
                    <div class="blacktop_1">
                        Input the file to be converted
                        <s:fielderror fieldName="samtobam_origin" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box" style="display:block">
                            <input type="text" name="samtobam_origin" class="input_text" id="samtobam_origin"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_samtools_origin" class="fileField" id="fileField_samtools_origin" onchange="document.getElementById('samtobam_origin').value=this.value;fileChange(this,'samtobam_origin');" />
                        </div>
                    </div>

                    <input type="submit" value="Execute" class="Execute_btn_samtools" id="btn_sam1"/>
                    <div id="wait_sam1" class="Upload_wait_div" style="display:none;">
                        <img src="./img/wait.gif" class="Upload_wait" />
                        Uploading and processing your file,please wait...
                    </div>
            </div>
        </form>
            <div class="link" onclick="JavaScript:samtools_option(2);"style="cursor:hand;">
                <div class="arrow-right" id="arrow-right6" style="display:none"></div>
                <div class="arrow-down"  id="arrow-down6" style="display:block"></div>
                Sort BAM dataset
            </div>
            <form action="samtools_sort" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_sam2').style.backgroundColor='#666666';document.getElementById('wait_sam2').style.display='block';">
                <div id="samtools_center_2" class="necessary_center" style="display:none">
                    <div class="blacktop_1">
                        Input .bam file
                        <s:fielderror fieldName="input_samtools_sort" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="input_samtools_sort" id="input_samtools_sort" class="input_text"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_samtools_sort" class="fileField" id="fileField_samtools_sort" onchange="document.getElementById('input_samtools_sort').value=this.value;fileChange(this,'input_samtools_sort');" />
                        </div>
                    </div>

                <input type="submit" value="Execute" class="Execute_btn_samtools" id="btn_sam2"/>
                <div id="wait_sam2" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
                </div>
                </form>


            <div class="link" onclick="JavaScript:samtools_option(3);"style="cursor:hand;">
                <div class="arrow-right" id="arrow-right7" style="display:none"></div>
                <div class="arrow-down"  id="arrow-down7" style="display:block"></div>
                Index reference sequence in the FASTA ,BAM  or CRAM format.
            </div>
        <form action="samtools_index" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_sam3').style.backgroundColor='#666666';document.getElementById('wait_sam3').style.display='block';">
            <div id="samtools_center_3" class="necessary_center" style="display:block">
                <div class="blacktop_1">
                    Choose the input format.
                    <s:fielderror fieldName="samtools_index_radio" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                </div>
                <div class="blackdown_1">
                    <input type="radio" name="samtools_index_radio" value="1" onclick="document.getElementById('samtools_index_fa').style.display='block';document.getElementById('samtools_index_bam').style.display='none';document.getElementById('samtools_index_cram').style.display='none';"/>FASTA
                    <input type="radio" name="samtools_index_radio" value="2" onclick="document.getElementById('samtools_index_bam').style.display='block';document.getElementById('samtools_index_fa').style.display='none';document.getElementById('samtools_index_cram').style.display='none';"/>BAM
                    <input type="radio" name="samtools_index_radio" value="3" onclick="document.getElementById('samtools_index_cram').style.display='block';document.getElementById('samtools_index_fa').style.display='none';document.getElementById('samtools_index_bam').style.display='none';"/>CRAM
                </div>
                <div class="blacktop_1">
                    Input file to build index
                    <s:fielderror fieldName="input_samtools_index" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                </div>
                <div class="blackdown_1">
                    <div class="file-box" style="display:block">
                        <input type="text" name="input_samtools_index" id="input_samtools_index" class="input_text"/>
                        <input type='button' class='btn' value='Choose File' />
                        <input type="file" name="fileField_samtools_index" class="fileField" id="fileField_samtools_index" onchange="document.getElementById('input_samtools_index').value=this.value;fileChange(this,'input_samtools_index');" />
                    </div>
                </div>
                <input type="submit" value="Execute" class="Execute_btn_samtools" id="btn_sam3"/>
                <div id="wait_sam3" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </div>
        </form>
            <div id="detail_text_22" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(22);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_22" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_22').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Li, H., Handsaker, B., Wysoker, A., Fennell, T., Ruan, J., & Homer, N., et al. (1987). The sequence alignment/map (sam) format and samtools.Transplantation Proceedings, 19(1 Pt 2), 1653-4.
            </div>
        </div>
        <!------------------------bamCoverage-------------------------------------------------------->
        <div id="side_right_23" class="side_right" style="display: none">
            <form action="bamCoverage_exe" enctype="multipart/form-data" method="post" onsubmit="document.getElementById('btn_bam').style.backgroundColor='#666666';document.getElementById('wait_bam').style.display='block';">
                <div id="bamCoverage_center" class="necessary_center" >
                    <div class="blacktop_1">
                        Choose the format of the input file
                        <s:fielderror fieldName="convert_sam" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="radio" name="convert_sam" value="1">SAM
                        <input type="radio" name="convert_sam" value="2">BAM
                    </div>
                    <div class="blacktop_1">
                        Input the file to convert
                        <s:fielderror fieldName="convert_file" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <div class="file-box" style="display:block">
                            <input type="text" name="convert_file" class="input_text" id="convert_file"/>
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file" name="fileField_samtools_convert" class="fileField" id="fileField_samtools_convert" onchange="document.getElementById('convert_file').value=this.value;fileChange(this,'convert_file');" />
                        </div>
                    </div>
                    <div class="blacktop_1">
                        Coverage file format
                        <s:fielderror fieldName="convert_for" cssStyle="color:red;float:right;margin-top:0px;margin-right:10px;"  />
                    </div>
                    <div class="blackdown_1">
                        <input type="radio" name="convert_for" value="1">bedgraph
                        <input type="radio" name="convert_for" value="2">bigwig
                    </div>

                </div>
                <input type="submit" value="Execute" class="Execute_btn" id="btn_bam"/>
                <div id="wait_bam" class="Upload_wait_div" style="display:none;">
                    <img src="./img/wait.gif" class="Upload_wait" />
                    Uploading and processing your file,please wait...
                </div>
            </form>
            <div id="detail_text_23" class="detail_tip" style="display:none" >
                If you want to get detail information about the operation which just finished, please <a href="JavaScript:operation_detail(23);" style="text-decoration: none;color:#666666">click here</a>.
                And the result files will be sent to you by email as soon as possible.
            </div>
            <div id="detail_23" class="inputOption_setting_de" style="display:none;">
                <div class="inputOption_setting_center_de" style="overflow-y:scroll;">
                    ${stdoutlist}<br>
                        <input type="button" value="close" class="btn_cancel" onclick="document.getElementById('detail_23').style.display='none'"/>
                </div>
            </div>
            <span style="color:#666666;font-size:20px;">Ref:</span> <br>
            <div class="citation">
                Ramírez, F., Dündar, F., Diehl, S., Grüning, B. A., & Manke, T. (2014). Deeptools: a flexible platform for exploring deep-sequencing data.Nucleic Acids Research, 42(W1), 187-91.
            </div>
        </div>
        <!------------------------IGV------------------------------------------------------------->
       <%-- <div id="side_right_22" class="side_right" style="display:none">
                <div class="link" onclick="JavaScript:IGV_mapping();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right44" style="display:none"></div>
                    <div class="arrow-down"  id="arrow-down44" style="display:block"></div>
                    Visualization of mapping
                </div>
                <div id="IGV_center_1" class="necessary_center" style="display:block;overflow-y:scroll;">
                    <s:form action="mapping_visual">
                    <div class="blacktop_1">Input the Sam file(after mapping)</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="sampath" id="input_sam_mavisual" class="input_text"/>
                        </div>
                    </div>
                    <div class="blacktop_1">Input the reference file</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="workflowCustom_reference" id="input_reference_mavisual" class="input_text"/>
                        </div>
                    </div>
                    <div class="blacktop_1">Input the path to save result</div>
                    <div class="blackdown_1">
                        <input type="text" name="workflowCustom_path" id="workflowCustom_path" class="input_text"/>
                    </div>
                    <div class="blacktop_1">Input the scope of the gene</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type='text' name='mapping_visual_scope' id="input_scope_mavisual" class='input_text' />
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file"  class="fileField"  onchange="document.getElementById('input_scope_mavisual').value=this.value" /><br>
                        </div>
                    </div>
                    <s:submit value="View" cssStyle="margin-bottom:10px;margin-top:10px;margin-left:10px;width:80px; height:30px; border: 01px ; background:#F9A32D;color: #ffffff; border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;border-top-left-radius: 5px;border-top-right-radius: 5px;"></s:submit>
                    </s:form>
            <div class="outer" onclick="JavaScript:expandPhoto();">
                <img  src="http://192.168.1.113:9080/ChIP-Seq_linux_war/img/mapping_visual.png" />
            </div>
                </div>


                <div class="link" onclick="JavaScript:IGV_peakcalling();"style="cursor:hand;">
                    <div class="arrow-right" id="arrow-right45" style="display:block"></div>
                    <div class="arrow-down"  id="arrow-down45" style="display:none"></div>
                    Visualization of peakcalling
                </div>
                <div id="IGV_center_2" class="optional_center" style="display:none;overflow-y:scroll;">
                    <s:form action="peakcalling_visual">
                    <div class="blacktop_1">Input the Sam file(after mapping) of treatment</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="bampath_treatment" id="input_samtreat_pevisual" class="input_text"/>
                        </div>
                    </div>
                    <div class="blacktop_1">Input the Sam file(after mapping) of control</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="bampath_control" id="input_samcontrol_pevisual" class="input_text"/>
                        </div>
                    </div>
                    <div class="blacktop_1">Input the bed file(after peakcalling)</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="peakpath" id="input_peak_pevisual" class="input_text"/>
                        </div>
                    </div>
                    <div class="blacktop_1">Input the reference file</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type="text" name="workflowCustom_reference" id="input_refer_pevisual" class="input_text"/>
                        </div>
                    </div>
                    <div class="blacktop_1">Input the path to save result</div>
                    <div class="blackdown_1">
                            <input type="text" name="workflowCustom_path" id="input_path_pevisual" class="input_text"/>
                    </div>
                    <div class="blacktop_1">Input the scope of the gene</div>
                    <div class="blackdown_1">
                        <div class="file-box">
                            <input type='text' name='peakcalling_scope' id="input_scope_pevisual" class='input_text' />
                            <input type='button' class='btn' value='Choose File' />
                            <input type="file"  class="fileField"  onchange="document.getElementById('input_scope_pevisual').value=this.value" /><br>
                        </div>
                    </div>
                    <s:submit value="View" cssStyle="margin-bottom:10px;margin-top:10px;margin-left:10px;width:80px; height:30px; border: 01px ; background:#F9A32D;color: #ffffff; border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;border-top-left-radius: 5px;border-top-right-radius: 5px;"></s:submit>
                    </s:form>
            <div class="outer" onclick="JavaScript:expandPhoto1();">
                <img src="http://192.168.1.113:9080/ChIP-Seq_linux_war/img/peakcalling_visual.png"/>
            </div>
                    </div>
                </div>--%>

        </div>
    </div>
    <div id="foot">
        Copyright © 2016 - CSU-Bioinformatics Group | All Rights Reserved
    </div>
  </div>
</body>
</html>
