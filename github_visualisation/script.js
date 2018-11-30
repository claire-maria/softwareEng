window.onload = function(){
var densityCanvas = document.getElementById("myChart");
Chart.defaults.global.defaultFontFamily = "Lato"; 
Chart.defaults.global.defaultFontSize = 18;
var dataToComputeAve = [16, 3, 3, 2, 9, 8, 6, 31, 2, 30];
var len = dataToComputeAve.length;
var diff = 0;
var average = 0;
    for(i = 0 ; i < len ; i++){
        average += dataToComputeAve[i]/len;
        diff = 11- dataToComputeAve[i];
        if(diff < 0){
            diff += diff+diff;
        }
    }
var chartOptions = {
  scales: {
    yAxes: [{
      barPercentage: 0.8,
      gridLines: {
        display: true
      }
    }],
    xAxes: [{
      gridLines: {
        zeroLineColor: "black",
        zeroLineWidth: 2
      },
      ticks: {
        min: 0,
        max: 3000,
        stepSize: 800
      },
      scaleLabel: {
        display: true,
        labelString: "hey"
      }
    }]
  },
  elements: {
    rectangle: {
      borderSkipped: 'bottom',
    }
  }
   
};
    Chart.pluginService.register({
    afterDraw: function(chart) {
        if (typeof chart.config.options.lineAt != 'undefined') {
        	var lineAt = chart.config.options.lineAt;
            var ctxPlugin = chart.chart.ctx;
            var xAxe = chart.scales[chart.config.options.scales.xAxes[0].id];
            var yAxe = chart.scales[chart.config.options.scales.yAxes[0].id];
           	
            // I'm not good at maths
            // So I couldn't find a way to make it work ...
            // ... without having the `min` property set to 0
            if(yAxe.min != 0) return;
            
            ctxPlugin.strokeStyle = "red";
        	ctxPlugin.beginPath();
            lineAt = (lineAt - yAxe.min) * (100 / yAxe.max);
            lineAt = (100 - lineAt) / 100 * (yAxe.height) + yAxe.top;
            ctxPlugin.moveTo(xAxe.left, lineAt);
            ctxPlugin.lineTo(xAxe.right, lineAt);
            ctxPlugin.stroke();
        }
    }
});

var dataStuff = { 
      label: 'Commits',
      data: [16, 3, 3, 2, 9, 8, 6, 31, 2, 30],
      
    
      backgroundColor: [
        'rgba(0, 99, 132, 0.6)',
        'rgba(30, 99, 132, 0.6)',
        'rgba(60, 99, 132, 0.6)',
        'rgba(90, 99, 132, 0.6)',
        'rgba(120, 99, 132, 0.6)',
        'rgba(150, 99, 132, 0.6)',
        'rgba(180, 99, 132, 0.6)',
        'rgba(210, 99, 132, 0.6)',
        'rgba(240, 99, 132, 0.6)',
        'rgba(270, 99, 132, 0.6)'
                    ],
      borderColor: [
        'rgba(0, 99, 132, 1)',
        'rgba(30, 99, 132, 1)',
        'rgba(60, 99, 132, 1)',
        'rgba(90, 99, 132, 1)',
        'rgba(120, 99, 132, 1)',
        'rgba(150, 99, 132, 1)',
        'rgba(180, 99, 132, 1)',
        'rgba(210, 99, 132, 1)',
        'rgba(240, 99, 132, 1)',
        'rgba(270, 99, 132, 0.6)'
                    ],
    borderWidth: 2,
    hoverBorderWidth: 0

};

    var myChart = new Chart(densityCanvas,{
        type: 'bar',
        data:{
            labels:["Algorithms","Django_App","freshman_prog","hubSpotChal","js_Platformer","Leetcode","redditScraper","softwareEng","3rd_Year_CompArch","CS2016"],
            datasets: [dataStuff],
        },
        options:{
            maintainAspectRatio : false,
            lineAt: average,
                scales: {
                    yAxes: [{
                        ticks: {
                            min: 0
                }
            }]
        }
    }
    });


//Doughnut chart

var dataStuffD = { 
      label: 'Commits',
      data: [16, 3, 3, 2, 9, 8, 6, 31, 2, 30],
      backgroundColor: [
        '#170337',
        '#581845',
        '#821E64',
        '#900C3F',
        '#C70039',
        '#FF4500',
        '#FF8C00',
        '#ffc300',
        '#FF1493',
        '#FF69B4'
                    ],
      borderColor: [
        '#170337',
        '#581845',
        '#821E64',
        '#900C3F',
        '#C70039',
        '#FF4500',
        '#FF8C00',
        '#ffc300',
        '#FF1493',
        '#FF69B4'
                    ],
    borderWidth: 2,
    hoverBorderWidth: 0

};
   
var ctx = document.getElementById("myDoughnutChart")
var myDoughnutChart = new Chart(ctx,{
        type: 'doughnut',
        data:{
            labels:["Algorithms","Django_App","freshman_prog","hubSpotChal","Js_Platformer","Leetcode","redditScraper","softwareEng","3rd_Year_CompArch","CS2016"],
            datasets: [dataStuffD],
        },
        options:{
            maintainAspectRatio : false
             
        }
        });
}