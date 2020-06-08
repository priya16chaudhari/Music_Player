
app.controller("weatherCntrl",function($state,$scope,weatherSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.weathereobj={};


  


  $scope.insertRecord=function(){
   
   weatherSevice.insertWeatherRecord($scope.weathereobj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       $scope.weathereobj=null;
         
         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }






});



app.service("weatherSevice",function($http){
  

 
  
  this.insertWeatherRecord=function(obj){
    return $http.post(hostUrl+"insertWeatherRecord",obj);
  }


// this.getDesignationRecordService=function(instituteId){
//    // alert(instituteId);
//     return $http.get(hostUrl+"getDesignationListByInstituteId/"+instituteId);
//   }

 //  this.editDesignnationRecordService=function(desgId){
 // // alert(branchId);
 //    return $http.post(hostUrl+"editDesignationName/"+desgId);
 //  }


 //    this.updateRecordService=function(obj){
 //    return $http.post(hostUrl+"updateDesignationMaster",obj);
 //  }


});