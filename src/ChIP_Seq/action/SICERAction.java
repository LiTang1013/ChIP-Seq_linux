package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.SICERBean;
import ChIP_Seq.service.SICERService;
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

/**
 * Created by lily on 5/3/16.
 */
public class SICERAction extends ActionSupport {
    private String input_sicer_tagfile;
    private String input_sicer_controlfile;
    private String input_sicer_path;
    private String sicer_sp;
    private String sicer_RT;
    private String sicer_ws;
    private String sicer_fs;
    private String sicer_egf;
    private String sicer_gs;
    private String sicer_fdr;
    private int optionalParameters_sicer;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_sicer_tag;
    private File fileField_sicer_control;
    private String fileField_sicer_tagFileName;
    private String fileField_sicer_controlFileName;
    private List<File> fileField_sicer;
    private List<String> fileField_sicerFileName;
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



    public List<File> getFileField_sicer() {
        return fileField_sicer;
    }

    public void setFileField_sicer(List<File> fileField_sicer) {
        this.fileField_sicer = fileField_sicer;
    }

    public List<String> getFileField_sicerFileName() {
        return fileField_sicerFileName;
    }

    public void setFileField_sicerFileName(List<String> fileField_sicerFileName) {
        this.fileField_sicerFileName = fileField_sicerFileName;
    }

    public String getFileField_sicer_controlFileName() {
        return fileField_sicer_controlFileName;
    }

    public void setFileField_sicer_controlFileName(String fileField_sicer_controlFileName) {
        this.fileField_sicer_controlFileName = fileField_sicer_controlFileName;
    }

    public File getFileField_sicer_tag() {
        return fileField_sicer_tag;
    }

    public void setFileField_sicer_tag(File fileField_sicer_tag) {
        this.fileField_sicer_tag = fileField_sicer_tag;
    }

    public File getFileField_sicer_control() {
        return fileField_sicer_control;
    }

    public void setFileField_sicer_control(File fileField_sicer_control) {
        this.fileField_sicer_control = fileField_sicer_control;
    }

    public String getFileField_sicer_tagFileName() {
        return fileField_sicer_tagFileName;
    }

    public void setFileField_sicer_tagFileName(String fileField_sicer_tagFileName) {
        this.fileField_sicer_tagFileName = fileField_sicer_tagFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getOptionalParameters_sicer() {
        return optionalParameters_sicer;
    }

    public void setOptionalParameters_sicer(int optionalParameters_sicer) {
        this.optionalParameters_sicer = optionalParameters_sicer;
    }

    public String getInput_sicer_path() {
        return input_sicer_path;
    }

    public void setInput_sicer_path(String input_sicer_path) {
        this.input_sicer_path = input_sicer_path;
    }

    public String getInput_sicer_tagfile() {
        return input_sicer_tagfile;
    }

    public void setInput_sicer_tagfile(String input_sicer_tagfile) {
        this.input_sicer_tagfile = input_sicer_tagfile;
    }

    public String getInput_sicer_controlfile() {
        return input_sicer_controlfile;
    }

    public void setInput_sicer_controlfile(String input_sicer_controlfile) {
        this.input_sicer_controlfile = input_sicer_controlfile;
    }

    public String getSicer_sp() {
        return sicer_sp;
    }

    public void setSicer_sp(String sicer_sp) {
        this.sicer_sp = sicer_sp;
    }

    public String getSicer_RT() {
        return sicer_RT;
    }

    public void setSicer_RT(String sicer_RT) {
        this.sicer_RT = sicer_RT;
    }

    public String getSicer_ws() {
        return sicer_ws;
    }

    public void setSicer_ws(String sicer_ws) {
        this.sicer_ws = sicer_ws;
    }

    public String getSicer_fs() {
        return sicer_fs;
    }

    public void setSicer_fs(String sicer_fs) {
        this.sicer_fs = sicer_fs;
    }

    public String getSicer_egf() {
        return sicer_egf;
    }

    public void setSicer_egf(String sicer_egf) {
        this.sicer_egf = sicer_egf;
    }

    public String getSicer_gs() {
        return sicer_gs;
    }

    public void setSicer_gs(String sicer_gs) {
        this.sicer_gs = sicer_gs;
    }

    public String getSicer_fdr() {
        return sicer_fdr;
    }

    public void setSicer_fdr(String sicer_fdr) {
        this.sicer_fdr = sicer_fdr;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String PeakCalling() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        //////////////////////////////////////////////////////////////////
        String remote_tag,remote_control;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_sicerFileName,fileField_sicer);
        remote_tag=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_sicer.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "SICER", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ///////////////////////////////////////////////////////////////////
        SICERService sicerService= (SICERService) applicationContext.getBean("sicerService");
        FileUtil fileUtil1=new FileUtil();
        input_sicer_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_sicer_path+"\r\n");
        SICERBean sicerBean=new SICERBean();
        sicerBean.setTagfile(remote_tag);
        sicerBean.setControlfile(remote_control);
        sicerBean.setPath(input_sicer_path);
        sicerBean.setOption(sicer_sp+" "+sicer_RT+" "+sicer_ws+" "+sicer_fs+" "+sicer_egf+" "+sicer_gs+" "+sicer_fdr);
        sicerService.setSicerBean(sicerBean);
        stdoutlist=sicerService.SICER();
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="13";
        flag_validate="1";
        return SUCCESS;
    }
    public String SICERnoUpload(){
        SICERService sicerService= (SICERService) applicationContext.getBean("sicerService");
        FileUtil fileUtil=new FileUtil();
        input_sicer_path=fileUtil.Result_path();
        SICERBean sicerBean=new SICERBean();
        sicerBean.setTagfile(input_sicer_tagfile);
        sicerBean.setControlfile(input_sicer_controlfile);
        sicerBean.setPath(input_sicer_path);
        sicerBean.setOption(sicer_sp+" "+sicer_RT+" "+sicer_ws+" "+sicer_fs+" "+sicer_egf+" "+sicer_gs+" "+sicer_fdr);
        sicerService.setSicerBean(sicerBean);
        stdoutlist=sicerService.SICER();
        flag="13";
        flag_validate="1";
        return SUCCESS;
    }
    public static void appendMethodB(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
        }
    }
    public void validate(){

        if(input_sicer_tagfile.equals("")){
            this.addFieldError("input_sicer_tagfile", "Please input the tag file.");
        }
        if(input_sicer_controlfile.equals("")){
            this.addFieldError("input_sicer_controlfile", "Please input the control file.");
        }
    /*    xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="13";
        flag_validate="2";
    }
}
