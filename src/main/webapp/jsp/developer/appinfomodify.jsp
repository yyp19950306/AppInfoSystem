<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>修改APP基础信息 <i class="fa fa-user"></i>
                    <small>${devUserSession.devName}</small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form class="form-horizontal form-label-left" action="/updateAppInfo" method="post"
                      enctype="multipart/form-data">
                    <input type="hidden" name="id" id="id" value="${appInfo.id}">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="softwareName" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1"
                                   name="softwarename" value="${appInfo.softwarename}" required="required"
                                   placeholder="请输入软件名称" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="APKName" type="text" class="form-control col-md-7 col-xs-12"
                                   name="apkname" value="${appInfo.apkname}" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="supportROM" class="form-control col-md-7 col-xs-12"
                                   name="supportrom" value="${appInfo.supportrom}" required="required"
                                   data-validate-length-range="20" data-validate-words="1"
                                   placeholder="请输入支持的ROM" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" required="required"
                                   name="interfacelanguage" value="${appInfo.interfacelanguage}"
                                   placeholder="请输入软件支持的界面语言" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="softwareSize" name="softwaresize" value="${appInfo.softwaresize}"
                                   required="required"
                                   data-validate-minmax="10,500" placeholder="请输入软件大小，单位为Mb"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="downloads" name="downloads" value="${appInfo.downloads}"
                                   required="required"
                                   data-validate-minmax="10,500" placeholder="请输入下载次数"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">所属平台 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="hidden" value="${appInfo.flatformid}" id="fid"/>
                            <select name="flatformid" id="flatformId" class="form-control" required="required">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="hidden" value="${appInfo.categorylevel1}" id="cl1"/>
                            <select name="categorylevel1" id="categoryLevel1" class="form-control" required="required">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">二级分类 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="hidden" value="${appInfo.categorylevel2}" id="cl2"/>
                            <select name="categorylevel2" id="categoryLevel2" class="form-control" required="required">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">三级分类 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="hidden" value="${appInfo.categorylevel3}" id="cl3"/>
                            <select name="categorylevel3" id="categoryLevel3" class="form-control" required="required">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="statusName" type="text" class="form-control col-md-7 col-xs-12"
                                   name="statusName" value="${appInfo.statusName}" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appinfo" required="required"
                        placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12">
                  ${appInfo.appinfo}</textarea>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <img src="${appInfo.logopicpath}" height="100" width="100">
                            <input type="hidden" value="${appInfo.logopicpath}" name="oldPicPath">
                            <input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath"
                                   id="a_logoPicPath"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <c:if test="${appInfo.status == 3}">
                                <button id="send" type="submit" name="status" value="1" class="btn btn-success">
                                    保存并再次提交审核
                                </button>
                            </c:if>
                            <button id="send" type="submit" class="btn btn-success">保存</button>
                            <button type="button" class="btn btn-primary" id="back" onclick="javascript:history.back(-1);">返回</button>
                            <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp" %>
<script type="text/javascript" language="JavaScript">
    $(function () {
        $.post("getDataDictionaryByTypeName", {"typename": "所属平台"}, function (data) {
            for (var i = 0; i < data.length; i++) {
                var option = "<option value='" + data[i].valueid + "'>" + data[i].valuename + "</option>";
                $("#flatformId").append(option);
            }
            $("#flatformId").val(${appInfo.flatformid});
        }, "json");


        $.post("getAppCategoryByParentId", null, function (data) {
            for (var i = 0; i < data.length; i++) {
                var option = "<option value='" + data[i].id + "'>" + data[i].categoryname + "</option>";
                $("#categoryLevel1").append(option);
            }
            $("#categoryLevel1").val(${appInfo.categorylevel1});
            $.post("getAppCategoryByParentId", {"parentid": $("#categoryLevel1").val()}, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var option = "<option value='" + data[i].id + "'>" + data[i].categoryname + "</option>";
                    $("#categoryLevel2").append(option);
                }
                $("#categoryLevel2").val(${appInfo.categorylevel2});
                $.post("getAppCategoryByParentId", {"parentid": $("#categoryLevel2").val()}, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var option = "<option value='" + data[i].id + "'>" + data[i].categoryname + "</option>";
                        $("#categoryLevel3").append(option);
                    }
                    $("#categoryLevel3").val(${appInfo.categorylevel3});
                }, "json");
            }, "json");
        }, "json");

        function load(level) {
            if (level == 1) {
                $("#categoryLevel1>option:gt(0)").remove();
                $.post("getAppCategoryByParentId", null, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var option = "<option value='" + data[i].id + "'>" + data[i].categoryname + "</option>";
                        $("#categoryLevel1").append(option);
                    }
                }, "json");
            } else if (level == 2) {
                $("#categoryLevel2>option:gt(0)").remove();
                $("#categoryLevel3>option:gt(0)").remove();
                $.post("getAppCategoryByParentId", {"parentid": $("#categoryLevel1").val()}, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var option = "<option value='" + data[i].id + "'>" + data[i].categoryname + "</option>";
                        $("#categoryLevel2").append(option);
                    }
                }, "json");
            } else if (level == 3) {
                $("#categoryLevel3>option:gt(0)").remove();
                $.post("getAppCategoryByParentId", {"parentid": $("#categoryLevel2").val()}, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var option = "<option value='" + data[i].id + "'>" + data[i].categoryname + "</option>";
                        $("#categoryLevel3").append(option);
                    }
                }, "json");
            }
        }

        $("#categoryLevel1").change(function () {
            if ($("#categoryLevel1").val() != "") {
                load(2);
            } else {
                $("#categoryLevel2>option:gt(0)").remove();
                $("#categoryLevel3>option:gt(0)").remove();
            }
        });

        $("#categoryLevel2").change(function () {
            if ($("#categoryLevel2").val() != "") {
                load(3);
            } else {
                $("#categoryLevel3>option:gt(0)").remove();
            }
        });

    });
</script>