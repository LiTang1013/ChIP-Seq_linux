package ChIP_Seq.service;

import ChIP_Seq.bean.IGV_PeakBean;
import ChIP_Seq.execute.IGV_PeakExecute;

import java.io.IOException;

/**
 * Created by lily on 11/19/16.
 */
public class IGV_PeakService {
    private IGV_PeakBean igv_peakBean;
    private IGV_PeakExecute igv_peakExecute;

    public IGV_PeakBean getIgv_peakBean() {
        return igv_peakBean;
    }

    public void setIgv_peakBean(IGV_PeakBean igv_peakBean) {
        this.igv_peakBean = igv_peakBean;
    }

    public IGV_PeakExecute getIgv_peakExecute() {
        return igv_peakExecute;
    }

    public void setIgv_peakExecute(IGV_PeakExecute igv_peakExecute) {
        this.igv_peakExecute = igv_peakExecute;
    }

    public String IGV_peakcalling_visual() throws Exception {
        igv_peakExecute.IGV_indexFa(igv_peakBean);
        igv_peakExecute.IGV_samtools_view(igv_peakBean);
        igv_peakExecute.IGV_samtools_view_control(igv_peakBean);
        igv_peakExecute.IGV_samtools_sort(igv_peakBean);
        igv_peakExecute.IGV_samtools_sort_control(igv_peakBean);
        igv_peakExecute.IGV_samtools_index(igv_peakBean);
        igv_peakExecute.IGV_samtools_index_control(igv_peakBean);
        igv_peakExecute.IGV_treatment(igv_peakBean);
        igv_peakExecute.IGV_control(igv_peakBean);
        igv_peakExecute.IGV_peakcalling(igv_peakBean);
        return igv_peakExecute.getStdoutlist();
    }
}
