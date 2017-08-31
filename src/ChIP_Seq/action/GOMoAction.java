package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.GetProperty;
import ChIP_Seq.UploadUtil;
import ChIP_Seq.bean.GOMoBean;
import ChIP_Seq.service.GOMoService;
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

/**
 * Created by Administrator on 2016/5/9 0009.
 */
public class GOMoAction extends ActionSupport{
    private String input_anno_peak;
    private int anno_genome;
    private String input_anno_path;
    private int GOMo_option;
    private String anno_gsize,anno_len;
    private String flag,flag_validate,flag_son;
    private String stdoutlist;
    private List<File> Gomo_peak;
    private List<String> Gomo_peakFileName;
    private String account_hidden;

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

    public List<File> getGomo_peak() {
        return Gomo_peak;
    }

    public void setGomo_peak(List<File> gomo_peak) {
        Gomo_peak = gomo_peak;
    }

    public List<String> getGomo_peakFileName() {
        return Gomo_peakFileName;
    }

    public void setGomo_peakFileName(List<String> gomo_peakFileName) {
        Gomo_peakFileName = gomo_peakFileName;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_anno_peak() {
        return input_anno_peak;
    }

    public void setInput_anno_peak(String input_anno_peak) {
        this.input_anno_peak = input_anno_peak;
    }

    public int getAnno_genome() {
        return anno_genome;
    }

    public void setAnno_genome(int anno_genome) {
        this.anno_genome = anno_genome;
    }

    public String getInput_anno_path() {
        return input_anno_path;
    }

    public void setInput_anno_path(String input_anno_path) {
        this.input_anno_path = input_anno_path;
    }

    public int getGOMo_option() {
        return GOMo_option;
    }

    public void setGOMo_option(int GOMo_option) {
        this.GOMo_option = GOMo_option;
    }

    public String getAnno_gsize() {
        return anno_gsize;
    }

    public void setAnno_gsize(String anno_gsize) {
        this.anno_gsize = anno_gsize;
    }

    public String getAnno_len() {
        return anno_len;
    }

    public void setAnno_len(String anno_len) {
        this.anno_len = anno_len;
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
    public String GOMo_exe() throws Exception{
        if(input_anno_peak.equals("H3K4me3.bed") && anno_genome==1){
            Gomo_DemoAction gomo_demoAction=new Gomo_DemoAction();
            gomo_demoAction.Demo();

            flag="4";
            flag_son="3";
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
            /////////////////////////////////////////////////////////////////////////////
            String remote_gomo;
            UploadUtil uploadUtil = new UploadUtil();
            List<String> Upload_path = uploadUtil.upload(Gomo_peakFileName, Gomo_peak);
            remote_gomo = Upload_path.get(0);
            /////////////////////////////////////////////////////////////////////////////
            FileUtil fileUtil = new FileUtil();
            String admin_path = fileUtil.adminCheck_path() + ".txt";
            File admin = new File(admin_path);
            appendMethodB(admin_path, "File list:" + "\r\n");
            String fileList = "";
            for (int i = 0; i < Gomo_peak.size(); i++) {
                appendMethodB(admin_path, Upload_path.get(i) + "\r\n");
                File file = new File(Upload_path.get(i));
                String name = file.getName();
                fileList += name + " ; ";
            }

            xmlUtil.xmlAdd_Jobs(JobId,fileList, "annotatePeaks",  "ERROR","email",time);
            appendMethodB(admin_path, "Result path:" + "\r\n");
            /////////////////////////////////////////////////////////////////////////////////
            GOMoService goMoService = (GOMoService) applicationContext.getBean("goMoService");
            FileUtil fileUtil1 = new FileUtil();
            input_anno_path = fileUtil1.Result_path();
            appendMethodB(admin_path, input_anno_path + "\r\n");
            GOMoBean goMoBean = new GOMoBean();
            goMoBean.setPeak(remote_gomo);
            if (anno_genome == 1) {
                goMoBean.setGenome("hg19");
            }
            else if(anno_genome==2){
                goMoBean.setGenome("mm8");
            }
            else{
                goMoBean.setGenome("sacCer3");
            }
            goMoBean.setPath(input_anno_path);
            if (GOMo_option == 1) {
                goMoBean.setOption("");
            } else {
                goMoBean.setOption(" -gsize " + anno_gsize + " -len " + anno_len);
            }
            goMoService.setGoMoBean(goMoBean);
            stdoutlist = goMoService.GOMo();

            //将结果压缩
            FileUtil fileUtil2=new FileUtil();
            fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");
            flag = "3";
            flag_son = "3";
        }
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
        if(input_anno_peak.equals("")){
            this.addFieldError("input_anno_peak", "Please input the peak file.");
        }
    /*    xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="3";
        flag_son="3";
        flag_validate="2";
    }
}
