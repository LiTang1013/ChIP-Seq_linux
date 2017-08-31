package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.diffRepsBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/15/16.
 */
public class diffRepsExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void diffReps_execute(diffRepsBean diffRepsBean){
        File temp=new File(diffRepsBean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "diffreps");
        cmd1 = commandline+" -tr " + diffRepsBean.getTagfile() + "  -co  " + diffRepsBean.getControlfile()+" "+diffRepsBean.getOption()+" --report "+diffRepsBean.getPath()+"/"+out+"_out.txt"+" --meth gt -gn "+diffRepsBean.getGn();
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

