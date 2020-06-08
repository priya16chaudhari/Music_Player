app.controller("generCntrl",function($state,$scope,generSevice){
  alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.genreobj={};


  


  $scope.insertRecord=function(){
   
   generSevice.insertGenerRecord($scope.genreobj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       $scope.genreobj={};


         
         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }






});



app.service("generSevice",function($http){
  

 
  
  this.insertGenerRecord=function(obj){
    return $http.post(hostUrl+"insertGenerRecord",obj);
  }




});