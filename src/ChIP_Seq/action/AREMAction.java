package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.AREMBean;
import ChIP_Seq.service.AREMService;
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
public class AREMAction extends ActionSupport {
    private String input_AREM_file,input_AREM_control,input_AREM_path;
    private int optionalParameters_AREM;
    private String AREM_g,AREM_s,AREM_bw,AREM_p,AREM_m,AREM_slocal,AREM_shift,AREM_verbose,AREM_femin,AREM_EM_cd,AREM_EM_min,AREM_ps;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;

    private File fileField_arem_tag;
    private String fileField_arem_tagFileName;
    private String fileField_arem_tagContentType;

    private File fileField_arem_control;
    private String fileField_arem_controlFileName;
    private String fileField_arem_controlContentType;
    private List<File> fileField_arem;
    private List<String> fileField_aremFileName;

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

    public List<File> getFileField_arem() {
        return fileField_arem;
    }

    public void setFileField_arem(List<File> fileField_arem) {
        this.fileField_arem = fileField_arem;
    }

    public List<String> getFileField_aremFileName() {
        return fileField_aremFileName;
    }

    public void setFileField_aremFileName(List<String> fileField_aremFileName) {
        this.fileField_aremFileName = fileField_aremFileName;
    }

    public File getFileField_arem_tag() {
        return fileField_arem_tag;
    }

    public void setFileField_arem_tag(File fileField_arem_tag) {
        this.fileField_arem_tag = fileField_arem_tag;
    }

    public String getFileField_arem_tagFileName() {
        return fileField_arem_tagFileName;
    }

    public void setFileField_arem_tagFileName(String fileField_arem_tagFileName) {
        this.fileField_arem_tagFileName = fileField_arem_tagFileName;
    }

    public String getFileField_arem_tagContentType() {
        return fileField_arem_tagContentType;
    }

    public void setFileField_arem_tagContentType(String fileField_arem_tagContentType) {
        this.fileField_arem_tagContentType = fileField_arem_tagContentType;
    }

    public File getFileField_arem_control() {
        return fileField_arem_control;
    }

    public void setFileField_arem_control(File fileField_arem_control) {
        this.fileField_arem_control = fileField_arem_control;
    }

    public String getFileField_arem_controlFileName() {
        return fileField_arem_controlFileName;
    }

    public void setFileField_arem_controlFileName(String fileField_arem_controlFileName) {
        this.fileField_arem_controlFileName = fileField_arem_controlFileName;
    }

    public String getFileField_arem_controlContentType() {
        return fileField_arem_controlContentType;
    }

    public void setFileField_arem_controlContentType(String fileField_arem_controlContentType) {
        this.fileField_arem_controlContentType = fileField_arem_controlContentType;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }



    public String getInput_AREM_file() {
        return input_AREM_file;
    }

    public void setInput_AREM_file(String input_AREM_file) {
        this.input_AREM_file = input_AREM_file;
    }

    public String getInput_AREM_control() {
        return input_AREM_control;
    }

    public void setInput_AREM_control(String input_AREM_control) {
        this.input_AREM_control = input_AREM_control;
    }

    public String getInput_AREM_path() {
        return input_AREM_path;
    }

    public void setInput_AREM_path(String input_AREM_path) {
        this.input_AREM_path = input_AREM_path;
    }

    public int getOptionalParameters_AREM() {
        return optionalParameters_AREM;
    }

    public void setOptionalParameters_AREM(int optionalParameters_AREM) {
        this.optionalParameters_AREM = optionalParameters_AREM;
    }

    public String getAREM_g() {
        return AREM_g;
    }

    public void setAREM_g(String AREM_g) {
        this.AREM_g = AREM_g;
    }

    public String getAREM_s() {
        return AREM_s;
    }

    public void setAREM_s(String AREM_s) {
        this.AREM_s = AREM_s;
    }

    public String getAREM_bw() {
        return AREM_bw;
    }

    public void setAREM_bw(String AREM_bw) {
        this.AREM_bw = AREM_bw;
    }

    public String getAREM_p() {
        return AREM_p;
    }

    public void setAREM_p(String AREM_p) {
        this.AREM_p = AREM_p;
    }

    public String getAREM_m() {
        return AREM_m;
    }

