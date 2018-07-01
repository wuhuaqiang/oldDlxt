/**
 * Created by Threecolors on 2017/11/16.
 */
function buildJqGrid(gridData, colNames, colModel, prmNames, title, ba) {
    var gridSelector = "#grid-table";
    var pagerSelector = "#grid-pager";
    buildGridTable(gridSelector, pagerSelector, gridData, colNames, colModel, prmNames, title);
    buildPager(gridSelector, pagerSelector, ba)
}

function buildGridTable(gridSelector, pagerSelector, gridData, colNames, colModel, title) {
    jQuery(gridSelector).jqGrid({
        data: gridData,
        datatype: "local",
        height: document.documentElement.clientHeight - 138 - $("#operDiv").height(),
        colNames: colNames,
        colModel: colModel,
        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pagerSelector,
        altRows: true,
        multiselect: true,
        multiboxonly: true,
        autowidth: true,
        shrinkToFit: isShrinkToFit(colModel),
        autoScroll: true,
        caption: title,
        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);
                updateActionIcons(table);
                updatePagerIcons(table);
                enableTooltips(table);
            }, 0);
        },
    });
}

function buildPager(gridSelector, pagerSelector, ba) {
    var isEdit = ((ba & 8) > 0);
    var isAdd = ((ba & 2) > 0);
    var isDel = ((ba & 4) > 0);

    jQuery(gridSelector).jqGrid('navGrid', pagerSelector,
        {
            edit: isEdit,
            editicon: 'icon-pencil blue',
            add: isAdd,
            addicon: 'icon-plus-sign purple',
            del: isDel,
            delicon: 'icon-trash red',
            search: true,
            searchicon: 'icon-search orange',
            refresh: true,
            refreshicon: 'icon-refresh green',
            view: true,
            viewicon: 'icon-zoom-in grey',
            addfunc: opneAddLayer,
            editfunc: openEditLayer,
            delfunc: openDeleteLayer
        },
        {
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //new record form
            closeAfterAdd: true,
            recreateForm: true,
            viewPagerButtons: false,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //delete record form
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                if (form.data('styled')) return false;

                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);

                form.data('styled', true);
            },
            onClick: function (e) {
                alert(1);
            }
        },
        {
            //search form
            recreateForm: true,
            afterShowSearch: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                style_search_form(form);
            },
            afterRedraw: function () {
                style_search_filters($(this));
            }
            ,
            multipleSearch: true,
        },
        {
            //view record form
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
            }
        }
    )
}

function opneAddLayer() {
    addFunction();
}

function openEditLayer(id) {
    editFunction(id);
}

function openDeleteLayer(ids) {
    top.layer.confirm('是否确定删除选中数据？', {
        btn: ['确认', '取消'] //按钮
    }, function () {
        deleteFunction(ids);//在js中实现调用reload传入参数
    }, function () {
        layer.closeAll();
    });
}

function editMethod(url, layW, layH, title, maxmin) {
    top.layer.open({
        type: 2,
        title: title,
        shadeClose: false,
        shade: [0.2, '#393D49'],
        maxmin: maxmin, //开启最大化最小化按钮
        area: [layW, layH],
        content: url,
        end: function () {
            reloadFunction()
        }
    });
}

function deleteMethod(url, ids) {
    jQuery.ajax({
        type: "Post",
        url: url,
        data: "ids=" + ids,
        success: function (data) {
            var msg = "选择数据不能删除！";
            if (data.count !== 0) {
                msg = '成功删除' + data.count + "数据";
            }
            top.layer.alert(msg,
                {
                    closeBtn: 0
                },
                function () {
                    reloadFunction();//在js中实现调用reload传入参数
                    top.layer.closeAll();
                });
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            top.layer.alert("删除数据出错！");
        }
    });
}

