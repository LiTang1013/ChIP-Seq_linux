package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.PePrBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/12/16.
 */
public class PePrExecute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private  String stdoutlist;

    public void PePr_execute(PePrBean pePrBean){
        File temp=new File(pePrBean.getTagfile1());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "pepr");
        String cmd1 = commandline+" -i " +pePrBean.getTagfile1()+","+pePrBean.getTagfile2() + "  -c  " +pePrBean.getControlfile1()+","+pePrBean.getControlfile2()+ " -n "+out+".bed"+" -f "+pePrBean.getFormat()+" "+pePrBean.getOption()+" --output-directory "+pePrBean.getPath();
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
