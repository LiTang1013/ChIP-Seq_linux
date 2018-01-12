package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.Bowtie2Bean;
import ChIP_Seq.bean.SamToolsBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily on 4/14/16.
 */
public class SamToolsExecute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private String stdoutlist;

    public void Samtools_execute(SamToolsBean samToolsBean) {
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "samtools");
        if(samToolsBean.getType()==1){
            File sam=new File(samToolsBean.getInput_sam());
            String sam_name=sam.getName().substring(0,sam.getName().length()-4);
            cmd1 = commandline+"   view -bS " +samToolsBean.getInput_sam()+ " -o "+samToolsBean.getInput_bam()+"/"+sam_name+".bam";
        }
        else{
            File bam=new File(samToolsBean.getInput_bam());
            String bam_name=bam.getName().substring(0,bam.getName().length()-4);
            cmd1 = commandline+"   view -h " +samToolsBean.getInput_bam()+ " -o "+samToolsBean.getInput_sam()+"/"+bam_name+".sam";
        }
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
    public void Samtools_sort(SamToolsBean samToolsBean) {
        String cmd1;
        String sort=samToolsBean.getInput_samtools_sort().substring(0,samToolsBean.getInput_samtools_sort().length() - 4);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "samtools");
        cmd1 = commandline+" sort "+samToolsBean.getInput_samtools_sort()+" -o "+sort+"_sort.bam";
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
    public void Samtools_index(SamToolsBean samToolsBean){
        String cmd1;
        if(samToolsBean.getIndex_type()==1){
            String commandline;
            commandline = GetProperty.getPropertyByName("Config", "samtools");
            cmd1 = commandline+" faidx " +samToolsBean.getInput_samtools_index();
        }
        else if(samToolsBean.getIndex_type()==2){
            File temp=new File(samToolsBean.getInput_samtools_index());
            String commandline;
            commandline = GetProperty.getPropertyByName("Config", "samtools");
            cmd1 =commandline+ " index -b " + samToolsBean.getInput_samtools_index()+" "+samToolsBean.getInput_samtools_indexpath()+"/"+temp.getName() + ".bai";
        }
        else {
            File temp=new File(samToolsBean.getInput_samtools_index());
            String commandline;
            commandline = GetProperty.getPropertyByName("Config", "samtools");
            cmd1 = commandline+" index -c " + samToolsBean.getInput_samtools_index()+" "+samToolsBean.getInput_samtools_indexpath()+"/"+temp.getName() + ".cai";
        }
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
