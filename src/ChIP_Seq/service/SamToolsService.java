package ChIP_Seq.service;

import ChIP_Seq.bean.SamToolsBean;
import ChIP_Seq.execute.SamToolsExecute;

/**
 * Created by lily on 4/14/16.
 */
public class SamToolsService {
    private SamToolsExecute samtoolsExecute;
    private SamToolsBean samToolsBean;

    public SamToolsBean getSamToolsBean() {
        return samToolsBean;
    }

    public void setSamToolsBean(SamToolsBean samToolsBean) {
        this.samToolsBean = samToolsBean;
    }

    public SamToolsExecute getSamtoolsExecute() {
        return samtoolsExecute;
    }

    public void setSamtoolsExecute(SamToolsExecute samtoolsExecute) {
        this.samtoolsExecute = samtoolsExecute;
    }

    public String SamTools() {
        samtoolsExecute.Samtools_execute(samToolsBean);
        return samtoolsExecute.getStdoutlist();
    }
    public String SamTools_sort(){
        samtoolsExecute.Samtools_sort(samToolsBean);
        return samtoolsExecute.getStdoutlist();
    }
    public String SamTools_index(){
        samtoolsExecute.Samtools_index(samToolsBean);
        return samtoolsExecute.getStdoutlist();
    }
    }
