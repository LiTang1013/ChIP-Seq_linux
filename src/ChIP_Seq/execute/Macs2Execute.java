package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.Macs2Bean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/10/16.
 */
public class Macs2Execute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private String stdoutlist;

    public void Macs2_execute(Macs2Bean macs2Bean) {
        File temp=new File(macs2Bean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "macs2");
        String cmd1 = commandline+" callpeak -t " + macs2Bean.getTagfile() + "  -c  " + macs2Bean.getControlfile()+ " --outdir "+ macs2Bean.getPath()+" -n "+out+" "+macs2Bean.getOption()+" --nomodel -f "+macs2Bean.getFormat();
        System.out.println(cmd1);
        BaseExecute util = new BaseExecute();
        util.executeCommand(cmd1);
        printList(util.getStdoutList());
        StringBuffer sb=new StringBuffer();
        for(String item:util.getErroroutList()){
            sb.append(item+"\n");
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
