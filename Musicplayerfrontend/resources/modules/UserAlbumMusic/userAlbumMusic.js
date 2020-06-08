app.controller("userAlbumCtrlmusic",function($state,$scope,$stateParams,Albummusicservice,$window){
 
// alert("priya");
$scope.userAlbumObj={};
$scope.obj1={};







$scope.obj1=angular.copy($stateParams.obj4);

   alert("obj1"+JSON.stringify($scope.obj1));




      // $scope.urlsize=$scope.obj1[0].length;

        // alert("obj song"+JSON.stringify($scope.obj1[0]));
console.log("size url"+JSON.stringify($scope.urlsize));

      var songs=$scope.obj1;
      var str = "resources/assets/Songs/";
     





       var songs1=$scope.obj1;
        var poster = ["resources/modules/UserAlbumMusic/Poster1.jpg"];
        
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
                $("#play img").attr("src","resources/modules/UserAlbumMusic/Pause.png");
            }
            else{
                song.pause();
                $("#play img").attr("src","resources/modules/UserAlbumMusic/Play.png");
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
            $("#play img").attr("src","resources/modules/UserAlbumMusic/Pause.png");
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
            $("#play img").attr("src","resources/modules/UserAlbumMusic/Pause.png");
            $("#image img").attr("src",poster[currentSong]);
            $("#bg img").attr("src",poster[currentSong]);
        }
        
   
    



});






app.service("Albummusicservice",function($http){
  

 
//  this.getActiveGenre=function(){
   
//     return $http.get(hostUrl+"getActiveGenre/");
//   }


//   this.getGenerWiseSong=function(userGenereObj){
//    // alert(generId);
//     return $http.post(hostUrl+"/getSongWiseActiveGenere",userGenereObj);
//   }

// this.getSongUrlBySongIdWIse=function(songId){
   
//     return $http.get(hostUrl+"getSongUrlBySongIdWIseAPI/"+songId);
//   }

// this.getSongsUrlBySongIdWIse=function(){
   
//     return $http.get(hostUrl+"getSongsUrlBySongIdWIse");
//   }

  });