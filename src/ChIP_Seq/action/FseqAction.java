package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.FseqBean;
import ChIP_Seq.service.FseqService;
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
 * Created by lily on 7/27/16.
 */
public class FseqAction extends ActionSupport {
    private String input_Fseq_file,input_Fseq_control,input_Fseq_path;
    private int optionalParameters_Fseq,Fseq_v;
    private String Fseq_l,Fseq_s,Fseq_t;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_fseq_tag;
    private File fileField_fseq_control;
    private String fileField_fseq_tagFileName;
    private String fileField_fseq_controlFileName;
    private List<File> fileField_fseq;
    private List<String> fileField_fseqFileName;
    private String account_hidden;

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


    public List<String> getFileField_fseqFileName() {
        return fileField_fseqFileName;
    }

    public void setFileField_fseqFileName(List<String> fileField_fseqFileName) {
        this.fileField_fseqFileName = fileField_fseqFileName;
    }

    public List<File> getFileField_fseq() {
        return fileField_fseq;
    }

    public void setFileField_fseq(List<File> fileField_fseq) {
        this.fileField_fseq = fileField_fseq;
    }

    public String getFileField_fseq_controlFileName() {
        return fileField_fseq_controlFileName;
    }

    public void setFileField_fseq_controlFileName(String fileField_fseq_controlFileName) {
        this.fileField_fseq_controlFileName = fileField_fseq_controlFileName;
    }

    public String getFileField_fseq_tagFileName() {
        return fileField_fseq_tagFileName;
    }

    public void setFileField_fseq_tagFileName(String fileField_fseq_tagFileName) {
        this.fileField_fseq_tagFileName = fileField_fseq_tagFileName;
    }

    public File getFileField_fseq_tag() {
        return fileField_fseq_tag;
    }

    public void setFileField_fseq_tag(File fileField_fseq_tag) {
        this.fileField_fseq_tag = fileField_fseq_tag;
    }

    public File getFileField_fseq_control() {
        return fileField_fseq_control;
    }

    public void setFileField_fseq_control(File fileField_fseq_control) {
        this.fileField_fseq_control = fileField_fseq_control;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_Fseq_file() {
        return input_Fseq_file;
    }

    public void setInput_Fseq_file(String input_Fseq_file) {
        this.input_Fseq_file = input_Fseq_file;
    }

    public String getInput_Fseq_control() {
        return input_Fseq_control;
    }

    public void setInput_Fseq_control(String input_Fseq_control) {
        this.input_Fseq_control = input_Fseq_control;
    }

    public String getInput_Fseq_path() {
        return input_Fseq_path;
    }

    public void setInput_Fseq_path(String input_Fseq_path) {
        this.input_Fseq_path = input_Fseq_path;
    }

    public int getOptionalParameters_Fseq() {
        return optionalParameters_Fseq;
    }

    public void setOptionalParameters_Fseq(int optionalParameters_Fseq) {
        this.optionalParameters_Fseq = optionalParameters_Fseq;
    }

    public int getFseq_v() {
        return Fseq_v;
    }

    public void setFseq_v(int fseq_v) {
        Fseq_v = fseq_v;
    }

    public String getFseq_l() {
        return Fseq_l;
    }

    public void setFseq_l(String fseq_l) {
        Fseq_l = fseq_l;
    }

    public String getFseq_s() {
        return Fseq_s;
    }

    public void setFseq_s(String fseq_s) {
        Fseq_s = fseq_s;
    }

    public String getFseq_t() {
        return Fseq_t;
    }

    public void setFseq_t(String fseq_t) {
        Fseq_t = fseq_t;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String Fseq_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ///////////////////////////////////////////////////////////////////
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_fseqFileName,fileField_fseq);
        remote_tag=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_fseq.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Fseq", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ///////////////////////////////////////////////////////////////////
        FseqService fseqService= (FseqService) applicationContext.getBean("fseqService");
        FileUtil fileUtil1=new FileUtil();
        input_Fseq_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_Fseq_path+"\r\n");
        FseqBean fseqBean=new FseqBean();
        fseqBean.setTagfile(remote_tag);
        fseqBean.setControlfile(remote_control);
        fseqBean.setPath(input_Fseq_path);
        if(optionalParameters_Fseq==1){
            fseqBean.setOption("");
        }
        else{
            String v;
            if(Fseq_v==1){
                v=" -v ";
            }
            else{
                v="";
            }
            fseqBean.setOption(" -l "+Fseq_l+" -s "+Fseq_s+" -t "+Fseq_t+v);
        }
        fseqService.setFseqBean(fseqBean);
        stdoutlist=fseqService.Fseq();
        flag="20";
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
    public void validate(){

        if(input_Fseq_file.equals("")){
            this.addFieldError("input_Fseq_file", "Please input the ChIP-Seq file.");
        }
        if(input_Fseq_control.equals("")){
            this.addFieldError("input_Fseq_control", "Please input the control file.");
        }
      /*  xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="20";
        flag_validate="2";
    }
}
