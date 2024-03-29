<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2017/4/26
  Time: 18:38
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
  <link rel="stylesheet" href="./layer/skin/layer.css">
  <link rel="stylesheet" href="./layer/skin/layer.ext.css">
  <link rel="stylesheet" href="./css/banner.css">
  <link rel="stylesheet" href="./css/workflow.css">
  <script src="./jquery-1.11.1/jquery.js"></script>
  <script src="./layer/layer.js"></script>
  <script src="./js/banner.js"></script>
  <script src="./js/workflow.js"></script>
</head>
<body>
<div id="attention" class="blackdown_tips_1">
  The input of Demo workflow has been filled on this page. Please click the "Execute" to run the demo.
  <br>
</div>

  <div class="blacktop_1">
    Select type of the input
  </div>
  <div class="blackdown_1">
    <input type="radio" name="workflow_type" value="1" checked="true" onclick="document.getElementById('file-box_workflow_sequence').style.display='block';document.getElementById('file-box_workflow_paired').style.display='none';">single-end
    <input type="radio" name="workflow_type" value="2" onclick="document.getElementById('file-box_workflow_sequence').style.display='none';document.getElementById('file-box_workflow_paired').style.display='block';">paired-end
  </div>
  <div class="blacktop_1">
    Select reference to build index or use a built-in index
    <div class="tip_out"><img class="tip" id="tip2" src="./img/tip.png" onclick="JavaScript:Tip_click(2)"></div>
  </div>
  <div class="blackdown_2_workflow">
    <input type="radio" name="refer_index_workCustom"  value="1" checked="true" onclick="document.getElementById('file-box_workflow_reference').style.display='block';document.getElementById('workflowCustom_build').style.display='none';"/>Select reference to build index
    <input type="radio" name="refer_index_workCustom"  value="2" onclick="document.getElementById('file-box_workflow_reference').style.display='none';document.getElementById('workflowCustom_build').style.display='block';"/>Use a built-in index
    <div class="file-box" id="file-box_workflow_reference" style="display:block">
      <input type='text' name='workflowCustom_reference' id="workflowCustom_reference" value="Escherichia_coli_K12.fasta" class='input_text' />
      <input type='button' class='btn' value='Choose File' />
      <input type="file" name="fileField_workflow" class="fileField" id="fileField_workflow_re"  onchange="document.getElementById('workflowCustom_reference').value=this.value;fileChange(this,'workflowCustom_reference');" />
    </div>
    <div id="workflowCustom_build" style="display:none">
      <select name="workflowCustom_build" class="gomo_select">
        <option value="1" selected="selected">Human(b37) hg19</option>
        <option value="-2">Human(b37) hg38</option>
      </select><br>
    </div>
  </div>
  <div class="blacktop_1">
    Input the sequences file
    <div class="tip_out"><img class="tip" id="tip1" src="./img/tip.png" onclick="JavaScript:Tip_click(1)"></div>

  </div>
  <div class="blackdown_1">
    <div class="file-box" id="file-box_workflow_sequence" style="display:block">
      <input type='text' name='workflowCustom_sequence' id="workflowCustom_sequence" value="SRR576933.fastq" class='input_text' />
      <input type='button' class='btn' value='Choose File' />
      <input type="file" name="fileField_workflow" class="fileField" id="fileField_workflow_se" onchange="document.getElementById('workflowCustom_sequence').value=this.value;fileChange(this,'workflowCustom_sequence');" />
    </div>
    <div class="file-box" id="file-box_workflow_paired" style="display:none;">
      <input type="text" name="workflowCustom_sequence_pair1text" class="input_text_pair" id="workflowCustom_sequence_pair1"/>
      <input type='button' class='btn' value='Choose File' />
      <input type="file" name="fileField_workflow" class="fileField" id="fileField_workflow_file1" onchange="document.getElementById('workflowCustom_sequence_pair1').value=this.value;fileChange(this,'workflowCustom_sequence_pair1');" />
      <input type="text" name="workflowCustom_sequence_pair2" class="input_text_pair" id="workflowCustom_sequence_pair2"/>
      <input type='button' class='btn' value='Choose File' />
      <input type="file" name="fileField_workflow" class="fileField" id="fileField_workflow_file2" onchange="document.getElementById('workflowCustom_sequence_pair2').value=this.value;fileChange(this,'workflowCustom_sequence_pair2');" />
    </div>
  </div>

  <div class="blacktop_1">
    Input the control file
    <div class="tip_out"><img class="tip" id="tip3" src="./img/tip.png" onclick="JavaScript:Tip_click(3)"></div>
  </div>
  <div class="blackdown_1">
    <div class="file-box" style="display:block">
      <input type='text' name='workflowCustom_control' id="workflowCustom_control" class='input_text' value="SRR576938.fastq"/>
      <input type='button' class='btn' value='Choose File' />
      <input type="file" name="fileField_workflow" class="fileField" id="fileField_workflow_control" onchange="document.getElementById('workflowCustom_control').value=this.value;fileChange(this,'workflowCustom_control');" />
    </div>
  </div>

  <div class="blacktop_1">
    Mapping
    <div class="tip_out"><img class="tip" id="tip4" src="./img/tip.png" onclick="JavaScript:Tip_click(4)"></div>
  </div>
  <div class="blackdown_1_workflowCustom" style="overflow-y:scroll;">
    <input type="radio" name="workflowCustom_mapping" value="1" onclick="
                    document.getElementById('workflowCustom_option_1').style.display='block';
                    document.getElementById('workflowCustom_option_2').style.display='none';document.getElementById('workflowCustom_option_3').style.display='none';document.getElementById('workflowCustom_option_4').style.display='none';document.getElementById('workflowCustom_option_5').style.display='none';document.getElementById('workflowCustom_option_6').style.display='none';document.getElementById('workflowCustom_option_7').style.display='none';">BWA<h1>mapping DNA sequences against a large reference genome</h1>
    <div id="workflowCustom_option_1" style="display:none">
      -Choose the type of the reference genome.<br>
      <input type="radio" name="long_short" value="1"/>long genome
      <input type="radio" name="long_short" value="2" checked="true"/>short genome<br>
      -Whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_bwa" value="1" checked="true" onclick="document.getElementById('workflow_custom_bwa').style.display='none'">default
      <input type="radio" name="workflowCustom_option_bwa" value="2" onclick="document.getElementById('workflow_custom_bwa').style.display='block'">setting by yourself
    </div>
    <div id="workflow_custom_bwa" class="inputOption_setting" style="display:none;">
      <div class="inputOption_setting_center" style="overflow-y:scroll;">
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
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_bwa').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_bwa').style.display='none'"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_mapping" value="2" checked="true" onclick="document.getElementById('workflowCustom_option_1').style.display='none';document.getElementById('workflowCustom_option_2').style.display='block';document.getElementById('workflowCustom_option_3').style.display='none';document.getElementById('workflowCustom_option_4').style.display='none';document.getElementById('workflowCustom_option_5').style.display='none';document.getElementById('workflowCustom_option_6').style.display='none';document.getElementById('workflowCustom_option_7').style.display='none';">Bowtie<h2>short read aligner geared toward quickly aligning large sets of short DNA sequences (reads) to large genomes.</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_2" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_bowtie" value="1" onclick="document.getElementById('workflow_custom_bowtie').style.display='none'">default
      <input type="radio" name="workflowCustom_option_bowtie" value="2" checked="true" onclick="document.getElementById('workflow_custom_bowtie').style.display='block'">setting by yourself
    </div>
    <div class="inputOption_setting" id="workflow_custom_bowtie" style="display:none">
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
        <input type="text" name="bowtie_3" class="input_setting_text" value="1"/><br>
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
        Report up to k valid alignments per read or pair <br>
        <h6>-k ;default: 1 </h6>
        <input type="text" name="bowtie_k" class="input_setting_text" value="1"/><br>
        Report all valid alignments per read or pair <br>
        <h6>-a/--all ;default: off.</h6>
        <input type="radio" name="bowtie_a" value="1" checked="true"/>Off
        <input type="radio" name="bowtie_a" value="2"/>on<br>
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_bowtie').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_bowtie').style.display='none'"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_mapping" value="3" onclick="document.getElementById('workflowCustom_option_1').style.display='none';document.getElementById('workflowCustom_option_2').style.display='none';document.getElementById('workflowCustom_option_3').style.display='block';document.getElementById('workflowCustom_option_4').style.display='none';document.getElementById('workflowCustom_option_5').style.display='none';document.getElementById('workflowCustom_option_6').style.display='none';document.getElementById('workflowCustom_option_7').style.display='none';">Bowtie2<h3>aligning sequencing reads to long reference sequences.It is particularly good at aligning reads of about 50 up to 100s or 1,000s of characters to relatively long</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_3" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_bowtie2" value="1" onclick="document.getElementById('workflow_custom_bowtie2').style.display='none'">default
      <input type="radio" name="workflowCustom_option_bowtie2" value="2" onclick="document.getElementById('workflow_custom_bowtie2').style.display='block'">setting by yourself
    </div>
    <div class="inputOption_setting" id="workflow_custom_bowtie2" style="display:none;">
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
        Set the number of mismatches to be allowed in a seed alignment during multiseed alignment<br>
        <h6>-N; Can be set to 0 or 1. Setting this higher makes alignment slower (often much slower) but increases sensitivity; default=0</h6>
        <select name="alignment_N" class="GOMo_select"/>
        <option value="0" selected="selected">0</option>
        <option value="1">1</option>
        </select><br>
        Sets the length of the seed substrings to align during multiseed alignment<br>
        <h6>-L; Smaller values make alignment slower but more sensitive. Default=22</h6>
        <input type="text" name="alignment_L" class="input_setting_text" value="22"/><br>
        Set a function governing the interval between seed substrings to use during multiseed alignment.Also see description of this option below in the help section.<br>
        <h6>-i;Default=`S,1,1.15`</h6>
        <input type="text" name="alignment_i"class="input_setting_text" value="S,1,1.15"/><br>
        Set a function governing the maximum number of ambiguous characters (usually `N`s and/or `.`s) allowed in a read as a function of read length.<br>
        <h6>--n-ceil;Default=`L,0,0.15`</h6>
        <input type="text" name="alignment_n"class="input_setting_text" value="L,0,0.15"/><br>
        Pad dynamic programming problems by that many columns on either side to allow gaps.<br>
        <h6>--dpad; default=15</h6>
        <input type="text" name="alignment_dpad"class="input_setting_text" value="15"/><br>
        Disallow gaps within that many positions of the beginning or end of the read<br>
        <h6>--gbar; default=4</h6>
        <input type="text" name="alignment_gbar"class="input_setting_text" value="4"/><br>
        Set the match bonus<br>
        <h6>--ma; Default=2</h6>
        <input type="text" name="score_ma" class="input_setting_text" value="2"/><br>
        Set the maximum (`MX`) and minimum (`MN`) mismatch penalties, both integers<br>
        <h6>--mp;Default=6,2</h6>
        <input type="text" name="score_mp" class="input_setting_text" value="6,2"/><br>
        Sets penalty for positions where the read, reference, or both, contain an ambiguous character such as `N`<br>
        <h6>--np; Default=1</h6>
        <input type="text" name="score_np" class="input_setting_text" value="1"/><br>
        Set the read gap opening penalty<br>
        <h6>--rdg; this is the first component of --rdg flag - opening penalty; Default=5</h6>
        <input type="text" name="score_rdg5" class="input_setting_text" value="5"/><br>
        Set the read gap extension penalty<br>
        <h6>--rdg; this is the second component of --rdg flag - extension penalty; Default=3</h6>
        <input type="text" name="score_rdg3" class="input_setting_text" value="3"/><br>
        Set the reference gap opening penalty<br>
        <h6> --rfg; this is the first component of --rfg flag - opening penalty; Default=5</h6>
        <input type="text" name="score_rfg5" class="input_setting_text" value="5"/><br>
        Set the reference gap extension penalty<br>
        <h6>--rfg; this is the second component of --rfg flag - extension penalty; Default=3</h6>
        <input type="text" name="score_rfg3" class="input_setting_text" value="3"/><br>
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_bowtie2').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_bowtie2').style.display='none'"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_mapping" value="4" onclick="document.getElementById('workflowCustom_option_1').style.display='none';document.getElementById('workflowCustom_option_2').style.display='none';document.getElementById('workflowCustom_option_3').style.display='none';document.getElementById('workflowCustom_option_4').style.display='block';document.getElementById('workflowCustom_option_5').style.display='none';document.getElementById('workflowCustom_option_6').style.display='none';document.getElementById('workflowCustom_option_7').style.display='none';">SOAP<h3>SOAP has been in evolution from a single alignment tool package that provides full solution to next generation sequencing data analysis.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_4" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_SOAP" value="1" onclick="document.getElementById('workflow_custom_SOAP').style.display='none'">default
      <input type="radio" name="workflowCustom_option_SOAP" value="2" onclick="document.getElementById('workflow_custom_SOAP').style.display='block'">setting by yourself
    </div>
    <div class="inputOption_setting" id="workflow_custom_SOAP" style="display:none;">
      <div class="inputOption_setting_center"  style="overflow-y:scroll; ">
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
        <input type="text" name="SOAP_s" class="input_setting_text" value="255"/>
        -g
        <h6>one continuous gap size allowed on a read. [0] bp</h6>
        <input type="text" name="SOAP_g" class="input_setting_text" value="0"/><br>
        -e
        <h6>will not allow gap exist inside n-bp edge of a read, default=5</h6>
        <input type="text" name="SOAP_e" class="input_setting_text" value="5"/>
        -p
        <h6>number of processors to use, [1]</h6>
        <input type="text" name="SOAP_p" class="input_setting_text" value="1"/>
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_SOAP').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_SOAP').style.display='none'"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_mapping" value="5" onclick="document.getElementById('workflowCustom_option_1').style.display='none';document.getElementById('workflowCustom_option_2').style.display='none';document.getElementById('workflowCustom_option_3').style.display='none';document.getElementById('workflowCustom_option_4').style.display='none';document.getElementById('workflowCustom_option_5').style.display='block';document.getElementById('workflowCustom_option_6').style.display='none';document.getElementById('workflowCustom_option_7').style.display='none';">BLAST<h3>The program compares nucleotide or protein sequences to sequences databases and calculates the statistical significance.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_5" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_BLAST" value="1" onclick="document.getElementById('workflow_custom_BLAST').style.display='none'">default
      <input type="radio" name="workflowCustom_option_BLAST" value="2" onclick="document.getElementById('workflow_custom_BLAST').style.display='block'">setting by yourself
    </div>
    <div class="inputOption_setting" id="workflow_custom_BLAST" style="display:none;">
      <div class="inputOption_setting_center"  style="overflow-y:scroll; ">
        num_descriptions<br>
        <h6>default:500;Show one-line descriptions for this number of database sequences.</h6>
        <input type="text" name="blast_num_descriptions" class="input_setting_text" value="500"/>
        num_alignments	<br>
        <h6>default:250;Show alignments for this number of database sequences.</h6>
        <input type="text" name="blast_num_align" class="input_setting_text" value="250"/>
        max_target_seqs<br>
        <h6>default:500	Number of aligned sequences to keep.
          Use with report formats that do not have separate definition line and alignment sections such as tabular (all outfmt > 4). Not compatible with num_descriptions or num_alignments.</h6>
        <hao input type="text" name="blast_max_target_seqs" class="input_setting_text" value="500"/>
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_BLAST').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_BLAST').style.display='none'"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_mapping" value="6" onclick="document.getElementById('workflowCustom_option_1').style.display='none';document.getElementById('workflowCustom_option_2').style.display='none';document.getElementById('workflowCustom_option_3').style.display='none';document.getElementById('workflowCustom_option_4').style.display='none';document.getElementById('workflowCustom_option_5').style.display='none';document.getElementById('workflowCustom_option_6').style.display='block';document.getElementById('workflowCustom_option_7').style.display='none';">Subread<h3>The package comprises a suite of software programs for processing next-gen sequencing read data.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_6" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_Subread" value="1" onclick="document.getElementById('workflow_custom_Subread').style.display='none'">default
      <input type="radio" name="workflowCustom_option_Subread" value="2" onclick="document.getElementById('workflow_custom_Subread').style.display='block'">setting by yourself
    </div>
    <div class="inputOption_setting" id="workflow_custom_Subread" style="display:none;">
      <div class="inputOption_setting_center"  style="overflow-y:scroll; ">
        -B < int >( nBestLocations )<br>
        <h6>Specify the maximal number of equally-best mapping locations al-
          lowed to be reported for each read. 1 by default.
        </h6>
        <input type="text" name="Subread_B2" class="input_setting_text" value="1">
        -d < int >( minFragLength )<br>
        <h6>Specify the minimum fragment/template length, 50 by default.</h6>
        <input type="text" name="Subread_d" class="input_setting_text" value="50"/>
        -D < int >( maxFragLength )<br>
        <h6>Specify the maximum fragment/template length, 600 by default.</h6>
        <input type="text" name="Subread_D" class="input_setting_text" value="600"/>
        -I < int >( indels )<br>
        <h6>Specify the number of INDEL bases allowed in the mapping. 5 by
          default. Indels of up to 200bp long can be detected.</h6>
        <input type="text" name="Subread_I" class="input_setting_text" value="5"/>
        -m < int >( TH1 )<br>
        <h6>Specify the consensus threshold, which is the minimal number of
          consensus subreads required for reporting a hit.3 by default.</h6>
        <input type="text" name="Subread_m" class="input_setting_text" value="3"/>
        -M < int >( maxMismatches )<br>
        <h6>Specify the maximum number of mis-matched bases allowed in the
          alignment. 3 by default. Mis-matches found in soft-clipped bases
          are not counted.</h6>
        <input type="text" name="Subread_M2" class="input_setting_text" value="3"/>
        -n < int >( nsubreads )<br>
        <h6>Specify the number of subreads extracted from each read, 10 by
          default.</h6>
        <input type="text" name="Subread_n" class="input_setting_text" value="10"/>
        -p < int >( TH2 )<br>
        <h6>Specify the minimum number of consensus subreads both reads
          from the same pair must have.1 by default.</h6>
        <input type="text" name="Subread_p" class="input_setting_text" value="1"/>
        -P < 3 : 6 >( phredOffset )<br>
        <h6>Specify the format of Phred scores used in the input data, ’3’ for
          phred+33 and ’6’ for phred+64. ’3’ by default.</h6>
        <input type="text" name="Subread_P" class="input_setting_text" value="3"/>
        -S < f f : f r : rf >( PE orientation )<br>
        <h6>Specify the orientation of the two reads from the same pair. It has
          three possible values including ‘fr’, ‘ff’ and ‘’rf. Letter ‘f’ denotes
          the forward strand and letter ‘r’ the reverse strand. ‘fr’ by default</h6>
        <input type="text" name="Subread_S" class="input_setting_text" value="fr"/>
        -T < int >( nthreads )<br>
        <h6>Specify the number of threads/CPUs used for mapping. The value
          should be between 1 and 32. 1 by default.</h6>
        <input type="text" name="Subread_T" class="input_setting_text" value="1"/>
        −−trim5 < int >( nTrim5 )<br>
        <h6>Trim off < int > number of bases from 5’ end of each read. 0 by
          default.</h6>
        <input type="text" name="Subread_trim5" class="input_setting_text" value="0"/>
        −−trim3 < int >( nTrim3 )<br>
        <h6>Trim off < int > number of bases from 3’ end of each read. 0 by
          default.</h6>
        <input type="text" name="Subread_trim3" class="input_setting_text" value="0"/>
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_Subread').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_Subread').style.display='none'"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_mapping" value="7" onclick="document.getElementById('workflowCustom_option_1').style.display='none';document.getElementById('workflowCustom_option_2').style.display='none';document.getElementById('workflowCustom_option_3').style.display='none';document.getElementById('workflowCustom_option_4').style.display='none';document.getElementById('workflowCustom_option_5').style.display='none';document.getElementById('workflowCustom_option_6').style.display='none';document.getElementById('workflowCustom_option_7').style.display='block';">NGM<h3>It is a flexible highly sensitive short read mapping tool that handles much higher mismatch rates than comparable algorithms while still outperforming them in terms of runtime.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_7" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_NGM" value="1" onclick="document.getElementById('workflow_custom_NGM').style.display='none'">default
      <input type="radio" name="workflowCustom_option_NGM" value="2" onclick="document.getElementById('workflow_custom_NGM').style.display='block'">setting by yourself
    </div>
    <div class="inputOption_setting" id="workflow_custom_NGM" style="display:none;">
      <div class="inputOption_setting_center"  style="overflow-y:scroll; ">
        --force-rlength-check <br>
        <h6>Forces NextgenMap to run through all reads to
          find the max. read length. (default: off)</h6>
        <input type="radio" name="NGM_frc" value="1">on
        <input type="radio" name="NGM_frc" value="2" checked="true">off
        -n/--topn <br>
        <h6>Prints the n best alignments sorted by
          alignment score (default: 1)</h6>
        <input type="text" name="NGM_n" class="input_setting_text" value="1"/>
        --keep-tags <br>
        <h6>Copy BAM/SAM tags present in input file to
          output file (default: off)</h6>
        <input type="radio" name="NGM_kt" value="1">on
        <input type="radio" name="NGM_kt" value="2" checked="true">off
        -t/--threads <br>
        <h6>Number of candidate search threads</h6>
        <input type="text" name="NGM_t" class="input_setting_text" value="1"/>
        Scale estimated sensitivity:<br>
        <h6>--very fast;Much faster, much less accurate<br>
          --fast;Scale estimated sensitivity: Faster, less accurate<br>
          --sensitive;Scale estimated sensitivity: More accurate, slower<br>
          --very-sensitive;Scale estimated sensitivity: Much more accurate, much slower</h6>
        <input type="radio" name="NGM_sen" value="1">very fast
        <input type="radio" name="NGM_sen" value="2" checked="true">fast
        <input type="radio" name="NGM_sen" value="3">sensitive
        <input type="radio" name="NGM_sen" value="4">very-sensitive
        -i/--min-identity <0-1> <br>
        <h6>All reads mapped with an identity lower than
          this threshold will be reported as unmapped
          (default: 0.65)</h6>
        <input type="text" name="NGM_i" class="input_setting_text" value="0.65"/>
        -R/--min-residues <br>
        <h6>All reads mapped with lower than
          * read length residues
          will be reported as unmapped. (default: 0.5)</h6>
        <input type="text" name="NGM_R" class="input_setting_text" value="0.5"/>
        -Q/--min-mq <br>
        <h6>All reads mapped with lower than n mapping quality will be reported as unmapped.
          (default: 0)</h6>
        <input type="text" name="NGM_Q" class="input_setting_text" value="0"/>
        --bs-cutoff <br>
        <h6>Max. number of Ts in a k-mer. All k-mers were
          the number of Ts is higher than b are ignored (default: 8)</h6>
        <input type="text" name="NGM_bc" class="input_setting_text" value="8"/>
        -k/--kmer [10-14] <br>
        <h6>Kmer length in bases. (default: 13)</h6>
        <input type="text" name="NGM_k" class="input_setting_text" value="13"/>
        --kmer-skip <br>
        <h6>Number of k-mers to skip when building the
          lookup table from the reference(default: 2)</h6>
        <input type="text" name="NGM_ks" class="input_setting_text" value="2"/>
        --kmer-min <br>
        <h6>Minimal number of k-mer hits required to
          consider a region a CMR. (default: 0)</h6>
        <input type="text" name="NGM_km" class="input_setting_text" value="0"/>
        -l/--local <br>
        <h6>Perform local alignment. Ends might get clipped.
          (default: on)</h6>
        <input type="radio" value="1" name="NGM_l" checked="true">on
        <input type="radio" value="2" name="NGM_l" >off
        -e/--end-to-end   <br>
        <h6>Perform end-to-end alignment. No clipping.
          (default: off)</h6>
        <input type="radio" value="1" name="NGM_e" >on
        <input type="radio" value="2" name="NGM_e" checked="true">off
        --affine     <br>
        <h6>Use alignment algorithms that support affine gap
          costs. This will give you better alignments for
          longer indels but will also increase the runtime.
          (default: off)</h6>
        <input type="radio" value="1" name="NGM_a" >on
        <input type="radio" value="2" name="NGM_a" checked="true">off
        --skip-mate-check     <br>
        <h6>Don't check that both mates have the same name
          (default: off)</h6>
        <input type="radio" value="1" name="NGM_smc" >on
        <input type="radio" value="2" name="NGM_smc" checked="true">off<br>
        <input type="button" value="submit" class="btn_submit" onclick="document.getElementById('workflow_custom_NGM').style.display='none'"/>
        <input type="button" value="cancel" class="btn_cancel" onclick="document.getElementById('workflow_custom_NGM').style.display='none'"/>
      </div>
    </div>
  </div>

  <div class="blacktop_1">
    Peak calling
    <div class="tip_out"><img class="tip" id="tip5" src="./img/tip.png" onclick="JavaScript:Tip_click(5)"></div>
  </div>
  <div class="blackdown_2_workflowCustom" style="overflow-y:scroll;">
    <input type="radio" name="workflowCustom_peak" value="1"  checked="true" onclick="document.getElementById('workflowCustom_option_macs').style.display='block';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">MACS<h2>MACS captures the influence of genome complexity to evaluate the significance of enriched ChIP regions, and MACS improves the spatial resolution of binding sites through combining the information of both sequencing tag position and orientation.</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_macs" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_macs" value="1" onclick="document.getElementById('workflow_custom_macs').style.display='none';">default
      <input type="radio" name="workflowCustom_option_macs" value="2" checked="true" onclick="document.getElementById('workflow_custom_macs').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_macs" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center"  style="overflow-y:scroll;">
        Tag size<br>
        <h6>This will overide the auto detected tag size.default:25</h6>
        <input type="text" name="macs_s" value="25" class="input_setting_text"/><br>
        Band width<br>
        <h6>This value is only used while building the shifting model. DEFAULT: 300</h6>
        <input type="text" name="macs_bw" value="400" class="input_setting_text"/><br>
        Pvalue cutoff for peak detection<br>
        <h6>Pvalue cutoff for peak detection. DEFAULT: 1e-5</h6>
        <input type="text" name="macs_p" value="1e-5" class="input_setting_text"/><br>
        Effective genome size:this is the size of the genome considered "usable" for peak calling.
        <h6>default:2700000000.0</h6>
        <input type="text" name="macs_gs" value="4639675" class="input_setting_text"/><br>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_macs').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_macs').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="2" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='block';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">MACS2<h3>It is the upgraded version of MACS.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_macs2" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_macs2" value="1" onclick="document.getElementById('workflow_custom_macs2').style.display='none';">default
      <input type="radio" name="workflowCustom_option_macs2" value="2" onclick="document.getElementById('workflow_custom_macs2').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_macs2" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center"  style="overflow-y:scroll;">
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
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_macs2').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_macs2').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="3" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='block';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">PeakSeq<h3>It is a program for identifying and ranking peak regions in ChIP-Seq experiments.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_peakseq" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_peakseq" value="1" onclick="document.getElementById('workflow_custom_peakseq').style.display='none'">default
      <input type="radio" name="workflowCustom_option_peakseq" value="2" onclick="document.getElementById('workflow_custom_peakseq').style.display='block'">setting by yourself
    </div>
    <div id="workflow_custom_peakseq" class="inputOption_setting" style="display:none">
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
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_peakseq').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_peakseq').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="4" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='block';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">PeakRanger<h4>uses a staged algorithm to discover enriched regions and the summits within them.</h4>
    <div class="workflowCustom_option" id="workflowCustom_option_peakranger" style="display:none">
      Select the tool to call peaks<br>
      <input type="radio" name="workflowCustom_option_peakranger" value="1" onclick="document.getElementById('peakranger_ranger').style.display='block';document.getElementById('peakranger_ccat').style.display='none';document.getElementById('peakranger_bcp').style.display='none';">ranger
      <input type="radio" name="workflowCustom_option_peakranger" value="2" onclick="document.getElementById('peakranger_ranger').style.display='none';document.getElementById('peakranger_ccat').style.display='block';document.getElementById('peakranger_bcp').style.display='none';">ccat
      <input type="radio" name="workflowCustom_option_peakranger" value="3" onclick="document.getElementById('peakranger_ranger').style.display='none';document.getElementById('peakranger_ccat').style.display='none';document.getElementById('peakranger_bcp').style.display='block';">bcp
    </div>
    <div id="peakranger_ranger" class="inputOption_setting" style="display:none">
      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
        Whether generate html reports?<br>
        <h6>`--report`</h6>
        <input type="radio" name="peakranger_mode" value="1"/>Yes
        <input type="radio" name="peakranger_mode" value="2"/>No<br>
        the length of the snapshort regions in the HTML report.<br>
        <h6>`--plot_region`;It also controls the search span for nearby genes.</h6>
        <input type="text" name="peakranger_length" value="" class="input_setting_text"/>
        the gene annotation file<br>
        <h6>`--gene_annot_file`</h6>
        <input type="text" name="peakranger_annofile" value="" class="input_setting_text"/>
        p value cut off<br>
        <h6>`-p,--pval` </h6>
        <input type="text" name="peakranger_pvalue" value="" class="input_setting_text"/>
        FDR cut off<br>
        <h6>`-q,--FDR`   </h6>
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
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakranger_ranger').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakranger_ranger').style.display='none';"/>
      </div>
    </div>
    <div id="peakranger_ccat" class="inputOption_setting" style="display:none">
      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
        Whether generate html reports?<br>
        <h6>`--report`</h6>
        <input type="radio" name="peakranger_mode" value="1"/>Yes
        <input type="radio" name="peakranger_mode" value="2"/>No<br>
        the length of the snapshort regions in the HTML report.<br>
        <h6>`--plot_region`;It also controls the search span for nearby genes.</h6>
        <input type="text" name="peakranger_length" value="" class="input_setting_text"/>
        the gene annotation file<br>
        <h6>`--gene_annot_file`</h6>
        <input type="text" name="peakranger_annofile" value="" class="input_setting_text"/>
        FDR cut off<br>
        <h6>`-q,--FDR`</h6>
        <input type="text" name="peakranger_fdr" value="" class="input_setting_text"/>
        sliding window size<br>
        <h6>`--win_size`</h6>
        <input type="text" name="peakranger_winsize" value="" class="input_setting_text"/>
        window moving step<br>
        <h6>`--win_step`</h6>
        <input type="text" name="peakranger_winstep" value="" class="input_setting_text"/>
        minimum window reads count<br>
        <h6>`--min_count`</h6>
        <input type="text" name="peakranger_imcount" value="" class="input_setting_text"/>
        minimum window reads fold change<br>
        <h6>`--min_score`</h6>
        <input type="text" name="peakranger_minscore" value="" class="input_setting_text"/>
        read extension length<br>
        <h6>`-l,--ext_length` </h6>
        <input type="text" name="peakranger_relength" value="" class="input_setting_text"/>
        p value cut off<br>
        <h6>`-p,--pval` </h6>
        <input type="text" name="peakranger_pvalue" value="" class="input_setting_text"/>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakranger_ccat').style.display='none';JavaScript:peakranger_radio(peakseq_length.value,peakseq_fdr.value,peakseq_N.value,peakseq_Min.value,peakseq_mode.value,peakseq_qvalue.value);"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakranger_ccat').style.display='none';"/>
      </div>
    </div>
    <div id="peakranger_bcp" class="inputOption_setting" style="display:none">
      <div  class="inputOption_setting_center" style="overflow-y:scroll;" >
        Whether generate html reports?<br>
        <h6>`--report`</h6>
        <input type="radio" name="peakranger_mode" value="1"/>Yes
        <input type="radio" name="peakranger_mode" value="2"/>No<br>
        the length of the snapshort regions in the HTML report.<br>
        <h6>`--plot_region`;It also controls the search span for nearby genes.</h6>
        <input type="text" name="peakranger_length" value="" class="input_setting_text"/>
        the gene annotation file<br>
        <h6>`--gene_annot_file`</h6>
        <input type="text" name="peakranger_annofile" value="" class="input_setting_text"/>
        sliding window size<br>
        <h6>`--win_size`</h6>
        <input type="text" name="peakranger_winsize" value="" class="input_setting_text"/>
        read extension length<br>
        <h6>`-l,--ext_length` </h6>
        <input type="text" name="peakranger_relength" value="" class="input_setting_text"/><br>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('peakranger_bcp').style.display='none';JavaScript:peakranger_radio(peakseq_length.value,peakseq_fdr.value,peakseq_N.value,peakseq_Min.value,peakseq_mode.value,peakseq_qvalue.value);"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('peakranger_bcp').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="5" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='block';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">SICER<h2>Delineation of the significantly ChIP-enriched regions, which can be used to associate with other genomic landmarks.Identification of reads on the ChIP-enriched regions, which can be used for profiling and other quantitative analysis.</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_sicer" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_sicer" value="1" onclick="document.getElementById('workflow_custom_sicer').style.display='none';">default
      <input type="radio" name="workflowCustom_option_sicer" value="2" onclick="document.getElementById('workflow_custom_sicer').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_sicer" class="inputOption_setting" style="display:none">
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
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_sicer').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_sicer').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="6" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='block';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">PePr<h2>It uses a negative binomial distribution to model the read counts among the samples in the same group,and look for consistent differences between ChIP and control group or two ChIP groups run under different conditions.</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_pepr" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_pepr" value="1" onclick="document.getElementById('workflow_custom_pepr').style.display='none';">default
      <input type="radio" name="workflowCustom_option_pepr" value="2" onclick="document.getElementById('workflow_custom_pepr').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_pepr" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center" style="overflow-y:scroll;">
        --peaktype.sharp or broad. <br>
        <h6>Default is broad.</h6>
        <input type="text" value="broad" class="input_setting_text" name="pepr_peaktype">
        --threshold<br>
        <h6>p-value cutoff. Default:1e-5.</h6>
        <input type="text" value="1e-5" class="input_setting_text" name="pepr_p">
        --keep-max-dup<br>
        <h6>maximum number of duplicated reads at each single position to keep. If not specified, will not remove any duplicate.</h6>
        <input type="text" value="2" class="input_setting_text" name="pepr_keep">
        --num-processors<br>
        <h6>Number of CPUs to run in parallel.</h6>
        <input type="text" value="1" class="input_setting_text" name="pepr_num">
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_pepr').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_pepr').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="7" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='block';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">BCP<h2>It is a flexible tool for ChIP-Seq peaks analysis.</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_BCP" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_BCP" value="1" onclick="document.getElementById('workflow_custom_BCP').style.display='none';">default
      <input type="radio" name="workflowCustom_option_BCP" value="2" onclick="document.getElementById('workflow_custom_BCP').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_BCP" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center" style="overflow-y:scroll;">
        fragment size<br>
        <h6>-f;Here fragment size is decided by the ChIP experiment sonication size (default value is 200bp)</h6>
        <input type="text" value="200" class="input_setting_text" name="BCP_f">
        window size<br>
        <h6>Window size is a resolution parameter that is decided by user.We recommend 200bp as the default value because it isapproximately the size of a single nucleosome. </h6>
        <input type="text" value="200" class="input_setting_text" name="BCP_W">
        p-value<br>
        <h6>P-values are used when calling signicant segments compared to control data (default is 1e-3). </h6>
        <input type="text" value="1e-3" class="input_setting_text" name="BCP_p">
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_BCP').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_BCP').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="8" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='block';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">diffReps<h3>It scans the whole genome using a sliding window,performing millions of statistical tests and report the significant hits. </h3>
    <div class="workflowCustom_option" id="workflowCustom_option_diff" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_diff" value="1" onclick="document.getElementById('workflow_custom_diff').style.display='none';">default
      <input type="radio" name="workflowCustom_option_diff" value="2" onclick="document.getElementById('workflow_custom_diff').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_diff" class="inputOption_setting" style="display:none">
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
        <input type="radio" value="3" name="diff_mode">block
        --window(1000)<br>
        <h6>Window size (default=Histone mark peak size).</h6>
        <input type="text" value="1000" class="input_setting_text" name="diff_w">
        --step(1/10 win) <br>
        <h6>Window moving step size.</h6>
        <input type="text" value="1" class="input_setting_text" name="diff_step">
        --gap(0)<br>
        <h6>Gap allowed between two consecutive windows.</h6>
        <input type="text" value="0" class="input_setting_text" name="diff_gap">
        --nsd(broad)<br>
        <h6>Z-score cutoff for low read count. Choose from two default modes or set your own.<br>
          (b)road     (=2)   Broad peak such as H3K36me3.<br>
          (s)harp     (=20)  Sharp peak such as H3K4me3 or Transcription factors.</h6>
        <input type="radio" value="1" name="diff_nsd" checked="true">broad
        <input type="radio" value="2" name="diff_nsd">sharp
        --alpha(0.05)  <br>
        <h6>Alpha for right-trimmed mean, must be in: [0, 0.5).</h6>
        <input type="text" value="0.05" class="input_setting_text" name="diff_alpha">
        --bkg(0)<br>
        <h6>Use fold enrichment vs. background as filter instead. Set a float number such as 2.0 here.</h6>
        <input type="text" value="0" class="input_setting_text" name="diff_bkg">
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_diff').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_diff').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="9" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='block';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">SISSRs<h3>A novel algorithm for precise identification of binding sites from short reads generated from ChIP-Seq experiments.</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_SISSRs" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_SISSRs" value="1" onclick="document.getElementById('workflow_custom_SISSRs').style.display='none';">default
      <input type="radio" name="workflowCustom_option_SISSRs" value="2" onclick="document.getElementById('workflow_custom_SISSRs').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_SISSRs" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center" style="overflow-y:scroll;">
        False discovery rate if random background model based on Poisson probabilities need to be
        used as control<br>
        <h6>
          i.e., no background data is available.Default: 0.001
        </h6>
        <input type="text" value="0.001" class="input_setting_text" name="SISSR_D">
        e-value threshold.<br>
        <h6>It is the maximum number of “enriched regions” one can expect to see by
          chance (Poisson probabilities), when analyzing a similar-sized dataset.Default: 10</h6>
        <input type="text" value="10" class="input_setting_text" name="SISSR_e">
        p-value threshold.<br>
        <h6>For a given F value (average DNA fragment length) and a candidate binding
          site (represented as genomic coordinate t in Fig 1 of Jothi et al [1]), let u be the number of tags
          mapped to the region [t - F, t] on the sense strand, and let v be the number of tags mapped to the
          region [t, t + F] on the anti-sense strand.Default: 0.001</h6>
        <input type="text" value="0.001" class="input_setting_text" name="SISSR_p">
        Fraction of genome (0.0 to 1.0) mappable by reads.<br>
        <h6>Default: 0.8 for hg18, assuming ELAND was used for mapping. This could be different for
          different organisms and other mapping algorithms.</h6>
        <input type="text" value="0.8" class="input_setting_text" name="SISSR_m">
        Size of the overlapping/sliding scanning window (must be an even number >1), which is one of
        the parameters that attempts to control for noise in the data<br>
        <h6>The amount of background noise in the data is a important factor one needs to
          consider before setting the size of the window.
          Default: 20</h6>
        <input type="text" value="20" class="input_setting_text" name="SISSR_w">
        Number of “directional” reads required within F base pairs on either side of the inferred
        binding site.<br>
        <h6>Default: 2 (assuming that the data file contains ~2 to ~5 million reads; the value may need to
          be increased if the total number of reads is much larger).</h6>
        <input type="text" value="2" class="input_setting_text" name="SISSR_E">
        Upper-bound on the DNA fragment length. It is the approximate length/size of the longest
        DNA fragment that was sequenced.<br>
        <h6>Default: 500</h6>
        <input type="text" value="500" class="input_setting_text" name="SISSR_L">
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_SISSRs').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_SISSRs').style.display='none';"/>
      </div>
    </div>
    <input type="radio" name="workflowCustom_peak" value="10" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='block';">findPeaks<h3>a Peak Finder/Analysis application for the ChIP-Seq or RNA-Seq experiments</h3>
    <div class="workflowCustom_option" id="workflowCustom_option_findPeaks" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_findPeaks" value="1" onclick="document.getElementById('workflow_custom_findPeaks').style.display='none';">default
      <input type="radio" name="workflowCustom_option_findPeaks" value="2" onclick="document.getElementById('workflow_custom_findPeaks').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_findPeaks" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center" style="overflow-y:scroll;">
        -g GSIZE, --gsize=GSIZE<br>
        <h6>Effective genome size. It can be 1.0e+9 or 1000000000,
          or shortcuts:'hs' for human (2.7e9), 'mm' for mouse
          (1.87e9), 'ce' for C. elegans (9e7) and 'dm' for
          fruitfly (1.2e8), Default:hs</h6>
        <input type="text" value="hs" class="input_setting_text" name="findPeaks_g">
        -s TSIZE, --tsize=TSIZE<br>
        <h6>Tag size. This will overide the auto detected tag
          size. DEFAULT: 25</h6>
        <input type="text" value="25" class="input_setting_text" name="findPeaks_s">
        --bw=BW<br>
        <h6>Band width. This value is only used while building the
          shifting model. DEFAULT: 300</h6>
        <input type="text" value="300" class="input_setting_text" name="findPeaks_bw">
        -p PVALUE, --pvalue=PVALUE<br>
        <h6>Pvalue cutoff for peak detection. DEFAULT: 1e-5</h6>
        <input type="text" value="1e-5" class="input_setting_text" name="findPeaks_p">
        -m MFOLD, --mfold=MFOLD<br>
        <h6>Select the regions within MFOLD range of high-
          confidence enrichment ratio against background to
          build model. The regions must be lower than upper
          limit, and higher than the lower limit. DEFAULT:10,30</h6>
        <input type="text" value="10,30" class="input_setting_text" name="findPeaks_m">
        --slocal=SMALLLOCAL <br>
        <h6>The small nearby region in basepairs to calculate
          dynamic lambda. This is used to capture the bias near
          the peak summit region. Invalid if there is no control
          data. DEFAULT: 1000</h6>
        <input type="text" value="1000" class="input_setting_text" name="findPeaks_slocal">
        --shiftsize=SHIFTSIZE<br>
        <h6>The arbitrary shift size in bp. When nomodel is true,
          MACS will use this value as 1/2 of fragment size.
          DEFAULT: 100</h6>
        <input type="text" value="100" class="input_setting_text" name="findPeaks_shift">
        --verbose=VERBOSE   <br>
        <h6>Set verbose level. 0: only show critical message, 1:
          show additional warning message, 2: show process
          information, 3: show debug messages. DEFAULT:2</h6>
        <input type="text" value="2" class="input_setting_text" name="findPeaks_verbose">
        --fe-min=FEMIN     <br>
        <h6>For diagnostics, min fold enrichment to consider.
          DEFAULT: 0</h6>
        <input type="text" value="0" class="input_setting_text" name="findPeaks_femin">
        --EM-converge-diff=MIN_CHANGE<br>
        <h6>The minimum entropy change between iterations before
          halting E-M steps. DEFAULT : 1e-05</h6>
        <input type="text" value="1e-05" class="input_setting_text" name="findPeaks_EM_cd">
        --EM-min-score=MIN_SCORE<br>
        <h6>Minimum enrichment score. Windows below this threshold
          will all look the same to the aligner. DEFAULT : 1.5</h6>
        <input type="text" value="1.5" class="input_setting_text" name="findPeaks_EM_min">
        --prior-snp=PRIOR_PROB_SNP<br>
        <h6>Prior probability that a SNP occurs at any base in the
          genome. DEFAULT : 0.001</h6>
        <input type="text" value="0.001" class="input_setting_text" name="findPeaks_ps">
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_findPeaks').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_findPeaks').style.display='none';"/>
      </div>
    </div>

    <input type="radio" name="workflowCustom_peak" value="11" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='block';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">AREM<h2>A peak caller for ChIP-Seq experiments that robustly handles short reads with *multiple* possible mappings.</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_AREM" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_AREM" value="1" onclick="document.getElementById('workflow_custom_AREM').style.display='none';">default
      <input type="radio" name="workflowCustom_option_AREM" value="2" onclick="document.getElementById('workflow_custom_AREM').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_AREM" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center" style="overflow-y:scroll;">
        -g GSIZE, --gsize=GSIZE<br>
        <h6>Effective genome size. It can be 1.0e+9 or 1000000000,
          or shortcuts:'hs' for human (2.7e9), 'mm' for mouse
          (1.87e9), 'ce' for C. elegans (9e7) and 'dm' for
          fruitfly (1.2e8), Default:hs</h6>
        <input type="text" value="hs" class="input_setting_text" name="AREM_g">
        -s TSIZE, --tsize=TSIZE<br>
        <h6>Tag size. This will overide the auto detected tag
          size. DEFAULT: 25</h6>
        <input type="text" value="25" class="input_setting_text" name="AREM_s">
        --bw=BW<br>
        <h6>Band width. This value is only used while building the
          shifting model. DEFAULT: 300</h6>
        <input type="text" value="300" class="input_setting_text" name="AREM_bw">
        -p PVALUE, --pvalue=PVALUE<br>
        <h6>Pvalue cutoff for peak detection. DEFAULT: 1e-5</h6>
        <input type="text" value="1e-5" class="input_setting_text" name="AREM_p">
        -m MFOLD, --mfold=MFOLD<br>
        <h6>Select the regions within MFOLD range of high-
          confidence enrichment ratio against background to
          build model. The regions must be lower than upper
          limit, and higher than the lower limit. DEFAULT:10,30</h6>
        <input type="text" value="10,30" class="input_setting_text" name="AREM_m">
        --slocal=SMALLLOCAL <br>
        <h6>The small nearby region in basepairs to calculate
          dynamic lambda. This is used to capture the bias near
          the peak summit region. Invalid if there is no control
          data. DEFAULT: 1000</h6>
        <input type="text" value="1000" class="input_setting_text" name="AREM_slocal">
        --shiftsize=SHIFTSIZE<br>
        <h6>The arbitrary shift size in bp. When nomodel is true,
          MACS will use this value as 1/2 of fragment size.
          DEFAULT: 100</h6>
        <input type="text" value="100" class="input_setting_text" name="AREM_shift">
        --verbose=VERBOSE   <br>
        <h6>Set verbose level. 0: only show critical message, 1:
          show additional warning message, 2: show process
          information, 3: show debug messages. DEFAULT:2</h6>
        <input type="text" value="2" class="input_setting_text" name="AREM_verbose">
        --fe-min=FEMIN     <br>
        <h6>For diagnostics, min fold enrichment to consider.
          DEFAULT: 0</h6>
        <input type="text" value="0" class="input_setting_text" name="AREM_femin">
        --EM-converge-diff=MIN_CHANGE<br>
        <h6>The minimum entropy change between iterations before
          halting E-M steps. DEFAULT : 1e-05</h6>
        <input type="text" value="1e-05" class="input_setting_text" name="AREM_EM_cd">
        --EM-min-score=MIN_SCORE<br>
        <h6>Minimum enrichment score. Windows below this threshold
          will all look the same to the aligner. DEFAULT : 1.5</h6>
        <input type="text" value="1.5" class="input_setting_text" name="AREM_EM_min">
        --prior-snp=PRIOR_PROB_SNP<br>
        <h6>Prior probability that a SNP occurs at any base in the
          genome. DEFAULT : 0.001</h6>
        <input type="text" value="0.001" class="input_setting_text" name="AREM_ps">
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_AREM').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_AREM').style.display='none';"/>
      </div>
    </div>

    <input type="radio" name="workflowCustom_peak" value="12" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='none';document.getElementById('workflowCustom_option_Fseq').style.display='block';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">Fseq<h2>a software package that generates a continuous tag sequence density estimation</h2>
    <div class="workflowCustom_option" id="workflowCustom_option_Fseq" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_Fseq" value="1" onclick="document.getElementById('workflow_custom_Fseq').style.display='none';">default
      <input type="radio" name="workflowCustom_option_Fseq" value="2" onclick="document.getElementById('workflow_custom_Fseq').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_Fseq" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center">
        -b: The size of bin<br>
        <h6>default value 200 (bp). It should be consistent with the bedGraph format input file</h6>
        <input type="text" value="200" class="input_setting_text" name="Fseq_b"/>
        -g: The size of the genome under consideration<br>
        <h6>default value 3107677273 (bp) for the human genome
          (hg18).</h6>
        <input type="text" value="3107677273" class="input_setting_text" name="Fseq_g"/>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_Fseq').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_Fseq').style.display='none';"/>
      </div>
    </div>

    <input type="radio" name="workflowCustom_peak" value="13" onclick="document.getElementById('workflowCustom_option_macs').style.display='none';document.getElementById('workflowCustom_option_macs2').style.display='none';document.getElementById('workflowCustom_option_peakseq').style.display='none';document.getElementById('workflowCustom_option_peakranger').style.display='none';document.getElementById('workflowCustom_option_sicer').style.display='none';document.getElementById('workflowCustom_option_pepr').style.display='none';document.getElementById('workflowCustom_option_BCP').style.display='none';document.getElementById('workflowCustom_option_diff').style.display='none';document.getElementById('workflowCustom_option_SISSRs').style.display='none';document.getElementById('workflowCustom_option_AREM').style.display='none';document.getElementById('workflowCustom_option_BroadPeak').style.display='block';document.getElementById('workflowCustom_option_Fseq').style.display='none';document.getElementById('workflowCustom_option_findPeaks').style.display='none';">BroadPeak<h4>It is broad peak calling algorithm for diffuse ChIP-Seq datasets.</h4>
    <div class="workflowCustom_option" id="workflowCustom_option_BroadPeak" style="display:none">
      whether to set optional parameters?<br>
      <input type="radio" name="workflowCustom_option_BroadPeak" value="1" onclick="document.getElementById('workflow_custom_BroadPeak').style.display='none';">default
      <input type="radio" name="workflowCustom_option_BroadPeak" value="2" onclick="document.getElementById('workflow_custom_BroadPeak').style.display='block';">setting by yourself
    </div>
    <div id="workflow_custom_BroadPeak" class="inputOption_setting" style="display:none">
      <div class="inputOption_setting_center">
        -b: The size of bin<br>
        <h6>default value 200 (bp). It should be consistent with the bedGraph format input file</h6>
        <input type="text" value="200" class="input_setting_text" name="BroadPeak_b"/>
        -g: The size of the genome under consideration<br>
        <h6>default value 3107677273 (bp) for the human genome
          (hg18).</h6>
        <input type="text" value="3107677273" class="input_setting_text" name="BroadPeak_g"/>
        <input type="button" class="btn_submit" value="submit" onclick="document.getElementById('workflow_custom_BroadPeak').style.display='none';"/>
        <input type="button" class="btn_cancel" value="cancel" onclick="document.getElementById('workflow_custom_BroadPeak').style.display='none';"/>
      </div>
    </div>
  </div>
</body>
</html>
