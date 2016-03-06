app.controller('customersCtrl', function($scope, $http) {
	
			
	$http({
		method : 'GET',
		url : 'customerJS'
	}).success(function(data, status, headers, config) {
		$scope.persons = data;
	}).error(function(data, status, headers, config) {
		// called asynchronously if an error occurs
		// or server returns response with an error status.
	});

	
 $scope.customerTableBtnClick = function(person) {
        $scope.customer=person;
   	 if(person.isPremium){
		 $scope.status="Premium";
	 }else{
		 $scope.status="Regular";
	 }
   	$("#vehicleInfoModal").modal(); 
 }

 
 $scope.generateInvoice=function(isic, month){
	 $scope.monthIndex=month;
		$http({
			method : 'GET',
			url : 'invoiceJS',
			params: {isic : isic,
					month : month	}	
		}).success(function(data, status, headers, config) {
			$scope.invoice = data;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});
	 
	 $("#invoiceModal").modal(); 
 }

	  $scope.months =[ 'January',
	                   'February',
	                   'March',
	                   'April',
	                   'May',
	                   'June',
	                   'July ',
	                   'August',
	                   'September',
	                   'October',
	                   'November',
	                   'December',
	                   ];
	  $scope.monthIndex=new Date().getMonth();
 

});