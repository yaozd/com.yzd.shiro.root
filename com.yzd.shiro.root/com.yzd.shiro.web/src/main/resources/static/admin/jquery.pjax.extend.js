/**
 * 判断当前是否在pjax.html页面下
 */
if (typeof($) == "undefined") {
    document.cookie = '___referrer='+window.location.href+"; path=/";
    window.location.href="/admin/admin.html";
}
//
