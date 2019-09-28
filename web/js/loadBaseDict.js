//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 生成下拉选时,select标签的name属性值
//参数4: 需要回显时,选中哪个option
function loadSelect(typeCode, positionId, selectedName, selectedId) {
    //1 创建select对象,将name属性指定
    var $select = $("<select name=" + selectedName + "></select>");
    //2 添加提示选项
    $select.append($("<option value=''>---请选择---</option>"));
    //3 使用jquery 的ajax 方法,访问后台Action
    $.post(
        "${pageContext.request.contextPath}/BaseDictAction_execute",
        {dict_type_code: typeCode},
        function (data) {
            //4 返回json数组对象,对其遍历
            $.each(data, function (i, jsonlist) {
                // 每次遍历创建一个option对象
                var $option = $("<option value=" + jsonlist['dict_id'] + ">" + jsonlist['dict_item_name'] + "</option>");
                //判断是否需要回显 ,如果需要使其被选中
                if (selectedId == jsonlist['dict_id']) {
                    $($option).attr("selected", "selected")
                }
                //添加到select对象
                $($select).append($option);
            });
        },
        "json"
    );
    //5 将组装好的select对象放入页面指定位置
    $("#" + positionId).append($select);
}