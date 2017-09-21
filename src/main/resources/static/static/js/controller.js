var app = angular.module("admin",[]);



app.service('viewService',function(){
	
var view = "default";

	changeView = function(obj){
		console.log("changing View");
		view = obj;
	};
	getView = function(){
		return view;
	};
	return {
		changeView: changeView,
		getView: getView
	};	

});

app.controller("sidebarCtrl",function($scope){

	$scope.changeView = function(obj){
		console.log(obj);
		/*viewService.changeView(obj);*/
		/*$rootScope.$emit("callContainerCtrlMethodToChangeView",{});*/
	};

});

app.controller("containerCtrl",function($scope,$http){

	/*$scope.view = viewService.getView();*/
	$scope.departments=[];
	var removeDepartmentList = [];

	$scope.getDepartments = function(){
		$http({
			method:'GET',
			url:"system/departments"
		})
			.then(function(response){
				console.log(response);
				$scope.departments = response.data;
			}
			,function(error){
				console.log("Error in fetching departments");
			});
	};

	$scope.checkAllDepartments = function(){
		if($scope.checkAll)
			$scope.checkAll = false;
		else
			$scope.checkAll = true;

		if(event.target.checked){ 
			removeDepartmentList = $scope.departments;
			$scope.removeBtnDisable = false;
			angular.forEach($scope.departments,function(dept){
			dept.selected = event.target.checked;
		});
		}
		else{
			removeDepartmentList = [];
			$scope.removeBtnDisable = true;
		}
	};

	$scope.toggleChange = function(dept){
		if(event.target.checked){

			if(removeDepartmentList.indexOf(dept) == -1){

				removeDepartmentList.push(dept);
			
			}
		}
		else{
		/*removeDepartmentList.splice($scope.departments.indexOf(dept),1);*/
		var temp = [];
		angular.forEach(removeDepartmentList,function(d){
			if(d.departmentId != dept.departmentId)
				temp.push(d);
		});
		removeDepartmentList = temp;
		}

		if(removeDepartmentList.length > 0)
			$scope.removeBtnDisable = false;
		else
			$scope.removeBtnDisable = true;
		if($scope.departments.length == removeDepartmentList.length)
			$scope.checkAll = true;
		else if($scope.departments.length > removeDepartmentList.length)
			$scope.checkAll = false;

	};

	$scope.initialize = function(){
		$scope.checkAll = false;
		$scope.removeBtnDisable = true;
		$scope.departments = [{"departmentId":1,"departmentName":"COE","headOfDepartment":"AP SINGH"},
	{"departmentId":2,"departmentName":"Information Technology","headOfDepartment":"Janini Paridhi"},
	{"departmentId":3,"departmentName":"COE","headOfDepartment":"AP SINGH"},
	{"departmentId":4,"departmentName":"Information Technology","headOfDepartment":"Janini Paridhi"},
	{"departmentId":5,"departmentName":"COE","headOfDepartment":"AP SINGH"},
	{"departmentId":6,"departmentName":"Information Technology","headOfDepartment":"Janini Paridhi"}];
	
	};

	$scope.removeSelected = function(){
		if($scope.departments.length == removeDepartmentList.length){
			$scope.departments = [];
			$scope.checkAll = false;
			$scope.removeBtnDisable = true;
		}
		else if($scope.departments.length > removeDepartmentList.length){
			console.log(removeDepartmentList);
			angular.forEach(removeDepartmentList,function(dept){
				for(var i=0;i<$scope.departments.length;i++){
					if(dept.departmentId == $scope.departments[i].departmentId){
						$scope.departments.splice(i,1);
						break;
					}
				}	

			});
		};
		removeDepartmentList = [];
		$scope.removeBtnDisable = true;
	};
	/*$rootScope.$on("callContainerCtrlMethodToChangeView",function(){
		changeView();
	});*/

});