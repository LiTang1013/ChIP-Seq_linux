package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.SamToolsBean;
import ChIP_Seq.service.SamToolsService;
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
 * Created by Administrator on 2016/4/10 0010.
 */
public class SamToolsAction extends ActionSupport{
    private int samtools_convert_type;
    private String samtobam_origin;
    private String samtobam_result;
    private String input_samtools_sort;
    private int samtools_index_radio;
    private String input_samtools_index;
    private String flag,flag_validate;
    private String input_samtools_indexpath;
    private String stdoutlist;
    private List<File> fileField_samtools_origin;
    private List<File> fileField_samtools_sort;
    private List<File> fileField_samtools_index;
    private List<String> fileField_samtools_originFileName;
    private List<String> fileField_samtools_sortFileName;
    private List<String> fileField_samtools_indexFileName;
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

    public List<File> getFileField_samtools_origin() {
        return fileField_samtools_origin;
    }

    public void setFileField_samtools_origin(List<File> fileField_samtools_origin) {
        this.fileField_samtools_origin = fileField_samtools_origin;
    }

    public List<File> getFileField_samtools_sort() {
        return fileField_samtools_sort;
    }

    public void setFileField_samtools_sort(List<File> fileField_samtools_sort) {
        this.fileField_samtools_sort = fileField_samtools_sort;
    }

    public List<File> getFileField_samtools_index() {
        return fileField_samtools_index;
    }

    public void setFileField_samtools_index(List<File> fileField_samtools_index) {
        this.fileField_samtools_index = fileField_samtools_index;
    }

    public List<String> getFileField_samtools_originFileName() {
        return fileField_samtools_originFileName;
    }

    public void setFileField_samtools_originFileName(List<String> fileField_samtools_originFileName) {
        this.fileField_samtools_originFileName = fileField_samtools_originFileName;
    }

    public List<String> getFileField_samtools_sortFileName() {
        return fileField_samtools_sortFileName;
    }

    public void setFileField_samtools_sortFileName(List<String> fileField_samtools_sortFileName) {
        this.fileField_samtools_sortFileName = fileField_samtools_sortFileName;
    }

    public List<String> getFileField_samtools_indexFileName() {
        return fileField_samtools_indexFileName;
    }

    public void setFileField_samtools_indexFileName(List<String> fileField_samtools_indexFileName) {
        this.fileField_samtools_indexFileName = fileField_samtools_indexFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getSamtools_convert_type() {
        return samtools_convert_type;
    }

    public void setSamtools_convert_type(int samtools_convert_type) {
        this.samtools_convert_type = samtools_convert_type;
    }

    public String getSamtobam_origin() {
        return samtobam_origin;
    }

    public void setSamtobam_origin(String samtobam_origin) {
        this.samtobam_origin = samtobam_origin;
    }

    public String getSamtobam_result() {
        return samtobam_result;
    }

    public void setSamtobam_result(String samtobam_result) {
        this.samtobam_result = samtobam_result;
    }

    public String getInput_samtools_sort() {
        return input_samtools_sort;
    }

    public void setInput_samtools_sort(String input_samtools_sort) {
        this.input_samtools_sort = input_samtools_sort;
    }

    public int getSamtools_index_radio() {
        return samtools_index_radio;
    }

    public void setSamtools_index_radio(int samtools_index_radio) {
        this.samtools_index_radio = samtools_index_radio;
    }

    public String getInput_samtools_index() {
        return input_samtools_index;
    }

    public void setInput_samtools_index(String input_samtools_index) {
        this.input_samtools_index = input_samtools_index;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getInput_samtools_indexpath() {
        return input_samtools_indexpath;
    }

    public void setInput_samtools_indexpath(String input_samtools_indexpath) {
        this.input_samtools_indexpath = input_samtools_indexpath;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public String SamToBam() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ////////////////////////////////////////////////////////////////////////////
        String remote_origin;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_samtools_originFileName,fileField_samtools_origin);
        remote_origin= Upload_path.get(0);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_samtools_origin.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Samtools", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ////////////////////////////////////////////////////////////////////////////
        SamToolsService samToolsService= (SamToolsService) applicationContext.getBean("samToolsService");
        SamToolsBean samToolsBean=new SamToolsBean();
        FileUtil fileUtil1=new FileUtil();
        samtobam_result=fileUtil1.Result_path();
        appendMethodB(admin_path,samtobam_result+"\r\n");
        if(samtools_convert_type==1){
            samToolsBean.setInput_sam(remote_origin);
            samToolsBean.setInput_bam(samtobam_result);
        }
        else{
            samToolsBean.setInput_sam(samtobam_result);
            samToolsBean.setInput_bam(remote_origin);
        }
        samToolsBean.setType(samtools_convert_type);
        samToolsService.setSamToolsBean(samToolsBean);
        stdoutlist=samToolsService.SamTools();
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="22";
        flag_validate="1";
        return SUCCESS;
    }
    public String Sort() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ///////////////////////////////////////////////////////////////////////
        String remote_sort;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path= uploadUtil.upload(fileField_samtools_sortFileName,fileField_samtools_sort);
        remote_sort=Upload_path.get(0);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_samtools_sort.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Samtools", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ///////////////////////////////////////////////////////////////////////
        SamToolsService samToolsService= (SamToolsService) applicationContext.getBean("samToolsService");
        FileUtil fileUtil1=new FileUtil();
        input_samtools_indexpath=fileUtil1.Result_path();
        appendMethodB(admin_path,input_samtools_indexpath+"\r\n");

        SamToolsBean samToolsBean=new SamToolsBean();
        samToolsBean.setInput_samtools_sort(remote_sort);
        samToolsService.setSamToolsBean(samToolsBean);
        samToolsBean.setInput_samtools_indexpath(input_samtools_indexpath);
        samToolsService.SamTools_sort();
        stdoutlist=samToolsService.SamTools_sort();
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="22";
        flag_validate="1";
        return SUCCESS;
    }
    public String Index() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        /////////////////////////////////////////////////////////////////
        String remote_index;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_samtools_indexFileName,fileField_samtools_index);
        remote_index=Upload_path.get(0);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_samtools_index.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Samtools", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        //////////////////////////////////////////////////////////////////
        SamToolsService samToolsService= (SamToolsService) applicationContext.getBean("samToolsService");
        FileUtil fileUtil1=new FileUtil();
        input_samtools_indexpath=fileUtil1.Result_path();
        appendMethodB(admin_path,input_samtools_indexpath+"\r\n");
        SamToolsBean samToolsBean=new SamToolsBean();
        samToolsBean.setInput_samtools_index(remote_index);
        samToolsBean.setIndex_type(samtools_index_radio);
        samToolsBean.setInput_samtools_indexpath(input_samtools_indexpath);
        samToolsService.setSamToolsBean(samToolsBean);
        stdoutlist=samToolsService.SamTools_index();
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="22";
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

        if(samtools_convert_type!=1&&samtools_convert_type!=2){
            this.addFieldError("samtools_convert_type", "Please choose the type to convert.");
        }
        if(samtobam_origin.equals("")){
            this.addFieldError("samtobam_origin", "Please input the file to be converted.");
        }
        try{
            UploadUtil uploadUtil=new UploadUtil();
            if(!uploadUtil.Check(fileField_samtools_originFileName,fileField_samtools_origin)){
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
        flag="22";
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
