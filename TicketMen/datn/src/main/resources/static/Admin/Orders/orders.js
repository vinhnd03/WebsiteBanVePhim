app.controller("orders-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.details1 = [];
    $scope.form = {};
    $scope.totalTicketPrice = 0;
    $scope.totalFoodPrice = 0;

    
    $scope.initialize = function () {
        //load products
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;


            resp.data.forEach(food => {
                $http.get("/rest/foods/getFoodOrder/" + food.id).then(resp => {
                    food.details1 = resp.data;  
                });
            });
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
        $scope.totalFoodPrice = 0;
        angular.forEach($scope.details1, function(item) {
            $scope.totalTicketPrice += item.ticket.price;
        });
        angular.forEach($scope.form.details1, function(food){
            $scope.totalFoodPrice += food.food.price * food.quantity;
        })
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