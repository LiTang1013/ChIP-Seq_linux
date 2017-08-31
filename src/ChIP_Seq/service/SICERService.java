package ChIP_Seq.service;

import ChIP_Seq.bean.SICERBean;
import ChIP_Seq.execute.SICERExecute;

/**
 * Created by Administrator on 2016/5/4 0004.
 */
public class SICERService {
    private SICERBean sicerBean;
    private SICERExecute sicerExecute;

    public SICERExecute getSicerExecute() {
        return sicerExecute;
    }

    public void setSicerExecute(SICERExecute sicerExecute) {
        this.sicerExecute = sicerExecute;
    }

    public SICERBean getSicerBean() {
        return sicerBean;
    }

    public void setSicerBean(SICERBean sicerBean) {
        this.sicerBean = sicerBean;
    }
    public String SICER(){
        sicerExecute.SICER_execute(sicerBean);
        return sicerExecute.getStdoutlist();
    }
}
