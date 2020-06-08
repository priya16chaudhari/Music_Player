
google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Armaan',     11],
          ['Atif',      2],
          ['Arijit',  4]
        ]);

        var options = {
          title:'',
          pieHole: 1,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }


app.controller("userDashboardCtrl",function($state,$scope,userdashService){
  // alert("HIIII");

$scope.cntObj={};
$scope.getUserCnt=function()
{
  //alert("getUserCnt");
  userdashService.getRegisterCntRecord().then(function(response)
  {
    $scope.cntObj=response.data.result;
    //alert("cntObj="+JSON.stringify($scope.cntObj));
  })
}
$scope.getUserCnt();

$scope.songCntObj=[];
$scope.getSongCnt=function()
{
  // alert("getUserCnt");
  userdashService.getSongs().then(function(response)
  {
  	// alert("***********");
    $scope.songCntObj=response.data;
    // alert("songCntObj="+JSON.stringify($scope.songCntObj));

    
$scope.count=$scope.songCntObj.length;
  })
}
$scope.getSongCnt();





});



app.service("userdashService",function($http)
{
  

 this.getRegisterCntRecord=function()
{
      return $http.get(hostUrl+"getRegistrationCnt");

}
 this.getSongs=function()
{
      return $http.get(hostUrl+"getSongs");

}

});