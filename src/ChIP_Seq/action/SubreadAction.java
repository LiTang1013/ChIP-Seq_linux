package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.SubreadBean;
import ChIP_Seq.service.SubreadService;
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
 * Created by lily on 7/24/16.
 */
public class SubreadAction extends ActionSupport {
    private int Subread_type;
    private String input_subread_reference;
    private String input_Subread_reads_single;
    private String input_Subread_reads_pair1;
    private String input_Subread_reads_pair2;
    private String input_Subread_path;
    private int optionalParameters_index_Subreadl,optionalParameters_align_Subread,refer_index_subread;
    private int Subread_B,Subread_B2,Subread_d,Subread_D,Subread_I,Subread_m,Subread_M2,Subread_n,Subread_p;
    private String Subread_f,Subread_P,Subread_S,Subread_T,Subread_trim5,Subread_trim3;
    private int Subread_F;
    private String Subread_M;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_subread_re;
    private File fileField_subread_read;
    private File fileField_subread_pair1;
    private File fileField_subread_pair2;
    private String fileField_subread_reFileName;
    private String fileField_subread_readFileName;
    private String fileField_subread_pair1FileName;
    private String fileField_subread_pair2FileName;
    private List<File> fileField_subread;
    private List<String> fileField_subreadFileName;
    private String  account_hidden;
    private int built_in_subread;

    public int getBuilt_in_subread() {
        return built_in_subread;
    }

    public void setBuilt_in_subread(int built_in_subread) {
        this.built_in_subread = built_in_subread;
    }

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


    public List<File> getFileField_subread() {
        return fileField_subread;
    }

    public void setFileField_subread(List<File> fileField_subread) {
        this.fileField_subread = fileField_subread;
    }

    public List<String> getFileField_subreadFileName() {
        return fileField_subreadFileName;
    }

    public void setFileField_subreadFileName(List<String> fileField_subreadFileName) {
        this.fileField_subreadFileName = fileField_subreadFileName;
    }

    public File getFileField_subread_re() {
        return fileField_subread_re;
    }

    public void setFileField_subread_re(File fileField_subread_re) {
        this.fileField_subread_re = fileField_subread_re;
    }

    public File getFileField_subread_read() {
        return fileField_subread_read;
    }

    public void setFileField_subread_read(File fileField_subread_read) {
        this.fileField_subread_read = fileField_subread_read;
    }

    public File getFileField_subread_pair1() {
        return fileField_subread_pair1;
    }

    public void setFileField_subread_pair1(File fileField_subread_pair1) {
        this.fileField_subread_pair1 = fileField_subread_pair1;
    }

    public File getFileField_subread_pair2() {
        return fileField_subread_pair2;
    }

    public void setFileField_subread_pair2(File fileField_subread_pair2) {
        this.fileField_subread_pair2 = fileField_subread_pair2;
    }

    public String getFileField_subread_reFileName() {
        return fileField_subread_reFileName;
    }

    public void setFileField_subread_reFileName(String fileField_subread_reFileName) {
        this.fileField_subread_reFileName = fileField_subread_reFileName;
    }

    public String getFileField_subread_readFileName() {
        return fileField_subread_readFileName;
    }

    public void setFileField_subread_readFileName(String fileField_subread_readFileName) {
        this.fileField_subread_readFileName = fileField_subread_readFileName;
    }

    public String getFileField_subread_pair1FileName() {
        return fileField_subread_pair1FileName;
    }

    public void setFileField_subread_pair1FileName(String fileField_subread_pair1FileName) {
        this.fileField_subread_pair1FileName = fileField_subread_pair1FileName;
    }

    public String getFileField_subread_pair2FileName() {
        return fileField_subread_pair2FileName;
    }

