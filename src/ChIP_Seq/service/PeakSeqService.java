package ChIP_Seq.service;

import ChIP_Seq.bean.PeakSeqBean;
import ChIP_Seq.execute.PeakSeqExecute;

/**
 * Created by Administrator on 2016/5/7 0007.
 */
public class PeakSeqService {
    private PeakSeqBean peakSeqBean;
    private PeakSeqExecute peakSeqExecute;

    public PeakSeqExecute getPeakSeqExecute() {
        return peakSeqExecute;
    }

    public void setPeakSeqExecute(PeakSeqExecute peakSeqExecute) {
        this.peakSeqExecute = peakSeqExecute;
    }

    public PeakSeqBean getPeakSeqBean() {
        return peakSeqBean;
    }

    public void setPeakSeqBean(PeakSeqBean peakSeqBean) {
        this.peakSeqBean = peakSeqBean;
    }

    public String  PeakSeq(){
        peakSeqExecute.PeakSeq_mkdir_ChIP(peakSeqBean);
        peakSeqExecute.PeakSeq_mkdir_Input(peakSeqBean);
        peakSeqExecute.PeakSeq_processed_tag(peakSeqBean);
        peakSeqExecute.PeakSeq_processed_control(peakSeqBean);
        peakSeqExecute.PeakSeq_exe(peakSeqBean);
        return peakSeqExecute.getStdoutlist();
    }
}
