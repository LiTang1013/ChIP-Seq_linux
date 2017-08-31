package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.IGVBean;
import ChIP_Seq.service.IGVService;
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

/**
 * Created by lily on 6/9/16.
 */
public class IGVAction extends ActionSupport{

    private String sampath;
    private String mapping_visual_scope;
    private String workflowCustom_reference;
    private String workflowCustom_path;

    private String bampath_treatment;
    private String bampath_control;
    private String peakpath;

    private String peakcalling_visual_scope;
    private String flag,flag_mapping,flag_validate,flag_validate_input1,flag_validate_input2;

    private int mapping_type;
    private String mapping_sam,mapping_reference,mapping_path,mapping_scope;

    private int peakcalling_type;
    private String peakcalling_treatment,peakcalling_control,peakcalling_peak,peakcalling_refer,peakcalling_result,peakcalling_scope;

    private String stdoutlist;
    private List<File> fileField_mapping;
    private List<String> fileField_mappingFileName;
    private List<File>fileField_peak;
    private List<String>fileField_peakFileName;
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

    public String getFlag_validate_input1() {
        return flag_validate_input1;
    }

    public void setFlag_validate_input1(String flag_validate_input1) {
        this.flag_validate_input1 = flag_validate_input1;
    }

    public String getFlag_validate_input2() {
        return flag_validate_input2;
    }

    public void setFlag_validate_input2(String flag_validate_input2) {
        this.flag_validate_input2 = flag_validate_input2;
    }

    public List<File> getFileField_peak() {
        return fileField_peak;
    }


    public void setFileField_peak(List<File> fileField_peak) {
        this.fileField_peak = fileField_peak;
    }

    public List<String> getFileField_peakFileName() {
        return fileField_peakFileName;
    }

    public void setFileField_peakFileName(List<String> fileField_peakFileName) {
        this.fileField_peakFileName = fileField_peakFileName;
    }

    public List<File> getFileField_mapping() {
        return fileField_mapping;
    }


    public void setFileField_mapping(List<File> fileField_mapping) {
        this.fileField_mapping = fileField_mapping;
    }

    public List<String> getFileField_mappingFileName() {
        return fileField_mappingFileName;
    }

