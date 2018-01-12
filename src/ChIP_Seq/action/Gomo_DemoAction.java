package ChIP_Seq.action;

import ChIP_Seq.FileUtil;
import ChIP_Seq.xmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by USER on 2017/4/26.
 */
public class Gomo_DemoAction extends ActionSupport{
    private String flag,flag_son;

    public String getFlag_son() {
        return flag_son;
    }

    public void setFlag_son(String flag_son) {
        this.flag_son = flag_son;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String Demo() throws Exception{
        try {
            Thread.sleep(5000);                 //1000 毫秒，也就是1秒.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        //生成运行起始时间
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String time=format.format(date);
        //构建session
        xmlUtil xmlUtil = new xmlUtil();
        xmlUtil.creatSession("JobId_annotatePeaks_demo",time);
        //写入XML文件
        xmlUtil.xmlAdd_Jobs("JobId_annotatePeaks_demo" ,"H3K4me3.bed", "annotatePeaks", "","email",time);

        flag="2";
        flag_son="3";
        return SUCCESS;
    }

}
