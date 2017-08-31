package ChIP_Seq;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6 0006.
 */
public class UploadUtil {
    public List<String>  upload(List<String> FileName,List<File> file) throws Exception{
        FileUtil fileUtil=new FileUtil();
        List<String> Upload_path=new LinkedList<String>();
        for(int i=0;i<file.size();i++){
            System.out.println("###########################"+i+"#########################");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@"+FileName.get(i));
            String path=fileUtil.Upload_path()+"/"+FileName.get(i);
            OutputStream os=new FileOutputStream(new File(path));
            InputStream is=new FileInputStream(file.get(i));
            byte[] buf=new byte[1024];
            int length=0;
            while(-1!=(length=is.read(buf))){
                os.write(buf,0,length);
            }
            is.close();
            os.close();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$" + path);
            Upload_path.add(path);
        }
        return Upload_path;
    }
}
