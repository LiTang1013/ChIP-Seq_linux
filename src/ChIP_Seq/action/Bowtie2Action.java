package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.Bowtie2Bean;
import ChIP_Seq.bean.Bowtie2Bean_pair;
import ChIP_Seq.service.Bowtie2Service;
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
 * Created by Administrator on 2016/4/9 0009.
 */
public class Bowtie2Action extends ActionSupport{
    private int type;
    private String input_path;
    private String input_reads;
    private String input_re;
    private int refer_index;
    private String input_reads_pair1;
    private String input_reads_pair2;
    private int inputOption;
    private String setting_skip;
    private String setting_u;
    private String setting_trim5;
    private String setting_trim3;
    private String alignment_N;
    private String alignment_L;
    private String alignment_i;
    private String alignment_n;
    private String alignment_dpad;
    private String alignment_gbar;
    private String scoreOption;
    private String score_ma;
    private String score_mp;
    private String score_np;
    private String score_rdg5;
    private String score_rdg3;
    private String score_rfg5;
    private String score_rfg3;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_bowtie2_re;
    private File fileField_bowtie2_read;
    private File fileField_bowtie2_pair1;
    private File fileField_bowtie2_pair2;
    private String fileField_bowtie2_reFileName;
    private String fileField_bowtie2_readFileName;
    private String fileField_bowtie2_pair1FileName;
    private String fileField_bowtie2_pair2FileName;
    private String account_hidden;
    private List<File> fileField_bowtie2;
    private List<String> fileField_bowtie2FileName;
    private int bowtie2_select_index;

    public int getBowtie2_select_index() {
        return bowtie2_select_index;
    }

