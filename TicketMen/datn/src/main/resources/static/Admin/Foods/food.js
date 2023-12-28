app.controller("food-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.food = [];
    $scope.form = {};

    $scope.updateBtn = true;
    $scope.createBtn = true;

    //Hiển thị thông báo
    $scope.sweetAlert = function (icon, message) {
        Swal.fire({
            icon: icon,
            title: message,
            theme: 'bootstrap 4',
        });
    }

    $scope.initialize = function () {
        //load products
        $http.get("/rest/foods").then(resp => {
            $scope.items = resp.data;            
            $scope.reset();
        });

        //load categories
        $http.get("/rest/foods").then(resp => {
            $scope.food = resp.data;
        })

    }

    //Khởi đầu
    $scope.initialize();


    //Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            poster: 'OIP2.jpg',
            available: true,
        }

        $scope.updateBtn = true;
        $scope.createBtn = false;
    }

    //Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
        $scope.updateBtn = false;
        $scope.createBtn = true;
    }

    //Thêm sản phẩm mới
    $scope.create = function () {
        if (!$scope.form.name || !$scope.form.price) {
            $scope.showInputError = true;
            $scope.sweetAlert("error", "Vui lòng điền đầy đủ và đúng thông tin!");
            return;
        }
    
        $scope.showInputError = false;

        var item = angular.copy($scope.form);
        $http.post(`/rest/foods`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.sweetAlert("success", "Thêm mới thành công!");
            $scope.initialize();
        }).catch(error => {
            $scope.sweetAlert("error", "Thêm mới thất bại!");
            console.log("Error", error);
        })
    }

    //Cập nhật sản phẩm
    $scope.update = function () {
        if (!$scope.form.name || !$scope.form.price) {
            $scope.showInputError = true;
            $scope.sweetAlert("error", "Vui lòng điền đầy đủ và đúng thông tin!");
            return;
        }
    
        $scope.showInputError = false;

        var item = angular.copy($scope.form);
        $http.put(`/rest/foods/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.sweetAlert("success", "Cập nhật thành công!");
        }).catch(error => {
            $scope.sweetAlert("error", "Cập nhật mới thành công!");
            console.log("Error", error);
        })
    }

    //Xóa sản phẩm
    $scope.delete = function (item) {

        $http.delete(`/rest/foods/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            $scope.sweetAlert("success", "Xóa thành công!");
        }).catch(error => {
            $scope.sweetAlert("error", "Xóa không thành công!");
            console.log("Error", error);
        })
    }

    // Hàm kiểm tra chiều dài ký tự
    $scope.checkMaxLength = function (value, maxLength) {
        return value && value.length > maxLength;
    };
    $scope.checkMinLength = function (value, minLength) {
        return value && value.length < minLength;
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