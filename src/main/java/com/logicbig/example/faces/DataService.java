package com.logicbig.example.faces;

import com.logicbig.example.bean.IdeasBean;
import com.logicbig.example.data.Ideas;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
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

    public BarChartSeries getBarChartData( BarChartSeries series) {
        series.set("Sistemas", ideasBean.groupedByIdeas("Sistemas").size());
        series.set("Matematicas", ideasBean.groupedByIdeas("Matematicas").size());
        series.set("Sociales", ideasBean.groupedByIdeas("Sociales").size());
        series.set("Administracion", ideasBean.groupedByIdeas("Administracion").size());
        return series;
    }
}