package ChIP_Seq.action;


import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.PeakSeqBean;
import ChIP_Seq.service.PeakSeqService;
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
 * Created by Administrator on 2016/5/7 0007.
 */
public class PeakSeqAction extends ActionSupport {
    private int peakseq_format;
    private String input_tagfile_peakseq;
    private String input_controlfile_peakseq;
    private int optionalParameters_peakseq;
    private String peakseq_length,peakseq_fdr,peakseq_N,peakseq_Min,peakseq_seed,peakseq_qvalue;
    private String input_path_peakseq;
    private int peakseq_mode;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_peakseq_tag;
    private File fileField_peakseq_control;
    private String fileField_peakseq_tagFileName;
    private String fileField_peakseq_controlFileName;
    private List<File> fileField_peakseq;
    private List<String> fileField_peakseqFileName;
    private String account_hidden;

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }

    public List<String> getFileField_peakseqFileName() {
        return fileField_peakseqFileName;
    }

    public void setFileField_peakseqFileName(List<String> fileField_peakseqFileName) {
        this.fileField_peakseqFileName = fileField_peakseqFileName;
    }

    public List<File> getFileField_peakseq() {
        return fileField_peakseq;
    }

    public void setFileField_peakseq(List<File> fileField_peakseq) {
        this.fileField_peakseq = fileField_peakseq;
    }

    public File getFileField_peakseq_tag() {
        return fileField_peakseq_tag;
    }

    public void setFileField_peakseq_tag(File fileField_peakseq_tag) {
        this.fileField_peakseq_tag = fileField_peakseq_tag;
    }

    public File getFileField_peakseq_control() {
        return fileField_peakseq_control;
    }

    public void setFileField_peakseq_control(File fileField_peakseq_control) {
        this.fileField_peakseq_control = fileField_peakseq_control;
    }

    public String getFileField_peakseq_tagFileName() {
        return fileField_peakseq_tagFileName;
    }

    public void setFileField_peakseq_tagFileName(String fileField_peakseq_tagFileName) {
        this.fileField_peakseq_tagFileName = fileField_peakseq_tagFileName;
    }

    public String getFileField_peakseq_controlFileName() {
        return fileField_peakseq_controlFileName;
    }

    public void setFileField_peakseq_controlFileName(String fileField_peakseq_controlFileName) {
        this.fileField_peakseq_controlFileName = fileField_peakseq_controlFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getPeakseq_format() {
        return peakseq_format;
    }

    public void setPeakseq_format(int peakseq_format) {
        this.peakseq_format = peakseq_format;
    }

    public String getInput_tagfile_peakseq() {
        return input_tagfile_peakseq;
    }

    public void setInput_tagfile_peakseq(String input_tagfile_peakseq) {
        this.input_tagfile_peakseq = input_tagfile_peakseq;
    }

    public String getInput_controlfile_peakseq() {
        return input_controlfile_peakseq;
    }

    public void setInput_controlfile_peakseq(String input_controlfile_peakseq) {
        this.input_controlfile_peakseq = input_controlfile_peakseq;
    }

    public int getOptionalParameters_peakseq() {
        return optionalParameters_peakseq;
    }

    public void setOptionalParameters_peakseq(int optionalParameters_peakseq) {
        this.optionalParameters_peakseq = optionalParameters_peakseq;
    }

    public String getPeakseq_length() {
        return peakseq_length;
    }

    public void setPeakseq_length(String peakseq_length) {
        this.peakseq_length = peakseq_length;
    }

    public String getPeakseq_fdr() {
        return peakseq_fdr;
    }

    public void setPeakseq_fdr(String peakseq_fdr) {
        this.peakseq_fdr = peakseq_fdr;
    }

    public String getPeakseq_N() {
        return peakseq_N;
    }

    public void setPeakseq_N(String peakseq_N) {
        this.peakseq_N = peakseq_N;
    }

    public String getPeakseq_Min() {
        return peakseq_Min;
    }

    public void setPeakseq_Min(String peakseq_Min) {
        this.peakseq_Min = peakseq_Min;
    }

    public String getPeakseq_seed() {
        return peakseq_seed;
    }

    public void setPeakseq_seed(String peakseq_seed) {
        this.peakseq_seed = peakseq_seed;
    }

    public String getPeakseq_qvalue() {
        return peakseq_qvalue;
    }

    public void setPeakseq_qvalue(String peakseq_qvalue) {
        this.peakseq_qvalue = peakseq_qvalue;
    }

    public String getInput_path_peakseq() {
        return input_path_peakseq;
    }

    public void setInput_path_peakseq(String input_path_peakseq) {
        this.input_path_peakseq = input_path_peakseq;
    }


    public int getPeakseq_mode() {
        return peakseq_mode;
    }

    public void setPeakseq_mode(int peakseq_mode) {
        this.peakseq_mode = peakseq_mode;
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

    public String peakseq_exe() throws Exception{
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
        List<String> Upload_path=uploadUtil.upload(fileField_peakseqFileName,fileField_peakseq);
        remote_tag=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_peakseq.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "PaekSeq",  "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        //////////////////////////////////////////////////////////////////
        PeakSeqService peakSeqService= (PeakSeqService) applicationContext.getBean("peakSeqService");
        FileUtil fileUtil1=new FileUtil();
        input_path_peakseq=fileUtil1.Result_path();
        appendMethodB(admin_path,input_path_peakseq+"\r\n");
        PeakSeqBean peakSeqBean=new PeakSeqBean();
        peakSeqBean.setTagfile(remote_tag);
        peakSeqBean.setControlfile(remote_control);
        peakSeqBean.setFormat(peakseq_format);
        System.out.println(peakseq_format);
        peakSeqBean.setPaht(input_path_peakseq);
        File name=new File(remote_tag);
        String name_tag=name.getName().substring(0,name.getName().length()-4);
        peakSeqBean.setOutput_name(name_tag);
        File config=new File(peakSeqBean.getPaht());
        if(!config.exists()){config.mkdirs();}
        String fileName=peakSeqBean.getOutput_name()+"_config.dat";
        File file = new File(config,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        appendMethodB(config+"/"+fileName, "Experiment_id "+peakSeqBean.getPaht()+"/"+name_tag+"\n");
        appendMethodB(config+"/"+fileName, "Enrichment_fragment_length "+peakseq_length+"\n" );
        appendMethodB(config+"/"+fileName, "target_FDR "+peakseq_fdr+"\n" );
        appendMethodB(config+"/"+fileName, "Enrichment_mapped_fragment_length 200\n" );
        appendMethodB(config+"/"+fileName, "Minimum_interpeak_distance "+peakseq_Min+"\n" );
        appendMethodB(config+"/"+fileName, "Mappability_map_file Mapability_HG.txt \n" );
        appendMethodB(config+"/"+fileName, "ChIP_Seq_reads_data_dirs "+peakSeqBean.getPaht() +"/"+ peakSeqBean.getOutput_name()+"_Pol1_Input"+"\n" );
        appendMethodB(config+"/"+fileName, "Input_reads_data_dirs "+peakSeqBean.getPaht()+"/"+ peakSeqBean.getOutput_name()+"_Pol1_Input"+"\n" );
        appendMethodB(config+"/"+fileName, "max_Qvalue "+peakseq_qvalue+"\n" );
        appendMethodB(config+"/"+fileName, "N_Simulations "+peakseq_N+"\n" );
        if(peakseq_mode==1){
            appendMethodB(config+"/"+fileName, "Background_model Poisson"+"\n" );
        }
        else{
            appendMethodB(config+"/"+fileName, "Background_model Simulated"+"\n" );
        }
        peakSeqService.setPeakSeqBean(peakSeqBean);
        stdoutlist=peakSeqService.PeakSeq();
        flag="11";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String PeakseqnoUpload(){
        PeakSeqService peakSeqService= (PeakSeqService) applicationContext.getBean("peakSeqService");
        PeakSeqBean peakSeqBean=new PeakSeqBean();
        FileUtil fileUtil=new FileUtil();
        input_path_peakseq=fileUtil.Result_path();
        peakSeqBean.setTagfile(input_tagfile_peakseq);
        peakSeqBean.setControlfile(input_controlfile_peakseq);
        peakSeqBean.setFormat(peakseq_format);
        System.out.println(peakseq_format);
        peakSeqBean.setPaht(input_path_peakseq);
        File name=new File(input_tagfile_peakseq);
        String name_tag=name.getName().substring(0,name.getName().length()-4);
        peakSeqBean.setOutput_name(name_tag);
        File config=new File(peakSeqBean.getPaht());
        if(!config.exists()){config.mkdirs();}
        String fileName=peakSeqBean.getOutput_name()+"_config.dat";
        File file = new File(config,fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        appendMethodB(config+"/"+fileName, "Experiment_id "+peakSeqBean.getPaht()+"/"+name_tag+"\n");
        appendMethodB(config+"/"+fileName, "Enrichment_fragment_length "+peakseq_length+"\n" );
        appendMethodB(config+"/"+fileName, "target_FDR "+peakseq_fdr+"\n" );
        appendMethodB(config+"/"+fileName, "Enrichment_mapped_fragment_length 200\n" );
        appendMethodB(config+"/"+fileName, "Minimum_interpeak_distance "+peakseq_Min+"\n" );
        appendMethodB(config+"/"+fileName, "Mappability_map_file Mapability_HG.txt \n" );
        appendMethodB(config+"/"+fileName, "ChIP_Seq_reads_data_dirs "+peakSeqBean.getPaht() +"/"+ peakSeqBean.getOutput_name()+"_Pol1_Input"+"\n" );
        appendMethodB(config+"/"+fileName, "Input_reads_data_dirs "+peakSeqBean.getPaht()+"/"+ peakSeqBean.getOutput_name()+"_Pol1_Input"+"\n" );
        appendMethodB(config+"/"+fileName, "max_Qvalue "+peakseq_qvalue+"\n" );
        appendMethodB(config+"/"+fileName, "N_Simulations "+peakseq_N+"\n" );
        if(peakseq_mode==1){
            appendMethodB(config+"/"+fileName, "Background_model Poisson"+"\n" );
        }
        else{
            appendMethodB(config+"/"+fileName, "Background_model Simulated"+"\n" );
        }
        peakSeqService.setPeakSeqBean(peakSeqBean);
        stdoutlist=peakSeqService.PeakSeq();
        flag="11";
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

        if (input_tagfile_peakseq.equals("")) {
            this.addFieldError("input_tagfile_peakseq", "Please input tag file.");
        }
        if (input_controlfile_peakseq.equals("")) {
            this.addFieldError("input_controlfile_peakseq", "Please input control file.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_peakseqFileName,fileField_peakseq)){
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
        flag = "11";
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
