app.controller("songCntrl",function($state,$scope,songSevice){
  // alert("HIIII");


$scope.statuslist=["Active","Inactive"];

$scope.songObj={};
$scope.generModel={};


$scope.filePath=function()
{
   var path = "resources/assets/Songs/"
   var x = document.getElementById("myFile").value;
   var res = x.replace("C:\\fakepath\\", path);
  //document.getElementById("demo").innerHTML = res;

    // alert(x);
    // alert(res);
    $scope.songObj.songUrl = res;
    alert(JSON.stringify($scope.songObj.songUrl)); 
}  


  $scope.insertRecord=function(){
 
    $scope.filePath();
    // alert(JSON.stringify($scope.songObj));
    $scope.songObj.generModel=angular.fromJson($scope.songObj.generModel);


    $scope.songObj.actorModel=angular.fromJson($scope.songObj.actorModel);


  $scope.songObj.albumModel=angular.fromJson($scope.songObj.albumModel);


    $scope.songObj.artistModel=angular.fromJson($scope.songObj.artistModel);



      $scope.songObj.languageModel=angular.fromJson($scope.songObj.languageModel);



        $scope.songObj.playListModel=angular.fromJson($scope.songObj.playListModel);

          $scope.songObj.weatherModel=angular.fromJson($scope.songObj.weatherModel);
          

   
   songSevice.insertSongRecord($scope.songObj).then(function(response){
    
      if(response.data.statusCode=="200"){
      
        alert("Insert Successfully !!!!!!!!!");
       $scope.songObj={};
         
         
      }else{
       
         alert("Insert Failed !!!!!!!!!");
             }
      
    });
   }







  $scope.getSongs=function()
   {

    songSevice.getSongs().then(function(response)
    {

       $scope.mylist=response.data;

      // alert(response.data.result);
      // alert("mylist"+JSON.stringify($scope.mylist));
  // alert("mylist jkjjkj"+JSON.stringify($scope.mylist));
  
    })

   }


$scope.getSongs();








  $scope.getActiveGenreList=function()
   {

    songSevice.getActiveGenre().then(function(response)
    {

       $scope.activeGenrelist=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeGenrelist));
  
    })

   }


$scope.getActiveGenreList();




  $scope.getActiveActorList=function()
   {

    songSevice.getActiveActor().then(function(response)
    {

       $scope.activeActorList=response.data.result;

      // alert("ACTIVE activeActorList"+JSON.stringify($scope.activeActorList));
  
    })

   }


$scope.getActiveActorList();




  $scope.getActiveAlbumList=function()
   {

    songSevice.getActiveAlbum().then(function(response)
    {

       $scope.activeAlbumList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeAlbumList));
  
    })

   }


$scope.getActiveAlbumList();


  $scope.getActiveArtistList=function()
   {

    songSevice.getActiveArtist().then(function(response)
    {

       $scope.activeArtistList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeArtistList));
  
    })

   }


$scope.getActiveArtistList();




  $scope.getActiveLangList=function()
   {

    songSevice.getActiveLang().then(function(response)
    {

       $scope.activeLangList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeLangList));
  
    })

   }


$scope.getActiveLangList();



  $scope.getActivePlayList=function()
   {

    songSevice.getActivePlayList().then(function(response)
    {

       $scope.activePlayList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activePlayList));
  
    })

   }


$scope.getActivePlayList();



$scope.getActiveWeatherList=function()
   {

    songSevice.getActiveWeather().then(function(response)
    {

       $scope.activeWeatherList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeWeatherList));
  
    })

   }


$scope.getActiveWeatherList();















});



app.service("songSevice",function($http){
  

 
  
  this.insertSongRecord=function(obj){
    return $http.post(hostUrl+"insertSongRecord",obj);
  }



this.getSongs=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getSongs/");
  }






this.getActiveGenre=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveGenre/");
  }


this.getActiveActor=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveActor/");
  }





this.getActiveAlbum=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveAlbum/");
  }




this.getActiveArtist=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveArtist/");
  }



this.getActiveLang=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveLang/");
  }



this.getActivePlayList=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActivePlayList/");
  }



this.getActiveWeather=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveWeather/");
  }




 //  this.editDesignnationRecordService=function(desgId){
 // // alert(branchId);
 //    return $http.post(hostUrl+"editDesignationName/"+desgId);
 //  }


 //    this.updateRecordService=function(obj){
 //    return $http.post(hostUrl+"updateDesignationMaster",obj);
 //  }


});