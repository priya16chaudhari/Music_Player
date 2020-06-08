app.controller("userGenereCntrl",function($state,$scope,userGenereService){
 

$scope.userGenereObj={};


 $scope.getActiveGenreList=function()
   {

   	

    userGenereService.getActiveGenre().then(function(response)
    {

       $scope.activeGenrelist=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeGenrelist));
  
    })

   }


$scope.getActiveGenreList();






 $scope.getSongWiseActiveGenreList=function(pp)
   {

   	// alert("In Song API"+JSON.stringify($scope.userGenereObj.pp));

    userGenereService.getGenerWiseSong(pp).then(function(response)
    {
    	// alert(JSON.stringify($scope.userGenereObj.pp));
       $scope.songList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.songList));
  
    })

   }


   $scope.activeSonglist=[];

 $scope.getActiveSongUrl=function(songName)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    userGenereService.getsongidwiseurl(songName).then(function(response)
    {


      $scope.activeSonglist=response.data;

       alert("Current ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist));


       $scope.userGenereObj=$scope.activeSonglist;

      
       // alert("dattttt"+JSON.stringify($scope.userGenereObj));


       $scope.showsongdiv($scope.userGenereObj);
       // $state.go('userGenreMusic',{'obj2':userGenereObj});
  
    })

   }

//$scope.getSongWiseActiveGenreList(userGenereObj);


$scope.showsongdiv=function(userGenereObj)
 {

 			// $scope.tbldisplay1=true;	 
$state.go('userGenreMusic',{'obj2':userGenereObj});

 }



});






app.service("userGenereService",function($http){
  

 
 this.getActiveGenre=function(){
   
    return $http.get(hostUrl+"getActiveGenre/");
  }


  this.getGenerWiseSong=function(userGenereObj){
   // alert(generId);
    return $http.post(hostUrl+"/getSongWiseActiveGenere",userGenereObj);
  }

this.getsongidwiseurl=function(songName){
   
    return $http.get(hostUrl+"getSongUrlBySongnameWIseAPI/"+songName);
  }


  });