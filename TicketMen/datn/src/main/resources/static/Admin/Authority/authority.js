app.controller("authority-ctrl", function($scope, $http, $location){
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    //Hiển thị thông báo
    $scope.sweetAlert = function (icon, message) {
        Swal.fire({
            icon: icon,
            title: message,
            theme: 'bootstrap 4',
        });
    }

    $scope.initialize = function(){
        //load all roles
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })

        //load staffs and directors (administration)
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
        })

        //load authorities of staffs and directors
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
        }).catch(error => {
            $location.path("/unauthorized")
        })
    }

    $scope.authority_of = function(acc, role){
        if($scope.authorities){
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id);
        }
    }

    $scope.authority_changed = function(acc, role){
        var authority = $scope.authority_of(acc, role);
        if(authority){ // đã cấp quyền => thu hồi quyền(xóa)
            $scope.revoke_authority(authority);
        }
        else{// chưa được cấp quyền => cấp quyền(thêm mới)
            authority = {account: acc, role: role};
            $scope.grant_authority(authority);
        }
    }

    //Thêm mới authority
    $scope.grant_authority = function(authority){
        $http.post(`/rest/authorities`, authority).then(resp => {
            $scope.authorities.push(resp.data)
            $scope.sweetAlert("success", "Cấp quyền sử dụng thành công!")
        }).catch(error => {
            $scope.sweetAlert("error", "Cấp quyền sử dụng thất bại!")
            console.log("Error", error);
        })
    }
    
    // Xóa authority
$scope.revoke_authority = function(authority) {
    // Kiểm tra nếu quyền đang được thu hồi là quyền của quản trị viên
    if (authority.role.isAdmin) {
        $scope.sweetAlert("warning", "Không thể thu hồi quyền của quản trị viên!");
        return;
    }

    $http.delete(`/rest/authorities/${authority.id}`)
        .then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
            $scope.sweetAlert("success", "Thu hồi quyền sử dụng thành công!");
        })
        .catch(error => {
            $scope.sweetAlert("error", "Thu hồi quyền sử dụng thất bại! " + error.data.message);
            console.log("Error", error);
        });
}


    

    $scope.initialize();
})