package ChIP_Seq.execute;
import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.Bowtie2Bean;
import ChIP_Seq.bean.Bowtie2Bean_pair;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2016/4/9 0009.
 */
public class Bowtie2Execute {
/**/
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void Bowtie2_build(Bowtie2Bean bowtie2Bean) {
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie2_build");
        String str = bowtie2Bean.getReference().substring(0, bowtie2Bean.getReference().length() - 6);
        String cmd1 = commandline+" " + bowtie2Bean.getReference()+ " "+str;
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
    public void Bowtie2_align(Bowtie2Bean bowtie2Bean){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie2");
        String str = bowtie2Bean.getReference().substring(0, bowtie2Bean.getReference().length() - 6);
        File read=new File(bowtie2Bean.getReads());
        String read_name=read.getName().substring(0,read.getName().length()-6);
        String cmd1 = commandline+"  -x "+str+" "+ bowtie2Bean.getReads()+ " "+bowtie2Bean.getOption()+" -S "+bowtie2Bean.getPath()+"/"+read_name+".sam";
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
    public void Bowtie2_build_pair(Bowtie2Bean_pair bowtie2Bean_pair) {
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie2_build");
        String str = bowtie2Bean_pair.getReference().substring(0, bowtie2Bean_pair.getReference().length() - 6);
        String cmd1 = commandline+" " + bowtie2Bean_pair.getReference()+ " "+str;
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
    public void Bowtie2_align_pair(Bowtie2Bean_pair bowtie2Bean_pair){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "bowtie2");
        String str = bowtie2Bean_pair.getReference().substring(0, bowtie2Bean_pair.getReference().length() - 6);
        File read=new File(bowtie2Bean_pair.getReads_left());
        String read_name=read.getName().substring(0,read.getName().length()-6);
        String cmd1 =commandline+ "  -x "+str+" -1 " + bowtie2Bean_pair.getReads_left()+ " -2 "+bowtie2Bean_pair.getReads_right()+" "+bowtie2Bean_pair.getOption()+" -S "+bowtie2Bean_pair.getPath()+"/"+read_name+".sam";
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
