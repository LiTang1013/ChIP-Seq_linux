package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.GOMoBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lily on 5/10/16.
 */
public class GOMoExecute {
    private String  stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void GOMo_exe(GOMoBean goMoBean){
        String cmd1 = "annotatePeaks.pl "+goMoBean.getPeak()+" "+goMoBean.getGenome()+" -genomeOntology "+goMoBean.getPath();
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

        String commandline = GetProperty.getPropertyByName("Config", "apache");
        String cmd2 ="cp"+" -R "+goMoBean.getPath()+" "+commandline+"/htmlReport/go";
        System.out.println(cmd2);
        BaseExecute util1 = new BaseExecute();
        util1.executeCommand(cmd2);
        printList(util1.getStdoutList());
        System.out.println("--------------------");
        printList(util1.getErroroutList());

    }
    public static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}
