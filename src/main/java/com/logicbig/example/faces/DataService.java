package com.logicbig.example.faces;

import com.logicbig.example.bean.IdeasBean;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.charts.bar.BarChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DataService {
    @Autowired
    IdeasBean ideasBean;


    public Map<Integer, Double> getLineChartData() {
        Map<Integer, Double> map = new LinkedHashMap<>();
        map.put(1, 5.20);
        map.put(2, 19.63);
        map.put(3, 59.01);
        map.put(4, 139.76);
        map.put(5, 300.4);
        map.put(6, 630.0);
       return map;
    }

    public BarChartModel getBarChartData(ChartSeries series) {
        BarChartModel model = new BarChartModel();
        series.set("Sistemas", ideasBean.groupedByIdeas("Sistemas").size());
        series.set("Matematicas", ideasBean.groupedByIdeas("Matematicas").size());
        series.set("Sociales", ideasBean.groupedByIdeas("Sociales").size());
        series.set("Administracion", ideasBean.groupedByIdeas("Administracion").size());
        return model;
    }

    public BarChartModel getBarChartDataStatus( ChartSeries series) {
        BarChartModel model2 = new BarChartModel();
        series.set("Pendiente", ideasBean.groupedByIdeas("Pendiente").size());
        series.set("Aprobada", ideasBean.groupedByIdeas("Aprobada").size());
        series.set("Revision", ideasBean.groupedByIdeas("Revision").size());
        series.set("Denegada", ideasBean.groupedByIdeas("Denegada").size());
        return model2;
    }
}