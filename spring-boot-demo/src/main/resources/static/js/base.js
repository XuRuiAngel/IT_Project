//控制垂直导航栏子功能的隐藏和显示
$(document).ready(function () {
    $("#click_1").click(function () {
        $("#fun1,#fun2,#fun3,#fun4,#fun5,#fun6").toggle();
    });
    $("#click_4").click(function () {
        $("#fun7,#fun8").toggle();
    });
});