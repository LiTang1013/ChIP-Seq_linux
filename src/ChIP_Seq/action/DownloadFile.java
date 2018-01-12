package ChIP_Seq.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
<<<<<<< HEAD
import org.apache.struts2.dispatcher.HttpParameters;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
=======

import javax.servlet.ServletContext;
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by USER on 2017/6/24.
 */
public class DownloadFile extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String contentType ;//文件的类型
    private long contentLength ;//流的长度
    private String contentDisposition ;// 用于指定文件名的内容配置头值
    private InputStream inputStream;//读取文件的输入流

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String Download() throws IOException{
<<<<<<< HEAD
      //  HttpParameters parameters = ActionContext.getContext().getParameters();
      //  String fName1=parameters;
        HttpServletRequest req1 = ServletActionContext.getRequest();
        String fName1 = req1.getParameter("fileName");

       // String [] fName = (String[]) map.get("fileName");
       // String fName1 = fName[0];
        contentType = "application/octet-stream";                           //文件下载的类型
        contentDisposition = "attachment; filename = "+fName1+"";
        // ServletContext servletContext = ServletActionContext.getServletContext();
=======
        Map<String ,Object> map = ActionContext.getContext().getParameters();
        String [] fName = (String[]) map.get("fileName");
        String fName1 = fName[0];
        contentType = "application/octet-stream";                           //文件下载的类型
        contentDisposition = "attachment; filename = "+fName1+"";
       // ServletContext servletContext = ServletActionContext.getServletContext();
>>>>>>> e936dd87b716fe25aca999e6e8b1f4143e34194c
        String fileName = "/home/bio/dataset/"+fName1;
        inputStream = new FileInputStream(fileName);
        contentLength = inputStream.available();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Downloads");
        return SUCCESS;
    }
}
