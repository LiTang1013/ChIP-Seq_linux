package ChIP_Seq.service;

import ChIP_Seq.bean.AREMBean;
import ChIP_Seq.execute.AREMExecute;

/**
 * Created by lily on 7/27/16.
 */
public class AREMService {
    private AREMBean aremBean;
    private AREMExecute aremExecute;

    public AREMBean getAremBean() {
        return aremBean;
    }

    public void setAremBean(AREMBean aremBean) {
        this.aremBean = aremBean;
    }

    public AREMExecute getAremExecute() {
        return aremExecute;
    }

    public void setAremExecute(AREMExecute aremExecute) {
        this.aremExecute = aremExecute;
    }
    public String AREM(){
        aremExecute.AREM_execute(aremBean);
        return aremExecute.getStdoutlist();
    }
}
