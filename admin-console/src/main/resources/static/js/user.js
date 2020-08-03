var language = {
    "sProcessing": "处理中...",
    "sLengthMenu": "显示 _MENU_ 项结果",
    "sZeroRecords": "没有匹配结果",
    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
    "sInfoPostFix": "",
    "sSearch": "搜索:",
    "sUrl": "",
    "sEmptyTable": "表中数据为空",
    "sLoadingRecords": "载入中...",
    "sInfoThousands": ",",
    "oPaginate": {
        "sFirst": "首页",
        "sPrevious": "上页",
        "sNext": "下页",
        "sLast": "末页"
    },
    "oAria": {
        "sSortAscending": ": 以升序排列此列",
        "sSortDescending": ": 以降序排列此列"
    }
}
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
                "render": function (id) {
                    var btn1 = '<a class="btn btn-xs btn-warning" href="#"><i class="fa fa-pencil fa-fw"></i> 编辑</a>  ';
                    var btn2 = '<a class="btn btn-xs btn-danger" onclick="removeUser(id)"><i class="fa fa-trash-o fa-fw"></i> 删除</a>  ';
                    return btn1 + btn2;
                }
            }
        ]
    });
});


function removeUser(id) {
    alert(id);
}