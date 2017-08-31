package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.HOMERBean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lily on 10/29/16.
 */
public class    HOMERExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void HOMER_execute(HOMERBean homerBean){
        String cmd1 ="findMotifsGenome.pl "+homerBean.getPeak()+" "+homerBean.getGenome()+" "+homerBean.getPath()+" -size "+homerBean.getSize()+" "+homerBean.getOption();
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
        String commandline = GetProperty.getPropertyByName("Config", "apache");
        String cmd2 ="cp"+" -R "+homerBean.getPath()+" "+commandline+"/htmlReport/homer";
        System.out.println(cmd2);
        BaseExecute util1 = new BaseExecute();
        util1.executeCommand(cmd2);
        printList(util1.getStdoutList());
        System.out.println("--------------------");
        printList(util1.getErroroutList());
    }
    public void HOMER_anoo(HOMERBean homerBean) throws IOException{
        String temp=homerBean.getPath();
        File temp1=new File(temp);
        if(!temp1.exists()){temp1.mkdirs();}
        File temp1_name=new File(homerBean.getPeak());
        String fileName1=temp1_name.getName().substring(0,temp1_name.getName().length()-4)+"_1.sh";
        File file1 = new File(temp1,fileName1);
        if(!file1.exists()) {
            file1.createNewFile();
        }
        else{
            file1.delete();
            file1.createNewFile();
        }
        appendMethodB(temp1 + "/" + fileName1, "/home/bio/software/homer/bin/annotatePeaks.pl "+homerBean.getPeak()+" "+homerBean.getGenome()+" > "+homerBean.getPath()+"/"+temp1_name.getName().substring(0,temp1_name.getName().length()-3)+"txt"+ "\n");

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