var app=angular.module('myApp', ['ngMaterial','ui.router','ui.bootstrap','smart-table','ngSanitize']);


var hostUrl="http://localhost:9911/";


app.config(function($stateProvider, $urlRouterProvider) 
{

	$urlRouterProvider.otherwise('/userLogin');
 	$stateProvider

 	




.state('userLogin', {
    
    url : '/userLogin',

    templateUrl : 'resources/modules/UserLogin/userLogin.html'

    })



.state('userWeatherMaster', {
    
    url : '/userWeatherMaster',

    templateUrl : 'resources/modules/UserWeatherMaster/userWeatherMaster.html'

    })


.state('userGenreMusic', {
    
    url : '/userGenreMusic',

    templateUrl : 'resources/modules/UserGenreMusic/userGenreMusic.html',

    params:
    {
        'obj2':null
    }

    })




.state('userRegistration', {
    
    url : '/userRegistration',

    templateUrl : 'resources/modules/UserRegistration/userRegistration.html'

    })


.state('genereMaster', {
    
    url : '/genereMaster',

    templateUrl : 'resources/modules/GenereMaster/genereMaster.html'

    })



.state('songMaster', {
    
    url : '/songMaster',

    templateUrl : 'resources/modules/SongMaster/songMaster.html'

    })

.state('weatherMaster', {
    
    url : '/weatherMaster',

    templateUrl : 'resources/modules/WeatherMaster/weatherMaster.html'

    })


.state('playlistMaster', {
    
    url : '/playlistMaster',

    templateUrl : 'resources/modules/PlaylistMaster/playlistMaster.html'

    })


.state('albumMaster', {
    
    url : '/albumMaster',

    templateUrl : 'resources/modules/AlbumMaster/albumMaster.html'

    })


.state('languageMaster', {
    
    url : '/languageMaster',

    templateUrl : 'resources/modules/LanguageMaster/languageMaster.html'

    })

 
 .state('actorMaster', {
    
    url : '/actorMaster',

    templateUrl : 'resources/modules/ActorMaster/actorMaster.html'

    })


.state('artistMaster', {
    
    url : '/artistMaster',

    templateUrl : 'resources/modules/ArtistMaster/artistMaster.html'

    })

.state('adminLogin', {
    
    url : '/adminLogin',

    templateUrl : 'resources/modules/AdminLoginMaster/adminLogin.html'

    })

.state('adminDashboard', {
    
    url : '/adminDashboard',

    templateUrl : 'resources/modules/AdminDashboard/adminDashboard.html'

    })





.state('userDashboard', {
    
    url : '/userDashboard',

    templateUrl : 'resources/modules/UserDashboard/userDashboard.html'

    })




.state('userGenerMaster', {
    
    url : '/userGenerMaster',

    templateUrl : 'resources/modules/UserGenreMaster/userGenerMaster.html'

    })



.state('userActorMaster', {
    
    url : '/userActorMaster',

    templateUrl : 'resources/modules/UserActorMaster/userActorMaster.html'

    })



.state('userAlbumMaster', {
    
    url : '/userAlbumMaster',

    templateUrl : 'resources/modules/UserAlbumMaster/userAlbumMaster.html'

    })

 .state('userArtistMaster', {
        
     url : '/userArtistMaster',

    templateUrl : 'resources/modules/UserArtistMaster/userArtistMaster.html'

     })

 .state('userLanguageMaster', {
    
     url : '/userLanguageMaster',

    templateUrl : 'resources/modules/UserLanguageMaster/userLanguageMaster.html'

     })

.state('userPlaylistMaster', {
    
    url : '/userPlaylistMaster',

    templateUrl : 'resources/modules/UserPlaylistMaster/userPlaylistMaster.html'

    })


.state('userActorMusic', {
    
    url : '/userActorMusic',

    templateUrl : 'resources/modules/UserActorMusic/userActorMusic.html',

    params:
    {
        'obj3':null
    }

    })

.state('userAlbumMusic', {
    
    url : '/userAlbumMusic',

    templateUrl : 'resources/modules/UserAlbumMusic/userAlbumMusic.html',
    
     params:
    {
        'obj4':null
    }

    })

.state('userArtistMusic', {
    
    url : '/userArtistMusic',

    templateUrl : 'resources/modules/UserArtistMusic/userArtistMusic.html',

    params:
    {
        'obj5':null
    }

    })

 .state('userLanguageMusic', {
    
     url : '/userLanguageMusic',

     templateUrl : 'resources/modules/UserLanguageMusic/userLanguageMusic.html',

     params:
     {
         'obj6':null
     }

    })

.state('userPlaylistMusic', {
    
    url : '/userPlaylistMusic',

    templateUrl : 'resources/modules/UserPlaylistMusic/userPlaylistMusic.html',

    params:
    {
        'obj7':null
    }

    })

// .state('userWeatherMusic', {
    
//     url : '/userWeatherMusic',

//     templateUrl : 'resources/modules/UserWeatherMusic/userWeatherMusic.html',

//     params:
//     {
//         'obj2':null
//     }

//     })






 });

