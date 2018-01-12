/**
 * Created by USER on 2017/4/26.
 */


function nece_opt_show_HOMER_ne(){
    if(document.getElementById("necessary_center_HOMER").style.display=='block'){
        document.getElementById("necessary_center_HOMER").style.display="none";
        document.getElementById("arrow-down1").style.display="none";
        document.getElementById("arrow-right1").style.display="block";
    }
    else{
        document.getElementById("necessary_center_HOMER").style.display="block";
        document.getElementById("arrow-down1").style.display="block";
        document.getElementById("arrow-right1").style.display="none";
    }
}
function nece_opt_show_HOMER_op(){
    if(document.getElementById("optional_center_HOMER").style.display=='block'){
        document.getElementById("optional_center_HOMER").style.display="none";
        document.getElementById("arrow-down2").style.display="none";
        document.getElementById("arrow-right2").style.display="block";
    }
    else{
        document.getElementById("optional_center_HOMER").style.display="block";
        document.getElementById("arrow-down2").style.display="block";
        document.getElementById("arrow-right2").style.display="none";
    }
}
function nece_opt_show_GOMo_ne(){
    if(document.getElementById("necessary_center_GOMo").style.display=='block'){
        document.getElementById("necessary_center_GOMo").style.display="none";
        document.getElementById("arrow-down3").style.display="none";
        document.getElementById("arrow-right3").style.display="block";
    }
    else{
        document.getElementById("necessary_center_GOMo").style.display="block";
        document.getElementById("arrow-down3").style.display="block";
        document.getElementById("arrow-right3").style.display="none";
    }
}
function nece_opt_show_GOMo_op(){
    if(document.getElementById("optional_center_GOMo").style.display=='block'){
        document.getElementById("optional_center_GOMo").style.display="none";
        document.getElementById("arrow-down4").style.display="none";
        document.getElementById("arrow-right4").style.display="block";
    }
    else{
        document.getElementById("optional_center_GOMo").style.display="block";
        document.getElementById("arrow-down4").style.display="block";
        document.getElementById("arrow-right4").style.display="none";
    }
}
function GLAM2_radio(GLAM2_r,GLAM2_n,GLAM2_z,GLAM2_w,GLAM2_a,GLAM2_b,GLAM2_D,GLAM2_E,GLAM2_I,GLAM2_J,GLAM2_q,GLAM2_t,GLAM2_c,GLAM2_u,GLAM2_m,GLAM2_x,GLAM2_s){
    var div = document.getElementById("GLAM2_radio");
    div.innerHTML="(-r "+GLAM2_r+" -n "+GLAM2_n+" -z "+GLAM2_z+" -w "+GLAM2_w+" -a "+GLAM2_a+" -b "+GLAM2_b+" -D "+GLAM2_D+" -E "+GLAM2_E+" -I "+GLAM2_I+" -J "+GLAM2_J+" -q "+GLAM2_q+" -t "+GLAM2_t+" -c "+GLAM2_c+" -u "+GLAM2_u+" -m "+GLAM2_m+" -x "+GLAM2_x+" -s "+GLAM2_s+")";
    div.style.visibility="visible";
}
function GOMo_radio(gomo_text,gomo_dagr,GOMo_t,gomo_motifmeme,gomo_motifall,GOMo_shuffle,gomo_verbo){
    var div = document.getElementById("GOMo_radio");
    var text,dagr,meme,all;
    if(gomo_text==1){
        text="--text";
    }
    else{
        text="";
    }
    if(gomo_dagr==1){
        dagr="--dag";
    }
    else{
        dagr="";
    }
    if(gomo_motifmeme==1){
        meme="--motifs"
    }
    else{
        meme="";
    }
    if(gomo_motifall==1){
        all="--motif";
    }
    else{
        all="";
    }
    div.innerHTML="( "+text+" "+dagr+" -t "+meme+" "+GOMo_t+" "+all+" --shuffle_scores "+GOMo_shuffle+" --verbosity "+gomo_verbo+")";
    div.style.visibility="visible";
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
function fileChange(target,box){
<<<<<<< HEAD
    var filename;
    filename=target.files[0].value().substr(target.files[0].value().lastIndexOf('/')+1);
    alert(filename);
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
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
<<<<<<< HEAD
    else{
        document.getElementById(box).value=filename;
        return true;
    }
}
=======
}
function Demo_right(id){
    for(var i=1;i<=6;i++){
        document.getElementById("side_right_"+i).style.display='none';
    }
    document.getElementById("side_right_"+id).style.display='block';
}
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
