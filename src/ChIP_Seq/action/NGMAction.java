package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.NGMBean;
import ChIP_Seq.service.NGMService;
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
 * Created by lily on 7/26/16.
 */
public class NGMAction extends ActionSupport {
    private int NGM_type,optionalParameters_NGM,NGM_frc,NGM_kt,NGM_sen,NGM_l,NGM_e,NGM_a,NGM_smc,refer_index_NGM;
    private String input_NGM_reference;
    private String input_NGM_reads;
    private String input_NGM_reads_pair1;
    private String input_NGM_reads_pair2;
    private String input_NGM_path;
    private String NGM_n,NGM_t,NGM_i,NGM_R,NGM_Q,NGM_bc,NGM_k,NGM_ks,NGM_km,NGM_I,NGM_X;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_ngm_re;
    private File fileField_ngm_read;
    private File fileField_ngm_pair1;
    private File fileField_ngm_pair2;
    private String fileField_ngm_reFileName;
    private String fileField_ngm_readFileName;
    private String fileField_ngm_pair1FileName;
    private String fileField_ngm_pair2FileName;
    private String account_hidden;
    private List<File> fileField_ngm;
    private List<String> fileField_ngmFileName;

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


    public List<String> getFileField_ngmFileName() {
        return fileField_ngmFileName;
    }

    public void setFileField_ngmFileName(List<String> fileField_ngmFileName) {
        this.fileField_ngmFileName = fileField_ngmFileName;
    }

    public List<File> getFileField_ngm() {
        return fileField_ngm;
    }

    public void setFileField_ngm(List<File> fileField_ngm) {
        this.fileField_ngm = fileField_ngm;
    }

    public String getFileField_ngm_reFileName() {
        return fileField_ngm_reFileName;
    }

    public void setFileField_ngm_reFileName(String fileField_ngm_reFileName) {
        this.fileField_ngm_reFileName = fileField_ngm_reFileName;
    }

    public String getFileField_ngm_readFileName() {
        return fileField_ngm_readFileName;
    }

    public void setFileField_ngm_readFileName(String fileField_ngm_readFileName) {
        this.fileField_ngm_readFileName = fileField_ngm_readFileName;
    }

    public String getFileField_ngm_pair1FileName() {
        return fileField_ngm_pair1FileName;
    }

    public void setFileField_ngm_pair1FileName(String fileField_ngm_pair1FileName) {
        this.fileField_ngm_pair1FileName = fileField_ngm_pair1FileName;
    }

    public String getFileField_ngm_pair2FileName() {
        return fileField_ngm_pair2FileName;
    }

    public void setFileField_ngm_pair2FileName(String fileField_ngm_pair2FileName) {
        this.fileField_ngm_pair2FileName = fileField_ngm_pair2FileName;
    }

    public File getFileField_ngm_re() {
        return fileField_ngm_re;
    }

    public void setFileField_ngm_re(File fileField_ngm_re) {
        this.fileField_ngm_re = fileField_ngm_re;
    }

    public File getFileField_ngm_read() {
        return fileField_ngm_read;
    }

    public void setFileField_ngm_read(File fileField_ngm_read) {
        this.fileField_ngm_read = fileField_ngm_read;
    }

    public File getFileField_ngm_pair1() {
        return fileField_ngm_pair1;
    }

    public void setFileField_ngm_pair1(File fileField_ngm_pair1) {
        this.fileField_ngm_pair1 = fileField_ngm_pair1;
    }

    public File getFileField_ngm_pair2() {
        return fileField_ngm_pair2;
    }

