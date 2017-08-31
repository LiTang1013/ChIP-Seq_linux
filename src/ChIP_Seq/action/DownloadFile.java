package ChIP_Seq.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
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
        Map<String ,Object> map = ActionContext.getContext().getParameters();
        String [] fName = (String[]) map.get("fileName");
        String fName1 = fName[0];
        contentType = "application/octet-stream";                           //文件下载的类型
        contentDisposition = "attachment; filename = "+fName1+"";
       // ServletContext servletContext = ServletActionContext.getServletContext();
        String fileName = "/home/bio/dataset/"+fName1;
        inputStream = new FileInputStream(fileName);
        contentLength = inputStream.available();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Downloads");
        return SUCCESS;
    }
}
