package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.SubreadBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/24/16.
 */
public class SubreadExecute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private String stdoutlist;

    public void Subread_index(SubreadBean subreadBean){
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "subread_build");
       /* File read;
        if(subreadBean.getRead_type()==1){
            read=new File(subreadBean.getReference());
        }
        else{
            read=new File(subreadBean.getReference());
        }*/
        String read_name=subreadBean.getReference().substring(0,subreadBean.getReference().length()-6);
        cmd1 = commandline+" "+subreadBean.getOption_index()+" -o "+read_name+" "+subreadBean.getReference();
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
    public void Subread_align(SubreadBean subreadBean){
        String cmd1;
        String commandline;
       /* File read;
        if(subreadBean.getRead_type()==1){
            read=new File(subreadBean.getReference());
        }
        else{
            read=new File(subreadBean.getReference());
        }*/
        String read_name=subreadBean.getReference().substring(0,subreadBean.getReference().length()-6);
        commandline = GetProperty.getPropertyByName("Config", "subread_align");
        if(subreadBean.getRead_type()==1){
            cmd1 = commandline+" -i "+read_name+" -r "+subreadBean.getRead_single()+" "+subreadBean.getOption_align()+" -o "+subreadBean.getPath()+"/"+read_name+".sam -t 1";
        }
        else{
            cmd1 = commandline+" -i "+read_name+" -r "+subreadBean.getRead_1()+" -R "+subreadBean.getRead_2()+" "+subreadBean.getOption_align()+" -o "+subreadBean.getPath()+"/"+read_name+".sam -t 1";
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
