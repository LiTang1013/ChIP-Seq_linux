package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.BWABean;
import ChIP_Seq.bean.BWABean_pair;
import ChIP_Seq.service.BWAService;
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

/**
 * Created by Administrator on 2016/4/18 0018.
 */
public class BWAction extends ActionSupport{
    private int  BWA_type;
    private int built_in_BWA;
    private int refer_index_BWA;
    private int long_short;
    private int buildOrnot;
    private String input_BWA_reference;
    private String input_BWA_reads_single;
    private String input_BWA_reads_pair1;
    private String input_BWA_reads_pair2;
    private String input_BWA_path;
    private String analysisMode_n;
    private String analysisMode_o,analysisMode_e,analysisMode_i,analysisMode_d,analysisMode_l,analysisMode_k,analysisMode_m,analysisMode_M,analysisMode_O,analysisMode_E,analysisMode_R,analysisMode_q,analysisMode_B,analysisMode_L;
    private int analysisMode;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;

    private List<File> fileField_bwa;
    private List<String> fileField_bwaFileName;

    private int upload_ornot;

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

    public List<File> getFileField_bwa() {
        return fileField_bwa;
    }

    public void setFileField_bwa(List<File> fileField_bwa) {
        this.fileField_bwa = fileField_bwa;
    }

    public List<String> getFileField_bwaFileName() {
        return fileField_bwaFileName;
    }

    public void setFileField_bwaFileName(List<String> fileField_bwaFileName) {
        this.fileField_bwaFileName = fileField_bwaFileName;
    }

    public int getUpload_ornot() {
        return upload_ornot;
    }

    public void setUpload_ornot(int upload_ornot) {
        this.upload_ornot = upload_ornot;
    }


    public int getBWA_type() {
        return BWA_type;
    }

    public void setBWA_type(int BWA_type) {
        this.BWA_type = BWA_type;
    }

    public String getInput_BWA_reference() {
        return input_BWA_reference;
    }

    public void setInput_BWA_reference(String input_BWA_reference) {
        this.input_BWA_reference = input_BWA_reference;
    }

    public String getInput_BWA_reads_single() {
        return input_BWA_reads_single;
    }

    public void setInput_BWA_reads_single(String input_BWA_reads_single) {
        this.input_BWA_reads_single = input_BWA_reads_single;
    }

    public String getInput_BWA_reads_pair2() {
        return input_BWA_reads_pair2;
    }

    public void setInput_BWA_reads_pair2(String input_BWA_reads_pair2) {
        this.input_BWA_reads_pair2 = input_BWA_reads_pair2;
    }

    public String getInput_BWA_reads_pair1() {
        return input_BWA_reads_pair1;
    }

    public void setInput_BWA_reads_pair1(String input_BWA_reads_pair1) {
        this.input_BWA_reads_pair1 = input_BWA_reads_pair1;
    }

    public String getInput_BWA_path() {
        return input_BWA_path;
    }

    public void setInput_BWA_path(String input_BWA_path) {
        this.input_BWA_path = input_BWA_path;
    }

    public int getBuilt_in_BWA() {
        return built_in_BWA;
    }

    public void setBuilt_in_BWA(int built_in_BWA) {
        this.built_in_BWA = built_in_BWA;
    }

    public int getRefer_index_BWA() {
        return refer_index_BWA;
    }

    public void setRefer_index_BWA(int refer_index_BWA) {
        this.refer_index_BWA = refer_index_BWA;
    }

    public String getAnalysisMode_n() {
        return analysisMode_n;
    }

    public void setAnalysisMode_n(String analysisMode_n) {
        this.analysisMode_n = analysisMode_n;
    }

    public String getAnalysisMode_o() {
        return analysisMode_o;
    }

    public void setAnalysisMode_o(String analysisMode_o) {
        this.analysisMode_o = analysisMode_o;
    }

    public String getAnalysisMode_e() {
        return analysisMode_e;
    }

    public void setAnalysisMode_e(String analysisMode_e) {
        this.analysisMode_e = analysisMode_e;
    }

    public String getAnalysisMode_i() {
        return analysisMode_i;
    }

    public void setAnalysisMode_i(String analysisMode_i) {
        this.analysisMode_i = analysisMode_i;
    }

    public String getAnalysisMode_d() {
        return analysisMode_d;
    }

    public void setAnalysisMode_d(String analysisMode_d) {
        this.analysisMode_d = analysisMode_d;
    }

    public String getAnalysisMode_l() {
        return analysisMode_l;
    }

    public void setAnalysisMode_l(String analysisMode_l) {
        this.analysisMode_l = analysisMode_l;
    }

    public String getAnalysisMode_k() {
        return analysisMode_k;
    }