    public void setFileField_ngm_pair2(File fileField_ngm_pair2) {
        this.fileField_ngm_pair2 = fileField_ngm_pair2;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getNGM_type() {
        return NGM_type;
    }

    public void setNGM_type(int NGM_type) {
        this.NGM_type = NGM_type;
    }

    public int getOptionalParameters_NGM() {
        return optionalParameters_NGM;
    }

    public void setOptionalParameters_NGM(int optionalParameters_NGM) {
        this.optionalParameters_NGM = optionalParameters_NGM;
    }

    public int getNGM_frc() {
        return NGM_frc;
    }

    public void setNGM_frc(int NGM_frc) {
        this.NGM_frc = NGM_frc;
    }

    public int getNGM_kt() {
        return NGM_kt;
    }

    public void setNGM_kt(int NGM_kt) {
        this.NGM_kt = NGM_kt;
    }

    public int getNGM_sen() {
        return NGM_sen;
    }

    public void setNGM_sen(int NGM_sen) {
        this.NGM_sen = NGM_sen;
    }

    public int getNGM_l() {
        return NGM_l;
    }

    public void setNGM_l(int NGM_l) {
        this.NGM_l = NGM_l;
    }

    public int getNGM_e() {
        return NGM_e;
    }

    public void setNGM_e(int NGM_e) {
        this.NGM_e = NGM_e;
    }

    public int getNGM_a() {
        return NGM_a;
    }

    public void setNGM_a(int NGM_a) {
        this.NGM_a = NGM_a;
    }

    public int getNGM_smc() {
        return NGM_smc;
    }

    public void setNGM_smc(int NGM_smc) {
        this.NGM_smc = NGM_smc;
    }

    public String getInput_NGM_reference() {
        return input_NGM_reference;
    }

    public void setInput_NGM_reference(String input_NGM_reference) {
        this.input_NGM_reference = input_NGM_reference;
    }

    public String getInput_NGM_reads() {
        return input_NGM_reads;
    }

    public void setInput_NGM_reads(String input_NGM_reads) {
        this.input_NGM_reads = input_NGM_reads;
    }

    public String getInput_NGM_reads_pair1() {
        return input_NGM_reads_pair1;
    }

    public void setInput_NGM_reads_pair1(String input_NGM_reads_pair1) {
        this.input_NGM_reads_pair1 = input_NGM_reads_pair1;
    }

    public String getInput_NGM_reads_pair2() {
        return input_NGM_reads_pair2;
    }

    public void setInput_NGM_reads_pair2(String input_NGM_reads_pair2) {
        this.input_NGM_reads_pair2 = input_NGM_reads_pair2;
    }

    public String getInput_NGM_path() {
        return input_NGM_path;
    }

    public void setInput_NGM_path(String input_NGM_path) {
        this.input_NGM_path = input_NGM_path;
    }

    public String getNGM_n() {
        return NGM_n;
    }

    public void setNGM_n(String NGM_n) {
        this.NGM_n = NGM_n;
    }

    public String getNGM_t() {
        return NGM_t;
    }

    public void setNGM_t(String NGM_t) {
        this.NGM_t = NGM_t;
    }

    public String getNGM_i() {
        return NGM_i;
    }

    public void setNGM_i(String NGM_i) {
        this.NGM_i = NGM_i;
    }

    public String getNGM_R() {
        return NGM_R;
    }

    public void setNGM_R(String NGM_R) {
        this.NGM_R = NGM_R;
    }

    public String getNGM_Q() {
        return NGM_Q;
    }

    public void setNGM_Q(String NGM_Q) {
        this.NGM_Q = NGM_Q;
    }

    public String getNGM_bc() {
        return NGM_bc;
    }

    public void setNGM_bc(String NGM_bc) {
        this.NGM_bc = NGM_bc;
    }

    public String getNGM_k() {
        return NGM_k;
    }

    public void setNGM_k(String NGM_k) {
        this.NGM_k = NGM_k;
    }

    public String getNGM_ks() {
        return NGM_ks;
    }

    public void setNGM_ks(String NGM_ks) {
        this.NGM_ks = NGM_ks;
    }

    public String getNGM_km() {
        return NGM_km;
    }

    public void setNGM_km(String NGM_km) {
        this.NGM_km = NGM_km;
    }

    public String getNGM_I() {
        return NGM_I;
    }

    public void setNGM_I(String NGM_I) {
        this.NGM_I = NGM_I;
    }

    public String getNGM_X() {
        return NGM_X;
    }

    public int getRefer_index_NGM() {
        return refer_index_NGM;
    }

    public void setRefer_index_NGM(int refer_index_NGM) {
        this.refer_index_NGM = refer_index_NGM;
    }

    public void setNGM_X(String NGM_X) {
        this.NGM_X = NGM_X;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String NGM_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ////////////////////////////////////////////////////////////////
        String remote_re,remote_read,remote_file1,remote_file2;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_ngmFileName,fileField_ngm);
        if(refer_index_NGM==1){
            if(NGM_type==1){
                remote_read=Upload_path.get(1);
                remote_file1="";
                remote_file2="";
            }
            else{
                remote_read="";
                remote_file1=Upload_path.get(1);
                remote_file2=Upload_path.get(2);
            }
            remote_re=Upload_path.get(0);
        }
        else{
            if(NGM_type==1){
                remote_read=Upload_path.get(0);
                remote_file1="";
                remote_file2="";
            }
            else{
                remote_read="";
                remote_file1=Upload_path.get(0);
                remote_file2=Upload_path.get(1);
            }
            remote_re="";
        }
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_ngm.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }

        xmlUtil.xmlAdd_Jobs(JobId,fileList, "NGM",  "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ////////////////////////////////////////////////////////////////
        NGMService ngmService= (NGMService) applicationContext.getBean("ngmService");
        NGMBean ngmBean=new NGMBean();
        FileUtil fileUtil1=new FileUtil();
        input_NGM_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_NGM_path+"\r\n");

