angular.module('myApp', ['ngRoute']).config(function ($routeProvider, $locationProvider) {
    $routeProvider.when('/home', {
        templateUrl: 'partials/home.html',
        controller: 'homeController'
    })
    .when('/login', {
        templateUrl: 'partials/login.html',
        controller: 'loginController'
    })
    .when('/usuarios', {
        templateUrl: 'partials/usuarios.html',
        controller: 'usuariosController'
    })
    .when('/chat', {
        templateUrl: 'partials/chat.html',
        controller: 'chatController'
    })
    .when('/acessoNegado', {
        templateUrl: 'partials/acessoNegado.html',
        controller: 'acessoNegadoController'
        })
    .otherwise({ 
        redirectTo: '/home'
    });
})

.controller('pageController', function ($scope, usuariosService) {
    $scope.logout = function(){
        usuariosService.logout();
    }
})

.controller('homeController', function ($scope) {

})

.controller('loginController', function ($scope, usuariosService) {
    $scope.logar = function(usuario){
        usuariosService.validaLogin(usuario);
    }
})

.controller('usuariosController', function ($scope, $http) {
    $scope.usuarios = []; 
	getUsuarioDetails();

	function getUsuarioDetails() {
		$http({
			method : "GET",
			url : 'users'
		}).then(function successCallback(response) {
			$scope.usuarios = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}    
})

.controller('chatController', function ($scope) {

})

.controller('acessoNegadoController', function ($scope) {
    
})

.service('usuariosService', function ($rootScope, $location, $http) {
    this.validaLogin = function(usuario) {
		$http({
			method : "POST",
			url : 'login',
			data : angular.toJson(usuario)
		}).then(function successCallback(response) {
            $rootScope.usuarioLogado = response.data;
            $location.path('/home')
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
    }
    this.logout = function() {
        $rootScope.usuarioLogado = null;
        $location.path('/home')
    }
})

//.service('chatService', function () {
//	var ws;
//    this.connect = function(usuario) {
//		$http({
//			method : "POST",
//			url : 'chat',
//			data : angular.toJson(usuario)
//		}).then(function successCallback(response) {
//            $rootScope.usuarioLogado = response.data;
//            $location.path('/home')
//		}, function errorCallback(response) {
//			console.log(response.statusText);
//		});
//    }
//})

.run(function ($rootScope, $location) {
    //Rotas que necessitam do login
    var rotasBloqueadasUsuariosNaoLogados = ['/chat', '/usuarios'];
    var rotasBloqueadasUsuariosComuns = ['/chat', '/usuarios'];
    $rootScope.$on('$locationChangeStart', function () { 
    	//iremos chamar essa função sempre que o endereço for alterado
        /*  podemos inserir a logica que quisermos para dar ou não permissão ao usuário.
         Neste caso, vamos usar uma lógica simples. Iremos analisar se o link que o usuário está tentando acessar (location.path())
         está no Array (rotasBloqueadasUsuariosNaoLogados) caso o usuário não esteja logado. Se o usuário estiver logado, iremos
         validar se ele possui permissão para acessar os links no Array de strings 'rotasBloqueadasUsuariosComuns'
         */
        if ($rootScope.usuarioLogado == null && rotasBloqueadasUsuariosNaoLogados.indexOf($location.path()) != -1) {
            $location.path('/acessoNegado');
        } else if ($rootScope.usuarioLogado != null && rotasBloqueadasUsuariosComuns.indexOf($location.path()) != -1 && $rootScope.usuarioLogado.admin == false) {
            $location.path('/acessoNegado')
        }
    });
});