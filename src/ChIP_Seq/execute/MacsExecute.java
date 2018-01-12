package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.MacsBean;
import com.opensymphony.xwork2.ActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by lily on 4/15/16.
 */
public class MacsExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void Macs_execute(MacsBean macsBean) {
        File temp = new File(macsBean.getInput_tagfile());
        String out = temp.getName().substring(0, temp.getName().length() - 4);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config","macs");
        String cmd1 = commandline+" -t " + macsBean.getInput_tagfile() + "  -c  " + macsBean.getInput_controlfile()+ " -n "+ macsBean.getInput_macs_path()+"/"+out+" "+macsBean.getOption()+" --keep-dup 1 --nomodel ";
        System.out.println(cmd1);
        BaseExecute util = new BaseExecute();
        util.executeCommand(cmd1);
        printList(util.getStdoutList());
        StringBuffer sb=new StringBuffer();
        for(String item:util.getErroroutList()){
            sb.append(item+"\n\r");
        }
        stdoutlist=stdoutlist+sb.toString();
        System.out.println("--------------------");
        printList(util.getErroroutList());
    }
    public static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}