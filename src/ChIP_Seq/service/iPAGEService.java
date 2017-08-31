package ChIP_Seq.service;

import ChIP_Seq.bean.iPAGEBean;
import ChIP_Seq.execute.iPAGExecute;

import java.io.IOException;

/**
 * Created by lily on 11/3/16.
 */
public class iPAGEService {
    private iPAGEBean iPAGEBean;
    private iPAGExecute iPAGExecute;

    public iPAGEBean getiPAGEBean() {
        return iPAGEBean;
    }

    public void setiPAGEBean(iPAGEBean iPAGEBean) {
        this.iPAGEBean = iPAGEBean;
    }

    public iPAGExecute getiPAGExecute() {
        return iPAGExecute;
    }

    public void setiPAGExecute(iPAGExecute iPAGExecute) {
        this.iPAGExecute = iPAGExecute;
    }
    public String iPAGE() throws IOException {
        iPAGExecute.iPAGE_execute(iPAGEBean);
        return iPAGExecute.getStdoutlist();
    }
}
