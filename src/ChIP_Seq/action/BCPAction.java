package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.BCPBean;
import ChIP_Seq.service.BCPService;
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
 * Created by lily on 7/12/16.
 */
public class BCPAction extends ActionSupport {
    private int BCP_type;
    private String input_BCP_tagfile;
    private String input_BCP_controlfile;
    private String input_BCP_path;
    private int optionalParameters_BCP;
    private String BCP_f;
    private String BCP_W;
    private String BCP_p;
    private String BCP_e;
    private String BCP_p2;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;
    private File fileField_bcp_tag;
    private String fileField_bcp_tagFileName;
    private String fileField_bcp_tagContentType;

    private File fileField_bcp_control;
    private String fileField_bcp_controlFileName;
    private String fileField_bcp_controlContentType;

    private List<File> fileField_bcp;
    private List<String> fileField_bcpFileName;

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

    public List<File> getFileField_bcp() {
        return fileField_bcp;
    }

    public void setFileField_bcp(List<File> fileField_bcp) {
        this.fileField_bcp = fileField_bcp;
    }

    public List<String> getFileField_bcpFileName() {
        return fileField_bcpFileName;
    }

    public void setFileField_bcpFileName(List<String> fileField_bcpFileName) {
        this.fileField_bcpFileName = fileField_bcpFileName;
    }

    public File getFileField_bcp_tag() {
        return fileField_bcp_tag;
    }

    public void setFileField_bcp_tag(File fileField_bcp_tag) {
        this.fileField_bcp_tag = fileField_bcp_tag;
    }

    public String getFileField_bcp_tagFileName() {
        return fileField_bcp_tagFileName;
    }

    public void setFileField_bcp_tagFileName(String fileField_bcp_tagFileName) {
        this.fileField_bcp_tagFileName = fileField_bcp_tagFileName;
    }

    public String getFileField_bcp_tagContentType() {
        return fileField_bcp_tagContentType;
    }

    public void setFileField_bcp_tagContentType(String fileField_bcp_tagContentType) {
        this.fileField_bcp_tagContentType = fileField_bcp_tagContentType;
    }

    public File getFileField_bcp_control() {
        return fileField_bcp_control;
    }

    public void setFileField_bcp_control(File fileField_bcp_control) {
        this.fileField_bcp_control = fileField_bcp_control;
    }

    public String getFileField_bcp_controlFileName() {
        return fileField_bcp_controlFileName;
    }

    public void setFileField_bcp_controlFileName(String fileField_bcp_controlFileName) {
        this.fileField_bcp_controlFileName = fileField_bcp_controlFileName;
    }

    public String getFileField_bcp_controlContentType() {
        return fileField_bcp_controlContentType;
    }

    public void setFileField_bcp_controlContentType(String fileField_bcp_controlContentType) {
        this.fileField_bcp_controlContentType = fileField_bcp_controlContentType;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getBCP_type() {
        return BCP_type;
    }

    public void setBCP_type(int BCP_type) {
        this.BCP_type = BCP_type;
    }

    public String getInput_BCP_tagfile() {
        return input_BCP_tagfile;
    }

    public void setInput_BCP_tagfile(String input_BCP_tagfile) {
        this.input_BCP_tagfile = input_BCP_tagfile;
    }

    public String getInput_BCP_controlfile() {
        return input_BCP_controlfile;
    }

    public void setInput_BCP_controlfile(String input_BCP_controlfile) {
        this.input_BCP_controlfile = input_BCP_controlfile;
    }

    public String getInput_BCP_path() {
        return input_BCP_path;
    }

    public void setInput_BCP_path(String input_BCP_path) {
        this.input_BCP_path = input_BCP_path;
    }

    public int getOptionalParameters_BCP() {
        return optionalParameters_BCP;
    }

    public void setOptionalParameters_BCP(int optionalParameters_BCP) {
        this.optionalParameters_BCP = optionalParameters_BCP;
    }

    public String getBCP_f() {
        return BCP_f;
    }

    public void setBCP_f(String BCP_f) {
        this.BCP_f = BCP_f;
    }

    public String getBCP_W() {
        return BCP_W;
    }

    public void setBCP_W(String BCP_W) {
        this.BCP_W = BCP_W;
    }

    public String getBCP_p() {
        return BCP_p;
    }

    public void setBCP_p(String BCP_p) {
        this.BCP_p = BCP_p;
    }

    public String getBCP_e() {
        return BCP_e;
    }

    public void setBCP_e(String BCP_e) {
        this.BCP_e = BCP_e;
    }

    public String getBCP_p2() {
        return BCP_p2;
    }

    public void setBCP_p2(String BCP_p2) {
        this.BCP_p2 = BCP_p2;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String BCP_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        /////////////////////////////////////////////////////////////////////////////
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_bcpFileName,fileField_bcp);
        remote_tag=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_bcp.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "BCP", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////////////
        BCPService bcpService= (BCPService) applicationContext.getBean("bcpService");
        FileUtil fileUtil1=new FileUtil();
        input_BCP_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_BCP_path+"\r\n");
        BCPBean bcpBean=new BCPBean();
        bcpBean.setTagfile(remote_tag);
        bcpBean.setControlfile(remote_control);
        bcpBean.setPath(input_BCP_path);
        bcpBean.setType(BCP_type);
        if(optionalParameters_BCP==1){
            bcpBean.setOption("");
        }
        else{
            if(BCP_type==1){
                bcpBean.setOption(" -f "+BCP_f+" -w "+BCP_W+" -p "+BCP_p);
            }
            else{
                bcpBean.setOption(" -e "+BCP_e+" -p "+BCP_p2);
            }
        }
        bcpService.setBcpBean(bcpBean);
        stdoutlist=bcpService.BCP();
        flag="15";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String BCPnoUpload(){
        BCPService bcpService= (BCPService) applicationContext.getBean("bcpService");
        FileUtil fileUtil=new FileUtil();
        input_BCP_path=fileUtil.Result_path();
        BCPBean bcpBean=new BCPBean();
        bcpBean.setTagfile(input_BCP_tagfile);
        bcpBean.setControlfile(input_BCP_controlfile);
        bcpBean.setPath(input_BCP_path);
        bcpBean.setType(BCP_type);
        if(optionalParameters_BCP==1){
            bcpBean.setOption("");
        }
        else{
            if(BCP_type==1){
                bcpBean.setOption(" -f "+BCP_f+" -w "+BCP_W+" -p "+BCP_p);
            }
            else{
                bcpBean.setOption(" -e "+BCP_e+" -p "+BCP_p2);
            }
        }
        bcpService.setBcpBean(bcpBean);
        stdoutlist=bcpService.BCP();
        flag="15";
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

        if(BCP_type!=1&&BCP_type!=2){
            this.addFieldError("BCP_type", "Please choose the type.");
        }
        if(input_BCP_tagfile.equals("")){
            this.addFieldError("input_BCP_tagfile", "Please input the tag file.");
        }
        if(input_BCP_controlfile.equals("")){
            this.addFieldError("input_BCP_controlfile", "Please input the control file.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_bcpFileName,fileField_bcp)){
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
      /*  xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="15";
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
