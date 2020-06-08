app.controller("userLanguageCntrl",function($state,$scope,userLanguageService){
 

$scope.userLanguageObj={};


 $scope.getActiveLangList=function()
   {

    userLanguageService.getActiveLang().then(function(response)
    {

       $scope.activeLangList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeLangList));
  
    })

   }


$scope.getActiveLangList();



 $scope.getSongWiseActiveLangList=function(lang)
   {

   	alert("In Song API"+JSON.stringify($scope.userLanguageObj.lang));

    userLanguageService.getSongWiseActiveLanguage(lang).then(function(response)
    {
    	alert(JSON.stringify($scope.userLanguageObj.lang));
       $scope.songList=response.data.result;

      alert("ACTIVE Language="+JSON.stringify($scope.songList));
  
    })

   }

//$scope.getSongWiseActiveGenreList(userLanguageObj);


$scope.activeSonglist=[];

   $scope.getActiveSongUrl=function(songName)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    userLanguageService.getsongidwiseurl(songName).then(function(response)
    {


      $scope.activeSonglist=response.data;

       alert("Current ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist));


       $scope.userLanguageObj=$scope.activeSonglist;

      
       // alert("dattttt"+JSON.stringify($scope.userGenereObj));


       $scope.showsongdiv($scope.userLanguageObj);
       // $state.go('userGenreMusic',{'obj2':userGenereObj});
  
    })

   }


   


$scope.showsongdiv=function(userLanguageObj)
 {

      // $scope.tbldisplay1=true;  
$state.go('userLanguageMusic',{'obj6':userLanguageObj});

 }









});






app.service("userLanguageService",function($http){
  

 this.getActiveLang=function(){
   // alert(instituteId);
    return $http.get(hostUrl+"getActiveLang/");
  }


  this.getSongWiseActiveLanguage=function(userLanguageObj){
   // alert(generId);
    return $http.post(hostUrl+"/getSongWiseActiveLanguage",userLanguageObj);
  }


this.getsongidwiseurl=function(songName){
   
    return $http.get(hostUrl+"getSongUrlBySongnameWIseAPI/"+songName);
  }



  });