app.controller("userActorCntrl",function($state,$scope,userActorService){
 
//alert("Actor master js");
$scope.userActorObj={};


  $scope.getActiveActorList=function()
   {

    userActorService.getActiveActor().then(function(response)
    {

       $scope.activeActorList=response.data.result;

      // alert("ACTIVE activeActorList"+JSON.stringify($scope.activeActorList));
  
    })

   }


$scope.getActiveActorList();



$scope.songList=[];


 $scope.getActorWiseActiveActorList=function(acc)
   {

   	alert("In Song API"+JSON.stringify($scope.userActorObj.acc));

    userActorService.getActiveActorWiseSong(acc).then(function(response)
    {
    	alert(JSON.stringify($scope.userActorObj.acc));
       $scope.songList=response.data.result;

  //      $scope.userActorObj=$scope.songList;
  // $scope.showsongdiv($scope.userActorObj);
      alert("ACTIVE GENRE"+JSON.stringify($scope.songList));
  
    })

   }




    $scope.activeSonglist=[];

 $scope.getActiveSongUrl=function(songName)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    userActorService.getsongidwiseurl(songName).then(function(response)
    {


      $scope.activeSonglist=response.data;

       alert("Current ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist));


       $scope.userActorObj=$scope.activeSonglist;

      
       // alert("dattttt"+JSON.stringify($scope.userGenereObj));


       $scope.showsongdiv($scope.userActorObj);
       // $state.go('userGenreMusic',{'obj2':userGenereObj});
  
    })

   }

$scope.showsongdiv=function(userActorObj)
 {

      // $scope.tbldisplay1=true;  
$state.go('userActorMusic',{'obj3':userActorObj});

 }




});






app.service("userActorService",function($http){
  

 
 
this.getActiveActor=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveActor/");
  }



  this.getActiveActorWiseSong=function(userActorObj){
   // alert(generId);
    return $http.post(hostUrl+"/getActiveActorWiseSong",userActorObj);
  }


this.getsongidwiseurl=function(songName){
   
    return $http.get(hostUrl+"getSongUrlBySongnameWIseAPI/"+songName);
  }



  });