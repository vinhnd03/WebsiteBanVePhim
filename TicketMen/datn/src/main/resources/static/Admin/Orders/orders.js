app.controller("orders-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.details1 = [];
    $scope.form = {};
    $scope.totalTicketPrice = 0;


    
    $scope.initialize = function () {
        //load products
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;
                    
        });

    }

    $scope.view = function(item){
        $scope.form = angular.copy(item);
        $http.get("/rest/orderDetails/getOrderDetail/" + item.id).then(resp => {
            $scope.details1 = resp.data;   
        });
    }

    //Khởi đầu
    $scope.initialize();    


    $scope.updateTotalTicketPrice = function() {
        $scope.totalTicketPrice = 0;
        angular.forEach($scope.details, function(item) {
            $scope.totalTicketPrice += item.ticket.price;
        });
    };
    $scope.pager = {
        page: 0,
        size: 5,
        get items() {
            var start = this.page * this.size;
            //console.log(start + "..." + this.size);
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }
});