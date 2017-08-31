package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.IGV_util;
import ChIP_Seq.bean.IGVBean;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * Created by lily on 6/9/16.
 */
public class IGVExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void IGV_indexFa(IGVBean igvBean){
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" faidx "+igvBean.getReference();
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

    public void IGV_treatment(IGVBean igvBean){
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "bamCoverage");
        String bam_str = igvBean.getTreatment().substring(0, igvBean.getTreatment().length()- 4);
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
    public void IGV_control(IGVBean igvBean){
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "bamCoverage");
        String bam_str=igvBean.getControl().substring(0,igvBean.getControl().length()-4);
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
    public void IGV_samtools_view(IGVBean igvBean){
        String commandline;
        File treat=new File(igvBean.getTreatment());
        System.out.println(igvBean.getTreatment());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" view -b "+igvBean.getTreatment()+" -o "+igvBean.getPath()+"/"+name+".bam";
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
    public void IGV_samtools_view_control(IGVBean igvBean){
        String commandline;
        File treat=new File(igvBean.getControl());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" view -b "+igvBean.getControl()+" -o "+igvBean.getPath()+"/"+name+".bam";
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
    public void IGV_samtools_sort(IGVBean igvBean){
        String commandline;
        File treat=new File(igvBean.getTreatment());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" sort "+igvBean.getPath()+"/"+name+".bam -o "+igvBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_samtools_sort_control(IGVBean igvBean){
        String commandline;
        File control=new File(igvBean.getControl());
        String name=control.getName().substring(0, control.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" sort "+igvBean.getPath()+"/"+name+".bam -o "+igvBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_samtools_index(IGVBean igvBean){
        String commandline;
        File treat=new File(igvBean.getTreatment());
        String name=treat.getName().substring(0, treat.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" index "+igvBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_samtools_index_control(IGVBean igvBean){
        String commandline;
        File control=new File(igvBean.getControl());
        String name=control.getName().substring(0, control.getName().length()- 4);
        commandline= GetProperty.getPropertyByName("Config", "samtools");
        String cmd1 = commandline+" index "+igvBean.getPath()+"/"+name+"_sort.bam";
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
    public void IGV_summit(IGVBean igvBean) throws Exception{
        File temp=new File(igvBean.getPath());
        if(!temp.exists()){temp.mkdirs();}
        File temp_name=new File(igvBean.getReference());
        String fileName=temp_name.getName().substring(0,temp_name.getName().length()-6)+"_Mapping_bash.sh";
        File file = new File(temp,fileName);
        File treat = new File(igvBean.getTreatment());
        String name = treat.getName().substring(0, treat.getName().length() - 4);
        if(!file.exists()) {
            file.createNewFile();
        }
        else{
            file.delete();
            file.createNewFile();
        }

        String scope=igvBean.getScope().replace("|", "_");
        String scope1=scope.replace(":", "_");
            appendMethodB(temp + "/" + fileName, "new " + "\n");
         //   appendMethodB(temp + "/" + fileName, "genome " + igvBean.getReference() + "\n");
            appendMethodB(temp + "/" + fileName, "load " + igvBean.getPath() + "/" + name + "_sort.bam" + "\n");
            appendMethodB(temp + "/" + fileName, "snapshotDirectory " + igvBean.getPath() + "\n");
           // appendMethodB(temp+"/"+fileName,"snapshot "+scope1+"_mapping.png"+"\n");
            appendMethodB(temp + "/" + fileName, "goto " + igvBean.getScope() + "\n");
            appendMethodB(temp + "/" + fileName, "sort position" + "\n");
            appendMethodB(temp + "/" + fileName, "collapse" + "\n");
            appendMethodB(temp+"/"+fileName,"snapshot "+scope1+"_mapping.png"+"\n");
            appendMethodB(temp + "/" + fileName, "exit");


        File temp1=new File(igvBean.getPath());
        if(!temp1.exists()){temp1.mkdirs();}
        File temp1_name=new File(igvBean.getReference());
        String fileName1=temp1_name.getName().substring(0,temp_name.getName().length()-6)+"_Mapping.sh";
        File file1 = new File(temp1,fileName1);
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "igv");
        if(!file1.exists()) {
            file1.createNewFile();
        }
        else{
            file1.delete();
            file1.createNewFile();
        }
        appendMethodB(temp1 + "/" + fileName1, commandline + " -b " + igvBean.getPath() + "/" + fileName+" -g "+igvBean.getReference());

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


    public void IGV_peakcalling(IGVBean igvBean) throws IOException{
        File temp=new File(igvBean.getPath());
        if(!temp.exists()){temp.mkdirs();}
        File temp_name=new File(igvBean.getReference());
        String fileName=temp_name.getName().substring(0,temp_name.getName().length()-6)+"_peak_bash.sh";
        File file = new File(temp,fileName);
        String bam_str = igvBean.getTreatment().substring(0, igvBean.getTreatment().length() - 4);
        String bam_str2 = igvBean.getControl().substring(0, igvBean.getControl().length() - 4);
        if(!file.exists()) {
            file.createNewFile();
        }
        else{
            file.delete();
            file.createNewFile();
        }

        String scope=igvBean.getScope().replace(":", "_");
        String scope1=scope.replace("|", "_");
            appendMethodB(temp + "/" + fileName, "new " + "\n");
            appendMethodB(temp + "/" + fileName, "genome " + igvBean.getReference() + "\n");
            appendMethodB(temp + "/" + fileName, "load " + bam_str + ".bedgraph" + "\n");
            appendMethodB(temp + "/" + fileName, "load " + bam_str2 + ".bedgraph" + "\n");
            appendMethodB(temp + "/" + fileName, "load " + igvBean.getPeak() + "\n");
            appendMethodB(temp + "/" + fileName, "snapshotDirectory " + igvBean.getPath() + "\n");
          //  appendMethodB(temp+"/"+fileName,"snapshot "+scope1+"_peakcalling.png"+"\n");
            appendMethodB(temp + "/" + fileName, "goto " + igvBean.getScope() + "\n");
            appendMethodB(temp + "/" + fileName, "sort position" + "\n");
            appendMethodB(temp + "/" + fileName, "collapse" + "\n");
            appendMethodB(temp+"/"+fileName,"snapshot "+scope1+"_peakcalling.png"+"\n");
            appendMethodB(temp + "/" + fileName, "exit");

        File temp1=new File(igvBean.getPath());
        if(!temp1.exists()){temp1.mkdirs();}
        File temp1_name=new File(igvBean.getReference());
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
        appendMethodB(temp1 + "/" + fileName1, commandline + " -b " + igvBean.getPath() + "/" + fileName);

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
