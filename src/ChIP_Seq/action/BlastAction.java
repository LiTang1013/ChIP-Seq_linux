package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.BlastBean;
import ChIP_Seq.service.BlastService;
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
 * Created by lily on 7/22/16.
 */
public class BlastAction extends ActionSupport {
    private int blast_type;
    private String input_blast_reference;
    private String input_blast_reads;
    private String input_blast_path;
    private int optionalParameters_blast,refer_index_blast;
    private String blast_num_descriptions;
    private String blast_num_align;
    private String blast_max_target_seqs;
    private String blast_word_size;
    private String blast_gapopen;
    private String blast_reward;
    private String blast_penalty,blast_strand;
    private String blast_dust,blast_word_sizep,blast_gapextend,blast_threshold,blast_comp_based_stats,blast_seg,blast_soft_masking,blast_window_size;
    private String flag,flag_validate;
    private String stdoutlist;
    private File fileField_blast_re;
    private File fileField_blast_read;
    private String fileField_blast_reFileName;
    private String fileField_blast_readFileName;
    private String account_hidden;
    private int built_in_blast;
    private List<File> fileField_blast;
    private List<String> fileField_blastFileName;

    public int getBuilt_in_blast() {
        return built_in_blast;
    }

    public void setBuilt_in_blast(int built_in_blast) {
        this.built_in_blast = built_in_blast;
    }

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

    public List<String> getFileField_blastFileName() {
        return fileField_blastFileName;
    }

    public void setFileField_blastFileName(List<String> fileField_blastFileName) {
        this.fileField_blastFileName = fileField_blastFileName;
    }

    public List<File> getFileField_blast() {
        return fileField_blast;
    }

    public void setFileField_blast(List<File> fileField_blast) {
        this.fileField_blast = fileField_blast;
    }

    public String getFileField_blast_reFileName() {
        return fileField_blast_reFileName;
    }

    public void setFileField_blast_reFileName(String fileField_blast_reFileName) {
        this.fileField_blast_reFileName = fileField_blast_reFileName;
    }

    public String getFileField_blast_readFileName() {
        return fileField_blast_readFileName;
    }

    public void setFileField_blast_readFileName(String fileField_blast_readFileName) {
        this.fileField_blast_readFileName = fileField_blast_readFileName;
    }

    public File getFileField_blast_read() {
        return fileField_blast_read;
    }

    public void setFileField_blast_read(File fileField_blast_read) {
        this.fileField_blast_read = fileField_blast_read;
    }

    public File getFileField_blast_re() {
        return fileField_blast_re;
    }

