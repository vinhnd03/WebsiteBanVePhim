app.controller("product", function($scope, $http){
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    //Hiển thị thông báo
    $scope.showAlert = false; // Không hiển thị thông báo ban đầu

    $scope.alertMessage = ""; // Chuỗi thông báo

    $scope.showAlertMessage = function (message) {
        $scope.alertMessage = message;
        $scope.showAlert = true;
    };

    $scope.closeAlert = function () {
        $scope.showAlert = false;
        $scope.alertMessage = "";
    };

    $scope.initialize = function(){
        //load products
        $http.get("/Admin/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
            $scope.reset();
        });

        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        })
        
    }

    //Khởi đầu
    $scope.initialize();
    

    //Xóa form
    $scope.reset = function(){
        $scope.form = {
            createDate: new Date(),
            image: 'OIP2.jpg',
            available: true,
        }
    }

    //Hiển thị lên form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //Thêm sản phẩm mới
    $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.showAlertMessage("Thêm mới thành công")
            $scope.initialize();
        }).catch(error => {
            $scope.showAlertMessage("Thêm mới thất bại")
            console.log("Error", error);
        })
    }

    //Cập nhật sản phẩm
    $scope.update = function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.showAlertMessage("Cập nhật thành công")
        }).catch(error => {
            $scope.showAlertMessage("Cập nhật thất bại")
            console.log("Error", error);
        })
    }

    //Xóa sản phẩm
    $scope.delete = function(item){       
        $http.delete(`/rest/products/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            $scope.showAlertMessage("Xóa thành công")
        }).catch(error => {
            $scope.showAlertMessage("Lỗi xóa sản phẩm")
            console.log("Error", error);
        })
    }

    //Upload hình
    $scope.imageChanged = function(files){
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            $scope.showAlertMessage("Lỗi Update ảnh")
            console.log("Error", error);
        })
    }

    $scope.pager = {
        page: 0,
        size: 5,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page < 0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page  >= this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count - 1; 
        }
    }
});


//5 trang (0, 1, 2, 3, 4)