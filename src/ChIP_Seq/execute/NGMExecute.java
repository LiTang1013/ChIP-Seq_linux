package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.NGMBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/26/16.
 */
public class NGMExecute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private String stdoutlist;

    public void NGM_execute(NGMBean ngmBean){
        File temp;
        if(ngmBean.getType()==1){
            temp=new File(ngmBean.getReads_single());
        }
        else{
            temp=new File(ngmBean.getReads_1());
        }
        String out = temp.getName().substring(0, temp.getName().length()- 5);
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "ngm");
        if(ngmBean.getType()==1){
            cmd1 = commandline+" -r " + ngmBean.getReference()+" -q "+ngmBean.getReads_single()+" "+ngmBean.getOption()+" -o "+ngmBean.getPath()+"/"+out+"sam";
        }
        else{
            cmd1=commandline+" -r " + ngmBean.getReference()+ " -1 "+ngmBean.getReads_1()+" -2 "+ngmBean.getReads_2()+" "+ngmBean.getOption()+" -o "+ngmBean.getPath()+"/"+out+"sam";
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
