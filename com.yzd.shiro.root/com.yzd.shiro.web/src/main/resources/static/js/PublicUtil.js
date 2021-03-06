/**
 * 来自：
 * http://www.htmleaf.com/ziliaoku/qianduanjiaocheng/201505311944.html
 */
/********************** 公共工具类 ***************/
var PublicUtil ={
    isNotEmpty:  function(val){
        return !this.isEmpty(val);
    },
    isEmpty: function(val){
        if ((val==null || typeof(val)=="undefined")|| (typeof(val)=="string"&&val==""&&val!="undefined")){
            return true;
        }else{
            return false;
        }
    },
    isDebug: function(){
        if(this.isNotEmpty(configDebug)&&configDebug=="true"){
            return true;
        }else{
            return false;
        }
    },
    //去除元素内所有内容 strIds："#id1,#id2,#id3"
    emptyHtml: function(strIds){
        try{
            var ids = strIds.trim(",").split(",");
            $(ids).each(function(){
                var obj = $(this.toString());
                if(obj.length>0){
                    $(obj).each(function(){
                        $(this).html("");
                    });
                }else{
                    obj.html("");
                }
            });
        }catch(ex){
            if(PublicUtil.isDebug()){
                throw new Error("js方法：【PublicUtil.emptyHtml(strIds)】，error！");
            }
        }
    },
    //去除元素的值 strIds："#id1,#id2,#id3"
    emptyValue: function(strIds){
        try{
            var ids = strIds.trim(",").split(",");
            $(ids).each(function(){
                var obj = $(this.toString());
                if(obj.length>0){
                    $(obj).each(function(){
                        $(this).val("");
                    });
                }else{
                    obj.val("");
                }
            });
        }catch(ex){
            if(PublicUtil.isDebug()){
                throw new Error("js方法：【PublicUtil.emptyValue(strIds)】，error！");
            }
        }
    },
    //去除Textarea内所有内容 strIds："#id1,#id2,#id3"
    emptyTextarea: function(strIds){
        try{
            var ids = strIds.trim(",").split(",");
            $(ids).each(function(){
                var obj = $(this.toString());
                if(obj.length>0){
                    $(obj).each(function(){
                        $(this).empty();
                        $(this).val("");
                    });
                }else{
                    obj.empty();
                    obj.val("");
                }
            });
        }catch(ex){
            if(PublicUtil.isDebug()){
                throw new Error("js方法：【PublicUtil.emptyTextarea(strIds)】，error！");
            }
        }
    }
}