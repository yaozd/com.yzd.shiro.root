/**
 * 判断当前是否在pjax.html页面下
 */
if (typeof($) == "undefined") {
    alert(1);
    document.cookie = '___referrer='+window.location.href+"; path=/";
    window.location.href="/html/pjax/pjax.html";
} else{
    alert(2)
};
//
