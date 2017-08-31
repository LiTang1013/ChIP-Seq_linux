package ChIP_Seq.service;

import ChIP_Seq.bean.GOMoBean;
import ChIP_Seq.execute.GOMoExecute;

/**
 * Created by lily on 5/10/16.
 */
public class GOMoService {
    private GOMoBean goMoBean;
    private GOMoExecute goMoExecute;

    public GOMoExecute getGoMoExecute() {
        return goMoExecute;
    }

    public void setGoMoExecute(GOMoExecute goMoExecute) {
        this.goMoExecute = goMoExecute;
    }

    public GOMoBean getGoMoBean() {
        return goMoBean;
    }

    public void setGoMoBean(GOMoBean goMoBean) {
        this.goMoBean = goMoBean;
    }
    public String GOMo(){
        goMoExecute.GOMo_exe(goMoBean);
        return goMoExecute.getStdoutlist();
    }
}
