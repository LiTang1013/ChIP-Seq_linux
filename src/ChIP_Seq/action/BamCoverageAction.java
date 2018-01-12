package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.BamCoverageBean;
import ChIP_Seq.service.BamCoverageService;
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
 * Created by lily on 11/27/16.
 */
public class BamCoverageAction extends ActionSupport {
    private int convert_sam;
    private int convert_for;
    private String convert_file;
    private String convert_result;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;

    private List<File> fileField_samtools_convert;
    private List<String> fileField_samtools_convertFileName;
    private List<String> fileField_samtools_convertContentType;

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

    public List<File> getFileField_samtools_convert() {
        return fileField_samtools_convert;
    }

    public void setFileField_samtools_convert(List<File> fileField_samtools_convert) {
        this.fileField_samtools_convert = fileField_samtools_convert;
    }

    public List<String> getFileField_samtools_convertFileName() {
        return fileField_samtools_convertFileName;
    }

    public void setFileField_samtools_convertFileName(List<String> fileField_samtools_convertFileName) {
        this.fileField_samtools_convertFileName = fileField_samtools_convertFileName;
    }

    public List<String> getFileField_samtools_convertContentType() {
        return fileField_samtools_convertContentType;
    }

    public void setFileField_samtools_convertContentType(List<String> fileField_samtools_convertContentType) {
        this.fileField_samtools_convertContentType = fileField_samtools_convertContentType;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getConvert_sam() {
        return convert_sam;
    }

    public void setConvert_sam(int convert_sam) {
        this.convert_sam = convert_sam;
    }

    public int getConvert_for() {
        return convert_for;
    }

    public void setConvert_for(int convert_for) {
        this.convert_for = convert_for;
    }

    public String getConvert_file() {
        return convert_file;
    }

    public void setConvert_file(String convert_file) {
        this.convert_file = convert_file;
    }

    public String getConvert_result() {
        return convert_result;
    }

    public void setConvert_result(String convert_result) {
        this.convert_result = convert_result;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String bamCoverage() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ////////////////////////////////////////////////////////////////////////
        String remote_convert;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_samtools_convertFileName,fileField_samtools_convert);
        remote_convert=Upload_path.get(0);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_samtools_convert.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "BamCoverage", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ////////////////////////////////////////////////////////////////////////
        BamCoverageService bamCoverageService= (BamCoverageService) applicationContext.getBean("bamCoverageService");
        FileUtil fileUtil1=new FileUtil();
        convert_result=fileUtil1.Result_path();
        appendMethodB(admin_path,convert_result+"\r\n");
        BamCoverageBean bamCoverageBean=new BamCoverageBean();
        bamCoverageBean.setConvert_file(remote_convert);
        bamCoverageBean.setConvert_result(convert_result);
        bamCoverageBean.setConvert_sam(convert_sam);
        bamCoverageBean.setConvert_for(convert_for);
        System.out.println(convert_file);
        bamCoverageService.setBamCoverageBean(bamCoverageBean);
        stdoutlist=bamCoverageService.BamCoverage();
        flag="23";
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

        if(convert_sam!=1&&convert_sam!=2){
            this.addFieldError("convert_sam", "Please choose the format of the file.");
        }
        if(convert_file.equals("")){
            this.addFieldError("convert_file", "Please input the file.");
        }
        if(convert_for!=1&&convert_for!=2){
            this.addFieldError("convert_for", "Please choose the format.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_samtools_convertFileName,fileField_samtools_convert)){
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
        flag="23";
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
