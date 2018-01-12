package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.BowtieBean;
import ChIP_Seq.service.BowtieService;
import ChIP_Seq.xmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/6 0006.
 */
public class BowtieAction extends ActionSupport {
    private int type;
    private int refer_index_bowtie;
    private String input_re_bowtie;
    private String input_path_bowtie;
    private int bowtie_option_radio;
    private int bowtie_noauto;
    private int bowtie_nodc;
    private int bowtie_justref;
    private String bowtie_offrate;
    private String bowtie_t;
    private int bowtie_ns;
    private String input_reads_bowtie;
    private String input_reads_pair1_bowtie;
    private String input_reads_pair2_bowtie;
    private int inputOption_bowtie_mode;
    private String bowtie_mode_n;
    private String bowtie_mode_l;
    private String bowtie_mode_e;
    private String bowtie_maximun;
    private String bowtie_mode_v;
    private int bowtie_best;
    private String bowtie_s,bowtie_u,bowtie_5,bowtie_3;
    private String bowtie_I,bowtie_X,bowtie_pairties;
    private int  bowtie_nomaqround,pair_fr_ff_radio,pair_no;
    private String bowtie_k;
    private int bowtie_a;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;
    private int built_in_bowtie;

    private List<File> fileField_bowtie;
    private List<String> fileField_bowtieFileName;

    private File fileField_bowtie_re;
    private File fileField_bowtie_read;
    private File fileField_bowtie_read1;
    private File fileField_bowtie_read2;
    private String fileField_bowtie_reFileName;
    private String fileField_bowtie_readFileName;
    private String fileField_bowtie_read1FileName;
    private String fileField_bowtie_read2FileName;

    public int getBuilt_in_bowtie() {
        return built_in_bowtie;
    }

