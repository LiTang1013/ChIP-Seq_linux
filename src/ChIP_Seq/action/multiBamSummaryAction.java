package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.multiBamSummaryBean;
import ChIP_Seq.service.multiBamSummaryService;
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
<<<<<<< HEAD
import java.util.Map;
import java.util.Set;
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class multiBamSummaryAction extends ActionSupport {
    private int multi_mode,optionalParameters_multi,multi_ignore,multi_minmapping,multi_center,multi_samFlagInclude,multi_samFlagExclude,multi_minFragmentLength,multi_maxFragmentLength;
    private List<File> fileField_multi;
    private List<String> fileField_multiFileName;
    private String multi_l,multi_bs,multi_n,multi_r,multi_bl,multi_p,multi_out,multi_e;
    private String multi_bins_bamfile1,multi_bins_bamfile2;
    private String multi_bed_text;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

    public int getOptionalParameters_multi() {
        return optionalParameters_multi;
    }

    public void setOptionalParameters_multi(int optionalParameters_multi) {
        this.optionalParameters_multi = optionalParameters_multi;
    }

    public int getMulti_ignore() {
        return multi_ignore;
    }

    public void setMulti_ignore(int multi_ignore) {
        this.multi_ignore = multi_ignore;
    }

    public int getMulti_minmapping() {
        return multi_minmapping;
    }

    public void setMulti_minmapping(int multi_minmapping) {
        this.multi_minmapping = multi_minmapping;
    }

    public int getMulti_center() {
        return multi_center;
    }

    public void setMulti_center(int multi_center) {
        this.multi_center = multi_center;
    }

    public int getMulti_samFlagInclude() {
        return multi_samFlagInclude;
    }

    public void setMulti_samFlagInclude(int multi_samFlagInclude) {
        this.multi_samFlagInclude = multi_samFlagInclude;
    }

    public int getMulti_samFlagExclude() {
        return multi_samFlagExclude;
    }

    public void setMulti_samFlagExclude(int multi_samFlagExclude) {
        this.multi_samFlagExclude = multi_samFlagExclude;
    }

    public int getMulti_minFragmentLength() {
        return multi_minFragmentLength;
    }

    public void setMulti_minFragmentLength(int multi_minFragmentLength) {
        this.multi_minFragmentLength = multi_minFragmentLength;
    }

    public int getMulti_maxFragmentLength() {
        return multi_maxFragmentLength;
    }

    public void setMulti_maxFragmentLength(int multi_maxFragmentLength) {
        this.multi_maxFragmentLength = multi_maxFragmentLength;
    }

    public String getMulti_l() {
        return multi_l;
    }

    public void setMulti_l(String multi_l) {
        this.multi_l = multi_l;
    }

    public String getMulti_bs() {
        return multi_bs;
    }

    public void setMulti_bs(String multi_bs) {
        this.multi_bs = multi_bs;
    }

    public String getMulti_n() {
        return multi_n;
    }

    public void setMulti_n(String multi_n) {
        this.multi_n = multi_n;
    }

    public String getMulti_r() {
        return multi_r;
    }

    public void setMulti_r(String multi_r) {
        this.multi_r = multi_r;
    }

    public String getMulti_bl() {
        return multi_bl;
    }

    public void setMulti_bl(String multi_bl) {
        this.multi_bl = multi_bl;
    }

    public String getMulti_p() {
        return multi_p;
    }

    public void setMulti_p(String multi_p) {
        this.multi_p = multi_p;
    }

    public String getMulti_out() {
        return multi_out;
    }

    public void setMulti_out(String multi_out) {
        this.multi_out = multi_out;
    }

    public String getMulti_e() {
        return multi_e;
    }

    public void setMulti_e(String multi_e) {
        this.multi_e = multi_e;
    }

    public String getMulti_bins_bamfile1() {
        return multi_bins_bamfile1;
    }

    public void setMulti_bins_bamfile1(String multi_bins_bamfile1) {
        this.multi_bins_bamfile1 = multi_bins_bamfile1;
    }

    public String getMulti_bins_bamfile2() {
        return multi_bins_bamfile2;
    }

    public void setMulti_bins_bamfile2(String multi_bins_bamfile2) {
        this.multi_bins_bamfile2 = multi_bins_bamfile2;
    }

    public String getMulti_bed_text() {
        return multi_bed_text;
    }

    public void setMulti_bed_text(String multi_bed_text) {
        this.multi_bed_text = multi_bed_text;
    }

    public int getMulti_mode() {
        return multi_mode;
    }

    public void setMulti_mode(int multi_mode) {
        this.multi_mode = multi_mode;
    }

    public List<File> getFileField_multi() {
        return fileField_multi;
    }

    public void setFileField_multi(List<File> fileField_multi) {
        this.fileField_multi = fileField_multi;
    }

    public List<String> getFileField_multiFileName() {
        return fileField_multiFileName;
    }

    public void setFileField_multiFileName(List<String> fileField_multiFileName) {
        this.fileField_multiFileName = fileField_multiFileName;
    }

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String multi_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        //////////////////////////////////////////////////////////////////////////
        String remote_bam1,remote_bam2,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List <String> Upload_path=uploadUtil.upload(fileField_multiFileName,fileField_multi);
        remote_bam1=Upload_path.get(0);
        remote_bam2=Upload_path.get(1);
        if(multi_mode==1){
            remote_control="";
        }
        else{
            remote_control=Upload_path.get(2);
        }
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_multi.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "multiBamSummary",  "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////////
        multiBamSummaryService multiBamSummaryService= (multiBamSummaryService) applicationContext.getBean("multiBamSummaryService");
        FileUtil fileUtil1=new FileUtil();
        String path=fileUtil1.Result_path();
        appendMethodB(admin_path,path+"\r\n");

        multiBamSummaryBean multiBamSummaryBean=new multiBamSummaryBean();
        multiBamSummaryBean.setBam1(remote_bam1);
        multiBamSummaryBean.setBam2(remote_bam2);
        multiBamSummaryBean.setBed(remote_control);
        multiBamSummaryBean.setPath(path);
        multiBamSummaryBean.setMode(multi_mode);
        if(optionalParameters_multi==1){
            multiBamSummaryBean.setOption("");
        }
        else{
            String l,bs,n,r,bl,p,out,e,ignore,minmapping,center,samFlagInclude,samFlagExclude,minFragmentLength,maxFragmentLength;
            l=equal_valid(multi_l,"-l");
            bs=equal_valid(multi_bs,"-bs");
            n=equal_valid(multi_n,"-n");
            r=equal_valid(multi_r,"-r");
            bl=equal_valid(multi_bl,"-bl");
            p=equal_valid(multi_p,"-p");
            out=equal_valid(multi_out," --outRawCounts");
            e=equal_valid(multi_e,"-e");
            if(multi_ignore==1){
                ignore=" --ignoreDuplicates ";
            }
            else{
                ignore="";
            }
            if(multi_minmapping==1){
                minmapping=" --minMappingQuality ";
            }
            else{
                minmapping="";
            }
            if(multi_center==1){
                center=" --centerReads ";
            }
            else{
                center="";
            }
            if(multi_samFlagInclude==1){
                samFlagInclude=" --samFlagInclude ";
            }
            else{
                samFlagInclude="";
            }
            if(multi_samFlagExclude==1){
                samFlagExclude=" --samFlagExclude ";
            }
            else{
                samFlagExclude="";
            }
            if(multi_minFragmentLength==1){
                minFragmentLength=" --minFragmentLength ";
            }
            else{
                minFragmentLength="";
            }
            if(multi_maxFragmentLength==1){
                maxFragmentLength=" --maxFragmentLength ";
            }
            else{
                maxFragmentLength="";
            }
            multiBamSummaryBean.setOption(l+bs+n+r+bl+p+out+e+ignore+minmapping+center+samFlagInclude+samFlagExclude+minFragmentLength+maxFragmentLength);
        }
        multiBamSummaryService.setMultiBamSummaryBean(multiBamSummaryBean);
        stdoutlist=multiBamSummaryService.multiBamSummary();
        flag="8";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
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
    public void validate() {

        if(multi_mode==1){
            if (multi_bins_bamfile1.equals("") || multi_bins_bamfile2.equals("")) {
                this.addFieldError("multi_bins_bamfile1", "Please input bamfile.");
            }
        }
        else{
            if (multi_bed_text.equals("")) {
                this.addFieldError("multi_bed_text", "Please input bamfile.");
            }
        }
<<<<<<< HEAD
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_multiFileName,fileField_multi)){
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
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
       /* xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="8";
        flag_validate="2";
    }
<<<<<<< HEAD
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
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
}