    public void setAREM_m(String AREM_m) {
        this.AREM_m = AREM_m;
    }

    public String getAREM_slocal() {
        return AREM_slocal;
    }

    public void setAREM_slocal(String AREM_slocal) {
        this.AREM_slocal = AREM_slocal;
    }

    public String getAREM_shift() {
        return AREM_shift;
    }

    public void setAREM_shift(String AREM_shift) {
        this.AREM_shift = AREM_shift;
    }

    public String getAREM_verbose() {
        return AREM_verbose;
    }

    public void setAREM_verbose(String AREM_verbose) {
        this.AREM_verbose = AREM_verbose;
    }

    public String getAREM_femin() {
        return AREM_femin;
    }

    public void setAREM_femin(String AREM_femin) {
        this.AREM_femin = AREM_femin;
    }

    public String getAREM_EM_cd() {
        return AREM_EM_cd;
    }

    public void setAREM_EM_cd(String AREM_EM_cd) {
        this.AREM_EM_cd = AREM_EM_cd;
    }

    public String getAREM_EM_min() {
        return AREM_EM_min;
    }

    public void setAREM_EM_min(String AREM_EM_min) {
        this.AREM_EM_min = AREM_EM_min;
    }

    public String getAREM_ps() {
        return AREM_ps;
    }

    public void setAREM_ps(String AREM_ps) {
        this.AREM_ps = AREM_ps;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String AREM_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ///upload
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_aremFileName,fileField_arem);
        remote_tag=Upload_path.get(0);
        remote_control= Upload_path.get(1);
        //构造运行记录文件
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_arem.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "AREM", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ////////////////////////////////////////////////////////////////////////////////////
        AREMService aremService= (AREMService) applicationContext.getBean("aremService");
        FileUtil fileUtil1=new FileUtil();
        input_AREM_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_AREM_path+"\r\n");
        AREMBean aremBean=new AREMBean();
        aremBean.setTagfile(remote_tag);
        aremBean.setControlfile(remote_control);
        aremBean.setPath(input_AREM_path);
        if(optionalParameters_AREM==1){
            aremBean.setOption("");
        }
        else{
            aremBean.setOption(" -g "+AREM_g+" -s "+AREM_s+" --bw="+AREM_bw+" -p "+AREM_p+" -m "+AREM_m+" --slocal="+AREM_slocal+" --shiftsize="+AREM_shift+" --verbose="+AREM_verbose+" --fe-min="+AREM_femin+" --EM-converge-diff="+AREM_EM_cd+" --EM-min-score="+AREM_EM_min+" --prior-snp="+AREM_ps);
        }
        aremService.setAremBean(aremBean);
        stdoutlist=aremService.AREM();

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="19";
        flag_validate="1";
        return SUCCESS;
    }
    public String AREMnoUpload(){
        AREMService aremService= (AREMService) applicationContext.getBean("aremService");
        AREMBean aremBean=new AREMBean();
        FileUtil fileUtil=new FileUtil();
        input_AREM_path=fileUtil.Result_path();
        aremBean.setTagfile(input_AREM_file);
        aremBean.setControlfile(input_AREM_control);
        aremBean.setPath(input_AREM_path);
        if(optionalParameters_AREM==1){
            aremBean.setOption("");
        }
        else{
            aremBean.setOption(" -g "+AREM_g+" -s "+AREM_s+" --bw="+AREM_bw+" -p "+AREM_p+" -m "+AREM_m+" --slocal="+AREM_slocal+" --shiftsize="+AREM_shift+" --verbose="+AREM_verbose+" --fe-min="+AREM_femin+" --EM-converge-diff="+AREM_EM_cd+" --EM-min-score="+AREM_EM_min+" --prior-snp="+AREM_ps);
        }
        aremService.setAremBean(aremBean);
        stdoutlist=aremService.AREM();
        flag="19";
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
    public void validate() {
        if(input_AREM_file.equals("")){
            this.addFieldError("input_AREM_file", "Please input ChIP-Seq file.");
        }
        if(input_AREM_control.equals("")){
            this.addFieldError("input_AREM_control", "Please input control file.");
        }
      /*  xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="19";
        flag_validate="2";
    }
}
