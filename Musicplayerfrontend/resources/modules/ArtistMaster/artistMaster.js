app.controller("artistCntrl",function($state,$scope,artistSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.artistObj={};


  


  $scope.insertRecord=function(){
   
   artistSevice.insertArtistRecord($scope.artistObj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       $scope.artistObj={};


  
         
         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }






});



app.service("artistSevice",function($http){
  

 
  
  this.insertArtistRecord=function(obj){
    return $http.post(hostUrl+"insertArtistRecord",obj);
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