        ngmBean.setPath(input_NGM_path);
        ngmBean.setType(NGM_type);
        if(refer_index_NGM==1){
            ngmBean.setReference(remote_re);
        }
        else{
            String commandline;
            commandline = GetProperty.getPropertyByName("Config", "hg19");
            ngmBean.setReference(commandline);
        }
        if(optionalParameters_NGM==1){
            ngmBean.setOption("");
        }
        else{
            String sen,l,e,a,smc;
            if(NGM_sen==1){
                sen=" very fast ";
            }
            else if(NGM_sen==2){
                sen=" fast ";
            }
            else if(NGM_sen==3){
                sen=" sensitive ";
            }
            else{
                sen=" very-sensitive ";
            }
            if(NGM_l==1){
                l=" -l ";
            }
            else{
                l="";
            }
            if(NGM_e==1){
                e=" -e ";
            }
            else{
                e="";
            }
            if(NGM_a==1){
                a=" --affine ";
            }
            else{
                a="";
            }
            if(NGM_smc==1){
                smc=" --skip-mate-check ";
            }
            else{
                smc="";
            }
            ngmBean.setOption(" --force-rlength-check "+NGM_frc+" -n "+NGM_n+" --keep-tags "+NGM_kt+" -t "+NGM_t+sen+" -i "+NGM_i+" -R "+NGM_R+" -Q "+NGM_Q+" --bs-cutoff "+NGM_bc+" -k "+NGM_k+" --kmer-skip "+NGM_ks+" --kmer-min "+NGM_km+l+e+a+smc);
        }
        if(NGM_type==1){
            ngmBean.setReads_single(remote_read);
        }
        else{
            ngmBean.setReads_1(remote_file1);
            ngmBean.setReads_2(remote_file2);
        }
        ngmService.setNgmBean(ngmBean);
        stdoutlist=ngmService.NGM();
        flag="7";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String NGM_noUpload(){
        NGMService ngmService= (NGMService) applicationContext.getBean("ngmService");
        NGMBean ngmBean=new NGMBean();
        ngmBean.setPath(input_NGM_path);
        ngmBean.setType(NGM_type);
        if(refer_index_NGM==1){
            ngmBean.setReference(input_NGM_reference);
        }
        else{
            ngmBean.setReference("");
        }
        if(optionalParameters_NGM==1){
            ngmBean.setOption("");
        }
        else{
            String sen,l,e,a,smc;
            if(NGM_sen==1){
                sen=" very fast ";
            }
            else if(NGM_sen==2){
                sen=" fast ";
            }
            else if(NGM_sen==3){
                sen=" sensitive ";
            }
            else{
                sen=" very-sensitive ";
            }
            if(NGM_l==1){
                l=" -l ";
            }
            else{
                l="";
            }
            if(NGM_e==1){
                e=" -e ";
            }
            else{
                e="";
            }
            if(NGM_a==1){
                a=" --affine ";
            }
            else{
                a="";
            }
            if(NGM_smc==1){
                smc=" --skip-mate-check ";
            }
            else{
                smc="";
            }
            ngmBean.setOption(" --force-rlength-check "+NGM_frc+" -n "+NGM_n+" --keep-tags "+NGM_kt+" -t "+NGM_t+sen+" -i "+NGM_i+" -R "+NGM_R+" -Q "+NGM_Q+" --bs-cutoff "+NGM_bc+" -k "+NGM_k+" --kmer-skip "+NGM_ks+" --kmer-min "+NGM_km+l+e+a+smc);
        }
        if(NGM_type==1){
            ngmBean.setReads_single(input_NGM_reads);
        }
        else{
            ngmBean.setReads_1(input_NGM_reads_pair1);
            ngmBean.setReads_2(input_NGM_reads_pair2);
        }
        ngmService.setNgmBean(ngmBean);
        stdoutlist=ngmService.NGM();
        flag="7";
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

        if(refer_index_NGM==1){
            if(input_NGM_reference.equals("")){
                this.addFieldError("input_NGM_reference", "Please input the reference file.");
            }
        }
        if(NGM_type==1){
            if(input_NGM_reads.equals("")){
                this.addFieldError("input_NGM_reads", "Please input the reads file.");
            }
        }
        else{
            if(input_NGM_reads_pair1.equals("")||input_NGM_reads_pair2.equals("")){
                this.addFieldError("input_NGM_reads_pair1", "Please input the reads file.");
            }
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_ngmFileName,fileField_ngm)){
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
      /*  xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="7";
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
