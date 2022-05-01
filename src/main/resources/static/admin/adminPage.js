angular.module('demo-front')
.controller('adminController', function($scope, $http) {
    const contextPath = 'http://localhost:8189/demo/api/v1/';


    $scope.createNewClient = function() {
        $http.post(contextPath + 'clients/', $scope.new_client)
        .then(function successCallback (response) {
            $scope.new_client = null;
            alert("Успех");
        }, function failureCallback (response) {
            if ($scope.new_client == null) {
                alert('Не создан объект!');
            } else {
                alert(response.data.message);
            }
        });
    };
});