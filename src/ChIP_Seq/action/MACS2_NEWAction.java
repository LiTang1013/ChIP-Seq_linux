package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.Macs2Bean;
import ChIP_Seq.service.Macs2Service;
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
 * Created by USER on 2017/4/23.
 */
public class MACS2_NEWAction extends ActionSupport{
    private String input_tagfile_macs2;
    private String input_controlfile_macs2;
    private String macs2_g;
    private String macs2_s;
    private String macs2_bw;
    private String macs2_q;
    private String macs2_m;
    private int optionalParameters_macs2;
    private String input_macs_path_macs2;
    private int macs2_format;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_macs2_tag;
    private File fileField_macs2_control;
    private String fileField_macs2_tagFileName;
    private String fileField_macs2_controlFileName;
    private List<File> fileField_macs2;
    private List<String> fileField_macs2FileName;
    private String account_hidden;

    public String getInput_tagfile_macs2() {
        return input_tagfile_macs2;
    }

    public void setInput_tagfile_macs2(String input_tagfile_macs2) {
        this.input_tagfile_macs2 = input_tagfile_macs2;
    }

    public String getInput_controlfile_macs2() {
        return input_controlfile_macs2;
    }

    public void setInput_controlfile_macs2(String input_controlfile_macs2) {
        this.input_controlfile_macs2 = input_controlfile_macs2;
    }

    public String getMacs2_g() {
        return macs2_g;
    }

    public void setMacs2_g(String macs2_g) {
        this.macs2_g = macs2_g;
    }

    public String getMacs2_s() {
        return macs2_s;
    }

    public void setMacs2_s(String macs2_s) {
        this.macs2_s = macs2_s;
    }

    public String getMacs2_bw() {
        return macs2_bw;
    }

    public void setMacs2_bw(String macs2_bw) {
        this.macs2_bw = macs2_bw;
    }

    public String getMacs2_q() {
        return macs2_q;
    }

    public void setMacs2_q(String macs2_q) {
        this.macs2_q = macs2_q;
    }

    public String getMacs2_m() {
        return macs2_m;
    }

    public void setMacs2_m(String macs2_m) {
        this.macs2_m = macs2_m;
    }

    public int getOptionalParameters_macs2() {
        return optionalParameters_macs2;
    }

    public void setOptionalParameters_macs2(int optionalParameters_macs2) {
        this.optionalParameters_macs2 = optionalParameters_macs2;
    }

    public String getInput_macs_path_macs2() {
        return input_macs_path_macs2;
    }

    public void setInput_macs_path_macs2(String input_macs_path_macs2) {
        this.input_macs_path_macs2 = input_macs_path_macs2;
    }

    public int getMacs2_format() {
        return macs2_format;
    }

    public void setMacs2_format(int macs2_format) {
        this.macs2_format = macs2_format;
    }

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

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public File getFileField_macs2_tag() {
        return fileField_macs2_tag;
    }

    public void setFileField_macs2_tag(File fileField_macs2_tag) {
        this.fileField_macs2_tag = fileField_macs2_tag;
    }

    public File getFileField_macs2_control() {
        return fileField_macs2_control;
    }

    public void setFileField_macs2_control(File fileField_macs2_control) {
        this.fileField_macs2_control = fileField_macs2_control;
    }

    public String getFileField_macs2_tagFileName() {
        return fileField_macs2_tagFileName;
    }

    public void setFileField_macs2_tagFileName(String fileField_macs2_tagFileName) {
        this.fileField_macs2_tagFileName = fileField_macs2_tagFileName;
    }

    public String getFileField_macs2_controlFileName() {
        return fileField_macs2_controlFileName;
    }

    public void setFileField_macs2_controlFileName(String fileField_macs2_controlFileName) {
        this.fileField_macs2_controlFileName = fileField_macs2_controlFileName;
    }

    public List<File> getFileField_macs2() {
        return fileField_macs2;
    }

    public void setFileField_macs2(List<File> fileField_macs2) {
        this.fileField_macs2 = fileField_macs2;
    }

    public List<String> getFileField_macs2FileName() {
        return fileField_macs2FileName;
    }

