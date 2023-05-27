package com.logicbig.example.faces;

import com.logicbig.example.bean.IdeasBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
public class BarChartBean {
    @Autowired
    public IdeasBean ideasBean;
    @Autowired
    private DataService dataService;
    private BarChartModel chartModel;
    private BarChartModel chartModelStatus;

    public void onAppReady (){
        chartModel = new BarChartModel();
        BarChartSeries s = new BarChartSeries();
        s.setLabel("Cantidad de Ideas por Area");

        dataService.getBarChartData(s);

        chartModel.addSeries(s);
        chartModel.setLegendPosition("n");
        Axis y = chartModel.getAxis(AxisType.Y);
        y.setMin(0);
        y.setTickInterval("1");
        y.setMax(ideasBean.maxIdea(true));
        y.setLabel("Cantidad");

        Axis x = chartModel.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(7);
        x.setTickInterval("1");
        x.setLabel("Areas o Dependencias");
        onAppReadyStatus();
    }

    public void onAppReadyStatus (){
        chartModelStatus = new BarChartModel();
        BarChartSeries s = new BarChartSeries();
        s.setLabel("Cantidad de Ideas por Area");

        dataService.getBarChartDataStatus(s);

        chartModelStatus.addSeries(s);
        chartModelStatus.setLegendPosition("n");
        Axis y = chartModelStatus.getAxis(AxisType.Y);
        y.setMin(0);
        y.setTickInterval("1");
        y.setMax(ideasBean.maxIdea(false));
        y.setLabel("Cantidad");

        Axis x = chartModelStatus.getAxis(AxisType.X);
        x.setMin(0);
        x.setMax(7);
        x.setTickInterval("1");
        x.setLabel("Areas o Dependencias");
    }
    public BarChartModel getChartModel() {
        return chartModel;
    }
    public BarChartModel getChartModelStatus() {return chartModelStatus;}

}