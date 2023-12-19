app.controller("category-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.updateBtn = true;
    $scope.createBtn = true;

    // Hiển thị thông báo
    $scope.sweetAlert = function (icon, message) {
        Swal.fire({
            icon: icon,
            title: message,
            theme: 'bootstrap 4',
        });
    };

    

    // Khởi tạo
    $scope.initialize = function () {
        // Load danh mục
        $http.get("/rest/categories").then(resp => {
            $scope.items = resp.data;            
            $scope.reset();
        });

        // Load danh sách danh mục
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });
    };

    // Khởi đầu
    $scope.initialize();

    // Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            poster: 'OIP2.jpg',
            available: true,
        };

        $scope.updateBtn = true;
        $scope.createBtn = false;
    };

    // Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show');
        $scope.updateBtn = false;
        $scope.createBtn = true;
    };


    // check xem đã tồn tại chưa
    $scope.checkCatenameExistence = function (name) {
        // Gửi yêu cầu kiểm tra tài khoản đến server
        $http.get(`/rest/categories?name=${name}`).then(resp => {
            // Nếu có kết quả trả về, tài khoản đã tồn tại
            if (resp.data) {
                $scope.sweetAlert("error", "Thể loại đã tồn tại!");
            } else {
                // Ngược lại, tài khoản chưa tồn tại
                $scope.sweetAlert("success", "Thể loại có thể sử dụng!");
            }
        }).catch(error => {
            console.log("Error checking username existence", error);
        });
    };
    //

    // Thêm danh mục mới
    $scope.create = function () {
        // Kiểm tra các trường bắt buộc
        if (!$scope.form.name) {
            $scope.showInputError = true;
            $scope.sweetAlert("error", "Vui lòng điền đầy đủ và đúng thông tin!");
            return;
        }

        // Kiểm tra sự tồn tại của danh mục
        $scope.checkCategoryExistence($scope.form.name);
        $scope.showInputError = false;

        var item = angular.copy($scope.form);
        $http.post(`/rest/categories`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate);
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.sweetAlert("success", "Thêm mới thành công!");
            $scope.initialize();
        }).catch(error => {
            $scope.sweetAlert("error", "Thêm mới thất bại!");
            console.log("Error", error);
        });
    };

    // Cập nhật danh mục
    $scope.update = function () {
        // Kiểm tra các trường bắt buộc
        if (!$scope.form.name) {
            $scope.showInputError = true;
            $scope.sweetAlert("error", "Vui lòng điền đầy đủ và đúng thông tin!");
            return;
        }

        // Kiểm tra sự tồn tại của danh mục
        $scope.checkCategoryExistence($scope.form.name);
        $scope.showInputError = false;

        var item = angular.copy($scope.form);
        $http.put(`/rest/categories/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.sweetAlert("success", "Cập nhật thành công!");
        }).catch(error => {
            $scope.sweetAlert("error", "Cập nhật mới thành công!");
            console.log("Error", error);
        });
    };

    // Xóa danh mục
    $scope.delete = function (item) {
        $http.delete(`/rest/categories/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            $scope.sweetAlert("success", "Xóa thành công!");
        }).catch(error => {
            $scope.sweetAlert("error", "Xóa không thành công!");
            console.log("Error", error);
        });
    };

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
    };
});
