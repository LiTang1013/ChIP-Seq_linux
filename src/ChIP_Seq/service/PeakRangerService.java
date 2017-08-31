package ChIP_Seq.service;

import ChIP_Seq.bean.PeakRangerBean;
import ChIP_Seq.execute.PeakRangerExecute;

/**
 * Created by Administrator on 2016/5/8 0008.
 */
public class PeakRangerService {
    PeakRangerBean peakRangerBean=new PeakRangerBean();
    PeakRangerExecute peakRangerExecute=new PeakRangerExecute();

    public PeakRangerBean getPeakRangerBean() {
        return peakRangerBean;
    }

    public void setPeakRangerBean(PeakRangerBean peakRangerBean) {
        this.peakRangerBean = peakRangerBean;
    }

    public PeakRangerExecute getPeakRangerExecute() {
        return peakRangerExecute;
    }

    public void setPeakRangerExecute(PeakRangerExecute peakRangerExecute) {
        this.peakRangerExecute = peakRangerExecute;
    }
    public String PeakRanger(){
        peakRangerExecute.PeakRanger_Execute(peakRangerBean);
        return peakRangerExecute.getStdoutlist();
    }
}