    public void setAnalysisMode_k(String analysisMode_k) {
        this.analysisMode_k = analysisMode_k;
    }

    public String getAnalysisMode_m() {
        return analysisMode_m;
    }

    public void setAnalysisMode_m(String analysisMode_m) {
        this.analysisMode_m = analysisMode_m;
    }

    public String getAnalysisMode_M() {
        return analysisMode_M;
    }

    public void setAnalysisMode_M(String analysisMode_M) {
        this.analysisMode_M = analysisMode_M;
    }

    public String getAnalysisMode_O() {
        return analysisMode_O;
    }

    public void setAnalysisMode_O(String analysisMode_O) {
        this.analysisMode_O = analysisMode_O;
    }

    public String getAnalysisMode_E() {
        return analysisMode_E;
    }

    public void setAnalysisMode_E(String analysisMode_E) {
        this.analysisMode_E = analysisMode_E;
    }

    public String getAnalysisMode_R() {
        return analysisMode_R;
    }

    public void setAnalysisMode_R(String analysisMode_R) {
        this.analysisMode_R = analysisMode_R;
    }

    public String getAnalysisMode_q() {
        return analysisMode_q;
    }

    public void setAnalysisMode_q(String analysisMode_q) {
        this.analysisMode_q = analysisMode_q;
    }

    public String getAnalysisMode_B() {
        return analysisMode_B;
    }

    public void setAnalysisMode_B(String analysisMode_B) {
        this.analysisMode_B = analysisMode_B;
    }

    public String getAnalysisMode_L() {
        return analysisMode_L;
    }

    public void setAnalysisMode_L(String analysisMode_L) {
        this.analysisMode_L = analysisMode_L;
    }

    public int getAnalysisMode() {
        return analysisMode;
    }

    public int getLong_short() {
        return long_short;
    }

    public void setLong_short(int long_short) {
        this.long_short = long_short;
    }

    public void setAnalysisMode(int analysisMode) {
        this.analysisMode = analysisMode;
    }

    public int getBuildOrnot() {
        return buildOrnot;
    }

