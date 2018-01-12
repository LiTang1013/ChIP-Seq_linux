package ChIP_Seq.action;

import ChIP_Seq.*;
import ChIP_Seq.bean.iPAGEBean;
import ChIP_Seq.service.iPAGEService;
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
<<<<<<< HEAD
import java.util.Map;
import java.util.Set;
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c

/**
 * Created by lily on 11/3/16.
 */
public class iPAGE_newAction extends ActionSupport {
    private String input_exp;
    private int species_select;
    private int profile_type,exp_peak;
    private String input_peakfile;
    private String flag,flag_validate,flag_son;
    private String stdoutlist;

   private List<File> ipage_file;
    private List<String> ipage_fileFileName;
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

    public List<String> getIpage_fileFileName() {
        return ipage_fileFileName;
    }

    public void setIpage_fileFileName(List<String> ipage_fileFileName) {
        this.ipage_fileFileName = ipage_fileFileName;
    }

    public List<File> getIpage_file() {
        return ipage_file;
    }

    public void setIpage_file(List<File> ipage_file) {
        this.ipage_file = ipage_file;
    }

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public String getInput_exp() {
        return input_exp;
    }

    public void setInput_exp(String input_exp) {
        this.input_exp = input_exp;
    }

    public int getSpecies_select() {
        return species_select;
    }

    public void setSpecies_select(int species_select) {
        this.species_select = species_select;
    }

    public int getProfile_type() {
        return profile_type;
    }

    public void setProfile_type(int profile_type) {
        this.profile_type = profile_type;
    }

    public String getInput_peakfile() {
        return input_peakfile;
    }

    public void setInput_peakfile(String input_peakfile) {
        this.input_peakfile = input_peakfile;
    }

    public int getExp_peak() {
        return exp_peak;
    }

    public void setExp_peak(int exp_peak) {
        this.exp_peak = exp_peak;
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
    public String IPAGE_exe() throws Exception {
        if (exp_peak == 1 && input_peakfile.equals("H3K4me3.bed") && species_select==1) {
            iPAGE_DemoAction iPAGE_demoAction = new iPAGE_DemoAction();
            iPAGE_demoAction.Demo();

<<<<<<< HEAD
            flag = "3";
=======
            flag = "6";
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
            flag_son = "5";
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
        //////////////////////////////////////////////////////////////////////////
        String remote_peak, remote_exp;
        UploadUtil uploadUtil = new UploadUtil();
        System.out.println(input_peakfile);
        List<String> Upload_path = uploadUtil.upload(ipage_fileFileName, ipage_file);
        if (exp_peak == 1) {
            remote_peak = Upload_path.get(0);
            remote_exp = "";
        } else {
            remote_exp = Upload_path.get(0);
            remote_peak = "";
        }
        //////////////////////////////////////////////////////////////////////////
        FileUtil fileUtil = new FileUtil();
        String admin_path = fileUtil.adminCheck_path() + ".txt";
        File admin = new File(admin_path);
        appendMethodB(admin_path, "File list:" + "\r\n");
        String fileList = "";
        for (int i = 0; i < ipage_file.size(); i++) {
            appendMethodB(admin_path, Upload_path.get(i) + "\r\n");
            File file = new File(Upload_path.get(i));
            String name = file.getName();
            fileList += name + " ; ";
        }
            xmlUtil.xmlAdd_Jobs(JobId,fileList, "iPAGE",  "ERROR","email",time);
        appendMethodB(admin_path, "Result path:" + "\r\n");
        /////////////////////////////////////////////////////////////////////////////////
        iPAGEService iPAGEService = (iPAGEService) applicationContext.getBean("iPAGEService");
        iPAGEBean iPAGEBean = new iPAGEBean();
        if (exp_peak == 2) {
            iPAGEBean.setExpfile(remote_exp);
        } else {
            FileUtil fileUtil1 = new FileUtil();
            String temp = fileUtil1.Result_path();
            File file = new File(remote_peak);
            String name = file.getName().substring(0, file.getName().length() - 3);
            HOMERAction homerAction = new HOMERAction();
            homerAction.setInput_HOMER_peak(remote_peak);
            homerAction.setHOMER_genome(species_select);
            homerAction.setInput_HOMER_path(temp);
            homerAction.HOMER_anno();
            FileTools fileTools = new FileTools();
            fileTools.read(temp + "/" + name + "txt", temp + "/Result." + "exp");
            iPAGEBean.setExpfile(temp + "/Result." + "exp");
        }
        if (species_select == 1) {
            iPAGEBean.setSpecies("human");
        } else if (species_select == 2) {
            iPAGEBean.setSpecies("yeast");
        } else if (species_select == 3) {
            iPAGEBean.setSpecies("worm");
        } else if (species_select == 4) {
            iPAGEBean.setSpecies("rat");
        } else if (species_select == 5) {
            iPAGEBean.setSpecies("pombe");
        } else if (species_select == 6) {
            iPAGEBean.setSpecies("mouse");
        } else if (species_select == 7) {
            iPAGEBean.setSpecies("malaria");
        } else if (species_select == 8) {
            iPAGEBean.setSpecies("drosophila");
        } else if (species_select == 9) {
            iPAGEBean.setSpecies("ciona");
        } else if (species_select == 10) {
            iPAGEBean.setSpecies("chicken");
        } else if (species_select == 11) {
            iPAGEBean.setSpecies("calbicans");
        } else {
            iPAGEBean.setSpecies("arabidopsis");
        }
        if (profile_type == 1) {
            iPAGEBean.setType("continuous");
        } else {
            iPAGEBean.setType("discrete");
        }
        iPAGEService.setiPAGEBean(iPAGEBean);
        stdoutlist = iPAGEService.iPAGE();

            //将结果压缩
            FileUtil fileUtil2=new FileUtil();
            fileUtil2.ZipMultiFile("/home/bio/dataset/" + JobId, "/home/bio/dataset/" + JobId + ".zip");

<<<<<<< HEAD
        flag = "3";
=======
        flag = "5";
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
        flag_son = "5";
    }
        flag_validate="1";
        return SUCCESS;
    }
    public  void appendMethodB(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void validate(){
<<<<<<< HEAD
=======

>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
        if(exp_peak==1){
            if(input_peakfile.equals("")){
                this.addFieldError("input_peakfile", "Please input peak file.");
            }
        }
        else{
            if(input_exp.equals("")){
                this.addFieldError("input_exp", "Please input peak file.");
            }
        }
<<<<<<< HEAD
        try{
            UploadUtil uploadUtil2=new UploadUtil();
            if(!uploadUtil2.Check(ipage_fileFileName,ipage_file)){
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
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
     /*   xmlUtil xmlUtil=new xmlUtil();
        xmlUtil.login_validate();*/
        flag="3";
        flag_son="5";
        flag_validate="2";
    }
<<<<<<< HEAD
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
=======
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
}
