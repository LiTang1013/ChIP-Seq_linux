package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.BroadPeakBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/27/16.
 */
public class BroadPeakExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void BroadPeak_execute(BroadPeakBean broadPeakBean){
        File temp=new File(broadPeakBean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 8);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "broadpeak");
        String cmd1 =commandline+"  -i "+broadPeakBean.getTagfile()+" -m "+broadPeakBean.getPath()+"/"+out+" "+broadPeakBean.getOption()+" -t unsupervised ";
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
    public static void printList(List<String> list){
        for (String string : list) {
            System.out.println(string);
        }
    }
}
