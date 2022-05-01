angular.module('demo-front')
.controller('clientsController', function($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/demo/api/v1/';
        let currentPageIndex = 1;

        $scope.loadClients = function(pageIndex = 1) {
            currentPageIndex = pageIndex;
            $http({
                url: contextPath + 'clients/data',
                method: 'GET',
                params: {
                    p: pageIndex - 1
                }
            }).then(function(response) {
                $scope.clientsList = response.data.content;
                $scope.paginationArray = $scope.generatePagesIndexes(1, response.data.totalPages);
            });
        };

        $scope.generatePagesIndexes = function (startPage, endPage) {
            let arr = [];
            for (let i = startPage; i < endPage + 1; i++) {
                arr.push(i);
            }
            return arr;
        }

        $scope.showInfo = function(client) {
            alert('id:' + client.id + ' name:' + client.name + ' createDate:' + client.createDate);
        };

        $scope.deleteThat = function(id) {
            $http.delete(contextPath + 'clients/' + id)
            .then(function(response) {
                alert('Объект удален.');
            }).then(function() {
                $scope.loadClients();
            });
        };

        $scope.loadClients();
});