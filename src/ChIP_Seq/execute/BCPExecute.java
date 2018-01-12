package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.BCPBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/12/16.
 */
public class BCPExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void BCP_execute(BCPBean bcpBean){
        File temp=new File(bcpBean.getTagfile());
        String out = temp.getName().substring(0, temp.getName().length()- 4);
        String cmd1;
        String commandline1;
        commandline1 = GetProperty.getPropertyByName("Config", "BCP_HM");
        String commandline2;
        commandline2 = GetProperty.getPropertyByName("Config","BCP_TF");
        if(bcpBean.getType()==1){
             cmd1 =commandline1+"  -1 " + bcpBean.getTagfile() + "  -2  " + bcpBean.getControlfile()+" "+bcpBean.getOption()+" -3 "+bcpBean.getPath()+"/"+out+".bed";
        }
        else{
             cmd1 =commandline2+"  -1 " + bcpBean.getTagfile() + "  -2  " + bcpBean.getControlfile()+" "+bcpBean.getOption()+" -3 "+bcpBean.getPath()+"/"+out+".bed";
        }
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