    public void setBuilt_in_bowtie(int built_in_bowtie) {
        this.built_in_bowtie = built_in_bowtie;
    }

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }

    public List<File> getFileField_bowtie() {
        return fileField_bowtie;
    }

    public void setFileField_bowtie(List<File> fileField_bowtie) {
        this.fileField_bowtie = fileField_bowtie;
    }

    public List<String> getFileField_bowtieFileName() {
        return fileField_bowtieFileName;
    }

    public void setFileField_bowtieFileName(List<String> fileField_bowtieFileName) {
        this.fileField_bowtieFileName = fileField_bowtieFileName;
    }

    public File getFileField_bowtie_re() {
        return fileField_bowtie_re;
    }

    public void setFileField_bowtie_re(File fileField_bowtie_re) {
        this.fileField_bowtie_re = fileField_bowtie_re;
    }

    public File getFileField_bowtie_read() {
        return fileField_bowtie_read;
    }

    public void setFileField_bowtie_read(File fileField_bowtie_read) {
        this.fileField_bowtie_read = fileField_bowtie_read;
    }

    public File getFileField_bowtie_read1() {
        return fileField_bowtie_read1;
    }

    public void setFileField_bowtie_read1(File fileField_bowtie_read1) {
        this.fileField_bowtie_read1 = fileField_bowtie_read1;
    }

    public File getFileField_bowtie_read2() {
        return fileField_bowtie_read2;
    }

    public void setFileField_bowtie_read2(File fileField_bowtie_read2) {
        this.fileField_bowtie_read2 = fileField_bowtie_read2;
    }

    public String getFileField_bowtie_reFileName() {
        return fileField_bowtie_reFileName;
    }

    public void setFileField_bowtie_reFileName(String fileField_bowtie_reFileName) {
        this.fileField_bowtie_reFileName = fileField_bowtie_reFileName;
    }

    public String getFileField_bowtie_readFileName() {
        return fileField_bowtie_readFileName;
    }

    public void setFileField_bowtie_readFileName(String fileField_bowtie_readFileName) {
        this.fileField_bowtie_readFileName = fileField_bowtie_readFileName;
    }

    public String getFileField_bowtie_read1FileName() {
        return fileField_bowtie_read1FileName;
    }

    public void setFileField_bowtie_read1FileName(String fileField_bowtie_read1FileName) {
        this.fileField_bowtie_read1FileName = fileField_bowtie_read1FileName;
    }

    public String getFileField_bowtie_read2FileName() {
        return fileField_bowtie_read2FileName;
    }

    public void setFileField_bowtie_read2FileName(String fileField_bowtie_read2FileName) {
        this.fileField_bowtie_read2FileName = fileField_bowtie_read2FileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRefer_index_bowtie() {
        return refer_index_bowtie;
    }

    public void setRefer_index_bowtie(int refer_index_bowtie) {
        this.refer_index_bowtie = refer_index_bowtie;
    }

    public String getInput_re_bowtie() {
        return input_re_bowtie;
    }

    public void setInput_re_bowtie(String input_re_bowtie) {
        this.input_re_bowtie = input_re_bowtie;
    }

    public int getBowtie_option_radio() {
        return bowtie_option_radio;
    }

    public void setBowtie_option_radio(int bowtie_option_radio) {
        this.bowtie_option_radio = bowtie_option_radio;
    }

    public int getBowtie_noauto() {
        return bowtie_noauto;
    }

    public void setBowtie_noauto(int bowtie_noauto) {
        this.bowtie_noauto = bowtie_noauto;
    }

    public int getBowtie_nodc() {
        return bowtie_nodc;
    }

    public void setBowtie_nodc(int bowtie_nodc) {
        this.bowtie_nodc = bowtie_nodc;
    }

    public int getBowtie_justref() {
        return bowtie_justref;
    }

    public void setBowtie_justref(int bowtie_justref) {
        this.bowtie_justref = bowtie_justref;
    }

    public String getBowtie_offrate() {
        return bowtie_offrate;
    }

    public void setBowtie_offrate(String bowtie_offrate) {
        this.bowtie_offrate = bowtie_offrate;
    }

    public String getBowtie_t() {
        return bowtie_t;
    }

    public void setBowtie_t(String bowtie_t) {
        this.bowtie_t = bowtie_t;
    }

    public int getBowtie_ns() {
        return bowtie_ns;
    }

    public void setBowtie_ns(int bowtie_ns) {
        this.bowtie_ns = bowtie_ns;
    }

    public String getInput_reads_pair2_bowtie() {
        return input_reads_pair2_bowtie;
    }

    public void setInput_reads_pair2_bowtie(String input_reads_pair2_bowtie) {
        this.input_reads_pair2_bowtie = input_reads_pair2_bowtie;
    }

    public String getInput_reads_bowtie() {
        return input_reads_bowtie;
    }

    public void setInput_reads_bowtie(String input_reads_bowtie) {
        this.input_reads_bowtie = input_reads_bowtie;
    }

    public String getInput_reads_pair1_bowtie() {
        return input_reads_pair1_bowtie;
    }

    public void setInput_reads_pair1_bowtie(String input_reads_pair1_bowtie) {
        this.input_reads_pair1_bowtie = input_reads_pair1_bowtie;
    }

    public int getInputOption_bowtie_mode() {
        return inputOption_bowtie_mode;
    }

    public void setInputOption_bowtie_mode(int inputOption_bowtie_mode) {
        this.inputOption_bowtie_mode = inputOption_bowtie_mode;
    }

    public String getBowtie_mode_n() {
        return bowtie_mode_n;
    }

    public void setBowtie_mode_n(String bowtie_mode_n) {
        this.bowtie_mode_n = bowtie_mode_n;
    }

    public String getBowtie_mode_l() {
        return bowtie_mode_l;
    }

    public void setBowtie_mode_l(String bowtie_mode_l) {
        this.bowtie_mode_l = bowtie_mode_l;
    }

    public String getBowtie_mode_e() {
        return bowtie_mode_e;
    }

    public void setBowtie_mode_e(String bowtie_mode_e) {
        this.bowtie_mode_e = bowtie_mode_e;
    }

    public String getBowtie_maximun() {
        return bowtie_maximun;
    }

    public void setBowtie_maximun(String bowtie_maximun) {
        this.bowtie_maximun = bowtie_maximun;
    }

    public String getBowtie_mode_v() {
        return bowtie_mode_v;
    }

    public void setBowtie_mode_v(String bowtie_mode_v) {
        this.bowtie_mode_v = bowtie_mode_v;
    }

    public int getBowtie_best() {
        return bowtie_best;
    }

    public void setBowtie_best(int bowtie_best) {
        this.bowtie_best = bowtie_best;
    }

    public String getBowtie_s() {
        return bowtie_s;
    }

    public void setBowtie_s(String bowtie_s) {
        this.bowtie_s = bowtie_s;
    }

    public String getBowtie_u() {
        return bowtie_u;
    }

    public void setBowtie_u(String bowtie_u) {
        this.bowtie_u = bowtie_u;
    }

    public String getBowtie_5() {
        return bowtie_5;
    }

    public void setBowtie_5(String bowtie_5) {
        this.bowtie_5 = bowtie_5;
    }

    public String getBowtie_3() {
        return bowtie_3;
    }

    public void setBowtie_3(String bowtie_3) {
        this.bowtie_3 = bowtie_3;
    }

    public int getBowtie_nomaqround() {
        return bowtie_nomaqround;
    }

    public void setBowtie_nomaqround(int bowtie_nomaqround) {
        this.bowtie_nomaqround = bowtie_nomaqround;
    }

    public String getBowtie_I() {
        return bowtie_I;
    }

    public void setBowtie_I(String bowtie_I) {
        this.bowtie_I = bowtie_I;
    }

    public String getBowtie_X() {
        return bowtie_X;
    }

    public void setBowtie_X(String bowtie_X) {
        this.bowtie_X = bowtie_X;
    }

    public String getBowtie_pairties() {
        return bowtie_pairties;
    }

    public void setBowtie_pairties(String bowtie_pairties) {
        this.bowtie_pairties = bowtie_pairties;
    }

    public int getPair_fr_ff_radio() {
        return pair_fr_ff_radio;
    }

    public void setPair_fr_ff_radio(int pair_fr_ff_radio) {
        this.pair_fr_ff_radio = pair_fr_ff_radio;
    }

    public int getPair_no() {
        return pair_no;
    }

    public void setPair_no(int pair_no) {
        this.pair_no = pair_no;
    }

    public int getBowtie_a() {
        return bowtie_a;
    }

    public void setBowtie_a(int bowtie_a) {
        this.bowtie_a = bowtie_a;
    }

    public String getBowtie_k() {
        return bowtie_k;
    }

    public void setBowtie_k(String bowtie_k) {
        this.bowtie_k = bowtie_k;
    }

    public String getInput_path_bowtie() {
        return input_path_bowtie;
    }

    public void setInput_path_bowtie(String input_path_bowtie) {
        this.input_path_bowtie = input_path_bowtie;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String Bowtie_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        //////////////////////////////////////////////////////////////////////
        String remote_re,remote_read,remote_read1,remote_read2;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_bowtieFileName,fileField_bowtie);
        if(refer_index_bowtie==1){
            if(type==1){
                remote_read=Upload_path.get(1);
                remote_read1="";
                remote_read2="";
            }
            else{
                remote_read="";
                remote_read1=Upload_path.get(1);
                remote_read2=Upload_path.get(2);
            }
            remote_re=Upload_path.get(0);
        }
        else{
            if(type==1){
                remote_read=Upload_path.get(0);
                remote_read1="";
                remote_read2="";
            }
            else{
                remote_read="";
                remote_read1=Upload_path.get(0);
                remote_read2=Upload_path.get(1);
            }
            remote_re="";
        }

        //////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path();
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_bowtie.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Bowtie", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////////
        String nodc,justref,ntoa;
        BowtieService bowtieService= (BowtieService) applicationContext.getBean("bowtieService");
        FileUtil fileUtil1=new FileUtil();
        input_path_bowtie=fileUtil1.Result_path();
        appendMethodB(admin_path,input_path_bowtie+"\r\n");
        BowtieBean bowtieBean=new BowtieBean();

        if(type==1){
            bowtieBean.setRead_1(remote_read);
        }
        else{
            bowtieBean.setRead_1(remote_read1);
            bowtieBean.setRead_2(remote_read2);
            if(bowtie_best==1){
                bowtieBean.setBest("");
            }
            else{
                bowtieBean.setBest(" --best --strata");
            }

        }
        bowtieBean.setRead_type(type);
///////////////// ///////////////////////////index option//////////////////////////////////////////////////////////
        if(bowtie_option_radio==1){
            bowtieBean.setIndex_option(" ");
        }
        else{
            if(bowtie_nodc==1){
                nodc="";
            }
            else{
                nodc="--nodc";
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
            bowtieBean.setIndex_option("--offrate "+bowtie_offrate+" -t "+bowtie_t+" "+nodc+" "+justref+" "+ntoa);
        }
/////////////////////////////////////////////////////////////////input option///////////////////////////////////////
        if(inputOption_bowtie_mode==1){
            bowtieBean.setVn_option("-n "+bowtie_mode_n+" "+"-l"+bowtie_mode_l+" -e "+bowtie_mode_e+" --maxbts "+bowtie_maximun);
        }
        else{
            bowtieBean.setVn_option("-v "+bowtie_mode_v);
        }
        bowtieBean.setInput_option("-s "+bowtie_s+" -u "+bowtie_u+" -5 "+bowtie_5+" -3 "+bowtie_3);
///////////////////////////////////////////////////Alignment option///////////////////////////////////////////////
        String  noma;
        if(bowtie_nomaqround==1){
            noma="";
        }
        else{
            noma="--nomaqround";
        }
        bowtieBean.setAli_option(noma+" -I "+bowtie_I+" -X "+bowtie_X);
///////////////////////////////////////////////////report option//////////////////////////////////////////////////
        String a;
        if(bowtie_a==1){
            a="";
        }
        else{
            a="-a";
        }
        bowtieBean.setReport_option("-k "+bowtie_k+" "+a);
//////////////////////////////////////////////////
        bowtieBean.setPath(input_path_bowtie);
        bowtieService.setBowtieBean(bowtieBean);
        if(refer_index_bowtie==1){
            bowtieBean.setReference(remote_re);
        }
        else{
            if(built_in_bowtie==1){
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "hg19");
                bowtieBean.setReference(commandline);
            }
            else{
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "mm8");
                bowtieBean.setReference(commandline);
            }
        }
        stdoutlist=bowtieService.Bowtie();
        flag="2";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");

        return SUCCESS;
    }
    public String Bowtie_noUpload(){
        String nodc,justref,ntoa;
        BowtieService bowtieService= (BowtieService) applicationContext.getBean("bowtieService");
        BowtieBean bowtieBean=new BowtieBean();

        if(type==1){
            bowtieBean.setRead_1(input_reads_bowtie);
        }
        else{
            bowtieBean.setRead_1(input_reads_pair1_bowtie);
            bowtieBean.setRead_2(input_reads_pair2_bowtie);
            if(bowtie_best==1){
                bowtieBean.setBest("");
            }
            else{
                bowtieBean.setBest(" --best --strata");
            }

        }
        bowtieBean.setRead_type(type);
///////////////// ///////////////////////////index option//////////////////////////////////////////////////////////
        if(bowtie_option_radio==1){
            bowtieBean.setIndex_option(" ");
        }
        else{
            if(bowtie_nodc==1){
                nodc="";
            }
            else{
                nodc="--nodc";
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
            bowtieBean.setIndex_option("--offrate "+bowtie_offrate+" -t "+bowtie_t+" "+nodc+" "+justref+" "+ntoa);
        }
/////////////////////////////////////////////////////////////////input option///////////////////////////////////////
        if(inputOption_bowtie_mode==1){
            bowtieBean.setVn_option("-n "+bowtie_mode_n+" "+"-l"+bowtie_mode_l+" -e "+bowtie_mode_e+" --maxbts "+bowtie_maximun);
        }
        else{
            bowtieBean.setVn_option("-v "+bowtie_mode_v);
        }
        bowtieBean.setInput_option("-s "+bowtie_s+" -u "+bowtie_u+" -5 "+bowtie_5+" -3 "+bowtie_3);
///////////////////////////////////////////////////Alignment option///////////////////////////////////////////////
        String  noma;
        if(bowtie_nomaqround==1){
            noma="";
        }
        else{
            noma="--nomaqround";
        }
        bowtieBean.setAli_option(noma+" -I "+bowtie_I+" -X "+bowtie_X);
///////////////////////////////////////////////////report option//////////////////////////////////////////////////
        String a;
        if(bowtie_a==1){
            a="";
        }
        else{
            a="-a";
        }
        bowtieBean.setReport_option("-k "+bowtie_k+" "+a);
//////////////////////////////////////////////////
        bowtieBean.setPath(input_path_bowtie);
        bowtieService.setBowtieBean(bowtieBean);
        if(refer_index_bowtie==1){
            bowtieBean.setReference(input_re_bowtie);
            stdoutlist=bowtieService.Bowtie();
        }
        else{
            if(built_in_bowtie==1){
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "hg19");
                bowtieBean.setReference(commandline);
            }
            else{
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "mm8");
                bowtieBean.setReference(commandline);
            }
            stdoutlist=bowtieService.Bowtie_unIndex();
        }
        flag="2";
        flag_validate="1";
        return SUCCESS;
    }
    public static void appendMethodB(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void validate(){
        if(refer_index_bowtie==1){
            if(input_re_bowtie.equals("")){
                this.addFieldError("input_re_bowtie", "Please input the reference.");
            }
        }
        if(type==1){
            if(input_reads_bowtie.equals("")){
                this.addFieldError("input_reads_bowtie", "Please input the reads.");
            }
        }
        else{
            if(input_reads_pair1_bowtie.equals("")){
                this.addFieldError("input_reads_pair1_bowtie", "Please input the reads.");
            }
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_bowtieFileName,fileField_bowtie)){
                /*HttpServletResponse response = ServletActionContext.getResponse();
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().println("<script language='javascript'>alert('The file should be in right format and right size!');</script>");*/
                this.addFieldError("check1", "The file should be in right format and right size!");
            }
        }catch(Exception e){
        }
        if(check()){
            this.addFieldError("check1", "The input contain invalid characters! ");
        }
       /* xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="2";
        flag_validate="2";
    }
    public boolean check() {
        String[] characterParams = {"~", "`", "!", "@", "#", "$", "%", "^", "&", "{", "}", "[", "]", "(", ")", ";", "\"", "'", "\\", "<", ">", "?", "/", "<<", ">>", "+"};
        boolean status = false;
        Map paramMap = ServletActionContext.getRequest().getParameterMap();
        Set<String> set = paramMap.keySet();
        String value="";
        for(Object aaa: set.toArray()){
            value = ((String[])paramMap.get(aaa))[0];
            for (int i = 0; i < characterParams.length; i++) {
                if (value.indexOf(characterParams[i]) >= 0) {
                    status = true;
                    break;
                }
            }
        }
        return status;
    }
}
