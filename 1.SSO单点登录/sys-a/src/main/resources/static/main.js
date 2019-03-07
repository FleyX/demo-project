function getToken() {
    return window.localStorage.token || null;
}

function setToken(token) {
    window.localStorage.token = token;
}

function getUserName() {
    var token = getToken();
    if (token == null) {
        return "未登录";
    } else {
        var info = token.split(".")[1];
        return JSON.parse(window.atob(info)).name;
    }
}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}