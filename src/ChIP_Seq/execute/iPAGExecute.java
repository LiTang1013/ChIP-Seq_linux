package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.iPAGEBean;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by lily on 11/3/16.
 */
public class iPAGExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void iPAGE_execute(iPAGEBean iPAGEBean) throws IOException{
        String temp=iPAGEBean.getExpfile().substring(0,iPAGEBean.getExpfile().length()-4)+".sh";
        File temp1=new File(temp);
        String commandline;
        commandline= GetProperty.getPropertyByName("Config", "iPAGE");
        if(!temp1.exists()) {
            temp1.createNewFile();
        }
        else{
            temp1.delete();
            temp1.createNewFile();
        }
        appendMethodB(temp,"export PAGEDIR="+commandline + "\n");
        appendMethodB(temp,"perl /home/bio/software/iPAGE/page.pl --expfile="+iPAGEBean.getExpfile()+" --species="+iPAGEBean.getSpecies()+" --exptype="+iPAGEBean.getType());

        String cmd1="/bin/sh "+temp;
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
        String commandline1 = GetProperty.getPropertyByName("Config", "apache");
        String cmd2 ="cp"+" -R "+iPAGEBean.getExpfile().substring(0,iPAGEBean.getExpfile().length())+"_PAGE"+" "+commandline1+"/htmlReport/iPAGE";
        System.out.println(cmd2);
        BaseExecute util2 = new BaseExecute();
        util2.executeCommand(cmd2);
        printList(util2.getStdoutList());
        System.out.println("--------------------");
        printList(util2.getErroroutList());
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
