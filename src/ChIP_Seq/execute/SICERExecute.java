package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.SICERBean;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4 0004.
 */
public class SICERExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void SICER_execute(SICERBean sicerBean) {
        StringBuilder sb = new StringBuilder();
        File temp = new File(sicerBean.getTagfile());
        while (temp.getParentFile() != null && temp.getParentFile().getName().length() != 0) {
            sb.insert(0, "/" + temp.getParentFile().getName());
            temp = temp.getParentFile();
        }
        sb.append("/");
        File temp2=new File(sicerBean.getTagfile());
        String tagfile=temp2.getName();
        File temp3=new File(sicerBean.getControlfile());
        String controlfile=temp3.getName();
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "sicer");
        String cmd1 = "sh "+commandline+"  "+ sb+" "+tagfile+" "+controlfile+" "+sicerBean.getPath()+" "+sicerBean.getOption();
        System.out.println(cmd1);
        BaseExecute util = new BaseExecute();
        util.executeCommand(cmd1);
        printList(util.getStdoutList());
        StringBuffer sb1=new StringBuffer();
        for(String item:util.getErroroutList()){
            sb1.append(item+"\n");
        }
        stdoutlist=stdoutlist+sb1.toString();
        System.out.println("--------------------");
        printList(util.getErroroutList());
    }
    public static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}
