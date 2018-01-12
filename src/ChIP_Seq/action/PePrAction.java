package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.PePrBean;
import ChIP_Seq.service.PePrService;
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
 * Created by lily on 7/12/16.
 */
public class PePrAction extends ActionSupport {
    private String input_pepr_tagfile1;
    private String input_pepr_tagfile2;
    private String input_pepr_controlfile1;
    private String input_pepr_controlfile2;
    private String input_pepr_path;
    private int optionalParameters_pepr;
    private String pepr_peaktype;
    private String pepr_diff;
    private String pepr_p;
    private String pepr_keep;
    private String pepr_num;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_pepr_tag1;
    private File fileField_pepr_tag2;
    private File fileField_pepr_control1;
    private File fileField_pepr_control2;
    private String fileField_pepr_tag1FileName;
    private String fileField_pepr_tag2FileName;
    private String fileField_pepr_control1FileName;
    private String fileField_pepr_control2FileName;
    private List<File> fileField_pepr;
    private List<String> fileField_peprFileName;
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

    public List<File> getFileField_pepr() {
        return fileField_pepr;
    }

    public void setFileField_pepr(List<File> fileField_pepr) {
        this.fileField_pepr = fileField_pepr;
    }

    public List<String> getFileField_peprFileName() {
        return fileField_peprFileName;
    }

    public void setFileField_peprFileName(List<String> fileField_peprFileName) {
        this.fileField_peprFileName = fileField_peprFileName;
    }

    public File getFileField_pepr_tag1() {
        return fileField_pepr_tag1;
    }

    public void setFileField_pepr_tag1(File fileField_pepr_tag1) {
        this.fileField_pepr_tag1 = fileField_pepr_tag1;
    }

    public File getFileField_pepr_tag2() {
        return fileField_pepr_tag2;
    }

    public void setFileField_pepr_tag2(File fileField_pepr_tag2) {
        this.fileField_pepr_tag2 = fileField_pepr_tag2;
    }

    public File getFileField_pepr_control1() {
        return fileField_pepr_control1;
    }

    public void setFileField_pepr_control1(File fileField_pepr_control1) {
        this.fileField_pepr_control1 = fileField_pepr_control1;
    }

    public File getFileField_pepr_control2() {
        return fileField_pepr_control2;
    }

    public void setFileField_pepr_control2(File fileField_pepr_control2) {
        this.fileField_pepr_control2 = fileField_pepr_control2;
    }

    public String getFileField_pepr_tag1FileName() {
        return fileField_pepr_tag1FileName;
    }

    public void setFileField_pepr_tag1FileName(String fileField_pepr_tag1FileName) {
        this.fileField_pepr_tag1FileName = fileField_pepr_tag1FileName;
    }

    public String getFileField_pepr_tag2FileName() {
        return fileField_pepr_tag2FileName;
    }

    public void setFileField_pepr_tag2FileName(String fileField_pepr_tag2FileName) {
        this.fileField_pepr_tag2FileName = fileField_pepr_tag2FileName;
    }

    public String getFileField_pepr_control1FileName() {
        return fileField_pepr_control1FileName;
    }

    public void setFileField_pepr_control1FileName(String fileField_pepr_control1FileName) {
        this.fileField_pepr_control1FileName = fileField_pepr_control1FileName;
    }

    public String getFileField_pepr_control2FileName() {
        return fileField_pepr_control2FileName;
    }

