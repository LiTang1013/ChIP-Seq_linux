package ChIP_Seq.execute;

import ChIP_Seq.GetProperty;
import ChIP_Seq.bean.multiBamSummaryBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class multiBamSummaryExecute {
    private String stdoutlist;

    public String getStdoutlist() {
        return stdoutlist;
    }

    public void setStdoutlist(String stdoutlist) {
        this.stdoutlist = stdoutlist;
    }
    public void multi_execute(multiBamSummaryBean multiBamSummaryBean){
        String multi = GetProperty.getPropertyByName("Config", "multi");
        String cmd1;
        if(multiBamSummaryBean.getMode()==1){
            cmd1 = multi+" bins --bamfiles "+multiBamSummaryBean.getBam1()+" "+multiBamSummaryBean.getBam2()+" "+multiBamSummaryBean.getOption()+" -out "+multiBamSummaryBean.getPath();
        }
        else{
             cmd1=multi+" BED-file --BED "+multiBamSummaryBean.getBed()+" --bamfiles "+multiBamSummaryBean.getBam1()+" "+multiBamSummaryBean.getBam2()+" -out "+multiBamSummaryBean.getPath();
        }
        System.out.println(cmd1);
        BaseExecute util = new BaseExecute();
        util.executeCommand(cmd1);
        printList(util.getStdoutList());
        StringBuffer sb=new StringBuffer();
        for(String item:util.getErroroutList()){
            sb.append(item+"\n\r");
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
