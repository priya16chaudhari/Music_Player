

app.controller("languageCntrl",function($state,$scope,langaugeSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.langObj={};


  


  $scope.insertRecord=function(){
   
   langaugeSevice.insertLanguageRecord($scope.langObj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       
         $scope.langObj={};

         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }






});



app.service("langaugeSevice",function($http){
  

 
  
  this.insertLanguageRecord=function(obj){
    return $http.post(hostUrl+"insertLanguageRecord",obj);
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