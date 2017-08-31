package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.FindPeaksBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/19/16.
 */
public class FindPeaksExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void FindPeaks_execute(FindPeaksBean findPeaksBean){
        File temp=new File(findPeaksBean.getFile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String cmd1,type;
        if(findPeaksBean.getType()==1){
            type="E";
        }
        else{
            type="B";
        }
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "findpeaks");
        cmd1 = "  java -jar "+commandline+" -aligner " +type+ " -input " +findPeaksBean.getFile()+" -output "+findPeaksBean.getPath()+" -eff_size "+findPeaksBean.getGenesize()+" -name "+out+" "+findPeaksBean.getOption();
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
