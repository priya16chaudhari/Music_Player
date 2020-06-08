app.controller("userPlaylistCntrl",function($state,$scope,userPlaylistService){
 

$scope.userPlaylistObj={};


 $scope.getActivePlayList=function()
   {

    userPlaylistService.getActivePlayList().then(function(response)
    {

       $scope.activePlayList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activePlayList));
  
    })

   }


$scope.getActivePlayList();



 $scope.getSongWiseActivePlaylist=function(pl)
   {

   	alert("In Song API"+JSON.stringify($scope.userPlaylistObj.pl));

    userPlaylistService.getPlayListWiseActiveSong(pl).then(function(response)
    {
    	alert(JSON.stringify($scope.userPlaylistObj.pl));
       $scope.songList=response.data.result;

      alert("ACTIVE GENRE"+JSON.stringify($scope.songList));
  
    })

   }

//$scope.getSongWiseActiveGenreList(userGenereObj);

$scope.activeSonglist=[];

   $scope.getActiveSongUrl=function(songName)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    userPlaylistService.getsongidwiseurl(songName).then(function(response)
    {


      $scope.activeSonglist=response.data;

       alert("Current ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist));


       $scope.userPlaylistObj=$scope.activeSonglist;

      
       // alert("dattttt"+JSON.stringify($scope.userGenereObj));


       $scope.showsongdiv($scope.userPlaylistObj);
       // $state.go('userGenreMusic',{'obj2':userGenereObj});
  
    })

   }
   $scope.showsongdiv=function(userPlaylistObj)
 {

      // $scope.tbldisplay1=true;  
$state.go('userPlaylistMusic',{'obj7':userPlaylistObj});

 }



});


app.service("userPlaylistService",function($http){
  

 

this.getActivePlayList=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActivePlayList/");
  }



  this.getPlayListWiseActiveSong=function(userPlaylistObj){
   // alert(generId);
    return $http.post(hostUrl+"/getPlayListWiseActiveSong",userPlaylistObj);
  }

this.getsongidwiseurl=function(songName){
   
    return $http.get(hostUrl+"getSongUrlBySongnameWIseAPI/"+songName);
  }



  });