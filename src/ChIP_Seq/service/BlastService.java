package ChIP_Seq.service;

import ChIP_Seq.bean.BlastBean;
import ChIP_Seq.execute.BlastExecute;

/**
 * Created by lily on 7/22/16.
 */
public class BlastService {
    private BlastBean blastBean;
    private BlastExecute blastExecute;

    public BlastBean getBlastBean() {
        return blastBean;
    }

    public void setBlastBean(BlastBean blastBean) {
        this.blastBean = blastBean;
    }

    public BlastExecute getBlastExecute() {
        return blastExecute;
    }

    public void setBlastExecute(BlastExecute blastExecute) {
        this.blastExecute = blastExecute;
    }
    public String Blast(){
        blastExecute.Blast_execute(blastBean);
        blastExecute.Blast_align(blastBean);
        return blastExecute.getStdoutlist();
    }
    public String Blast_unBuild(){
        blastExecute.Blast_align(blastBean);
        return blastExecute.getStdoutlist();
    }
}