    public void setBowtie2_select_index(int bowtie2_select_index) {
        this.bowtie2_select_index = bowtie2_select_index;
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

    public List<File> getFileField_bowtie2() {
        return fileField_bowtie2;
    }

    public void setFileField_bowtie2(List<File> fileField_bowtie2) {
        this.fileField_bowtie2 = fileField_bowtie2;
    }

    public List<String> getFileField_bowtie2FileName() {
        return fileField_bowtie2FileName;
    }

    public void setFileField_bowtie2FileName(List<String> fileField_bowtie2FileName) {
        this.fileField_bowtie2FileName = fileField_bowtie2FileName;
    }

    public File getFileField_bowtie2_re() {
        return fileField_bowtie2_re;
    }

    public void setFileField_bowtie2_re(File fileField_bowtie2_re) {
        this.fileField_bowtie2_re = fileField_bowtie2_re;
    }

    public File getFileField_bowtie2_read() {
        return fileField_bowtie2_read;
    }

    public void setFileField_bowtie2_read(File fileField_bowtie2_read) {
        this.fileField_bowtie2_read = fileField_bowtie2_read;
    }

    public File getFileField_bowtie2_pair1() {
        return fileField_bowtie2_pair1;
    }

    public void setFileField_bowtie2_pair1(File fileField_bowtie2_pair1) {
        this.fileField_bowtie2_pair1 = fileField_bowtie2_pair1;
    }

    public File getFileField_bowtie2_pair2() {
        return fileField_bowtie2_pair2;
    }

    public void setFileField_bowtie2_pair2(File fileField_bowtie2_pair2) {
        this.fileField_bowtie2_pair2 = fileField_bowtie2_pair2;
    }

    public String getFileField_bowtie2_reFileName() {
        return fileField_bowtie2_reFileName;
    }

    public void setFileField_bowtie2_reFileName(String fileField_bowtie2_reFileName) {
        this.fileField_bowtie2_reFileName = fileField_bowtie2_reFileName;
    }

    public String getFileField_bowtie2_readFileName() {
        return fileField_bowtie2_readFileName;
    }

    public void setFileField_bowtie2_readFileName(String fileField_bowtie2_readFileName) {
        this.fileField_bowtie2_readFileName = fileField_bowtie2_readFileName;
    }

    public String getFileField_bowtie2_pair1FileName() {
        return fileField_bowtie2_pair1FileName;
    }

    public void setFileField_bowtie2_pair1FileName(String fileField_bowtie2_pair1FileName) {
        this.fileField_bowtie2_pair1FileName = fileField_bowtie2_pair1FileName;
    }

    public String getFileField_bowtie2_pair2FileName() {
        return fileField_bowtie2_pair2FileName;
    }

    public void setFileField_bowtie2_pair2FileName(String fileField_bowtie2_pair2FileName) {
        this.fileField_bowtie2_pair2FileName = fileField_bowtie2_pair2FileName;
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

    public String getInput_re() {
        return input_re;
    }
    public void setInput_re(String input_re) {
        this.input_re = input_re;
    }

    public String getInput_path() {
        return input_path;
    }

    public void setInput_path(String input_path) {
        this.input_path = input_path;
    }

    public String getInput_reads() {
        return input_reads;
    }

    public void setInput_reads(String input_reads) {
        this.input_reads = input_reads;
    }

    public int getRefer_index() {
        return refer_index;
    }

    public void setRefer_index(int refer_index) {
        this.refer_index = refer_index;
    }

    public String getInput_reads_pair2() {
        return input_reads_pair2;
    }

    public void setInput_reads_pair2(String input_reads_pair2) {
        this.input_reads_pair2 = input_reads_pair2;
    }

    public String getInput_reads_pair1() {
        return input_reads_pair1;
    }

    public void setInput_reads_pair1(String input_reads_pair1) {
        this.input_reads_pair1 = input_reads_pair1;
    }


    public int getInputOption() {
        return inputOption;
    }

    public void setInputOption(int inputOption) {
        this.inputOption = inputOption;
    }

    public String getSetting_skip() {
        return setting_skip;
    }

    public void setSetting_skip(String setting_skip) {
        this.setting_skip = setting_skip;
    }

    public String getSetting_u() {
        return setting_u;
    }

    public void setSetting_u(String setting_u) {
        this.setting_u = setting_u;
    }

    public String getSetting_trim5() {
        return setting_trim5;
    }

    public void setSetting_trim5(String setting_trim5) {
        this.setting_trim5 = setting_trim5;
    }

    public String getSetting_trim3() {
        return setting_trim3;
    }

    public void setSetting_trim3(String setting_trim3) {
        this.setting_trim3 = setting_trim3;
    }


    public String getAlignment_N() {
        return alignment_N;
    }

    public void setAlignment_N(String alignment_N) {
        this.alignment_N = alignment_N;
    }

    public String getAlignment_L() {
        return alignment_L;
    }

    public void setAlignment_L(String alignment_L) {
        this.alignment_L = alignment_L;
    }

    public String getAlignment_i() {
        return alignment_i;
    }

    public void setAlignment_i(String alignment_i) {
        this.alignment_i = alignment_i;
    }

    public String getAlignment_n() {
        return alignment_n;
    }

    public void setAlignment_n(String alignment_n) {
        this.alignment_n = alignment_n;
    }

    public String getAlignment_dpad() {
        return alignment_dpad;
    }

    public void setAlignment_dpad(String alignment_dpad) {
        this.alignment_dpad = alignment_dpad;
    }

    public String getAlignment_gbar() {
        return alignment_gbar;
    }

    public void setAlignment_gbar(String alignment_gbar) {
        this.alignment_gbar = alignment_gbar;
    }

    public String getScoreOption() {
        return scoreOption;
    }

    public void setScoreOption(String scoreOption) {
        this.scoreOption = scoreOption;
    }

    public String getScore_ma() {
        return score_ma;
    }

    public void setScore_ma(String score_ma) {
        this.score_ma = score_ma;
    }

    public String getScore_mp() {
        return score_mp;
    }

    public void setScore_mp(String score_mp) {
        this.score_mp = score_mp;
    }

    public String getScore_np() {
        return score_np;
    }

    public void setScore_np(String score_np) {
        this.score_np = score_np;
    }

    public String getScore_rdg5() {
        return score_rdg5;
    }

    public void setScore_rdg5(String score_rdg5) {
        this.score_rdg5 = score_rdg5;
    }

    public String getScore_rdg3() {
        return score_rdg3;
    }

    public void setScore_rdg3(String score_rdg3) {
        this.score_rdg3 = score_rdg3;
    }

    public String getScore_rfg5() {
        return score_rfg5;
    }

    public void setScore_rfg5(String score_rfg5) {
        this.score_rfg5 = score_rfg5;
    }

    public String getScore_rfg3() {
        return score_rfg3;
    }

    public void setScore_rfg3(String score_rfg3) {
        this.score_rfg3 = score_rfg3;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String Bowtie2_exe()throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        /////////////////////////////////////////////////////////////////////////
        String remote_re,remote_read,remote_file1,remote_file2;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload( fileField_bowtie2FileName, fileField_bowtie2);
        if(refer_index==1){
            if(type==1){
                remote_read=Upload_path.get(1);
                remote_file1="";
                remote_file2="";
            }
            else{
                remote_read="";
                remote_file1=Upload_path.get(1);
                remote_file2=Upload_path.get(2);
            }
            remote_re=Upload_path.get(0);
        }
        else{
            if(type==1){
                remote_read=Upload_path.get(0);
                remote_file1="";
                remote_file2="";
            }
            else{
                remote_read="";
                remote_file1=Upload_path.get(0);
                remote_file2=Upload_path.get(1);
            }
            remote_re="";
        }
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_bowtie2.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Bowtie2", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////////
        Bowtie2Service bowtie2Service= (Bowtie2Service) applicationContext.getBean("bowtie2Service");
        FileUtil fileUtil1=new FileUtil();
        input_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_path+"\r\n");
        if(type==1){
            Bowtie2Bean bowtie2Bean=new Bowtie2Bean();
            bowtie2Bean.setReads(remote_read);
            bowtie2Bean.setPath(input_path);
            if(inputOption==1) {
                bowtie2Bean.setOption("-s 0 -u 100000000 -5 0 -3 0 -N 0 -L 22 -i S,1,1.15 --n-ceil L,0,0.15 --dpad 15 --gbar 4 --ma 2 --mp 6,2 --np 1 --rdg 5,3 --rfg 5,3");
            }
            else{
                bowtie2Bean.setOption("-s " + setting_skip + " -u " + setting_u + " -5 " + setting_trim5 + " -3 " + setting_trim3 + " -N " + alignment_N + " -L " + alignment_L + " -i " + alignment_i + " --n-ceil " + alignment_n + " --dpad " + alignment_dpad + " --gbar " + alignment_gbar + " --ma " + score_ma + " --mp " + score_mp + " --np " + score_np + " --rdg " + score_rdg5 + "," + score_rdg3 + " " + " --rfg " + score_rfg5 + "," + score_rfg3);
            }
            if(refer_index==1){
                bowtie2Bean.setReference(remote_re);
                bowtie2Service.setBowtie2Bean(bowtie2Bean);
                stdoutlist=bowtie2Service.Bowtie2();
            }
            else{
                if(bowtie2_select_index==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bowtie2Bean.setReference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "mm8");
                    bowtie2Bean.setReference(commandline);
                }
                bowtie2Service.setBowtie2Bean(bowtie2Bean);
                stdoutlist=bowtie2Service.Bowtie2_noBuild();
            }
        }
       else {
            Bowtie2Bean_pair bowtie2Bean_pair = new Bowtie2Bean_pair();
            bowtie2Bean_pair.setReads_left(remote_file1);
            bowtie2Bean_pair.setReads_right(remote_file2);
            bowtie2Bean_pair.setPath(input_path);
            bowtie2Bean_pair.setOption("-s " + setting_skip + " -u " + setting_u + " -5 " + setting_trim5 + " -3 " + setting_trim3 + " -N " + alignment_N + " -L " + alignment_L + " -i " + alignment_i + " --n-ceil " + alignment_n + " --dpad " + alignment_dpad + " --gbar " + alignment_gbar + " --ma " + score_ma + " --mp " + score_mp + " --np " + score_np + " --rdg " + score_rdg5 + "," + score_rdg3 + " " + " --rfg " + score_rfg5 + "," + score_rfg3);
            if(refer_index==1){
                bowtie2Bean_pair.setReference(remote_re);
                bowtie2Service.setBowtie2Bean_pair(bowtie2Bean_pair);
                stdoutlist=bowtie2Service.Bowtie2_pair();
            }
            else{
                if(bowtie2_select_index==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bowtie2Bean_pair.setReference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "mm8");
                    bowtie2Bean_pair.setReference(commandline);
                }
                bowtie2Service.setBowtie2Bean_pair(bowtie2Bean_pair);
                stdoutlist=bowtie2Service.Bowtie2_pair_noBuild();
            }
        }

