package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.MacsBean;
import ChIP_Seq.service.MacsService;
import ChIP_Seq.xmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily on 11/17/16.
 */
public class BroadPeakAction extends ActionSupport{
    private String input_BroadPeak_file;
    private String input_BroadPeak_control;
    private String input_macs_path;
    private String flag,flag_validate;
    private String stdoutlist;
    private String account_hidden;
    private List<File> fileField_broad;
    private List<String> fileField_broadFileName;

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

    public String getInput_BroadPeak_file() {
        return input_BroadPeak_file;
    }

    public void setInput_BroadPeak_file(String input_BroadPeak_file) {
        this.input_BroadPeak_file = input_BroadPeak_file;
    }

    public String getInput_BroadPeak_control() {
        return input_BroadPeak_control;
    }

    public void setInput_BroadPeak_control(String input_BroadPeak_control) {
        this.input_BroadPeak_control = input_BroadPeak_control;
    }

    public String getInput_macs_path() {
        return input_macs_path;
    }

    public void setInput_macs_path(String input_macs_path) {
        this.input_macs_path = input_macs_path;
    }

    public List<File> getFileField_broad() {
        return fileField_broad;
    }

    public void setFileField_broad(List<File> fileField_broad) {
        this.fileField_broad = fileField_broad;
    }

    public List<String> getFileField_broadFileName() {
        return fileField_broadFileName;
    }

    public void setFileField_broadFileName(List<String> fileField_broadFileName) {
        this.fileField_broadFileName = fileField_broadFileName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String BroadPeak_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        /////////////////////////////////////////////////////////////////////////
        UploadUtil uploadUtil=new UploadUtil();
        String remote_tag,remote_control;
        List<String> Upload_path=uploadUtil.upload(fileField_broadFileName,fileField_broad);
        remote_tag=Upload_path.get(0);
        remote_control= Upload_path.get(1);
        System.out.println(remote_tag);
        System.out.println(remote_control);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_broad.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "BroadPeak", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////////////////
        MacsService macsService= (MacsService) applicationContext.getBean("macsService");
        FileUtil fileUtil1=new FileUtil();
        input_macs_path=fileUtil1.Result_path();
        appendMethodB(admin_path, input_macs_path + "\r\n");
        MacsBean macsBean=new MacsBean();
        macsBean.setInput_tagfile(remote_tag);
        macsBean.setInput_controlfile(remote_control);
        macsBean.setInput_macs_path(input_macs_path);
        macsBean.setOption("");
        macsService.setMacsBean(macsBean);
        stdoutlist=macsService.Macs();
        flag="21";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String MACS_noUpload(){
        MacsService macsService= (MacsService) applicationContext.getBean("macsService");
        MacsBean macsBean=new MacsBean();
        FileUtil fileUtil=new FileUtil();
        input_macs_path=fileUtil.Result_path();
        macsBean.setInput_tagfile(input_BroadPeak_file);
        macsBean.setInput_controlfile(input_BroadPeak_control);
        macsBean.setInput_macs_path(input_macs_path);
        macsBean.setOption("");
        macsService.setMacsBean(macsBean);
        stdoutlist=macsService.Macs();
        flag="21";
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

        if(input_BroadPeak_file.equals("")){
            this.addFieldError("input_tagfile", "Please input tag file.");
        }
        if(input_BroadPeak_control.equals("")){
            this.addFieldError("input_controlfile", "Please input control file.");
        }
     /*   xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="21";
        flag_validate="2";
    }
}
