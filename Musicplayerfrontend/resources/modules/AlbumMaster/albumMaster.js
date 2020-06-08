app.controller("albumCntrl",function($state,$scope,albumSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.albumObj={};


  


  $scope.insertRecord=function(){
   
   albumSevice.insertAlbumRecord($scope.albumObj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       
         $scope.albumObj={};


         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }






});



app.service("albumSevice",function($http){
  

 
  
  this.insertAlbumRecord=function(obj){
    return $http.post(hostUrl+"insertAlbumRecord",obj);
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