app.controller("userActorCtrl",function($state,$scope,$stateParams,actormusicservice,$window){
 
// alert("priya");
$scope.userGenereObj={};
$scope.obj1={};







$scope.obj1=angular.copy($stateParams.obj3);

   alert("obj1"+JSON.stringify($scope.obj1));




      $scope.urlsize=$scope.obj1[0].length;

        // alert("obj song"+JSON.stringify($scope.obj1[0]));
// console.log("size url"+JSON.stringify($scope.urlsize));

      var songs=$scope.obj1;
      // var str = "resources/assets/Songs/";
     





       var songs1=$scope.obj1;
        var poster = ["resources/modules/UserActorMusic/Poster1.jpg"];
        
        var songTitle = document.getElementById("songTitle");
        var fillBar = document.getElementById("fill");
        
        var song = new Audio();
        var currentSong = 0;    // it point to the current song
        
        window.onload = $scope.playSong;   // it will call the function playSong when window is load
        
      
   $scope.playSong=function(){
            
            song.src = $scope.obj1;  //set the source of 0th song 
            
            songTitle.textContent =$scope.obj1; // set the title of song
            
            song.play();    // play the song
        }
        
        // function playOrPauseSong(){
           $scope.playOrPauseSong=function(){
             
            if(song.paused){
                song.play();
                $("#play img").attr("src","resources/modules/UserActorMusic/Pause.png");
            }
            else{
                song.pause();
                $("#play img").attr("src","resources/modules/UserActorMusic/Play.png");
            }
        }
        
        song.addEventListener('timeupdate',function(){ 
            
            var position = song.currentTime / song.duration;
            
            fillBar.style.width = position * 100 +'%';
        });
        
    
        // function next(){
            $scope.next=function(){
           //        currentSong++;
           // if(currentSong >$scope.urlsize-1){
           //      currentSong = 0;
           //  }
            $scope.playSong();
            $("#play img").attr("src","resources/modules/UserActorMusic/Pause.png");
            $("#image img").attr("src",poster[currentSong]);
            $("#bg img").attr("src",poster[currentSong]);
        }
    
        // function pre(){
          $scope.pre=function(){
            
            // currentSong--;
            // if(currentSong < 0){
            //     currentSong =$scope.urlsize-1;
            // }
            $scope.playSong();
            $("#play img").attr("src","resources/modules/UserActorMusic/Pause.png");
            $("#image img").attr("src",poster[currentSong]);
            $("#bg img").attr("src",poster[currentSong]);
        }
        
   
    




 $scope.getActiveGenreList=function()
   {

    

    actormusicservice.getActiveGenre().then(function(response)
    {

       $scope.activeGenrelist=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.activeGenrelist));
  
    })

   }


$scope.getActiveGenreList();






 $scope.getSongWiseActiveGenreList=function(pp)
   {

    // alert("In Song API"+JSON.stringify($scope.userGenereObj.pp));

    actormusicservice.getGenerWiseSong(pp).then(function(response)
    {
      alert(JSON.stringify($scope.userGenereObj.pp));
       $scope.songList=response.data.result;

      // alert("ACTIVE GENRE"+JSON.stringify($scope.songList));
  
    })

   }


   $scope.activeSonglist=[];

   $scope.getActiveSongUrl=function(data)
   {

    // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
    actormusicservice.getSongUrlBySongIdWIse(data).then(function(response)
    {


      $scope.activeSonglist=response.data.result;

      // alert("ACTIVE SONG BY URL"+JSON.stringify($scope.activeSonglist.data));
  
    })

   }


//$scope.getSongWiseActiveGenreList(userGenereObj);

