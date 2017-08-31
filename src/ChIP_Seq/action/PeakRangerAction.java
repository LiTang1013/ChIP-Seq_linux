package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.PeakRangerBean;
import ChIP_Seq.service.PeakRangerService;
import ChIP_Seq.xmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/8 0008.
 */
public class PeakRangerAction extends ActionSupport{
    private String input_tagfile_peakranger;
    private String input_controlfile_peakranger;
    private String input_path_peakranger;
    private int optionalParameters_peakRanger;
    private int select_peakranger;
    private int peakranger_format;
    private String account_hidden;

    private int peakranger_mode;
    private String peakranger_length;
    private String peakranger_annofile;
    private String peakranger_pvalue;
    private String peakranger_fdr;
    private String peakranger_relength;
    private String peakranger_delta;
    private String peakranger_bandwidth;
    private String peakranger_pad;
    private String peakranger_t;

    private int peakranger_mode1;
    private String peakranger_annofile1;
    private String peakranger_length1;
    private String peakranger_fdr1;
    private String peakranger_winsize1;
    private String peakranger_winstep1;
    private String peakranger_imcount1;
    private String peakranger_minscore;
    private String peakranger_relength1;
    private String peakranger_pvalue1;

    private int peakranger_mode2;
    private String peakranger_length2;
    private String peakranger_annofile2;
    private String peakranger_winsize2;
    private String peakranger_relength2;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_peakranger_tag;
    private File fileField_peakranger_control;
    private String fileField_peakranger_tagFileName;
    private String fileField_peakranger_controlFileName;
    private List<File> fileField_peakranger;
    private List<String> fileField_peakrangerFileName;

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

    public List<File> getFileField_peakranger() {
        return fileField_peakranger;
    }

    public void setFileField_peakranger(List<File> fileField_peakranger) {
        this.fileField_peakranger = fileField_peakranger;
    }

    public List<String> getFileField_peakrangerFileName() {
        return fileField_peakrangerFileName;
    }

    public void setFileField_peakrangerFileName(List<String> fileField_peakrangerFileName) {
        this.fileField_peakrangerFileName = fileField_peakrangerFileName;
    }

    public File getFileField_peakranger_tag() {
        return fileField_peakranger_tag;
    }

    public void setFileField_peakranger_tag(File fileField_peakranger_tag) {
        this.fileField_peakranger_tag = fileField_peakranger_tag;
    }

    public File getFileField_peakranger_control() {
        return fileField_peakranger_control;
    }

    public void setFileField_peakranger_control(File fileField_peakranger_control) {
        this.fileField_peakranger_control = fileField_peakranger_control;
    }

    public String getFileField_peakranger_tagFileName() {
        return fileField_peakranger_tagFileName;
    }

    public void setFileField_peakranger_tagFileName(String fileField_peakranger_tagFileName) {
        this.fileField_peakranger_tagFileName = fileField_peakranger_tagFileName;
    }

    public String getFileField_peakranger_controlFileName() {
        return fileField_peakranger_controlFileName;
    }

