package ChIP_Seq.service;

import ChIP_Seq.bean.HOMERBean;
import ChIP_Seq.execute.HOMERExecute;

import java.io.IOException;

/**
 * Created by lily on 10/29/16.
 */
public class HOMERService {
    private HOMERBean homerBean;
    private HOMERExecute homerExecute;

    public HOMERBean getHomerBean() {
        return homerBean;
    }

    public void setHomerBean(HOMERBean homerBean) {
        this.homerBean = homerBean;
    }

    public HOMERExecute getHomerExecute() {
        return homerExecute;
    }

    public void setHomerExecute(HOMERExecute homerExecute) {
        this.homerExecute = homerExecute;
    }
    public String HOMER(){
        homerExecute.HOMER_execute(homerBean);
        return homerExecute.getStdoutlist();
    }
    public String HOMER_anno() throws IOException {
        homerExecute.HOMER_anoo(homerBean);
        return homerExecute.getStdoutlist();
    }
}
