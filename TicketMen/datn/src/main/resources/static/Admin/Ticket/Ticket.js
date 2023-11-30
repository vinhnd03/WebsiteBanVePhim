app.controller("ticket-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.rooms = [];
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
        //load tickets
        $http.get("/rest/tickets").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.date = new Date(item.date)
                // Chuyển đổi thời gian thành đúng định dạng "HH:mm a"
                const timeParts = item.time.split(':');
                const hours = parseInt(timeParts[0], 10);
                const minutes = parseInt(timeParts[1], 10);
                const timeDate = new Date();
                timeDate.setHours(hours);
                timeDate.setMinutes(minutes);
                timeDate.setSeconds(0);
                timeDate.setMilliseconds(0);
                item.time = timeDate;
            })
            $scope.reset();
        });

        //load tickettypes
        $http.get("/rest/movies").then(resp => {
            $scope.cates = resp.data;
        })
        $http.get("/rest/rooms").then(resp => {
            $scope.rooms = resp.data;
        })

        

    }

    //Khởi đầu
    $scope.initialize();


    //Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
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
        var item = angular.copy($scope.form);
        $http.post(`/rest/tickets`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.sweetAlert("success", "Tạo vé thành công!");
            $scope.initialize();
        }).catch(error => {
            $scope.sweetAlert("error", "Tạo vé thất bại!");
            console.log("Error", error);
        })
    }

    //Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/tickets/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.sweetAlert("success", "Cập nhật vé thành công!");
            $scope.initialize();
        }).catch(error => {
            $scope.sweetAlert("error", "Cập nhật vé thất bại!");
            console.log("Error", error);
        })
    }

    //Xóa sản phẩm
    $scope.delete = function (item) {

        $http.delete(`/rest/tickets/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            $scope.sweetAlert("success", "Xóa vé thành công!");
        }).catch(error => {
            $scope.sweetAlert("error", "Xóa vé thất bại!");
            console.log("Error", error);
        })
    }

    //Upload hình
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/image', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.poster = resp.data.name;
        }).catch(error => {
            $scope.sweetAlert("error", "Lỗi tải lên ảnh!");
            console.log("Error", error);
        })
    }

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