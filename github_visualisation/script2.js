var dataStuff = { 
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
 var barChart = new Chart(densityCanvas,{
        type: 'doughnut',
        data:{
            labels:["Algorithms","Django_App","freshman_prog","hubSpotChal","Leetcode","redditScraper","softwareEng","3rd_Year_CompArch","CS2016"],
            datasets: [dataStuff],
        },
        //options: chartOptions
        });