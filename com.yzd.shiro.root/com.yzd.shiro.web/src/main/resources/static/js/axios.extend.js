var instance = axios.create({
    baseURL: 'http://localhost:9091'
});
instance.interceptors.response.use(function(res){
    if(res.headers.token){
        localStorage.setItem('token',res.headers.token);
    }
    return res;
},function(err){
    console.log(err);
    if (err && err.response){
        hanlder4ErrorStatus4Axios(err,err.response.status);
    }
    return err;
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
            err.message = '请求地址出错404';
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
