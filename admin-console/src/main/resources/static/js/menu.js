let menuTree;

let treeSetting = {
    check: {
        enable: true
    },
    view: {
        addHoverDom: addHoverDom,
        removeHoverDom: removeHoverDom,
        editHoverDom: editHoverDom,
        selectedMulti: false
    },
    edit: {
        enable: true,
        editNameSelectAll: true,
        showRemoveBtn: true,
        showRenameBtn: true,
        renameTitle: "编辑",
        removeTitle: "删除"
    },
    data: {
        key: {
            name: "name"
        },
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid",
            rootPId: ""
        }
    },
    callback: {
        beforeRemove: beforeRemove,
        onRemove: onRemove,
        beforeEditName: beforeEditName,
        beforeRename: beforeRename,
        onRename: onRename
    }
};

$(function () {
    loadMenuTree();
})

function loadMenuTree() {
    $.ajax({
        url: "/menu/tree",
        method: "get",
        dataType: "json",
        success: function (data) {
            menuTree = $.fn.zTree.init($("#menuTree"), treeSetting, data);
            menuTree.expandAll(true); //展开树
        },
        error: function () {
            alert("加载失败");
        }
    });
}

let log, className = "dark";

function beforeEditName(treeId, treeNode) {
    $('#menu-div').show();
    $("input[name='type']").val('edit');
    $("input[name='id']").val(treeNode.id);
    $("input[name='name']").val(treeNode.name);
    $("input[name='url']").val(treeNode.url);
    $("input[name='icon']").val(treeNode.icon);
    $('#previewIcon').attr('class', '').addClass('fas').addClass(treeNode.icon);
    return false;
}

function beforeRemove(treeId, treeNode) {
    className = (className === "dark" ? "" : "dark");
    menuTree.selectNode(treeNode);
    return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}

function onRemove(e, treeId, treeNode) {
    console.log(treeNode);
    $.ajax({
        url: "/menu/remove/" + treeNode.id,
        method: "POST",
        success: function (data) {
            if (data.statusCode === 0) {
                loadMenuTree();
            } else {
                alert("删除失败：" + data.statusMsg);
            }
        },
        error: function () {
            alert("加载失败");
        }
    });
}

function beforeRename(treeId, treeNode, newName, isCancel) {
    className = (className === "dark" ? "" : "dark");
    if (newName.length === 0) {
        setTimeout(function () {
            let zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.cancelEditName();
            alert("节点名称不能为空.");
        }, 0);
        return false;
    }
    return true;
}

function onRename(e, treeId, treeNode, isCancel) {
}


function getTime() {
    var now = new Date(),
        h = now.getHours(),
        m = now.getMinutes(),
        s = now.getSeconds(),
        ms = now.getMilliseconds();
    return (h + ":" + m + ":" + s + " " + ms);
}

let newCount = 1;

function addHoverDom(treeId, treeNode) {
    let sObj = $("#" + treeNode.tId + "_span");
    if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
    let addStr = "<span class='button add' id='addBtn_" + treeNode.tId
        + "' title='新增' onfocus='this.blur();'></span>";
    sObj.after(addStr);
    let btn = $("#addBtn_" + treeNode.tId);
    if (btn) btn.bind("click", function () {
        $('#menu-div').show();
        $('#menuForm').reset();
        // let zTree = $.fn.zTree.getZTreeObj("menuTree");
        // zTree.addNodes(treeNode, {id: (100 + newCount), pId: treeNode.id, name: "new node" + (newCount++)});
        return false;
    });
};

function editHoverDom(treeId, treeNode) {

}

function removeHoverDom(treeId, treeNode) {
    $("#addBtn_" + treeNode.tId).unbind().remove();
}

function onCancel() {
    $("#addMenu").modal("hide");
    $('#menu-div').hide();
}

function addMenu(form) {
    alert(form);
    $('#addMenuForm').form('submit', {
        url: '/menu/add',
        success: function (data) {
            alert(data);
        }
    });
}

function previewIcon() {
    $('#previewIcon').attr('class', '').addClass('fas').addClass($("input[name='icon']").val());
}

function save() {
    let type = $("input[name='type']").val();
    let url;
    if (type === 'edit') {
        url = '/menu/update';
    } else if (type === 'add') {
        url = '/menu/add';
    }
    $.ajax({
        url: url,
        type: 'POST',
        data: $('#menuForm').serialize(),
        success: function (data) {
            if (data.statusCode === 0) {
                loadMenuTree();
            }
        },
        error: function (data) {

        }
    });
}