$scope.listobj={};
$scope.getActiveSongsUrl1=function()
   {

  
    actormusicservice.getSongsUrlBySongIdWIse().then(function(response)
    {


      $scope.listobj=response.data.result;

      // alert("listttt"+JSON.stringify($scope.listobj));




      $scope.urlsize=$scope.listobj.urlList.length;

     // alert("urlList size:"+JSON.stringify($scope.listobj.urlList.length));


      var songs=$scope.listobj.urlList;
       var songs1=$scope.listobj.nameList;
        var poster = ["resources/modules/UserActorMusic/Poster1.jpg"];
        
        var songTitle = document.getElementById("songTitle");
        var fillBar = document.getElementById("fill");
        
        var song = new Audio();
        var currentSong = 0;    // it point to the current song
        
        window.onload = $scope.playSong;   // it will call the function playSong when window is load
        
        // function playSong(){

          $scope.playSong=function(){
            
            song.src = songs[currentSong];  //set the source of 0th song 
            
            songTitle.textContent = songs1[currentSong]; // set the title of song
            
            song.play();    // play the song
        }
        
        // function playOrPauseSong(){
           $scope.playOrPauseSong=function(){
             
            if(song.paused){
                song.play();
                $("#play img").attr("src","resources/modules/UserActorMusic/Pause.png");
            }
            else{
                song.pause();
                $("#play img").attr("src","resources/modules/UserActorMusic/Play.png");
            }
        }
        
        song.addEventListener('timeupdate',function(){ 
            
            var position = song.currentTime / song.duration;
            
            fillBar.style.width = position * 100 +'%';
        });
        
    
        // function next(){
            $scope.next=function(){
                  currentSong++;
           if(currentSong > $scope.listobj.urlList.length-1){
                currentSong = 0;
            }
            $scope.playSong();
            $("#play img").attr("src","resources/modules/UserActorMusic/Pause.png");
            $("#image img").attr("src",poster[currentSong]);
            $("#bg img").attr("src",poster[currentSong]);
        }
    
        // function pre(){
          $scope.pre=function(){
            
            currentSong--;
            if(currentSong < 0){
                currentSong =$scope.listobj.urlList.length-1;
            }
            $scope.playSong();
            $("#play img").attr("src","resources/modules/UserActorMusic/Pause.png");
            $("#image img").attr("src",poster[currentSong]);
            $("#bg img").attr("src",poster[currentSong]);
        }
        
   
    
  
    })

   }


   // $scope.getActiveSongsUrl1();






       // var songs=["resources/modules/Music/swarghanava.mp3","resources/modules/Music/YaadHai.mp3"];
       
    
    
        // var songs = ["resources/modules/Music/swarghanava.mp3","resources/modules/Music/YaadHai.mp3","resources/modules/Music/swarghanava1.mp3"];
        // var poster = ["Poster1.jpg","Poster2.jpg","Poster1.jpg"];
        
        // var songTitle = document.getElementById("songTitle");
        // var fillBar = document.getElementById("fill");
        
        // var song = new Audio();
        // var currentSong = 0;    // it point to the current song
        
        // window.onload =  $scope.playSong;   // it will call the function playSong when window is load
        
        // // function playSong(){
        //     $scope.playSong=function(){
        //     song.src = songs[currentSong];  //set the source of 0th song 
            
        //     songTitle.textContent = songs[currentSong]; // set the title of song
            
        //     song.play();    // play the song
        // }
        
        // // function playOrPauseSong(){
        //     $scope.playOrPauseSong=function(){
        //     if(song.paused){
        //         song.play();
        //         $("#play img").attr("src","resources/modules/Music/Pause.png");
        //     }
        //     else{
        //         song.pause();
        //         $("#play img").attr("src","resources/modules/Music/Play.png");
        //     }
        // }
        
        // song.addEventListener('timeupdate',function(){ 
            
        //     var position = song.currentTime / song.duration;
            
        //     fillBar.style.width = position * 100 +'%';
        // });
        
    
        // // function next(){
        //     $scope.next=function(){
        //     currentSong++;
        //     if(currentSong > 2){
        //         currentSong = 0;
        //     }
        //     $scope.playSong();
        //     $("#play img").attr("src","resources/modules/Music/Pause.png");
        //     $("#image img").attr("src",poster[currentSong]);
        //     $("#bg img").attr("src",poster[currentSong]);
        // }
    
        // // function pre(){
        //     $scope.pre=function(){
        //     currentSong--;
        //     if(currentSong < 0){
        //         currentSong = 2;
        //     }
        //      $scope.playSong();
        //     $("#play img").attr("src","resources/modules/Music/Pause.png");
        //     $("#image img").attr("src",poster[currentSong]);
        //     $("#bg img").attr("src",poster[currentSong]);
        // }
    


});






app.service("actormusicservice",function($http){
  

 
 this.getActiveGenre=function(){
   
    return $http.get(hostUrl+"getActiveGenre/");
  }


  this.getGenerWiseSong=function(userGenereObj){
   // alert(generId);
    return $http.post(hostUrl+"/getSongWiseActiveGenere",userGenereObj);
  }

this.getSongUrlBySongIdWIse=function(songId){
   
    return $http.get(hostUrl+"getSongUrlBySongIdWIseAPI/"+songId);
  }

this.getSongsUrlBySongIdWIse=function(){
   
    return $http.get(hostUrl+"getSongsUrlBySongIdWIse");
  }

  });