        flag="3";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String Bowtie2_noUpload(){
        Bowtie2Service bowtie2Service= (Bowtie2Service) applicationContext.getBean("bowtie2Service");
        if(type==1){
            Bowtie2Bean bowtie2Bean=new Bowtie2Bean();
            bowtie2Bean.setReads(input_reads);
            bowtie2Bean.setPath(input_path);
            if(inputOption==1) {
                bowtie2Bean.setOption("-s 0 -u 100000000 -5 0 -3 0 -N 0 -L 22 -i S,1,1.15 --n-ceil L,0,0.15 --dpad 15 --gbar 4 --ma 2 --mp 6,2 --np 1 --rdg 5,3 --rfg 5,3");
            }
            else{
                bowtie2Bean.setOption("-s " + setting_skip + " -u " + setting_u + " -5 " + setting_trim5 + " -3 " + setting_trim3 + " -N " + alignment_N + " -L " + alignment_L + " -i " + alignment_i + " --n-ceil " + alignment_n + " --dpad " + alignment_dpad + " --gbar " + alignment_gbar + " --ma " + score_ma + " --mp " + score_mp + " --np " + score_np + " --rdg " + score_rdg5 + "," + score_rdg3 + " " + " --rfg " + score_rfg5 + "," + score_rfg3);
            }
            if(refer_index==1){
                bowtie2Bean.setReference(input_re);
                bowtie2Service.setBowtie2Bean(bowtie2Bean);
                stdoutlist=bowtie2Service.Bowtie2();
            }
            else{
                if(bowtie2_select_index==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bowtie2Bean.setReference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "mm8");
                    bowtie2Bean.setReference(commandline);
                }
                bowtie2Service.setBowtie2Bean(bowtie2Bean);
                stdoutlist=bowtie2Service.Bowtie2_noBuild();
            }
        }
        else {
            Bowtie2Bean_pair bowtie2Bean_pair = new Bowtie2Bean_pair();
            bowtie2Bean_pair.setReads_left(input_reads_pair1);
            bowtie2Bean_pair.setReads_right(input_reads_pair2);
            bowtie2Bean_pair.setPath(input_path);
            bowtie2Bean_pair.setOption("-s " + setting_skip + " -u " + setting_u + " -5 " + setting_trim5 + " -3 "+setting_trim3+" -N "+alignment_N+" -L "+alignment_L+" -i "+alignment_i+" --n-ceil "+alignment_n+" --dpad "+alignment_dpad+" --gbar "+alignment_gbar+" --ma "+score_ma+" --mp "+score_mp+" --np "+score_np+" --rdg "+score_rdg5+","+score_rdg3+" "+" --rfg "+score_rfg5+","+score_rfg3);
            if(refer_index==1){
                bowtie2Bean_pair.setReference(input_re);
                bowtie2Service.setBowtie2Bean_pair(bowtie2Bean_pair);
                stdoutlist=bowtie2Service.Bowtie2_pair();
            }
            else{
                if(bowtie2_select_index==1){
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "hg19");
                    bowtie2Bean_pair.setReference(commandline);
                }
                else{
                    String commandline;
                    commandline = GetProperty.getPropertyByName("Config", "mm8");
                    bowtie2Bean_pair.setReference(commandline);
                }
                bowtie2Service.setBowtie2Bean_pair(bowtie2Bean_pair);
                stdoutlist=bowtie2Service.Bowtie2_pair_noBuild();
            }
        }
        flag="3";
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
        if(input_re.equals("")) {
            this.addFieldError("input_re", "Please input the reference.");
        }
            if(type==1){
                if(input_reads.equals("")){
                    this.addFieldError("input_reads", "Please input the reads.");
                }
            }
            else{
                if(input_reads_pair1.equals("")){
                    this.addFieldError("input_reads_pair1", "Please input the reads.");
                }
        }
       /* xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="3";
        flag_validate="2";
    }
}
