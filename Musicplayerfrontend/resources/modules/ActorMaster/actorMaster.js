

app.controller("actorCntrl",function($state,$scope,actorSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.actorObj={};


  


  $scope.insertRecord=function(){
   
   actorSevice.insertActorRecord($scope.actorObj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       
         $scope.actorObj={};


         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }












});



app.service("actorSevice",function($http){
  

 
  
  this.insertActorRecord=function(obj){
    return $http.post(hostUrl+"insertActorRecord",obj);
  }


this.getDesignationRecordService=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getDesignationListByInstituteId/");
  }

 //  this.editDesignnationRecordService=function(desgId){
 // // alert(branchId);
 //    return $http.post(hostUrl+"editDesignationName/"+desgId);
 //  }


 //    this.updateRecordService=function(obj){
 //    return $http.post(hostUrl+"updateDesignationMaster",obj);
 //  }


});