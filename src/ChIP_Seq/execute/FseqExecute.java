package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.FseqBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/27/16.
 */
public class FseqExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void Fseq_execute(FseqBean fseqBean){
        File temp=new File(fseqBean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "fseq");
        String cmd1 =commandline+" "+fseqBean.getOption()+" -o "+fseqBean.getPath()+" -of bed "+fseqBean.getTagfile()+" "+fseqBean.getControlfile();
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
