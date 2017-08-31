package ChIP_Seq.service;
import ChIP_Seq.execute.diffRepsExecute;
import ChIP_Seq.bean.diffRepsBean;
/**
 * Created by lily on 7/15/16.
 */
public class diffRepService {
    private diffRepsExecute diffRepsExecute;
    private diffRepsBean diffRepsBean;

    public diffRepsExecute getDiffRepsExecute() {
        return diffRepsExecute;
    }

    public void setDiffRepsExecute(diffRepsExecute diffRepsExecute) {
        this.diffRepsExecute = diffRepsExecute;
    }

    public diffRepsBean getDiffRepsBean() {
        return diffRepsBean;
    }

    public void setDiffRepsBean(diffRepsBean diffRepsBean) {
        this.diffRepsBean = diffRepsBean;
    }
    public String diffReps(){
        diffRepsExecute.diffReps_execute(diffRepsBean);
        return diffRepsExecute.getStdoutlist();
    }
}
