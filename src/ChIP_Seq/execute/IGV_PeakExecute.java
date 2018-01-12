package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.IGV_util;
import ChIP_Seq.bean.IGVBean;
import ChIP_Seq.bean.IGV_PeakBean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by lily on 11/19/16.
 */
public class IGV_PeakExecute {
    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    private String stdoutlist;

    public void IGV_indexFa(IGV_PeakBean igv_peakBean){
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" faidx "+igv_peakBean.getReference();
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
    public void IGV_treatment(IGV_PeakBean igv_peakBean){
        System.out.println(igv_peakBean.getTreatment());
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "bamCoverage");
        String bam_str = igv_peakBean.getTreatment().substring(0, igv_peakBean.getTreatment().length()- 4);
        String cmd1 = commandline+" --bam "+bam_str+"_sort.bam"+" --outFileName "+bam_str+".bedgraph --outFileFormat bedgraph";
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
    public void IGV_control(IGV_PeakBean igv_peakBean){
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "bamCoverage");
        String bam_str=igv_peakBean.getControl().substring(0,igv_peakBean.getControl().length()-4);
        String cmd1 = commandline+" --bam "+bam_str+"_sort.bam"+" --outFileName "+bam_str+".bedgraph --outFileFormat bedgraph";
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
    public void IGV_samtools_view(IGV_PeakBean igv_peakBean){
        String commandline;
        File treat=new File(igv_peakBean.getTreatment());
        System.out.println(igv_peakBean.getTreatment());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" view -b "+igv_peakBean.getTreatment()+" -o "+igv_peakBean.getPath()+"/"+name+".bam";
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
    public void IGV_samtools_view_control(IGV_PeakBean igv_peakBean){
        String commandline;
        File treat=new File(igv_peakBean.getControl());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" view -b "+igv_peakBean.getControl()+" -o "+igv_peakBean.getPath()+"/"+name+".bam";
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
    public void IGV_samtools_sort(IGV_PeakBean igv_peakBean){
        String commandline;
        File treat=new File(igv_peakBean.getTreatment());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" sort "+igv_peakBean.getPath()+"/"+name+".bam -o "+igv_peakBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_samtools_sort_control(IGV_PeakBean igv_peakBean){
        String commandline;
        File control=new File(igv_peakBean.getControl());
        String name=control.getName().substring(0, control.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" sort "+igv_peakBean.getPath()+"/"+name+".bam -o "+igv_peakBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_samtools_index(IGV_PeakBean igv_peakBean){
        String commandline;
        File treat=new File(igv_peakBean.getTreatment());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" index "+igv_peakBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_samtools_index_control(IGV_PeakBean igv_peakBean){
        String commandline;
        File control=new File(igv_peakBean.getControl());
        String name=control.getName().substring(0, control.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" index "+igv_peakBean.getPath()+"/"+name+"_sort.bam";
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

    public void IGV_peakcalling(IGV_PeakBean igv_peakBean) throws Exception{
        File temp=new File(igv_peakBean.getPath());
        if(!temp.exists()){temp.mkdirs();}
        File temp_name=new File(igv_peakBean.getReference());
        String fileName=temp_name.getName().substring(0,temp_name.getName().length()-6)+"_peak_bash.sh";
        File file = new File(temp,fileName);
        String bam_str = igv_peakBean.getTreatment().substring(0, igv_peakBean.getTreatment().length() - 4);
        String bam_str2 = igv_peakBean.getControl().substring(0, igv_peakBean.getControl().length() - 4);
        if(!file.exists()) {
            file.createNewFile();
        }
        else{
            file.delete();
            file.createNewFile();
        }
        String scope=igv_peakBean.getScope().replace(':','_');
        String scope1=scope.replace('|', '_');
        appendMethodB(temp + "/" + fileName, "new " + "\n");
        appendMethodB(temp + "/" + fileName, "genome " + igv_peakBean.getReference() + "\n");
        appendMethodB(temp + "/" + fileName, "load " + bam_str + ".bedgraph" + "\n");
        appendMethodB(temp + "/" + fileName, "load " + bam_str2 + ".bedgraph" + "\n");
        appendMethodB(temp + "/" + fileName, "load " + igv_peakBean.getPeak() + "\n");
        appendMethodB(temp + "/" + fileName, "snapshotDirectory " + igv_peakBean.getPath() + "\n");
        appendMethodB(temp + "/" + fileName, "goto " + igv_peakBean.getScope() + "\n");
        appendMethodB(temp + "/" + fileName, "sort position" + "\n");
        appendMethodB(temp + "/" + fileName, "collapse" + "\n");
        appendMethodB(temp+"/"+fileName,"snapshot "+scope1+"_peakcalling.png"+"\n");
        appendMethodB(temp + "/" + fileName, "exit");

        File temp1=new File(igv_peakBean.getPath());
        if(!temp1.exists()){temp1.mkdirs();}
        File temp1_name=new File(igv_peakBean.getReference());
        String fileName1=temp1_name.getName().substring(0,temp_name.getName().length()-6)+"_peak.sh";
        File file1 = new File(temp1,fileName1);
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "igv");
        if(!file1.exists()) {
            file1.createNewFile();
        }
        else{
            file1.delete();
            file1.createNewFile();
        }
        appendMethodB(temp1 + "/" + fileName1, commandline + " -b " + igv_peakBean.getPath() + "/" + fileName+" -g "+igv_peakBean.getReference());

        String cmd1="/bin/sh "+temp1+"/"+fileName1;
        System.out.println(cmd1);
        BaseExecute util1 = new BaseExecute();
        util1.executeCommand(cmd1);
        printList(util1.getStdoutList());
        StringBuffer sb=new StringBuffer();
        for(String item:util1.getErroroutList()){
            sb.append(item+"\n");
        }
        stdoutlist=stdoutlist+sb.toString();
        System.out.println("--------------------------");
        printList(util1.getErroroutList());

    }
    public static void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    public static void appendMethodB(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
