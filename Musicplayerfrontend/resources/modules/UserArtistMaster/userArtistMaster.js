app.controller("userArtistCtrl",function($state,$scope,userArtistService){
 

$scope.userArtistObj={};

alert("Hiiii");


  $scope.getActiveArtistList=function()
   {

    userArtistService.getActiveArtist().then(function(response)
    {

       $scope.activeArtistList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeArtistList));
  
    })

   }


$scope.getActiveArtistList();



 $scope.getSongWiseActiveArtistList=function(art)
   {

   	alert("In Song API"+JSON.stringify($scope.userArtistObj.art));

    userArtistService.getActiveArtistwiseSong(art).then(function(response)
    {
    	alert(JSON.stringify($scope.userArtistObj.art));
       $scope.songList=response.data;

      alert("ACTIVE Artist="+JSON.stringify($scope.songList));
  
    })

   }

//$scope.getSongWiseActiveGenreList(userGenereObj);

 $scope.activeSonglist=[];

   $scope.getActiveSongUrl=function(songName)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    userArtistService.getsongidwiseurl(songName).then(function(response)
    {


      $scope.activeSonglist=response.data;

       alert("Current ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist));


       $scope.userArtistObj=$scope.activeSonglist;

      
       // alert("dattttt"+JSON.stringify($scope.userGenereObj));


       $scope.showsongdiv($scope.userArtistObj);
       // $state.go('userGenreMusic',{'obj2':userGenereObj});
  
    })

   }


   


$scope.showsongdiv=function(userArtistObj)
 {

      // $scope.tbldisplay1=true;  
$state.go('userArtistMusic',{'obj5':userArtistObj});

 }





});






app.service("userArtistService",function($http){
  

 
this.getActiveArtist=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveArtist/");
  }



  this.getActiveArtistwiseSong=function(userArtistObj){
   // alert(generId);
    return $http.post(hostUrl+"/getActiveArtistwiseSong",userArtistObj);
  }

this.getsongidwiseurl=function(songName){
   
    return $http.get(hostUrl+"getSongUrlBySongnameWIseAPI/"+songName);
  }




  });