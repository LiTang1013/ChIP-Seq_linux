package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.PeakRangerBean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/8 0008.
 */
public class PeakRangerExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void PeakRanger_Execute(PeakRangerBean peakRangerBean){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "peakranger");
        String cmd1 =commandline+" "+peakRangerBean.getSelect_peakranger()+" --format "+peakRangerBean.getFormate()+" "+peakRangerBean.getTagfile()+" "+peakRangerBean.getControlfile()+" "+peakRangerBean.getPath()+"/"+peakRangerBean.getName()+" "+peakRangerBean.getOption();
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
