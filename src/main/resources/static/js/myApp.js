var myApp=angular.module("myApp",[]);

myApp.controller("ListEtudiantController", function($scope,$http) {
	
	$scope.pageEtudiants=null;
	$scope.pageCourante=0;
	$scope.size=5;
	
	$scope.listEtudiants=function(){
		$http.get("etudiants?page="+$scope.pageCourante+"&size="$scope.size)
		.success(function(data)){
			$scope.pageEtudiants=data;
		})
	};
	$scope.listeEtudiant();
	
});

myApp.controller("InscriptionController",function($scope,$http){
	$scope.etudiant={};
	$scope.errors=null;
	$scope.mode={value:"form"}
	$scope.exception={message:null}
	
	
	$scope.saveEtudiant=function(){ 
		
		$http.post("etudiants",$scope.edudiant)
			.success(function(data){ 
				if(!data.errors){
					$scope.etudiant=data;
					$scope.errors=null;
					$scope.mode.value="confirm";
				}
				else{
					$scope.errors=data;
					
				}
					
		})
		.error(function(data) {
			$scope.exception.message=data.message;
		})
		;
	};
		
	
	
	
	
});

myApp.controller("IndexController", function($scope,$http) {
	
	$scope.menu=["inscription","listes","Utilisateurs","Logout"];
	$scope.selectedMenu=null;
	
	$scope.select=function(m){
		$scope.selectedMenu=m;
	};
	
	
	myApp.controller("HistoConnController",function($scope,$http){
		$scope.histoconn={};
		
		
		
		$scope.saveHistoConn=function(){ 
			
			$http.post("histoConnexion",$scope.histoconn)
				.success(function(data){ 
					
						$scope.etudiant=data;
						$scope.errors=null;
						
			})
			
		};
			
		
		
		
		
	});
	
	
	myApp.controller("ListHistoConn", function($scope,$http) {
		
		$scope.pageHistoConn=null;
		$scope.pageCourante=0;
		$scope.size=5;
		
		$scope.listHisto=function(){
			$http.get("Histo?page="+$scope.pageCourante+"&size="$scope.size)
			.success(function(data)){
				$scope.pageHistoConn=data;
			})
		};
		$scope.listeEtudiant();
		
	});
	
	
	
});