    public void setFileField_blast_re(File fileField_blast_re) {
        this.fileField_blast_re = fileField_blast_re;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public int getBlast_type() {
        return blast_type;
    }

    public void setBlast_type(int blast_type) {
        this.blast_type = blast_type;
    }

    public String getInput_blast_reference() {
        return input_blast_reference;
    }

    public void setInput_blast_reference(String input_blast_reference) {
        this.input_blast_reference = input_blast_reference;
    }

    public String getInput_blast_reads() {
        return input_blast_reads;
    }

    public void setInput_blast_reads(String input_blast_reads) {
        this.input_blast_reads = input_blast_reads;
    }

    public String getInput_blast_path() {
        return input_blast_path;
    }

    public void setInput_blast_path(String input_blast_path) {
        this.input_blast_path = input_blast_path;
    }

    public int getOptionalParameters_blast() {
        return optionalParameters_blast;
    }

    public void setOptionalParameters_blast(int optionalParameters_blast) {
        this.optionalParameters_blast = optionalParameters_blast;
    }

    public String getBlast_num_descriptions() {
        return blast_num_descriptions;
    }

    public void setBlast_num_descriptions(String blast_num_descriptions) {
        this.blast_num_descriptions = blast_num_descriptions;
    }

    public String getBlast_num_align() {
        return blast_num_align;
    }

    public void setBlast_num_align(String blast_num_align) {
        this.blast_num_align = blast_num_align;
    }

    public String getBlast_max_target_seqs() {
        return blast_max_target_seqs;
    }

    public void setBlast_max_target_seqs(String blast_max_target_seqs) {
        this.blast_max_target_seqs = blast_max_target_seqs;
    }

    public String getBlast_word_size() {
        return blast_word_size;
    }

    public void setBlast_word_size(String blast_word_size) {
        this.blast_word_size = blast_word_size;
    }

    public String getBlast_gapopen() {
        return blast_gapopen;
    }

    public void setBlast_gapopen(String blast_gapopen) {
        this.blast_gapopen = blast_gapopen;
    }

    public String getBlast_reward() {
        return blast_reward;
    }

    public void setBlast_reward(String blast_reward) {
        this.blast_reward = blast_reward;
    }

    public String getBlast_penalty() {
        return blast_penalty;
    }

    public void setBlast_penalty(String blast_penalty) {
        this.blast_penalty = blast_penalty;
    }

    public String getBlast_dust() {
        return blast_dust;
    }

    public void setBlast_dust(String blast_dust) {
        this.blast_dust = blast_dust;
    }

    public String getBlast_word_sizep() {
        return blast_word_sizep;
    }

    public void setBlast_word_sizep(String blast_word_sizep) {
        this.blast_word_sizep = blast_word_sizep;
    }

    public String getBlast_gapextend() {
        return blast_gapextend;
    }

    public void setBlast_gapextend(String blast_gapextend) {
        this.blast_gapextend = blast_gapextend;
    }

    public String getBlast_threshold() {
        return blast_threshold;
    }

    public void setBlast_threshold(String blast_threshold) {
        this.blast_threshold = blast_threshold;
    }

    public String getBlast_comp_based_stats() {
        return blast_comp_based_stats;
    }

    public void setBlast_comp_based_stats(String blast_comp_based_stats) {
        this.blast_comp_based_stats = blast_comp_based_stats;
    }

    public String getBlast_seg() {
        return blast_seg;
    }

    public void setBlast_seg(String blast_seg) {
        this.blast_seg = blast_seg;
    }

    public String getBlast_soft_masking() {
        return blast_soft_masking;
    }

    public void setBlast_soft_masking(String blast_soft_masking) {
        this.blast_soft_masking = blast_soft_masking;
    }

    public String getBlast_window_size() {
        return blast_window_size;
    }

    public void setBlast_window_size(String blast_window_size) {
        this.blast_window_size = blast_window_size;
    }

    public String getBlast_strand() {
        return blast_strand;
    }

    public void setBlast_strand(String blast_strand) {
        this.blast_strand = blast_strand;
    }

    public int getRefer_index_blast() {
        return refer_index_blast;
    }

    public void setRefer_index_blast(int refer_index_blast) {
        this.refer_index_blast = refer_index_blast;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAccount_hidden() {
        return account_hidden;
    }

    public void setAccount_hidden(String account_hidden) {
        this.account_hidden = account_hidden;
    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    public String Blast_exe() throws Exception{
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        String JobId="JobId_"+xmlUtil.generateString(6);
        xmlUtil.creatSession(JobId,time);
        ///////////////////////////////////////////////////////////////////////////////////
        String remote_refer,remote_read;
        UploadUtil uploadUtil=new UploadUtil();
        List<String> Upload_path=uploadUtil.upload(fileField_blastFileName,fileField_blast);
        if(refer_index_blast==1){
            remote_refer=Upload_path.get(0);
            remote_read=Upload_path.get(1);
        }
        else{
            remote_refer="";
            remote_read=Upload_path.get(0);
        }
        ///////////////////////////////////////////////////////////////////////
        FileUtil fileUtil=new FileUtil();
        String admin_path= fileUtil.adminCheck_path()+".txt";
        File admin=new File(admin_path);
        appendMethodB(admin_path,"File list:"+"\r\n");
        String fileList="";
        for(int i=0;i<fileField_blast.size();i++){
            appendMethodB(admin_path,Upload_path.get(i)+"\r\n");
            File file=new File(Upload_path.get(i));
            String name=file.getName();
            fileList+=name+" ; ";
        }
        xmlUtil.xmlAdd_Jobs(JobId,fileList, "Blast", "ERROR","email",time);
        appendMethodB(admin_path,"Result path:"+"\r\n");
        ///////////////////////////////////////////////////////////////////////////////////
        BlastService blastService= (BlastService) applicationContext.getBean("blastService");
        FileUtil fileUtil1=new FileUtil();
        input_blast_path=fileUtil1.Result_path();
        appendMethodB(admin_path,input_blast_path+"\r\n");
        BlastBean blastBean=new BlastBean();
        blastBean.setReads(remote_read);
        blastBean.setPath(input_blast_path);
        blastBean.setType(blast_type);

        if(optionalParameters_blast==1){
            blastBean.setOption("");
        }
        else{
            if(blast_type==1){
                blastBean.setOption(" -num_descriptions "+blast_num_descriptions+" -num_alignments "+blast_num_align+" -max_target_seqs "+blast_max_target_seqs+" -word_size "+blast_word_size+" -gapopen "+blast_gapopen+" -reward "+blast_reward+" -penalty "+blast_penalty+" -strand "+blast_strand+" -dust "+blast_dust);
            }
            else{
                blastBean.setOption(" -num_descriptions "+blast_num_descriptions+" -num_alignments "+blast_num_align+" -max_target_seqs "+blast_max_target_seqs+" -word_size "+blast_word_sizep+" -gapextend "+blast_gapextend+" -threshold "+blast_threshold+" -comp_based_stats "+blast_comp_based_stats+" -seg "+blast_seg+" -soft_masking "+blast_soft_masking+" -window_size "+blast_window_size);
            }
        }
        if(refer_index_blast==1){
            blastBean.setReference(remote_refer);
            blastService.setBlastBean(blastBean);
            stdoutlist=blastService.Blast();
        }
        else{
            if(built_in_blast==1){
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "hg19");
                blastBean.setReference(commandline);
            }
            else{
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "mm8");
                blastBean.setReference(commandline);
            }
            blastService.setBlastBean(blastBean);
            stdoutlist=blastService.Blast_unBuild();
        }

        flag="5";
        flag_validate="1";

        //将结果压缩
        FileUtil fileUtil2=new FileUtil();
        fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
        return SUCCESS;
    }
    public String Blast_noUpload(){
        BlastService blastService= (BlastService) applicationContext.getBean("blastService");
        BlastBean blastBean=new BlastBean();
        blastBean.setReads(input_blast_reads);
        blastBean.setPath(input_blast_path);
        blastBean.setType(blast_type);

        if(optionalParameters_blast==1){
            blastBean.setOption("");
        }
        else{
            if(blast_type==1){
                blastBean.setOption(" -num_descriptions "+blast_num_descriptions+" -num_alignments "+blast_num_align+" -max_target_seqs "+blast_max_target_seqs+" -word_size "+blast_word_size+" -gapopen "+blast_gapopen+" -reward "+blast_reward+" -penalty "+blast_penalty+" -strand "+blast_strand+" -dust "+blast_dust);
            }
            else{
                blastBean.setOption(" -num_descriptions "+blast_num_descriptions+" -num_alignments "+blast_num_align+" -max_target_seqs "+blast_max_target_seqs+" -word_size "+blast_word_sizep+" -gapextend "+blast_gapextend+" -threshold "+blast_threshold+" -comp_based_stats "+blast_comp_based_stats+" -seg "+blast_seg+" -soft_masking "+blast_soft_masking+" -window_size "+blast_window_size);
            }
        }
        if(refer_index_blast==1){
            blastBean.setReference(input_blast_reference);
            blastService.setBlastBean(blastBean);
            stdoutlist=blastService.Blast();
        }
        else{
            if(built_in_blast==1){
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "hg19");
                blastBean.setReference(commandline);
            }
            else{
                String commandline;
                commandline = GetProperty.getPropertyByName("Config", "mm8");
                blastBean.setReference(commandline);
            }
            blastService.setBlastBean(blastBean);
            stdoutlist=blastService.Blast_unBuild();
        }
        flag="5";
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

        if(blast_type!=1&&blast_type!=2){
            this.addFieldError("blast_type", "Please select the type of sequence.");
        }
        if(refer_index_blast==1){
            if(input_blast_reference.equals("")){
                this.addFieldError("input_blast_reference", "Please input the reference.");
            }
        }
        if(input_blast_reads.equals("")){
            this.addFieldError("input_blast_reads", "Please input the reads.");
        }
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(fileField_blastFileName,fileField_blast)){
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
        flag="5";
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
