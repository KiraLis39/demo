(function () {
    angular
        .module('demo-front', ['ngRoute'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
        .when('/', {
            templateUrl: 'welcome/welcome.html',
            controller: 'welcomeController'
        })
        .when('/clients', {
            templateUrl: 'clients/clients.html',
            controller: 'clientsController'
        })
        .when('/admin', {
            templateUrl: 'admin/adminPage.html',
            controller: 'adminController'
        })
        .otherwise({
            redirectTo: '/'
        });
    }

    function run($rootScope, $http) {

    }
})();

angular.module('demo-front')
.controller('indexController', function($rootScope, $scope, $http) {
    const contextPath = 'http://localhost:8189/demo/api/v1/';
});