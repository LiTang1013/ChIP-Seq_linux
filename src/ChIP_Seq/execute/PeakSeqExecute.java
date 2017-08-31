package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.PeakSeqBean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7 0007.
 */
public class PeakSeqExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }

    public void PeakSeq_mkdir_ChIP(PeakSeqBean peakSeqBean){
        String cmd1;
        cmd1="mkdir "+peakSeqBean.getPaht()+"/"+peakSeqBean.getOutput_name() + "_Pol1_ChIP";
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
    public void PeakSeq_mkdir_Input(PeakSeqBean peakSeqBean){
        String cmd1;
        cmd1="mkdir "+peakSeqBean.getPaht()+"/"+peakSeqBean.getOutput_name() + "_Pol1_Input";
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
    public void PeakSeq_processed_tag(PeakSeqBean peakSeqBean) {
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "peakseq");
        if (peakSeqBean.getFormat() == 1) {
            cmd1 = commandline+" -preprocess SAM " + peakSeqBean.getTagfile() + " " + peakSeqBean.getPaht()+"/"+peakSeqBean.getOutput_name() + "_Pol1_ChIP";
        }
        else {
            cmd1 = commandline+" -preprocess ELAND " + peakSeqBean.getTagfile() + " " + peakSeqBean.getPaht() + "/" + peakSeqBean.getOutput_name() + "_Pol1_ChIP";
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
    public void PeakSeq_processed_control(PeakSeqBean peakSeqBean) {
        String cmd1;
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "peakseq");
        if (peakSeqBean.getFormat() == 1) {
            cmd1 = commandline+" -preprocess SAM " + peakSeqBean.getControlfile() + " " + peakSeqBean.getPaht() +"/"+ peakSeqBean.getOutput_name()+"_Pol1_Input";
        }
        else {
            cmd1 = commandline+" -preprocess ELAND " + peakSeqBean.getControlfile() + " " + peakSeqBean.getPaht()+"/"+ peakSeqBean.getOutput_name()+"_Pol1_Input";
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
    public void PeakSeq_exe(PeakSeqBean peakSeqBean){
        String commandline;
        commandline = GetProperty.getPropertyByName("Config", "peakseq");
        String cmd1=commandline+" -peak_select "+peakSeqBean.getPaht()+"/"+peakSeqBean.getOutput_name()+"_config.dat";
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
