package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.FindPeaksBean;
import ChIP_Seq.service.FindPeaksService;
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
 * Created by lily on 7/19/16.
 */
public class FindPeaksAction extends ActionSupport {
    private int findpeak_format;
    private String input_findpeaks_file;
    private String input_findpeaks_path;
    private String input_findpeaks_gs;
    private int optionalParameters_findpeaks;
    private int findpeak_dir;
    private String findpeak_type;
    private int findpeak_filter;
    private String findpeak_hs;
    private String flag,flag_validate;
    private String stdoutlist;

    private File fileField_find_tag;
    private String fileField_find_tagFileName;
    private List<File> fileField_find;
    private List<String> fileField_findFileName;
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


    public List<File> getFileField_find() {
        return fileField_find;
    }

    public void setFileField_find(List<File> fileField_find) {
        this.fileField_find = fileField_find;
    }

    public List<String> getFileField_findFileName() {
        return fileField_findFileName;
    }

    public void setFileField_findFileName(List<String> fileField_findFileName) {
        this.fileField_findFileName = fileField_findFileName;
    }

    public File getFileField_find_tag() {
        return fileField_find_tag;
    }

    public void setFileField_find_tag(File fileField_find_tag) {
        this.fileField_find_tag = fileField_find_tag;
    }

    public String getFileField_find_tagFileName() {
        return fileField_find_tagFileName;
    }

    public void setFileField_find_tagFileName(String fileField_find_tagFileName) {
        this.fileField_find_tagFileName = fileField_find_tagFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getFindpeak_format() {
        return findpeak_format;
    }

    public void setFindpeak_format(int findpeak_format) {
        this.findpeak_format = findpeak_format;
    }

    public String getInput_findpeaks_file() {
        return input_findpeaks_file;
    }

    public void setInput_findpeaks_file(String input_findpeaks_file) {
        this.input_findpeaks_file = input_findpeaks_file;
    }

    public String getInput_findpeaks_path() {
        return input_findpeaks_path;
    }

    public void setInput_findpeaks_path(String input_findpeaks_path) {
        this.input_findpeaks_path = input_findpeaks_path;
    }

    public String getInput_findpeaks_gs() {
        return input_findpeaks_gs;
    }

    public void setInput_findpeaks_gs(String input_findpeaks_gs) {
        this.input_findpeaks_gs = input_findpeaks_gs;
    }

    public int getOptionalParameters_findpeaks() {
        return optionalParameters_findpeaks;
    }

    public void setOptionalParameters_findpeaks(int optionalParameters_findpeaks) {
        this.optionalParameters_findpeaks = optionalParameters_findpeaks;
    }

    public int getFindpeak_dir() {
        return findpeak_dir;
    }

    public void setFindpeak_dir(int findpeak_dir) {
        this.findpeak_dir = findpeak_dir;
    }

    public String getFindpeak_type() {
        return findpeak_type;
    }

    public void setFindpeak_type(String findpeak_type) {
        this.findpeak_type = findpeak_type;
    }

    public int getFindpeak_filter() {
        return findpeak_filter;
    }

    public void setFindpeak_filter(int findpeak_filter) {
        this.findpeak_filter = findpeak_filter;
    }

    public String getFindpeak_hs() {
        return findpeak_hs;
    }

    public void setFindpeak_hs(String findpeak_hs) {
        this.findpeak_hs = findpeak_hs;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String FindPeaks_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        /////////////////////////////////////////////////////////////////////
        String remote_tag;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_findFileName,fileField_find);
        remote_tag=Upload_path.get(0);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="" ;
        for(int i=0;i<fileField_find.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "FindPeaks", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////
        FindPeaksService findPeaksService= (FindPeaksService) applicationContext.getBean("findPeaksService");
        FileUtil fileUtil1=new FileUtil();
        input_findpeaks_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_findpeaks_path+"\r\n");
        FindPeaksBean findPeaksBean=new FindPeaksBean();
        findPeaksBean.setFile(remote_tag);
        findPeaksBean.setGenesize(input_findpeaks_gs);
        findPeaksBean.setPath(input_findpeaks_path);
        findPeaksBean.setType(findpeak_format);
        if(optionalParameters_findpeaks==1){
            findPeaksBean.setOption("");
        }
        else{
            String dir,filter;
            if(findpeak_dir==1){
                dir="-dist_type";
            }
            else{
                dir="";
            }
            if(findpeak_filter==1){
                filter="-filter";
            }
            else{
                filter="";
            }
            findPeaksBean.setOption(dir+filter+" -hist_size "+findpeak_hs);
        }
        findPeaksService.setFindPeaksBean(findPeaksBean);
        stdoutlist=findPeaksService.FindPeaks();
        flag="18";
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

        if(input_findpeaks_file.equals("")){
            this.addFieldError("input_findpeaks_file", "Please input ChIP-Seq file.");
        }
        if(input_findpeaks_gs.equals("")){
            this.addFieldError("input_findpeaks_gs", "Please input the genome size.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_findFileName,fileField_find)){
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
        flag="18";
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