    public void setFileField_subread_pair2FileName(String fileField_subread_pair2FileName) {
        this.fileField_subread_pair2FileName = fileField_subread_pair2FileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getSubread_type() {
        return Subread_type;
    }

    public void setSubread_type(int subread_type) {
        Subread_type = subread_type;
    }

    public String getInput_subread_reference() {
        return input_subread_reference;
    }

    public void setInput_subread_reference(String input_subread_reference) {
        this.input_subread_reference = input_subread_reference;
    }

    public String getInput_Subread_reads_single() {
        return input_Subread_reads_single;
    }

    public void setInput_Subread_reads_single(String input_Subread_reads_single) {
        this.input_Subread_reads_single = input_Subread_reads_single;
    }

    public String getInput_Subread_reads_pair1() {
        return input_Subread_reads_pair1;
    }

    public void setInput_Subread_reads_pair1(String input_Subread_reads_pair1) {
        this.input_Subread_reads_pair1 = input_Subread_reads_pair1;
    }

    public String getInput_Subread_reads_pair2() {
        return input_Subread_reads_pair2;
    }

    public void setInput_Subread_reads_pair2(String input_Subread_reads_pair2) {
        this.input_Subread_reads_pair2 = input_Subread_reads_pair2;
    }

    public String getInput_Subread_path() {
        return input_Subread_path;
    }

    public void setInput_Subread_path(String input_Subread_path) {
        this.input_Subread_path = input_Subread_path;
    }

    public int getOptionalParameters_index_Subreadl() {
        return optionalParameters_index_Subreadl;
    }

    public void setOptionalParameters_index_Subreadl(int optionalParameters_index_Subreadl) {
        this.optionalParameters_index_Subreadl = optionalParameters_index_Subreadl;
    }

    public int getOptionalParameters_align_Subread() {
        return optionalParameters_align_Subread;
    }

    public void setOptionalParameters_align_Subread(int optionalParameters_align_Subread) {
        this.optionalParameters_align_Subread = optionalParameters_align_Subread;
    }

    public int getSubread_B() {
        return Subread_B;
    }

    public void setSubread_B(int subread_B) {
        Subread_B = subread_B;
    }

    public int getSubread_B2() {
        return Subread_B2;
    }

    public void setSubread_B2(int subread_B2) {
        Subread_B2 = subread_B2;
    }

    public int getSubread_d() {
        return Subread_d;
    }

    public void setSubread_d(int subread_d) {
        Subread_d = subread_d;
    }

    public int getSubread_D() {
        return Subread_D;
    }

    public void setSubread_D(int subread_D) {
        Subread_D = subread_D;
    }

    public int getSubread_I() {
        return Subread_I;
    }

    public void setSubread_I(int subread_I) {
        Subread_I = subread_I;
    }

    public int getSubread_m() {
        return Subread_m;
    }

    public void setSubread_m(int subread_m) {
        Subread_m = subread_m;
    }

    public int getSubread_M2() {
        return Subread_M2;
    }

    public void setSubread_M2(int subread_M2) {
        Subread_M2 = subread_M2;
    }

    public int getSubread_n() {
        return Subread_n;
    }

    public void setSubread_n(int subread_n) {
        Subread_n = subread_n;
    }

    public int getSubread_p() {
        return Subread_p;
    }

    public void setSubread_p(int subread_p) {
        Subread_p = subread_p;
    }

    public String getSubread_f() {
        return Subread_f;
    }

    public void setSubread_f(String subread_f) {
        Subread_f = subread_f;
    }

    public String getSubread_P() {
        return Subread_P;
    }

    public void setSubread_P(String subread_P) {
        Subread_P = subread_P;
    }

    public String getSubread_S() {
        return Subread_S;
    }

    public void setSubread_S(String subread_S) {
        Subread_S = subread_S;
    }

    public String getSubread_T() {
        return Subread_T;
    }

    public void setSubread_T(String subread_T) {
        Subread_T = subread_T;
    }

    public String getSubread_trim5() {
        return Subread_trim5;
    }

    public void setSubread_trim5(String subread_trim5) {
        Subread_trim5 = subread_trim5;
    }

    public String getSubread_trim3() {
        return Subread_trim3;
    }

    public void setSubread_trim3(String subread_trim3) {
        Subread_trim3 = subread_trim3;
    }

    public int getSubread_F() {
        return Subread_F;
    }

    public void setSubread_F(int subread_F) {
        Subread_F = subread_F;
    }

    public String getSubread_M() {
        return Subread_M;
    }

    public void setSubread_M(String subread_M) {
        Subread_M = subread_M;
    }

    public int getRefer_index_subread() {
        return refer_index_subread;
    }

    public void setRefer_index_subread(int refer_index_subread) {
        this.refer_index_subread = refer_index_subread;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String Subread_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        /////////////////////////////////////////////////////////////
        String remote_re,remote_read,remote_pair1,remote_pair2;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_subreadFileName,fileField_subread);
        if(refer_index_subread==1){
            if(Subread_type==1){
                remote_read= Upload_path.get(1);
                remote_pair1="";
                remote_pair2="";
            }
            else{
                remote_read="";
                remote_pair1=Upload_path.get(1);
                remote_pair2=Upload_path.get(2);
            }
            remote_re=Upload_path.get(0);
        }
        else{
            if(Subread_type==1){
                remote_read= Upload_path.get(0);
                remote_pair1="";
                remote_pair2="";
            }
            else{
                remote_read="";
                remote_pair1=Upload_path.get(0);
                remote_pair2=Upload_path.get(1);
            }
            remote_re="";
        }
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_subread.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Subread", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        /////////////////////////////////////////////////////////////
        SubreadService subreadService= (SubreadService) applicationContext.getBean("subreadService");
        SubreadBean subreadBean=new SubreadBean();
        FileUtil fileUtil1=new FileUtil();
        input_Subread_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_Subread_path+"\r\n");
        subreadBean.setPath(input_Subread_path);
        subreadBean.setRead_type(Subread_type);