    public void setFileField_peakranger_controlFileName(String fileField_peakranger_controlFileName) {
        this.fileField_peakranger_controlFileName = fileField_peakranger_controlFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_tagfile_peakranger() {
        return input_tagfile_peakranger;
    }

    public String getPeakranger_annofile1() {
        return peakranger_annofile1;
    }

    public void setPeakranger_annofile1(String peakranger_annofile1) {
        this.peakranger_annofile1 = peakranger_annofile1;
    }

    public void setInput_tagfile_peakranger(String input_tagfile_peakranger) {
        this.input_tagfile_peakranger = input_tagfile_peakranger;
    }

    public String getInput_controlfile_peakranger() {
        return input_controlfile_peakranger;
    }

    public void setInput_controlfile_peakranger(String input_controlfile_peakranger) {
        this.input_controlfile_peakranger = input_controlfile_peakranger;
    }

    public String getInput_path_peakranger() {
        return input_path_peakranger;
    }

    public void setInput_path_peakranger(String input_path_peakranger) {
        this.input_path_peakranger = input_path_peakranger;
    }

    public int getOptionalParameters_peakRanger() {
        return optionalParameters_peakRanger;
    }

    public void setOptionalParameters_peakRanger(int optionalParameters_peakRanger) {
        this.optionalParameters_peakRanger = optionalParameters_peakRanger;
    }

    public int getSelect_peakranger() {
        return select_peakranger;
    }

    public void setSelect_peakranger(int select_peakranger) {
        this.select_peakranger = select_peakranger;
    }

    public int getPeakranger_format() {
        return peakranger_format;
    }

    public void setPeakranger_format(int peakranger_format) {
        this.peakranger_format = peakranger_format;
    }

    public int getPeakranger_mode() {
        return peakranger_mode;
    }

    public void setPeakranger_mode(int peakranger_mode) {
        this.peakranger_mode = peakranger_mode;
    }

    public String getPeakranger_length() {
        return peakranger_length;
    }

    public void setPeakranger_length(String peakranger_length) {
        this.peakranger_length = peakranger_length;
    }

    public String getPeakranger_annofile() {
        return peakranger_annofile;
    }

    public void setPeakranger_annofile(String peakranger_annofile) {
        this.peakranger_annofile = peakranger_annofile;
    }

    public String getPeakranger_pvalue() {
        return peakranger_pvalue;
    }

    public void setPeakranger_pvalue(String peakranger_pvalue) {
        this.peakranger_pvalue = peakranger_pvalue;
    }

    public String getPeakranger_fdr() {
        return peakranger_fdr;
    }

    public void setPeakranger_fdr(String peakranger_fdr) {
        this.peakranger_fdr = peakranger_fdr;
    }

    public String getPeakranger_relength() {
        return peakranger_relength;
    }

    public void setPeakranger_relength(String peakranger_relength) {
        this.peakranger_relength = peakranger_relength;
    }

    public String getPeakranger_delta() {
        return peakranger_delta;
    }

    public void setPeakranger_delta(String peakranger_delta) {
        this.peakranger_delta = peakranger_delta;
    }

    public String getPeakranger_bandwidth() {
        return peakranger_bandwidth;
    }

    public void setPeakranger_bandwidth(String peakranger_bandwidth) {
        this.peakranger_bandwidth = peakranger_bandwidth;
    }

    public String getPeakranger_pad() {
        return peakranger_pad;
    }

    public void setPeakranger_pad(String peakranger_pad) {
        this.peakranger_pad = peakranger_pad;
    }

    public String getPeakranger_t() {
        return peakranger_t;
    }

    public void setPeakranger_t(String peakranger_t) {
        this.peakranger_t = peakranger_t;
    }

    public int getPeakranger_mode1() {
        return peakranger_mode1;
    }

    public void setPeakranger_mode1(int peakranger_mode1) {
        this.peakranger_mode1 = peakranger_mode1;
    }

    public String getPeakranger_length1() {
        return peakranger_length1;
    }

    public void setPeakranger_length1(String peakranger_length1) {
        this.peakranger_length1 = peakranger_length1;
    }

    public String getPeakranger_fdr1() {
        return peakranger_fdr1;
    }

    public void setPeakranger_fdr1(String peakranger_fdr1) {
        this.peakranger_fdr1 = peakranger_fdr1;
    }

    public String getPeakranger_winsize1() {
        return peakranger_winsize1;
    }

    public void setPeakranger_winsize1(String peakranger_winsize1) {
        this.peakranger_winsize1 = peakranger_winsize1;
    }

    public String getPeakranger_winstep1() {
        return peakranger_winstep1;
    }

    public void setPeakranger_winstep1(String peakranger_winstep1) {
        this.peakranger_winstep1 = peakranger_winstep1;
    }

    public String getPeakranger_imcount1() {
        return peakranger_imcount1;
    }

    public void setPeakranger_imcount1(String peakranger_imcount1) {
        this.peakranger_imcount1 = peakranger_imcount1;
    }

    public String getPeakranger_minscore() {
        return peakranger_minscore;
    }

    public void setPeakranger_minscore(String peakranger_minscore) {
        this.peakranger_minscore = peakranger_minscore;
    }

    public String getPeakranger_relength1() {
        return peakranger_relength1;
    }

    public void setPeakranger_relength1(String peakranger_relength1) {
        this.peakranger_relength1 = peakranger_relength1;
    }

    public String getPeakranger_pvalue1() {
        return peakranger_pvalue1;
    }

    public void setPeakranger_pvalue1(String peakranger_pvalue1) {
        this.peakranger_pvalue1 = peakranger_pvalue1;
    }

    public int getPeakranger_mode2() {
        return peakranger_mode2;
    }

    public void setPeakranger_mode2(int peakranger_mode2) {
        this.peakranger_mode2 = peakranger_mode2;
    }

    public String getPeakranger_length2() {
        return peakranger_length2;
    }

    public void setPeakranger_length2(String peakranger_length2) {
        this.peakranger_length2 = peakranger_length2;
    }

    public String getPeakranger_annofile2() {
        return peakranger_annofile2;
    }

    public void setPeakranger_annofile2(String peakranger_annofile2) {
        this.peakranger_annofile2 = peakranger_annofile2;
    }

    public String getPeakranger_winsize2() {
        return peakranger_winsize2;
    }

    public void setPeakranger_winsize2(String peakranger_winsize2) {
        this.peakranger_winsize2 = peakranger_winsize2;
    }

    public String getPeakranger_relength2() {
        return peakranger_relength2;
    }

    public void setPeakranger_relength2(String peakranger_relength2) {
        this.peakranger_relength2 = peakranger_relength2;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public String peakranger_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ////////////////////////////////////////////////////////////////////////////
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_peakrangerFileName,fileField_peakranger);
        remote_tag= Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_peakranger.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "PaekRanger",  "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ///////////////////////////////////////////////////////////////////////////
        PeakRangerService peakRangerService= (PeakRangerService) applicationContext.getBean("peakRangerService");
        FileUtil fileUtil1=new FileUtil();
        input_path_peakranger=fileUtil1.Result_path();
        appendMethodB(admin_path,input_path_peakranger+"\r\n");

        PeakRangerBean peakRangerBean=new PeakRangerBean();
        peakRangerBean.setTagfile(remote_tag);
        peakRangerBean.setControlfile(remote_control);
        peakRangerBean.setPath(input_path_peakranger);
        File name=new File(remote_tag);
        String input_name_peakranger=name.getName().substring(0,name.getName().length()-4);
        System.out.println("PeakRanger__name"+input_name_peakranger);
        peakRangerBean.setName(input_name_peakranger);
        if (peakranger_format==1){
            peakRangerBean.setFormate("sam");
        }
        else if(peakranger_format==2){
            peakRangerBean.setFormate("bam");
        }
        else{
            peakRangerBean.setFormate("bed");
        }
        String mode,length,file,winsize,relength,annofile,fdr,winstep,mincount,minscore,l,p,q,r,b,pad,t;

        if(select_peakranger==3){
            if(peakranger_mode2==1){
                mode="--report";
            }
            else{
                mode="";
            }
            length=equal_valid(peakranger_length2,"--plot_region");
            file=equal_valid(peakranger_annofile2,"--gene_annot_file");
            winsize=equal_valid(peakranger_winsize2,"--win_size");
            relength=equal_valid(peakranger_relength2,"-l");
            peakRangerBean.setOption(mode+length +file +winsize+relength);
            peakRangerBean.setSelect_peakranger(" bcp ");
        }
        else if(select_peakranger==2){
            if(peakranger_mode1==1){
                mode="--report";
            }
            else{
                mode="";
            }
            length=equal_valid(peakranger_length1,"--plot_region");
            annofile=equal_valid(peakranger_annofile1,"--gene_annot_file");
            fdr=equal_valid(peakranger_fdr1,"-q");
            winsize=equal_valid(peakranger_winsize1,"--win_size");
            winstep=equal_valid(peakranger_winstep1, "--win_step");
            mincount=equal_valid(peakranger_imcount1,"--min_count");
            minscore=equal_valid(peakranger_minscore,"--min_score");
            l=equal_valid(peakranger_relength1,"-l");
            p=equal_valid(peakranger_pvalue1,"-p");
            peakRangerBean.setOption(mode+length+annofile+winsize+fdr+winstep+mincount+minscore+l+p);
            peakRangerBean.setSelect_peakranger(" ccat ");
        }
        else{
            if(peakranger_mode==1){
                mode="--report";
            }
            else{
                mode="";
            }
            length=equal_valid(peakranger_length,"--plot_region");
            annofile=equal_valid(peakranger_annofile,"--gene_annot_file");
            p=equal_valid(peakranger_pvalue,"-p");
            q=equal_valid(peakranger_fdr,"-q");
            l=equal_valid(peakranger_relength,"-l");
            r=equal_valid(peakranger_delta,"-r");
            b=equal_valid(peakranger_bandwidth,"-b");
            pad=equal_valid(peakranger_pad,"--pad");
            t=equal_valid(peakranger_t,"-t");
            peakRangerBean.setOption(mode+length+annofile+p+q+l+r+b+pad+t);
            peakRangerBean.setSelect_peakranger(" ranger ");
        }
        peakRangerService.setPeakRangerBean(peakRangerBean);
        stdoutlist=peakRangerService.PeakRanger();
        flag="12";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String PeakrangernoUpload(){
        PeakRangerService peakRangerService= (PeakRangerService) applicationContext.getBean("peakRangerService");
        FileUtil fileUtil=new FileUtil();
        input_path_peakranger=fileUtil.Result_path();
        PeakRangerBean peakRangerBean=new PeakRangerBean();
        peakRangerBean.setTagfile(input_tagfile_peakranger);
        peakRangerBean.setControlfile(input_controlfile_peakranger);
        peakRangerBean.setPath(input_path_peakranger);
        File name=new File(input_tagfile_peakranger);
        String input_name_peakranger=name.getName().substring(0,name.getName().length()-4);
        peakRangerBean.setName(input_name_peakranger);
        if(peakranger_format==1){
            peakRangerBean.setFormate("sam");
        }
        else if(peakranger_format==2){
            peakRangerBean.setFormate("bam");
        }
        else{
            peakRangerBean.setFormate("bed");
        }
        String mode,length,file,winsize,relength,annofile,fdr,winstep,mincount,minscore,l,p,q,r,b,pad,t;

        if(select_peakranger==3){
            if(peakranger_mode2==1){
                mode="--report";
            }
            else{
                mode="";
            }
            length=equal_valid(peakranger_length2,"--plot_region");
            file=equal_valid(peakranger_annofile2,"--gene_annot_file");
            winsize=equal_valid(peakranger_winsize2,"--win_size");
            relength=equal_valid(peakranger_relength2,"-l");
            peakRangerBean.setOption(mode+length +file +winsize+relength);
            peakRangerBean.setSelect_peakranger(" bcp ");
        }
        else if(select_peakranger==2){
            if(peakranger_mode1==1){
                mode="--report";
            }
            else{
                mode="";
            }
            length=equal_valid(peakranger_length1,"--plot_region");
            annofile=equal_valid(peakranger_annofile1,"--gene_annot_file");
            fdr=equal_valid(peakranger_fdr1,"-q");
            winsize=equal_valid(peakranger_winsize1,"--win_size");
            winstep=equal_valid(peakranger_winstep1, "--win_step");
            mincount=equal_valid(peakranger_imcount1,"--min_count");
            minscore=equal_valid(peakranger_minscore,"--min_score");
            l=equal_valid(peakranger_relength1,"-l");
            p=equal_valid(peakranger_pvalue1,"-p");
            peakRangerBean.setOption(mode+length+annofile+winsize+fdr+winstep+mincount+minscore+l+p);
            peakRangerBean.setSelect_peakranger(" ccat ");
        }
        else{
            if(peakranger_mode==1){
                mode="--report";
            }
            else{
                mode="";
            }
            length=equal_valid(peakranger_length,"--plot_region");
            annofile=equal_valid(peakranger_annofile,"--gene_annot_file");
            p=equal_valid(peakranger_pvalue,"-p");
            q=equal_valid(peakranger_fdr,"-q");
            l=equal_valid(peakranger_relength,"-l");
            r=equal_valid(peakranger_delta,"-r");
            b=equal_valid(peakranger_bandwidth,"-b");
            pad=equal_valid(peakranger_pad,"--pad");
            t=equal_valid(peakranger_t,"-t");
            peakRangerBean.setOption(mode+length+annofile+p+q+l+r+b+pad+t);
            peakRangerBean.setSelect_peakranger(" ranger ");
        }
        peakRangerService.setPeakRangerBean(peakRangerBean);
        stdoutlist=peakRangerService.PeakRanger();
        flag="12";
        flag_validate="1";
        return SUCCESS;
    }
    public String equal_valid(String temp1,String temp2){
        String validate;
        if(temp1.equals("")){
            validate="";
        }
        else{
            validate=" "+temp2+" "+temp1;
        }
        return validate;
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

        if(input_tagfile_peakranger.equals("")){
            this.addFieldError("input_tagfile_peakranger", "Please input the tag file.");
        }
        if(input_controlfile_peakranger.equals("")){
            this.addFieldError("input_controlfile_peakranger", "Please input the control file.");
        }
        /*xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="12";
        flag_validate="2";
    }
}