    public void setFileField_mappingFileName(List<String> fileField_mappingFileName) {
        this.fileField_mappingFileName = fileField_mappingFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getSampath() {
        return sampath;
    }

    public void setSampath(String sampath) {
        this.sampath = sampath;
    }

    public String getMapping_visual_scope() {
        return mapping_visual_scope;
    }

    public void setMapping_visual_scope(String mapping_visual_scope) {
        this.mapping_visual_scope = mapping_visual_scope;
    }

    public String getWorkflowCustom_reference() {
        return workflowCustom_reference;
    }

    public void setWorkflowCustom_reference(String workflowCustom_reference) {
        this.workflowCustom_reference = workflowCustom_reference;
    }

    public String getWorkflowCustom_path() {
        return workflowCustom_path;
    }

    public void setWorkflowCustom_path(String workflowCustom_path) {
        this.workflowCustom_path = workflowCustom_path;
    }

    public String getBampath_treatment() {
        return bampath_treatment;
    }

    public void setBampath_treatment(String bampath_treatment) {
        this.bampath_treatment = bampath_treatment;
    }

    public String getBampath_control() {
        return bampath_control;
    }

    public void setBampath_control(String bampath_control) {
        this.bampath_control = bampath_control;
    }

    public String getPeakpath() {
        return peakpath;
    }

    public void setPeakpath(String peakpath) {
        this.peakpath = peakpath;
    }

    public String getPeakcalling_scope() {
        return peakcalling_scope;
    }

    public void setPeakcalling_scope(String peakcalling_scope) {
        this.peakcalling_scope = peakcalling_scope;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag_mapping() {
        return flag_mapping;
    }

    public void setFlag_mapping(String flag_mapping) {
        this.flag_mapping = flag_mapping;
    }

    public String getPeakcalling_visual_scope() {
        return peakcalling_visual_scope;
    }

    public void setPeakcalling_visual_scope(String peakcalling_visual_scope) {
        this.peakcalling_visual_scope = peakcalling_visual_scope;
    }

    public int getMapping_type() {
        return mapping_type;
    }

    public void setMapping_type(int mapping_type) {
        this.mapping_type = mapping_type;
    }

    public String getMapping_sam() {
        return mapping_sam;
    }

    public void setMapping_sam(String mapping_sam) {
        this.mapping_sam = mapping_sam;
    }

    public String getMapping_reference() {
        return mapping_reference;
    }

    public void setMapping_reference(String mapping_reference) {
        this.mapping_reference = mapping_reference;
    }

    public String getMapping_path() {
        return mapping_path;
    }

    public void setMapping_path(String mapping_path) {
        this.mapping_path = mapping_path;
    }

    public String getMapping_scope() {
        return mapping_scope;
    }

    public void setMapping_scope(String mapping_scope) {
        this.mapping_scope = mapping_scope;
    }

    public int getPeakcalling_type() {
        return peakcalling_type;
    }

    public void setPeakcalling_type(int peakcalling_type) {
        this.peakcalling_type = peakcalling_type;
    }

    public String getPeakcalling_treatment() {
        return peakcalling_treatment;
    }

    public void setPeakcalling_treatment(String peakcalling_treatment) {
        this.peakcalling_treatment = peakcalling_treatment;
    }

    public String getPeakcalling_control() {
        return peakcalling_control;
    }

    public void setPeakcalling_control(String peakcalling_control) {
        this.peakcalling_control = peakcalling_control;
    }

    public String getPeakcalling_peak() {
        return peakcalling_peak;
    }

    public void setPeakcalling_peak(String peakcalling_peak) {
        this.peakcalling_peak = peakcalling_peak;
    }

    public String getPeakcalling_refer() {
        return peakcalling_refer;
    }

    public void setPeakcalling_refer(String peakcalling_refer) {
        this.peakcalling_refer = peakcalling_refer;
    }

    public String getPeakcalling_result() {
        return peakcalling_result;
    }

    public void setPeakcalling_result(String peakcalling_result) {
        this.peakcalling_result = peakcalling_result;
    }


    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public String visual_exe_noupload() throws Exception{
        String s[]=read(workflowCustom_path+"/workflow_input_temp.txt");
        bampath_treatment=s[0];
        bampath_control=s[1];
        peakpath=s[2];
        flag="2";
        flag_mapping="1";
        IGVService igvService=(IGVService)applicationContext.getBean("igvService");
        IGVBean igvBean=new IGVBean();
        if(mapping_type==1){                                                                //不需要上传，不需要构建Samtools，传区间参数
            igvBean.setPath(workflowCustom_path);
            igvBean.setTreatment(sampath);
            igvBean.setReference(workflowCustom_reference);
            igvBean.setScope(mapping_visual_scope);
            igvService.setIgvBean(igvBean);
            igvService.IGV_mapping_unSamtools();
            return SUCCESS;
        }
        else{
                //上传，构建samtools
            //生成运行起始时间
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time=format.format(date);
            //构建session
            xmlUtil xmlUtil = new xmlUtil();
            String JobId="JobId_"+xmlUtil.generateString(6);
            xmlUtil.creatSession(JobId,time);
            ///////////////////////////////upload///////////////////////////////////////////////////
            UploadUtil uploadUtil=new UploadUtil();
            String remote_sam,remote_reference;
            List<String> Upload_path=uploadUtil.upload(fileField_mappingFileName,fileField_mapping);
            remote_sam=Upload_path.get(0);
            remote_reference=Upload_path.get(1);
            /////////////////////////////temp file/////////////////////////////////////////////////////
            FileUtil fileUtil=new FileUtil();
            String admin_path= fileUtil.adminCheck_path()+".txt";
            File admin=new File(admin_path);
            String fileList="";
            appendMethodB(admin_path,"File list:"+"\r\n");
            for(int i=0;i<fileField_mapping.size();i++){
                appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
                File file=new File(Upload_path.get(i));
                String name=file.getName();
                fileList+=name+" ; ";
            }

            xmlUtil.xmlAdd_Jobs(JobId,fileList, "IGV",  "ERROR","email",time);
            appendMethodB(admin_path,"Result path:"+"\r\n");
            ///////////////////////////////////////////////////////////////////////////////////////////////
            FileUtil fileUtil1=new FileUtil();
            workflowCustom_path=fileUtil1.Result_path();
            appendMethodB(admin_path,workflowCustom_path+"\r\n");

            igvBean.setScope(mapping_scope);
            igvBean.setTreatment(remote_sam);
            igvBean.setReference(remote_reference);
            igvBean.setPath(workflowCustom_path);
            igvService.setIgvBean(igvBean);
            igvService.IGV_mapping_visual();

            //将结果压缩
            FileUtil fileUtil2=new FileUtil();
            fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
            return SUCCESS;
        }

    }
//第一次可视化，需要构建samtools文件
    public String visual_exe() throws Exception{
        String s[]=read(workflowCustom_path+"/workflow_input_temp.txt");                //传到peakcalling前台显示
        bampath_treatment=s[0];
        bampath_control=s[1];
        peakpath=s[2];
        IGVService igvService=(IGVService)applicationContext.getBean("igvService");
        IGVBean igvBean=new IGVBean();
        if(mapping_type==1){
            igvBean.setPath(workflowCustom_path);
            igvBean.setTreatment(sampath);
            igvBean.setReference(workflowCustom_reference);
            igvBean.setScope(mapping_visual_scope);
            igvService.setIgvBean(igvBean);
            igvService.IGV_mapping_visual();
        }
        else{
            //生成运行起始时间
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time=format.format(date);
            //构建session
            xmlUtil xmlUtil = new xmlUtil();
            String JobId="JobId_"+xmlUtil.generateString(6);
            xmlUtil.creatSession(JobId,time);
            ///////////////////////////////upload///////////////////////////////////////////////////
            UploadUtil uploadUtil=new UploadUtil();
            String remote_sam,remote_reference;
            List<String> Upload_path=uploadUtil.upload(fileField_mappingFileName,fileField_mapping);
            remote_sam=Upload_path.get(0);
            remote_reference=Upload_path.get(1);
            /////////////////////////////temp file/////////////////////////////////////////////////////
            FileUtil fileUtil=new FileUtil();
            String admin_path= fileUtil.adminCheck_path()+".txt";
            File admin=new File(admin_path);
            String fileList="";
            appendMethodB(admin_path,"File list:"+"\r\n");
            for(int i=0;i<fileField_mapping.size();i++){
                appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
                File file=new File(Upload_path.get(i));
                String name=file.getName();
                fileList+=name+" ; ";
            }
            xmlUtil.xmlAdd_Jobs(JobId,fileList, "IGV",  "ERROR","email",time);
            appendMethodB(admin_path,"Result path:"+"\r\n");
            ///////////////////////////////////////////////////////////////////////////////////////////////
            FileUtil fileUtil1=new FileUtil();
            workflowCustom_path=fileUtil1.Result_path();
            appendMethodB(admin_path,workflowCustom_path+"\r\n");
            xmlUtil.xmlAdd(fileList,"IGV");

            igvBean.setScope(mapping_scope);
            igvBean.setTreatment(remote_sam);
            igvBean.setReference(remote_reference);
            igvBean.setPath(workflowCustom_path);
            igvService.setIgvBean(igvBean);
            igvService.IGV_mapping_visual();

            //将结果压缩
            FileUtil fileUtil2=new FileUtil();
            fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        }
        flag="2";
        flag_mapping="1";
        return SUCCESS;
    }


    public String[] read(String readPath){
        String []s=new String [6];
        try {
            File f = new File(readPath);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "UTF-8");
                BufferedReader reader = new BufferedReader(read);
                String line;
                int count=0;
                while ((line = reader.readLine()) != null) {
                    s[count]=line;
                    count++;
                }
                read.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
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
        if(mapping_type==2){
            if(mapping_sam.equals("")){
                this.addFieldError("mapping_sam", "Please input your sam file.");
            }
            if(mapping_reference.equals("")){
                this.addFieldError("mapping_reference", "Please input your reference file.");
            }
            if(mapping_scope.equals("")){
                this.addFieldError("mapping_scope", "Please input the scope of gene.");
            }
        //  flag_validate_input1="2";
            flag_validate="2";
            flag_mapping="1";
        }
        else if(mapping_type==1){
            if(mapping_visual_scope.equals("")){
                this.addFieldError("mapping_visual_scope", "Please input the scope of gene.");
            }
          //flag_validate_input1="1";
            flag_validate="2";
            flag_mapping="1";
        }
        else{}

        if(peakcalling_type==1){
            if(peakcalling_visual_scope.equals("")){
                this.addFieldError("peakcalling_visual_scope", "Please input the scope of gene.");
            }
          //flag_validate_input2="1";
            flag_validate="2";
            flag_mapping="2";
        }
        else if(peakcalling_type==2){
            if(peakcalling_treatment.equals("")){
                this.addFieldError("peakcalling_treatment", "Please input the treatment file.");
            }
            if(peakcalling_control.equals("")){
                this.addFieldError("peakcalling_control", "Please input the control file.");
            }
            if(peakcalling_peak.equals("")){
                this.addFieldError("peakcalling_peak", "Please input the peak file.");
            }
            if(peakcalling_refer.equals("")){
                this.addFieldError("peakcalling_refer", "Please input the reference file.");
            }
            if(peakcalling_scope.equals("")){
                this.addFieldError("peakcalling_scope", "Please input scope of gene.");
            }
           /* xmlUtil xmlUtil=new xmlUtil();
            xmlUtil.login_validate();*/
          //flag_validate_input2="2";
            flag_validate="2";
            flag_mapping="2";
            flag="2";
        }
        else{}
    }
}