    public void setFileField_macs2FileName(List<String> fileField_macs2FileName) {
        this.fileField_macs2FileName = fileField_macs2FileName;
    }

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public String macs2_peakcalling() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        //////////////////////////////////////////////////////////////////////////
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List <String> Upload_path=uploadUtil.upload(fileField_macs2FileName,fileField_macs2);
        remote_tag=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_macs2.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "MACS2",  "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////////
        Macs2Service macs2Service= (Macs2Service) applicationContext.getBean("macs2Service");
        FileUtil fileUtil1=new FileUtil();
        input_macs_path_macs2=fileUtil1.Result_path();
        appendMethodB(admin_path,input_macs_path_macs2+"\r\n");

        Macs2Bean macs2Bean=new Macs2Bean();
        macs2Bean.setTagfile(remote_tag);
        macs2Bean.setControlfile(remote_control);
        macs2Bean.setPath(input_macs_path_macs2);
        if(macs2_format==1){
            macs2Bean.setFormat("BAM");
        }
        else if(macs2_format==2){
            macs2Bean.setFormat("SAM");
        }
        else if(macs2_format==3){
            macs2Bean.setFormat("BED");
        }
        else if(macs2_format==4){
            macs2Bean.setFormat("ELAND");
        }
        else if(macs2_format==5){
            macs2Bean.setFormat("ELANDMULTI");
        }
        else if(macs2_format==6){
            macs2Bean.setFormat("ELANDEXPORT");
        }
        else if(macs2_format==7){
            macs2Bean.setFormat("BOWTIE");
        }
        else if(macs2_format==8){
            macs2Bean.setFormat("BAMPE");
        }
        else{
            macs2Bean.setFormat("BEDPE");
        }
        if(optionalParameters_macs2==1){
            macs2Bean.setOption("");
        }
        else{
            macs2Bean.setOption("-g "+macs2_g+" "+"-s "+macs2_s+" --bw "+macs2_bw+" -q "+macs2_q+" -m "+macs2_m);
        }
        macs2Service.setMacs2Bean(macs2Bean);
        stdoutlist=macs2Service.Macs2();
        flag="10";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }

    public String MACS2noUpload(){
        Macs2Service macs2Service= (Macs2Service) applicationContext.getBean("macs2Service");
        FileUtil fileUtil=new FileUtil();
        input_macs_path_macs2=fileUtil.Result_path();
        Macs2Bean macs2Bean=new Macs2Bean();
        macs2Bean.setTagfile(input_tagfile_macs2);
        macs2Bean.setControlfile(input_controlfile_macs2);
        macs2Bean.setPath(input_macs_path_macs2);
        if(macs2_format==2){
            macs2Bean.setFormat("SAM");
        }
        else if(macs2_format==3){
            macs2Bean.setFormat("BED");
        }
        else if(macs2_format==4){
            macs2Bean.setFormat("ELAND");
        }
        else if(macs2_format==5){
            macs2Bean.setFormat("ELANDMULTI");
        }
        else if(macs2_format==6){
            macs2Bean.setFormat("ELANDEXPORT");
        }
        else if(macs2_format==7){
            macs2Bean.setFormat("BOWTIE");
        }
        else if(macs2_format==8){
            macs2Bean.setFormat("BAMPE");
        }
        else{
            macs2Bean.setFormat("BEDPE");
        }
        if(optionalParameters_macs2==1){
            macs2Bean.setOption("");
        }
        else{
            macs2Bean.setOption("-g "+macs2_g+" "+"-s "+macs2_s+" --bw "+macs2_bw+" -q "+macs2_q+" -m "+macs2_m);
        }
        macs2Service.setMacs2Bean(macs2Bean);
        stdoutlist=macs2Service.Macs2();
        flag="10";
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

        if(input_tagfile_macs2.equals("")){
            this.addFieldError("input_tagfile_macs2", "Please input the tag file.");
        }
        if(input_controlfile_macs2.equals("")){
            this.addFieldError("input_controlfile_macs2", "Please input the control file.");
        }
<<<<<<< HEAD
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_macs2FileName,fileField_macs2)){
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
        flag="10";
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
