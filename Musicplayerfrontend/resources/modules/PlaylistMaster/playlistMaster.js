


app.controller("playlistCntrl",function($state,$scope,playlistSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.playlistObj={};


  


  $scope.insertRecord=function(){
   
   playlistSevice.insertPlayListRecord($scope.playlistObj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       
$scope.playlistObj={};


  
         
         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }






});



app.service("playlistSevice",function($http){
  

 
  
  this.insertPlayListRecord=function(obj){
    return $http.post(hostUrl+"insertPlayListRecord",obj);
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