    public void setBuildOrnot(int buildOrnot) {
        this.buildOrnot = buildOrnot;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String BWA_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ///////////////////////////////////////////////////////////////
            String remote_re,remote_file,remote_file1,remote_file2;
            UploadUtil uploadUtil=new UploadUtil();
            List<String> Upload_path=uploadUtil.upload(fileField_bwaFileName,fileField_bwa);
        if(refer_index_BWA==1){
            remote_re=Upload_path.get(0);
            if(BWA_type==1){
                remote_file=Upload_path.get(1);
                remote_file1="";
                remote_file2="";
            }
            else{
                remote_file="";
                remote_file1=Upload_path.get(1);
                remote_file2=Upload_path.get(2);
            }
        }
        else{
            remote_re="";
            if(BWA_type==1){
                remote_file=Upload_path.get(0);
                remote_file1="";
                remote_file2="";
            }
            else{
                remote_file="";
                remote_file1=Upload_path.get(0);
                remote_file2=Upload_path.get(1);
            }
        }
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_bwa.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        appendMethodB(admin_path,"Result path:"+"\r\n");
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "BWA", "ERROR","email",time);
        /////////////////////////////////////////////////////////////////////
        FileUtil fileUtil1=new FileUtil();
        input_BWA_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_BWA_path+"\r\n");

        BWAService bwaService= (BWAService) applicationContext.getBean("bwaService");
        if(BWA_type==1){
            BWABean bwaBean=new BWABean();
            bwaBean.setInput_BWA_reads_single(remote_file);
            if(refer_index_BWA==1){
                bwaBean.setInput_BWA_reference(remote_re);
            }
           else{
                if(built_in_BWA==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean.setInput_BWA_reference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean.setInput_BWA_reference(commandline);
                }
            }
            bwaBean.setInput_BWA_path(input_BWA_path);
            if(analysisMode==1){
                bwaBean.setOption(" ");
            }
            else{
                bwaBean.setOption("-n " + analysisMode_n + " -o " + analysisMode_o + " -e " + analysisMode_e + " -i " + analysisMode_i + " -d " + analysisMode_d + " -l " + analysisMode_l + " -k " + analysisMode_k + " -m " + analysisMode_m + " -M " + analysisMode_M + " -O " + analysisMode_O + " -E " + analysisMode_E + " -R " + analysisMode_R + " -q " + analysisMode_q + " -B " + analysisMode_B + " -L " + analysisMode_L);
            }
            bwaBean.setLong_short(long_short);
            bwaService.setBwaBean(bwaBean);

        }
        else {
            BWABean_pair bwaBean_pair=new BWABean_pair();
            if(refer_index_BWA==1){
                bwaBean_pair.setInput_BWA_reference(remote_re);
            }
            else{
                if(built_in_BWA==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean_pair.setInput_BWA_reference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean_pair.setInput_BWA_reference(commandline);
                }
            }
            bwaBean_pair.setInput_BWA_reads_pair1(remote_file1);
            bwaBean_pair.setInput_BWA_reads_pair2(remote_file2);
            bwaBean_pair.setInput_BWA_path(input_BWA_path);
            bwaBean_pair.setLong_short(long_short);
            if(analysisMode==1){
                bwaBean_pair.setOption(" ");
            }
            else{
                bwaBean_pair.setOption("-n " + analysisMode_n + " -o " + analysisMode_o + " -e " + analysisMode_e + " -i " + analysisMode_i + " -d " + analysisMode_d + " -l " + analysisMode_l + " -k " + analysisMode_k + " -m " + analysisMode_m + " -M " + analysisMode_M + " -O " + analysisMode_O + " -E " + analysisMode_E + " -R " + analysisMode_R + " -q " + analysisMode_q + " -B " + analysisMode_B + " -L " + analysisMode_L);
            }
            bwaService.setBwaBean_pair(bwaBean_pair);

        }
        flag="1";
        flag_validate="1";
        stdoutlist=bwaService.BWA();


        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }

    public String BWA_noUpload(){
        BWAService bwaService=( BWAService)applicationContext.getBean("bwaService");
        if(BWA_type==1){
            BWABean bwaBean=new BWABean();
            bwaBean.setInput_BWA_reads_single(input_BWA_reads_single);
            if(refer_index_BWA==1){
                bwaBean.setInput_BWA_reference(input_BWA_reference);
            }
            else{
                if(built_in_BWA==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean.setInput_BWA_reference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean.setInput_BWA_reference(commandline);
                }
            }
            bwaBean.setInput_BWA_path(input_BWA_path);
            if(analysisMode==1){
                bwaBean.setOption(" ");
            }
            else{
                bwaBean.setOption("-n " + analysisMode_n + " -o " + analysisMode_o + " -e " + analysisMode_e + " -i " + analysisMode_i + " -d " + analysisMode_d + " -l " + analysisMode_l + " -k " + analysisMode_k + " -m " + analysisMode_m + " -M " + analysisMode_M + " -O " + analysisMode_O + " -E " + analysisMode_E + " -R " + analysisMode_R + " -q " + analysisMode_q + " -B " + analysisMode_B + " -L " + analysisMode_L);
            }
            bwaBean.setLong_short(long_short);
            bwaService.setBwaBean(bwaBean);
            bwaService.BWA();
        }
        else {
            BWABean_pair bwaBean_pair=new BWABean_pair();
            if(refer_index_BWA==1){
                bwaBean_pair.setInput_BWA_reference(input_BWA_reference);
            }
            else{
                if(built_in_BWA==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean_pair.setInput_BWA_reference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bwaBean_pair.setInput_BWA_reference(commandline);
                }
            }
            bwaBean_pair.setInput_BWA_reads_pair1(input_BWA_reads_pair1);
            bwaBean_pair.setInput_BWA_reads_pair2(input_BWA_reads_pair2);
            bwaBean_pair.setInput_BWA_path(input_BWA_path);
            bwaBean_pair.setLong_short(long_short);
            if(analysisMode==1){
                bwaBean_pair.setOption(" ");
            }
            else{
                bwaBean_pair.setOption("-n " + analysisMode_n + " -o " + analysisMode_o + " -e " + analysisMode_e + " -i " + analysisMode_i + " -d " + analysisMode_d + " -l " + analysisMode_l + " -k " + analysisMode_k + " -m " + analysisMode_m + " -M " + analysisMode_M + " -O " + analysisMode_O + " -E " + analysisMode_E + " -R " + analysisMode_R + " -q " + analysisMode_q + " -B " + analysisMode_B + " -L " + analysisMode_L);
            }
            bwaService.setBwaBean_pair(bwaBean_pair);
            bwaService.BWA_pair();
        }
        flag="1";
        flag_validate="1";
        stdoutlist=bwaService.BWA();
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

        if(refer_index_BWA==1){
            if(input_BWA_reference.equals("")){
                this.addFieldError("input_BWA_reference", "Please input the reference.");
            }
        }
        if(BWA_type==1){
            if(input_BWA_reads_single.equals("")){
                this.addFieldError("input_BWA_reads_single", "Please input the reads.");
            }
        }
        else{
            if(input_BWA_reads_pair1.equals("")){
                this.addFieldError("input_BWA_reads_pair1", "Please input the reads.");
            }
        }
      /*  xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="1";
        flag_validate="2";
    }
}
