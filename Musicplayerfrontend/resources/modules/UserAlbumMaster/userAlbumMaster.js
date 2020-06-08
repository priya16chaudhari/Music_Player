app.controller("userAlbumCtrl",function($state,$scope,userAlbumService){
 

$scope.userAlbumObj={};

// alert("Hiiii");


  $scope.getActiveAlbumList=function()
   {

    userAlbumService.getActiveAlbum().then(function(response)
    {

       $scope.activeAlbumList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeAlbumList));
  
    })

   }


$scope.getActiveAlbumList();


$scope.songList=[];

 $scope.getSongWiseActiveAlbumList=function(alb)
   {

   	// alert("In Song API"+JSON.stringify($scope.userAlbumObj.alb));

    userAlbumService.getActiveAlbumwiseSong(alb).then(function(response)
    {
    	// alert(JSON.stringify($scope.userAlbumObj.alb));
       $scope.songList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.songList));
  
    })

   }

//$scope.getSongWiseActiveGenreList(userAlbumObj);



      $scope.activeSonglist=[];

 $scope.getActiveSongUrl=function(songName)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    userAlbumService.getsongidwiseurl(songName).then(function(response)
    {


      $scope.activeSonglist=response.data;

       alert("Current ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist));


       $scope.userAlbumObj=$scope.activeSonglist;

      
       // alert("dattttt"+JSON.stringify($scope.userGenereObj));


       $scope.showsongdiv($scope.userAlbumObj);
       // $state.go('userGenreMusic',{'obj2':userGenereObj});
  
    })

   }

   


$scope.showsongdiv=function(userAlbumObj)
 {

      // $scope.tbldisplay1=true;  
$state.go('userAlbumMusic',{'obj4':userAlbumObj});

 }
});






app.service("userAlbumService",function($http){
  

 
 


this.getActiveAlbum=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveAlbum/");
  }


this.getActiveAlbumwiseSong=function(userAlbumObj){
   // alert(generId);
    return $http.post(hostUrl+"/getActiveAlbumwiseSong",userAlbumObj);
  }



this.getsongidwiseurl=function(songName){
   
    return $http.get(hostUrl+"getSongUrlBySongnameWIseAPI/"+songName);
  }



  });