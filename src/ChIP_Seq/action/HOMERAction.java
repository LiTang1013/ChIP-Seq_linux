package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.HOMERBean;
import ChIP_Seq.service.HOMERService;
import ChIP_Seq.xmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lily on 10/28/16.
 */
public class HOMERAction extends ActionSupport {
    private String input_HOMER_peak;
    private int HOMER_select;
    private int HOMER_genome;
    private String input_HOMER_fasta;
    private String input_HOMER_size;
    private String input_HOMER_path;
    private int HOMER_option,HOMER_mask;
    private String HOMER_bg,HOMER_len,HOMER_S,HOMER_mis;
    private String flag,flag_validate,flag_son;
    private String stdoutlist;
    private String account_hidden;

    private File fileField_HOMER_peak;
    private String fileField_HOMER_peakFileName;
    private String fileField_HOMER_peakContentType;

    private File fileField_HOMER_fasta;
    private String fileField_HOMER_fastaFileName;
    private String fileField_HOMER_fastaContentType;

    private List<File> fileField_HOMER;
    private List<String> fileField_HOMERFileName;
    private String peak_remote;
    private String refer_remote;

    public String getFlag_son() {
        return flag_son;
    }

    public void setFlag_son(String flag_son) {
        this.flag_son = flag_son;
    }

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }

    public List<File> getFileField_HOMER() {
        return fileField_HOMER;
    }

    public void setFileField_HOMER(List<File> fileField_HOMER) {
        this.fileField_HOMER = fileField_HOMER;
    }

    public List<String> getFileField_HOMERFileName() {
        return fileField_HOMERFileName;
    }

    public void setFileField_HOMERFileName(List<String> fileField_HOMERFileName) {
        this.fileField_HOMERFileName = fileField_HOMERFileName;
    }

    public String getFileField_HOMER_fastaFileName() {
        return fileField_HOMER_fastaFileName;
    }

    public void setFileField_HOMER_fastaFileName(String fileField_HOMER_fastaFileName) {
        this.fileField_HOMER_fastaFileName = fileField_HOMER_fastaFileName;
    }

    public String getFileField_HOMER_fastaContentType() {
        return fileField_HOMER_fastaContentType;
    }

    public void setFileField_HOMER_fastaContentType(String fileField_HOMER_fastaContentType) {
        this.fileField_HOMER_fastaContentType = fileField_HOMER_fastaContentType;
    }

    public String getPeak_remote() {
        return peak_remote;
    }

    public void setPeak_remote(String peak_remote) {
        this.peak_remote = peak_remote;
    }

    public String getRefer_remote() {
        return refer_remote;
    }

    public void setRefer_remote(String refer_remote) {
        this.refer_remote = refer_remote;
    }

    public File getFileField_HOMER_peak() {
        return fileField_HOMER_peak;
    }

    public void setFileField_HOMER_peak(File fileField_HOMER_peak) {
        this.fileField_HOMER_peak = fileField_HOMER_peak;
    }

    public String getFileField_HOMER_peakFileName() {
        return fileField_HOMER_peakFileName;
    }

    public void setFileField_HOMER_peakFileName(String fileField_HOMER_peakFileName) {
        this.fileField_HOMER_peakFileName = fileField_HOMER_peakFileName;
    }

    public String getFileField_HOMER_peakContentType() {
        return fileField_HOMER_peakContentType;
    }

    public void setFileField_HOMER_peakContentType(String fileField_HOMER_peakContentType) {
        this.fileField_HOMER_peakContentType = fileField_HOMER_peakContentType;
    }

    public File getFileField_HOMER_fasta() {
        return fileField_HOMER_fasta;
    }

    public void setFileField_HOMER_fasta(File fileField_HOMER_fasta) {
        this.fileField_HOMER_fasta = fileField_HOMER_fasta;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_HOMER_peak() {
        return input_HOMER_peak;
    }

    public void setInput_HOMER_peak(String input_HOMER_peak) {
        this.input_HOMER_peak = input_HOMER_peak;
    }

    public int getHOMER_select() {
        return HOMER_select;
    }

    public void setHOMER_select(int HOMER_select) {
        this.HOMER_select = HOMER_select;
    }

    public int getHOMER_genome() {
        return HOMER_genome;
    }

    public void setHOMER_genome(int HOMER_genome) {
        this.HOMER_genome = HOMER_genome;
    }

    public String getInput_HOMER_fasta() {
        return input_HOMER_fasta;
    }

    public void setInput_HOMER_fasta(String input_HOMER_fasta) {
        this.input_HOMER_fasta = input_HOMER_fasta;
    }

    public String getInput_HOMER_size() {
        return input_HOMER_size;
    }

    public void setInput_HOMER_size(String input_HOMER_size) {
        this.input_HOMER_size = input_HOMER_size;
    }

    public String getInput_HOMER_path() {
        return input_HOMER_path;
    }

    public void setInput_HOMER_path(String input_HOMER_path) {
        this.input_HOMER_path = input_HOMER_path;
    }

    public int getHOMER_option() {
        return HOMER_option;
    }

    public void setHOMER_option(int HOMER_option) {
        this.HOMER_option = HOMER_option;
    }

    public int getHOMER_mask() {
        return HOMER_mask;
    }

    public void setHOMER_mask(int HOMER_mask) {
        this.HOMER_mask = HOMER_mask;
    }

    public String getHOMER_bg() {
        return HOMER_bg;
    }

    public void setHOMER_bg(String HOMER_bg) {
        this.HOMER_bg = HOMER_bg;
    }

    public String getHOMER_len() {
        return HOMER_len;
    }

    public void setHOMER_len(String HOMER_len) {
        this.HOMER_len = HOMER_len;
    }

    public String getHOMER_S() {
        return HOMER_S;
    }

    public void setHOMER_S(String HOMER_S) {
        this.HOMER_S = HOMER_S;
    }

    public String getHOMER_mis() {
        return HOMER_mis;
    }

    public void setHOMER_mis(String HOMER_mis) {
        this.HOMER_mis = HOMER_mis;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String HOMER_exe_upload() throws Exception{
        if(input_HOMER_peak.equals("H3K4me3.bed") && HOMER_genome==1 && input_HOMER_size.equals("400")){
            HOMER_DemoAction homer_demoAction=new HOMER_DemoAction();
            homer_demoAction.Demo();

            flag="1";
            flag_son="1";
            flag_validate="1";
        }
        else {
            //生成运行起始时间
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time=format.format(date);
            //构建session
            xmlUtil xmlUtil = new xmlUtil();
            String JobId="JobId_"+xmlUtil.generateString(6);
            xmlUtil.creatSession(JobId,time);
            ////////////////////////////////upload////////////////////////////////////////////////;
            String peak_remote, refer_remote;
            UploadUtil uploadUtil = new UploadUtil();
            List<String> Upload_path = uploadUtil.upload(fileField_HOMERFileName, fileField_HOMER);
            peak_remote = Upload_path.get(0);
            if (HOMER_select == 2) {
                refer_remote = Upload_path.get(1);
            } else {
                refer_remote = "";
            }
            //////////////////////////////////////////////////////////////////////////////////////
            FileUtil fileUtil = new FileUtil();
            String admin_path = fileUtil.adminCheck_path() + ".txt";
            File admin = new File(admin_path);
            appendMethodB(admin_path, "File list:" + "\r\n");
            String fileList = "";
            for (int i = 0; i < fileField_HOMER.size(); i++) {
                appendMethodB(admin_path, Upload_path.get(i) + "\r\n");
                File file = new File(Upload_path.get(i));
                String name = file.getName();
                fileList += name + " ; ";
            }

            xmlUtil.xmlAdd_Jobs(JobId,fileList, "HOMER", stdoutlist,"email",time);
            appendMethodB(admin_path, "Result path:" + "\r\n");
            /////////////////////////////////////////////////////////////////////////////////////////
            HOMERService homerService = (HOMERService) applicationContext.getBean("homerService");
            FileUtil fileUtil1 = new FileUtil();
            input_HOMER_path = fileUtil1.Result_path();
            appendMethodB(admin_path, input_HOMER_path + "\r\n");
            HOMERBean homerBean = new HOMERBean();
            homerBean.setPeak(peak_remote);
            if (HOMER_select == 1) {
                if (HOMER_genome == 1) {
                    homerBean.setGenome("hg19");
                }
                else if(HOMER_genome==2){
                    homerBean.setGenome("mm8");
                }
                else{
                    homerBean.setGenome("sacCer3");
                }
            } else {
                homerBean.setGenome(refer_remote);
            }
            homerBean.setSize(input_HOMER_size);
            homerBean.setPath(input_HOMER_path);
            if (HOMER_option == 1) {
                homerBean.setOption("");
            } else {
                homerBean.setOption(" -bg " + HOMER_bg + " -len " + HOMER_len + " -S " + HOMER_S + " -mis " + HOMER_mis);
            }
            homerService.setHomerBean(homerBean);
            stdoutlist = homerService.HOMER();

            //将结果压缩
            FileUtil fileUtil2=new FileUtil();
            fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
            flag="1";
            flag_son="1";
            flag_validate="1";

        }
        return SUCCESS;
    }

    public String HOMER_anno() throws Exception {
        HOMERService homerService= (HOMERService) applicationContext.getBean("homerService");
        HOMERBean homerBean=new HOMERBean();
        homerBean.setPeak(input_HOMER_peak);
            if(HOMER_genome==1){
                homerBean.setGenome("hg19");
            }
            else if(HOMER_genome==2){
                homerBean.setGenome("mm8");
            }
            else{
                homerBean.setGenome("sacCer3");
            }
        homerBean.setPath(input_HOMER_path);
        homerService.setHomerBean(homerBean);
        stdoutlist=homerService.HOMER_anno();
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

        if(input_HOMER_peak.equals("")){
            this.addFieldError("input_HOMER_peak", "Please input peak file.");
        }
        if(HOMER_select==2){
            if(input_HOMER_fasta.equals("")) {
                this.addFieldError("HOMER_select", "Please input fasta file.");
            }
        }
        if(input_HOMER_size.equals("")){
            this.addFieldError("input_HOMER_size", "Please input fasta file.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_HOMERFileName,fileField_HOMER)){
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
        flag="1";
        flag_son="1";
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