function reloadMethod(url, data) {
    jQuery.ajax({
        type: "Post",
        url: url,
        data: data,
        success: function (gridData) {
            debugger;
            console.log(gridData);
         /*   jQuery.each(gridData, function (index, value) {
                console.log(index);
                console.log(value);
            })*/
            $.each( gridData, function(i, n){
                n.operate="<a data-toggle=\"tooltip\" data-placement=\"top\" title=\"编辑\" style=\"text-decoration:none\" onclick=\"editFunction('"+
                    n.id+"')\"><div class=\"ui-pg-div\" style=\"display: inline\"><i class=\"ui-icon icon-pencil blue\"></i></div> </a><a data-toggle=\"tooltip\" data-placement=\"top\" title=\"删除\" style=\"text-decoration:none\" onclick=\"openDeleteLayer('"
                    +n.id+"')\"><div class=\"ui-pg-div\" style=\"display: inline\"><i class=\"ui-icon icon-trash red\"></i> </div></a>";
            });
            console.log(gridData);
            //
            var gridSelector = "#grid-table";
            $(gridSelector).jqGrid('clearGridData');
            $(gridSelector).jqGrid('setGridParam', {
                datatype: 'local',
                data: gridData,
                page: 1
            }).trigger("reloadGrid");
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (XMLHttpRequest.status === 401) {
                top.layer.alert('登录超时，请重新登录！',
                    {
                        closeBtn: 0
                    },
                    function () {
                        top.layer.closeAll();
                        window.parent.location = "/login";
                    });
            }
            else {
                top.layer.alert("获取数据出错！");
            }
        }
    });
}

function style_edit_form(form) {
    //enable datepicker on "sdate" field and switches for "stock" field
    form.find('input[name=sdate]').datepicker({format: 'yyyy-mm-dd', autoclose: true})
        .end().find('input[name=stock]')
        .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

    //update buttons classes
    var buttons = form.next().find('.EditButton .fm-button');
    buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
    buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
    buttons.eq(1).prepend('<i class="icon-remove"></i>')

    buttons = form.next().find('.navButton a');
    buttons.find('.ui-icon').remove();
    buttons.eq(0).append('<i class="icon-chevron-left"></i>');
    buttons.eq(1).append('<i class="icon-chevron-right"></i>');
}

function style_delete_form(form) {
    var buttons = form.next().find('.EditButton .fm-button');
    buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
    buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
    buttons.eq(1).prepend('<i class="icon-remove"></i>')
}

function style_search_filters(form) {
    form.find('.delete-rule').val('X');
    form.find('.add-rule').addClass('btn btn-xs btn-primary');
    form.find('.add-group').addClass('btn btn-xs btn-success');
    form.find('.delete-group').addClass('btn btn-xs btn-danger');
}

function style_search_form(form) {
    var dialog = form.closest('.ui-jqdialog');
    var buttons = dialog.find('.EditTable')
    buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
    buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
    buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
}

function beforeDeleteCallback(e) {
    var form = $(e[0]);
    if (form.data('styled')) return false;

    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
    style_delete_form(form);

    form.data('styled', true);
}

function beforeEditCallback(e) {
    var form = $(e[0]);
    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
    style_edit_form(form);
}


//it causes some flicker when reloading or navigating grid
//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
//or go back to default browser checkbox styles for the grid
function styleCheckbox(table) {
    /**
     $(table).find('input:checkbox').addClass('ace')
     .wrap('<label />')
     .after('<span class="lbl align-top" />')


     $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
     .find('input.cbox[type=checkbox]').addClass('ace')
     .wrap('<label />').after('<span class="lbl align-top" />');
     */
}


//unlike navButtons icons, action icons in rows seem to be hard-coded
//you can change them like this in here if you want
function updateActionIcons(table) {
    /**
     var replacement =
     {
         'ui-icon-pencil' : 'icon-pencil blue',
         'ui-icon-trash' : 'icon-trash red',
         'ui-icon-disk' : 'icon-ok green',
         'ui-icon-cancel' : 'icon-remove red'
     };
     $(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
     */
}

//replace icons with FontAwesome icons like above
function updatePagerIcons(table) {
    var replacement =
        {
            'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
            'ui-icon-seek-prev': 'icon-angle-left bigger-140',
            'ui-icon-seek-next': 'icon-angle-right bigger-140',
            'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
    })
}

function enableTooltips(table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
    $(table).find('a').tooltip({container: 'body'});
}

function isShrinkToFit(colModel) {
    var width = 0;
    $.each(colModel, function (idx, obj) {
        if (!obj.hidden) {
            width += obj.width;
        }
    });

    if ($(window).width() - 14 >= width)
        return true;
    else
        return false;
}