package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.SISSRBean;
import ChIP_Seq.service.SISSRService;
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
import java.util.Map;
import java.util.Set;

/**
 * Created by lily on 7/18/16.
 */
public class SISSRAction extends ActionSupport {
    private String input_SISSR_tagfile;
    private String input_SISSR_controlfile;
    private String input_SISSR_size;
    private String input_SISSR_path;
    private int optionalParameters_SISSR;
    private String SISSR_D;
    private String SISSR_e;
    private String SISSR_p;
    private String SISSR_m;
    private String SISSR_w;
    private String SISSR_E;
    private String SISSR_L;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_sissr_tag;
    private File fileField_sissr_control;
    private String fileField_sissr_tagFileName;
    private String fileField_sissr_controlFileName;
    private List<File> fileField_sissr;
    private List<String> fileField_sissrFileName;
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


    public List<File> getFileField_sissr() {
        return fileField_sissr;
    }

    public void setFileField_sissr(List<File> fileField_sissr) {
        this.fileField_sissr = fileField_sissr;
    }

    public List<String> getFileField_sissrFileName() {
        return fileField_sissrFileName;
    }

    public void setFileField_sissrFileName(List<String> fileField_sissrFileName) {
        this.fileField_sissrFileName = fileField_sissrFileName;
    }

    public File getFileField_sissr_tag() {
        return fileField_sissr_tag;
    }

    public void setFileField_sissr_tag(File fileField_sissr_tag) {
        this.fileField_sissr_tag = fileField_sissr_tag;
    }

    public File getFileField_sissr_control() {
        return fileField_sissr_control;
    }

    public void setFileField_sissr_control(File fileField_sissr_control) {
        this.fileField_sissr_control = fileField_sissr_control;
    }

    public String getFileField_sissr_tagFileName() {
        return fileField_sissr_tagFileName;
    }

    public void setFileField_sissr_tagFileName(String fileField_sissr_tagFileName) {
        this.fileField_sissr_tagFileName = fileField_sissr_tagFileName;
    }

    public String getFileField_sissr_controlFileName() {
        return fileField_sissr_controlFileName;
    }

    public void setFileField_sissr_controlFileName(String fileField_sissr_controlFileName) {
        this.fileField_sissr_controlFileName = fileField_sissr_controlFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_SISSR_tagfile() {
        return input_SISSR_tagfile;
    }

    public void setInput_SISSR_tagfile(String input_SISSR_tagfile) {
        this.input_SISSR_tagfile = input_SISSR_tagfile;
    }

    public String getInput_SISSR_controlfile() {
        return input_SISSR_controlfile;
    }

    public void setInput_SISSR_controlfile(String input_SISSR_controlfile) {
        this.input_SISSR_controlfile = input_SISSR_controlfile;
    }

    public String getInput_SISSR_size() {
        return input_SISSR_size;
    }

    public void setInput_SISSR_size(String input_SISSR_size) {
        this.input_SISSR_size = input_SISSR_size;
    }

    public String getInput_SISSR_path() {
        return input_SISSR_path;
    }

    public void setInput_SISSR_path(String input_SISSR_path) {
        this.input_SISSR_path = input_SISSR_path;
    }

    public int getOptionalParameters_SISSR() {
        return optionalParameters_SISSR;
    }

    public void setOptionalParameters_SISSR(int optionalParameters_SISSR) {
        this.optionalParameters_SISSR = optionalParameters_SISSR;
    }

    public String getSISSR_D() {
        return SISSR_D;
    }

    public void setSISSR_D(String SISSR_D) {
        this.SISSR_D = SISSR_D;
    }

    public String getSISSR_e() {
        return SISSR_e;
    }

    public void setSISSR_e(String SISSR_e) {
        this.SISSR_e = SISSR_e;
    }

    public String getSISSR_p() {
        return SISSR_p;
    }

    public void setSISSR_p(String SISSR_p) {
        this.SISSR_p = SISSR_p;
    }

    public String getSISSR_m() {
        return SISSR_m;
    }

    public void setSISSR_m(String SISSR_m) {
        this.SISSR_m = SISSR_m;
    }

    public String getSISSR_w() {
        return SISSR_w;
    }

    public void setSISSR_w(String SISSR_w) {
        this.SISSR_w = SISSR_w;
    }

    public String getSISSR_E() {
        return SISSR_E;
    }

    public void setSISSR_E(String SISSR_E) {
        this.SISSR_E = SISSR_E;
    }

    public String getSISSR_L() {
        return SISSR_L;
    }

    public void setSISSR_L(String SISSR_L) {
        this.SISSR_L = SISSR_L;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String SISSR_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ////////////////////////////////////////////////////////////////////
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_sissrFileName,fileField_sissr);
        remote_tag=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_sissr.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "SISSR", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ////////////////////////////////////////////////////////////////////
        SISSRService sissrService= (SISSRService) applicationContext.getBean("sissrService");
        FileUtil fileUtil1=new FileUtil();
        input_SISSR_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_SISSR_path+"\r\n");

        SISSRBean sissrBean=new SISSRBean();
        sissrBean.setTagfile(remote_tag);
        sissrBean.setControlfile(remote_control);
        sissrBean.setPath(input_SISSR_path);
        sissrBean.setSize(input_SISSR_size);
        if(optionalParameters_SISSR==1){
            sissrBean.setOption("");
        }
        else{
            sissrBean.setOption(" -D "+SISSR_D+" -e "+SISSR_e+" -p "+SISSR_p+" -m "+SISSR_m+" -w "+SISSR_w+" -E "+SISSR_E+" -L "+SISSR_L);
        }
        sissrService.setSissrBean(sissrBean);
        stdoutlist=sissrService.SISSR();
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="17";
        flag_validate="1";
        return SUCCESS;
    }
    public String SISSRnoUpload(){
        SISSRService sissrService= (SISSRService) applicationContext.getBean("sissrService");
        FileUtil fileUtil=new FileUtil();
        input_SISSR_path=fileUtil.Result_path();
        SISSRBean sissrBean=new SISSRBean();
        sissrBean.setTagfile(input_SISSR_tagfile);
        sissrBean.setControlfile(input_SISSR_controlfile);
        sissrBean.setPath(input_SISSR_path);
        sissrBean.setSize(input_SISSR_size);
        if(optionalParameters_SISSR==1){
            sissrBean.setOption("");
        }
        else{
            sissrBean.setOption(" -D "+SISSR_D+" -e "+SISSR_e+" -p "+SISSR_p+" -m "+SISSR_m+" -w "+SISSR_w+" -E "+SISSR_E+" -L "+SISSR_L);
        }
        sissrService.setSissrBean(sissrBean);
        stdoutlist=sissrService.SISSR();
        flag="17";
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

        if(input_SISSR_tagfile.equals("")){
            this.addFieldError("input_SISSR_tagfile", "Please input the tag file.");
        }
        if(input_SISSR_controlfile.equals("")){
            this.addFieldError("input_SISSR_controlfile", "Please input the control file.");
        }
        if(input_SISSR_size.equals("")){
            this.addFieldError("input_SISSR_size", "Please input the size of genome.");
        }
        try{
            UploadUtil uploadUtil=new UploadUtil();
            if(!uploadUtil.Check(fileField_sissrFileName,fileField_sissr)){
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
     /*   xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="17";
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
