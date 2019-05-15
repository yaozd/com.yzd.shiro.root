var AUTH_TOKEN=(function(){
    return localStorage.getItem("token");
})();
var instance = axios.create({
    baseURL: 'http://localhost:9090'
});
//配置请求头为json格式
instance.defaults.headers['Content-Type'] = 'application/json';
//
instance.defaults.headers.common["Authorization"] = AUTH_TOKEN;
instance.interceptors.request.use(function(config){
    var url = config.url;
    if(url.indexOf("/api/account/login")>-1){
        //localStorage.setItem('token',"");
        config.headers.Authorization = "";
        return config;
    }
    var token=localStorage.getItem("token");
    if(token==null){
        token="";
    }
    config.headers.Authorization =token;
    return config;
},function(err){
    alert(err);
    return Promise.reject(err);
});
instance.interceptors.response.use(function(res){

    //authorization必须是小写
    if(res.headers.authorization&&res.headers.authorization!=""){
        localStorage.setItem('token',res.headers.authorization);
    }
    //return res.data; 直接返回响应结果{code:"200"},默认status为200;
    //return res; 返回完整的http信息
    //return res.data;
    return res;
},function(err){
    //使用场景：如断网情况
    if (typeof(err.response) == "undefined"){
        alert("当前请求没有响应，错误信息："+err);
        return Promise.reject(err);
    }
    //console.log(err);
    if (err && err.response){
        hanlder4ErrorStatus4Axios(err,err.response.status);
    }
    //return Promise.reject(err) :结果由catch捕获
    //return err ;结果由then捕获
    return Promise.reject(err);
    //return err;
});
function hanlder4ErrorStatus4Axios(err,status) {
    switch (status) {
        case 400:
            err.message = '请求错误';
            break;
        case 401:
            err.message = '未授权，请登录';
            break;
        case 403:
            err.message = '拒绝访问';
            break;
        case 404:
            var url=err.response.config.url;
            err.message = '请求地址没有找到,PATH='+url;
            break;
        case 408:
            err.message = '请求超时';
            break;
        case 500:
            err.message = '服务器内部错误';
            break;
        case 501:
            err.message = '服务未实现';
            break;
        case 502:
            err.message = '网关错误';
            break;
        case 503:
            err.message = '服务不可用';
            break;
        case 504:
            err.message = '网关超时';
            break;
        case 505:
            err.message = 'HTTP版本不受支持';
            break;
        default:
    }
    alert("message="+err.message+";status="+status);
}
