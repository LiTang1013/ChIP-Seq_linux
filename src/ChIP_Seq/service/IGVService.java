package ChIP_Seq.service;

import ChIP_Seq.bean.IGVBean;
import ChIP_Seq.execute.IGVExecute;

import java.io.IOException;

/**
 * Created by lily on 6/9/16.
 */
public class IGVService {
    private IGVBean igvBean;
    private IGVExecute igvExecute;

    public IGVBean getIgvBean() {
        return igvBean;
    }

    public void setIgvBean(IGVBean igvBean) {
        this.igvBean = igvBean;
    }

    public IGVExecute getIgvExecute() {
        return igvExecute;
    }

    public void setIgvExecute(IGVExecute igvExecute) {
        this.igvExecute = igvExecute;
    }

    public void IGV_mapping_visual() throws Exception{
        igvExecute.IGV_indexFa(igvBean);
        igvExecute.IGV_samtools_view(igvBean);
        igvExecute.IGV_samtools_sort(igvBean);
        igvExecute.IGV_samtools_index(igvBean);
        igvExecute.IGV_summit(igvBean);
    }
    public void IGV_mapping_unSamtools() throws Exception{
        igvExecute.IGV_summit(igvBean);
    }
    public String IGV_peakcalling_visual() throws Exception{
        igvExecute.IGV_indexFa(igvBean);
        igvExecute.IGV_samtools_view(igvBean);
        igvExecute.IGV_samtools_view_control(igvBean);
        igvExecute.IGV_samtools_sort(igvBean);
        igvExecute.IGV_samtools_sort_control(igvBean);
        igvExecute.IGV_samtools_index(igvBean);
        igvExecute.IGV_samtools_index_control(igvBean);
        igvExecute.IGV_treatment(igvBean);
        igvExecute.IGV_control(igvBean);
        igvExecute.IGV_peakcalling(igvBean);
        return igvExecute.getStdoutlist();
    }
    public void  IGV_peakcalling_unSamtools() throws Exception{
        igvExecute.IGV_peakcalling(igvBean);
    }

}