        if(Subread_type==1){
            subreadBean.setRead_single(remote_read);
        }
        else{
            subreadBean.setRead_1(remote_pair1);
            subreadBean.setRead_2(remote_pair2);
        }
        if(optionalParameters_index_Subreadl==1){
            subreadBean.setOption_index("");
        }
        else{
            String B,F;
            if(Subread_B==1){
                B="-B";
            }
            else{
                B="";
            }
            if(Subread_F==1){
                F="-F";
            }
            else{
                F="";
            }
            subreadBean.setOption_index(B+" -f "+F+" -M "+Subread_M);
        }
        if(optionalParameters_align_Subread==1){
            subreadBean.setOption_align("");
        }
        else{
            subreadBean.setOption_align(" -B "+Subread_B2+" -d "+Subread_d+" -D "+Subread_D+" -I "+Subread_I+" -m "+Subread_m+" -M "+Subread_M+" -n "+Subread_n+" -p "+Subread_p+" -P "+Subread_P+" -S "+Subread_S+" -T "+Subread_T+" --trim5 "+Subread_trim5+" --trim3 "+Subread_trim3);
        }
        if(refer_index_subread==1){
            subreadBean.setReference(remote_re);
            subreadService.setSubreadBean(subreadBean);
            stdoutlist=subreadService.Subread();
        }
        else{
            if(built_in_subread==1){
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "hg19");
                subreadBean.setReference(commandline);
            }
            else{
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "mm8");
                subreadBean.setReference(commandline);
            }
            subreadService.setSubreadBean(subreadBean);
            stdoutlist=subreadService.Subread_unBuild();
        }
        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        flag="6";
        flag_validate="1";
        return SUCCESS;
    }
    public String SubreadnoUpload(){
        SubreadService subreadService= (SubreadService) applicationContext.getBean("subreadService");
        SubreadBean subreadBean=new SubreadBean();

        subreadBean.setPath(input_Subread_path);
        subreadBean.setRead_type(Subread_type);
        if(Subread_type==1){
            subreadBean.setRead_single(input_Subread_reads_single);
        }
        else{
            subreadBean.setRead_1(input_Subread_reads_pair1);
            subreadBean.setRead_2(input_Subread_reads_pair2);
        }
        if(optionalParameters_index_Subreadl==1){
            subreadBean.setOption_index("");
        }
        else{
            String B,F;
            if(Subread_B==1){
                B="-B";
            }
            else{
                B="";
            }
            if(Subread_F==1){
                F="-F";
            }
            else{
                F="";
            }
            subreadBean.setOption_index(B+" -f "+F+" -M "+Subread_M);
        }
        if(optionalParameters_align_Subread==1){
            subreadBean.setOption_align("");
        }
        else{
            subreadBean.setOption_align(" -B "+Subread_B2+" -d "+Subread_d+" -D "+Subread_D+" -I "+Subread_I+" -m "+Subread_m+" -M "+Subread_M+" -n "+Subread_n+" -p "+Subread_p+" -P "+Subread_P+" -S "+Subread_S+" -T "+Subread_T+" --trim5 "+Subread_trim5+" --trim3 "+Subread_trim3);
        }
        if(refer_index_subread==1){
            subreadBean.setReference(input_subread_reference);
            subreadService.setSubreadBean(subreadBean);
            stdoutlist=subreadService.Subread();
        }
        else{
            if(built_in_subread==1){
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "hg19");
                subreadBean.setReference(commandline);
            }
            else{
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "mm8");
                subreadBean.setReference(commandline);
            }
            subreadService.setSubreadBean(subreadBean);
            stdoutlist=subreadService.Subread_unBuild();
        }
        flag="6";
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

        if(refer_index_subread==1) {
            if (input_subread_reference.equals("")) {
                this.addFieldError("input_subread_reference", "Please input the reference file.");
            }
        }
            if(Subread_type==1){
                if(input_Subread_reads_single.equals("")){
                    this.addFieldError("input_Subread_reads_single", "Please input the reads file.");
                }
            }
        else{
                if(input_Subread_reads_pair1.equals("")||input_Subread_reads_pair1.equals("")){
                    this.addFieldError("input_Subread_reads_pair1", "Please input the reads file.");
                }
            }
        try{
            UploadUtil uploadUtil=new UploadUtil();
            if(!uploadUtil.Check(fileField_subreadFileName,fileField_subread)){
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
        flag="6";
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
