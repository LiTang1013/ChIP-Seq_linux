package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.AREMBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/27/16.
 */
public class AREMExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void AREM_execute(AREMBean aremBean){
        File temp=new File(aremBean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "arem");
        String cmd1 =commandline+" "+aremBean.getTagfile()+" -c "+aremBean.getControlfile()+" -n "+aremBean.getPath()+"/"+out+" "+aremBean.getOption();
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
