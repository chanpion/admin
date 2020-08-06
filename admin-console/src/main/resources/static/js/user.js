$(function () {
    $("#userTable").DataTable({
        "language": {
            "url": "plugins/datatables/lang.json"
        },
        "paging": true,
        "lengthChange": true,
        "searching": true,
        "ordering": true,
        "info": true,
        "responsive": true,
        "autoWidth": false,
        "ajax": {
            "url": "/user/all",
            "dataType": "json",
            "type": "GET",
            "dataSrc": function (result) {
                return result;
            }
        },
        "columns": [
            {"data": "id"},
            {"data": "username"},
            {"data": "age"},
            {"data": "createTime"},
            {"data": "id"}
        ],
        "columnDefs": [
            {
                "targets": -1,
                "data": null,
                "render": function (data) {
                    var btn1 = '<a class="btn btn-sm btn-info" onclick="editUser(' + data + ')"><i class="fas fa-pencil-alt"></i> 编辑</a>  ';
                    var btn2 = '<a class="btn btn-sm btn-danger"  data-toggle="modal" data-target="#modal-default"><i class="fas fa-trash"></i> 删除</a>  ';
                    return btn1 + btn2;
                }
            }
        ]
    });

    $('#registerForm').submit(function (e) {
        var formData = new FormData(this);
        $.ajax({
            async: false,
            type: "POST",
            url: "/user/register",
            data: formData,
            dataType: $('#registerForm').serialize(),
            success: function (data) {
                if (data.success) {
                    layer.alert("上传成功")
                } else {
                    layer.alert(data.error)
                }
            }
        });
        return false;
    });


});


function removeUser(data) {
    alert(data);
}

function editUser(data) {
    alert(data);
}