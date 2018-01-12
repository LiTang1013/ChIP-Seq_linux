package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.BamCoverageBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 11/27/16.
 */
public class BamCoverageExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void BamCoverage_Execute(BamCoverageBean bamCoverageBean){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bamCoverage");
        if(bamCoverageBean.getConvert_sam()==1){
            File name=new File(bamCoverageBean.getConvert_file());
            String name_bam=name.getName().substring(0,name.getName().length()-4);
            String samtools=GetProperty.getPropertyByName("Config","samtools");
            String cmd1 = samtools+" view -b "+bamCoverageBean.getConvert_file()+" -o "+bamCoverageBean.getConvert_result()+"/"+name_bam+".bam";
            System.out.println(cmd1);
            BaseExecute util = new BaseExecute();
            util.executeCommand(cmd1);
            StringBuffer sb=new StringBuffer();
            for(String item:util.getErroroutList()){
                sb.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb.toString();
            printList(util.getStdoutList());
            System.out.println("--------------------");
            printList(util.getErroroutList());
            //////////////////////////////////////////////////////////////////
            String cmd2= samtools+" sort "+bamCoverageBean.getConvert_result()+"/"+name_bam+".bam -o "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bam";
            System.out.println(cmd2);
            BaseExecute util1= new BaseExecute();
            util1.executeCommand(cmd2);
            printList(util1.getStdoutList());
            StringBuffer sb1=new StringBuffer();
            for(String item:util1.getErroroutList()){
                sb1.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb1.toString();
            System.out.println("--------------------");
            printList(util1.getErroroutList());
            /////////////////////////////////////////////////////////////////
            String cmd3= samtools+" index "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bam "+bamCoverageBean.getConvert_result()+"/"+name_bam+".bai";
            System.out.println(cmd3);
            BaseExecute util2= new BaseExecute();
            util2.executeCommand(cmd3);
            printList(util2.getStdoutList());
            StringBuffer sb2=new StringBuffer();
            for(String item:util2.getErroroutList()){
                sb2.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb2.toString();
            System.out.println("--------------------");
            printList(util2.getErroroutList());
            /////////////////////////////////////////////////////////////////
            String cmd4;
            if(bamCoverageBean.getConvert_for()==1){
                 cmd4=commandline+" --bam "+bamCoverageBean.getConvert_result()+"/"+name_bam+".bai"+" --outFileName "+name_bam+".bedgraph --outFileFormat bedgraph";
            }
            else{
                 cmd4=commandline+" --bam "+bamCoverageBean.getConvert_result()+"/"+name_bam+".bai"+" --outFileName "+name_bam+".bigwig --outFileFormat bigwig";
            }
            System.out.println(cmd4);
            BaseExecute util3 = new BaseExecute();
            util3.executeCommand(cmd3);
            printList(util3.getStdoutList());
            StringBuffer sb3=new StringBuffer();
            for(String item:util3.getErroroutList()){
                sb3.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb3.toString();
            System.out.println("--------------------");
            printList(util3.getErroroutList());
        }
        else{
            File name=new File(bamCoverageBean.getConvert_file());
            String name_bam=name.getName().substring(0,name.getName().length()-4);
            String samtools=GetProperty.getPropertyByName("Config","samtools");
            String cmd2= samtools+" sort "+bamCoverageBean.getConvert_file()+" -o "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bam";
            System.out.println(cmd2);
            BaseExecute util1= new BaseExecute();
            util1.executeCommand(cmd2);
            printList(util1.getStdoutList());
            StringBuffer sb1=new StringBuffer();
            for(String item:util1.getErroroutList()){
                sb1.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb1.toString();
            System.out.println("--------------------");
            printList(util1.getErroroutList());
            /////////////////////////////////////////////////////////////////
            String cmd3= samtools+" index -b "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bam "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bam.bai";
            System.out.println(cmd3);
            BaseExecute util2= new BaseExecute();
            util2.executeCommand(cmd3);
            printList(util2.getStdoutList());
            StringBuffer sb2=new StringBuffer();
            for(String item:util2.getErroroutList()){
                sb2.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb2.toString();
            System.out.println("--------------------");
            printList(util2.getErroroutList());


            String cmd4;
            if(bamCoverageBean.getConvert_for()==1){
                cmd4=commandline+" --bam "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bam.bai"+" --outFileName "+name_bam+".bedgraph --outFileFormat bedgraph";
            }
            else{
                cmd4=commandline+" --bam "+bamCoverageBean.getConvert_result()+"/"+name_bam+"_sort.bai"+" --outFileName "+name_bam+".bigwig --outFileFormat bigwig";
            }
            System.out.println(cmd4);
            BaseExecute util3 = new BaseExecute();
            util3.executeCommand(cmd4);
            printList(util3.getStdoutList());
            StringBuffer sb3=new StringBuffer();
            for(String item:util3.getErroroutList()){
                sb3.append(item+"\n");
            }
            stdoutlist=stdoutlist+sb3.toString();
            System.out.println("--------------------");
            printList(util3.getErroroutList());
        }
    }
    public static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}
