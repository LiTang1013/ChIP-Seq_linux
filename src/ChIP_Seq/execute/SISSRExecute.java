package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.SISSRBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/18/16.
 */
public class SISSRExecute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private String stdoutlist;

    public void SISSR_execute(SISSRBean sissrBean){
        File temp=new File(sissrBean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "sissrs");
        cmd1 = commandline+" -i " +sissrBean.getTagfile() + " -b " +sissrBean.getControlfile()+" -s "+sissrBean.getSize()+" "+sissrBean.getOption()+" -o "+sissrBean.getPath()+"/"+out+".bed";
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