    public void setFileField_pepr_control2FileName(String fileField_pepr_control2FileName) {
        this.fileField_pepr_control2FileName = fileField_pepr_control2FileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_pepr_tagfile1() {
        return input_pepr_tagfile1;
    }

    public void setInput_pepr_tagfile1(String input_pepr_tagfile1) {
        this.input_pepr_tagfile1 = input_pepr_tagfile1;
    }

    public String getInput_pepr_tagfile2() {
        return input_pepr_tagfile2;
    }

    public void setInput_pepr_tagfile2(String input_pepr_tagfile2) {
        this.input_pepr_tagfile2 = input_pepr_tagfile2;
    }

    public String getInput_pepr_controlfile1() {
        return input_pepr_controlfile1;
    }

    public void setInput_pepr_controlfile1(String input_pepr_controlfile1) {
        this.input_pepr_controlfile1 = input_pepr_controlfile1;
    }

    public String getInput_pepr_controlfile2() {
        return input_pepr_controlfile2;
    }

    public void setInput_pepr_controlfile2(String input_pepr_controlfile2) {
        this.input_pepr_controlfile2 = input_pepr_controlfile2;
    }

    public String getInput_pepr_path() {
        return input_pepr_path;
    }

    public void setInput_pepr_path(String input_pepr_path) {
        this.input_pepr_path = input_pepr_path;
    }

    public int getOptionalParameters_pepr() {
        return optionalParameters_pepr;
    }

    public void setOptionalParameters_pepr(int optionalParameters_pepr) {
        this.optionalParameters_pepr = optionalParameters_pepr;
    }

    public String getPepr_peaktype() {
        return pepr_peaktype;
    }

    public void setPepr_peaktype(String pepr_peaktype) {
        this.pepr_peaktype = pepr_peaktype;
    }

    public String getPepr_diff() {
        return pepr_diff;
    }

    public void setPepr_diff(String pepr_diff) {
        this.pepr_diff = pepr_diff;
    }

    public String getPepr_p() {
        return pepr_p;
    }

    public void setPepr_p(String pepr_p) {
        this.pepr_p = pepr_p;
    }

    public String getPepr_keep() {
        return pepr_keep;
    }

    public void setPepr_keep(String pepr_keep) {
        this.pepr_keep = pepr_keep;
    }

    public String getPepr_num() {
        return pepr_num;
    }

    public void setPepr_num(String pepr_num) {
        this.pepr_num = pepr_num;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String PePr_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        //////////////////////////////////////////////////////////////////////
        String remote_tag1,remote_tag2,remote_control1,remote_control2;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_peprFileName,fileField_pepr);
        remote_tag1=Upload_path.get(0);
        remote_tag2=Upload_path.get(1);
        remote_control1=Upload_path.get(2);
        remote_control2=Upload_path.get(3);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_pepr.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "PePr", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        //////////////////////////////////////////////////////////////////////
        PePrService pePrService= (PePrService) applicationContext.getBean("pePrService");
        FileUtil fileUtil1=new FileUtil();
        input_pepr_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_pepr_path+"\r\n");
        PePrBean pePrBean=new PePrBean();
        pePrBean.setTagfile1(remote_tag1);
        pePrBean.setTagfile2(remote_tag2);
        pePrBean.setControlfile1(remote_control1);
        pePrBean.setControlfile2(remote_control2);
        pePrBean.setPath(input_pepr_path);
        String temp=remote_tag1.substring(remote_tag1.length()-3,remote_tag1.length());
        pePrBean.setFormat(temp);
        if(optionalParameters_pepr==1){
            pePrBean.setOption("");
        }
        else{
            pePrBean.setOption(" --peaktype "+pepr_peaktype+" --threshold "+pepr_p+" --keep-max-dup "+pepr_keep+" --num-processors "+pepr_num);
        }
        pePrService.setPePrBean(pePrBean);
        stdoutlist=pePrService.PePr();
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="14";
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

        if(input_pepr_tagfile1.equals("")){
            this.addFieldError("input_pepr_tagfile1", "Please input your tag file.");
        }
        if(input_pepr_tagfile2.equals("")){
            this.addFieldError("input_pepr_tagfile2", "Please input your tag file.");
        }
        if(input_pepr_controlfile1.equals("")){
            this.addFieldError("input_pepr_controlfile1", "Please input your control file.");
        }
        if(input_pepr_controlfile2.equals("")){
            this.addFieldError("input_pepr_controlfile2", "Please input your control file.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_peprFileName,fileField_pepr)){
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
        flag="14";
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
