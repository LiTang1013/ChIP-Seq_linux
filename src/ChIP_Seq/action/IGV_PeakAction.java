package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.IGVBean;
import ChIP_Seq.bean.IGV_PeakBean;
import ChIP_Seq.service.IGVService;
import ChIP_Seq.service.IGV_PeakService;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lily on 11/19/16.
 */
public class IGV_PeakAction extends ActionSupport{
    private String reference;
    private String treatment;
    private String control;
    private String peak;
    private String path;
    private String scope;
    private String stdoutlist;
    private String flag,flag_mapping,flag_validate,flag_command;
    private String workflowCustom_path;
    private int peakcalling_type;
    private String peakcalling_visual_scope,peakcalling_scope;
    private List<File>fileField_peak;
    private List<String>fileField_peakFileName;
    private String peakcalling_treatment;
    private String peakcalling_control;
    private String peakcalling_peak;
    private String peakcalling_refer;
    private String bampath_treatment;
    private String bampath_control;
    private String peakpath;
    private String sampath;
    private String workflowCustom_reference;
    private String mapping_visual_scope;

    public String getFlag_command() {
        return flag_command;
    }

    public void setFlag_command(String flag_command) {
        this.flag_command = flag_command;
    }

    public String getSampath() {
        return sampath;
    }

    public void setSampath(String sampath) {
        this.sampath = sampath;
    }

    public String getWorkflowCustom_reference() {
        return workflowCustom_reference;
    }

    public void setWorkflowCustom_reference(String workflowCustom_reference) {
        this.workflowCustom_reference = workflowCustom_reference;
    }

    public String getMapping_visual_scope() {
        return mapping_visual_scope;
    }

    public void setMapping_visual_scope(String mapping_visual_scope) {
        this.mapping_visual_scope = mapping_visual_scope;
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

    public String getPeakcalling_scope() {
        return peakcalling_scope;
    }

    public void setPeakcalling_scope(String peakcalling_scope) {
        this.peakcalling_scope = peakcalling_scope;
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

    public String getPeakcalling_visual_scope() {
        return peakcalling_visual_scope;
    }

    public void setPeakcalling_visual_scope(String peakcalling_visual_scope) {
        this.peakcalling_visual_scope = peakcalling_visual_scope;
    }

    public int getPeakcalling_type() {
        return peakcalling_type;
    }

    public void setPeakcalling_type(int peakcalling_type) {
        this.peakcalling_type = peakcalling_type;
    }

    public String getWorkflowCustom_path() {
        return workflowCustom_path;
    }

    public void setWorkflowCustom_path(String workflowCustom_path) {
        this.workflowCustom_path = workflowCustom_path;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//第一次可视化
    public String IGV_Peak() throws Exception{
        IGV_PeakService igv_peakService = (IGV_PeakService) applicationContext.getBean("igv_peakService");
        IGV_PeakBean igv_peakBean=new IGV_PeakBean();

            igv_peakBean.setReference(reference);
            igv_peakBean.setTreatment(treatment);
            igv_peakBean.setControl(control);
            igv_peakBean.setPeak(peak);
            igv_peakBean.setScope(scope);
            igv_peakBean.setPath(path);
            igv_peakService.setIgv_peakBean(igv_peakBean);
            stdoutlist=igv_peakService.IGV_peakcalling_visual();
        flag="3";
        flag_command="1";
        return SUCCESS;
    }
//第二次,第三次
public String visual_peakcalling() throws Exception{
    ///////////////////////////peakcalling generated 显示///////////////////////////
    String s1[]=read(workflowCustom_path+"/workflow_input_temp.txt");
    bampath_treatment=s1[0];
    bampath_control=s1[1];
    peakpath=s1[2];
    ////////////////////////mapping generated 显示////////////////////////////////////
    String s2[]=read(workflowCustom_path+"/workflow_input_temp.txt");
    sampath=s2[0];
    workflowCustom_reference=s2[4];
    ///////////////////////////////////////////////////////////////////////////////////////
    IGVService igvService=(IGVService)applicationContext.getBean("igvService");
    String [] s=new String [6];
    s=read(workflowCustom_path+"/workflow_input_temp.txt");
    String bampath_treatment1=s[0];
    String bampath_control1=s[1];
    String peakpath1=s[2];
    String workflowCustom_reference1=s[4];

    IGVBean igvBean=new IGVBean();
    if(peakcalling_type==1){
        igvBean.setReference(workflowCustom_reference1);
        igvBean.setTreatment(bampath_treatment1);
        igvBean.setControl(bampath_control1);
        igvBean.setPath(workflowCustom_path);
        igvBean.setPeak(peakpath1);
        igvBean.setScope(peakcalling_visual_scope);
        igvService.setIgvBean(igvBean);
        igvService.IGV_peakcalling_unSamtools();
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
        String remote_treat,remote_control,remote_peak,remote_reference;
        List<String> Upload_path=uploadUtil.upload(fileField_peakFileName,fileField_peak);
        remote_treat=Upload_path.get(0);
        remote_control=Upload_path.get(1);
        remote_peak=Upload_path.get(2);
        remote_reference=Upload_path.get(3);
        /////////////////////////////temp file/////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        String fileList="";

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "IGV",  "ERROR","email",time);
        appendMethodB(admin_path,"File list:"+"\r\n");
        for(int i=0;i<fileField_peak.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        appendMethodB(admin_path,"Result path:"+"\r\n");
        ///////////////////////////////////////////////////////////////////////////////////////////////
        FileUtil fileUtil1=new FileUtil();
        workflowCustom_path=fileUtil1.Result_path();
        appendMethodB(admin_path,workflowCustom_path+"\r\n");


        igvBean.setReference(remote_reference);
        igvBean.setTreatment(remote_treat);
        igvBean.setControl(remote_control);
        igvBean.setPath(workflowCustom_path);
        igvBean.setPeak(remote_peak);
        igvBean.setScope(peakcalling_scope);
        igvService.setIgvBean(igvBean);
        stdoutlist=igvService.IGV_peakcalling_visual();

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
    }
    flag="3";
    flag_command="2";
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
        if(peakcalling_type==1){
            if(peakcalling_visual_scope.equals("")){
                this.addFieldError("peakcalling_visual_scope", "Please input the scope of gene.");
            }
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
       /*     xmlUtil xmlUtil=new xmlUtil();
            xmlUtil.login_validate();*/
        }
        else{}
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_peakFileName,fileField_peak)){
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
