package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.BlastBean;

import java.io.File;
import java.util.List;

/**
 * Created by lily on 7/22/16.
 */
public class BlastExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void Blast_execute(BlastBean blastBean){
        String cmd1,type;
        if(blastBean.getType()==1){
            type="nucl";
        }
        else{
            type="prot";
        }
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "blast");
        cmd1 = commandline+"  -in " +blastBean.getReference()+" -parse_seqids -dbtype "+type ;
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
    public void Blast_align(BlastBean blastBean){
        File temp=new File(blastBean.getReads());
        String out = temp.getName().substring(0, temp.getName().length()-6);
        String cmd1;
        String commandline_n;
        commandline_n = GetProperty.getPropertyByName("Config", "blast_n");
        String commandline_p;
        commandline_p= GetProperty.getPropertyByName("Config", "blast_p");
        if(blastBean.getType()==1){
            cmd1 = commandline_n+" -db " +blastBean.getReference()+" -query "+blastBean.getReads()+" -out "+blastBean.getPath()+"/"+out+".sam";
        }
        else{
            cmd1 = commandline_p+" -db " +blastBean.getReference()+" -query "+blastBean.getReads()+" -out "+blastBean.getPath()+"/"+out+".sam";
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
