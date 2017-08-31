package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.BWABean;
import ChIP_Seq.bean.BWABean_pair;

import java.io.*;
import java.util.List;

/**
 * Created by Administrator on 2016/4/18 0018.
 */
public class BWAExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void BWA_build(BWABean bwaBean){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bwa");
        String cmd1;
        if(bwaBean.getLong_short()==1){
            cmd1 = commandline+" index -a bwtsw " + bwaBean.getInput_BWA_reference();
        }
        else{
            cmd1 = commandline+" index -a  is " + bwaBean.getInput_BWA_reference();
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

    public void BWA_corodinate(BWABean bwaBean) {
       // File temp=new File(bwaBean.getInput_BWA_reference());
        String str_sai = bwaBean.getInput_BWA_reference().substring(0, bwaBean.getInput_BWA_reference().length() - 3);
        System.out.println(str_sai);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bwa");
        String cmd1 = commandline+" aln "+bwaBean.getOption()+" "+ bwaBean.getInput_BWA_reference() + " " + bwaBean.getInput_BWA_reads_single()+" -f "+str_sai+".sai";
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

    public void BWA_aln(BWABean bwaBean) {
      //  File temp=new File(bwaBean.getInput_BWA_reference());
        String str_sai = bwaBean.getInput_BWA_reference().substring(0, bwaBean.getInput_BWA_reference().length()- 3);
        File read=new File(bwaBean.getInput_BWA_reads_single());
        String read_name=read.getName().substring(0,read.getName().length()-5);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config","bwa");
        String cmd1 =commandline+" samse -f " + bwaBean.getInput_BWA_path()+"/"+read_name+"sam  "+ bwaBean.getInput_BWA_reference() + " " + str_sai + ".sai " + bwaBean.getInput_BWA_reads_single();
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
    public void BWA_build_pair(BWABean_pair bwaBean_pair){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bwa");
        String cmd1;
        if(bwaBean_pair.getLong_short()==1){
            cmd1 =commandline+" index -a bwtsw " + bwaBean_pair.getInput_BWA_reference();
        }
        else{
            cmd1 =commandline+" index -a is " + bwaBean_pair.getInput_BWA_reference();
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
    public void BWA_corordinate_pair1(BWABean_pair bwaBean_pair){
        String str_sai_left=bwaBean_pair.getInput_BWA_reads_pair1().substring(0, bwaBean_pair.getInput_BWA_reads_pair1().length() - 3);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bwa");
        String cmd1 =commandline+" aln " +bwaBean_pair.getOption()+" "+ bwaBean_pair.getInput_BWA_reference() + " " + bwaBean_pair.getInput_BWA_reads_pair1() + " -f " + str_sai_left + ".sai";
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
    public void BWA_corordinate_pair2(BWABean_pair bwaBean_pair){
        String str_sai_right=bwaBean_pair.getInput_BWA_reads_pair2().substring(0, bwaBean_pair.getInput_BWA_reads_pair2().length() - 3);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bwa");
        String cmd1 =commandline+" aln " +bwaBean_pair.getOption()+" "+ bwaBean_pair.getInput_BWA_reference() + " " + bwaBean_pair.getInput_BWA_reads_pair2() + " -f " + str_sai_right + ".sai ";
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
    public void BWA_aln_pair(BWABean_pair bwaBean_pair) {
        //String str_sai = bwaBean_pair.getInput_BWA_reference().substring(0, bwaBean_pair.getInput_BWA_reference().length() - 6);
        String str_sai_left=bwaBean_pair.getInput_BWA_reads_pair1().substring(0, bwaBean_pair.getInput_BWA_reads_pair1().length() - 6);
        String str_sai_right=bwaBean_pair.getInput_BWA_reads_pair2().substring(0, bwaBean_pair.getInput_BWA_reads_pair2().length() - 6);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bwa");
        File read=new File(bwaBean_pair.getInput_BWA_reads_pair1());
        String read_name=read.getName().substring(0,bwaBean_pair.getInput_BWA_reads_pair1().length()-5);
        String cmd1 = commandline+" sampe " + bwaBean_pair.getInput_BWA_reference() +" "+ str_sai_left + ".sai " +str_sai_right + ".sai "+bwaBean_pair.getInput_BWA_reads_pair1()+" "+bwaBean_pair.getInput_BWA_reads_pair2()+" "+bwaBean_pair.getInput_BWA_path()+"/"+read_name+".sam";
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
