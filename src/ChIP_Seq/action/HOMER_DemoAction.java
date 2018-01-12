package ChIP_Seq.action;

import ChIP_Seq.xmlUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by USER on 2017/4/26.
 */
public class HOMER_DemoAction extends ActionSupport {
    private String flag,flag_son,flag_validate;

    public String getFlag_validate() {
        return flag_validate;
    }

    public void setFlag_validate(String flag_validate) {
        this.flag_validate = flag_validate;
    }

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
<<<<<<< HEAD
        xmlUtil.creatSession("JobId_findMotifs_demo",time);
        //写入XML文件
        xmlUtil.xmlAdd_Jobs("JobId_findMotifs_demo","H3K4me3.bed", "findMotifs", "","email",time);

        flag="1";
=======
        xmlUtil.creatSession("JobId_findMotifs",time);
        //写入XML文件
        xmlUtil.xmlAdd_Jobs("JobId_findMotifs","H3K4me3.bed", "findMotifs", "","email",time);

        flag="2";
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
        flag_son="1";
        flag_validate="1";
        return SUCCESS;
    }
}
