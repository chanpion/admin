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
            {"data": "email"},
            {"data": "age"},
            {"data": "createTime"},
            {"data": "id"}
        ],
        "columnDefs": [
            {
                "targets": -1,
                "data": null,
                "render": function (data) {
                    var btn1 = '<a class="btn btn-sm btn-info" data-toggle="modal" data-target="#modal-update-user" onclick="editUser(' + data + ')"><i class="fas fa-pencil-alt"></i> 编辑</a>  ';
                    var btn2 = '<a class="btn btn-sm btn-danger"  data-toggle="modal" data-target="#modal-remove" onclick="confirmRemoveUser(' + data + ')"><i class="fas fa-trash"></i></a>  ';
                    return btn1 + btn2;
                }
            }
        ]
    });

    $('#registerForm').submit(function (e) {
        return false;
    });


});

function confirmRemoveUser(id) {
    $("#removeId").val(id);
}

function removeUser() {
    var id = $("#removeId").val();
    $.ajax({
        url: "/user/remove/" + id,
        type: "post",
        success: function (data) {
            $('#modal-add-user').modal('hide');
            $('#userTable').DataTable().ajax.reload()
        },
        error: function (msg) {
            alert("请求异常！");
        }
    })
    $('#modal-remove').modal('hide');
    $("#removeId").val('');
}

function editUser(id) {
    $.ajax({
        url: "/user/id/" + id,
        type: "get",
        success: function (data) {
            $('#form-update-user input').each(function (index, element) {
                var name = $(element).attr("name");
                alert(index + ":" + name);
            });
        },
        error: function (msg) {
            alert("请求异常！");
        }
    });
}

function addUser() {
    $.ajax({
        url: "/user/register",
        type: "post",
        data: $('#form-add-user').serialize(),
        success: function (data) {
            $('#modal-add-user').modal('hide');
            $('#userTable').DataTable().ajax.reload()
        },
        error: function (msg) {
            alert("请求异常！");
        }
    })
}

