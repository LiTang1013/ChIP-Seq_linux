package ChIP_Seq.service;

import ChIP_Seq.bean.BroadPeakBean;
import ChIP_Seq.execute.BroadPeakExecute;

/**
 * Created by lily on 7/27/16.
 */
public class BroadPeakService {
    private BroadPeakExecute broadPeakExecute;
    private BroadPeakBean broadPeakBean;

    public BroadPeakExecute getBroadPeakExecute() {
        return broadPeakExecute;
    }

    public void setBroadPeakExecute(BroadPeakExecute broadPeakExecute) {
        this.broadPeakExecute = broadPeakExecute;
    }

    public BroadPeakBean getBroadPeakBean() {
        return broadPeakBean;
    }

    public void setBroadPeakBean(BroadPeakBean broadPeakBean) {
        this.broadPeakBean = broadPeakBean;
    }
    public String BroadPeak(){
        broadPeakExecute.BroadPeak_execute(broadPeakBean);
        return broadPeakExecute.getStdoutlist();
    }

}
