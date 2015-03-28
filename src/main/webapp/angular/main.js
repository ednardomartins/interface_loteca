var app = angular.module('myApp', [ 'ngGrid' ]);
app.controller('MyCtrl', function($scope, $http) {
	$scope.filterOptions = {
		filterText : "",
		useExternalFilter : true
	};
	$scope.totalServerItems = 0;
	$scope.pagingOptions = {
		pageSizes : [ 20, 10, 20 ],
		pageSize : 20,
		currentPage : 1
	};
	$scope.setPagingData = function(data, page, pageSize) {
		var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
		$scope.myData = pagedData;
		$scope.totalServerItems = data.length;
		if (!$scope.$$phase) {
			$scope.$apply();
		}
	};
	$scope.getPagedDataAsync = function(pageSize, page, searchText) {
		setTimeout(function() {
			$http.get('http://localhost:8080/informacoesClube').success(
					function(data) {
						$scope.setPagingData(data, page, pageSize);
					});
		}, 100);
	};

	$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
			$scope.pagingOptions.currentPage);

	$scope.$watch('pagingOptions', function(newVal, oldVal) {
		if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
			$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
					$scope.pagingOptions.currentPage,
					$scope.filterOptions.filterText);
		}
	}, true);
	$scope.$watch('filterOptions', function(newVal, oldVal) {
		if (newVal !== oldVal) {
			$scope.getPagedDataAsync($scope.pagingOptions.pageSize,
					$scope.pagingOptions.currentPage,
					$scope.filterOptions.filterText);
		}
	}, true);

	$scope.gridOptions = {
		data : 'myData',
		enablePaging : true,
		showFooter : true,
		totalServerItems : 'totalServerItems',
		pagingOptions : $scope.pagingOptions,
		filterOptions : $scope.filterOptions
	};
});