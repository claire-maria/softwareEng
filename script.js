var densityCanvas = document.getElementById("myChart");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

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

    var barChart = new Chart(densityCanvas,{
        type: 'bar',
        data:{
            labels:["Algorithms","Django_App","freshman_prog","hubSpotChal","Leetcode","redditScraper","softwareEng","3rd_Year_CompArch","CS2016"],
            datasets: [dataStuff],
        },
        options: chartOptions
        });
   