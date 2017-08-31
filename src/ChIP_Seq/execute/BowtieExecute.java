package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.BowtieBean;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/5/6 0006.
 */
public class BowtieExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void Bowtie_build(BowtieBean bowtieBean) {
        //File temp=new File(bowtieBean.getReference());
        String str = bowtieBean.getReference().substring(0, bowtieBean.getReference().length() -6);
        System.out.println(str);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie_build");
        String cmd1 = commandline+" "+bowtieBean.getIndex_option()+" "+ bowtieBean.getReference()+ " "+str;
        System.out.println(cmd1);
        BaseExecute util=new BaseExecute();
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
    public void Bowtie_align(BowtieBean bowtieBean){
     //   File temp=new File(bowtieBean.getReference());
        String str = bowtieBean.getReference().substring(0, bowtieBean.getReference().length() - 6);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie");
        File read=new File(bowtieBean.getRead_1());
        String read_name=read.getName().substring(0,read.getName().length()-5);
        String cmd1 =commandline+ " "+bowtieBean.getInput_option()+" "+bowtieBean.getAli_option()+" "+bowtieBean.getReport_option()+" "+str+" " + bowtieBean.getRead_1()+" -S "+bowtieBean.getPath()+"/"+read_name+"sam";
        System.out.println(cmd1);
        BaseExecute util=new BaseExecute();
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
    public void Bowtie_align_pair(BowtieBean bowtieBean){
       // File temp=new File(bowtieBean.getReference());
        String str = bowtieBean.getReference().substring(0, bowtieBean.getReference().length() - 6);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie");
        File read=new File(bowtieBean.getRead_1());
        String read_name=read.getName().substring(0,read.getName().length()-5);
        String cmd1 = commandline+" "+bowtieBean.getInput_option()+" "+bowtieBean.getAli_option()+" "+bowtieBean.getReport_option()+" "+str+" -1 " + bowtieBean.getRead_1()+" -2 "+bowtieBean.getRead_2()+" -S "+bowtieBean.getPath()+"/"+read_name+"sam";
        System.out.println(cmd1);
        BaseExecute util=new BaseExecute();
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
